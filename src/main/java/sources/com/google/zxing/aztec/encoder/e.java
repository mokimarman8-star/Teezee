package com.google.zxing.aztec.encoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class e {
    static final e f = new e(f.b, 0, 0, 0);
    private final int a;
    private final f b;
    private final int c;
    private final int d;
    private final int e;

    private e(f fVar, int i, int i2, int i3) {
        this.b = fVar;
        this.a = i;
        this.c = i2;
        this.d = i3;
        this.e = c(i2);
    }

    private static int c(int i) {
        if (i > 62) {
            return 21;
        }
        if (i > 31) {
            return 20;
        }
        return i > 0 ? 10 : 0;
    }

    e a(int i) {
        f fVar = this.b;
        int i2 = this.a;
        int i3 = this.d;
        if (i2 == 4 || i2 == 2) {
            int i4 = HighLevelEncoder.d[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            fVar = fVar.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.c;
        e eVar = new e(fVar, i2, i7 + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return eVar.c == 2078 ? eVar.d(i + 1) : eVar;
    }

    e b(int i) {
        f fVar;
        f fVar2 = j(4, 0).b;
        int i2 = 3;
        if (i < 0) {
            fVar = fVar2.a(0, 3);
        } else {
            if (i > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i).getBytes(StandardCharsets.ISO_8859_1);
            f a = fVar2.a(bytes.length, 3);
            for (byte b : bytes) {
                a = a.a(b - 46, 4);
            }
            i2 = 3 + (bytes.length * 4);
            fVar = a;
        }
        return new e(fVar, this.a, 0, this.d + i2);
    }

    e d(int i) {
        int i2 = this.c;
        return i2 == 0 ? this : new e(this.b.b(i - i2, i2), this.a, 0, this.d);
    }

    int e() {
        return this.c;
    }

    int f() {
        return this.d;
    }

    int g() {
        return this.a;
    }

    boolean h(e eVar) {
        int i = this.d + (HighLevelEncoder.d[this.a][eVar.a] >> 16);
        int i2 = this.c;
        int i3 = eVar.c;
        if (i2 < i3) {
            i += eVar.e - this.e;
        } else if (i2 > i3 && i3 > 0) {
            i += 10;
        }
        return i <= eVar.d;
    }

    e i(int i, int i2) {
        int i3 = this.d;
        f fVar = this.b;
        int i4 = this.a;
        if (i != i4) {
            int i5 = HighLevelEncoder.d[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            fVar = fVar.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new e(fVar.a(i2, i8), i, 0, i3 + i8);
    }

    e j(int i, int i2) {
        f fVar = this.b;
        int i3 = this.a;
        int i4 = i3 == 2 ? 4 : 5;
        return new e(fVar.a(HighLevelEncoder.f[i3][i], i4).a(i2, 5), this.a, 0, this.d + i4 + 5);
    }

    kd.a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (f fVar = d(bArr.length).b; fVar != null; fVar = fVar.d()) {
            arrayList.add(fVar);
        }
        kd.a aVar = new kd.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((f) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.c[this.a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
