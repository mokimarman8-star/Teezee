package com.transsion.transfer.wifi.util;

import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final String a(String s) {
        Intrinsics.h(s, "s");
        if (TextUtils.isEmpty(s)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = s.getBytes(Charsets.UTF_8);
            Intrinsics.g(bytes, "getBytes(...)");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i += 2;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
