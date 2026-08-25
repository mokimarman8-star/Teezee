package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    public static volatile String a = null;
    public static String b = null;
    public static boolean c = false;
    public static int d = 0;
    private static String e = "";
    private static boolean f = false;
    private static String g = "";
    private static boolean h;
    private static boolean i;

    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
                    f.a(advertisingIdInfo.getId());
                    f.d = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                    f.b(this.a, advertisingIdInfo.getId(), f.d);
                } catch (Exception unused) {
                    o0.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                    try {
                        b.C0091b a = new b().a(this.a);
                        f.a(a.a());
                        f.d = a.b() ? 1 : 0;
                        f.b(this.a, a.a(), f.d);
                    } catch (Exception unused2) {
                        o0.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                    }
                } catch (Throwable th) {
                    o0.b("DomainSameDiTool", th.getMessage());
                }
            }
        }
    }

    public static int a() {
        return d;
    }

    public static void a(int i2) {
        d = i2;
    }

    public static void a(Context context) {
        new Thread(new a(context)).start();
    }

    public static void a(String str) {
        b = i0.b(str);
        a = str;
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (f) {
            return e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().d().getContentResolver();
                int i2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                jSONObject.put("status", i2);
                jSONObject.put("amazonId", string);
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    g = jSONObject2;
                    e = i0.b(jSONObject2);
                }
            } catch (Settings.SettingNotFoundException e2) {
                o0.b("DomainSameDiTool", e2.getMessage());
            }
        } catch (Throwable th) {
            o0.b("DomainSameDiTool", th.getMessage());
        }
        f = true;
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, int i2) {
        try {
            if (y0.b(str)) {
                w0.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            w0.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i2));
        } catch (Exception e2) {
            o0.b("DomainSameDiTool", e2.getMessage());
        }
    }

    public static boolean b(Context context) {
        try {
        } catch (Exception unused) {
            h = false;
        }
        if (i) {
            return h;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            h = context.getPackageManager().checkPermission(i0.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
        } else {
            h = true;
        }
        i = true;
        return h;
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(b) ? TtmlNode.ANONYMOUS_REGION_ID : b;
        }
        if (!TextUtils.isEmpty(b)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() || d == 0) ? b : TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (!c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            c = true;
        }
        return TtmlNode.ANONYMOUS_REGION_ID;
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String d() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(a) ? TtmlNode.ANONYMOUS_REGION_ID : a;
        }
        if (!TextUtils.isEmpty(a)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() || d == 0) ? a : TtmlNode.ANONYMOUS_REGION_ID;
        }
        k0.k();
        if (!c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            c = true;
        }
        return TextUtils.isEmpty(a) ? TtmlNode.ANONYMOUS_REGION_ID : a;
    }

    public static String e() {
        if (TextUtils.isEmpty(g) && !f) {
            b();
        }
        return g;
    }
}
