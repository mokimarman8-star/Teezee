package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    private double[] f5742a;

    /* renamed from: b, reason: collision with root package name */
    private double[][] f5743b;

    /* renamed from: c, reason: collision with root package name */
    private double f5744c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5745d = true;

    /* renamed from: e, reason: collision with root package name */
    double[] f5746e;

    public e(double[] dArr, double[][] dArr2) {
        this.f5744c = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f5746e = new double[length2];
        this.f5742a = dArr;
        this.f5743b = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i5 = 0;
        double d5 = 0.0d;
        while (true) {
            double d6 = d5;
            if (i5 >= dArr.length) {
                this.f5744c = 0.0d;
                return;
            }
            double d7 = dArr2[i5][0];
            if (i5 > 0) {
                Math.hypot(d7 - d5, d7 - d6);
            }
            i5++;
            d5 = d7;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d5, int i5) {
        double d6;
        double d7;
        double f5;
        double[] dArr = this.f5742a;
        int length = dArr.length;
        int i6 = 0;
        if (this.f5745d) {
            double d8 = dArr[0];
            if (d5 <= d8) {
                d6 = this.f5743b[0][i5];
                d7 = d5 - d8;
                f5 = f(d8, i5);
            } else {
                int i7 = length - 1;
                double d9 = dArr[i7];
                if (d5 >= d9) {
                    d6 = this.f5743b[i7][i5];
                    d7 = d5 - d9;
                    f5 = f(d9, i5);
                }
            }
            return d6 + (d7 * f5);
        }
        if (d5 <= dArr[0]) {
            return this.f5743b[0][i5];
        }
        int i8 = length - 1;
        if (d5 >= dArr[i8]) {
            return this.f5743b[i8][i5];
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.f5742a;
            double d10 = dArr2[i6];
            if (d5 == d10) {
                return this.f5743b[i6][i5];
            }
            int i9 = i6 + 1;
            double d11 = dArr2[i9];
            if (d5 < d11) {
                double d12 = (d5 - d10) / (d11 - d10);
                double[][] dArr3 = this.f5743b;
                return (dArr3[i6][i5] * (1.0d - d12)) + (dArr3[i9][i5] * d12);
            }
            i6 = i9;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d5, double[] dArr) {
        double[] dArr2 = this.f5742a;
        int length = dArr2.length;
        int i5 = 0;
        int length2 = this.f5743b[0].length;
        if (this.f5745d) {
            double d6 = dArr2[0];
            if (d5 <= d6) {
                g(d6, this.f5746e);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.f5743b[0][i6] + ((d5 - this.f5742a[0]) * this.f5746e[i6]);
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr2[i7];
            if (d5 >= d7) {
                g(d7, this.f5746e);
                while (i5 < length2) {
                    dArr[i5] = this.f5743b[i7][i5] + ((d5 - this.f5742a[i7]) * this.f5746e[i5]);
                    i5++;
                }
                return;
            }
        } else {
            if (d5 <= dArr2[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f5743b[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d5 >= dArr2[i9]) {
                while (i5 < length2) {
                    dArr[i5] = this.f5743b[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d5 == this.f5742a[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f5743b[i10][i11];
                }
            }
            double[] dArr3 = this.f5742a;
            int i12 = i10 + 1;
            double d8 = dArr3[i12];
            if (d5 < d8) {
                double d9 = dArr3[i10];
                double d10 = (d5 - d9) / (d8 - d9);
                while (i5 < length2) {
                    double[][] dArr4 = this.f5743b;
                    dArr[i5] = (dArr4[i10][i5] * (1.0d - d10)) + (dArr4[i12][i5] * d10);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d5, float[] fArr) {
        double[] dArr = this.f5742a;
        int length = dArr.length;
        int i5 = 0;
        int length2 = this.f5743b[0].length;
        if (this.f5745d) {
            double d6 = dArr[0];
            if (d5 <= d6) {
                g(d6, this.f5746e);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (this.f5743b[0][i6] + ((d5 - this.f5742a[0]) * this.f5746e[i6]));
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr[i7];
            if (d5 >= d7) {
                g(d7, this.f5746e);
                while (i5 < length2) {
                    fArr[i5] = (float) (this.f5743b[i7][i5] + ((d5 - this.f5742a[i7]) * this.f5746e[i5]));
                    i5++;
                }
                return;
            }
        } else {
            if (d5 <= dArr[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.f5743b[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d5 >= dArr[i9]) {
                while (i5 < length2) {
                    fArr[i5] = (float) this.f5743b[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d5 == this.f5742a[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.f5743b[i10][i11];
                }
            }
            double[] dArr2 = this.f5742a;
            int i12 = i10 + 1;
            double d8 = dArr2[i12];
            if (d5 < d8) {
                double d9 = dArr2[i10];
                double d10 = (d5 - d9) / (d8 - d9);
                while (i5 < length2) {
                    double[][] dArr3 = this.f5743b;
                    fArr[i5] = (float) ((dArr3[i10][i5] * (1.0d - d10)) + (dArr3[i12][i5] * d10));
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double f(double d5, int i5) {
        double[] dArr = this.f5742a;
        int length = dArr.length;
        int i6 = 0;
        double d6 = dArr[0];
        if (d5 >= d6) {
            d6 = dArr[length - 1];
        }
        d5 = d6;
        while (i6 < length - 1) {
            double[] dArr2 = this.f5742a;
            int i7 = i6 + 1;
            double d7 = dArr2[i7];
            if (d5 <= d7) {
                double d8 = d7 - dArr2[i6];
                double[][] dArr3 = this.f5743b;
                return (dArr3[i7][i5] - dArr3[i6][i5]) / d8;
            }
            i6 = i7;
        }
        return 0.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(double d5, double[] dArr) {
        double[] dArr2 = this.f5742a;
        int length = dArr2.length;
        int length2 = this.f5743b[0].length;
        double d6 = dArr2[0];
        if (d5 > d6) {
            d6 = dArr2[length - 1];
        }
        d5 = d6;
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.f5742a;
            int i6 = i5 + 1;
            double d7 = dArr3[i6];
            if (d5 <= d7) {
                double d8 = d7 - dArr3[i5];
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.f5743b;
                    dArr[i7] = (dArr4[i6][i7] - dArr4[i5][i7]) / d8;
                }
                return;
            }
            i5 = i6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f5742a;
    }
}
