package com.transsion.baselib.report;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.transsion.baselib.helper.b;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();
    private static String b = "cold";
    private static long c = SystemClock.elapsedRealtime();
    private static String d = BuildConfig.FLAVOR;
    private static String e = BuildConfig.FLAVOR;
    private static Uri f;

    private h() {
    }

    private final int a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    private final String c(Uri uri) {
        return uri == null ? "launch" : Intrinsics.c(b.a.c(uri).getUtmSource(), MsgStyle.SOURCE_PUSH) ? MsgStyle.SOURCE_PUSH : "deeplink";
    }

    private final void f(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", d);
        hashMap.put("channel", e);
        hashMap.put("duration", String.valueOf(j));
        qi.h.a.r("app_stop", hashMap);
    }

    private final void g(String str) {
        d = c(f);
        String utmSource = b.a.c(f).getUtmSource();
        if (utmSource == null) {
            utmSource = BuildConfig.FLAVOR;
        }
        e = utmSource;
        f = null;
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("source", d);
        hashMap.put("channel", e);
        qi.h hVar = qi.h.a;
        hVar.r("app_start", hashMap);
        if (Intrinsics.c(d, "launch")) {
            hVar.r("app_launch_channel", hashMap);
            i(e);
        }
    }

    private final void i(String str) {
        Long x;
        try {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            bVar.b().putString("k_last_open_channel", str);
            String string = bVar.b().getString("k_last_open_time", "0");
            long longValue = (string == null || (x = StringsKt.x(string)) == null) ? 0L : x.longValue();
            if (!DateUtils.isToday(longValue)) {
                int i = bVar.b().getInt("k_open_day_count", 0);
                int a2 = a(longValue);
                int a3 = a(System.currentTimeMillis());
                int i2 = a3 - a2 == 1 ? 1 + i : 1;
                bVar.b().putInt("k_open_day_count", i2);
                a.a.f(wf.a.a, "ReportLaunchManager", "openDayCount:" + i2 + ", lastDay:" + a2 + ", curDay:" + a3, false, 4, (Object) null);
            }
            bVar.b().putString("k_last_open_time", String.valueOf(System.currentTimeMillis()));
            bVar.b().putString("k_last_open_version", com.transsion.core.utils.a.c());
        } catch (Exception unused) {
        }
    }

    public final Uri b() {
        return f;
    }

    public final String d() {
        return TextUtils.isEmpty(d) ? "launch" : d;
    }

    public final void e(boolean z) {
        if (z) {
            b = "warm";
            f(SystemClock.elapsedRealtime() - c);
        } else {
            c = SystemClock.elapsedRealtime();
            g(b);
        }
    }

    public final void h(String str, String str2) {
        String str3;
        String queryParameter;
        Intrinsics.h(str, "shortUrl");
        Intrinsics.h(str2, "wholeUrl");
        String str4 = BuildConfig.FLAVOR;
        Uri parse = !Intrinsics.c(str2, BuildConfig.FLAVOR) ? Uri.parse(str2) : Uri.parse(str);
        d = c(parse);
        String utmSource = b.a.c(parse).getUtmSource();
        if (utmSource == null) {
            utmSource = BuildConfig.FLAVOR;
        }
        e = utmSource;
        HashMap hashMap = new HashMap();
        hashMap.put("source", d);
        hashMap.put("channel", e);
        if (parse == null || (str3 = parse.getQueryParameter("msgId")) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        hashMap.put("msgId", str3);
        if (parse != null && (queryParameter = parse.getQueryParameter("msg_type")) != null) {
            str4 = queryParameter;
        }
        hashMap.put("msg_type", str4);
        hashMap.put("url", str2);
        hashMap.put("surl", str);
        qi.h.a.r("app_launch_channel", hashMap);
        i(e);
    }

    public final void j(Uri uri) {
        f = uri;
    }
}
