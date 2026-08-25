package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4960b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4961c = i(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4962d = i(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f4963e = i(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f4964f = i(3);

    /* renamed from: g, reason: collision with root package name */
    private static final int f4965g = i(4);

    /* renamed from: h, reason: collision with root package name */
    private static final int f4966h = i(5);

    /* renamed from: i, reason: collision with root package name */
    private static final int f4967i = i(6);

    /* renamed from: a, reason: collision with root package name */
    private final int f4968a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return f.f4961c;
        }

        public final int b() {
            return f.f4962d;
        }

        public final int c() {
            return f.f4967i;
        }

        public final int d() {
            return f.f4966h;
        }

        public final int e() {
            return f.f4964f;
        }

        public final int f() {
            return f.f4963e;
        }

        public final int g() {
            return f.f4965g;
        }
    }

    private /* synthetic */ f(int i5) {
        this.f4968a = i5;
    }

    public static final /* synthetic */ f h(int i5) {
        return new f(i5);
    }

    private static int i(int i5) {
        return i5;
    }

    public static boolean j(int i5, Object obj) {
        return (obj instanceof f) && i5 == ((f) obj).n();
    }

    public static final boolean k(int i5, int i6) {
        return i5 == i6;
    }

    public static int l(int i5) {
        return i5;
    }

    public static String m(int i5) {
        return k(i5, f4961c) ? "Button" : k(i5, f4962d) ? "Checkbox" : k(i5, f4963e) ? "Switch" : k(i5, f4964f) ? "RadioButton" : k(i5, f4965g) ? "Tab" : k(i5, f4966h) ? "Image" : k(i5, f4967i) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return j(this.f4968a, obj);
    }

    public int hashCode() {
        return l(this.f4968a);
    }

    public final /* synthetic */ int n() {
        return this.f4968a;
    }

    public String toString() {
        return m(this.f4968a);
    }
}
