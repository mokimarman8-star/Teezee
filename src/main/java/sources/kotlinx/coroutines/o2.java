package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o2 {
    public static final o2 a = new o2();
    private static final ThreadLocal b = kotlinx.coroutines.internal.j0.a(new kotlinx.coroutines.internal.z("ThreadLocalEventLoop"));

    private o2() {
    }

    public final e1 a() {
        return (e1) b.get();
    }

    public final e1 b() {
        ThreadLocal threadLocal = b;
        e1 e1Var = (e1) threadLocal.get();
        if (e1Var != null) {
            return e1Var;
        }
        e1 a2 = g1.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        b.set(null);
    }

    public final void d(e1 e1Var) {
        b.set(e1Var);
    }
}
