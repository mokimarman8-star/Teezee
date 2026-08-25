package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class k extends c {

    /* renamed from: d, reason: collision with root package name */
    f f5778d;

    k(String str) {
        this.f5734a = str;
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
        this.f5778d = d(Arrays.copyOf(dArr, i5 + 1));
    }

    private static f d(double[] dArr) {
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
        f fVar = new f(dArr3, dArr2);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + fVar.c(0.0d, 0));
        printStream.println(" 1 " + fVar.c(1.0d, 0));
        return fVar;
    }

    @Override // androidx.constraintlayout.core.motion.utils.c
    public double a(double d5) {
        return this.f5778d.c(d5, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.c
    public double b(double d5) {
        return this.f5778d.f(d5, 0);
    }
}
