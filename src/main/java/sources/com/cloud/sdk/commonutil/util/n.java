package com.cloud.sdk.commonutil.util;

import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class n {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return b(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Exception e) {
            c.Log().e("MD5", Log.getStackTraceString(e));
            return str;
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(c(b));
        }
        return sb.toString();
    }

    private static String c(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }
}
