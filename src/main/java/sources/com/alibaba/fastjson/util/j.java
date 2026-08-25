package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.math.BigInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class j {
    private static final int[][] a;
    private static final int[][] b;

    static {
        Class cls = Integer.TYPE;
        a = (int[][]) Array.newInstance((Class<?>) cls, 326, 4);
        b = (int[][]) Array.newInstance((Class<?>) cls, 291, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger subtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger subtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i = 0;
        while (i < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i);
            int bitLength = pow.bitLength();
            int i2 = i == 0 ? 1 : (int) (((i * 23219280) + 9999999) / 10000000);
            if (i2 != bitLength) {
                throw new IllegalStateException(bitLength + " != " + i2);
            }
            if (i < a.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    a[i][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                }
            }
            if (i < b.length) {
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger add = bigInteger2.shiftLeft(bitLength + 121).divide(pow).add(bigInteger2);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        b[i][i4] = add.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        b[i][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static int a(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        long j;
        boolean z3;
        boolean z4;
        long j2;
        long j3;
        long j4;
        int i4;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z7;
        boolean z8;
        int i12;
        int i13;
        int i14;
        int i15;
        if (Double.isNaN(d)) {
            cArr[i] = 'N';
            cArr[i + 1] = 'a';
            i15 = i + 3;
            cArr[i + 2] = 'N';
        } else {
            if (d == Double.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                cArr[i + 7] = 'y';
                return (i + 8) - i;
            }
            if (d == Double.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i15 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d);
                if (doubleToLongBits != 0) {
                    if (doubleToLongBits == Long.MIN_VALUE) {
                        cArr[i] = '-';
                        cArr[i + 1] = '0';
                        cArr[i + 2] = '.';
                        i11 = i + 4;
                        cArr[i + 3] = '0';
                    } else {
                        int i16 = (int) ((doubleToLongBits >>> 52) & 2047);
                        long j8 = doubleToLongBits & 4503599627370495L;
                        if (i16 == 0) {
                            i2 = -1074;
                        } else {
                            i2 = i16 - 1075;
                            j8 |= 4503599627370496L;
                        }
                        boolean z9 = doubleToLongBits < 0;
                        boolean z10 = (j8 & 1) == 0;
                        long j9 = 4 * j8;
                        long j10 = j9 + 2;
                        int i17 = (j8 != 4503599627370496L || i16 <= 1) ? 1 : 0;
                        long j11 = (j9 - 1) - i17;
                        int i18 = i2 - 2;
                        int i19 = 3;
                        if (i18 >= 0) {
                            int max = Math.max(0, ((int) ((i18 * 3010299) / 10000000)) - 1);
                            int i20 = (((-i18) + max) + ((max == 0 ? 1 : (int) (((max * 23219280) + 9999999) / 10000000)) + 121)) - 114;
                            if (i20 < 0) {
                                throw new IllegalArgumentException("" + i20);
                            }
                            int[] iArr = b[max];
                            long j12 = j9 >>> 31;
                            long j13 = j9 & 2147483647L;
                            int i21 = iArr[0];
                            int i22 = iArr[1];
                            z = z9;
                            int i23 = iArr[2];
                            z2 = z10;
                            int i24 = iArr[3];
                            long j14 = ((((((((((((j13 * i24) >>> 31) + (i23 * j13)) + (j12 * i24)) >>> 31) + (i22 * j13)) + (i23 * j12)) >>> 31) + (i21 * j13)) + (i22 * j12)) >>> 21) + ((i21 * j12) << 10)) >>> i20;
                            long j15 = j10 >>> 31;
                            long j16 = j10 & 2147483647L;
                            long j17 = ((((((((((((j16 * i24) >>> 31) + (i23 * j16)) + (j15 * i24)) >>> 31) + (i22 * j16)) + (i23 * j15)) >>> 31) + (i21 * j16)) + (i22 * j15)) >>> 21) + ((i21 * j15) << 10)) >>> i20;
                            long j18 = j11 >>> 31;
                            long j19 = j11 & 2147483647L;
                            j = j17;
                            long j20 = ((((((((((((j19 * i24) >>> 31) + (i23 * j19)) + (j18 * i24)) >>> 31) + (i22 * j19)) + (i23 * j18)) >>> 31) + (i21 * j19)) + (i22 * j18)) >>> 21) + ((i21 * j18) << 10)) >>> i20;
                            if (max <= 21) {
                                long j21 = j9 % 5;
                                if (j21 == 0) {
                                    if (j21 != 0) {
                                        i14 = 0;
                                    } else if (j9 % 25 != 0) {
                                        i14 = 1;
                                    } else if (j9 % 125 != 0) {
                                        i14 = 2;
                                    } else if (j9 % 625 != 0) {
                                        i14 = 3;
                                    } else {
                                        long j22 = j9 / 625;
                                        i14 = 4;
                                        for (long j23 = 0; j22 > j23 && j22 % 5 == j23; j23 = 0) {
                                            j22 /= 5;
                                            i14++;
                                        }
                                    }
                                    if (i14 >= max) {
                                        z7 = true;
                                        z8 = false;
                                        z4 = z7;
                                        z3 = z8;
                                        i3 = max;
                                        j2 = j20;
                                        j3 = j14;
                                    }
                                } else if (z2) {
                                    if (j11 % 5 != 0) {
                                        i13 = 0;
                                    } else if (j11 % 25 != 0) {
                                        i13 = 1;
                                    } else if (j11 % 125 != 0) {
                                        i13 = 2;
                                    } else if (j11 % 625 != 0) {
                                        i13 = 3;
                                    } else {
                                        long j24 = j11 / 625;
                                        i13 = 4;
                                        for (long j25 = 0; j24 > j25 && j24 % 5 == j25; j25 = 0) {
                                            j24 /= 5;
                                            i13++;
                                        }
                                    }
                                    z8 = i13 >= max;
                                    z7 = false;
                                    z4 = z7;
                                    z3 = z8;
                                    i3 = max;
                                    j2 = j20;
                                    j3 = j14;
                                } else {
                                    if (j10 % 5 != 0) {
                                        i12 = 0;
                                    } else if (j10 % 25 != 0) {
                                        i12 = 1;
                                    } else if (j10 % 125 != 0) {
                                        i12 = 2;
                                    } else if (j10 % 625 != 0) {
                                        i12 = 3;
                                    } else {
                                        long j26 = j10 / 625;
                                        i12 = 4;
                                        for (long j27 = 0; j26 > j27 && j26 % 5 == j27; j27 = 0) {
                                            j26 /= 5;
                                            i12++;
                                        }
                                    }
                                    if (i12 >= max) {
                                        j--;
                                    }
                                }
                            }
                            z7 = false;
                            z8 = false;
                            z4 = z7;
                            z3 = z8;
                            i3 = max;
                            j2 = j20;
                            j3 = j14;
                        } else {
                            z = z9;
                            z2 = z10;
                            int i25 = -i18;
                            int max2 = Math.max(0, ((int) ((i25 * 6989700) / 10000000)) - 1);
                            int i26 = i25 - max2;
                            int i27 = (max2 - ((i26 == 0 ? 1 : (int) (((i26 * 23219280) + 9999999) / 10000000)) - 121)) - 114;
                            if (i27 < 0) {
                                throw new IllegalArgumentException("" + i27);
                            }
                            int[] iArr2 = a[i26];
                            long j28 = j9 >>> 31;
                            long j29 = j9 & 2147483647L;
                            int i28 = iArr2[0];
                            int i29 = iArr2[1];
                            int i30 = i17;
                            int i31 = iArr2[2];
                            int i32 = iArr2[3];
                            long j30 = ((((((((((((j29 * i32) >>> 31) + (i31 * j29)) + (j28 * i32)) >>> 31) + (i29 * j29)) + (i31 * j28)) >>> 31) + (i28 * j29)) + (i29 * j28)) >>> 21) + ((i28 * j28) << 10)) >>> i27;
                            long j31 = j10 >>> 31;
                            long j32 = j10 & 2147483647L;
                            long j33 = ((((((((((((i32 * j32) >>> 31) + (i31 * j32)) + (j31 * i32)) >>> 31) + (i29 * j32)) + (i31 * j31)) >>> 31) + (i28 * j32)) + (i29 * j31)) >>> 21) + ((i28 * j31) << 10)) >>> i27;
                            long j34 = j11 >>> 31;
                            long j35 = j11 & 2147483647L;
                            long j36 = ((((((((((((i32 * j35) >>> 31) + (i31 * j35)) + (j34 * i32)) >>> 31) + (i29 * j35)) + (i31 * j34)) >>> 31) + (i28 * j35)) + (i29 * j34)) >>> 21) + ((i28 * j34) << 10)) >>> i27;
                            int i33 = max2 + i18;
                            if (max2 <= 1) {
                                if (z2) {
                                    i3 = i33;
                                    z4 = true;
                                    j = j33;
                                    z3 = i30 == 1;
                                    j2 = j36;
                                    j3 = j30;
                                } else {
                                    j = j33 - 1;
                                    i3 = i33;
                                    z4 = true;
                                    z3 = false;
                                    j2 = j36;
                                    j3 = j30;
                                }
                            } else if (max2 < 63) {
                                i3 = i33;
                                z4 = (j9 & ((1 << (max2 - 1)) - 1)) == 0;
                                j = j33;
                                z3 = false;
                                j2 = j36;
                                j3 = j30;
                            } else {
                                i3 = i33;
                                j = j33;
                                z3 = false;
                                z4 = false;
                                j2 = j36;
                                j3 = j30;
                            }
                        }
                        if (j >= 1000000000000000000L) {
                            i19 = 19;
                        } else if (j >= 100000000000000000L) {
                            i19 = 18;
                        } else if (j >= 10000000000000000L) {
                            i19 = 17;
                        } else if (j >= 1000000000000000L) {
                            i19 = 16;
                        } else if (j >= 100000000000000L) {
                            i19 = 15;
                        } else if (j >= 10000000000000L) {
                            i19 = 14;
                        } else if (j >= 1000000000000L) {
                            i19 = 13;
                        } else if (j >= 100000000000L) {
                            i19 = 12;
                        } else if (j >= 10000000000L) {
                            i19 = 11;
                        } else if (j >= 1000000000) {
                            i19 = 10;
                        } else if (j >= 100000000) {
                            i19 = 9;
                        } else if (j >= 10000000) {
                            i19 = 8;
                        } else if (j >= 1000000) {
                            i19 = 7;
                        } else if (j >= 100000) {
                            i19 = 6;
                        } else if (j >= 10000) {
                            i19 = 5;
                        } else if (j >= 1000) {
                            i19 = 4;
                        } else if (j < 100) {
                            i19 = j >= 10 ? 2 : 1;
                        }
                        int i34 = i3 + i19;
                        int i35 = i34 - 1;
                        boolean z11 = i35 < -3 || i35 >= 7;
                        if (z3 || z4) {
                            boolean z12 = z3;
                            boolean z13 = z4;
                            int i36 = 0;
                            int i37 = 0;
                            while (true) {
                                long j37 = j / 10;
                                long j38 = j2 / 10;
                                if (j37 <= j38 || (j < 100 && z11)) {
                                    break;
                                }
                                z12 &= j2 % 10 == 0;
                                z13 &= i36 == 0;
                                i36 = (int) (j3 % 10);
                                j3 /= 10;
                                i37++;
                                j = j37;
                                j2 = j38;
                            }
                            if (z12 && z2) {
                                while (j2 % 10 == 0 && (j >= 100 || !z11)) {
                                    z13 &= i36 == 0;
                                    i36 = (int) (j3 % 10);
                                    j /= 10;
                                    j3 /= 10;
                                    j2 /= 10;
                                    i37++;
                                }
                            }
                            if (z13 && i36 == 5 && j3 % 2 == 0) {
                                i36 = 4;
                            }
                            j4 = j3 + (((j3 != j2 || (z12 && z2)) && i36 < 5) ? 0 : 1);
                            i4 = i37;
                        } else {
                            i4 = 0;
                            int i38 = 0;
                            while (true) {
                                long j39 = j / 10;
                                long j40 = j2 / 10;
                                if (j39 <= j40 || (j < 100 && z11)) {
                                    break;
                                }
                                i38 = (int) (j3 % 10);
                                j3 /= 10;
                                i4++;
                                j = j39;
                                j2 = j40;
                            }
                            j4 = j3 + ((j3 == j2 || i38 >= 5) ? 1 : 0);
                        }
                        int i39 = i19 - i4;
                        if (z) {
                            i8 = i + 1;
                            cArr[i] = '-';
                        } else {
                            i8 = i;
                        }
                        if (!z11) {
                            char c = '0';
                            if (i35 < 0) {
                                int i40 = i8 + 1;
                                cArr[i8] = '0';
                                int i41 = i8 + 2;
                                cArr[i40] = '.';
                                int i42 = -1;
                                while (i42 > i35) {
                                    cArr[i41] = c;
                                    i42--;
                                    i41++;
                                    c = '0';
                                }
                                i9 = i41;
                                for (int i43 = 0; i43 < i39; i43++) {
                                    cArr[((i41 + i39) - i43) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                    i9++;
                                }
                            } else if (i34 >= i39) {
                                for (int i44 = 0; i44 < i39; i44++) {
                                    cArr[((i8 + i39) - i44) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                int i45 = i8 + i39;
                                while (i39 < i34) {
                                    cArr[i45] = '0';
                                    i39++;
                                    i45++;
                                }
                                cArr[i45] = '.';
                                i9 = i45 + 2;
                                cArr[i45 + 1] = '0';
                            } else {
                                int i46 = i8 + 1;
                                for (int i47 = 0; i47 < i39; i47++) {
                                    if ((i39 - i47) - 1 == i35) {
                                        cArr[((i46 + i39) - i47) - 1] = '.';
                                        i46--;
                                    }
                                    cArr[((i46 + i39) - i47) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                i9 = i8 + i39 + 1;
                            }
                            return i9 - i;
                        }
                        for (int i48 = 0; i48 < i39 - 1; i48++) {
                            int i49 = (int) (j4 % 10);
                            j4 /= 10;
                            cArr[(i8 + i39) - i48] = (char) (i49 + 48);
                        }
                        cArr[i8] = (char) ((j4 % 10) + 48);
                        cArr[i8 + 1] = '.';
                        int i50 = i8 + i39 + 1;
                        if (i39 == 1) {
                            cArr[i50] = '0';
                            i50++;
                        }
                        int i51 = i50 + 1;
                        cArr[i50] = 'E';
                        if (i35 < 0) {
                            cArr[i51] = '-';
                            i35 = -i35;
                            i51 = i50 + 2;
                        }
                        if (i35 >= 100) {
                            int i52 = i51 + 1;
                            i10 = 48;
                            cArr[i51] = (char) ((i35 / 100) + 48);
                            i35 %= 100;
                            i51 += 2;
                            cArr[i52] = (char) ((i35 / 10) + 48);
                        } else {
                            i10 = 48;
                            if (i35 >= 10) {
                                cArr[i51] = (char) ((i35 / 10) + 48);
                                i51++;
                            }
                        }
                        i11 = i51 + 1;
                        cArr[i51] = (char) ((i35 % 10) + i10);
                    }
                    return i11 - i;
                }
                cArr[i] = '0';
                cArr[i + 1] = '.';
                i15 = i + 3;
                cArr[i + 2] = '0';
            }
        }
        return i15 - i;
    }

    public static String b(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, a(d, cArr, 0));
    }
}
