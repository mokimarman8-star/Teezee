package com.transsnet.downloader.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    private static long c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    public static final h a = new h();
    private static String b = HttpUrl.FRAGMENT_ENCODE_SET;
    private static String g = HttpUrl.FRAGMENT_ENCODE_SET;
    private static final ConcurrentHashMap h = new ConcurrentHashMap();

    private h() {
    }

    public final Map a() {
        if (d) {
            c("6");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConcurrentHashMap concurrentHashMap = h;
        linkedHashMap.putAll(concurrentHashMap);
        concurrentHashMap.clear();
        e = false;
        f = false;
        return linkedHashMap;
    }

    public final void b(String step) {
        Intrinsics.h(step, "step");
        if (d && !Intrinsics.c(g, step)) {
            if (Intrinsics.c(step, "4")) {
                if (e) {
                    return;
                } else {
                    e = true;
                }
            }
            if (Intrinsics.c(step, com.vungle.ads.internal.b.AD_VISIBILITY_VISIBLE_LATER)) {
                if (f) {
                    return;
                } else {
                    f = true;
                }
            }
            g = step;
            a.a.f(wf.a.a, "DownloadProxyLog", "logPoint, step = " + step, false, 4, (Object) null);
            long currentTimeMillis = System.currentTimeMillis();
            h.put("delay_step_" + b + "_" + step, Long.valueOf(currentTimeMillis - c));
            b = step;
            c = currentTimeMillis;
        }
    }

    public final void c(String step) {
        Intrinsics.h(step, "step");
        a.a.v(wf.a.a, "DownloadProxyLog", "onFinish, step = " + step, false, 4, (Object) null);
        b(step);
        d = false;
        c = 0L;
    }

    public final void d(String step) {
        Intrinsics.h(step, "step");
        a.a.v(wf.a.a, "DownloadProxyLog", "onStart, step = " + step, false, 4, (Object) null);
        d = true;
        b = step;
        c = System.currentTimeMillis();
        h.clear();
    }
}
