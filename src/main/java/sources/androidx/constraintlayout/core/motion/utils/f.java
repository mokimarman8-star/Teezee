package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class f extends b {

    /* renamed from: a, reason: collision with root package name */
    private double[] f5747a;

    /* renamed from: b, reason: collision with root package name */
    private double[][] f5748b;

    /* renamed from: c, reason: collision with root package name */
    private double[][] f5749c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5750d = true;

    /* renamed from: e, reason: collision with root package name */
    double[] f5751e;

    public f(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f5751e = new double[length2];
        int i5 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i5, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i6 = 0; i6 < length2; i6++) {
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 + 1;
                double d5 = dArr[i8] - dArr[i7];
                double[] dArr5 = dArr3[i7];
                double d6 = (dArr2[i8][i6] - dArr2[i7][i6]) / d5;
                dArr5[i6] = d6;
                if (i7 == 0) {
                    dArr4[i7][i6] = d6;
                } else {
                    dArr4[i7][i6] = (dArr3[i7 - 1][i6] + d6) * 0.5d;
                }
                i7 = i8;
            }
            dArr4[i5][i6] = dArr3[length - 2][i6];
        }
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < length2; i10++) {
                double d7 = dArr3[i9][i10];
                if (d7 == 0.0d) {
                    dArr4[i9][i10] = 0.0d;
                    dArr4[i9 + 1][i10] = 0.0d;
                } else {
                    double d8 = dArr4[i9][i10] / d7;
                    int i11 = i9 + 1;
                    double d9 = dArr4[i11][i10] / d7;
                    double hypot = Math.hypot(d8, d9);
                    if (hypot > 9.0d) {
                        double d10 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i9];
                        double[] dArr7 = dArr3[i9];
                        dArr6[i10] = d8 * d10 * dArr7[i10];
                        dArr4[i11][i10] = d10 * d9 * dArr7[i10];
                    }
                }
            }
        }
        this.f5747a = dArr;
        this.f5748b = dArr2;
        this.f5749c = dArr4;
    }

    public static f i(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i5 = 0;
        while (indexOf2 != -1) {
            dArr[i5] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i5++;
        }
        dArr[i5] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return j(Arrays.copyOf(dArr, i5 + 1));
    }

    private static f j(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d5 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d6 = dArr[i5];
            int i6 = i5 + length2;
            dArr2[i6][0] = d6;
            double d7 = i5 * d5;
            dArr3[i6] = d7;
            if (i5 > 0) {
                int i7 = (length2 * 2) + i5;
                dArr2[i7][0] = d6 + 1.0d;
                dArr3[i7] = d7 + 1.0d;
                int i8 = i5 - 1;
                dArr2[i8][0] = (d6 - 1.0d) - d5;
                dArr3[i8] = (d7 - 1.0d) - d5;
            }
        }
        return new f(dArr3, dArr2);
    }

    private static double k(double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d6 * 6.0d;
        double d13 = 3.0d * d5;
        return ((((((((((-6.0d) * d11) * d8) + (d12 * d8)) + ((6.0d * d11) * d7)) - (d12 * d7)) + ((d13 * d10) * d11)) + ((d13 * d9) * d11)) - (((2.0d * d5) * d10) * d6)) - (((4.0d * d5) * d9) * d6)) + (d5 * d9);
    }

    private static double l(double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d11 * d6;
        double d13 = 3.0d * d11;
        double d14 = ((((((-2.0d) * d12) * d8) + (d13 * d8)) + ((d12 * 2.0d) * d7)) - (d13 * d7)) + d7;
        double d15 = d5 * d10;
        double d16 = d5 * d9;
        return ((((d14 + (d15 * d12)) + (d12 * d16)) - (d15 * d11)) - (((d5 * 2.0d) * d9) * d11)) + (d16 * d6);
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d5, int i5) {
        double d6;
        double d7;
        double f5;
        double[] dArr = this.f5747a;
        int length = dArr.length;
        int i6 = 0;
        if (this.f5750d) {
            double d8 = dArr[0];
            if (d5 <= d8) {
                d6 = this.f5748b[0][i5];
                d7 = d5 - d8;
                f5 = f(d8, i5);
            } else {
                int i7 = length - 1;
                double d9 = dArr[i7];
                if (d5 >= d9) {
                    d6 = this.f5748b[i7][i5];
                    d7 = d5 - d9;
                    f5 = f(d9, i5);
                }
            }
            return d6 + (d7 * f5);
        }
        if (d5 <= dArr[0]) {
            return this.f5748b[0][i5];
        }
        int i8 = length - 1;
        if (d5 >= dArr[i8]) {
            return this.f5748b[i8][i5];
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.f5747a;
            double d10 = dArr2[i6];
            if (d5 == d10) {
                return this.f5748b[i6][i5];
            }
            int i9 = i6 + 1;
            double d11 = dArr2[i9];
            if (d5 < d11) {
                double d12 = d11 - d10;
                double d13 = (d5 - d10) / d12;
                double[][] dArr3 = this.f5748b;
                double d14 = dArr3[i6][i5];
                double d15 = dArr3[i9][i5];
                double[][] dArr4 = this.f5749c;
                return l(d12, d13, d14, d15, dArr4[i6][i5], dArr4[i9][i5]);
            }
            i6 = i9;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d5, double[] dArr) {
        double[] dArr2 = this.f5747a;
        int length = dArr2.length;
        int i5 = 0;
        int length2 = this.f5748b[0].length;
        if (this.f5750d) {
            double d6 = dArr2[0];
            if (d5 <= d6) {
                g(d6, this.f5751e);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.f5748b[0][i6] + ((d5 - this.f5747a[0]) * this.f5751e[i6]);
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr2[i7];
            if (d5 >= d7) {
                g(d7, this.f5751e);
                while (i5 < length2) {
                    dArr[i5] = this.f5748b[i7][i5] + ((d5 - this.f5747a[i7]) * this.f5751e[i5]);
                    i5++;
                }
                return;
            }
        } else {
            if (d5 <= dArr2[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f5748b[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d5 >= dArr2[i9]) {
                while (i5 < length2) {
                    dArr[i5] = this.f5748b[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d5 == this.f5747a[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f5748b[i10][i11];
                }
            }
            double[] dArr3 = this.f5747a;
            int i12 = i10 + 1;
            double d8 = dArr3[i12];
            if (d5 < d8) {
                double d9 = dArr3[i10];
                double d10 = d8 - d9;
                double d11 = (d5 - d9) / d10;
                while (i5 < length2) {
                    double[][] dArr4 = this.f5748b;
                    double d12 = dArr4[i10][i5];
                    double d13 = dArr4[i12][i5];
                    double[][] dArr5 = this.f5749c;
                    dArr[i5] = l(d10, d11, d12, d13, dArr5[i10][i5], dArr5[i12][i5]);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d5, float[] fArr) {
        double[] dArr = this.f5747a;
        int length = dArr.length;
        int i5 = 0;
        int length2 = this.f5748b[0].length;
        if (this.f5750d) {
            double d6 = dArr[0];
            if (d5 <= d6) {
                g(d6, this.f5751e);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (this.f5748b[0][i6] + ((d5 - this.f5747a[0]) * this.f5751e[i6]));
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr[i7];
            if (d5 >= d7) {
                g(d7, this.f5751e);
                while (i5 < length2) {
                    fArr[i5] = (float) (this.f5748b[i7][i5] + ((d5 - this.f5747a[i7]) * this.f5751e[i5]));
                    i5++;
                }
                return;
            }
        } else {
            if (d5 <= dArr[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.f5748b[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d5 >= dArr[i9]) {
                while (i5 < length2) {
                    fArr[i5] = (float) this.f5748b[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d5 == this.f5747a[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.f5748b[i10][i11];
                }
            }
            double[] dArr2 = this.f5747a;
            int i12 = i10 + 1;
            double d8 = dArr2[i12];
            if (d5 < d8) {
                double d9 = dArr2[i10];
                double d10 = d8 - d9;
                double d11 = (d5 - d9) / d10;
                while (i5 < length2) {
                    double[][] dArr3 = this.f5748b;
                    double d12 = dArr3[i10][i5];
                    double d13 = dArr3[i12][i5];
                    double[][] dArr4 = this.f5749c;
                    fArr[i5] = (float) l(d10, d11, d12, d13, dArr4[i10][i5], dArr4[i12][i5]);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d5, int i5) {
        double[] dArr = this.f5747a;
        int length = dArr.length;
        int i6 = 0;
        double d6 = dArr[0];
        if (d5 >= d6) {
            d6 = dArr[length - 1];
            if (d5 < d6) {
                d6 = d5;
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.f5747a;
            int i7 = i6 + 1;
            double d7 = dArr2[i7];
            if (d6 <= d7) {
                double d8 = dArr2[i6];
                double d9 = d7 - d8;
                double[][] dArr3 = this.f5748b;
                double d10 = dArr3[i6][i5];
                double d11 = dArr3[i7][i5];
                double[][] dArr4 = this.f5749c;
                return k(d9, (d6 - d8) / d9, d10, d11, dArr4[i6][i5], dArr4[i7][i5]) / d9;
            }
            i6 = i7;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d5, double[] dArr) {
        double[] dArr2 = this.f5747a;
        int length = dArr2.length;
        int length2 = this.f5748b[0].length;
        double d6 = dArr2[0];
        if (d5 > d6) {
            d6 = dArr2[length - 1];
            if (d5 < d6) {
                d6 = d5;
            }
        }
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.f5747a;
            int i6 = i5 + 1;
            double d7 = dArr3[i6];
            if (d6 <= d7) {
                double d8 = dArr3[i5];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.f5748b;
                    double d11 = dArr4[i5][i7];
                    double d12 = dArr4[i6][i7];
                    double[][] dArr5 = this.f5749c;
                    dArr[i7] = k(d9, d10, d11, d12, dArr5[i5][i7], dArr5[i6][i7]) / d9;
                }
                return;
            }
            i5 = i6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f5747a;
    }
}
