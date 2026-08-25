package y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    static final l f18598k = k(b.f18563c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f18599a;

    /* renamed from: b, reason: collision with root package name */
    private final float f18600b;

    /* renamed from: c, reason: collision with root package name */
    private final float f18601c;

    /* renamed from: d, reason: collision with root package name */
    private final float f18602d;

    /* renamed from: e, reason: collision with root package name */
    private final float f18603e;

    /* renamed from: f, reason: collision with root package name */
    private final float f18604f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f18605g;

    /* renamed from: h, reason: collision with root package name */
    private final float f18606h;

    /* renamed from: i, reason: collision with root package name */
    private final float f18607i;

    /* renamed from: j, reason: collision with root package name */
    private final float f18608j;

    private l(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f18604f = f5;
        this.f18599a = f6;
        this.f18600b = f7;
        this.f18601c = f8;
        this.f18602d = f9;
        this.f18603e = f10;
        this.f18605g = fArr;
        this.f18606h = f11;
        this.f18607i = f12;
        this.f18608j = f13;
    }

    static l k(float[] fArr, float f5, float f6, float f7, boolean z5) {
        float[][] fArr2 = b.f18561a;
        float f8 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f9 = fArr3[0] * f8;
        float f10 = fArr[1];
        float f11 = f9 + (fArr3[1] * f10);
        float f12 = fArr[2];
        float f13 = f11 + (fArr3[2] * f12);
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[0] * f8) + (fArr4[1] * f10) + (fArr4[2] * f12);
        float[] fArr5 = fArr2[2];
        float f15 = (f8 * fArr5[0]) + (f10 * fArr5[1]) + (f12 * fArr5[2]);
        float f16 = (f7 / 10.0f) + 0.8f;
        float d5 = ((double) f16) >= 0.9d ? b.d(0.59f, 0.69f, (f16 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        float exp = z5 ? 1.0f : (1.0f - (((float) Math.exp(((-f5) - 42.0f) / 92.0f)) * 0.2777778f)) * f16;
        double d6 = exp;
        if (d6 > 1.0d) {
            exp = 1.0f;
        } else if (d6 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * exp) + 1.0f) - exp, (((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp};
        float f17 = 1.0f / ((5.0f * f5) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float cbrt = (f18 * f5) + (0.1f * f19 * f19 * ((float) Math.cbrt(f5 * 5.0d)));
        float h5 = b.h(f6) / fArr[1];
        double d7 = h5;
        float sqrt = ((float) Math.sqrt(d7)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d7, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f15) / 100.0d, 0.42d)};
        float f20 = fArr7[0];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[1];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[2];
        float[] fArr8 = {f21, f23, (400.0f * f24) / (f24 + 27.13f)};
        return new l(h5, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, d5, f16, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    float a() {
        return this.f18599a;
    }

    float b() {
        return this.f18602d;
    }

    float c() {
        return this.f18606h;
    }

    float d() {
        return this.f18607i;
    }

    float e() {
        return this.f18604f;
    }

    float f() {
        return this.f18600b;
    }

    float g() {
        return this.f18603e;
    }

    float h() {
        return this.f18601c;
    }

    float[] i() {
        return this.f18605g;
    }

    float j() {
        return this.f18608j;
    }
}
