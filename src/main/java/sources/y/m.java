package y;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18548b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f18549c = d(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f18550d = d(9205357640488583168L);

    /* renamed from: a, reason: collision with root package name */
    private final long f18551a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return m.f18550d;
        }

        public final long b() {
            return m.f18549c;
        }
    }

    private /* synthetic */ m(long j5) {
        this.f18551a = j5;
    }

    public static final /* synthetic */ m c(long j5) {
        return new m(j5);
    }

    public static long d(long j5) {
        return j5;
    }

    public static boolean e(long j5, Object obj) {
        return (obj instanceof m) && j5 == ((m) obj).m();
    }

    public static final boolean f(long j5, long j6) {
        return j5 == j6;
    }

    public static final float g(long j5) {
        if (j5 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    public static final float h(long j5) {
        if (j5 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Math.min(Float.intBitsToFloat((int) ((j5 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j5 & 2147483647L)));
    }

    public static final float i(long j5) {
        if (j5 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static int j(long j5) {
        return s.a(j5);
    }

    public static final boolean k(long j5) {
        if (j5 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        long j6 = j5 & (~((((-9223372034707292160L) & j5) >>> 31) * (-1)));
        return ((j6 & 4294967295L) & (j6 >>> 32)) == 0;
    }

    public static String l(long j5) {
        if (j5 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + c.a(i(j5), 1) + ", " + c.a(g(j5), 1) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f18551a, obj);
    }

    public int hashCode() {
        return j(this.f18551a);
    }

    public final /* synthetic */ long m() {
        return this.f18551a;
    }

    public String toString() {
        return l(this.f18551a);
    }
}
