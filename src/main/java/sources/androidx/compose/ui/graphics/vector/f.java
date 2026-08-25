package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    public static final void a(char c5, ArrayList arrayList, float[] fArr, int i5) {
        if (c5 == 'z' || c5 == 'Z') {
            arrayList.add(e.b.f3785c);
            return;
        }
        if (c5 == 'm') {
            c(arrayList, fArr, i5);
            return;
        }
        if (c5 == 'M') {
            b(arrayList, fArr, i5);
            return;
        }
        int i6 = 0;
        if (c5 == 'l') {
            int i7 = i5 - 2;
            while (i6 <= i7) {
                arrayList.add(new e.m(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'L') {
            int i8 = i5 - 2;
            while (i6 <= i8) {
                arrayList.add(new e.C0030e(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'h') {
            int i9 = i5 - 1;
            while (i6 <= i9) {
                arrayList.add(new e.l(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'H') {
            int i10 = i5 - 1;
            while (i6 <= i10) {
                arrayList.add(new e.d(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'v') {
            int i11 = i5 - 1;
            while (i6 <= i11) {
                arrayList.add(new e.r(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'V') {
            int i12 = i5 - 1;
            while (i6 <= i12) {
                arrayList.add(new e.s(fArr[i6]));
                i6++;
            }
            return;
        }
        if (c5 == 'c') {
            int i13 = i5 - 6;
            while (i6 <= i13) {
                arrayList.add(new e.k(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                i6 += 6;
            }
            return;
        }
        if (c5 == 'C') {
            int i14 = i5 - 6;
            while (i6 <= i14) {
                arrayList.add(new e.c(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                i6 += 6;
            }
            return;
        }
        if (c5 == 's') {
            int i15 = i5 - 4;
            while (i6 <= i15) {
                arrayList.add(new e.p(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'S') {
            int i16 = i5 - 4;
            while (i6 <= i16) {
                arrayList.add(new e.h(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'q') {
            int i17 = i5 - 4;
            while (i6 <= i17) {
                arrayList.add(new e.o(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 'Q') {
            int i18 = i5 - 4;
            while (i6 <= i18) {
                arrayList.add(new e.g(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                i6 += 4;
            }
            return;
        }
        if (c5 == 't') {
            int i19 = i5 - 2;
            while (i6 <= i19) {
                arrayList.add(new e.q(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'T') {
            int i20 = i5 - 2;
            while (i6 <= i20) {
                arrayList.add(new e.i(fArr[i6], fArr[i6 + 1]));
                i6 += 2;
            }
            return;
        }
        if (c5 == 'a') {
            int i21 = i5 - 7;
            for (int i22 = 0; i22 <= i21; i22 += 7) {
                arrayList.add(new e.j(fArr[i22], fArr[i22 + 1], fArr[i22 + 2], Float.compare(fArr[i22 + 3], 0.0f) != 0, Float.compare(fArr[i22 + 4], 0.0f) != 0, fArr[i22 + 5], fArr[i22 + 6]));
            }
            return;
        }
        if (c5 != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c5);
        }
        int i23 = i5 - 7;
        for (int i24 = 0; i24 <= i23; i24 += 7) {
            arrayList.add(new e.a(fArr[i24], fArr[i24 + 1], fArr[i24 + 2], Float.compare(fArr[i24 + 3], 0.0f) != 0, Float.compare(fArr[i24 + 4], 0.0f) != 0, fArr[i24 + 5], fArr[i24 + 6]));
        }
    }

    private static final void b(List list, float[] fArr, int i5) {
        int i6 = i5 - 2;
        if (i6 >= 0) {
            list.add(new e.f(fArr[0], fArr[1]));
            for (int i7 = 2; i7 <= i6; i7 += 2) {
                list.add(new e.C0030e(fArr[i7], fArr[i7 + 1]));
            }
        }
    }

    private static final void c(List list, float[] fArr, int i5) {
        int i6 = i5 - 2;
        if (i6 >= 0) {
            list.add(new e.n(fArr[0], fArr[1]));
            for (int i7 = 2; i7 <= i6; i7 += 2) {
                list.add(new e.m(fArr[i7], fArr[i7 + 1]));
            }
        }
    }
}
