package yd;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.encoder.Compaction;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kd.h;
import kd.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class e {
    private static final byte[] c;
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] d = new byte[128];
    private static final Charset e = StandardCharsets.ISO_8859_1;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Compaction.values().length];
            a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static final class b implements h {
        String a;

        private b(String str) {
            this.a = str;
        }

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // kd.h
        public boolean a(int i) {
            return false;
        }

        @Override // kd.h
        public int b(int i) {
            return -1;
        }

        @Override // kd.h
        public char charAt(int i) {
            return this.a.charAt(i);
        }

        @Override // kd.h
        public int length() {
            return this.a.length();
        }

        @Override // kd.h
        public CharSequence subSequence(int i, int i2) {
            return this.a.subSequence(i, i2);
        }

        public String toString() {
            return this.a;
        }
    }

    static {
        int i = 0;
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i >= bArr3.length) {
                return;
            }
            byte b3 = bArr3[i];
            if (b3 > 0) {
                d[b3] = (byte) i;
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x002e, code lost:
    
        return r1 - r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(h hVar, int i, Charset charset) {
        CharsetEncoder newEncoder = charset == null ? null : charset.newEncoder();
        int length = hVar.length();
        int i2 = i;
        while (i2 < length) {
            int i3 = 0;
            int i4 = i2;
            while (i3 < 13 && !hVar.a(i4) && l(hVar.charAt(i4)) && (i4 = i2 + (i3 = i3 + 1)) < length) {
            }
            if (newEncoder != null && !newEncoder.canEncode(hVar.charAt(i2))) {
                char charAt = hVar.charAt(i2);
                throw new WriterException("Non-encodable character detected: " + charAt + " (Unicode: " + ((int) charAt) + ')');
            }
            i2++;
        }
        return i2 - i;
    }

    private static int b(h hVar, int i) {
        int length = hVar.length();
        int i2 = 0;
        if (i < length) {
            while (i < length && !hVar.a(i) && l(hVar.charAt(i))) {
                i2++;
                i++;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0027, code lost:
    
        return (r1 - r6) - r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(h hVar, int i) {
        int length = hVar.length();
        int i2 = i;
        while (i2 < length) {
            int i3 = 0;
            while (i3 < 13 && i2 < length && !hVar.a(i2) && l(hVar.charAt(i2))) {
                i3++;
                i2++;
            }
            if (i3 <= 0) {
                if (hVar.a(i2) || !o(hVar.charAt(i2))) {
                    break;
                }
                i2++;
            }
        }
        return i2 - i;
    }

    private static void d(byte[] bArr, int i, int i2, int i3, StringBuilder sb2) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb2.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + (bArr[i4 + i5] & 255);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j % 900);
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb2.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb2.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    static String e(String str, Compaction compaction, Charset charset, boolean z) {
        h bVar;
        CharacterSetECI characterSetECI;
        if (str.isEmpty()) {
            throw new WriterException("Empty message not allowed");
        }
        if (charset == null && !z) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 255) {
                    throw new WriterException("Non-encodable character detected: " + str.charAt(i) + " (Unicode: " + ((int) str.charAt(i)) + "). Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET.");
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        a aVar = null;
        if (z) {
            bVar = new m(str, charset, -1);
        } else {
            bVar = new b(str, aVar);
            if (charset == null) {
                charset = e;
            } else if (!e.equals(charset) && (characterSetECI = CharacterSetECI.getCharacterSetECI(charset)) != null) {
                i(characterSetECI.getValue(), sb2);
            }
        }
        int length = bVar.length();
        int i2 = a.a[compaction.ordinal()];
        if (i2 == 1) {
            h(bVar, 0, length, sb2, 0);
        } else if (i2 != 2) {
            if (i2 != 3) {
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < length) {
                    while (i3 < length && bVar.a(i3)) {
                        i(bVar.b(i3), sb2);
                        i3++;
                    }
                    if (i3 >= length) {
                        break;
                    }
                    int b2 = b(bVar, i3);
                    if (b2 >= 13) {
                        sb2.append((char) 902);
                        g(bVar, i3, b2, sb2);
                        i3 += b2;
                        i4 = 0;
                        i5 = 2;
                    } else {
                        int c2 = c(bVar, i3);
                        if (c2 >= 5 || b2 == length) {
                            if (i5 != 0) {
                                sb2.append((char) 900);
                                i4 = 0;
                                i5 = 0;
                            }
                            i4 = h(bVar, i3, c2, sb2, i4);
                            i3 += c2;
                        } else {
                            int a2 = a(bVar, i3, z ? null : charset);
                            if (a2 == 0) {
                                a2 = 1;
                            }
                            byte[] bytes = z ? null : bVar.subSequence(i3, i3 + a2).toString().getBytes(charset);
                            if ((!(bytes == null && a2 == 1) && (bytes == null || bytes.length != 1)) || i5 != 0) {
                                if (z) {
                                    f(bVar, i3, i3 + a2, i5, sb2);
                                } else {
                                    d(bytes, 0, bytes.length, i5, sb2);
                                }
                                i4 = 0;
                                i5 = 1;
                            } else if (z) {
                                f(bVar, i3, 1, 0, sb2);
                            } else {
                                d(bytes, 0, 1, 0, sb2);
                            }
                            i3 += a2;
                        }
                    }
                }
            } else {
                sb2.append((char) 902);
                g(bVar, 0, length, sb2);
            }
        } else if (z) {
            f(bVar, 0, bVar.length(), 0, sb2);
        } else {
            byte[] bytes2 = bVar.toString().getBytes(charset);
            d(bytes2, 0, bytes2.length, 1, sb2);
        }
        return sb2.toString();
    }

    private static void f(h hVar, int i, int i2, int i3, StringBuilder sb2) {
        int min = Math.min(i2 + i, hVar.length());
        int i4 = i;
        while (true) {
            if (i4 >= min || !hVar.a(i4)) {
                int i5 = i4;
                while (i5 < min && !hVar.a(i5)) {
                    i5++;
                }
                int i6 = i5 - i4;
                if (i6 <= 0) {
                    return;
                }
                d(p(hVar, i4, i5), 0, i6, i4 == i ? i3 : 1, sb2);
                i4 = i5;
            } else {
                i(hVar.b(i4), sb2);
                i4++;
            }
        }
    }

    private static void g(h hVar, int i, int i2, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb3.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1");
            int i4 = i + i3;
            sb4.append((Object) hVar.subSequence(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i3 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x010b A[EDGE_INSN: B:24:0x010b->B:25:0x010b BREAK  A[LOOP:0: B:2:0x000f->B:19:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int h(h hVar, int i, int i2, StringBuilder sb2, int i3) {
        StringBuilder sb3 = new StringBuilder(i2);
        int i4 = i3;
        int i5 = 0;
        while (true) {
            int i6 = i + i5;
            if (hVar.a(i6)) {
                i(hVar.b(i6), sb2);
                i5++;
            } else {
                char charAt = hVar.charAt(i6);
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (n(charAt)) {
                                sb3.append((char) d[charAt]);
                            } else {
                                sb3.append((char) 29);
                                i4 = 0;
                            }
                        } else if (m(charAt)) {
                            sb3.append((char) c[charAt]);
                        } else if (k(charAt)) {
                            sb3.append((char) 28);
                            i4 = 0;
                        } else if (j(charAt)) {
                            sb3.append((char) 27);
                            i4 = 1;
                        } else {
                            int i7 = i6 + 1;
                            if (i7 >= i2 || hVar.a(i7) || !n(hVar.charAt(i7))) {
                                sb3.append((char) 29);
                                sb3.append((char) d[charAt]);
                            } else {
                                sb3.append((char) 25);
                                i4 = 3;
                            }
                        }
                    } else if (j(charAt)) {
                        if (charAt == ' ') {
                            sb3.append((char) 26);
                        } else {
                            sb3.append((char) (charAt - 'a'));
                        }
                    } else if (k(charAt)) {
                        sb3.append((char) 27);
                        sb3.append((char) (charAt - 'A'));
                    } else if (m(charAt)) {
                        sb3.append((char) 28);
                        i4 = 2;
                    } else {
                        sb3.append((char) 29);
                        sb3.append((char) d[charAt]);
                    }
                    i5++;
                    if (i5 < i2) {
                        break;
                    }
                } else {
                    if (k(charAt)) {
                        if (charAt == ' ') {
                            sb3.append((char) 26);
                        } else {
                            sb3.append((char) (charAt - 'A'));
                        }
                    } else if (j(charAt)) {
                        sb3.append((char) 27);
                        i4 = 1;
                    } else if (m(charAt)) {
                        sb3.append((char) 28);
                        i4 = 2;
                    } else {
                        sb3.append((char) 29);
                        sb3.append((char) d[charAt]);
                    }
                    i5++;
                    if (i5 < i2) {
                    }
                }
            }
        }
        int length = sb3.length();
        char c2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 % 2 != 0) {
                c2 = (char) ((c2 * 30) + sb3.charAt(i8));
                sb2.append(c2);
            } else {
                c2 = sb3.charAt(i8);
            }
        }
        if (length % 2 != 0) {
            sb2.append((char) ((c2 * 30) + 29));
        }
        return i4;
    }

    private static void i(int i, StringBuilder sb2) {
        if (i >= 0 && i < 900) {
            sb2.append((char) 927);
            sb2.append((char) i);
            return;
        }
        if (i < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i / 900) - 1));
            sb2.append((char) (i % 900));
        } else if (i < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
        }
    }

    private static boolean j(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static boolean k(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean l(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean m(char c2) {
        return c[c2] != -1;
    }

    private static boolean n(char c2) {
        return d[c2] != -1;
    }

    private static boolean o(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    static byte[] p(h hVar, int i, int i2) {
        byte[] bArr = new byte[i2 - i];
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3 - i] = (byte) (hVar.charAt(i3) & 255);
        }
        return bArr;
    }
}
