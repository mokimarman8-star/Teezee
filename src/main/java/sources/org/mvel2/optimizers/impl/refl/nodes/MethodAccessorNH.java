package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Method;
import org.mvel2.b;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import yz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class MethodAccessorNH implements AccessorNode {
    private boolean coercionNeeded = false;
    private int length;
    private Method method;
    private AccessorNode nextNode;
    private c nullHandler;
    private Class[] parameterTypes;
    private ExecutableStatement[] parms;

    public MethodAccessorNH() {
    }

    public MethodAccessorNH(Method method, ExecutableStatement[] executableStatementArr, c cVar) {
        this.method = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.parameterTypes = parameterTypes;
        this.length = parameterTypes.length;
        this.parms = executableStatementArr;
    }

    private Object[] executeAll(Object obj, VariableResolverFactory variableResolverFactory) {
        int i = this.length;
        if (i == 0) {
            return GetterAccessor.EMPTY;
        }
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < this.length; i2++) {
            objArr[i2] = this.parms[i2].getValue(obj, variableResolverFactory);
        }
        return objArr;
    }

    private Object[] executeAndCoerce(Class[] clsArr, Object obj, VariableResolverFactory variableResolverFactory) {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = b.b(this.parms[i].getValue(obj, variableResolverFactory), clsArr[i]);
        }
        return objArr;
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            Object invoke = method.invoke(obj, executeAll(obj2, variableResolverFactory));
            if (invoke != null) {
                AccessorNode accessorNode = this.nextNode;
                return accessorNode != null ? accessorNode.getValue(invoke, obj2, variableResolverFactory) : invoke;
            }
            method.getName();
            throw null;
        } catch (Exception e) {
            throw new RuntimeException("unable to invoke method", e);
        }
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.method.getReturnType();
    }

    public Method getMethod() {
        return this.method;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode getNextNode() {
        return this.nextNode;
    }

    public ExecutableStatement[] getParms() {
        return this.parms;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Method J;
        if (this.coercionNeeded) {
            try {
                AccessorNode accessorNode = this.nextNode;
                return accessorNode != null ? accessorNode.getValue(this.method.invoke(obj, executeAndCoerce(this.parameterTypes, obj2, variableResolverFactory)), obj2, variableResolverFactory) : this.method.invoke(obj, executeAndCoerce(this.parameterTypes, obj2, variableResolverFactory));
            } catch (Exception e) {
                throw new RuntimeException("cannot invoke method", e);
            }
        }
        try {
            try {
                Object invoke = this.method.invoke(obj, executeAll(obj2, variableResolverFactory));
                if (invoke != null) {
                    AccessorNode accessorNode2 = this.nextNode;
                    return accessorNode2 != null ? accessorNode2.getValue(invoke, obj2, variableResolverFactory) : invoke;
                }
                this.method.getName();
                throw null;
            } catch (Exception e3) {
                throw new RuntimeException("cannot invoke method", e3);
            }
        } catch (IllegalArgumentException unused) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (J = m.J(this.parameterTypes, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(J, obj, obj2, variableResolverFactory);
            }
            this.coercionNeeded = true;
            return getValue(obj, obj2, variableResolverFactory);
        }
    }

    public void setMethod(Method method) {
        this.method = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.parameterTypes = parameterTypes;
        this.length = parameterTypes.length;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    public void setParms(ExecutableStatement[] executableStatementArr) {
        this.parms = executableStatementArr;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return this.nextNode.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
