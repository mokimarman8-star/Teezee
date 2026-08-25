package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected b f5762a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f5763b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    protected float[] f5764c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    private int f5765d;

    /* renamed from: e, reason: collision with root package name */
    private String f5766e;

    private static class a {
        static void a(int[] iArr, float[] fArr, int i5, int i6) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i6;
            iArr2[1] = i5;
            int i7 = 2;
            while (i7 > 0) {
                int i8 = iArr2[i7 - 1];
                int i9 = i7 - 2;
                int i10 = iArr2[i9];
                if (i8 < i10) {
                    int b5 = b(iArr, fArr, i8, i10);
                    iArr2[i9] = b5 - 1;
                    iArr2[i7 - 1] = i8;
                    int i11 = i7 + 1;
                    iArr2[i7] = i10;
                    i7 += 2;
                    iArr2[i11] = b5 + 1;
                } else {
                    i7 = i9;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i5, int i6) {
            int i7 = iArr[i6];
            int i8 = i5;
            while (i5 < i6) {
                if (iArr[i5] <= i7) {
                    c(iArr, fArr, i8, i5);
                    i8++;
                }
                i5++;
            }
            c(iArr, fArr, i8, i6);
            return i8;
        }

        private static void c(int[] iArr, float[] fArr, int i5, int i6) {
            int i7 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i7;
            float f5 = fArr[i5];
            fArr[i5] = fArr[i6];
            fArr[i6] = f5;
        }
    }

    public float a(float f5) {
        return (float) this.f5762a.c(f5, 0);
    }

    public float b(float f5) {
        return (float) this.f5762a.f(f5, 0);
    }

    public void c(int i5, float f5) {
        int[] iArr = this.f5763b;
        if (iArr.length < this.f5765d + 1) {
            this.f5763b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f5764c;
            this.f5764c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f5763b;
        int i6 = this.f5765d;
        iArr2[i6] = i5;
        this.f5764c[i6] = f5;
        this.f5765d = i6 + 1;
    }

    public void d(String str) {
        this.f5766e = str;
    }

    public void e(int i5) {
        int i6;
        int i7 = this.f5765d;
        if (i7 == 0) {
            return;
        }
        a.a(this.f5763b, this.f5764c, 0, i7 - 1);
        int i8 = 1;
        for (int i9 = 1; i9 < this.f5765d; i9++) {
            int[] iArr = this.f5763b;
            if (iArr[i9 - 1] != iArr[i9]) {
                i8++;
            }
        }
        double[] dArr = new double[i8];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i8, 1);
        int i10 = 0;
        for (0; i6 < this.f5765d; i6 + 1) {
            if (i6 > 0) {
                int[] iArr2 = this.f5763b;
                i6 = iArr2[i6] == iArr2[i6 - 1] ? i6 + 1 : 0;
            }
            dArr[i10] = this.f5763b[i6] * 0.01d;
            dArr2[i10][0] = this.f5764c[i6];
            i10++;
        }
        this.f5762a = b.a(i5, dArr, dArr2);
    }

    public String toString() {
        String str = this.f5766e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.f5765d; i5++) {
            str = str + "[" + this.f5763b[i5] + " , " + decimalFormat.format(this.f5764c[i5]) + "] ";
        }
        return str;
    }
}
