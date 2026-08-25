package z0;

import android.graphics.Color;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f18716a = new ThreadLocal();

    public static void a(int i5, int i6, int i7, float[] fArr) {
        float f5;
        float abs;
        float f6 = i5 / 255.0f;
        float f7 = i6 / 255.0f;
        float f8 = i7 / 255.0f;
        float max = Math.max(f6, Math.max(f7, f8));
        float min = Math.min(f6, Math.min(f7, f8));
        float f9 = max - min;
        float f10 = (max + min) / 2.0f;
        if (max == min) {
            f5 = 0.0f;
            abs = 0.0f;
        } else {
            f5 = max == f6 ? ((f7 - f8) / f9) % 6.0f : max == f7 ? ((f8 - f6) / f9) + 2.0f : 4.0f + ((f6 - f7) / f9);
            abs = f9 / (1.0f - Math.abs((2.0f * f10) - 1.0f));
        }
        float f11 = (f5 * 60.0f) % 360.0f;
        if (f11 < 0.0f) {
            f11 += 360.0f;
        }
        fArr[0] = m(f11, 0.0f, 360.0f);
        fArr[1] = m(abs, 0.0f, 1.0f);
        fArr[2] = m(f10, 0.0f, 1.0f);
    }

    public static void b(int i5, int i6, int i7, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d5 = i5 / 255.0d;
        double pow = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        double d6 = i6 / 255.0d;
        double pow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = i7 / 255.0d;
        double pow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
    }

    public static int c(double d5, double d6, double d7) {
        double d8 = (((3.2406d * d5) + ((-1.5372d) * d6)) + ((-0.4986d) * d7)) / 100.0d;
        double d9 = ((((-0.9689d) * d5) + (1.8758d * d6)) + (0.0415d * d7)) / 100.0d;
        double d10 = (((0.0557d * d5) + ((-0.204d) * d6)) + (1.057d * d7)) / 100.0d;
        return Color.rgb(n((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255), n((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255), n((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, 255));
    }

    public static int d(int i5, int i6, float f5) {
        float f6 = 1.0f - f5;
        return Color.argb((int) ((Color.alpha(i5) * f6) + (Color.alpha(i6) * f5)), (int) ((Color.red(i5) * f6) + (Color.red(i6) * f5)), (int) ((Color.green(i5) * f6) + (Color.green(i6) * f5)), (int) ((Color.blue(i5) * f6) + (Color.blue(i6) * f5)));
    }

    public static double e(int i5, int i6) {
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        if (Color.alpha(i5) < 255) {
            i5 = k(i5, i6);
        }
        double f5 = f(i5) + 0.05d;
        double f6 = f(i6) + 0.05d;
        return Math.max(f5, f6) / Math.min(f5, f6);
    }

    public static double f(int i5) {
        double[] o5 = o();
        i(i5, o5);
        return o5[1] / 100.0d;
    }

    public static int g(int i5, int i6, float f5) {
        int i7 = 255;
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        double d5 = f5;
        if (e(p(i5, 255), i6) < d5) {
            return -1;
        }
        int i8 = 0;
        for (int i9 = 0; i9 <= 10 && i7 - i8 > 1; i9++) {
            int i10 = (i8 + i7) / 2;
            if (e(p(i5, i10), i6) < d5) {
                i8 = i10;
            } else {
                i7 = i10;
            }
        }
        return i7;
    }

    public static void h(int i5, float[] fArr) {
        a(Color.red(i5), Color.green(i5), Color.blue(i5), fArr);
    }

    public static void i(int i5, double[] dArr) {
        b(Color.red(i5), Color.green(i5), Color.blue(i5), dArr);
    }

    private static int j(int i5, int i6) {
        return 255 - (((255 - i6) * (255 - i5)) / 255);
    }

    public static int k(int i5, int i6) {
        int alpha = Color.alpha(i6);
        int alpha2 = Color.alpha(i5);
        int j5 = j(alpha2, alpha);
        return Color.argb(j5, l(Color.red(i5), alpha2, Color.red(i6), alpha, j5), l(Color.green(i5), alpha2, Color.green(i6), alpha, j5), l(Color.blue(i5), alpha2, Color.blue(i6), alpha, j5));
    }

    private static int l(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            return 0;
        }
        return (((i5 * 255) * i6) + ((i7 * i8) * (255 - i6))) / (i9 * 255);
    }

    private static float m(float f5, float f6, float f7) {
        return f5 < f6 ? f6 : Math.min(f5, f7);
    }

    private static int n(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }

    private static double[] o() {
        ThreadLocal threadLocal = f18716a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int p(int i5, int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i5 & 16777215) | (i6 << 24);
    }
}
