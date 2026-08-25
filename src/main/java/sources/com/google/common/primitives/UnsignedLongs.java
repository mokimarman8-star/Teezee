package com.google.common.primitives;

import com.google.common.base.m;
import com.mbridge.msdk.MBridgeConstans;
import java.math.BigInteger;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class UnsignedLongs {

    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                long j = jArr[i];
                long j2 = jArr2[i];
                if (j != j2) {
                    return UnsignedLongs.a(j, j2);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    private static final class a {
        static final long[] a = new long[37];
        static final int[] b = new int[37];
        static final int[] c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                a[i] = UnsignedLongs.b(-1L, j);
                b[i] = (int) UnsignedLongs.e(-1L, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long j2 = a[i2];
            if (j < j2) {
                return false;
            }
            return j > j2 || i > b[i2];
        }
    }

    public static int a(long j, long j2) {
        return Longs.c(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + (a(j - (j3 * j2), j2) < 0 ? 0 : 1);
    }

    private static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static long d(String str, int i) {
        m.o(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        }
        int i2 = a.c[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int digit = Character.digit(str.charAt(i3), i);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i3 > i2 && a.a(j, digit, i)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j = (j * i) + digit;
        }
        return j;
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i) {
        m.f(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL;
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long b = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : b(j, i);
            long j2 = i;
            int i4 = 63;
            cArr[63] = Character.forDigit((int) (j - (b * j2)), i);
            while (b > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (b % j2), i);
                b /= j2;
            }
            i2 = i4;
        }
        return new String(cArr, i2, 64 - i2);
    }
}
