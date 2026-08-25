package c00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c implements org.mvel2.compiler.a {
    private org.mvel2.compiler.a[] a;

    public c(org.mvel2.compiler.a[] aVarArr) {
        this.a = aVarArr;
    }

    public org.mvel2.compiler.a[] b() {
        return this.a;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return List.class;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Object[] objArr = new Object[b().length];
        for (int i = 0; i < b().length; i++) {
            objArr[i] = b()[i].getValue(obj, obj2, variableResolverFactory);
        }
        return new ArrayList(Arrays.asList(objArr));
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
