package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a {
    private final kd.b a;
    private g b;
    private e c;
    private boolean d;

    a(kd.b bVar) {
        int k = bVar.k();
        if (k < 21 || (k & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.a = bVar;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.a.h(i2, i) : this.a.h(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    void b() {
        int i = 0;
        while (i < this.a.n()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.k(); i3++) {
                if (this.a.h(i, i3) != this.a.h(i3, i)) {
                    this.a.g(i3, i);
                    this.a.g(i, i3);
                }
            }
            i = i2;
        }
    }

    byte[] c() {
        e d = d();
        g e = e();
        DataMask dataMask = DataMask.values()[d.c()];
        int k = this.a.k();
        dataMask.unmaskBitMatrix(this.a, k);
        kd.b a = e.a();
        byte[] bArr = new byte[e.h()];
        int i = k - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < k; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!a.h(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.a.h(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == e.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    e d() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a = a(8, i4, a);
        }
        int k = this.a.k();
        int i5 = k - 7;
        for (int i6 = k - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = k - 8; i7 < k; i7++) {
            i = a(i7, 8, i);
        }
        e a2 = e.a(a, i);
        this.c = a2;
        if (a2 != null) {
            return a2;
        }
        throw FormatException.getFormatInstance();
    }

    g e() {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        int k = this.a.k();
        int i = (k - 17) / 4;
        if (i <= 6) {
            return g.i(i);
        }
        int i2 = k - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = k - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        g c = g.c(i4);
        if (c != null && c.e() == k) {
            this.b = c;
            return c;
        }
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = k - 9; i8 >= i2; i8--) {
                i3 = a(i7, i8, i3);
            }
        }
        g c2 = g.c(i3);
        if (c2 == null || c2.e() != k) {
            throw FormatException.getFormatInstance();
        }
        this.b = c2;
        return c2;
    }

    void f() {
        if (this.c == null) {
            return;
        }
        DataMask.values()[this.c.c()].unmaskBitMatrix(this.a, this.a.k());
    }

    void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
