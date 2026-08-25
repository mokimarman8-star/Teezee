package androidx.core.util;

import java.io.PrintWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7131a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static char[] f7132b = new char[24];

    private static int a(int i5, int i6, boolean z5, int i7) {
        if (i5 > 99 || (z5 && i7 >= 3)) {
            return i6 + 3;
        }
        if (i5 > 9 || (z5 && i7 >= 2)) {
            return i6 + 2;
        }
        if (z5 || i5 > 0) {
            return i6 + 1;
        }
        return 0;
    }

    public static void b(long j5, long j6, PrintWriter printWriter) {
        if (j5 == 0) {
            printWriter.print("--");
        } else {
            d(j5 - j6, printWriter, 0);
        }
    }

    public static void c(long j5, PrintWriter printWriter) {
        d(j5, printWriter, 0);
    }

    public static void d(long j5, PrintWriter printWriter, int i5) {
        synchronized (f7131a) {
            printWriter.print(new String(f7132b, 0, e(j5, i5)));
        }
    }

    private static int e(long j5, int i5) {
        char c5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j6 = j5;
        if (f7132b.length < i5) {
            f7132b = new char[i5];
        }
        char[] cArr = f7132b;
        if (j6 == 0) {
            int i11 = i5 - 1;
            while (i11 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j6 > 0) {
            c5 = '+';
        } else {
            j6 = -j6;
            c5 = '-';
        }
        int i12 = (int) (j6 % 1000);
        int floor = (int) Math.floor(j6 / 1000);
        if (floor > 86400) {
            i6 = floor / 86400;
            floor -= 86400 * i6;
        } else {
            i6 = 0;
        }
        if (floor > 3600) {
            i7 = floor / 3600;
            floor -= i7 * 3600;
        } else {
            i7 = 0;
        }
        if (floor > 60) {
            int i13 = floor / 60;
            i8 = floor - (i13 * 60);
            i9 = i13;
        } else {
            i8 = floor;
            i9 = 0;
        }
        if (i5 != 0) {
            int a5 = a(i6, 1, false, 0);
            int a6 = a5 + a(i7, 1, a5 > 0, 2);
            int a7 = a6 + a(i9, 1, a6 > 0, 2);
            int a8 = a7 + a(i8, 1, a7 > 0, 2);
            i10 = 0;
            for (int a9 = a8 + a(i12, 2, true, a8 > 0 ? 3 : 0) + 1; a9 < i5; a9++) {
                cArr[i10] = ' ';
                i10++;
            }
        } else {
            i10 = 0;
        }
        cArr[i10] = c5;
        int i14 = i10 + 1;
        boolean z5 = i5 != 0;
        int f5 = f(cArr, i6, 'd', i14, false, 0);
        int f6 = f(cArr, i7, 'h', f5, f5 != i14, z5 ? 2 : 0);
        int f7 = f(cArr, i9, 'm', f6, f6 != i14, z5 ? 2 : 0);
        int f8 = f(cArr, i8, 's', f7, f7 != i14, z5 ? 2 : 0);
        int f9 = f(cArr, i12, 'm', f8, true, (!z5 || f8 == i14) ? 0 : 3);
        cArr[f9] = 's';
        return f9 + 1;
    }

    private static int f(char[] cArr, int i5, char c5, int i6, boolean z5, int i7) {
        int i8;
        if (!z5 && i5 <= 0) {
            return i6;
        }
        if ((!z5 || i7 < 3) && i5 <= 99) {
            i8 = i6;
        } else {
            int i9 = i5 / 100;
            cArr[i6] = (char) (i9 + 48);
            i8 = i6 + 1;
            i5 -= i9 * 100;
        }
        if ((z5 && i7 >= 2) || i5 > 9 || i6 != i8) {
            int i10 = i5 / 10;
            cArr[i8] = (char) (i10 + 48);
            i8++;
            i5 -= i10 * 10;
        }
        cArr[i8] = (char) (i5 + 48);
        cArr[i8 + 1] = c5;
        return i8 + 2;
    }
}
