package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final kd.b a;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final l i;
    private final List b = new ArrayList(5);
    private final int[] h = new int[3];

    b(kd.b bVar, int i, int i2, int i3, int i4, float f, l lVar) {
        this.a = bVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = lVar;
    }

    private static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i, int i2, int i3, int i4) {
        kd.b bVar = this.a;
        int k = bVar.k();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bVar.h(i2, i5)) {
            int i6 = iArr[1];
            if (i6 > i3) {
                break;
            }
            iArr[1] = i6 + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.h(i2, i5)) {
            int i7 = iArr[0];
            if (i7 > i3) {
                break;
            }
            iArr[0] = i7 + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i8 = i + 1;
        while (i8 < k && bVar.h(i2, i8)) {
            int i9 = iArr[1];
            if (i9 > i3) {
                break;
            }
            iArr[1] = i9 + 1;
            i8++;
        }
        if (i8 == k || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i8 < k && !bVar.h(i2, i8)) {
            int i10 = iArr[2];
            if (i10 > i3) {
                break;
            }
            iArr[2] = i10 + 1;
            i8++;
        }
        int i11 = iArr[2];
        if (i11 <= i3 && Math.abs(((iArr[0] + iArr[1]) + i11) - i4) * 5 < i4 * 2 && d(iArr)) {
            return a(iArr, i8);
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float a = a(iArr, i2);
        float b = b(i, (int) a, iArr[1] * 2, i3);
        if (Float.isNaN(b)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.b) {
            if (aVar.f(f, b, a)) {
                return aVar.g(b, a, f);
            }
        }
        a aVar2 = new a(a, b, f);
        this.b.add(aVar2);
        l lVar = this.i;
        if (lVar == null) {
            return null;
        }
        lVar.a(aVar2);
        return null;
    }

    a c() {
        a e;
        a e2;
        int i = this.c;
        int i2 = this.f;
        int i3 = this.e + i;
        int i4 = this.d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.a.h(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.a.h(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else {
                    if (d(iArr) && (e2 = e(iArr, i6, i7)) != null) {
                        return e2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (d(iArr) && (e = e(iArr, i6, i3)) != null) {
                return e;
            }
        }
        if (this.b.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (a) this.b.get(0);
    }
}
