package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        double f5730a;

        /* renamed from: b, reason: collision with root package name */
        double[] f5731b;

        a(double d5, double[] dArr) {
            this.f5730a = d5;
            this.f5731b = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double c(double d5, int i5) {
            return this.f5731b[i5];
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void d(double d5, double[] dArr) {
            double[] dArr2 = this.f5731b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void e(double d5, float[] fArr) {
            int i5 = 0;
            while (true) {
                double[] dArr = this.f5731b;
                if (i5 >= dArr.length) {
                    return;
                }
                fArr[i5] = (float) dArr[i5];
                i5++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double f(double d5, int i5) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void g(double d5, double[] dArr) {
            for (int i5 = 0; i5 < this.f5731b.length; i5++) {
                dArr[i5] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double[] h() {
            return new double[]{this.f5730a};
        }
    }

    public static b a(int i5, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i5 = 2;
        }
        return i5 != 0 ? i5 != 2 ? new e(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new f(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new androidx.constraintlayout.core.motion.utils.a(iArr, dArr, dArr2);
    }

    public abstract double c(double d5, int i5);

    public abstract void d(double d5, double[] dArr);

    public abstract void e(double d5, float[] fArr);

    public abstract double f(double d5, int i5);

    public abstract void g(double d5, double[] dArr);

    public abstract double[] h();
}
