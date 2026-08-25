package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class AbstractBase32Codec {
    private final byte[] a;

    protected AbstractBase32Codec(byte[] bArr) {
        this.a = bArr;
    }

    private final void b(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i3 + 1;
        int j = j(bArr[i2]) << 3;
        int i8 = i2 + 2;
        int j2 = j(bArr[i2 + 1]);
        bArr2[i3] = (byte) (j | ((j2 >>> 2) & 7));
        if (i == 1) {
            CodecUtils.sanityCheckLastPos(j2, 3);
            return;
        }
        int i9 = i3 + 2;
        int j3 = ((j2 & 3) << 6) | (j(bArr[i8]) << 1);
        int i10 = i2 + 4;
        int j4 = j(bArr[i2 + 3]);
        bArr2[i4] = (byte) (j3 | ((j4 >>> 4) & 1));
        if (i == 2) {
            CodecUtils.sanityCheckLastPos(j4, 15);
            return;
        }
        int i11 = i3 + 3;
        int i12 = i2 + 5;
        int j8 = j(bArr[i10]);
        bArr2[i9] = (byte) ((15 & (j8 >>> 1)) | ((j4 & 15) << 4));
        if (i == 3) {
            CodecUtils.sanityCheckLastPos(j8, 1);
            return;
        }
        int j9 = ((j8 & 1) << 7) | (j(bArr[i12]) << 2);
        int j10 = j(bArr[i2 + 6]);
        bArr2[i11] = (byte) (j9 | ((j10 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(j10, 7);
    }

    private final void c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int j = j(bArr[i]) << 3;
        int j2 = j(bArr[i + 1]);
        bArr2[i2] = (byte) (j | ((j2 >>> 2) & 7));
        int j3 = ((j2 & 3) << 6) | (j(bArr[i + 2]) << 1);
        int j4 = j(bArr[i + 3]);
        bArr2[i2 + 1] = (byte) (j3 | ((j4 >>> 4) & 1));
        int j8 = j(bArr[i + 4]);
        bArr2[i2 + 2] = (byte) (((j4 & 15) << 4) | ((j8 >>> 1) & 15));
        int j9 = ((j8 & 1) << 7) | (j(bArr[i + 5]) << 2);
        int j10 = j(bArr[i + 6]);
        bArr2[i2 + 3] = (byte) (j9 | ((j10 >>> 3) & 3));
        bArr2[i2 + 4] = (byte) (j(bArr[i + 7]) | ((j10 & 7) << 5));
    }

    private final void e(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        int i4 = i2 + 2;
        bArr2[i3] = bArr3[(b & 7) << 2];
        int i8 = 0;
        while (i8 < 6) {
            bArr2[i4] = 61;
            i8++;
            i4++;
        }
    }

    private final void f(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        int i3 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i3];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int i4 = i2 + 3;
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        int i8 = i2 + 4;
        bArr2[i4] = bArr3[(b2 & 1) << 4];
        int i9 = 0;
        while (i9 < 4) {
            bArr2[i8] = 61;
            i9++;
            i8++;
        }
    }

    private final void g(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        int i3 = i2 + 4;
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b3 >>> 4) & 15) | ((b2 & 1) << 4)];
        int i4 = i2 + 5;
        bArr2[i3] = bArr3[(b3 & 15) << 1];
        int i8 = 0;
        while (i8 < 3) {
            bArr2[i4] = 61;
            i8++;
            i4++;
        }
    }

    private final void h(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b2 & 1) << 4) | ((b3 >>> 4) & 15)];
        byte b4 = bArr[i + 3];
        bArr2[i2 + 4] = bArr3[((b4 >>> 7) & 1) | ((b3 & 15) << 1)];
        bArr2[i2 + 5] = bArr3[(b4 >>> 2) & 31];
        bArr2[i2 + 6] = bArr3[(b4 & 3) << 3];
        bArr2[i2 + 7] = 61;
    }

    private final void i(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b2 & 1) << 4) | ((b3 >>> 4) & 15)];
        byte b4 = bArr[i + 3];
        bArr2[i2 + 4] = bArr3[((b3 & 15) << 1) | ((b4 >>> 7) & 1)];
        bArr2[i2 + 5] = bArr3[(b4 >>> 2) & 31];
        byte b8 = bArr[i + 4];
        bArr2[i2 + 6] = bArr3[((b8 >>> 5) & 7) | ((b4 & 3) << 3)];
        bArr2[i2 + 7] = bArr3[b8 & 31];
    }

    public final byte[] a(byte[] bArr, int i) {
        int i2;
        if (i % 8 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + i);
        }
        int i3 = i - 1;
        int i4 = 0;
        while (i4 < 6 && i3 > -1 && bArr[i3] == 61) {
            i3--;
            i4++;
        }
        if (i4 != 0) {
            int i8 = 4;
            if (i4 != 1) {
                i2 = 3;
                if (i4 != 3) {
                    if (i4 == 4) {
                        i8 = 2;
                    } else {
                        if (i4 != 6) {
                            throw new IllegalArgumentException("Invalid number of paddings " + i4);
                        }
                        i2 = 1;
                    }
                }
            }
            i2 = i8;
        } else {
            i2 = 5;
        }
        int i9 = ((i / 8) * 5) - (5 - i2);
        byte[] bArr2 = new byte[i9];
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9 - (i2 % 5)) {
            c(bArr, i10, bArr2, i11);
            i10 += 8;
            i11 += 5;
        }
        if (i2 < 5) {
            b(i2, bArr, i10, bArr2, i11);
        }
        return bArr2;
    }

    public final byte[] d(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int i = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 8];
            int i2 = 0;
            while (i < bArr.length) {
                i(bArr, i, bArr2, i2);
                i += 5;
                i2 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 8];
        int i3 = 0;
        while (i < bArr.length - length2) {
            i(bArr, i, bArr3, i3);
            i += 5;
            i3 += 8;
        }
        if (length2 == 1) {
            e(bArr, i, bArr3, i3);
        } else if (length2 == 2) {
            f(bArr, i, bArr3, i3);
        } else if (length2 == 3) {
            g(bArr, i, bArr3, i3);
        } else if (length2 == 4) {
            h(bArr, i, bArr3, i3);
        }
        return bArr3;
    }

    protected abstract int j(byte b);
}
