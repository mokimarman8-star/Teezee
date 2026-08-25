package androidx.compose.ui.focus;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3234b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3235c = j(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3236d = j(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f3237e = j(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f3238f = j(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f3239g = j(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f3240h = j(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f3241i = j(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f3242j = j(8);

    /* renamed from: a, reason: collision with root package name */
    private final int f3243a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f3240h;
        }

        public final int b() {
            return b.f3241i;
        }

        public final int c() {
            return b.f3242j;
        }

        public final int d() {
            return b.f3237e;
        }

        public final int e() {
            return b.f3235c;
        }

        public final int f() {
            return b.f3236d;
        }

        public final int g() {
            return b.f3238f;
        }

        public final int h() {
            return b.f3239g;
        }
    }

    private /* synthetic */ b(int i5) {
        this.f3243a = i5;
    }

    public static final /* synthetic */ b i(int i5) {
        return new b(i5);
    }

    public static int j(int i5) {
        return i5;
    }

    public static boolean k(int i5, Object obj) {
        return (obj instanceof b) && i5 == ((b) obj).o();
    }

    public static final boolean l(int i5, int i6) {
        return i5 == i6;
    }

    public static int m(int i5) {
        return i5;
    }

    public static String n(int i5) {
        return l(i5, f3235c) ? "Next" : l(i5, f3236d) ? "Previous" : l(i5, f3237e) ? "Left" : l(i5, f3238f) ? "Right" : l(i5, f3239g) ? "Up" : l(i5, f3240h) ? "Down" : l(i5, f3241i) ? "Enter" : l(i5, f3242j) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return k(this.f3243a, obj);
    }

    public int hashCode() {
        return m(this.f3243a);
    }

    public final /* synthetic */ int o() {
        return this.f3243a;
    }

    public String toString() {
        return n(this.f3243a);
    }
}
