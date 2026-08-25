package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16659b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16660c = c(0);

    /* renamed from: a, reason: collision with root package name */
    private final long f16661a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return p.f16660c;
        }
    }

    private /* synthetic */ p(long j5) {
        this.f16661a = j5;
    }

    public static final /* synthetic */ p b(long j5) {
        return new p(j5);
    }

    public static long c(long j5) {
        return j5;
    }

    public static final long d(long j5, int i5, int i6) {
        return c((i5 << 32) | (i6 & 4294967295L));
    }

    public static /* synthetic */ long e(long j5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = (int) (j5 >> 32);
        }
        if ((i7 & 2) != 0) {
            i6 = (int) (4294967295L & j5);
        }
        return d(j5, i5, i6);
    }

    public static boolean f(long j5, Object obj) {
        return (obj instanceof p) && j5 == ((p) obj).n();
    }

    public static final boolean g(long j5, long j6) {
        return j5 == j6;
    }

    public static final int h(long j5) {
        return (int) (j5 >> 32);
    }

    public static final int i(long j5) {
        return (int) (j5 & 4294967295L);
    }

    public static int j(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static final long k(long j5, long j6) {
        return c(((((int) (j5 >> 32)) - ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) - ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    public static final long l(long j5, long j6) {
        return c(((((int) (j5 >> 32)) + ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) + ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    public static String m(long j5) {
        return '(' + h(j5) + ", " + i(j5) + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f16661a, obj);
    }

    public int hashCode() {
        return j(this.f16661a);
    }

    public final /* synthetic */ long n() {
        return this.f16661a;
    }

    public String toString() {
        return m(this.f16661a);
    }
}
