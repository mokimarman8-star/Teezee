package org.apache.commons.compress.archivers.zip;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class u {
    private static final byte[] a = ZipLong.getBytes(8448);

    public static long a(int i) {
        return i < 0 ? i + 4294967296L : i;
    }

    static long b(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + bigInteger + "]");
    }

    static byte[] c(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    static BigInteger d(long j) {
        if (j >= -2147483648L) {
            if (j < 0 && j >= -2147483648L) {
                j = a((int) j);
            }
            return BigInteger.valueOf(j);
        }
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + j + "]");
    }

    public static byte[] e(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            int i2 = length - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    public static int f(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static byte g(int i) {
        if (i <= 255 && i >= 0) {
            return i < 128 ? (byte) i : (byte) (i - 256);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i + "]");
    }
}
