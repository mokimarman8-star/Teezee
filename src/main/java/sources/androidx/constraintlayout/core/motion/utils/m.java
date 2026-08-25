package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class m implements l {

    /* renamed from: a, reason: collision with root package name */
    private float f5779a;

    /* renamed from: b, reason: collision with root package name */
    private float f5780b;

    /* renamed from: c, reason: collision with root package name */
    private float f5781c;

    /* renamed from: d, reason: collision with root package name */
    private float f5782d;

    /* renamed from: e, reason: collision with root package name */
    private float f5783e;

    /* renamed from: f, reason: collision with root package name */
    private float f5784f;

    /* renamed from: g, reason: collision with root package name */
    private float f5785g;

    /* renamed from: h, reason: collision with root package name */
    private float f5786h;

    /* renamed from: i, reason: collision with root package name */
    private float f5787i;

    /* renamed from: j, reason: collision with root package name */
    private int f5788j;

    /* renamed from: k, reason: collision with root package name */
    private String f5789k;

    /* renamed from: m, reason: collision with root package name */
    private float f5791m;

    /* renamed from: n, reason: collision with root package name */
    private float f5792n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5790l = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5793o = false;

    private float b(float f5) {
        this.f5793o = false;
        float f6 = this.f5782d;
        if (f5 <= f6) {
            float f7 = this.f5779a;
            return (f7 * f5) + ((((this.f5780b - f7) * f5) * f5) / (f6 * 2.0f));
        }
        int i5 = this.f5788j;
        if (i5 == 1) {
            return this.f5785g;
        }
        float f8 = f5 - f6;
        float f9 = this.f5783e;
        if (f8 < f9) {
            float f10 = this.f5785g;
            float f11 = this.f5780b;
            return f10 + (f11 * f8) + ((((this.f5781c - f11) * f8) * f8) / (f9 * 2.0f));
        }
        if (i5 == 2) {
            return this.f5786h;
        }
        float f12 = f8 - f9;
        float f13 = this.f5784f;
        if (f12 > f13) {
            this.f5793o = true;
            return this.f5787i;
        }
        float f14 = this.f5786h;
        float f15 = this.f5781c;
        return (f14 + (f15 * f12)) - (((f15 * f12) * f12) / (f13 * 2.0f));
    }

    private void e(float f5, float f6, float f7, float f8, float f9) {
        this.f5793o = false;
        if (f5 == 0.0f) {
            f5 = 1.0E-4f;
        }
        this.f5779a = f5;
        float f10 = f5 / f7;
        float f11 = (f10 * f5) / 2.0f;
        if (f5 < 0.0f) {
            float sqrt = (float) Math.sqrt((f6 - ((((-f5) / f7) * f5) / 2.0f)) * f7);
            if (sqrt < f8) {
                this.f5789k = "backward accelerate, decelerate";
                this.f5788j = 2;
                this.f5779a = f5;
                this.f5780b = sqrt;
                this.f5781c = 0.0f;
                float f12 = (sqrt - f5) / f7;
                this.f5782d = f12;
                this.f5783e = sqrt / f7;
                this.f5785g = ((f5 + sqrt) * f12) / 2.0f;
                this.f5786h = f6;
                this.f5787i = f6;
                return;
            }
            this.f5789k = "backward accelerate cruse decelerate";
            this.f5788j = 3;
            this.f5779a = f5;
            this.f5780b = f8;
            this.f5781c = f8;
            float f13 = (f8 - f5) / f7;
            this.f5782d = f13;
            float f14 = f8 / f7;
            this.f5784f = f14;
            float f15 = ((f5 + f8) * f13) / 2.0f;
            float f16 = (f14 * f8) / 2.0f;
            this.f5783e = ((f6 - f15) - f16) / f8;
            this.f5785g = f15;
            this.f5786h = f6 - f16;
            this.f5787i = f6;
            return;
        }
        if (f11 >= f6) {
            this.f5789k = "hard stop";
            this.f5788j = 1;
            this.f5779a = f5;
            this.f5780b = 0.0f;
            this.f5785g = f6;
            this.f5782d = (2.0f * f6) / f5;
            return;
        }
        float f17 = f6 - f11;
        float f18 = f17 / f5;
        if (f18 + f10 < f9) {
            this.f5789k = "cruse decelerate";
            this.f5788j = 2;
            this.f5779a = f5;
            this.f5780b = f5;
            this.f5781c = 0.0f;
            this.f5785g = f17;
            this.f5786h = f6;
            this.f5782d = f18;
            this.f5783e = f10;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f7 * f6) + ((f5 * f5) / 2.0f));
        float f19 = (sqrt2 - f5) / f7;
        this.f5782d = f19;
        float f20 = sqrt2 / f7;
        this.f5783e = f20;
        if (sqrt2 < f8) {
            this.f5789k = "accelerate decelerate";
            this.f5788j = 2;
            this.f5779a = f5;
            this.f5780b = sqrt2;
            this.f5781c = 0.0f;
            this.f5782d = f19;
            this.f5783e = f20;
            this.f5785g = ((f5 + sqrt2) * f19) / 2.0f;
            this.f5786h = f6;
            return;
        }
        this.f5789k = "accelerate cruse decelerate";
        this.f5788j = 3;
        this.f5779a = f5;
        this.f5780b = f8;
        this.f5781c = f8;
        float f21 = (f8 - f5) / f7;
        this.f5782d = f21;
        float f22 = f8 / f7;
        this.f5784f = f22;
        float f23 = ((f5 + f8) * f21) / 2.0f;
        float f24 = (f22 * f8) / 2.0f;
        this.f5783e = ((f6 - f23) - f24) / f8;
        this.f5785g = f23;
        this.f5786h = f6 - f24;
        this.f5787i = f6;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float a() {
        return this.f5790l ? -d(this.f5792n) : d(this.f5792n);
    }

    public void c(float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f5793o = false;
        this.f5791m = f5;
        boolean z5 = f5 > f6;
        this.f5790l = z5;
        if (z5) {
            e(-f7, f5 - f6, f9, f10, f8);
        } else {
            e(f7, f6 - f5, f9, f10, f8);
        }
    }

    public float d(float f5) {
        float f6 = this.f5782d;
        if (f5 <= f6) {
            float f7 = this.f5779a;
            return f7 + (((this.f5780b - f7) * f5) / f6);
        }
        int i5 = this.f5788j;
        if (i5 == 1) {
            return 0.0f;
        }
        float f8 = f5 - f6;
        float f9 = this.f5783e;
        if (f8 < f9) {
            float f10 = this.f5780b;
            return f10 + (((this.f5781c - f10) * f8) / f9);
        }
        if (i5 == 2) {
            return this.f5786h;
        }
        float f11 = f8 - f9;
        float f12 = this.f5784f;
        if (f11 >= f12) {
            return this.f5787i;
        }
        float f13 = this.f5781c;
        return f13 - ((f11 * f13) / f12);
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f5) {
        float b5 = b(f5);
        this.f5792n = f5;
        return this.f5790l ? this.f5791m - b5 : this.f5791m + b5;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean isStopped() {
        return a() < 1.0E-5f && Math.abs(this.f5787i - this.f5792n) < 1.0E-5f;
    }
}
