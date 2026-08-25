package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.d;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final int a;
    private final byte[] b;

    private b(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static b[] b(byte[] bArr, d dVar) {
        d.c d = dVar.d();
        d.b[] a = d.a();
        int i = 0;
        for (d.b bVar : a) {
            i += bVar.a();
        }
        b[] bVarArr = new b[i];
        int i2 = 0;
        for (d.b bVar2 : a) {
            int i3 = 0;
            while (i3 < bVar2.a()) {
                int b = bVar2.b();
                bVarArr[i2] = new b(b, new byte[d.b() + b]);
                i3++;
                i2++;
            }
        }
        int length = bVarArr[0].b.length - d.b();
        int i4 = length - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                bVarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        boolean z = dVar.i() == 24;
        int i8 = z ? 8 : i2;
        int i9 = 0;
        while (i9 < i8) {
            bVarArr[i9].b[i4] = bArr[i5];
            i9++;
            i5++;
        }
        int length2 = bVarArr[0].b.length;
        while (length < length2) {
            int i10 = 0;
            while (i10 < i2) {
                int i11 = z ? (i10 + 8) % i2 : i10;
                bVarArr[i11].b[(!z || i11 <= 7) ? length : length - 1] = bArr[i5];
                i10++;
                i5++;
            }
            length++;
        }
        if (i5 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}
