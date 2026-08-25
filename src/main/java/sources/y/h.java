package y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h {
    public static final long a(float f5, float f6) {
        return g.e((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static final boolean b(long j5) {
        long j6 = (j5 & 9187343241974906880L) ^ 9187343241974906880L;
        return (((~j6) & (j6 - 4294967297L)) & (-9223372034707292160L)) == 0;
    }

    public static final boolean c(long j5) {
        return (j5 & 9223372034707292159L) != 9205357640488583168L;
    }

    public static final boolean d(long j5) {
        return (j5 & 9223372034707292159L) == 9205357640488583168L;
    }

    public static final long e(long j5, long j6, float f5) {
        float b5 = q0.b.b(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j6 >> 32)), f5);
        float b6 = q0.b.b(Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 & 4294967295L)), f5);
        return g.e((Float.floatToRawIntBits(b5) << 32) | (Float.floatToRawIntBits(b6) & 4294967295L));
    }
}
