package kd;

import com.google.zxing.NotFoundException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class j extends com.google.zxing.a {
    private static final byte[] d = new byte[0];
    private byte[] b;
    private final int[] c;

    public j(com.google.zxing.e eVar) {
        super(eVar);
        this.b = d;
        this.c = new int[32];
    }

    private static int g(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i3 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    private void h(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    @Override // com.google.zxing.a
    public b b() {
        com.google.zxing.e e = e();
        int d2 = e.d();
        int a = e.a();
        b bVar = new b(d2, a);
        h(d2);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] c = e.c((a * i) / 5, this.b);
            int i2 = (d2 * 4) / 5;
            for (int i3 = d2 / 5; i3 < i2; i3++) {
                int i4 = (c[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int g = g(iArr);
        byte[] b = e.b();
        for (int i5 = 0; i5 < a; i5++) {
            int i6 = i5 * d2;
            for (int i7 = 0; i7 < d2; i7++) {
                if ((b[i6 + i7] & 255) < g) {
                    bVar.r(i7, i5);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public a c(int i, a aVar) {
        com.google.zxing.e e = e();
        int d2 = e.d();
        if (aVar == null || aVar.m() < d2) {
            aVar = new a(d2);
        } else {
            aVar.e();
        }
        h(d2);
        byte[] c = e.c(i, this.b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < d2; i2++) {
            int i3 = (c[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int g = g(iArr);
        if (d2 < 3) {
            for (int i4 = 0; i4 < d2; i4++) {
                if ((c[i4] & 255) < g) {
                    aVar.r(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = c[0] & 255;
            int i7 = c[1] & 255;
            while (i5 < d2 - 1) {
                int i8 = i5 + 1;
                int i9 = c[i8] & 255;
                if ((((i7 * 4) - i6) - i9) / 2 < g) {
                    aVar.r(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return aVar;
    }
}
