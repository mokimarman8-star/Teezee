package com.transsion.push.utils;

import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    public static String a() {
        int c = com.transsion.core.utils.d.c();
        return c != -101 ? (c == -1 || c == 0) ? BuildConfig.FLAVOR : c != 1 ? c != 2 ? c != 3 ? BuildConfig.FLAVOR : "4G" : "3G" : "2G" : "wifi";
    }

    public static String b() {
        String a = a();
        return "wifi".equals(a) ? "wifi" : BuildConfig.FLAVOR.equals(a) ? "no_network" : "mobile";
    }

    public static boolean c() {
        return "wifi".equals(a());
    }
}
