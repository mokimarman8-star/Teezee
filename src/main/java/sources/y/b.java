package y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {
    public static final long a(float f5, float f6) {
        return a.b((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static /* synthetic */ long b(float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = f5;
        }
        return a(f5, f6);
    }
}
