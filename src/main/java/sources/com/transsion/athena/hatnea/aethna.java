package com.transsion.athena.hatnea;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna extends anateh {
    private final String c;

    public aethna(Handler handler, String str) {
        super(handler);
        this.c = str;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        byte[] bArr;
        Context J = AthenaAnalytics.J();
        boolean b = com.transsion.athena.taaneh.anehat.b(J);
        String a = com.transsion.athena.config.data.model.anehat.a(this.c.getBytes(StandardCharsets.UTF_8));
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject put = new JSONObject().put("appid", 9999).put("hostid", 9999).put(PushConstants.PROVIDER_FIELD_PKG, BuildConfig.FLAVOR).put("vn", BuildConfig.FLAVOR).put("vc", BuildConfig.FLAVOR).put("ins", BuildConfig.FLAVOR).put("sdkv", "3.1.1.4").put("isfl", b).put("cnt", 1).put("events", new JSONArray().put(new JSONObject(this.c)));
            try {
                PackageManager packageManager = J.getPackageManager();
                String packageName = J.getPackageName();
                JSONObject put2 = put.put(PushConstants.PROVIDER_FIELD_PKG, packageName == null ? BuildConfig.FLAVOR : packageName);
                String installerPackageName = packageManager.getInstallerPackageName(packageName);
                if (installerPackageName == null) {
                    installerPackageName = BuildConfig.FLAVOR;
                }
                put2.put("ins", installerPackageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    JSONObject put3 = put.put("vn", str);
                    String valueOf = String.valueOf(packageInfo.versionCode);
                    if (valueOf == null) {
                        valueOf = BuildConfig.FLAVOR;
                    }
                    put3.put("vc", valueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            jSONArray.put(put);
        } catch (Exception e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
        String a2 = com.transsion.athena.taaneh.athena.a(J, 0);
        try {
            JSONObject jSONObject = new JSONObject();
            String g = com.transsion.athena.config.data.model.ehanat.g();
            if (g == null) {
                g = BuildConfig.FLAVOR;
            }
            JSONObject put4 = jSONObject.put("channel", g);
            String b2 = com.transsion.athena.taaneh.anehat.b(J, "opid");
            if (b2 == null) {
                b2 = BuildConfig.FLAVOR;
            }
            JSONObject put5 = put4.put("opid", b2);
            String b3 = com.transsion.athena.taaneh.anehat.b(J, "oneid");
            if (b3 == null) {
                b3 = BuildConfig.FLAVOR;
            }
            JSONObject put6 = put5.put("tsid", b3);
            String a3 = com.transsion.athena.taaneh.ehatna.a();
            if (a3 == null) {
                a3 = BuildConfig.FLAVOR;
            }
            JSONObject put7 = put6.put(PushConstants.PROVIDER_VAID, a3);
            JSONObject jSONObject2 = new JSONObject();
            String b4 = com.transsion.athena.taaneh.athena.b();
            if (b4 == null) {
                b4 = BuildConfig.FLAVOR;
            }
            JSONObject put8 = jSONObject2.put("tz", b4);
            String a4 = com.transsion.athena.taaneh.anehat.a();
            if (a4 == null) {
                a4 = BuildConfig.FLAVOR;
            }
            JSONObject put9 = put8.put("gaid", a4);
            String b5 = com.transsion.athena.config.data.model.ehanat.b();
            if (b5 == null) {
                b5 = BuildConfig.FLAVOR;
            }
            JSONObject put10 = put9.put("tuid", b5).put("actype", (int) com.transsion.athena.config.data.model.ehanat.c());
            String a5 = com.transsion.athena.taaneh.hatnea.a();
            if (a5 == null) {
                a5 = BuildConfig.FLAVOR;
            }
            JSONObject put11 = put10.put("osver", a5);
            String str2 = Build.VERSION.RELEASE;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            JSONObject put12 = put11.put("aver", str2);
            String str3 = Build.DISPLAY;
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            JSONObject put13 = put12.put("build", str3);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = BuildConfig.FLAVOR;
            }
            JSONObject put14 = put13.put("lang", language);
            String str4 = Build.BRAND;
            if (str4 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            JSONObject put15 = put14.put("brand", str4);
            String str5 = Build.MODEL;
            if (str5 == null) {
                str5 = BuildConfig.FLAVOR;
            }
            JSONObject put16 = put15.put("model", str5).put("net", com.transsion.athena.taaneh.aatnhe.b(J)).put("uts", System.currentTimeMillis()).put("try", 0);
            String f = com.transsion.athena.taaneh.athena.f(J);
            if (f == null) {
                f = BuildConfig.FLAVOR;
            }
            JSONObject put17 = put16.put("mcc", f);
            String g2 = com.transsion.athena.taaneh.athena.g(J);
            if (g2 == null) {
                g2 = BuildConfig.FLAVOR;
            }
            JSONObject put18 = put17.put("mnc", g2).put("ekey", put7.toString()).put("appids", jSONArray);
            JSONObject h = com.transsion.athena.config.data.model.ehanat.h();
            if (h != null && h.length() > 0) {
                int length = h.toString().getBytes(StandardCharsets.UTF_8).length;
                if (length > 2000) {
                    String format = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                    com.transsion.athena.taaneh.aethna.b(format);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorMsg", format);
                    put7.put("cparam", jSONObject3.toString());
                } else {
                    put7.put("cparam", h.toString());
                }
            }
            if (com.transsion.athena.config.data.model.ehanat.C) {
                put18.put("iid", a2 == null ? BuildConfig.FLAVOR : a2);
            }
            bArr = put18.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Exception e3) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e3));
            bArr = null;
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = com.transsion.athena.taaneh.anehat.a();
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J());
        }
        ehanat<aatnhe> a6 = anehat.a(TextUtils.isEmpty(null) ? GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.o(), true) : GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.b((String) null), true), bArr, 1, Collections.singletonList(9999), a, a2 + "_" + com.transsion.athena.data.athena.b());
        if (a6.a == 0) {
            m4.a.a(J).g("gdpr_close", BuildConfig.FLAVOR);
        } else {
            com.transsion.athena.taaneh.aethna.b("PostGdprEventTask requestByPost error : %s", a6.b.d);
        }
        if (b) {
            m4.a.a(J).g("first_launch", "false");
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "GDPR";
    }
}
