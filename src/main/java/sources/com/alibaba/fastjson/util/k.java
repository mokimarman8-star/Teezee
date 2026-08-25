package com.alibaba.fastjson.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class k {
    private static final int[][] a = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] b = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static int a(float f, char[] cArr, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        if (!Float.isNaN(f)) {
            if (f == Float.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i19 = i + 8;
                cArr[i + 7] = 'y';
            } else if (f == Float.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i20 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                int floatToIntBits = Float.floatToIntBits(f);
                if (floatToIntBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = '.';
                    i20 = i + 3;
                    cArr[i + 2] = '0';
                } else {
                    if (floatToIntBits != Integer.MIN_VALUE) {
                        int i21 = (floatToIntBits >> 23) & 255;
                        int i22 = 8388607 & floatToIntBits;
                        if (i21 == 0) {
                            i2 = -149;
                        } else {
                            i2 = i21 - 150;
                            i22 |= 8388608;
                        }
                        boolean z2 = floatToIntBits < 0;
                        boolean z3 = (i22 & 1) == 0;
                        int i23 = i22 * 4;
                        int i24 = i23 + 2;
                        int i25 = i23 - ((((long) i22) != 8388608 || i21 <= 1) ? 2 : 1);
                        int i26 = i2 - 2;
                        if (i26 >= 0) {
                            i12 = (int) ((i26 * 3010299) / 10000000);
                            int i27 = i12 == 0 ? 1 : (int) (((i12 * 23219280) + 9999999) / 10000000);
                            int i28 = (-i26) + i12;
                            int[][] iArr = b;
                            int[] iArr2 = iArr[i12];
                            long j = iArr2[0];
                            long j2 = iArr2[1];
                            long j3 = i23;
                            int i29 = ((i27 + 58) + i28) - 31;
                            i3 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i29);
                            long j4 = i24;
                            i15 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i29);
                            z = z3;
                            int i30 = i25;
                            long j8 = i30;
                            i4 = (int) (((j * j8) + ((j8 * j2) >> 31)) >> i29);
                            if (i12 == 0 || (i15 - 1) / 10 > i4 / 10) {
                                i11 = 0;
                            } else {
                                int i31 = i12 - 1;
                                int i32 = (i28 - 1) + (i31 == 0 ? 1 : (int) (((i31 * 23219280) + 9999999) / 10000000)) + 58;
                                int[] iArr3 = iArr[i31];
                                i11 = (int) ((((iArr3[0] * j3) + ((j3 * iArr3[1]) >> 31)) >> (i32 - 31)) % 10);
                            }
                            int i33 = 0;
                            while (i24 > 0 && i24 % 5 == 0) {
                                i24 /= 5;
                                i33++;
                            }
                            int i34 = i23;
                            int i35 = 0;
                            while (i34 > 0 && i34 % 5 == 0) {
                                i34 /= 5;
                                i35++;
                            }
                            int i36 = 0;
                            while (i30 > 0 && i30 % 5 == 0) {
                                i30 /= 5;
                                i36++;
                            }
                            i13 = i33 >= i12 ? 1 : 0;
                            int i37 = i35 >= i12 ? 1 : 0;
                            i14 = i36 >= i12 ? 1 : 0;
                            i10 = i37;
                            i8 = 0;
                        } else {
                            z = z3;
                            int i38 = -i26;
                            int i39 = (int) ((i38 * 6989700) / 10000000);
                            int i40 = i38 - i39;
                            int i41 = i40 == 0 ? 1 : (int) (((i40 * 23219280) + 9999999) / 10000000);
                            int[][] iArr4 = a;
                            int[] iArr5 = iArr4[i40];
                            long j9 = iArr5[0];
                            long j10 = iArr5[1];
                            int i42 = (i39 - (i41 - 61)) - 31;
                            long j11 = i23;
                            long j12 = i24;
                            int i43 = (int) (((j12 * j9) + ((j12 * j10) >> 31)) >> i42);
                            i3 = (int) (((j11 * j9) + ((j11 * j10) >> 31)) >> i42);
                            long j13 = i25;
                            i4 = (int) (((j9 * j13) + ((j13 * j10) >> 31)) >> i42);
                            if (i39 == 0 || (i43 - 1) / 10 > i4 / 10) {
                                i8 = 0;
                                i9 = 0;
                            } else {
                                int i44 = i40 + 1;
                                int i45 = (i39 - 1) - ((i44 == 0 ? 1 : (int) (((i44 * 23219280) + 9999999) / 10000000)) - 61);
                                int[] iArr6 = iArr4[i44];
                                i8 = 0;
                                i9 = (int) ((((iArr6[0] * j11) + ((j11 * iArr6[1]) >> 31)) >> (i45 - 31)) % 10);
                            }
                            int i46 = i26 + i39;
                            int i47 = 1 >= i39 ? 1 : i8;
                            i10 = (i39 >= 23 || (i23 & ((1 << (i39 + (-1))) - 1)) != 0) ? i8 : 1;
                            int i48 = (i25 % 2 == 1 ? i8 : 1) >= i39 ? 1 : i8;
                            i11 = i9;
                            i12 = i46;
                            i13 = i47;
                            i14 = i48;
                            i15 = i43;
                        }
                        int i49 = 1000000000;
                        int i50 = 10;
                        while (i50 > 0 && i15 < i49) {
                            i49 /= 10;
                            i50--;
                        }
                        int i51 = i12 + i50;
                        int i52 = i51 - 1;
                        int i53 = (i52 < -3 || i52 >= 7) ? 1 : i8;
                        if (i13 != 0 && !z) {
                            i15--;
                        }
                        int i54 = i8;
                        while (true) {
                            int i55 = i15 / 10;
                            int i56 = i4 / 10;
                            if (i55 <= i56 || (i15 < 100 && i53 != 0)) {
                                break;
                            }
                            i14 &= i4 % 10 == 0 ? 1 : i8;
                            i11 = i3 % 10;
                            i3 /= 10;
                            i54++;
                            i15 = i55;
                            i4 = i56;
                        }
                        if (i14 != 0 && z) {
                            while (i4 % 10 == 0 && (i15 >= 100 || i53 == 0)) {
                                i15 /= 10;
                                i11 = i3 % 10;
                                i3 /= 10;
                                i4 /= 10;
                                i54++;
                            }
                        }
                        int i57 = i3;
                        if (i10 != 0 && i11 == 5 && i57 % 2 == 0) {
                            i11 = 4;
                        }
                        int i58 = (((i57 != i4 || (i14 != 0 && z)) && i11 < 5) ? i8 : 1) + i57;
                        int i59 = i50 - i54;
                        if (z2) {
                            i16 = i + 1;
                            cArr[i] = '-';
                        } else {
                            i16 = i;
                        }
                        if (i53 != 0) {
                            while (i8 < i59 - 1) {
                                int i60 = i58 % 10;
                                i58 /= 10;
                                cArr[(i16 + i59) - i8] = (char) (i60 + 48);
                                i8++;
                            }
                            cArr[i16] = (char) ((i58 % 10) + 48);
                            cArr[i16 + 1] = '.';
                            int i61 = i16 + i59 + 1;
                            if (i59 == 1) {
                                cArr[i61] = '0';
                                i61++;
                            }
                            int i62 = i61 + 1;
                            cArr[i61] = 'E';
                            if (i52 < 0) {
                                cArr[i62] = '-';
                                i52 = -i52;
                                i62 = i61 + 2;
                            }
                            if (i52 >= 10) {
                                i18 = 48;
                                cArr[i62] = (char) ((i52 / 10) + 48);
                                i62++;
                            } else {
                                i18 = 48;
                            }
                            i17 = i62 + 1;
                            cArr[i62] = (char) ((i52 % 10) + i18);
                        } else {
                            int i63 = 48;
                            if (i52 < 0) {
                                int i64 = i16 + 1;
                                cArr[i16] = '0';
                                int i65 = i16 + 2;
                                cArr[i64] = '.';
                                int i66 = -1;
                                while (i66 > i52) {
                                    cArr[i65] = '0';
                                    i66--;
                                    i65++;
                                }
                                int i67 = i65;
                                int i68 = i8;
                                while (i68 < i59) {
                                    cArr[((i65 + i59) - i68) - 1] = (char) ((i58 % 10) + i63);
                                    i58 /= 10;
                                    i67++;
                                    i68++;
                                    i63 = 48;
                                }
                                i17 = i67;
                            } else if (i51 >= i59) {
                                for (int i69 = i8; i69 < i59; i69++) {
                                    cArr[((i16 + i59) - i69) - 1] = (char) ((i58 % 10) + 48);
                                    i58 /= 10;
                                }
                                int i70 = i16 + i59;
                                while (i59 < i51) {
                                    cArr[i70] = '0';
                                    i59++;
                                    i70++;
                                }
                                int i71 = i70 + 1;
                                cArr[i70] = '.';
                                i17 = i70 + 2;
                                cArr[i71] = '0';
                            } else {
                                int i72 = i16 + 1;
                                while (i8 < i59) {
                                    if ((i59 - i8) - 1 == i52) {
                                        cArr[((i72 + i59) - i8) - 1] = '.';
                                        i72--;
                                    }
                                    cArr[((i72 + i59) - i8) - 1] = (char) ((i58 % 10) + 48);
                                    i58 /= 10;
                                    i8++;
                                }
                                i17 = i16 + i59 + 1;
                            }
                        }
                        return i17 - i;
                    }
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = '.';
                    i19 = i + 4;
                    cArr[i + 3] = '0';
                }
            }
            return i19 - i;
        }
        cArr[i] = 'N';
        cArr[i + 1] = 'a';
        i20 = i + 3;
        cArr[i + 2] = 'N';
        return i20 - i;
    }

    public static String b(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, a(f, cArr, 0));
    }
}
