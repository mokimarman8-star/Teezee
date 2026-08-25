package kotlinx.serialization.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class p1 {
    public static /* synthetic */ void c(p1 p1Var, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i2 & 1) != 0) {
            i = p1Var.d() + 1;
        }
        p1Var.b(i);
    }

    public abstract Object a();

    public abstract void b(int i);

    public abstract int d();
}
