package androidx.compose.ui.node;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o0 {
    private static final void b(t tVar, k kVar) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < tVar.c()) {
            int i8 = i5 + 2;
            int b5 = tVar.b(i5) - tVar.b(i8);
            int b6 = tVar.b(i5 + 1) - tVar.b(i8);
            int b7 = tVar.b(i8);
            i5 += 3;
            while (i6 < b5) {
                kVar.a(i7, i6);
                i6++;
            }
            while (i7 < b6) {
                kVar.c(i7);
                i7++;
            }
            while (true) {
                int i9 = b7 - 1;
                if (b7 > 0) {
                    kVar.d(i6, i7);
                    i6++;
                    i7++;
                    b7 = i9;
                }
            }
        }
    }

    private static final boolean c(int i5, int i6, int i7, int i8, k kVar, int[] iArr, int[] iArr2, int i9, int[] iArr3) {
        int b5;
        int i10;
        int i11;
        int i12 = (i6 - i5) - (i8 - i7);
        boolean z5 = i12 % 2 == 0;
        int i13 = -i9;
        for (int i14 = i13; i14 <= i9; i14 += 2) {
            if (i14 == i13 || (i14 != i9 && c.b(iArr2, i14 + 1) < c.b(iArr2, i14 - 1))) {
                b5 = c.b(iArr2, i14 + 1);
                i10 = b5;
            } else {
                b5 = c.b(iArr2, i14 - 1);
                i10 = b5 - 1;
            }
            int i15 = i8 - ((i6 - i10) - i14);
            int i16 = (i9 == 0 || i10 != b5) ? i15 : i15 + 1;
            while (i10 > i5 && i15 > i7) {
                if (!kVar.b(i10 - 1, i15 - 1)) {
                    break;
                }
                i10--;
                i15--;
            }
            c.d(iArr2, i14, i10);
            if (z5 && (i11 = i12 - i14) >= i13 && i11 <= i9) {
                if (c.b(iArr, i11) >= i10) {
                    f(i10, i15, b5, i16, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final t d(int i5, int i6, k kVar) {
        int i7 = ((i5 + i6) + 1) / 2;
        t tVar = new t(i7 * 3);
        t tVar2 = new t(i7 * 4);
        tVar2.h(0, i5, 0, i6);
        int i8 = (i7 * 2) + 1;
        int[] a5 = c.a(new int[i8]);
        int[] a6 = c.a(new int[i8]);
        int[] b5 = k1.b(new int[5]);
        while (tVar2.d()) {
            int f5 = tVar2.f();
            int f6 = tVar2.f();
            int f7 = tVar2.f();
            int f8 = tVar2.f();
            int[] iArr = a5;
            int[] iArr2 = a6;
            if (h(f8, f7, f6, f5, kVar, a5, a6, b5)) {
                if (k1.c(b5) > 0) {
                    k1.a(b5, tVar);
                }
                tVar2.h(f8, k1.h(b5), f6, k1.i(b5));
                tVar2.h(k1.d(b5), f7, k1.e(b5), f5);
            }
            a5 = iArr;
            a6 = iArr2;
        }
        tVar.j();
        tVar.g(i5, i6, 0);
        return tVar;
    }

    public static final void e(int i5, int i6, k kVar) {
        b(d(i5, i6, kVar), kVar);
    }

    public static final void f(int i5, int i6, int i7, int i8, boolean z5, int[] iArr) {
        iArr[0] = i5;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i8;
        iArr[4] = z5 ? 1 : 0;
    }

    private static final boolean g(int i5, int i6, int i7, int i8, k kVar, int[] iArr, int[] iArr2, int i9, int[] iArr3) {
        int b5;
        int i10;
        int i11;
        int i12 = (i6 - i5) - (i8 - i7);
        boolean z5 = Math.abs(i12) % 2 == 1;
        int i13 = -i9;
        for (int i14 = i13; i14 <= i9; i14 += 2) {
            if (i14 == i13 || (i14 != i9 && c.b(iArr, i14 + 1) > c.b(iArr, i14 - 1))) {
                b5 = c.b(iArr, i14 + 1);
                i10 = b5;
            } else {
                b5 = c.b(iArr, i14 - 1);
                i10 = b5 + 1;
            }
            int i15 = (i7 + (i10 - i5)) - i14;
            int i16 = (i9 == 0 || i10 != b5) ? i15 : i15 - 1;
            while (i10 < i6 && i15 < i8) {
                if (!kVar.b(i10, i15)) {
                    break;
                }
                i10++;
                i15++;
            }
            c.d(iArr, i14, i10);
            if (z5 && (i11 = i12 - i14) >= i13 + 1 && i11 <= i9 - 1) {
                if (c.b(iArr2, i11) <= i10) {
                    f(b5, i16, i10, i15, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final boolean h(int i5, int i6, int i7, int i8, k kVar, int[] iArr, int[] iArr2, int[] iArr3) {
        int i9 = i6 - i5;
        int i10 = i8 - i7;
        if (i9 >= 1 && i10 >= 1) {
            int i11 = ((i9 + i10) + 1) / 2;
            c.d(iArr, 1, i5);
            c.d(iArr2, 1, i6);
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12;
                if (g(i5, i6, i7, i8, kVar, iArr, iArr2, i12, iArr3) || c(i5, i6, i7, i8, kVar, iArr, iArr2, i13, iArr3)) {
                    return true;
                }
                i12 = i13 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int[] iArr, int i5, int i6) {
        int i7 = iArr[i5];
        iArr[i5] = iArr[i6];
        iArr[i6] = i7;
    }
}
