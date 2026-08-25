package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private float f1462a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1464c;

    /* renamed from: d, reason: collision with root package name */
    private double f1465d;

    /* renamed from: e, reason: collision with root package name */
    private double f1466e;

    /* renamed from: f, reason: collision with root package name */
    private double f1467f;

    /* renamed from: b, reason: collision with root package name */
    private double f1463b = Math.sqrt(50.0d);

    /* renamed from: g, reason: collision with root package name */
    private float f1468g = 1.0f;

    public m0(float f5) {
        this.f1462a = f5;
    }

    private final void c() {
        if (this.f1464c) {
            return;
        }
        if (this.f1462a == n0.b()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f5 = this.f1468g;
        double d5 = f5 * f5;
        if (f5 > 1.0f) {
            double d6 = this.f1463b;
            double d7 = d5 - 1;
            this.f1465d = ((-f5) * d6) + (d6 * Math.sqrt(d7));
            double d8 = -this.f1468g;
            double d9 = this.f1463b;
            this.f1466e = (d8 * d9) - (d9 * Math.sqrt(d7));
        } else if (f5 >= 0.0f && f5 < 1.0f) {
            this.f1467f = this.f1463b * Math.sqrt(1 - d5);
        }
        this.f1464c = true;
    }

    public final float a() {
        return this.f1468g;
    }

    public final float b() {
        double d5 = this.f1463b;
        return (float) (d5 * d5);
    }

    public final void d(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f1468g = f5;
        this.f1464c = false;
    }

    public final void e(float f5) {
        this.f1462a = f5;
    }

    public final void f(float f5) {
        if (b() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f1463b = Math.sqrt(f5);
        this.f1464c = false;
    }

    public final long g(float f5, float f6, long j5) {
        double cos;
        double d5;
        c();
        float f7 = f5 - this.f1462a;
        double d6 = j5 / 1000.0d;
        float f8 = this.f1468g;
        if (f8 > 1.0f) {
            double d7 = f7;
            double d8 = this.f1466e;
            double d9 = f6;
            double d10 = this.f1465d;
            double d11 = d7 - (((d8 * d7) - d9) / (d8 - d10));
            double d12 = ((d7 * d8) - d9) / (d8 - d10);
            d5 = (Math.exp(d8 * d6) * d11) + (Math.exp(this.f1465d * d6) * d12);
            double d13 = this.f1466e;
            double exp = d11 * d13 * Math.exp(d13 * d6);
            double d14 = this.f1465d;
            cos = exp + (d12 * d14 * Math.exp(d14 * d6));
        } else if (f8 == 1.0f) {
            double d15 = this.f1463b;
            double d16 = f7;
            double d17 = f6 + (d15 * d16);
            double d18 = d16 + (d17 * d6);
            double exp2 = Math.exp((-d15) * d6) * d18;
            double exp3 = d18 * Math.exp((-this.f1463b) * d6);
            double d19 = this.f1463b;
            cos = (exp3 * (-d19)) + (d17 * Math.exp((-d19) * d6));
            d5 = exp2;
        } else {
            double d20 = 1 / this.f1467f;
            double d21 = this.f1463b;
            double d22 = f7;
            double d23 = d20 * ((f8 * d21 * d22) + f6);
            double exp4 = Math.exp((-f8) * d21 * d6) * ((Math.cos(this.f1467f * d6) * d22) + (Math.sin(this.f1467f * d6) * d23));
            double d24 = this.f1463b;
            double d25 = (-d24) * exp4 * this.f1468g;
            double exp5 = Math.exp((-r5) * d24 * d6);
            double d26 = this.f1467f;
            double sin = (-d26) * d22 * Math.sin(d26 * d6);
            double d27 = this.f1467f;
            cos = d25 + (exp5 * (sin + (d23 * d27 * Math.cos(d27 * d6))));
            d5 = exp4;
        }
        return n0.a((float) (d5 + this.f1462a), (float) cos);
    }
}
