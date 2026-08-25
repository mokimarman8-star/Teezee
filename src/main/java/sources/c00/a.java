package c00;

import java.lang.reflect.Array;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements org.mvel2.compiler.a {
    public org.mvel2.compiler.a[] a;
    private Class b;

    public a(org.mvel2.compiler.a[] aVarArr, Class cls) {
        this.a = aVarArr;
        this.b = cls;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.b;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        int i = 0;
        if (Object.class.equals(this.b)) {
            int length = this.a.length;
            Object[] objArr = new Object[length];
            while (i < length) {
                objArr[i] = this.a[i].getValue(obj, obj2, variableResolverFactory);
                i++;
            }
            return objArr;
        }
        Object newInstance = Array.newInstance((Class<?>) this.b, this.a.length);
        while (true) {
            org.mvel2.compiler.a[] aVarArr = this.a;
            if (i >= aVarArr.length) {
                return newInstance;
            }
            Array.set(newInstance, i, aVarArr[i].getValue(obj, obj2, variableResolverFactory));
            i++;
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
