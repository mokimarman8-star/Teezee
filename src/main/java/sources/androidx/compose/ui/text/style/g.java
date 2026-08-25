package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final b f5382c;

    /* renamed from: d, reason: collision with root package name */
    private static final g f5383d;

    /* renamed from: a, reason: collision with root package name */
    private final float f5384a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5385b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0039a f5386a = new C0039a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final float f5387b = c(0.0f);

        /* renamed from: c, reason: collision with root package name */
        private static final float f5388c = c(0.5f);

        /* renamed from: d, reason: collision with root package name */
        private static final float f5389d = c(-1.0f);

        /* renamed from: e, reason: collision with root package name */
        private static final float f5390e = c(1.0f);

        /* renamed from: androidx.compose.ui.text.style.g$a$a, reason: collision with other inner class name */
        public static final class C0039a {
            private C0039a() {
            }

            public /* synthetic */ C0039a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final float a() {
                return a.f5388c;
            }

            public final float b() {
                return a.f5389d;
            }
        }

        public static float c(float f5) {
            if ((0.0f > f5 || f5 > 1.0f) && f5 != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f5;
        }

        public static final boolean d(float f5, float f6) {
            return Float.compare(f5, f6) == 0;
        }

        public static int e(float f5) {
            return Float.floatToIntBits(f5);
        }

        public static String f(float f5) {
            if (f5 == f5387b) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f5 == f5388c) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f5 == f5389d) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f5 == f5390e) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f5 + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return g.f5383d;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5391a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5392b = c(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5393c = c(16);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5394d = c(17);

        /* renamed from: e, reason: collision with root package name */
        private static final int f5395e = c(0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f5394d;
            }

            public final int b() {
                return c.f5395e;
            }
        }

        private static int c(int i5) {
            return i5;
        }

        public static final boolean d(int i5, int i6) {
            return i5 == i6;
        }

        public static int e(int i5) {
            return i5;
        }

        public static final boolean f(int i5) {
            return (i5 & 1) > 0;
        }

        public static final boolean g(int i5) {
            return (i5 & 16) > 0;
        }

        public static String h(int i5) {
            return i5 == f5392b ? "LineHeightStyle.Trim.FirstLineTop" : i5 == f5393c ? "LineHeightStyle.Trim.LastLineBottom" : i5 == f5394d ? "LineHeightStyle.Trim.Both" : i5 == f5395e ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f5382c = new b(defaultConstructorMarker);
        f5383d = new g(a.f5386a.b(), c.f5391a.a(), defaultConstructorMarker);
    }

    private g(float f5, int i5) {
        this.f5384a = f5;
        this.f5385b = i5;
    }

    public /* synthetic */ g(float f5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, i5);
    }

    public final float b() {
        return this.f5384a;
    }

    public final int c() {
        return this.f5385b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a.d(this.f5384a, gVar.f5384a) && c.d(this.f5385b, gVar.f5385b);
    }

    public int hashCode() {
        return (a.e(this.f5384a) * 31) + c.e(this.f5385b);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) a.f(this.f5384a)) + ", trim=" + ((Object) c.h(this.f5385b)) + ')';
    }
}
