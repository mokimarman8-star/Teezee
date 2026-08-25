package n3;

import android.text.Layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f16612a;

    /* renamed from: b, reason: collision with root package name */
    private int f16613b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16614c;

    /* renamed from: d, reason: collision with root package name */
    private int f16615d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16616e;

    /* renamed from: k, reason: collision with root package name */
    private float f16622k;

    /* renamed from: l, reason: collision with root package name */
    private String f16623l;

    /* renamed from: o, reason: collision with root package name */
    private Layout.Alignment f16626o;

    /* renamed from: p, reason: collision with root package name */
    private Layout.Alignment f16627p;

    /* renamed from: r, reason: collision with root package name */
    private b f16629r;

    /* renamed from: t, reason: collision with root package name */
    private String f16631t;

    /* renamed from: u, reason: collision with root package name */
    private String f16632u;

    /* renamed from: f, reason: collision with root package name */
    private int f16617f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f16618g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f16619h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f16620i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f16621j = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f16624m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f16625n = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f16628q = -1;

    /* renamed from: s, reason: collision with root package name */
    private float f16630s = Float.MAX_VALUE;

    private g t(g gVar, boolean z5) {
        int i5;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f16614c && gVar.f16614c) {
                z(gVar.f16613b);
            }
            if (this.f16619h == -1) {
                this.f16619h = gVar.f16619h;
            }
            if (this.f16620i == -1) {
                this.f16620i = gVar.f16620i;
            }
            if (this.f16612a == null && (str = gVar.f16612a) != null) {
                this.f16612a = str;
            }
            if (this.f16617f == -1) {
                this.f16617f = gVar.f16617f;
            }
            if (this.f16618g == -1) {
                this.f16618g = gVar.f16618g;
            }
            if (this.f16625n == -1) {
                this.f16625n = gVar.f16625n;
            }
            if (this.f16626o == null && (alignment2 = gVar.f16626o) != null) {
                this.f16626o = alignment2;
            }
            if (this.f16627p == null && (alignment = gVar.f16627p) != null) {
                this.f16627p = alignment;
            }
            if (this.f16628q == -1) {
                this.f16628q = gVar.f16628q;
            }
            if (this.f16621j == -1) {
                this.f16621j = gVar.f16621j;
                this.f16622k = gVar.f16622k;
            }
            if (this.f16629r == null) {
                this.f16629r = gVar.f16629r;
            }
            if (this.f16630s == Float.MAX_VALUE) {
                this.f16630s = gVar.f16630s;
            }
            if (this.f16631t == null) {
                this.f16631t = gVar.f16631t;
            }
            if (this.f16632u == null) {
                this.f16632u = gVar.f16632u;
            }
            if (z5 && !this.f16616e && gVar.f16616e) {
                w(gVar.f16615d);
            }
            if (z5 && this.f16624m == -1 && (i5 = gVar.f16624m) != -1) {
                this.f16624m = i5;
            }
        }
        return this;
    }

    public g A(String str) {
        this.f16612a = str;
        return this;
    }

    public g B(float f5) {
        this.f16622k = f5;
        return this;
    }

    public g C(int i5) {
        this.f16621j = i5;
        return this;
    }

    public g D(String str) {
        this.f16623l = str;
        return this;
    }

    public g E(boolean z5) {
        this.f16620i = z5 ? 1 : 0;
        return this;
    }

    public g F(boolean z5) {
        this.f16617f = z5 ? 1 : 0;
        return this;
    }

    public g G(Layout.Alignment alignment) {
        this.f16627p = alignment;
        return this;
    }

    public g H(String str) {
        this.f16631t = str;
        return this;
    }

    public g I(int i5) {
        this.f16625n = i5;
        return this;
    }

    public g J(int i5) {
        this.f16624m = i5;
        return this;
    }

    public g K(float f5) {
        this.f16630s = f5;
        return this;
    }

    public g L(Layout.Alignment alignment) {
        this.f16626o = alignment;
        return this;
    }

    public g M(boolean z5) {
        this.f16628q = z5 ? 1 : 0;
        return this;
    }

    public g N(b bVar) {
        this.f16629r = bVar;
        return this;
    }

    public g O(boolean z5) {
        this.f16618g = z5 ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return t(gVar, true);
    }

    public int b() {
        if (this.f16616e) {
            return this.f16615d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public String c() {
        return this.f16632u;
    }

    public int d() {
        if (this.f16614c) {
            return this.f16613b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String e() {
        return this.f16612a;
    }

    public float f() {
        return this.f16622k;
    }

    public int g() {
        return this.f16621j;
    }

    public String h() {
        return this.f16623l;
    }

    public Layout.Alignment i() {
        return this.f16627p;
    }

    public String j() {
        return this.f16631t;
    }

    public int k() {
        return this.f16625n;
    }

    public int l() {
        return this.f16624m;
    }

    public float m() {
        return this.f16630s;
    }

    public int n() {
        int i5 = this.f16619h;
        if (i5 == -1 && this.f16620i == -1) {
            return -1;
        }
        return (i5 == 1 ? 1 : 0) | (this.f16620i == 1 ? 2 : 0);
    }

    public Layout.Alignment o() {
        return this.f16626o;
    }

    public boolean p() {
        return this.f16628q == 1;
    }

    public b q() {
        return this.f16629r;
    }

    public boolean r() {
        return this.f16616e;
    }

    public boolean s() {
        return this.f16614c;
    }

    public boolean u() {
        return this.f16617f == 1;
    }

    public boolean v() {
        return this.f16618g == 1;
    }

    public g w(int i5) {
        this.f16615d = i5;
        this.f16616e = true;
        return this;
    }

    public g x(boolean z5) {
        this.f16619h = z5 ? 1 : 0;
        return this;
    }

    public g y(String str) {
        this.f16632u = str;
        return this;
    }

    public g z(int i5) {
        this.f16613b = i5;
        this.f16614c = true;
        return this;
    }
}
