package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a {
    private final kd.b a;
    private final kd.b b;
    private final d c;

    a(kd.b bVar) {
        int k = bVar.k();
        if (k < 8 || k > 144 || (k & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.c = j(bVar);
        kd.b a = a(bVar);
        this.a = a;
        this.b = new kd.b(a.n(), a.k());
    }

    private kd.b a(kd.b bVar) {
        int f = this.c.f();
        int e = this.c.e();
        if (bVar.k() != f) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int c = this.c.c();
        int b = this.c.b();
        int i = f / c;
        int i2 = e / b;
        kd.b bVar2 = new kd.b(i2 * b, i * c);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * c;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * b;
                for (int i7 = 0; i7 < c; i7++) {
                    int i8 = ((c + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < b; i10++) {
                        if (bVar.h(((b + 2) * i5) + 1 + i10, i8)) {
                            bVar2.r(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        if (h(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (h(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private int e(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return h(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private int f(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (h(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return h(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int g(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (h(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return h(3, i7, i, i2) ? i10 | 1 : i10;
    }

    private boolean h(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        if (i >= i3) {
            i -= i3;
        }
        this.b.r(i2, i);
        return this.a.h(i2, i);
    }

    private int i(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (h(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (h(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (h(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return h(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private static d j(kd.b bVar) {
        return d.h(bVar.k(), bVar.n());
    }

    d b() {
        return this.c;
    }

    byte[] c() {
        byte[] bArr = new byte[this.c.g()];
        int k = this.a.k();
        int n = this.a.n();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == k && i == 0 && !z) {
                bArr[i2] = (byte) d(k, n);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = k - 2;
                if (i3 == i4 && i == 0 && (n & 3) != 0 && !z2) {
                    bArr[i2] = (byte) e(k, n);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == k + 4 && i == 2 && (n & 7) == 0 && !z3) {
                    bArr[i2] = (byte) f(k, n);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (n & 7) == 4 && !z4) {
                    bArr[i2] = (byte) g(k, n);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    while (true) {
                        if (i3 < k && i >= 0 && !this.b.h(i, i3)) {
                            bArr[i2] = (byte) i(i3, i, k, n);
                            i2++;
                        }
                        int i5 = i3 - 2;
                        int i6 = i + 2;
                        if (i5 < 0 || i6 >= n) {
                            break;
                        }
                        i3 = i5;
                        i = i6;
                    }
                    int i7 = i3 - 1;
                    int i8 = i + 5;
                    while (true) {
                        if (i7 >= 0 && i8 < n && !this.b.h(i8, i7)) {
                            bArr[i2] = (byte) i(i7, i8, k, n);
                            i2++;
                        }
                        int i9 = i7 + 2;
                        int i10 = i8 - 2;
                        if (i9 >= k || i10 < 0) {
                            break;
                        }
                        i7 = i9;
                        i8 = i10;
                    }
                    i3 = i7 + 5;
                    i = i8 - 1;
                }
            }
            if (i3 >= k && i >= n) {
                break;
            }
        }
        if (i2 == this.c.g()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
