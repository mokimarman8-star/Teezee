package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Array;
import org.mvel2.b;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class InvokableAccessor extends BaseAccessor {
    protected boolean coercionNeeded = false;
    protected int length;
    protected Class[] parameterTypes;
    protected ExecutableStatement[] parms;

    protected Object[] executeAndCoerce(Class[] clsArr, Object obj, VariableResolverFactory variableResolverFactory, boolean z) {
        int i;
        Object obj2;
        Object[] objArr = new Object[this.length];
        int i2 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i || (z && i2 >= i - 1)) {
                break;
            }
            objArr[i2] = b.b(this.parms[i2].getValue(obj, variableResolverFactory), clsArr[i2]);
            i2++;
        }
        if (z) {
            Class<?> componentType = clsArr[i - 1].getComponentType();
            ExecutableStatement[] executableStatementArr = this.parms;
            if (executableStatementArr == null) {
                obj2 = Array.newInstance(componentType, 0);
            } else {
                Object newInstance = Array.newInstance(componentType, (executableStatementArr.length - this.length) + 1);
                int i3 = this.length - 1;
                while (true) {
                    ExecutableStatement[] executableStatementArr2 = this.parms;
                    if (i3 >= executableStatementArr2.length) {
                        break;
                    }
                    Array.set(newInstance, (i3 - this.length) + 1, b.b(executableStatementArr2[i3].getValue(obj, variableResolverFactory), componentType));
                    i3++;
                }
                obj2 = newInstance;
            }
            objArr[this.length - 1] = obj2;
        }
        return objArr;
    }

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public abstract /* synthetic */ Class getKnownEgressType();

    public Class[] getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public abstract /* synthetic */ Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory);

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public abstract /* synthetic */ Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3);
}
