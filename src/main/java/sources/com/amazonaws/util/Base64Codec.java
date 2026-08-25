package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class Base64Codec {
    private final byte[] a = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    private static class LazyHolder {
        private static final byte[] a = b();

        private static byte[] b() {
            byte[] bArr = new byte[123];
            for (int i = 0; i <= 122; i++) {
                if (i >= 65 && i <= 90) {
                    bArr[i] = (byte) (i - 65);
                } else if (i >= 48 && i <= 57) {
                    bArr[i] = (byte) (i + 4);
                } else if (i == 43) {
                    bArr[i] = (byte) (i + 19);
                } else if (i == 47) {
                    bArr[i] = (byte) (i + 16);
                } else if (i < 97 || i > 122) {
                    bArr[i] = -1;
                } else {
                    bArr[i] = (byte) (i - 71);
                }
            }
            return bArr;
        }
    }

    Base64Codec() {
    }

    public byte[] a(byte[] bArr, int i) {
        int i2;
        if (i % 4 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + i);
        }
        int i3 = i - 1;
        int i4 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= 2 || i3 <= -1 || bArr[i3] != 61) {
                break;
            }
            i3--;
            i4++;
        }
        if (i4 == 0) {
            i2 = 3;
        } else if (i4 != 1) {
            if (i4 != 2) {
                throw new Error("Impossible");
            }
            i2 = 1;
        }
        int i8 = ((i / 4) * 3) - (3 - i2);
        byte[] bArr2 = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        while (i10 < i8 - (i2 % 3)) {
            c(bArr, i9, bArr2, i10);
            i9 += 4;
            i10 += 3;
        }
        if (i2 < 3) {
            b(i2, bArr, i9, bArr2, i10);
        }
        return bArr2;
    }

    void b(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i3 + 1;
        int h = h(bArr[i2]) << 2;
        int i8 = i2 + 2;
        int h2 = h(bArr[i2 + 1]);
        bArr2[i3] = (byte) (h | ((h2 >>> 4) & 3));
        if (i == 1) {
            CodecUtils.sanityCheckLastPos(h2, 15);
            return;
        }
        int i9 = i3 + 2;
        int i10 = i2 + 3;
        int h3 = h(bArr[i8]);
        bArr2[i4] = (byte) (((h2 & 15) << 4) | (15 & (h3 >>> 2)));
        if (i == 2) {
            CodecUtils.sanityCheckLastPos(h3, 3);
        } else {
            bArr2[i9] = (byte) (((h3 & 3) << 6) | h(bArr[i10]));
        }
    }

    void c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int h = h(bArr[i]) << 2;
        int h2 = h(bArr[i + 1]);
        bArr2[i2] = (byte) (h | ((h2 >>> 4) & 3));
        int h3 = h(bArr[i + 2]);
        bArr2[i2 + 1] = (byte) (((h2 & 15) << 4) | ((h3 >>> 2) & 15));
        bArr2[i2 + 2] = (byte) (h(bArr[i + 3]) | ((h3 & 3) << 6));
    }

    public byte[] d(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int i2 = 0;
            while (i < bArr.length) {
                g(bArr, i, bArr2, i2);
                i += 3;
                i2 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int i3 = 0;
        while (i < bArr.length - length2) {
            g(bArr, i, bArr3, i3);
            i += 3;
            i3 += 4;
        }
        if (length2 == 1) {
            e(bArr, i, bArr3, i3);
        } else if (length2 == 2) {
            f(bArr, i, bArr3, i3);
        }
        return bArr3;
    }

    void e(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        bArr2[i2 + 1] = bArr3[(b & 3) << 4];
        bArr2[i2 + 2] = 61;
        bArr2[i2 + 3] = 61;
    }

    void f(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        int i3 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        byte b2 = bArr[i3];
        bArr2[i2 + 1] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[i2 + 2] = bArr3[(b2 & 15) << 2];
        bArr2[i2 + 3] = 61;
    }

    void g(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        byte b3 = bArr[i + 2];
        bArr2[i2 + 2] = bArr3[((b3 >>> 6) & 3) | ((b2 & 15) << 2)];
        bArr2[i2 + 3] = bArr3[b3 & 63];
    }

    protected int h(byte b) {
        byte b2 = LazyHolder.a[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b) + "'");
    }
}
