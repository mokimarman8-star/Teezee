package y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final float f18552a;

    /* renamed from: b, reason: collision with root package name */
    private final float f18553b;

    /* renamed from: c, reason: collision with root package name */
    private final float f18554c;

    /* renamed from: d, reason: collision with root package name */
    private final float f18555d;

    /* renamed from: e, reason: collision with root package name */
    private final float f18556e;

    /* renamed from: f, reason: collision with root package name */
    private final float f18557f;

    /* renamed from: g, reason: collision with root package name */
    private final float f18558g;

    /* renamed from: h, reason: collision with root package name */
    private final float f18559h;

    /* renamed from: i, reason: collision with root package name */
    private final float f18560i;

    a(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f18552a = f5;
        this.f18553b = f6;
        this.f18554c = f7;
        this.f18555d = f8;
        this.f18556e = f9;
        this.f18557f = f10;
        this.f18558g = f11;
        this.f18559h = f12;
        this.f18560i = f13;
    }

    private static a b(float f5, float f6, float f7) {
        float f8 = 100.0f;
        float f9 = 1000.0f;
        float f10 = 0.0f;
        a aVar = null;
        float f11 = 1000.0f;
        while (Math.abs(f10 - f8) > 0.01f) {
            float f12 = ((f8 - f10) / 2.0f) + f10;
            int p5 = e(f12, f6, f5).p();
            float b5 = b.b(p5);
            float abs = Math.abs(f7 - b5);
            if (abs < 0.2f) {
                a c5 = c(p5);
                float a5 = c5.a(e(c5.k(), c5.i(), f5));
                if (a5 <= 1.0f) {
                    aVar = c5;
                    f9 = abs;
                    f11 = a5;
                }
            }
            if (f9 == 0.0f && f11 == 0.0f) {
                break;
            }
            if (b5 < f7) {
                f10 = f12;
            } else {
                f8 = f12;
            }
        }
        return aVar;
    }

    static a c(int i5) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i5, l.f18598k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i5, l lVar, float[] fArr, float[] fArr2) {
        b.f(i5, fArr2);
        float[][] fArr3 = b.f18561a;
        float f5 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f6 = fArr4[0] * f5;
        float f7 = fArr2[1];
        float f8 = f6 + (fArr4[1] * f7);
        float f9 = fArr2[2];
        float f10 = f8 + (fArr4[2] * f9);
        float[] fArr5 = fArr3[1];
        float f11 = (fArr5[0] * f5) + (fArr5[1] * f7) + (fArr5[2] * f9);
        float[] fArr6 = fArr3[2];
        float f12 = (f5 * fArr6[0]) + (f7 * fArr6[1]) + (f9 * fArr6[2]);
        float f13 = lVar.i()[0] * f10;
        float f14 = lVar.i()[1] * f11;
        float f15 = lVar.i()[2] * f12;
        float pow = (float) Math.pow((lVar.c() * Math.abs(f13)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((lVar.c() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((lVar.c() * Math.abs(f15)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d5 = signum3;
        float f16 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d5)) / 11.0f;
        float f17 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = (((signum * 20.0f) + f18) + (21.0f * signum3)) / 20.0f;
        float f20 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f21 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f20 * lVar.f()) / lVar.a(), lVar.b() * lVar.j())) * 100.0f;
        float b5 = (4.0f / lVar.b()) * ((float) Math.sqrt(pow4 / 100.0f)) * (lVar.a() + 4.0f) * lVar.d();
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.g()) * lVar.h()) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d));
        float d6 = lVar.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((r7 * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f22 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * d6) + 1.0f)) * 43.85965f;
        double d7 = f21;
        float cos = ((float) Math.cos(d7)) * log;
        float sin = log * ((float) Math.sin(d7));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = b5;
            fArr[2] = d6;
            fArr[3] = sqrt2;
            fArr[4] = f22;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static a e(float f5, float f6, float f7) {
        return f(f5, f6, f7, l.f18598k);
    }

    private static a f(float f5, float f6, float f7, l lVar) {
        float b5 = (4.0f / lVar.b()) * ((float) Math.sqrt(f5 / 100.0d)) * (lVar.a() + 4.0f) * lVar.d();
        float d5 = f6 * lVar.d();
        float sqrt = ((float) Math.sqrt(((f6 / ((float) Math.sqrt(r4))) * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f8 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float log = ((float) Math.log((d5 * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (3.1415927f * f7) / 180.0f;
        return new a(f7, f6, f5, b5, d5, sqrt, f8, log * ((float) Math.cos(d6)), log * ((float) Math.sin(d6)));
    }

    public static int m(float f5, float f6, float f7) {
        return n(f5, f6, f7, l.f18598k);
    }

    static int n(float f5, float f6, float f7, l lVar) {
        if (f6 < 1.0d || Math.round(f7) <= 0.0d || Math.round(f7) >= 100.0d) {
            return b.a(f7);
        }
        float min = f5 < 0.0f ? 0.0f : Math.min(360.0f, f5);
        a aVar = null;
        boolean z5 = true;
        float f8 = 0.0f;
        float f9 = f6;
        while (Math.abs(f8 - f6) >= 0.4f) {
            a b5 = b(min, f9, f7);
            if (!z5) {
                if (b5 == null) {
                    f6 = f9;
                } else {
                    f8 = f9;
                    aVar = b5;
                }
                f9 = ((f6 - f8) / 2.0f) + f8;
            } else {
                if (b5 != null) {
                    return b5.o(lVar);
                }
                f9 = ((f6 - f8) / 2.0f) + f8;
                z5 = false;
            }
        }
        return aVar == null ? b.a(f7) : aVar.o(lVar);
    }

    float a(a aVar) {
        float l5 = l() - aVar.l();
        float g5 = g() - aVar.g();
        float h5 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((l5 * l5) + (g5 * g5) + (h5 * h5)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f18559h;
    }

    float h() {
        return this.f18560i;
    }

    float i() {
        return this.f18553b;
    }

    float j() {
        return this.f18552a;
    }

    float k() {
        return this.f18554c;
    }

    float l() {
        return this.f18558g;
    }

    int o(l lVar) {
        float pow = (float) Math.pow(((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(k() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d), 1.1111111111111112d);
        double j5 = (j() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(2.0d + j5) + 3.8d)) * 0.25f;
        float a5 = lVar.a() * ((float) Math.pow(k() / 100.0d, (1.0d / lVar.b()) / lVar.j()));
        float g5 = cos * 3846.1538f * lVar.g() * lVar.h();
        float f5 = a5 / lVar.f();
        float sin = (float) Math.sin(j5);
        float cos2 = (float) Math.cos(j5);
        float f6 = (((0.305f + f5) * 23.0f) * pow) / (((g5 * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f7 = cos2 * f6;
        float f8 = f6 * sin;
        float f9 = f5 * 460.0f;
        float f10 = (((451.0f * f7) + f9) + (288.0f * f8)) / 1403.0f;
        float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
        float signum = Math.signum(f10) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f10) * 27.13d) / (400.0d - Math.abs(f10))), 2.380952380952381d));
        float signum2 = Math.signum(f11) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
        float signum3 = Math.signum(((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f12 = signum / lVar.i()[0];
        float f13 = signum2 / lVar.i()[1];
        float f14 = signum3 / lVar.i()[2];
        float[][] fArr = b.f18562b;
        float[] fArr2 = fArr[0];
        float f15 = (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f12) + (fArr3[1] * f13) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        return z0.b.c(f15, f16, (f12 * fArr4[0]) + (f13 * fArr4[1]) + (f14 * fArr4[2]));
    }

    int p() {
        return o(l.f18598k);
    }
}
