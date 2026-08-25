package ux;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements iy.a {
    private static final Object c = new Object();
    private volatile iy.a a;
    private volatile Object b = c;

    private a(iy.a aVar) {
        this.a = aVar;
    }

    public static iy.a a(iy.a aVar) {
        b.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // iy.a
    public Object get() {
        Object obj = this.b;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.b;
                    if (obj == obj2) {
                        obj = this.a.get();
                        this.b = b(this.b, obj);
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
