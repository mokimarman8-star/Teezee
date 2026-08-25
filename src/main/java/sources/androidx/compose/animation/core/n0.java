package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n0 {

    /* renamed from: a, reason: collision with root package name */
    private static final float f1474a = Float.MAX_VALUE;

    public static final long a(float f5, float f6) {
        return i0.a((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static final float b() {
        return f1474a;
    }
}
