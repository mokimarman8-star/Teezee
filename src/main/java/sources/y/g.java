package y;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18527b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f18528c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f18529d = e(9187343241974906880L);

    /* renamed from: e, reason: collision with root package name */
    private static final long f18530e = e(9205357640488583168L);

    /* renamed from: a, reason: collision with root package name */
    private final long f18531a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return g.f18529d;
        }

        public final long b() {
            return g.f18530e;
        }

        public final long c() {
            return g.f18528c;
        }
    }

    private /* synthetic */ g(long j5) {
        this.f18531a = j5;
    }

    public static final /* synthetic */ g d(long j5) {
        return new g(j5);
    }

    public static long e(long j5) {
        return j5;
    }

    public static final long f(long j5, float f5, float f6) {
        return e((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
    }

    public static /* synthetic */ long g(long j5, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i5 & 2) != 0) {
            f6 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return f(j5, f5, f6);
    }

    public static final long h(long j5, float f5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) / f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) / f5;
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static boolean i(long j5, Object obj) {
        return (obj instanceof g) && j5 == ((g) obj).v();
    }

    public static final boolean j(long j5, long j6) {
        return j5 == j6;
    }

    public static final float k(long j5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        return (float) Math.sqrt((intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2));
    }

    public static final float l(long j5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        return (intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2);
    }

    public static final float m(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final float n(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    public static int o(long j5) {
        return s.a(j5);
    }

    public static final boolean p(long j5) {
        long j6 = j5 & 9223372034707292159L;
        return (((~j6) & (j6 - 9187343246269874177L)) & (-9223372034707292160L)) == -9223372034707292160L;
    }

    public static final long q(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static final long r(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) + Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) + Float.intBitsToFloat((int) (j6 & 4294967295L));
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static final long s(long j5, float f5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) * f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) * f5;
        return e((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    public static String t(long j5) {
        if (!h.c(j5)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + c.a(m(j5), 1) + ", " + c.a(n(j5), 1) + ')';
    }

    public static final long u(long j5) {
        return e(j5 ^ (-9223372034707292160L));
    }

    public boolean equals(Object obj) {
        return i(this.f18531a, obj);
    }

    public int hashCode() {
        return o(this.f18531a);
    }

    public String toString() {
        return t(this.f18531a);
    }

    public final /* synthetic */ long v() {
        return this.f18531a;
    }
}
