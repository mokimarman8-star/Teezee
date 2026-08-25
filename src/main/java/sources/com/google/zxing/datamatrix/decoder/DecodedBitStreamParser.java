package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kd.i;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class DecodedBitStreamParser {
    private static final char[] b;
    private static final char[] d;
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.ECI_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        d = cArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static kd.d a(byte[] bArr) {
        int i;
        kd.c cVar = new kd.c(bArr);
        i iVar = new i(100);
        boolean z = false;
        StringBuilder sb2 = new StringBuilder(0);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        HashSet hashSet = new HashSet();
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = c(cVar, iVar, sb2, hashSet);
            } else {
                switch (a.a[mode.ordinal()]) {
                    case 1:
                        e(cVar, iVar, hashSet);
                        break;
                    case 2:
                        h(cVar, iVar, hashSet);
                        break;
                    case 3:
                        b(cVar, iVar);
                        break;
                    case 4:
                        g(cVar, iVar);
                        break;
                    case 5:
                        d(cVar, iVar, arrayList);
                        break;
                    case 6:
                        f(cVar, iVar);
                        z = true;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                mode = mode2;
            }
            if (mode != Mode.PAD_ENCODE) {
            }
            if (sb2.length() > 0) {
                iVar.e(sb2);
            }
            if (!z) {
                if (hashSet.contains(0) || hashSet.contains(4)) {
                    i = 5;
                } else if (hashSet.contains(1) || hashSet.contains(5)) {
                    i2 = 6;
                } else {
                    i = 4;
                }
                String iVar2 = iVar.toString();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new kd.d(bArr, iVar2, arrayList, null, i);
            }
            if (hashSet.contains(0) || hashSet.contains(4)) {
                i2 = 2;
            } else if (hashSet.contains(1) || hashSet.contains(5)) {
                i2 = 3;
            }
            i = i2;
            String iVar22 = iVar.toString();
            if (arrayList.isEmpty()) {
            }
            return new kd.d(bArr, iVar22, arrayList, null, i);
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
        }
        if (!z) {
        }
        i = i2;
        String iVar222 = iVar.toString();
        if (arrayList.isEmpty()) {
        }
        return new kd.d(bArr, iVar222, arrayList, null, i);
    }

    private static void b(kd.c cVar, i iVar) {
        int d2;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            i(d2, cVar.d(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    iVar.b('\r');
                } else if (i2 == 1) {
                    iVar.b('*');
                } else if (i2 == 2) {
                    iVar.b('>');
                } else if (i2 == 3) {
                    iVar.b(' ');
                } else if (i2 < 14) {
                    iVar.b((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    iVar.b((char) (i2 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static Mode c(kd.c cVar, i iVar, StringBuilder sb2, Set set) {
        boolean z = false;
        do {
            int d2 = cVar.d(8);
            if (d2 == 0) {
                throw FormatException.getFormatInstance();
            }
            if (d2 > 128) {
                if (d2 != 129) {
                    if (d2 > 229) {
                        switch (d2) {
                            case 230:
                                return Mode.C40_ENCODE;
                            case 231:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                iVar.d("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                iVar.d("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            case 241:
                                return Mode.ECI_ENCODE;
                            default:
                                if (d2 != 254 || cVar.a() != 0) {
                                    throw FormatException.getFormatInstance();
                                }
                                break;
                        }
                    } else {
                        int i = d2 - 130;
                        if (i < 10) {
                            iVar.b('0');
                        }
                        iVar.c(i);
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z) {
                    d2 += 128;
                }
                iVar.b((char) (d2 - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void d(kd.c cVar, i iVar, Collection collection) {
        int c2 = cVar.c();
        int i = c2 + 2;
        int j = j(cVar.d(8), c2 + 1);
        if (j == 0) {
            j = cVar.a() / 8;
        } else if (j >= 250) {
            j = ((j - 249) * 250) + j(cVar.d(8), i);
            i = c2 + 3;
        }
        if (j < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[j];
        int i2 = 0;
        while (i2 < j) {
            if (cVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) j(cVar.d(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        iVar.d(new String(bArr, StandardCharsets.ISO_8859_1));
    }

    private static void e(kd.c cVar, i iVar, Set set) {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            i(d2, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = b;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    iVar.b((char) (c2 + 128));
                                    z = false;
                                } else {
                                    iVar.b(c2);
                                }
                            } else if (i3 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                iVar.b((char) (i3 + 224));
                                z = false;
                                i = 0;
                            } else {
                                iVar.b((char) (i3 + 96));
                                i = 0;
                            }
                        }
                    } else if (z) {
                        iVar.b((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        iVar.b((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i3 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i3];
                    if (z) {
                        iVar.b((char) (c3 + 128));
                        z = false;
                    } else {
                        iVar.b(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(kd.c cVar, i iVar) {
        if (cVar.a() < 8) {
            throw FormatException.getFormatInstance();
        }
        int d2 = cVar.d(8);
        if (d2 <= 127) {
            iVar.f(d2 - 1);
        }
    }

    private static void g(kd.c cVar, i iVar) {
        while (cVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int d2 = cVar.d(6);
                if (d2 == 31) {
                    int b2 = 8 - cVar.b();
                    if (b2 != 8) {
                        cVar.d(b2);
                        return;
                    }
                    return;
                }
                if ((d2 & 32) == 0) {
                    d2 |= 64;
                }
                iVar.b((char) d2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(kd.c cVar, i iVar, Set set) {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            i(d2, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = d;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    iVar.b((char) (c2 + 128));
                                    z = false;
                                } else {
                                    iVar.b(c2);
                                }
                            } else if (i3 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i = 0;
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = e;
                            if (i3 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i3];
                            if (z) {
                                iVar.b((char) (c3 + 128));
                                z = false;
                                i = 0;
                            } else {
                                iVar.b(c3);
                                i = 0;
                            }
                        }
                    } else if (z) {
                        iVar.b((char) (i3 + 128));
                        z = false;
                        i = 0;
                    } else {
                        iVar.b((char) i3);
                        i = 0;
                    }
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i3 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i3];
                    if (z) {
                        iVar.b((char) (c4 + 128));
                        z = false;
                    } else {
                        iVar.b(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void i(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static int j(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
