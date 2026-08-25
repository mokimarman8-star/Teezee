package com.bytedance.sdk.component.utils;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uvD {
    private static final char[] Sj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String Sj(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes(Key.STRING_CHARSET_NAME));
                    return Sj(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String Sj(byte[] bArr) {
        if (bArr != null) {
            return Sj(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String Sj(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            byte b = bArr[i8 + i];
            int i9 = i4 + 1;
            char[] cArr2 = Sj;
            cArr[i4] = cArr2[(b & 255) >> 4];
            i4 += 2;
            cArr[i9] = cArr2[b & 15];
        }
        return new String(cArr, 0, i3);
    }
}
