package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class j implements l {

    /* renamed from: c, reason: collision with root package name */
    private double f5769c;

    /* renamed from: d, reason: collision with root package name */
    private double f5770d;

    /* renamed from: e, reason: collision with root package name */
    private double f5771e;

    /* renamed from: f, reason: collision with root package name */
    private float f5772f;

    /* renamed from: g, reason: collision with root package name */
    private float f5773g;

    /* renamed from: h, reason: collision with root package name */
    private float f5774h;

    /* renamed from: i, reason: collision with root package name */
    private float f5775i;

    /* renamed from: j, reason: collision with root package name */
    private float f5776j;

    /* renamed from: a, reason: collision with root package name */
    double f5767a = 0.5d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5768b = false;

    /* renamed from: k, reason: collision with root package name */
    private int f5777k = 0;

    private void b(double d5) {
        double d6 = this.f5769c;
        double d7 = this.f5767a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d6 / this.f5775i) * d5) * 4.0d)) + 1.0d);
        double d8 = d5 / sqrt;
        int i5 = 0;
        while (i5 < sqrt) {
            float f5 = this.f5773g;
            double d9 = this.f5770d;
            float f6 = this.f5774h;
            double d10 = d6;
            double d11 = ((-d6) * (f5 - d9)) - (f6 * d7);
            float f7 = this.f5775i;
            double d12 = d7;
            double d13 = f6 + (((d11 / f7) * d8) / 2.0d);
            double d14 = ((((-((f5 + ((d8 * d13) / 2.0d)) - d9)) * d10) - (d13 * d12)) / f7) * d8;
            float f8 = (float) (f6 + d14);
            this.f5774h = f8;
            float f9 = (float) (f5 + ((f6 + (d14 / 2.0d)) * d8));
            this.f5773g = f9;
            int i6 = this.f5777k;
            if (i6 > 0) {
                if (f9 < 0.0f && (i6 & 1) == 1) {
                    this.f5773g = -f9;
                    this.f5774h = -f8;
                }
                float f10 = this.f5773g;
                if (f10 > 1.0f && (i6 & 2) == 2) {
                    this.f5773g = 2.0f - f10;
                    this.f5774h = -this.f5774h;
                }
            }
            i5++;
            d6 = d10;
            d7 = d12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float a() {
        return 0.0f;
    }

    public void c(float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i5) {
        this.f5770d = f6;
        this.f5767a = f10;
        this.f5768b = false;
        this.f5773g = f5;
        this.f5771e = f7;
        this.f5769c = f9;
        this.f5775i = f8;
        this.f5776j = f11;
        this.f5777k = i5;
        this.f5772f = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f5) {
        b(f5 - this.f5772f);
        this.f5772f = f5;
        return this.f5773g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean isStopped() {
        double d5 = this.f5773g - this.f5770d;
        double d6 = this.f5769c;
        double d7 = this.f5774h;
        return Math.sqrt((((d7 * d7) * ((double) this.f5775i)) + ((d6 * d5) * d5)) / d6) <= ((double) this.f5776j);
    }
}
