package c0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0124a f14191b = new C0124a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f14192c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f14193d = d(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f14194a;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    public static final class C0124a {
        private C0124a() {
        }

        public /* synthetic */ C0124a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return a.f14193d;
        }

        public final int b() {
            return a.f14192c;
        }
    }

    private /* synthetic */ a(int i5) {
        this.f14194a = i5;
    }

    public static final /* synthetic */ a c(int i5) {
        return new a(i5);
    }

    public static int d(int i5) {
        return i5;
    }

    public static boolean e(int i5, Object obj) {
        return (obj instanceof a) && i5 == ((a) obj).i();
    }

    public static final boolean f(int i5, int i6) {
        return i5 == i6;
    }

    public static int g(int i5) {
        return i5;
    }

    public static String h(int i5) {
        return f(i5, f14192c) ? "Touch" : f(i5, f14193d) ? "Keyboard" : "Error";
    }

    public boolean equals(Object obj) {
        return e(this.f14194a, obj);
    }

    public int hashCode() {
        return g(this.f14194a);
    }

    public final /* synthetic */ int i() {
        return this.f14194a;
    }

    public String toString() {
        return h(this.f14194a);
    }
}
