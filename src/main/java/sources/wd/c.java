package wd;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c {
    private final b a;
    private final int[] b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
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

    c a(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = cVar.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.a.a(iArr2[i - length], iArr[i]);
        }
        return new c(this.a, iArr3);
    }

    int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.b) {
                i2 = this.a.a(i2, i3);
            }
            return i2;
        }
        int[] iArr = this.b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            b bVar = this.a;
            i4 = bVar.a(bVar.i(i, i4), this.b[i5]);
        }
        return i4;
    }

    int c(int i) {
        return this.b[(r0.length - 1) - i];
    }

    int d() {
        return this.b.length - 1;
    }

    boolean e() {
        return this.b[0] == 0;
    }

    c f(int i) {
        if (i == 0) {
            return this.a.f();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.i(this.b[i2], i);
        }
        return new c(this.a, iArr);
    }

    c g(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.a.f();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = cVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                b bVar = this.a;
                iArr3[i4] = bVar.a(iArr3[i4], bVar.i(i2, iArr2[i3]));
            }
        }
        return new c(this.a, iArr3);
    }

    c h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.f();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.i(this.b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    c i() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.j(0, this.b[i]);
        }
        return new c(this.a, iArr);
    }

    c j(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(d() * 8);
        for (int d = d(); d >= 0; d--) {
            int c = c(d);
            if (c != 0) {
                if (c < 0) {
                    sb2.append(" - ");
                    c = -c;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (d == 0 || c != 1) {
                    sb2.append(c);
                }
                if (d != 0) {
                    if (d == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(d);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
