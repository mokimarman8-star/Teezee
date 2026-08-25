package rd;

import com.google.zxing.FormatException;
import java.text.DecimalFormat;
import kd.d;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class b {
    private static final byte[] a = {53, 54, 43, 44, 45, 46, 47, 48, 37, 38};
    private static final byte[] b = {55, 56, 57, 58, 59, 60, 49, 50, 51, 52};
    private static final byte[] c = {39, 40, 41, 42, 31, 32};
    private static final byte[] d = {33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2};
    private static final byte[][] e = {new byte[]{39, 40, 41, 42, 31, 32}, new byte[]{33, 34, 35, 36, 25, 26}, new byte[]{27, 28, 29, 30, 19, 20}, new byte[]{21, 22, 23, 24, 13, 14}, new byte[]{15, 16, 17, 18, 7, 8}, new byte[]{9, 10, 11, 12, 1, 2}};
    private static final String[] f = {"\rABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001e\ufffbÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8"};

    static d a(byte[] bArr, int i) {
        String h;
        StringBuilder sb2 = new StringBuilder(144);
        if (i == 2 || i == 3) {
            if (i == 2) {
                int f2 = f(bArr);
                int g = g(bArr);
                if (g > 10) {
                    throw FormatException.getFormatInstance();
                }
                h = new DecimalFormat("0000000000".substring(0, g)).format(f2);
            } else {
                h = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format = decimalFormat.format(c(bArr));
            String format2 = decimalFormat.format(i(bArr));
            sb2.append(e(bArr, 10, 84));
            if (sb2.toString().startsWith("[)>\u001e01\u001d")) {
                sb2.insert(9, h + (char) 29 + format + (char) 29 + format2 + (char) 29);
            } else {
                sb2.insert(0, h + (char) 29 + format + (char) 29 + format2 + (char) 29);
            }
        } else if (i == 4) {
            sb2.append(e(bArr, 1, 93));
        } else if (i == 5) {
            sb2.append(e(bArr, 1, 77));
        }
        return new d(bArr, sb2.toString(), null, String.valueOf(i));
    }

    private static int b(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int c(byte[] bArr) {
        return d(bArr, a);
    }

    private static int d(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            i += b(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
        }
        return i;
    }

    private static String e(byte[] bArr, int i, int i2) {
        StringBuilder sb2 = new StringBuilder();
        int i3 = i;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (i3 < i + i2) {
            char charAt = f[i5].charAt(bArr[i3]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i6 = i5;
                    i5 = charAt - 65520;
                    i4 = 1;
                    break;
                case 65525:
                    i4 = 2;
                    i6 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i4 = 3;
                    i6 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i4 = -1;
                    i5 = 0;
                    break;
                case 65528:
                    i4 = -1;
                    i5 = 1;
                    break;
                case 65529:
                    i4 = -1;
                    break;
                case 65530:
                default:
                    sb2.append(charAt);
                    break;
                case 65531:
                    int i7 = (bArr[i3 + 1] << 24) + (bArr[i3 + 2] << 18) + (bArr[i3 + 3] << 12) + (bArr[i3 + 4] << 6);
                    i3 += 5;
                    sb2.append(new DecimalFormat("000000000").format(i7 + bArr[i3]));
                    break;
            }
            int i8 = i4 - 1;
            if (i4 == 0) {
                i5 = i6;
            }
            i3++;
            i4 = i8;
        }
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == 65532) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    private static int f(byte[] bArr) {
        return d(bArr, d);
    }

    private static int g(byte[] bArr) {
        return d(bArr, c);
    }

    private static String h(byte[] bArr) {
        byte[][] bArr2 = e;
        StringBuilder sb2 = new StringBuilder(bArr2.length);
        for (byte[] bArr3 : bArr2) {
            sb2.append(f[0].charAt(d(bArr, bArr3)));
        }
        return sb2.toString();
    }

    private static int i(byte[] bArr) {
        return d(bArr, b);
    }
}
