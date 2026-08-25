package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {

    /* renamed from: k, reason: collision with root package name */
    protected static float f5794k = 6.2831855f;

    /* renamed from: a, reason: collision with root package name */
    protected b f5795a;

    /* renamed from: e, reason: collision with root package name */
    protected int f5799e;

    /* renamed from: f, reason: collision with root package name */
    protected String f5800f;

    /* renamed from: i, reason: collision with root package name */
    protected long f5803i;

    /* renamed from: b, reason: collision with root package name */
    protected int f5796b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int[] f5797c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    protected float[][] f5798d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    protected float[] f5801g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    protected boolean f5802h = false;

    /* renamed from: j, reason: collision with root package name */
    protected float f5804j = Float.NaN;

    protected static class a {
        static void a(int[] iArr, float[][] fArr, int i5, int i6) {
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

        private static int b(int[] iArr, float[][] fArr, int i5, int i6) {
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

        private static void c(int[] iArr, float[][] fArr, int i5, int i6) {
            int i7 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i7;
            float[] fArr2 = fArr[i5];
            fArr[i5] = fArr[i6];
            fArr[i6] = fArr2;
        }
    }

    protected float a(float f5) {
        float abs;
        switch (this.f5796b) {
            case 1:
                return Math.signum(f5 * f5794k);
            case 2:
                abs = Math.abs(f5);
                break;
            case 3:
                return (((f5 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f5 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f5 * f5794k);
            case 6:
                float abs2 = 1.0f - Math.abs(((f5 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f5 * f5794k);
        }
        return 1.0f - abs;
    }

    public void b(int i5, float f5, float f6, int i6, float f7) {
        int[] iArr = this.f5797c;
        int i7 = this.f5799e;
        iArr[i7] = i5;
        float[] fArr = this.f5798d[i7];
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f7;
        this.f5796b = Math.max(this.f5796b, i6);
        this.f5799e++;
    }

    protected void c(long j5) {
        this.f5803i = j5;
    }

    public void d(String str) {
        this.f5800f = str;
    }

    public void e(int i5) {
        int i6;
        int i7 = this.f5799e;
        if (i7 == 0) {
            System.err.println("Error no points added to " + this.f5800f);
            return;
        }
        a.a(this.f5797c, this.f5798d, 0, i7 - 1);
        int i8 = 1;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f5797c;
            if (i8 >= iArr.length) {
                break;
            }
            if (iArr[i8] != iArr[i8 - 1]) {
                i9++;
            }
            i8++;
        }
        if (i9 == 0) {
            i9 = 1;
        }
        double[] dArr = new double[i9];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i9, 3);
        int i10 = 0;
        for (0; i6 < this.f5799e; i6 + 1) {
            if (i6 > 0) {
                int[] iArr2 = this.f5797c;
                i6 = iArr2[i6] == iArr2[i6 - 1] ? i6 + 1 : 0;
            }
            dArr[i10] = this.f5797c[i6] * 0.01d;
            double[] dArr3 = dArr2[i10];
            float[] fArr = this.f5798d[i6];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i10++;
        }
        this.f5795a = b.a(i5, dArr, dArr2);
    }

    public String toString() {
        String str = this.f5800f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.f5799e; i5++) {
            str = str + "[" + this.f5797c[i5] + " , " + decimalFormat.format(this.f5798d[i5]) + "] ";
        }
        return str;
    }
}
