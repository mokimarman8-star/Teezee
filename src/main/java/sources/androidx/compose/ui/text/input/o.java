package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5236b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5237c = j(-1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5238d = j(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5239e = j(0);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5240f = j(2);

    /* renamed from: g, reason: collision with root package name */
    private static final int f5241g = j(3);

    /* renamed from: h, reason: collision with root package name */
    private static final int f5242h = j(4);

    /* renamed from: i, reason: collision with root package name */
    private static final int f5243i = j(5);

    /* renamed from: j, reason: collision with root package name */
    private static final int f5244j = j(6);

    /* renamed from: k, reason: collision with root package name */
    private static final int f5245k = j(7);

    /* renamed from: a, reason: collision with root package name */
    private final int f5246a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f5238d;
        }

        public final int b() {
            return o.f5245k;
        }

        public final int c() {
            return o.f5240f;
        }

        public final int d() {
            return o.f5244j;
        }

        public final int e() {
            return o.f5239e;
        }

        public final int f() {
            return o.f5243i;
        }

        public final int g() {
            return o.f5241g;
        }

        public final int h() {
            return o.f5242h;
        }
    }

    private /* synthetic */ o(int i5) {
        this.f5246a = i5;
    }

    public static final /* synthetic */ o i(int i5) {
        return new o(i5);
    }

    private static int j(int i5) {
        return i5;
    }

    public static boolean k(int i5, Object obj) {
        return (obj instanceof o) && i5 == ((o) obj).o();
    }

    public static final boolean l(int i5, int i6) {
        return i5 == i6;
    }

    public static int m(int i5) {
        return i5;
    }

    public static String n(int i5) {
        return l(i5, f5237c) ? "Unspecified" : l(i5, f5239e) ? "None" : l(i5, f5238d) ? "Default" : l(i5, f5240f) ? "Go" : l(i5, f5241g) ? "Search" : l(i5, f5242h) ? "Send" : l(i5, f5243i) ? "Previous" : l(i5, f5244j) ? "Next" : l(i5, f5245k) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return k(this.f5246a, obj);
    }

    public int hashCode() {
        return m(this.f5246a);
    }

    public final /* synthetic */ int o() {
        return this.f5246a;
    }

    public String toString() {
        return n(this.f5246a);
    }
}
