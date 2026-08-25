package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.bumptech.glide.load.Key;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f {
    public static final Properties a = new Properties();
    public static final Charset b = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] d = new boolean[256];
    public static final boolean[] e = new boolean[256];
    public static final byte[] f;
    public static final byte[] g;
    public static final boolean[] h;
    public static final boolean[] i;
    public static final char[] j;
    public static final char[] k;
    static final char[] l;
    static final char[] m;
    static final char[] n;
    static final int[] o;
    public static final char[] p;
    public static final int[] q;

    static class a implements PrivilegedAction {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c2 = 0;
        while (true) {
            boolean[] zArr = d;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                zArr[c2] = true;
            } else if (c2 == '_' || c2 == '$') {
                zArr[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        char c3 = 0;
        while (true) {
            boolean[] zArr2 = e;
            if (c3 < zArr2.length) {
                if (c3 >= 'A' && c3 <= 'Z') {
                    zArr2[c3] = true;
                } else if (c3 >= 'a' && c3 <= 'z') {
                    zArr2[c3] = true;
                } else if (c3 == '_') {
                    zArr2[c3] = true;
                } else if (c3 >= '0' && c3 <= '9') {
                    zArr2[c3] = true;
                }
                c3 = (char) (c3 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        l();
        byte[] bArr = new byte[161];
        f = bArr;
        byte[] bArr2 = new byte[161];
        g = bArr2;
        h = new boolean[161];
        i = new boolean[161];
        j = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i2 = 14; i2 <= 31; i2++) {
            f[i2] = 4;
            g[i2] = 4;
        }
        for (int i3 = 127; i3 < 160; i3++) {
            f[i3] = 4;
            g[i3] = 4;
        }
        for (int i4 = 0; i4 < 161; i4++) {
            h[i4] = f[i4] != 0;
            i[i4] = g[i4] != 0;
        }
        char[] cArr = j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        o = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        p = charArray;
        int[] iArr = new int[256];
        q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i8 = 0; i8 < length; i8++) {
            q[p[i8]] = i8;
        }
        q[61] = 0;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e2) {
            throw new JSONException("utf8 decode error, " + e2.getMessage(), e2);
        }
    }

    public static byte[] c(String str) {
        int i2;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && q[str.charAt(i4) & 255] < 0) {
            i4++;
        }
        while (i3 > 0 && q[str.charAt(i3) & 255] < 0) {
            i3--;
        }
        int i8 = str.charAt(i3) == '=' ? str.charAt(i3 + (-1)) == '=' ? 2 : 1 : 0;
        int i9 = (i3 - i4) + 1;
        if (length > 76) {
            i2 = (str.charAt(76) == '\r' ? i9 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i10 = (((i9 - i2) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = q;
            int i14 = i4 + 4;
            int i15 = iArr[str.charAt(i4 + 3)] | (iArr[str.charAt(i4 + 1)] << 12) | (iArr[str.charAt(i4)] << 18) | (iArr[str.charAt(i4 + 2)] << 6);
            bArr[i12] = (byte) (i15 >> 16);
            int i16 = i12 + 2;
            bArr[i12 + 1] = (byte) (i15 >> 8);
            i12 += 3;
            bArr[i16] = (byte) i15;
            if (i2 <= 0 || (i13 = i13 + 1) != 19) {
                i4 = i14;
            } else {
                i4 += 6;
                i13 = 0;
            }
        }
        if (i12 < i10) {
            int i17 = 0;
            int i18 = 0;
            while (i4 <= i3 - i8) {
                i17 |= q[str.charAt(i4)] << (18 - (i18 * 6));
                i18++;
                i4++;
            }
            int i19 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i17 >> i19);
                i19 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static byte[] d(String str, int i2, int i3) {
        int i4;
        if (i3 == 0) {
            return new byte[0];
        }
        int i8 = (i2 + i3) - 1;
        int i9 = i2;
        while (i9 < i8 && q[str.charAt(i9)] < 0) {
            i9++;
        }
        while (i8 > 0 && q[str.charAt(i8)] < 0) {
            i8--;
        }
        int i10 = str.charAt(i8) == '=' ? str.charAt(i8 + (-1)) == '=' ? 2 : 1 : 0;
        int i11 = (i8 - i9) + 1;
        if (i3 > 76) {
            i4 = (str.charAt(76) == '\r' ? i11 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i12 = (((i11 - i4) * 6) >> 3) - i10;
        byte[] bArr = new byte[i12];
        int i13 = (i12 / 3) * 3;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i13) {
            int[] iArr = q;
            int i16 = i9 + 4;
            int i17 = iArr[str.charAt(i9 + 3)] | (iArr[str.charAt(i9 + 1)] << 12) | (iArr[str.charAt(i9)] << 18) | (iArr[str.charAt(i9 + 2)] << 6);
            bArr[i14] = (byte) (i17 >> 16);
            int i18 = i14 + 2;
            bArr[i14 + 1] = (byte) (i17 >> 8);
            i14 += 3;
            bArr[i18] = (byte) i17;
            if (i4 <= 0 || (i15 = i15 + 1) != 19) {
                i9 = i16;
            } else {
                i9 += 6;
                i15 = 0;
            }
        }
        if (i14 < i12) {
            int i19 = 0;
            int i20 = 0;
            while (i9 <= i8 - i10) {
                i19 |= q[str.charAt(i9)] << (18 - (i20 * 6));
                i20++;
                i9++;
            }
            int i21 = 16;
            while (i14 < i12) {
                bArr[i14] = (byte) (i19 >> i21);
                i21 -= 8;
                i14++;
            }
        }
        return bArr;
    }

    public static int e(byte[] bArr, int i2, int i3, char[] cArr) {
        int i4 = i2 + i3;
        int min = Math.min(i3, cArr.length);
        int i8 = 0;
        while (i8 < min) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                break;
            }
            i2++;
            cArr[i8] = (char) b2;
            i8++;
        }
        while (i2 < i4) {
            int i9 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                cArr[i8] = (char) b3;
                i8++;
                i2 = i9;
            } else {
                if ((b3 >> 5) != -2 || (b3 & 30) == 0) {
                    if ((b3 >> 4) == -2) {
                        int i10 = i2 + 2;
                        if (i10 < i4) {
                            byte b4 = bArr[i9];
                            i2 += 3;
                            byte b8 = bArr[i10];
                            if ((b3 != -32 || (b4 & 224) != 128) && (b4 & 192) == 128 && (b8 & 192) == 128) {
                                char c2 = (char) (((b4 << 6) ^ (b3 << 12)) ^ ((-123008) ^ b8));
                                if (c2 >= 55296 && c2 < 57344) {
                                    return -1;
                                }
                                cArr[i8] = c2;
                                i8++;
                            }
                        }
                        return -1;
                    }
                    if ((b3 >> 3) == -2 && i2 + 3 < i4) {
                        byte b9 = bArr[i9];
                        int i11 = i2 + 3;
                        byte b10 = bArr[i2 + 2];
                        i2 += 4;
                        byte b11 = bArr[i11];
                        int i12 = (((b3 << 18) ^ (b9 << 12)) ^ (b10 << 6)) ^ (3678080 ^ b11);
                        if ((b9 & 192) == 128 && (b10 & 192) == 128 && (b11 & 192) == 128 && i12 >= 65536 && i12 < 1114112) {
                            int i13 = i8 + 1;
                            cArr[i8] = (char) ((i12 >>> 10) + 55232);
                            i8 += 2;
                            cArr[i13] = (char) ((i12 & 1023) + 56320);
                        }
                    }
                    return -1;
                }
                if (i9 >= i4) {
                    return -1;
                }
                i2 += 2;
                byte b12 = bArr[i9];
                if ((b12 & 192) != 128) {
                    return -1;
                }
                cArr[i8] = (char) ((b12 ^ (b3 << 6)) ^ 3968);
                i8++;
            }
        }
        return i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Type inference failed for: r3v0, types: [char, int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(char[] cArr, int i2, int i3, byte[] bArr) {
        int i4;
        char c2;
        int i8 = i2 + i3;
        int min = Math.min(i3, bArr.length);
        int i9 = 0;
        while (i9 < min && (c2 = cArr[i2]) < 128) {
            i2++;
            bArr[i9] = (byte) c2;
            i9++;
        }
        while (i2 < i8) {
            int i10 = i2 + 1;
            char c3 = cArr[i2];
            if (c3 < 128) {
                i4 = i9 + 1;
                bArr[i9] = (byte) c3;
            } else {
                if (c3 < 2048) {
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) ((c3 >> 6) | 192);
                    i9 += 2;
                    bArr[i11] = (byte) ((c3 & 63) | 128);
                } else if (c3 < 55296 || c3 >= 57344) {
                    bArr[i9] = (byte) ((c3 >> 12) | 224);
                    int i12 = i9 + 2;
                    bArr[i9 + 1] = (byte) ((63 & (c3 >> 6)) | 128);
                    i9 += 3;
                    bArr[i12] = (byte) ((c3 & 63) | 128);
                } else if (c3 < 55296 || c3 >= 56320) {
                    if (c3 >= 56320 && c3 < 57344) {
                        i4 = i9 + 1;
                        bArr[i9] = 63;
                    }
                    if (c3 >= 0) {
                        i4 = i9 + 1;
                        bArr[i9] = 63;
                    } else {
                        bArr[i9] = (byte) ((c3 >> 18) | 240);
                        bArr[i9 + 1] = (byte) (((c3 >> 12) & 63) | 128);
                        bArr[i9 + 2] = (byte) ((63 & (c3 >> 6)) | 128);
                        bArr[i9 + 3] = (byte) ((c3 & 63) | 128);
                        i10 = i2 + 2;
                        i4 = i9 + 4;
                    }
                } else {
                    if (i8 - i2 < 2) {
                        c3 = -1;
                    } else {
                        char c4 = cArr[i2 + 1];
                        if (c4 < 56320 || c4 >= 57344) {
                            i4 = i9 + 1;
                            bArr[i9] = 63;
                        } else {
                            c3 = ((c3 << 10) + c4) - 56613888;
                        }
                    }
                    if (c3 >= 0) {
                    }
                }
                i2 = i10;
            }
            i9 = i4;
            i2 = i10;
        }
        return i9;
    }

    public static boolean g(char c2) {
        boolean[] zArr = d;
        return c2 < zArr.length && zArr[c2];
    }

    public static void h(int i2, int i3, char[] cArr) {
        char c2;
        if (i2 < 0) {
            i2 = -i2;
            c2 = '-';
        } else {
            c2 = 0;
        }
        while (i2 >= 65536) {
            int i4 = i2 / 100;
            int i8 = i2 - (((i4 << 6) + (i4 << 5)) + (i4 << 2));
            cArr[i3 - 1] = n[i8];
            i3 -= 2;
            cArr[i3] = m[i8];
            i2 = i4;
        }
        while (true) {
            int i9 = (52429 * i2) >>> 19;
            int i10 = i3 - 1;
            cArr[i10] = l[i2 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i2 = i9;
            i3 = i10;
        }
        if (c2 != 0) {
            cArr[i3 - 2] = c2;
        }
    }

    public static void i(long j2, int i2, char[] cArr) {
        char c2;
        if (j2 < 0) {
            j2 = -j2;
            c2 = '-';
        } else {
            c2 = 0;
        }
        while (j2 > 2147483647L) {
            long j3 = j2 / 100;
            int i3 = (int) (j2 - (((j3 << 6) + (j3 << 5)) + (j3 << 2)));
            cArr[i2 - 1] = n[i3];
            i2 -= 2;
            cArr[i2] = m[i3];
            j2 = j3;
        }
        int i4 = (int) j2;
        while (i4 >= 65536) {
            int i8 = i4 / 100;
            int i9 = i4 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            cArr[i2 - 1] = n[i9];
            i2 -= 2;
            cArr[i2] = m[i9];
            i4 = i8;
        }
        while (true) {
            int i10 = (52429 * i4) >>> 19;
            int i11 = i2 - 1;
            cArr[i11] = l[i4 - ((i10 << 3) + (i10 << 1))];
            if (i10 == 0) {
                break;
            }
            i4 = i10;
            i2 = i11;
        }
        if (c2 != 0) {
            cArr[i2 - 2] = c2;
        }
    }

    public static String j(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? a.getProperty(str) : str2;
    }

    public static boolean k(char c2) {
        boolean[] zArr = e;
        return c2 < zArr.length && zArr[c2];
    }

    public static void l() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String m(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e2) {
            throw new JSONException("read string from reader error", e2);
        }
    }

    public static int n(int i2) {
        int i3 = 0;
        while (i2 > o[i3]) {
            i3++;
        }
        return i3 + 1;
    }

    public static int o(long j2) {
        long j3 = 10;
        for (int i2 = 1; i2 < 19; i2++) {
            if (j2 < j3) {
                return i2;
            }
            j3 *= 10;
        }
        return 19;
    }
}
