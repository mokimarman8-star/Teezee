package kotlinx.coroutines.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class i {
    public static final void a(int i) {
        if (i >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i).toString());
    }

    public static final kotlinx.coroutines.i0 b(kotlinx.coroutines.i0 i0Var, String str) {
        return str != null ? new r(i0Var, str) : i0Var;
    }
}
