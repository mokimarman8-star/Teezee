package kd;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class o {
    private static final Charset a = Charset.defaultCharset();
    public static final Charset b = Charset.forName("SJIS");
    public static final Charset c;
    private static final Charset d;
    private static final boolean e;

    static {
        Charset charset;
        try {
            charset = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        c = charset;
        Charset forName = Charset.forName("EUC_JP");
        d = forName;
        Charset charset2 = b;
        Charset charset3 = a;
        e = charset2.equals(charset3) || forName.equals(charset3);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Charset a(byte[] bArr, Map map) {
        int i;
        byte b2;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return Charset.forName(map.get(decodeHintType).toString());
            }
        }
        boolean z = true;
        int i2 = 0;
        if (bArr2.length > 2 && (((b2 = bArr2[0]) == -2 && bArr2[1] == -1) || (b2 == -1 && bArr2[1] == -2))) {
            return StandardCharsets.UTF_16;
        }
        int length = bArr2.length;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z3 = true;
        boolean z4 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z || z3 || z4)) {
            byte b3 = bArr2[i4];
            int i14 = b3 & 255;
            if (z4) {
                if (i5 <= 0) {
                    i = length;
                    if ((b3 & 128) != 0) {
                        if ((b3 & 64) != 0) {
                            int i15 = i5 + 1;
                            if ((b3 & 32) == 0) {
                                i7++;
                            } else {
                                i15 = i5 + 2;
                                if ((b3 & 16) == 0) {
                                    i8++;
                                } else {
                                    i5 += 3;
                                    if ((b3 & 8) == 0) {
                                        i9++;
                                    }
                                }
                            }
                            i5 = i15;
                        }
                    }
                    if (z) {
                        if (i14 > 127 && i14 < 160) {
                            z = false;
                        } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                            i11++;
                        }
                    }
                    if (z3) {
                        if (i6 > 0) {
                            if (i14 >= 64 && i14 != 127 && i14 <= 252) {
                                i6--;
                            }
                            z3 = false;
                        } else {
                            if (i14 != 128 && i14 != 160 && i14 <= 239) {
                                if (i14 <= 160 || i14 >= 224) {
                                    if (i14 > 127) {
                                        i6++;
                                        int i16 = i12 + 1;
                                        if (i16 > i2) {
                                            i2 = i16;
                                            i12 = i2;
                                        } else {
                                            i12 = i16;
                                        }
                                    } else {
                                        i12 = 0;
                                    }
                                    i13 = 0;
                                } else {
                                    i3++;
                                    int i17 = i13 + 1;
                                    if (i17 > i10) {
                                        i10 = i17;
                                        i13 = i10;
                                    } else {
                                        i13 = i17;
                                    }
                                    i12 = 0;
                                }
                            }
                            z3 = false;
                        }
                    }
                    i4++;
                    bArr2 = bArr;
                    length = i;
                } else if ((b3 & 128) == 0) {
                    i = length;
                } else {
                    i5--;
                }
                z4 = false;
                if (z) {
                }
                if (z3) {
                }
                i4++;
                bArr2 = bArr;
                length = i;
            }
            i = length;
            if (z) {
            }
            if (z3) {
            }
            i4++;
            bArr2 = bArr;
            length = i;
        }
        int i18 = length;
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        return (!z4 || (!z2 && (i7 + i8) + i9 <= 0)) ? (!z3 || (!e && i10 < 3 && i2 < 3)) ? (z && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < i18) ? StandardCharsets.ISO_8859_1 : b : z ? StandardCharsets.ISO_8859_1 : z3 ? b : z4 ? StandardCharsets.UTF_8 : a : b : StandardCharsets.UTF_8;
    }
}
