package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final int a;
    private final byte[] b;

    private b(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != gVar.h()) {
            throw new IllegalArgumentException();
        }
        g.b f = gVar.f(errorCorrectionLevel);
        g.a[] a = f.a();
        int i = 0;
        for (g.a aVar : a) {
            i += aVar.a();
        }
        b[] bVarArr = new b[i];
        int i2 = 0;
        for (g.a aVar2 : a) {
            int i3 = 0;
            while (i3 < aVar2.a()) {
                int b = aVar2.b();
                bVarArr[i2] = new b(b, new byte[f.b() + b]);
                i3++;
                i2++;
            }
        }
        int length = bVarArr[0].b.length;
        int i4 = i - 1;
        while (i4 >= 0 && bVarArr[i4].b.length != length) {
            i4--;
        }
        int i5 = i4 + 1;
        int b2 = length - f.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b2; i7++) {
            int i8 = 0;
            while (i8 < i2) {
                bVarArr[i8].b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        int i9 = i5;
        while (i9 < i2) {
            bVarArr[i9].b[b2] = bArr[i6];
            i9++;
            i6++;
        }
        int length2 = bVarArr[0].b.length;
        while (b2 < length2) {
            int i10 = 0;
            while (i10 < i2) {
                bVarArr[i10].b[i10 < i5 ? b2 : b2 + 1] = bArr[i6];
                i10++;
                i6++;
            }
            b2++;
        }
        return bVarArr;
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}
