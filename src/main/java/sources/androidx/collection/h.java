package androidx.collection;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h {
    public static long a(float f5, float f6) {
        return b((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static long b(long j5) {
        return j5;
    }
}
