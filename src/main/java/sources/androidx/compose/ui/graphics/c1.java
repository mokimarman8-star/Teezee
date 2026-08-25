package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3289a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3290b = D(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3291c = D(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3292d = D(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f3293e = D(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f3294f = D(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f3295g = D(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f3296h = D(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f3297i = D(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f3298j = D(8);

    /* renamed from: k, reason: collision with root package name */
    private static final int f3299k = D(9);

    /* renamed from: l, reason: collision with root package name */
    private static final int f3300l = D(10);

    /* renamed from: m, reason: collision with root package name */
    private static final int f3301m = D(11);

    /* renamed from: n, reason: collision with root package name */
    private static final int f3302n = D(12);

    /* renamed from: o, reason: collision with root package name */
    private static final int f3303o = D(13);

    /* renamed from: p, reason: collision with root package name */
    private static final int f3304p = D(14);

    /* renamed from: q, reason: collision with root package name */
    private static final int f3305q = D(15);

    /* renamed from: r, reason: collision with root package name */
    private static final int f3306r = D(16);

    /* renamed from: s, reason: collision with root package name */
    private static final int f3307s = D(17);

    /* renamed from: t, reason: collision with root package name */
    private static final int f3308t = D(18);

    /* renamed from: u, reason: collision with root package name */
    private static final int f3309u = D(19);

    /* renamed from: v, reason: collision with root package name */
    private static final int f3310v = D(20);

    /* renamed from: w, reason: collision with root package name */
    private static final int f3311w = D(21);

    /* renamed from: x, reason: collision with root package name */
    private static final int f3312x = D(22);

    /* renamed from: y, reason: collision with root package name */
    private static final int f3313y = D(23);

    /* renamed from: z, reason: collision with root package name */
    private static final int f3314z = D(24);
    private static final int A = D(25);
    private static final int B = D(26);
    private static final int C = D(27);
    private static final int D = D(28);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int A() {
            return c1.f3297i;
        }

        public final int B() {
            return c1.f3293e;
        }

        public final int C() {
            return c1.f3301m;
        }

        public final int a() {
            return c1.f3290b;
        }

        public final int b() {
            return c1.C;
        }

        public final int c() {
            return c1.f3309u;
        }

        public final int d() {
            return c1.f3308t;
        }

        public final int e() {
            return c1.f3306r;
        }

        public final int f() {
            return c1.f3312x;
        }

        public final int g() {
            return c1.f3292d;
        }

        public final int h() {
            return c1.f3300l;
        }

        public final int i() {
            return c1.f3296h;
        }

        public final int j() {
            return c1.f3298j;
        }

        public final int k() {
            return c1.f3294f;
        }

        public final int l() {
            return c1.f3313y;
        }

        public final int m() {
            return c1.f3310v;
        }

        public final int n() {
            return c1.A;
        }

        public final int o() {
            return c1.f3307s;
        }

        public final int p() {
            return c1.D;
        }

        public final int q() {
            return c1.f3303o;
        }

        public final int r() {
            return c1.f3314z;
        }

        public final int s() {
            return c1.f3305q;
        }

        public final int t() {
            return c1.f3302n;
        }

        public final int u() {
            return c1.B;
        }

        public final int v() {
            return c1.f3304p;
        }

        public final int w() {
            return c1.f3311w;
        }

        public final int x() {
            return c1.f3291c;
        }

        public final int y() {
            return c1.f3299k;
        }

        public final int z() {
            return c1.f3295g;
        }
    }

    public static int D(int i5) {
        return i5;
    }

    public static final boolean E(int i5, int i6) {
        return i5 == i6;
    }

    public static int F(int i5) {
        return i5;
    }

    public static String G(int i5) {
        return E(i5, f3290b) ? "Clear" : E(i5, f3291c) ? "Src" : E(i5, f3292d) ? "Dst" : E(i5, f3293e) ? "SrcOver" : E(i5, f3294f) ? "DstOver" : E(i5, f3295g) ? "SrcIn" : E(i5, f3296h) ? "DstIn" : E(i5, f3297i) ? "SrcOut" : E(i5, f3298j) ? "DstOut" : E(i5, f3299k) ? "SrcAtop" : E(i5, f3300l) ? "DstAtop" : E(i5, f3301m) ? "Xor" : E(i5, f3302n) ? "Plus" : E(i5, f3303o) ? "Modulate" : E(i5, f3304p) ? "Screen" : E(i5, f3305q) ? "Overlay" : E(i5, f3306r) ? "Darken" : E(i5, f3307s) ? "Lighten" : E(i5, f3308t) ? "ColorDodge" : E(i5, f3309u) ? "ColorBurn" : E(i5, f3310v) ? "HardLight" : E(i5, f3311w) ? "Softlight" : E(i5, f3312x) ? "Difference" : E(i5, f3313y) ? "Exclusion" : E(i5, f3314z) ? "Multiply" : E(i5, A) ? "Hue" : E(i5, B) ? "Saturation" : E(i5, C) ? "Color" : E(i5, D) ? "Luminosity" : "Unknown";
    }
}
