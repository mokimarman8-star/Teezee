package c00;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d implements org.mvel2.compiler.a {
    private org.mvel2.compiler.a[] a;
    private org.mvel2.compiler.a[] b;
    private int c;

    public d(org.mvel2.compiler.a[] aVarArr, org.mvel2.compiler.a[] aVarArr2) {
        this.a = aVarArr;
        this.c = aVarArr.length;
        this.b = aVarArr2;
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return Map.class;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        HashMap hashMap = new HashMap(this.c * 2);
        int i = this.c;
        while (true) {
            i--;
            if (i == -1) {
                return hashMap;
            }
            hashMap.put(this.a[i].getValue(obj, obj2, variableResolverFactory), this.b[i].getValue(obj, obj2, variableResolverFactory));
        }
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
