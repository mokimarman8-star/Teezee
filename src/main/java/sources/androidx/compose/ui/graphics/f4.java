package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f4 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3436b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3437c = g(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3438d = g(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f3439e = g(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f3440f = g(3);

    /* renamed from: g, reason: collision with root package name */
    private static final int f3441g = g(4);

    /* renamed from: a, reason: collision with root package name */
    private final int f3442a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return f4.f3438d;
        }

        public final int b() {
            return f4.f3437c;
        }

        public final int c() {
            return f4.f3440f;
        }

        public final int d() {
            return f4.f3441g;
        }

        public final int e() {
            return f4.f3439e;
        }
    }

    private /* synthetic */ f4(int i5) {
        this.f3442a = i5;
    }

    public static final /* synthetic */ f4 f(int i5) {
        return new f4(i5);
    }

    public static int g(int i5) {
        return i5;
    }

    public static boolean h(int i5, Object obj) {
        return (obj instanceof f4) && i5 == ((f4) obj).l();
    }

    public static final boolean i(int i5, int i6) {
        return i5 == i6;
    }

    public static int j(int i5) {
        return i5;
    }

    public static String k(int i5) {
        return i(i5, f3437c) ? "Argb8888" : i(i5, f3438d) ? "Alpha8" : i(i5, f3439e) ? "Rgb565" : i(i5, f3440f) ? "F16" : i(i5, f3441g) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return h(this.f3442a, obj);
    }

    public int hashCode() {
        return j(this.f3442a);
    }

    public final /* synthetic */ int l() {
        return this.f3442a;
    }

    public String toString() {
        return k(this.f3442a);
    }
}
