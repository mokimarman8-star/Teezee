package vz;

import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d {
    byte[] a;
    int b;

    public d() {
        this.a = new byte[64];
    }

    public d(int i) {
        this.a = new byte[i];
    }

    d(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    private void b(int i) {
        byte[] bArr = this.a;
        int length = bArr.length * 2;
        int i2 = this.b;
        int i3 = i + i2;
        if (length <= i3) {
            length = i3;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.a = bArr2;
    }

    final d a(String str, int i, int i2) {
        int length = str.length();
        int i3 = i;
        int i4 = i3;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            i4 = (charAt < 1 || charAt > 127) ? charAt <= 2047 ? i4 + 2 : i4 + 3 : i4 + 1;
            i3++;
        }
        if (i4 > i2) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i6 = this.b;
        int i7 = i6 - i;
        int i8 = i7 - 2;
        if (i8 >= 0) {
            byte[] bArr = this.a;
            bArr[i8] = (byte) (i4 >>> 8);
            bArr[i7 - 1] = (byte) i4;
        }
        if ((i6 + i4) - i > this.a.length) {
            b(i4 - i);
        }
        int i9 = this.b;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 >= 1 && charAt2 <= 127) {
                this.a[i9] = (byte) charAt2;
                i9++;
            } else if (charAt2 <= 2047) {
                byte[] bArr2 = this.a;
                int i10 = i9 + 1;
                bArr2[i9] = (byte) (((charAt2 >> 6) & 31) | 192);
                i9 += 2;
                bArr2[i10] = (byte) ((charAt2 & '?') | ASTNode.ASSIGN);
            } else {
                byte[] bArr3 = this.a;
                bArr3[i9] = (byte) (((charAt2 >> '\f') & 15) | 224);
                int i11 = i9 + 2;
                bArr3[i9 + 1] = (byte) (((charAt2 >> 6) & 63) | ASTNode.ASSIGN);
                i9 += 3;
                bArr3[i11] = (byte) ((charAt2 & '?') | ASTNode.ASSIGN);
            }
            i++;
        }
        this.b = i9;
        return this;
    }

    final d c(int i, int i2) {
        int i3 = this.b;
        if (i3 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) i2;
        this.b = i3 + 2;
        return this;
    }

    final d d(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 + 4 > this.a.length) {
            b(4);
        }
        byte[] bArr = this.a;
        bArr[i4] = (byte) i;
        bArr[i4 + 1] = (byte) i2;
        bArr[i4 + 2] = (byte) (i3 >>> 8);
        bArr[i4 + 3] = (byte) i3;
        this.b = i4 + 4;
        return this;
    }

    final d e(int i, int i2) {
        int i3 = this.b;
        if (i3 + 3 > this.a.length) {
            b(3);
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) i2;
        this.b = i3 + 3;
        return this;
    }

    final d f(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 + 5 > this.a.length) {
            b(5);
        }
        byte[] bArr = this.a;
        bArr[i4] = (byte) i;
        bArr[i4 + 1] = (byte) (i2 >>> 8);
        bArr[i4 + 2] = (byte) i2;
        bArr[i4 + 3] = (byte) (i3 >>> 8);
        bArr[i4 + 4] = (byte) i3;
        this.b = i4 + 5;
        return this;
    }

    public d g(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        if (i3 > this.a.length) {
            b(1);
        }
        this.a[i2] = (byte) i;
        this.b = i3;
        return this;
    }

    public d h(byte[] bArr, int i, int i2) {
        if (this.b + i2 > this.a.length) {
            b(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.a, this.b, i2);
        }
        this.b += i2;
        return this;
    }

    public d i(int i) {
        int i2 = this.b;
        if (i2 + 4 > this.a.length) {
            b(4);
        }
        byte[] bArr = this.a;
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.b = i2 + 4;
        return this;
    }

    public d j(long j) {
        int i = this.b;
        if (i + 8 > this.a.length) {
            b(8);
        }
        byte[] bArr = this.a;
        int i2 = (int) (j >>> 32);
        bArr[i] = (byte) (i2 >>> 24);
        bArr[i + 1] = (byte) (i2 >>> 16);
        bArr[i + 2] = (byte) (i2 >>> 8);
        bArr[i + 3] = (byte) i2;
        int i3 = (int) j;
        bArr[i + 4] = (byte) (i3 >>> 24);
        bArr[i + 5] = (byte) (i3 >>> 16);
        bArr[i + 6] = (byte) (i3 >>> 8);
        bArr[i + 7] = (byte) i3;
        this.b = i + 8;
        return this;
    }

    public d k(int i) {
        int i2 = this.b;
        if (i2 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        this.b = i2 + 2;
        return this;
    }

    public d l(String str) {
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = this.b;
        if (i + 2 + length > this.a.length) {
            b(length + 2);
        }
        byte[] bArr = this.a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i + 2;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt < 1 || charAt > 127) {
                this.b = i3;
                return a(str, i4, 65535);
            }
            bArr[i3] = (byte) charAt;
            i4++;
            i3++;
        }
        this.b = i3;
        return this;
    }
}
