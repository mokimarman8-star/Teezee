package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class q0 {
    private static final boolean a = kotlinx.coroutines.internal.a0.f("kotlinx.coroutines.main.delay", false);
    private static final t0 b = b();

    public static final t0 a() {
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final t0 b() {
        if (!a) {
            return DefaultExecutor.INSTANCE;
        }
        a2 c = y0.c();
        return (kotlinx.coroutines.internal.p.c(c) || !(c instanceof t0)) ? DefaultExecutor.INSTANCE : (t0) c;
    }
}
