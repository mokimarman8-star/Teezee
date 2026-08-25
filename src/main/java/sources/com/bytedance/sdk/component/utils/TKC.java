package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    private static HashMap<String, ArrayList<String>> Sj = new HashMap<>();

    public static String Sj(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> Sj2 = Sj(context, "SHA1");
        if (Sj2 != null && Sj2.size() != 0) {
            for (int i = 0; i < Sj2.size(); i++) {
                sb.append(Sj2.get(i));
                if (i < Sj2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String Sj(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception unused) {
            return "error!";
        }
    }

    public static ArrayList<String> Sj(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (Sj.get(str) != null) {
                return Sj.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : sP(context, packageName)) {
                    String str2 = "error!";
                    if ("MD5".equals(str)) {
                        str2 = Sj(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        str2 = Sj(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = Sj(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception unused) {
            }
            Sj.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] sP(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }
}
