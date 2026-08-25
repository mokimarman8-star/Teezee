package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class o0 {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = true;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        g = false;
        a = false;
        c = false;
        h = false;
        b = false;
        f = false;
        e = false;
        d = false;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }

    public static void a(String str, String str2) {
        if (!a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, Throwable th) {
        if (!h || th == null) {
            return;
        }
        Log.w(a(str), th);
    }

    public static void b(String str, String str2) {
        if (!b || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!b || str2 == null || th == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    public static void c(String str, String str2) {
        if (!c || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void c(String str, String str2, Throwable th) {
        if (!h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th);
    }

    public static void d(String str, String str2) {
        if (!h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }
}
