package dz;

import java.io.IOException;
import java.math.BigInteger;
import okhttp3.HttpUrl;
import org.apache.commons.compress.archivers.zip.r;
import org.apache.commons.compress.archivers.zip.s;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class d {
    static final r a = s.a(null);
    static final r b = new a();

    static class a implements r {
        a() {
        }

        @Override // org.apache.commons.compress.archivers.zip.r
        public String a(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length);
            for (byte b : bArr) {
                if (b == 0) {
                    break;
                }
                sb.append((char) (b & 255));
            }
            return sb.toString();
        }
    }

    private static String a(byte[] bArr, int i, int i2, int i3, byte b2) {
        return "Invalid byte " + ((int) b2) + " at offset " + (i3 - i) + " in '" + new String(bArr, i, i2).replaceAll("\u0000", "{NUL}") + "' len=" + i2;
    }

    private static long b(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 1, bArr2, 0, i3);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1L)).not();
        }
        if (bigInteger.bitLength() <= 63) {
            long longValue = bigInteger.longValue();
            return z ? -longValue : longValue;
        }
        throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number exceeds maximum signed long value");
    }

    private static long c(byte[] bArr, int i, int i2, boolean z) {
        if (i2 >= 9) {
            throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number exceeds maximum signed long value");
        }
        long j = 0;
        for (int i3 = 1; i3 < i2; i3++) {
            j = (j << 8) + (bArr[i + i3] & 255);
        }
        if (z) {
            j = (j - 1) ^ (((long) Math.pow(2.0d, (i2 - 1) * 8.0d)) - 1);
        }
        return z ? -j : j;
    }

    public static boolean d(byte[] bArr, int i) {
        return bArr[i] == 1;
    }

    public static String e(byte[] bArr, int i, int i2) {
        try {
            try {
                return f(bArr, i, i2, a);
            } catch (IOException unused) {
                return f(bArr, i, i2, b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String f(byte[] bArr, int i, int i2, r rVar) {
        int i3 = 0;
        for (int i4 = i; i3 < i2 && bArr[i4] != 0; i4++) {
            i3++;
        }
        if (i3 <= 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return rVar.a(bArr2);
    }

    public static long g(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i2 < 2) {
            throw new IllegalArgumentException("Length " + i2 + " must be at least 2");
        }
        long j = 0;
        if (bArr[i] == 0) {
            return 0L;
        }
        int i4 = i;
        while (i4 < i3 && bArr[i4] == 32) {
            i4++;
        }
        byte b2 = bArr[i3 - 1];
        while (i4 < i3 && (b2 == 0 || b2 == 32)) {
            b2 = bArr[i3 - 2];
            i3--;
        }
        while (i4 < i3) {
            byte b3 = bArr[i4];
            if (b3 < 48 || b3 > 55) {
                throw new IllegalArgumentException(a(bArr, i, i2, i4, b3));
            }
            j = (j << 3) + (b3 - 48);
            i4++;
        }
        return j;
    }

    public static long h(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        if ((b2 & 128) == 0) {
            return g(bArr, i, i2);
        }
        boolean z = b2 == -1;
        return i2 < 9 ? c(bArr, i, i2, z) : b(bArr, i, i2, z);
    }

    public static boolean i(byte[] bArr) {
        long g = g(bArr, 148, 8);
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (148 <= i && i < 156) {
                b2 = 32;
            }
            j += b2 & 255;
            j2 += b2;
        }
        return g == j || g == j2;
    }
}
