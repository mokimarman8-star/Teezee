package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Field;
import org.mvel2.b;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.integration.VariableResolverFactory;
import yz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class FieldAccessorNH implements AccessorNode {
    private boolean coercionRequired = false;
    private Field field;
    private AccessorNode nextNode;
    private c nullHandler;

    public FieldAccessorNH(Field field, c cVar) {
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.field.getClass();
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode getNextNode() {
        return this.nextNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            Object obj3 = this.field.get(obj);
            if (obj3 != null) {
                AccessorNode accessorNode = this.nextNode;
                return accessorNode != null ? accessorNode.getValue(obj3, obj2, variableResolverFactory) : obj3;
            }
            this.field.getName();
            throw null;
        } catch (Exception e) {
            throw new RuntimeException("unable to access field", e);
        }
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        boolean z = this.coercionRequired;
        try {
            AccessorNode accessorNode = this.nextNode;
            if (accessorNode != null) {
                return accessorNode.setValue(obj, obj2, variableResolverFactory, obj3);
            }
            if (!z) {
                this.field.set(obj, obj3);
                return obj3;
            }
            Field field = this.field;
            Object b = b.b(obj, field.getClass());
            field.set(obj, b);
            return b;
        } catch (IllegalArgumentException e) {
            if (z) {
                throw new RuntimeException("unable to bind property", e);
            }
            this.coercionRequired = true;
            return setValue(obj, obj2, variableResolverFactory, obj3);
        } catch (Exception e3) {
            throw new RuntimeException("unable to access field", e3);
        }
    }
}
