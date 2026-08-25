package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Method;
import org.mvel2.CompileException;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import org.mvel2.util.p;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class GetterAccessor implements AccessorNode {
    public static final Object[] EMPTY = new Object[0];
    private final Method method;
    private AccessorNode nextNode;

    public GetterAccessor(Method method) {
        this.method = method;
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(method.invoke(obj, EMPTY), obj2, variableResolverFactory) : method.invoke(obj, EMPTY);
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

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Method L;
        try {
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(this.method.invoke(obj, EMPTY), obj2, variableResolverFactory) : this.method.invoke(obj, EMPTY);
        } catch (IllegalArgumentException unused) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (L = m.L(EMPTY, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(L, obj, obj2, variableResolverFactory);
            }
            AccessorNode accessorNode2 = this.nextNode;
            return accessorNode2 != null ? accessorNode2.getValue(d.v(p.d(this.method.getName()), obj), obj2, variableResolverFactory) : d.v(p.d(this.method.getName()), obj);
        } catch (NullPointerException e) {
            if (obj != null) {
                throw new RuntimeException("cannot invoke getter: " + this.method.getName() + " (see trace)", e);
            }
            throw new RuntimeException("unable to invoke method: " + this.method.getDeclaringClass().getName() + "." + this.method.getName() + ": target of method is null", e);
        } catch (Exception e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("cannot invoke getter: ");
            sb.append(this.method.getName());
            sb.append(" [declr.class: ");
            sb.append(this.method.getDeclaringClass().getName());
            sb.append("; act.class: ");
            sb.append(obj != null ? obj.getClass().getName() : "null");
            sb.append("] (see trace)");
            throw new RuntimeException(sb.toString(), e3);
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
            AccessorNode accessorNode = this.nextNode;
            if (accessorNode != null) {
                return accessorNode.setValue(this.method.invoke(obj, EMPTY), obj2, variableResolverFactory, obj3);
            }
            throw new RuntimeException("bad payload");
        } catch (IllegalArgumentException unused) {
            AccessorNode accessorNode2 = this.nextNode;
            return accessorNode2 != null ? accessorNode2.setValue(d.v(p.d(this.method.getName()), obj), obj2, variableResolverFactory, obj3) : d.v(p.d(this.method.getName()), obj);
        } catch (CompileException e) {
            throw e;
        } catch (Exception e3) {
            throw new RuntimeException("error " + this.method.getName() + ": " + e3.getClass().getName() + ":" + e3.getMessage(), e3);
        }
    }

    public String toString() {
        return this.method.getDeclaringClass().getName() + "." + this.method.getName();
    }
}
