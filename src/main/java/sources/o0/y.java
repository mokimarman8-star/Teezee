package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16676b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16677c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f16678d = e(4294967296L);

    /* renamed from: e, reason: collision with root package name */
    private static final long f16679e = e(8589934592L);

    /* renamed from: a, reason: collision with root package name */
    private final long f16680a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return y.f16679e;
        }

        public final long b() {
            return y.f16678d;
        }

        public final long c() {
            return y.f16677c;
        }
    }

    private /* synthetic */ y(long j5) {
        this.f16680a = j5;
    }

    public static final /* synthetic */ y d(long j5) {
        return new y(j5);
    }

    public static long e(long j5) {
        return j5;
    }

    public static boolean f(long j5, Object obj) {
        return (obj instanceof y) && j5 == ((y) obj).j();
    }

    public static final boolean g(long j5, long j6) {
        return j5 == j6;
    }

    public static int h(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String i(long j5) {
        return g(j5, f16677c) ? "Unspecified" : g(j5, f16678d) ? "Sp" : g(j5, f16679e) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.f16680a, obj);
    }

    public int hashCode() {
        return h(this.f16680a);
    }

    public final /* synthetic */ long j() {
        return this.f16680a;
    }

    public String toString() {
        return i(this.f16680a);
    }
}
