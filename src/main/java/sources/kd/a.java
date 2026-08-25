package kd;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a implements Cloneable {
    private static final int[] c = new int[0];
    private int[] a;
    private int b;

    public a() {
        this.b = 0;
        this.a = c;
    }

    public a(int i) {
        this.b = i;
        this.a = p(i);
    }

    a(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }

    private void h(int i) {
        if (i > this.a.length * 32) {
            int[] p = p((int) Math.ceil(i / 0.75f));
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, p, 0, iArr.length);
            this.a = p;
        }
    }

    private static int[] p(int i) {
        return new int[(i + 31) / 32];
    }

    public void a(boolean z) {
        h(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public void b(a aVar) {
        int i = aVar.b;
        h(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.i(i2));
        }
    }

    public void c(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i3 = this.b;
        h(i3 + i2);
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (((1 << i4) & i) != 0) {
                int[] iArr = this.a;
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (1 << (i3 & 31));
            }
            i3++;
        }
        this.b = i3;
    }

    public void e() {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            this.a[i] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && Arrays.equals(this.a, aVar.a);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.a.clone(), this.b);
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public boolean i(int i) {
        return ((1 << (i & 31)) & this.a[i / 32]) != 0;
    }

    public int[] j() {
        return this.a;
    }

    public int k(int i) {
        int i2 = this.b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & this.a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.a;
            if (i3 == iArr.length) {
                return this.b;
            }
            i4 = iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.b);
    }

    public int l(int i) {
        int i2 = this.b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & (~this.a[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.a;
            if (i3 == iArr.length) {
                return this.b;
            }
            i4 = ~iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.b);
    }

    public int m() {
        return this.b;
    }

    public int n() {
        return (this.b + 7) / 8;
    }

    public boolean o(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.b) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            int i8 = this.a[i6] & i7;
            if (!z) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void q() {
        int[] iArr = new int[this.a.length];
        int i = (this.b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i - i3] = Integer.reverse(this.a[i3]);
        }
        int i4 = this.b;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.a = iArr;
    }

    public void r(int i) {
        int[] iArr = this.a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void s(int i, int i2) {
        this.a[i / 32] = i2;
    }

    public void t(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (i(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public String toString() {
        int i = this.b;
        StringBuilder sb2 = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.b; i2++) {
            if ((i2 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(i(i2) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void u(a aVar) {
        if (this.b != aVar.b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ aVar.a[i];
            i++;
        }
    }
}
