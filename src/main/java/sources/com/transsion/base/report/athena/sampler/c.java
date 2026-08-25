package com.transsion.base.report.athena.sampler;

import android.os.Bundle;
import com.transsion.gslb.BuildConfig;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final Bundle a(Bundle bundle) {
        Intrinsics.h(bundle, "<this>");
        Bundle bundle2 = new Bundle();
        for (String str : bundle.keySet()) {
            bundle2.putString(str, bundle.getString(str));
        }
        return bundle2;
    }

    public final boolean b(String str, Bundle bundle, String str2) {
        Intrinsics.h(str, "event");
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(str2, "deviceId");
        a.a aVar = wf.a.a;
        a.a.f(aVar, "sampler", "ReportInterception --> intercept() --> 开始处理埋点拦截逻辑 --> event = " + str, false, 4, (Object) null);
        Triple a2 = a.a.a(str, a(bundle));
        boolean z = false;
        if (Intrinsics.c(a2.getFirst(), Boolean.TRUE)) {
            a.a.f(aVar, "sampler", "ReportInterception --> intercept() --> 事件表达式 命中 --> 下一步采样率判断", false, 4, (Object) null);
            b bVar = b.a;
            double intValue = ((Integer) a2.getSecond()) != null ? r4.intValue() : 100.0d;
            String str3 = (String) a2.getThird();
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            boolean a3 = bVar.a(intValue, str2, str3, 100);
            a.a.f(aVar, "sampler", "ReportInterception --> intercept() --> 采样率命中 = " + a3, false, 4, (Object) null);
            if (a3) {
                bundle.putString("sampling_rate", String.valueOf(a2.getSecond()));
                EventConfig eventConfig = EventConfig.a;
                eventConfig.i(str);
                eventConfig.h(str);
            } else {
                if (Intrinsics.a(((Integer) a2.getSecond()) != null ? Double.valueOf(r3.intValue()) : null, 0.0d)) {
                    EventConfig.a.a(str);
                } else {
                    EventConfig.a.b(str);
                }
            }
            if (!a3) {
                z = true;
            }
        } else {
            a.a.f(aVar, "sampler", "ReportInterception --> intercept() --> 事件表达式 没有命中 --> 不需要处理采样率 --> 直接上报埋点 --> event = " + str, false, 4, (Object) null);
        }
        if (z) {
            a.a.f(aVar, "sampler", "埋点拒绝上报 --> event = " + str, false, 4, (Object) null);
        } else {
            EventConfig eventConfig2 = EventConfig.a;
            bundle.putString("close_event", eventConfig2.c().toString());
            bundle.putString("miss_event", eventConfig2.d().toString());
            a.a.f(aVar, "sampler", "track: 日志上报 --> bundle = " + bundle, false, 4, (Object) null);
        }
        return z;
    }
}
