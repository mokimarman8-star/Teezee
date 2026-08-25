package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5079b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f5080c = c0.a(0);

    /* renamed from: a, reason: collision with root package name */
    private final long f5081a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return b0.f5080c;
        }
    }

    private /* synthetic */ b0(long j5) {
        this.f5081a = j5;
    }

    public static final /* synthetic */ b0 b(long j5) {
        return new b0(j5);
    }

    public static long c(long j5) {
        return j5;
    }

    public static boolean d(long j5, Object obj) {
        return (obj instanceof b0) && j5 == ((b0) obj).n();
    }

    public static final boolean e(long j5, long j6) {
        return j5 == j6;
    }

    public static final boolean f(long j5) {
        return k(j5) == g(j5);
    }

    public static final int g(long j5) {
        return (int) (j5 & 4294967295L);
    }

    public static final int h(long j5) {
        return i(j5) - j(j5);
    }

    public static final int i(long j5) {
        return k(j5) > g(j5) ? k(j5) : g(j5);
    }

    public static final int j(long j5) {
        return k(j5) > g(j5) ? g(j5) : k(j5);
    }

    public static final int k(long j5) {
        return (int) (j5 >> 32);
    }

    public static int l(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String m(long j5) {
        return "TextRange(" + k(j5) + ", " + g(j5) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f5081a, obj);
    }

    public int hashCode() {
        return l(this.f5081a);
    }

    public final /* synthetic */ long n() {
        return this.f5081a;
    }

    public String toString() {
        return m(this.f5081a);
    }
}
