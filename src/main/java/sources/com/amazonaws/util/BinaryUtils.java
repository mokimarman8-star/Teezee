package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class BinaryUtils {
    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str);
    }

    public static byte[] b(String str) {
        byte[] bArr = new byte[(str.length() + 1) / 2];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i, i3), 16);
            i = i3;
            i2++;
        }
        return bArr;
    }

    public static String c(byte[] bArr) {
        return Base64.encodeAsString(bArr);
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            if (hexString.length() == 1) {
                sb.append("0");
            } else if (hexString.length() == 8) {
                hexString = hexString.substring(6);
            }
            sb.append(hexString);
        }
        return StringUtils.b(sb.toString());
    }
}
