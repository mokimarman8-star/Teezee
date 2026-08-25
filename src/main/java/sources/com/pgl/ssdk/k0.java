package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class k0 {
    public static int a = -1;
    public static String b = null;
    private static String c = "api16-access-ttp.tiktokpangle.us";
    public static final String[] d = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    private static int e = Integer.MIN_VALUE;
    public static String f = "";

    public static String a() {
        return a == 1 ? "VA" : "SG";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            if (e == Integer.MIN_VALUE) {
                e = u0.a(context, "domain_index", 0);
            }
            String[] strArr = d;
            return strArr[e % strArr.length];
        } catch (Throwable unused) {
            return c;
        }
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    public static String b() {
        return f;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(b)) {
            r0.a("updateIndex");
            int i = e;
            if (i >= Integer.MAX_VALUE) {
                e = 0;
                return;
            }
            int i2 = i + 1;
            e = i2;
            u0.b(context, "domain_index", i2);
        }
    }

    public static void b(String str) {
        f = str;
    }
}
