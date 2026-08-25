package md;

import com.mbridge.msdk.MBridgeConstans;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final a a;
    private final int[] b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = bVar.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = a.a(iArr2[i - length], iArr[i]);
        }
        return new b(this.a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b g = this.a.g();
        int h = this.a.h(bVar.d(bVar.f()));
        b bVar2 = this;
        while (bVar2.f() >= bVar.f() && !bVar2.g()) {
            int f = bVar2.f() - bVar.f();
            int j = this.a.j(bVar2.d(bVar2.f()), h);
            b j2 = bVar.j(f, j);
            g = g.a(this.a.b(f, j));
            bVar2 = bVar2.a(j2);
        }
        return new b[]{g, bVar2};
    }

    int c(int i) {
        if (i == 0) {
            return d(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.b) {
                i2 = a.a(i2, i3);
            }
            return i2;
        }
        int[] iArr = this.b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            i4 = a.a(this.a.j(i, i4), this.b[i5]);
        }
        return i4;
    }

    int d(int i) {
        return this.b[(r0.length - 1) - i];
    }

    int[] e() {
        return this.b;
    }

    int f() {
        return this.b.length - 1;
    }

    boolean g() {
        return this.b[0] == 0;
    }

    b h(int i) {
        if (i == 0) {
            return this.a.g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(this.b[i2], i);
        }
        return new b(this.a, iArr);
    }

    b i(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.a.g();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = bVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = a.a(iArr3[i4], this.a.j(i2, iArr2[i3]));
            }
        }
        return new b(this.a, iArr3);
    }

    b j(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.g();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.j(this.b[i3], i2);
        }
        return new b(this.a, iArr);
    }

    public String toString() {
        if (g()) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL;
        }
        StringBuilder sb2 = new StringBuilder(f() * 8);
        for (int f = f(); f >= 0; f--) {
            int d = d(f);
            if (d != 0) {
                if (d < 0) {
                    if (f == f()) {
                        sb2.append("-");
                    } else {
                        sb2.append(" - ");
                    }
                    d = -d;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (f == 0 || d != 1) {
                    int i = this.a.i(d);
                    if (i == 0) {
                        sb2.append('1');
                    } else if (i == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(i);
                    }
                }
                if (f != 0) {
                    if (f == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(f);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
