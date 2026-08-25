package wz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class h implements org.mvel2.a {
    private final org.mvel2.a[] a;

    public h(org.mvel2.a... aVarArr) {
        this.a = aVarArr;
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        for (org.mvel2.a aVar : this.a) {
            if (aVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        for (org.mvel2.a aVar : this.a) {
            if (aVar.a(obj.getClass())) {
                return aVar.b(obj);
            }
        }
        return null;
    }
}
