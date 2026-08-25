package androidx.media3.common.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f8510a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8511b;

    /* renamed from: c, reason: collision with root package name */
    private final float f8512c;

    /* renamed from: d, reason: collision with root package name */
    private final float f8513d;

    /* renamed from: e, reason: collision with root package name */
    private final float f8514e;

    /* renamed from: f, reason: collision with root package name */
    private final int f8515f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8516g;

    /* renamed from: h, reason: collision with root package name */
    private final int f8517h;

    /* renamed from: i, reason: collision with root package name */
    private final short[] f8518i;

    /* renamed from: j, reason: collision with root package name */
    private short[] f8519j;

    /* renamed from: k, reason: collision with root package name */
    private int f8520k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f8521l;

    /* renamed from: m, reason: collision with root package name */
    private int f8522m;

    /* renamed from: n, reason: collision with root package name */
    private short[] f8523n;

    /* renamed from: o, reason: collision with root package name */
    private int f8524o;

    /* renamed from: p, reason: collision with root package name */
    private int f8525p;

    /* renamed from: q, reason: collision with root package name */
    private int f8526q;

    /* renamed from: r, reason: collision with root package name */
    private int f8527r;

    /* renamed from: s, reason: collision with root package name */
    private int f8528s;

    /* renamed from: t, reason: collision with root package name */
    private int f8529t;

    /* renamed from: u, reason: collision with root package name */
    private int f8530u;

    /* renamed from: v, reason: collision with root package name */
    private int f8531v;

    /* renamed from: w, reason: collision with root package name */
    private double f8532w;

    public c(int i5, int i6, float f5, float f6, int i7) {
        this.f8510a = i5;
        this.f8511b = i6;
        this.f8512c = f5;
        this.f8513d = f6;
        this.f8514e = i5 / i7;
        this.f8515f = i5 / 400;
        int i8 = i5 / 65;
        this.f8516g = i8;
        int i9 = i8 * 2;
        this.f8517h = i9;
        this.f8518i = new short[i9];
        this.f8519j = new short[i9 * i6];
        this.f8521l = new short[i9 * i6];
        this.f8523n = new short[i9 * i6];
    }

    private void a(float f5, int i5) {
        int i6;
        int i7;
        if (this.f8522m == i5) {
            return;
        }
        int i8 = this.f8510a;
        long j5 = (long) (i8 / f5);
        long j6 = i8;
        while (j5 != 0 && j6 != 0 && j5 % 2 == 0 && j6 % 2 == 0) {
            j5 /= 2;
            j6 /= 2;
        }
        o(i5);
        int i9 = 0;
        while (true) {
            int i10 = this.f8524o;
            if (i9 >= i10 - 1) {
                u(i10 - 1);
                return;
            }
            while (true) {
                i6 = this.f8525p;
                long j7 = (i6 + 1) * j5;
                i7 = this.f8526q;
                if (j7 <= i7 * j6) {
                    break;
                }
                this.f8521l = f(this.f8521l, this.f8522m, 1);
                int i11 = 0;
                while (true) {
                    int i12 = this.f8511b;
                    if (i11 < i12) {
                        this.f8521l[(this.f8522m * i12) + i11] = n(this.f8523n, (i12 * i9) + i11, j6, j5);
                        i11++;
                    }
                }
                this.f8526q++;
                this.f8522m++;
            }
            int i13 = i6 + 1;
            this.f8525p = i13;
            if (i13 == j6) {
                this.f8525p = 0;
                androidx.media3.common.util.a.g(((long) i7) == j5);
                this.f8526q = 0;
            }
            i9++;
        }
    }

    private void b(double d5) {
        int m5;
        int i5 = this.f8520k;
        if (i5 < this.f8517h) {
            return;
        }
        int i6 = 0;
        do {
            if (this.f8527r > 0) {
                m5 = c(i6);
            } else {
                int g5 = g(this.f8519j, i6);
                if (d5 > 1.0d) {
                    i6 += g5 + w(this.f8519j, i6, d5, g5);
                } else {
                    m5 = m(this.f8519j, i6, d5, g5);
                }
            }
            i6 += m5;
        } while (this.f8517h + i6 <= i5);
        v(i6);
    }

    private int c(int i5) {
        int min = Math.min(this.f8517h, this.f8527r);
        d(this.f8519j, i5, min);
        this.f8527r -= min;
        return min;
    }

    private void d(short[] sArr, int i5, int i6) {
        short[] f5 = f(this.f8521l, this.f8522m, i6);
        this.f8521l = f5;
        int i7 = this.f8511b;
        System.arraycopy(sArr, i5 * i7, f5, this.f8522m * i7, i7 * i6);
        this.f8522m += i6;
    }

    private void e(short[] sArr, int i5, int i6) {
        int i7 = this.f8517h / i6;
        int i8 = this.f8511b;
        int i9 = i6 * i8;
        int i10 = i5 * i8;
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = 0;
            for (int i13 = 0; i13 < i9; i13++) {
                i12 += sArr[(i11 * i9) + i10 + i13];
            }
            this.f8518i[i11] = (short) (i12 / i9);
        }
    }

    private short[] f(short[] sArr, int i5, int i6) {
        int length = sArr.length;
        int i7 = this.f8511b;
        int i8 = length / i7;
        return i5 + i6 <= i8 ? sArr : Arrays.copyOf(sArr, (((i8 * 3) / 2) + i6) * i7);
    }

    private int g(short[] sArr, int i5) {
        int i6;
        int i7 = this.f8510a;
        int i8 = i7 > 4000 ? i7 / 4000 : 1;
        if (this.f8511b == 1 && i8 == 1) {
            i6 = h(sArr, i5, this.f8515f, this.f8516g);
        } else {
            e(sArr, i5, i8);
            int h5 = h(this.f8518i, 0, this.f8515f / i8, this.f8516g / i8);
            if (i8 != 1) {
                int i9 = h5 * i8;
                int i10 = i8 * 4;
                int i11 = i9 - i10;
                int i12 = i9 + i10;
                int i13 = this.f8515f;
                if (i11 < i13) {
                    i11 = i13;
                }
                int i14 = this.f8516g;
                if (i12 > i14) {
                    i12 = i14;
                }
                if (this.f8511b == 1) {
                    i6 = h(sArr, i5, i11, i12);
                } else {
                    e(sArr, i5, 1);
                    i6 = h(this.f8518i, 0, i11, i12);
                }
            } else {
                i6 = h5;
            }
        }
        int i15 = q(this.f8530u, this.f8531v) ? this.f8528s : i6;
        this.f8529t = this.f8530u;
        this.f8528s = i6;
        return i15;
    }

    private int h(short[] sArr, int i5, int i6, int i7) {
        int i8 = i5 * this.f8511b;
        int i9 = 255;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        while (i6 <= i7) {
            int i13 = 0;
            for (int i14 = 0; i14 < i6; i14++) {
                i13 += Math.abs(sArr[i8 + i14] - sArr[(i8 + i6) + i14]);
            }
            if (i13 * i11 < i10 * i6) {
                i11 = i6;
                i10 = i13;
            }
            if (i13 * i9 > i12 * i6) {
                i9 = i6;
                i12 = i13;
            }
            i6++;
        }
        this.f8530u = i10 / i11;
        this.f8531v = i12 / i9;
        return i11;
    }

    private int m(short[] sArr, int i5, double d5, int i6) {
        int i7;
        if (d5 < 0.5d) {
            double d6 = ((i6 * d5) / (1.0d - d5)) + this.f8532w;
            i7 = (int) Math.round(d6);
            this.f8532w = d6 - i7;
        } else {
            double d7 = ((i6 * ((2.0d * d5) - 1.0d)) / (1.0d - d5)) + this.f8532w;
            int round = (int) Math.round(d7);
            this.f8527r = round;
            this.f8532w = d7 - round;
            i7 = i6;
        }
        int i8 = i6 + i7;
        short[] f5 = f(this.f8521l, this.f8522m, i8);
        this.f8521l = f5;
        int i9 = this.f8511b;
        System.arraycopy(sArr, i5 * i9, f5, this.f8522m * i9, i9 * i6);
        p(i7, this.f8511b, this.f8521l, this.f8522m + i6, sArr, i5 + i6, sArr, i5);
        this.f8522m += i8;
        return i7;
    }

    private short n(short[] sArr, int i5, long j5, long j6) {
        short s5 = sArr[i5];
        short s6 = sArr[i5 + this.f8511b];
        long j7 = this.f8526q * j5;
        long j8 = this.f8525p * j6;
        long j9 = (r7 + 1) * j6;
        long j10 = j9 - j7;
        long j11 = j9 - j8;
        return (short) (((s5 * j10) + ((j11 - j10) * s6)) / j11);
    }

    private void o(int i5) {
        int i6 = this.f8522m - i5;
        short[] f5 = f(this.f8523n, this.f8524o, i6);
        this.f8523n = f5;
        short[] sArr = this.f8521l;
        int i7 = this.f8511b;
        System.arraycopy(sArr, i5 * i7, f5, this.f8524o * i7, i7 * i6);
        this.f8522m = i5;
        this.f8524o += i6;
    }

    private static void p(int i5, int i6, short[] sArr, int i7, short[] sArr2, int i8, short[] sArr3, int i9) {
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i7 * i6) + i10;
            int i12 = (i9 * i6) + i10;
            int i13 = (i8 * i6) + i10;
            for (int i14 = 0; i14 < i5; i14++) {
                sArr[i11] = (short) (((sArr2[i13] * (i5 - i14)) + (sArr3[i12] * i14)) / i5);
                i11 += i6;
                i13 += i6;
                i12 += i6;
            }
        }
    }

    private boolean q(int i5, int i6) {
        return i5 != 0 && this.f8528s != 0 && i6 <= i5 * 3 && i5 * 2 > this.f8529t * 3;
    }

    private void r() {
        int i5 = this.f8522m;
        float f5 = this.f8512c;
        float f6 = this.f8513d;
        double d5 = f5 / f6;
        float f7 = this.f8514e * f6;
        if (d5 > 1.0000100135803223d || d5 < 0.9999899864196777d) {
            b(d5);
        } else {
            d(this.f8519j, 0, this.f8520k);
            this.f8520k = 0;
        }
        if (f7 != 1.0f) {
            a(f7, i5);
        }
    }

    private void u(int i5) {
        if (i5 == 0) {
            return;
        }
        short[] sArr = this.f8523n;
        int i6 = this.f8511b;
        System.arraycopy(sArr, i5 * i6, sArr, 0, (this.f8524o - i5) * i6);
        this.f8524o -= i5;
    }

    private void v(int i5) {
        int i6 = this.f8520k - i5;
        short[] sArr = this.f8519j;
        int i7 = this.f8511b;
        System.arraycopy(sArr, i5 * i7, sArr, 0, i7 * i6);
        this.f8520k = i6;
    }

    private int w(short[] sArr, int i5, double d5, int i6) {
        int i7;
        if (d5 >= 2.0d) {
            double d6 = (i6 / (d5 - 1.0d)) + this.f8532w;
            i7 = (int) Math.round(d6);
            this.f8532w = d6 - i7;
        } else {
            double d7 = ((i6 * (2.0d - d5)) / (d5 - 1.0d)) + this.f8532w;
            int round = (int) Math.round(d7);
            this.f8527r = round;
            this.f8532w = d7 - round;
            i7 = i6;
        }
        short[] f5 = f(this.f8521l, this.f8522m, i7);
        this.f8521l = f5;
        p(i7, this.f8511b, f5, this.f8522m, sArr, i5, sArr, i5 + i6);
        this.f8522m += i7;
        return i7;
    }

    public void i() {
        this.f8520k = 0;
        this.f8522m = 0;
        this.f8524o = 0;
        this.f8525p = 0;
        this.f8526q = 0;
        this.f8527r = 0;
        this.f8528s = 0;
        this.f8529t = 0;
        this.f8530u = 0;
        this.f8531v = 0;
        this.f8532w = 0.0d;
    }

    public void j(ShortBuffer shortBuffer) {
        androidx.media3.common.util.a.g(this.f8522m >= 0);
        int min = Math.min(shortBuffer.remaining() / this.f8511b, this.f8522m);
        shortBuffer.put(this.f8521l, 0, this.f8511b * min);
        int i5 = this.f8522m - min;
        this.f8522m = i5;
        short[] sArr = this.f8521l;
        int i6 = this.f8511b;
        System.arraycopy(sArr, min * i6, sArr, 0, i5 * i6);
    }

    public int k() {
        androidx.media3.common.util.a.g(this.f8522m >= 0);
        return this.f8522m * this.f8511b * 2;
    }

    public int l() {
        return this.f8520k * this.f8511b * 2;
    }

    public void s() {
        int i5;
        int i6 = this.f8520k;
        float f5 = this.f8512c;
        float f6 = this.f8513d;
        double d5 = f5 / f6;
        int i7 = this.f8522m + ((int) (((((((i6 - r5) / d5) + this.f8527r) + this.f8532w) + this.f8524o) / (this.f8514e * f6)) + 0.5d));
        this.f8532w = 0.0d;
        this.f8519j = f(this.f8519j, i6, (this.f8517h * 2) + i6);
        int i8 = 0;
        while (true) {
            i5 = this.f8517h;
            int i9 = this.f8511b;
            if (i8 >= i5 * 2 * i9) {
                break;
            }
            this.f8519j[(i9 * i6) + i8] = 0;
            i8++;
        }
        this.f8520k += i5 * 2;
        r();
        if (this.f8522m > i7) {
            this.f8522m = Math.max(i7, 0);
        }
        this.f8520k = 0;
        this.f8527r = 0;
        this.f8524o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i5 = this.f8511b;
        int i6 = remaining / i5;
        short[] f5 = f(this.f8519j, this.f8520k, i6);
        this.f8519j = f5;
        shortBuffer.get(f5, this.f8520k * this.f8511b, ((i5 * i6) * 2) / 2);
        this.f8520k += i6;
        r();
    }
}
