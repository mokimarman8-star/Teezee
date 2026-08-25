package com.pgl.ssdk;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class v0 {
    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
