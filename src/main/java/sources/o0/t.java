package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16668b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16669c = c(0);

    /* renamed from: a, reason: collision with root package name */
    private final long f16670a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return t.f16669c;
        }
    }

    private /* synthetic */ t(long j5) {
        this.f16670a = j5;
    }

    public static final /* synthetic */ t b(long j5) {
        return new t(j5);
    }

    public static long c(long j5) {
        return j5;
    }

    public static boolean d(long j5, Object obj) {
        return (obj instanceof t) && j5 == ((t) obj).j();
    }

    public static final boolean e(long j5, long j6) {
        return j5 == j6;
    }

    public static final int f(long j5) {
        return (int) (j5 & 4294967295L);
    }

    public static final int g(long j5) {
        return (int) (j5 >> 32);
    }

    public static int h(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String i(long j5) {
        return g(j5) + " x " + f(j5);
    }

    public boolean equals(Object obj) {
        return d(this.f16670a, obj);
    }

    public int hashCode() {
        return h(this.f16670a);
    }

    public final /* synthetic */ long j() {
        return this.f16670a;
    }

    public String toString() {
        return i(this.f16670a);
    }
}
