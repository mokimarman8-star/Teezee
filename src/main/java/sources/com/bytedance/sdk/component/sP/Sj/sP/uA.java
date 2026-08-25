package com.bytedance.sdk.component.sP.Sj.sP;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.bumptech.glide.load.Key;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class uA {
    public static final Charset Sj = Charset.forName(Key.STRING_CHARSET_NAME);

    public static int Sj(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static int Sj(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int Sj(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int Sj(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String Sj(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (sP(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress TKC = (str.startsWith("[") && str.endsWith("]")) ? TKC(str, 1, str.length() - 1) : TKC(str, 0, str.length());
        if (TKC == null) {
            return null;
        }
        byte[] address = TKC.getAddress();
        if (address.length == 16) {
            return Sj(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    private static String Sj(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i8 = i3;
            while (i8 < 16 && bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i3;
            if (i9 > i4 && i9 >= 4) {
                i = i3;
                i4 = i9;
            }
            i3 = i8 + 2;
        }
        Sj sj = new Sj();
        while (i2 < bArr.length) {
            if (i2 == i) {
                sj.sP(58);
                i2 += i4;
                if (i2 == 16) {
                    sj.sP(58);
                }
            } else {
                if (i2 > 0) {
                    sj.sP(58);
                }
                sj.sP(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return sj.TKC();
    }

    public static void Sj(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static boolean Sj(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i8 = i;
            int i9 = 0;
            while (i8 < i2) {
                char charAt = str.charAt(i8);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i9 == 0 && i != i8) || (i9 = ((i9 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i8++;
            }
            if (i8 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i9;
            i4++;
            i = i8;
        }
        return i4 == i3 + 4;
    }

    public static boolean Sj(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InetAddress TKC(String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i8 = -1;
        int i9 = -1;
        while (true) {
            if (i < i2) {
                if (i4 != 16) {
                    int i10 = i + 2;
                    if (i10 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                        if (i8 == -1) {
                            i4 += 2;
                            i8 = i4;
                            if (i10 != i2) {
                                i9 = i10;
                                int i11 = 0;
                                i = i9;
                                while (i < i2) {
                                }
                                i3 = i - i9;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i4 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else {
                            if (!str.regionMatches(i, InstructionFileId.DOT, 0, 1) || !Sj(str, i9, i2, bArr, i4 - 2)) {
                                return null;
                            }
                            i4 += 2;
                        }
                    }
                    i9 = i;
                    int i112 = 0;
                    i = i9;
                    while (i < i2) {
                        int Sj2 = Sj(str.charAt(i));
                        if (Sj2 == -1) {
                            break;
                        }
                        i112 = (i112 << 4) + Sj2;
                        i++;
                    }
                    i3 = i - i9;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i12 = i4 + 1;
                    bArr[i4] = (byte) ((i112 >>> 8) & 255);
                    i4 += 2;
                    bArr[i12] = (byte) (i112 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i4 != 16) {
            if (i8 == -1) {
                return null;
            }
            int i13 = i4 - i8;
            System.arraycopy(bArr, i8, bArr, 16 - i13, i13);
            Arrays.fill(bArr, i8, (16 - i4) + i8, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int sP(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    private static boolean sP(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
