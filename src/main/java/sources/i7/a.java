package i7;

import com.cloud.hisavana.sdk.Y;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a {
    private static int a;
    private static boolean b;

    public static boolean a() {
        return c() != 0;
    }

    public static String b() {
        return c() != 0 ? "https://minproject.test.sunnbird.com/close-report/index.html" : "https://minproject.sunnbird.com/close-report/index.html";
    }

    public static int c() {
        return a;
    }

    public static String d() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/cloudcontrol/query/getCloudControlDataOffline";
    }

    public static String e() {
        int c = c();
        return c != 0 ? c != 2 ? c != 3 ? c != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com" : "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea" : "https://api-fat0101.eagllwin.com" : "https://cc-api.hisavana.com";
    }

    public static String f() {
        return c() == 0 ? "https://dcdn-api.hisavana.com" : "https://dcdn-api.test.hisavana.com";
    }

    public static String g() {
        return c() != 0 ? Y.a.y() : Y.a.x();
    }

    public static String h() {
        int c = c();
        return c != 0 ? c != 4 ? "https://api.test.eagllwin.com" : "https://api.fat1.eagllwin.com" : "https://api.eagllwin.com";
    }

    public static String i() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/addispatch/query/getAdData";
    }

    public static String j() {
        int c = c();
        return c != 0 ? c != 2 ? c != 3 ? c != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com" : "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea" : "https://api-fat0101.eagllwin.com" : "https://api.hisavana.com";
    }

    public static boolean k() {
        return b;
    }
}
