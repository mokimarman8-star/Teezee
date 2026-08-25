package com.cloud.sdk.commonutil.util;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.R$string;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {
    private static String a = "";

    public static String a(String str) {
        try {
            byte[] bytes = b().getBytes();
            byte[] bArr = new byte[12];
            new SecureRandom().nextBytes(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr));
            byte[] doFinal = cipher.doFinal(str.getBytes("UTF8"));
            byte[] bArr2 = new byte[doFinal.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(doFinal, 0, bArr2, 12, doFinal.length);
            return f(bArr2);
        } catch (Exception e) {
            c.Log().e("AESUtils", Log.getStackTraceString(e));
            return "";
        }
    }

    private static String b() {
        if (TextUtils.isEmpty(a)) {
            a = "sOWGI8Lv" + c(1, 2) + e() + d();
        }
        return a;
    }

    private static String c(int i, int i2) {
        for (int i3 = 1; i3 <= i * i2; i3++) {
            if (i3 % i == 0 && i3 % i2 == 0) {
                return "FnvyH19r";
            }
        }
        return "FnvyH19r";
    }

    private static String d() {
        return e.a().getResources().getString(R$string.bk4);
    }

    private static String e() {
        return "s2DytdII";
    }

    public static String f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
