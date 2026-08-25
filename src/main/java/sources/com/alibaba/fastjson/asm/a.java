package com.alibaba.fastjson.asm;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f14651a;

    /* renamed from: b, reason: collision with root package name */
    public int f14652b;

    public a() {
        this.f14651a = new byte[64];
    }

    public a(int i5) {
        this.f14651a = new byte[i5];
    }

    private void a(int i5) {
        byte[] bArr = this.f14651a;
        int length = bArr.length * 2;
        int i6 = this.f14652b;
        int i7 = i5 + i6;
        if (length <= i7) {
            length = i7;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        this.f14651a = bArr2;
    }

    a b(int i5, int i6) {
        int i7 = this.f14652b;
        if (i7 + 2 > this.f14651a.length) {
            a(2);
        }
        byte[] bArr = this.f14651a;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) i6;
        this.f14652b = i7 + 2;
        return this;
    }

    public a c(int i5, int i6) {
        int i7 = this.f14652b;
        if (i7 + 3 > this.f14651a.length) {
            a(3);
        }
        byte[] bArr = this.f14651a;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) (i6 >>> 8);
        bArr[i7 + 2] = (byte) i6;
        this.f14652b = i7 + 3;
        return this;
    }

    public a d(int i5) {
        int i6 = this.f14652b;
        int i7 = i6 + 1;
        if (i7 > this.f14651a.length) {
            a(1);
        }
        this.f14651a[i6] = (byte) i5;
        this.f14652b = i7;
        return this;
    }

    public a e(byte[] bArr, int i5, int i6) {
        if (this.f14652b + i6 > this.f14651a.length) {
            a(i6);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i5, this.f14651a, this.f14652b, i6);
        }
        this.f14652b += i6;
        return this;
    }

    public a f(int i5) {
        int i6 = this.f14652b;
        if (i6 + 4 > this.f14651a.length) {
            a(4);
        }
        byte[] bArr = this.f14651a;
        bArr[i6] = (byte) (i5 >>> 24);
        bArr[i6 + 1] = (byte) (i5 >>> 16);
        bArr[i6 + 2] = (byte) (i5 >>> 8);
        bArr[i6 + 3] = (byte) i5;
        this.f14652b = i6 + 4;
        return this;
    }

    public a g(int i5) {
        int i6 = this.f14652b;
        if (i6 + 2 > this.f14651a.length) {
            a(2);
        }
        byte[] bArr = this.f14651a;
        bArr[i6] = (byte) (i5 >>> 8);
        bArr[i6 + 1] = (byte) i5;
        this.f14652b = i6 + 2;
        return this;
    }

    public a h(String str) {
        int length = str.length();
        int i5 = this.f14652b;
        if (i5 + 2 + length > this.f14651a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f14651a;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (length >>> 8);
        int i7 = i5 + 2;
        bArr[i6] = (byte) length;
        int i8 = 0;
        while (i8 < length) {
            char charAt = str.charAt(i8);
            if ((charAt < 1 || charAt > 127) && (charAt < 19968 || charAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i7] = (byte) charAt;
            i8++;
            i7++;
        }
        this.f14652b = i7;
        return this;
    }
}
