package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class Base16Codec {
    private final byte[] a = CodecUtils.toBytesDirect("0123456789ABCDEF");

    private static class LazyHolder {
        private static final byte[] a = b();

        private static byte[] b() {
            byte[] bArr = new byte[103];
            for (int i = 0; i <= 102; i++) {
                if (i >= 48 && i <= 57) {
                    bArr[i] = (byte) (i - 48);
                } else if (i >= 65 && i <= 70) {
                    bArr[i] = (byte) (i - 55);
                } else if (i < 97 || i > 102) {
                    bArr[i] = -1;
                } else {
                    bArr[i] = (byte) (i - 87);
                }
            }
            return bArr;
        }
    }

    Base16Codec() {
    }

    public byte[] a(byte[] bArr, int i) {
        if (i % 2 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + i);
        }
        int i2 = i / 2;
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i8 = i3 + 1;
            int c = c(bArr[i3]) << 4;
            i3 += 2;
            bArr2[i4] = (byte) (c(bArr[i8]) | c);
        }
        return bArr2;
    }

    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            byte[] bArr3 = this.a;
            bArr2[i] = bArr3[(b >>> 4) & 15];
            i += 2;
            bArr2[i2] = bArr3[b & 15];
        }
        return bArr2;
    }

    protected int c(byte b) {
        byte b2 = LazyHolder.a[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b) + "'");
    }
}
