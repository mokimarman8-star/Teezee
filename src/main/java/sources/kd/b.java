package kd;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements Cloneable {
    private int a;
    private int b;
    private int c;
    private int[] d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i;
        this.b = i2;
        int i3 = (i + 31) / 32;
        this.c = i3;
        this.d = new int[i3 * i2];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                sb2.append(h(i2, i) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void b() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public void e() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            int[] iArr = this.d;
            iArr[i] = ~iArr[i];
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Arrays.equals(this.d, bVar.d);
    }

    public void g(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean h(int i, int i2) {
        return ((this.d[(i2 * this.c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int hashCode() {
        int i = this.a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public int[] i() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.c;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] j() {
        int i = this.a;
        int i2 = this.b;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.b; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.c;
                if (i6 < i7) {
                    int i8 = this.d[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 * 32;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int k() {
        return this.b;
    }

    public a l(int i, a aVar) {
        if (aVar == null || aVar.m() < this.a) {
            aVar = new a(this.a);
        } else {
            aVar.e();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            aVar.s(i3 * 32, this.d[i2 + i3]);
        }
        return aVar;
    }

    public int[] m() {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) * 32;
        while ((iArr[i2] << (31 - i)) == 0) {
            i++;
        }
        return new int[]{i5 + i, i4};
    }

    public int n() {
        return this.a;
    }

    public void o(int i) {
        int i2 = i % 360;
        if (i2 != 0) {
            if (i2 == 90) {
                q();
                return;
            }
            if (i2 == 180) {
                p();
            } else {
                if (i2 != 270) {
                    throw new IllegalArgumentException("degrees must be a multiple of 0, 90, 180, or 270");
                }
                q();
                p();
            }
        }
    }

    public void p() {
        a aVar = new a(this.a);
        a aVar2 = new a(this.a);
        int i = (this.b + 1) / 2;
        for (int i2 = 0; i2 < i; i2++) {
            aVar = l(i2, aVar);
            int i3 = (this.b - 1) - i2;
            aVar2 = l(i3, aVar2);
            aVar.q();
            aVar2.q();
            t(i2, aVar2);
            t(i3, aVar);
        }
    }

    public void q() {
        int i = this.b;
        int i2 = this.a;
        int i3 = (i + 31) / 32;
        int[] iArr = new int[i3 * i2];
        for (int i4 = 0; i4 < this.b; i4++) {
            for (int i5 = 0; i5 < this.a; i5++) {
                if (((this.d[(this.c * i4) + (i5 / 32)] >>> (i5 & 31)) & 1) != 0) {
                    int i6 = (((i2 - 1) - i5) * i3) + (i4 / 32);
                    iArr[i6] = (1 << (i4 & 31)) | iArr[i6];
                }
            }
        }
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public void r(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void s(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.b || i5 > this.a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.c * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.d;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void t(int i, a aVar) {
        int[] j = aVar.j();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(j, 0, iArr, i * i2, i2);
    }

    public String toString() {
        return u("X ", "  ");
    }

    public String u(String str, String str2) {
        return a(str, str2, "\n");
    }
}
