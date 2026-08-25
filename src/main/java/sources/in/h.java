package in;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class h {
    private final int a;
    private final int b;
    private final float c;
    private final float d;
    private float e;
    private final float f;
    private final int g;
    private final int h;
    private final int i;
    private final short[] j;
    private short[] k;
    private int l;
    private short[] m;
    private int n;
    private short[] o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;

    public h(int i, int i2, float f, float f2, float f3, int i3) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = i / i3;
        this.g = i / 400;
        int i4 = i / 65;
        this.h = i4;
        int i5 = i4 * 2;
        this.i = i5;
        this.j = new short[i5];
        this.k = new short[i5 * i2];
        this.m = new short[i5 * i2];
        this.o = new short[i5 * i2];
    }

    private void a(float f, int i) {
        int i2;
        int i3;
        if (this.n == i) {
            return;
        }
        int i4 = this.a;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        n(i);
        int i6 = 0;
        while (true) {
            int i7 = this.p;
            if (i6 >= i7 - 1) {
                t(i7 - 1);
                return;
            }
            while (true) {
                i2 = this.q;
                int i8 = (i2 + 1) * i5;
                i3 = this.r;
                if (i8 <= i3 * i4) {
                    break;
                }
                this.m = f(this.m, this.n, 1);
                int i9 = 0;
                while (true) {
                    int i10 = this.b;
                    if (i9 < i10) {
                        this.m[(this.n * i10) + i9] = m(this.o, (i10 * i6) + i9, i4, i5);
                        i9++;
                    }
                }
                this.r++;
                this.n++;
            }
            int i11 = i2 + 1;
            this.q = i11;
            if (i11 == i4) {
                this.q = 0;
                androidx.media3.common.util.a.g(i3 == i5);
                this.r = 0;
            }
            i6++;
        }
    }

    private void b(float f) {
        int x;
        int i = this.l;
        if (i < this.i) {
            return;
        }
        int i2 = 0;
        do {
            if (this.s > 0) {
                x = c(i2);
            } else {
                int g = g(this.k, i2);
                x = ((double) f) > 1.0d ? g + x(this.k, i2, f, g) : l(this.k, i2, f, g);
            }
            i2 += x;
        } while (this.i + i2 <= i);
        u(i2);
    }

    private int c(int i) {
        int min = Math.min(this.i, this.s);
        d(this.k, i, min);
        this.s -= min;
        return min;
    }

    private void d(short[] sArr, int i, int i2) {
        short[] f = f(this.m, this.n, i2);
        this.m = f;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, f, this.n * i3, i3 * i2);
        this.n += i2;
    }

    private void e(short[] sArr, int i, int i2) {
        int i3 = this.i / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.j[i7] = (short) (i8 / i5);
        }
    }

    private short[] f(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private int g(short[] sArr, int i) {
        int i2;
        int i3 = this.a;
        int i4 = i3 > 4000 ? i3 / 4000 : 1;
        if (this.b == 1 && i4 == 1) {
            i2 = h(sArr, i, this.g, this.h);
        } else {
            e(sArr, i, i4);
            int h = h(this.j, 0, this.g / i4, this.h / i4);
            if (i4 != 1) {
                int i5 = h * i4;
                int i6 = i4 * 4;
                int i7 = i5 - i6;
                int i8 = i5 + i6;
                int i9 = this.g;
                if (i7 < i9) {
                    i7 = i9;
                }
                int i10 = this.h;
                if (i8 > i10) {
                    i8 = i10;
                }
                if (this.b == 1) {
                    i2 = h(sArr, i, i7, i8);
                } else {
                    e(sArr, i, 1);
                    i2 = h(this.j, 0, i7, i8);
                }
            } else {
                i2 = h;
            }
        }
        int i11 = p(this.v, this.w) ? this.t : i2;
        this.u = this.v;
        this.t = i2;
        return i11;
    }

    private int h(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            if (i9 * i7 < i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            if (i9 * i5 > i8 * i2) {
                i5 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.v = i6 / i7;
        this.w = i8 / i5;
        return i7;
    }

    private int l(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.s = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        short[] f2 = f(this.m, this.n, i4);
        this.m = f2;
        int i5 = this.b;
        System.arraycopy(sArr, i * i5, f2, this.n * i5, i5 * i2);
        o(i3, this.b, this.m, this.n + i2, sArr, i + i2, sArr, i);
        this.n += i4;
        return i3;
    }

    private short m(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[i + this.b];
        int i4 = this.r * i2;
        int i5 = this.q;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s * i8) + ((i9 - i8) * s2)) / i9);
    }

    private void n(int i) {
        int i2 = this.n - i;
        short[] f = f(this.o, this.p, i2);
        this.o = f;
        short[] sArr = this.m;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, f, this.p * i3, i3 * i2);
        this.n = i;
        this.p += i2;
    }

    private static void o(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    private boolean p(int i, int i2) {
        return i != 0 && this.t != 0 && i2 <= i * 3 && i * 2 > this.u * 3;
    }

    private void q() {
        int i = this.n;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.f * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            b(f3);
        } else {
            d(this.k, 0, this.l);
            this.l = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
        float f5 = this.e;
        if (f5 != 1.0f) {
            v(this.m, i, this.n - i, f5);
        }
    }

    private void t(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.o;
        int i2 = this.b;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.p - i) * i2);
        this.p -= i;
    }

    private void u(int i) {
        int i2 = this.l - i;
        short[] sArr = this.k;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.l = i2;
    }

    private void v(short[] sArr, int i, int i2, float f) {
        int i3 = (int) (f * 4096.0f);
        int i4 = this.b;
        int i5 = i * i4;
        int i6 = (i2 * i4) + i5;
        while (i5 < i6) {
            int i7 = (sArr[i5] * i3) >> 12;
            int i8 = 32767;
            if (i7 <= 32767) {
                i8 = -32767;
                if (i7 >= -32767) {
                    sArr[i5] = (short) i7;
                    i5++;
                }
            }
            i7 = i8;
            sArr[i5] = (short) i7;
            i5++;
        }
    }

    private int x(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.s = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        short[] f2 = f(this.m, this.n, i3);
        this.m = f2;
        o(i3, this.b, f2, this.n, sArr, i, sArr, i + i2);
        this.n += i3;
        return i3;
    }

    public void i() {
        this.l = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.b, this.n);
        shortBuffer.put(this.m, 0, this.b * min);
        int i = this.n - min;
        this.n = i;
        short[] sArr = this.m;
        int i2 = this.b;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public int k() {
        return this.n * this.b * 2;
    }

    public void r() {
        int i;
        int i2 = this.l;
        float f = this.c;
        float f2 = this.d;
        int i3 = this.n + ((int) ((((i2 / (f / f2)) + this.p) / (this.f * f2)) + 0.5f));
        this.k = f(this.k, i2, (this.i * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.i;
            int i5 = this.b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.k[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.l += i * 2;
        q();
        if (this.n > i3) {
            this.n = i3;
        }
        this.l = 0;
        this.s = 0;
        this.p = 0;
    }

    public void s(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = remaining / i;
        short[] f = f(this.k, this.l, i2);
        this.k = f;
        shortBuffer.get(f, this.l * this.b, ((i * i2) * 2) / 2);
        this.l += i2;
        q();
    }

    public void w(float f) {
        this.e = f;
    }
}
