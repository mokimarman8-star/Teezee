package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16681b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16682c = c(0);

    /* renamed from: a, reason: collision with root package name */
    private final long f16683a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return z.f16682c;
        }
    }

    private /* synthetic */ z(long j5) {
        this.f16683a = j5;
    }

    public static final /* synthetic */ z b(long j5) {
        return new z(j5);
    }

    public static long c(long j5) {
        return j5;
    }

    public static final long d(long j5, float f5, float f6) {
        return c((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
    }

    public static /* synthetic */ long e(long j5, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i5 & 2) != 0) {
            f6 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return d(j5, f5, f6);
    }

    public static boolean f(long j5, Object obj) {
        return (obj instanceof z) && j5 == ((z) obj).n();
    }

    public static final boolean g(long j5, long j6) {
        return j5 == j6;
    }

    public static final float h(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final float i(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    public static int j(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static final long k(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return c((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static final long l(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) + Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) + Float.intBitsToFloat((int) (j6 & 4294967295L));
        return c((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static String m(long j5) {
        return '(' + h(j5) + ", " + i(j5) + ") px/sec";
    }

    public boolean equals(Object obj) {
        return f(this.f16683a, obj);
    }

    public int hashCode() {
        return j(this.f16683a);
    }

    public final /* synthetic */ long n() {
        return this.f16683a;
    }

    public String toString() {
        return m(this.f16683a);
    }
}
