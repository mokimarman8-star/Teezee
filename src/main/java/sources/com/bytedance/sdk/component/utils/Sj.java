package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {

    /* renamed from: com.bytedance.sdk.component.utils.Sj$Sj, reason: collision with other inner class name */
    static class C0054Sj {
        static final Random Sj = Sj.TKC();
    }

    public static String Sj() {
        String Sj = Sj(16);
        if (Sj == null || Sj.length() != 32) {
            return null;
        }
        return Sj;
    }

    public static String Sj(int i) {
        try {
            byte[] bArr = new byte[i];
            C0054Sj.Sj.nextBytes(bArr);
            return HiB.Sj(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String Sj(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static JSONObject Sj(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String sP = sP(str);
                if (TextUtils.isEmpty(sP)) {
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
                    jSONObject.put("cypher", 0);
                } else {
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, sP);
                    jSONObject.put("cypher", 3);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable unused) {
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            jSONObject.put("cypher", 0);
        }
        return jSONObject;
    }

    public static JSONObject Sj(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : Sj(jSONObject.toString());
    }

    public static String TKC(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String Sj = Sj(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || Sj == null) ? str : com.bytedance.sdk.component.EjP.Sj.sP(str.substring(49), substring, Sj);
    }

    public static Random TKC() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String sP() {
        String Sj = Sj(8);
        if (Sj == null || Sj.length() != 16) {
            return null;
        }
        return Sj;
    }

    public static String sP(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String Sj = Sj();
        String Sj2 = Sj(Sj, 32);
        String sP = sP();
        return 3 + Sj + sP + ((Sj2 == null || sP == null) ? null : com.bytedance.sdk.component.EjP.Sj.Sj(str, sP, Sj2));
    }
}
