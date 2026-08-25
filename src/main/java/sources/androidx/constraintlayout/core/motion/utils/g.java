package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    double[] f5754c;

    /* renamed from: d, reason: collision with root package name */
    String f5755d;

    /* renamed from: e, reason: collision with root package name */
    f f5756e;

    /* renamed from: f, reason: collision with root package name */
    int f5757f;

    /* renamed from: a, reason: collision with root package name */
    float[] f5752a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    double[] f5753b = new double[0];

    /* renamed from: g, reason: collision with root package name */
    double f5758g = 6.283185307179586d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5759h = false;

    public void a(double d5, float f5) {
        int length = this.f5752a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f5753b, d5);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f5753b = Arrays.copyOf(this.f5753b, length);
        this.f5752a = Arrays.copyOf(this.f5752a, length);
        this.f5754c = new double[length];
        double[] dArr = this.f5753b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f5753b[binarySearch] = d5;
        this.f5752a[binarySearch] = f5;
        this.f5759h = false;
    }

    double b(double d5) {
        if (d5 <= 0.0d) {
            d5 = 1.0E-5d;
        } else if (d5 >= 1.0d) {
            d5 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f5753b, d5);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i5 = -binarySearch;
        int i6 = i5 - 1;
        float[] fArr = this.f5752a;
        float f5 = fArr[i6];
        int i7 = i5 - 2;
        float f6 = fArr[i7];
        double[] dArr = this.f5753b;
        double d6 = dArr[i6];
        double d7 = dArr[i7];
        double d8 = (f5 - f6) / (d6 - d7);
        return (d5 * d8) + (f6 - (d8 * d7));
    }

    double c(double d5) {
        if (d5 < 0.0d) {
            d5 = 0.0d;
        } else if (d5 > 1.0d) {
            d5 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f5753b, d5);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i5 = -binarySearch;
        int i6 = i5 - 1;
        float[] fArr = this.f5752a;
        float f5 = fArr[i6];
        int i7 = i5 - 2;
        float f6 = fArr[i7];
        double[] dArr = this.f5753b;
        double d6 = dArr[i6];
        double d7 = dArr[i7];
        double d8 = (f5 - f6) / (d6 - d7);
        return this.f5754c[i7] + ((f6 - (d8 * d7)) * (d5 - d7)) + ((d8 * ((d5 * d5) - (d7 * d7))) / 2.0d);
    }

    public double d(double d5, double d6, double d7) {
        double c5 = d6 + c(d5);
        double b5 = b(d5) + d7;
        switch (this.f5757f) {
            case 1:
                return 0.0d;
            case 2:
                return b5 * 4.0d * Math.signum((((c5 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b5 * 2.0d;
            case 4:
                return (-b5) * 2.0d;
            case 5:
                double d8 = this.f5758g;
                return (-d8) * b5 * Math.sin(d8 * c5);
            case 6:
                return b5 * 4.0d * ((((c5 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f5756e.f(c5 % 1.0d, 0);
            default:
                double d9 = this.f5758g;
                return b5 * d9 * Math.cos(d9 * c5);
        }
    }

    public double e(double d5, double d6) {
        double abs;
        double c5 = c(d5) + d6;
        switch (this.f5757f) {
            case 1:
                return Math.signum(0.5d - (c5 % 1.0d));
            case 2:
                abs = Math.abs((((c5 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c5 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c5 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f5758g * (d6 + c5));
            case 6:
                double abs2 = 1.0d - Math.abs(((c5 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f5756e.c(c5 % 1.0d, 0);
            default:
                return Math.sin(this.f5758g * c5);
        }
        return 1.0d - abs;
    }

    public void f() {
        double d5 = 0.0d;
        int i5 = 0;
        while (true) {
            if (i5 >= this.f5752a.length) {
                break;
            }
            d5 += r7[i5];
            i5++;
        }
        double d6 = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr = this.f5752a;
            if (i6 >= fArr.length) {
                break;
            }
            int i7 = i6 - 1;
            float f5 = (fArr[i7] + fArr[i6]) / 2.0f;
            double[] dArr = this.f5753b;
            d6 += (dArr[i6] - dArr[i7]) * f5;
            i6++;
        }
        int i8 = 0;
        while (true) {
            float[] fArr2 = this.f5752a;
            if (i8 >= fArr2.length) {
                break;
            }
            fArr2[i8] = (float) (fArr2[i8] * (d5 / d6));
            i8++;
        }
        this.f5754c[0] = 0.0d;
        int i9 = 1;
        while (true) {
            float[] fArr3 = this.f5752a;
            if (i9 >= fArr3.length) {
                this.f5759h = true;
                return;
            }
            int i10 = i9 - 1;
            float f6 = (fArr3[i10] + fArr3[i9]) / 2.0f;
            double[] dArr2 = this.f5753b;
            double d7 = dArr2[i9] - dArr2[i10];
            double[] dArr3 = this.f5754c;
            dArr3[i9] = dArr3[i10] + (d7 * f6);
            i9++;
        }
    }

    public void g(int i5, String str) {
        this.f5757f = i5;
        this.f5755d = str;
        if (str != null) {
            this.f5756e = f.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f5753b) + " period=" + Arrays.toString(this.f5752a);
    }
}
