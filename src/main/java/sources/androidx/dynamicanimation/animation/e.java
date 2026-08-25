package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    double f7849a;

    /* renamed from: b, reason: collision with root package name */
    double f7850b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7851c;

    /* renamed from: d, reason: collision with root package name */
    private double f7852d;

    /* renamed from: e, reason: collision with root package name */
    private double f7853e;

    /* renamed from: f, reason: collision with root package name */
    private double f7854f;

    /* renamed from: g, reason: collision with root package name */
    private double f7855g;

    /* renamed from: h, reason: collision with root package name */
    private double f7856h;

    /* renamed from: i, reason: collision with root package name */
    private double f7857i;

    /* renamed from: j, reason: collision with root package name */
    private final b.o f7858j;

    public e() {
        this.f7849a = Math.sqrt(1500.0d);
        this.f7850b = 0.5d;
        this.f7851c = false;
        this.f7857i = Double.MAX_VALUE;
        this.f7858j = new b.o();
    }

    public e(float f5) {
        this.f7849a = Math.sqrt(1500.0d);
        this.f7850b = 0.5d;
        this.f7851c = false;
        this.f7857i = Double.MAX_VALUE;
        this.f7858j = new b.o();
        this.f7857i = f5;
    }

    private void b() {
        if (this.f7851c) {
            return;
        }
        if (this.f7857i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d5 = this.f7850b;
        if (d5 > 1.0d) {
            double d6 = this.f7849a;
            this.f7854f = ((-d5) * d6) + (d6 * Math.sqrt((d5 * d5) - 1.0d));
            double d7 = this.f7850b;
            double d8 = this.f7849a;
            this.f7855g = ((-d7) * d8) - (d8 * Math.sqrt((d7 * d7) - 1.0d));
        } else if (d5 >= 0.0d && d5 < 1.0d) {
            this.f7856h = this.f7849a * Math.sqrt(1.0d - (d5 * d5));
        }
        this.f7851c = true;
    }

    public float a() {
        return (float) this.f7857i;
    }

    public boolean c(float f5, float f6) {
        return ((double) Math.abs(f6)) < this.f7853e && ((double) Math.abs(f5 - a())) < this.f7852d;
    }

    public e d(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f7850b = f5;
        this.f7851c = false;
        return this;
    }

    public e e(float f5) {
        this.f7857i = f5;
        return this;
    }

    public e f(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f7849a = Math.sqrt(f5);
        this.f7851c = false;
        return this;
    }

    void g(double d5) {
        double abs = Math.abs(d5);
        this.f7852d = abs;
        this.f7853e = abs * 62.5d;
    }

    b.o h(double d5, double d6, long j5) {
        double cos;
        double d7;
        b();
        double d8 = j5 / 1000.0d;
        double d9 = d5 - this.f7857i;
        double d10 = this.f7850b;
        if (d10 > 1.0d) {
            double d11 = this.f7855g;
            double d12 = this.f7854f;
            double d13 = d9 - (((d11 * d9) - d6) / (d11 - d12));
            double d14 = ((d9 * d11) - d6) / (d11 - d12);
            d7 = (Math.pow(2.718281828459045d, d11 * d8) * d13) + (Math.pow(2.718281828459045d, this.f7854f * d8) * d14);
            double d15 = this.f7855g;
            double pow = d13 * d15 * Math.pow(2.718281828459045d, d15 * d8);
            double d16 = this.f7854f;
            cos = pow + (d14 * d16 * Math.pow(2.718281828459045d, d16 * d8));
        } else if (d10 == 1.0d) {
            double d17 = this.f7849a;
            double d18 = d6 + (d17 * d9);
            double d19 = d9 + (d18 * d8);
            d7 = Math.pow(2.718281828459045d, (-d17) * d8) * d19;
            double pow2 = d19 * Math.pow(2.718281828459045d, (-this.f7849a) * d8);
            double d20 = this.f7849a;
            cos = (d18 * Math.pow(2.718281828459045d, (-d20) * d8)) + (pow2 * (-d20));
        } else {
            double d21 = 1.0d / this.f7856h;
            double d22 = this.f7849a;
            double d23 = d21 * ((d10 * d22 * d9) + d6);
            double pow3 = Math.pow(2.718281828459045d, (-d10) * d22 * d8) * ((Math.cos(this.f7856h * d8) * d9) + (Math.sin(this.f7856h * d8) * d23));
            double d24 = this.f7849a;
            double d25 = this.f7850b;
            double d26 = (-d24) * pow3 * d25;
            double pow4 = Math.pow(2.718281828459045d, (-d25) * d24 * d8);
            double d27 = this.f7856h;
            double sin = (-d27) * d9 * Math.sin(d27 * d8);
            double d28 = this.f7856h;
            cos = d26 + (pow4 * (sin + (d23 * d28 * Math.cos(d28 * d8))));
            d7 = pow3;
        }
        b.o oVar = this.f7858j;
        oVar.f7846a = (float) (d7 + this.f7857i);
        oVar.f7847b = (float) cos;
        return oVar;
    }
}
