package androidx.compose.ui.layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m0 {
    public static final long a(float f5, float f6) {
        return l0.a((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static final long b(long j5, long j6) {
        return y.n.a(y.m.i(j5) * l0.b(j6), y.m.g(j5) * l0.c(j6));
    }
}
