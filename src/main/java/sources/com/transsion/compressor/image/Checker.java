package com.transsion.compressor.image;

import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public enum Checker {
    SINGLE;

    private static final int IS_JPG_TAG = 3;
    private static final byte[] JPEG_SIGNATURE = {-1, -40, -1};
    private static final String JPG = ".jpg";

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r8 <= 8) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        if (r2 == 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        if (r2 == 1296891946) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        com.transsion.compressor.image.j.f("Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
    
        if (r2 != 1229531648) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        r3 = pack(r11, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (r3 < 10) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
    
        if (r3 <= r8) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
    
        r1 = r1 + r3;
        r8 = r8 - r3;
        r3 = pack(r11, r1 - 2, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        r5 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        if (r3 <= 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
    
        if (r8 < 12) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (pack(r11, r1, 2, r2) != 274) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
    
        r1 = r1 + 12;
        r8 = r8 - 12;
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
    
        r11 = pack(r11, r1 + 8, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        if (r11 == 1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
    
        if (r11 == 3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
    
        if (r11 == 6) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b2, code lost:
    
        if (r11 == 8) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b4, code lost:
    
        com.transsion.compressor.image.j.f("Unsupported orientation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b9, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ba, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c0, code lost:
    
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c3, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ca, code lost:
    
        com.transsion.compressor.image.j.f("Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x007e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0060, code lost:
    
        r8 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getOrientation(byte[] bArr) {
        int i;
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            if (i2 + 3 >= bArr.length) {
                i = 0;
                break;
            }
            int i3 = i2 + 1;
            if ((bArr[i2] & 255) != 255) {
                break;
            }
            int i4 = bArr[i3] & 255;
            if (i4 != 255) {
                i3 = i2 + 2;
                if (i4 != 216 && i4 != 1) {
                    if (i4 != 217 && i4 != 218) {
                        int pack = pack(bArr, i3, 2, false);
                        if (pack >= 2 && (i3 = i3 + pack) <= bArr.length) {
                            if (i4 == 225 && pack >= 8 && pack(bArr, i2 + 4, 4, false) == 1165519206 && pack(bArr, i2 + 8, 2, false) == 0) {
                                i2 += 10;
                                i = pack - 8;
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i2 = i3;
        }
        j.f("Invalid length");
        return 0;
    }

    private boolean isJpg(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    String extSuffix(d dVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(dVar.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    int getOrientation(InputStream inputStream) {
        return getOrientation(j.g(inputStream));
    }

    boolean isJpg(InputStream inputStream) {
        return isJpg(j.g(inputStream));
    }

    boolean needCompress(int i, String str) {
        if (i > 0) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    if (file.length() > (i << 10)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                j.f(Log.getStackTraceString(e));
            }
        }
        return true;
    }
}
