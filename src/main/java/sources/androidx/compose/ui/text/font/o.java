package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5139b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5140c = f(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5141d = f(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5142e = f(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5143f = f(3);

    /* renamed from: a, reason: collision with root package name */
    private final int f5144a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f5141d;
        }

        public final int b() {
            return o.f5140c;
        }

        public final int c() {
            return o.f5143f;
        }

        public final int d() {
            return o.f5142e;
        }
    }

    private /* synthetic */ o(int i5) {
        this.f5144a = i5;
    }

    public static final /* synthetic */ o e(int i5) {
        return new o(i5);
    }

    public static int f(int i5) {
        return i5;
    }

    public static boolean g(int i5, Object obj) {
        return (obj instanceof o) && i5 == ((o) obj).k();
    }

    public static final boolean h(int i5, int i6) {
        return i5 == i6;
    }

    public static int i(int i5) {
        return i5;
    }

    public static String j(int i5) {
        return h(i5, f5140c) ? "None" : h(i5, f5141d) ? "All" : h(i5, f5142e) ? "Weight" : h(i5, f5143f) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return g(this.f5144a, obj);
    }

    public int hashCode() {
        return i(this.f5144a);
    }

    public final /* synthetic */ int k() {
        return this.f5144a;
    }

    public String toString() {
        return j(this.f5144a);
    }
}
