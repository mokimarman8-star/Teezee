package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5362a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5363b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f5364c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f5365d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f5366e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f5363b;
        }

        public final int b() {
            return e.f5366e;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5367a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5368b = d(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5369c = d(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5370d = d(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f5371e = d(0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f5370d;
            }

            public final int b() {
                return b.f5369c;
            }

            public final int c() {
                return b.f5368b;
            }
        }

        public static int d(int i5) {
            return i5;
        }

        public static final boolean e(int i5, int i6) {
            return i5 == i6;
        }

        public static String f(int i5) {
            return e(i5, f5368b) ? "Strategy.Simple" : e(i5, f5369c) ? "Strategy.HighQuality" : e(i5, f5370d) ? "Strategy.Balanced" : e(i5, f5371e) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5372a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5373b = e(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5374c = e(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5375d = e(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f5376e = e(4);

        /* renamed from: f, reason: collision with root package name */
        private static final int f5377f = e(0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f5373b;
            }

            public final int b() {
                return c.f5374c;
            }

            public final int c() {
                return c.f5375d;
            }

            public final int d() {
                return c.f5376e;
            }
        }

        public static int e(int i5) {
            return i5;
        }

        public static final boolean f(int i5, int i6) {
            return i5 == i6;
        }

        public static String g(int i5) {
            return f(i5, f5373b) ? "Strictness.None" : f(i5, f5374c) ? "Strictness.Loose" : f(i5, f5375d) ? "Strictness.Normal" : f(i5, f5376e) ? "Strictness.Strict" : f(i5, f5377f) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5378a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5379b = c(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5380c = c(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5381d = c(0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return d.f5379b;
            }

            public final int b() {
                return d.f5380c;
            }
        }

        public static int c(int i5) {
            return i5;
        }

        public static final boolean d(int i5, int i6) {
            return i5 == i6;
        }

        public static String e(int i5) {
            return d(i5, f5379b) ? "WordBreak.None" : d(i5, f5380c) ? "WordBreak.Phrase" : d(i5, f5381d) ? "WordBreak.Unspecified" : "Invalid";
        }
    }

    static {
        int e5;
        int e6;
        int e7;
        b.a aVar = b.f5367a;
        int c5 = aVar.c();
        c.a aVar2 = c.f5372a;
        int c6 = aVar2.c();
        d.a aVar3 = d.f5378a;
        e5 = f.e(c5, c6, aVar3.a());
        f5363b = c(e5);
        e6 = f.e(aVar.a(), aVar2.b(), aVar3.b());
        f5364c = c(e6);
        e7 = f.e(aVar.b(), aVar2.d(), aVar3.a());
        f5365d = c(e7);
        f5366e = c(0);
    }

    private static int c(int i5) {
        return i5;
    }

    public static final boolean d(int i5, int i6) {
        return i5 == i6;
    }

    public static final int e(int i5) {
        int f5;
        f5 = f.f(i5);
        return b.d(f5);
    }

    public static final int f(int i5) {
        int g5;
        g5 = f.g(i5);
        return c.e(g5);
    }

    public static final int g(int i5) {
        int h5;
        h5 = f.h(i5);
        return d.c(h5);
    }

    public static int h(int i5) {
        return i5;
    }

    public static String i(int i5) {
        return "LineBreak(strategy=" + ((Object) b.f(e(i5))) + ", strictness=" + ((Object) c.g(f(i5))) + ", wordBreak=" + ((Object) d.e(g(i5))) + ')';
    }
}
