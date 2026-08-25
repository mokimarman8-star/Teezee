package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Method;
import org.mvel2.CompileException;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import yz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class GetterAccessorNH implements AccessorNode {
    public static final Object[] EMPTY = new Object[0];
    private final Method method;
    private AccessorNode nextNode;
    private c nullHandler;

    public GetterAccessorNH(Method method, c cVar) {
        this.method = method;
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            return nullHandle(method.getName(), method.invoke(obj, EMPTY), obj, obj2, variableResolverFactory);
        } catch (Exception e) {
            throw new RuntimeException("unable to invoke method", e);
        }
    }

    private Object nullHandle(String str, Object obj, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        if (obj != null) {
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(obj, obj3, variableResolverFactory) : obj;
        }
        this.nextNode.getClass();
        throw null;
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

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Method L;
        try {
            return nullHandle(this.method.getName(), this.method.invoke(obj, EMPTY), obj, obj2, variableResolverFactory);
        } catch (IllegalArgumentException unused) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (L = m.L(EMPTY, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(L, obj, obj2, variableResolverFactory);
            }
            return nullHandle(this.method.getName(), d.v(this.method.getName() + "()", obj), obj, obj2, variableResolverFactory);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("cannot invoke getter: ");
            sb.append(this.method.getName());
            sb.append(" [declr.class: ");
            sb.append(this.method.getDeclaringClass().getName());
            sb.append("; act.class: ");
            sb.append(obj != null ? obj.getClass().getName() : "null");
            sb.append("]");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        try {
            try {
                Object invoke = this.method.invoke(obj, EMPTY);
                if (invoke != null) {
                    return this.nextNode.setValue(invoke, obj2, variableResolverFactory, obj3);
                }
                this.method.getName();
                throw null;
            } catch (Exception e) {
                throw new RuntimeException("error " + this.method.getName() + ": " + e.getClass().getName() + ":" + e.getMessage(), e);
            }
        } catch (IllegalArgumentException unused) {
            Object v = d.v(this.method.getName() + "()", obj);
            if (v != null) {
                return this.nextNode.setValue(v, obj2, variableResolverFactory, obj3);
            }
            this.method.getName();
            throw null;
        } catch (CompileException e3) {
            throw e3;
        }
    }

    public String toString() {
        return this.method.getDeclaringClass().getName() + "." + this.method.getName();
    }
}
