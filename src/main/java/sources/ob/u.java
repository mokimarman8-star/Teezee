package ob;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class u implements kc.b {
    private static final Object c = new Object();
    private volatile Object a = c;
    private volatile kc.b b;

    public u(kc.b bVar) {
        this.b = bVar;
    }

    @Override // kc.b
    public Object get() {
        Object obj = this.a;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.a;
                    if (obj == obj2) {
                        obj = this.b.get();
                        this.a = obj;
                        this.b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
