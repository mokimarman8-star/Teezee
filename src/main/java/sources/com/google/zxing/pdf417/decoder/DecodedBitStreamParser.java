package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class DecodedBitStreamParser {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        if (r11 == 924) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
    
        if (r8 >= r12[0]) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        if (r12[r8] >= 900) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        if (r13 >= 6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        r14.a((byte) (r6 >> ((5 - r13) * 8)));
        r13 = r13 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(int i, int[] iArr, int i2, kd.i iVar) {
        int i3;
        int i4;
        boolean z = false;
        while (i2 < iArr[0] && !z) {
            while (true) {
                i3 = iArr[0];
                if (i2 >= i3 || iArr[i2] != 927) {
                    break;
                }
                iVar.f(iArr[i2 + 1]);
                i2 += 2;
            }
            if (i2 >= i3 || iArr[i2] >= 900) {
                z = true;
            } else {
                long j = 0;
                int i5 = 0;
                while (true) {
                    i4 = i2 + 1;
                    j = (j * 900) + iArr[i2];
                    i5++;
                    if (i5 >= 5 || i4 >= iArr[0] || iArr[i4] >= 900) {
                        break;
                    }
                    i2 = i4;
                }
                i4 -= i5;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < 900) {
                        iVar.a((byte) i7);
                        i4 = i6;
                    } else if (i7 == 927) {
                        i4 += 2;
                        iVar.f(iArr[i6]);
                    } else {
                        z = true;
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    static kd.d b(int[] iArr, String str) {
        kd.i iVar = new kd.i(iArr.length * 2);
        int g = g(iArr, 1, iVar);
        vd.c cVar = new vd.c();
        while (g < iArr[0]) {
            int i = g + 1;
            int i2 = iArr[g];
            if (i2 != 913) {
                switch (i2) {
                    case 900:
                        g = g(iArr, i, iVar);
                        continue;
                    case 901:
                        break;
                    case 902:
                        g = f(iArr, i, iVar);
                        continue;
                    default:
                        switch (i2) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                g += 2;
                                continue;
                            case 926:
                                g += 3;
                                continue;
                            case 927:
                                g += 2;
                                iVar.f(iArr[i]);
                                continue;
                            case 928:
                                g = d(iArr, i, cVar);
                                continue;
                            default:
                                g = g(iArr, g, iVar);
                                continue;
                        }
                }
                g = a(i2, iArr, i, iVar);
            } else {
                g += 2;
                iVar.b((char) iArr[i]);
            }
        }
        if (iVar.h() && cVar.a() == null) {
            throw FormatException.getFormatInstance();
        }
        kd.d dVar = new kd.d(null, iVar.toString(), null, str);
        dVar.p(cVar);
        return dVar;
    }

    private static String c(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    static int d(int[] iArr, int i, vd.c cVar) {
        int i2;
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i];
            i3++;
            i++;
        }
        String c2 = c(iArr2, 2);
        if (c2.isEmpty()) {
            cVar.k(0);
        } else {
            try {
                cVar.k(Integer.parseInt(c2));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i < iArr[0] && i < iArr.length && (i2 = iArr[i]) != 922 && i2 != 923) {
            sb2.append(String.format("%03d", Integer.valueOf(i2)));
            i++;
        }
        if (sb2.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        cVar.e(sb2.toString());
        int i4 = iArr[i] == 923 ? i + 1 : -1;
        while (i < iArr[0]) {
            int i5 = iArr[i];
            if (i5 == 922) {
                i++;
                cVar.h(true);
            } else {
                if (i5 != 923) {
                    throw FormatException.getFormatInstance();
                }
                switch (iArr[i + 1]) {
                    case 0:
                        kd.i iVar = new kd.i();
                        i = g(iArr, i + 2, iVar);
                        cVar.f(iVar.toString());
                        break;
                    case 1:
                        kd.i iVar2 = new kd.i();
                        i = f(iArr, i + 2, iVar2);
                        try {
                            cVar.j(Integer.parseInt(iVar2.toString()));
                            break;
                        } catch (NumberFormatException unused2) {
                            throw FormatException.getFormatInstance();
                        }
                    case 2:
                        kd.i iVar3 = new kd.i();
                        i = f(iArr, i + 2, iVar3);
                        try {
                            cVar.m(Long.parseLong(iVar3.toString()));
                            break;
                        } catch (NumberFormatException unused3) {
                            throw FormatException.getFormatInstance();
                        }
                    case 3:
                        kd.i iVar4 = new kd.i();
                        i = g(iArr, i + 2, iVar4);
                        cVar.l(iVar4.toString());
                        break;
                    case 4:
                        kd.i iVar5 = new kd.i();
                        i = g(iArr, i + 2, iVar5);
                        cVar.c(iVar5.toString());
                        break;
                    case 5:
                        kd.i iVar6 = new kd.i();
                        i = f(iArr, i + 2, iVar6);
                        try {
                            cVar.g(Long.parseLong(iVar6.toString()));
                            break;
                        } catch (NumberFormatException unused4) {
                            throw FormatException.getFormatInstance();
                        }
                    case 6:
                        kd.i iVar7 = new kd.i();
                        i = f(iArr, i + 2, iVar7);
                        try {
                            cVar.d(Integer.parseInt(iVar7.toString()));
                            break;
                        } catch (NumberFormatException unused5) {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
        }
        if (i4 != -1) {
            int i6 = i - i4;
            if (cVar.b()) {
                i6--;
            }
            if (i6 > 0) {
                cVar.i(Arrays.copyOfRange(iArr, i4, i6 + i4));
            }
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Mode e(int[] iArr, int[] iArr2, int i, kd.i iVar, Mode mode) {
        Mode mode2;
        int i2;
        char c2;
        char c3;
        Mode mode3;
        Mode mode4 = mode;
        Mode mode5 = mode4;
        Mode mode6 = mode5;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            char c4 = ' ';
            switch (a.a[mode5.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c2 = (char) i2;
                        Mode mode7 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode7;
                        break;
                    } else {
                        if (i4 != 900) {
                            if (i4 != 913) {
                                switch (i4) {
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode8 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode8;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                                break;
                            } else {
                                iVar.b((char) iArr2[i3]);
                            }
                            c4 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c3 = c4;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c4 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    }
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c2 = (char) i2;
                        Mode mode72 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode72;
                        break;
                    } else {
                        if (i4 != 900) {
                            if (i4 != 913) {
                                switch (i4) {
                                    case 27:
                                        mode2 = Mode.ALPHA_SHIFT;
                                        c4 = 0;
                                        Mode mode82 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode82;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode822 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode822;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                                break;
                            } else {
                                iVar.b((char) iArr2[i3]);
                            }
                            c4 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c3 = c4;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c4 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    }
                case 3:
                    if (i4 < 25) {
                        c2 = b[i4];
                        Mode mode722 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode722;
                        break;
                    } else {
                        if (i4 != 900) {
                            if (i4 != 913) {
                                switch (i4) {
                                    case 25:
                                        mode4 = Mode.PUNCT;
                                        c4 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        c4 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 29:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c4 = 0;
                                        Mode mode8222 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode8222;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                                break;
                            } else {
                                iVar.b((char) iArr2[i3]);
                            }
                            c4 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c3 = c4;
                        }
                        mode4 = Mode.ALPHA;
                        c4 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    }
                case 4:
                    if (i4 >= 29) {
                        if (i4 == 29 || i4 == 900) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                        } else if (i4 == 913) {
                            iVar.b((char) iArr2[i3]);
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = 0;
                        break;
                    } else {
                        c2 = a[i4];
                        Mode mode7222 = mode6;
                        mode6 = mode5;
                        c3 = c2;
                        mode3 = mode7222;
                        break;
                    }
                case 5:
                    if (i4 < 26) {
                        c3 = (char) (i4 + 65);
                        mode3 = mode6;
                        break;
                    } else {
                        if (i4 != 26) {
                            if (i4 == 900) {
                                mode5 = Mode.ALPHA;
                                c4 = 0;
                                mode3 = mode6;
                                mode6 = mode5;
                                c3 = c4;
                                break;
                            } else {
                                c4 = 0;
                            }
                        }
                        mode5 = mode6;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = c4;
                    }
                case 6:
                    if (i4 < 29) {
                        c3 = a[i4];
                    } else if (i4 == 29 || i4 == 900) {
                        mode5 = Mode.ALPHA;
                        mode3 = mode6;
                        mode6 = mode5;
                        c3 = 0;
                        break;
                    } else {
                        if (i4 == 913) {
                            iVar.b((char) iArr2[i3]);
                        }
                        c3 = 0;
                    }
                    mode3 = mode6;
                    break;
                default:
                    mode3 = mode6;
                    mode6 = mode5;
                    c3 = 0;
                    break;
            }
            if (c3 != 0) {
                iVar.b(c3);
            }
            i3++;
            mode5 = mode6;
            mode6 = mode3;
        }
        return mode4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r10.d(c(r0, r3));
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int f(int[] iArr, int i, kd.i iVar) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i < i3 && !z) {
                int i4 = i + 1;
                int i5 = iArr[i];
                if (i4 == i3) {
                    z = true;
                }
                if (i5 < 900) {
                    iArr2[i2] = i5;
                    i2++;
                } else {
                    if (i5 != 900 && i5 != 901 && i5 != 927 && i5 != 928) {
                        switch (i5) {
                        }
                        if (i2 % 15 == 0 || i5 == 902 || z) {
                        }
                    }
                    z = true;
                    if (i2 % 15 == 0) {
                    }
                }
                i = i4;
                if (i2 % 15 == 0) {
                }
            }
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x003d. Please report as an issue. */
    private static int g(int[] iArr, int i, kd.i iVar) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) * 2];
        int[] iArr3 = new int[(i2 - i) * 2];
        Mode mode = Mode.ALPHA;
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 == 913) {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            } else if (i5 != 927) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                z = true;
            } else {
                Mode e = e(iArr2, iArr3, i3, iVar, mode);
                i += 2;
                iVar.f(iArr[i4]);
                int i6 = iArr[0];
                if (i > i6) {
                    throw FormatException.getFormatInstance();
                }
                i3 = 0;
                mode = e;
                iArr3 = new int[(i6 - i) * 2];
                iArr2 = new int[(i6 - i) * 2];
            }
            i = i4;
        }
        e(iArr2, iArr3, i3, iVar, mode);
        return i;
    }
}
