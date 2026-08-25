package com.transsion.startup.pref.consume;

import android.app.ActivityManager;
import android.app.Application;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.h;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import tg.b;
import yw.f;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class AppStartReport {
    private static boolean b;
    private static boolean c;
    public static final AppStartReport a = new AppStartReport();
    private static final Map d = new HashMap();

    private AppStartReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map f() {
        long j;
        long j2;
        long j3;
        try {
            Result.Companion companion = Result.Companion;
            HashMap hashMap = new HashMap();
            Map map = d;
            AppStartDotState appStartDotState = (AppStartDotState) map.get(AppStartDotState.APP_START);
            AppStartDotState appStartDotState2 = (AppStartDotState) map.get(AppStartDotState.APP_END);
            AppStartDotState appStartDotState3 = (AppStartDotState) map.get(AppStartDotState.MAIN_CREATE);
            AppStartDotState appStartDotState4 = (AppStartDotState) map.get(AppStartDotState.TRENDING_END);
            if (appStartDotState3 != null) {
                j = appStartDotState3.getTimestamp() - (appStartDotState2 != null ? appStartDotState2.getTimestamp() : appStartDotState3.getTimestamp());
            } else {
                j = 0;
            }
            String str = ((appStartDotState2 != null ? appStartDotState2.getTimestamp() : 0L) <= 0 || j > 10000 || j <= 0) ? "warm" : "cold";
            if (Intrinsics.c(str, "warm")) {
                if (appStartDotState4 != null) {
                    j3 = appStartDotState4.getTimestamp() - (appStartDotState3 != null ? appStartDotState3.getTimestamp() : appStartDotState4.getTimestamp());
                } else {
                    j3 = 0;
                }
                hashMap.put("act_app_gap", "0");
            } else {
                if (appStartDotState4 != null) {
                    j2 = appStartDotState4.getTimestamp() - (appStartDotState != null ? appStartDotState.getTimestamp() : appStartDotState4.getTimestamp());
                } else {
                    j2 = 0;
                }
                hashMap.put("act_app_gap", String.valueOf(j));
                j3 = j2;
            }
            if (j3 <= 0) {
                return null;
            }
            hashMap.put("total_time", String.valueOf(j3));
            hashMap.put("type", h.a.d());
            hashMap.put("model", str);
            b bVar = b.a;
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            ActivityManager.MemoryInfo k = bVar.k(a2);
            hashMap.put("mem_size", String.valueOf(k.totalMem));
            hashMap.put("low_memory", String.valueOf(k.lowMemory));
            Iterator it = DownloadSDCardUtil.a.b().iterator();
            long j4 = 0;
            while (it.hasNext()) {
                j4 += ((f) it.next()).a();
            }
            hashMap.put("available", String.valueOf(j4));
            hashMap.put("cpu_size", String.valueOf(Runtime.getRuntime().availableProcessors()));
            boolean z = c;
            if (z) {
                hashMap.put("first_open", String.valueOf(z));
            }
            a aVar = new a();
            long timestamp = appStartDotState != null ? appStartDotState.getTimestamp() : 0L;
            hashMap.put(AppStartDotState.APP_START, "0");
            hashMap.put(AppStartDotState.APP_END, String.valueOf(((Number) aVar.invoke(AppStartDotState.APP_END)).longValue() - timestamp));
            hashMap.put(AppStartDotState.SPLASH_START, String.valueOf(((Number) aVar.invoke(AppStartDotState.SPLASH_START)).longValue() - timestamp));
            hashMap.put(AppStartDotState.SPLASH_RESUME, String.valueOf(((Number) aVar.invoke(AppStartDotState.SPLASH_RESUME)).longValue() - timestamp));
            hashMap.put(AppStartDotState.AD_LOADING, String.valueOf(((Number) aVar.invoke(AppStartDotState.AD_LOADING)).longValue() - timestamp));
            hashMap.put(AppStartDotState.AD_END, String.valueOf(((Number) aVar.invoke(AppStartDotState.AD_END)).longValue() - timestamp));
            hashMap.put(AppStartDotState.AD_RENDERING, String.valueOf(((Number) aVar.invoke(AppStartDotState.AD_RENDERING)).longValue() - timestamp));
            hashMap.put(AppStartDotState.MAIN_CREATE, String.valueOf(((Number) aVar.invoke(AppStartDotState.MAIN_CREATE)).longValue() - timestamp));
            hashMap.put(AppStartDotState.TRENDING_CREATE, String.valueOf(((Number) aVar.invoke(AppStartDotState.TRENDING_CREATE)).longValue() - timestamp));
            hashMap.put(AppStartDotState.TRENDING_RENDER, String.valueOf(((Number) aVar.invoke(AppStartDotState.TRENDING_RENDER)).longValue() - timestamp));
            hashMap.put(AppStartDotState.TRENDING_END, String.valueOf(((Number) aVar.invoke(AppStartDotState.TRENDING_END)).longValue() - timestamp));
            return hashMap;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            if (Result.m37exceptionOrNullimpl(Result.m34constructorimpl(ResultKt.a(th))) == null) {
                throw new KotlinNothingValueException();
            }
            a.h("error error error --- failed to obtain device information");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(String str) {
        Intrinsics.h(str, "dot");
        AppStartDotState appStartDotState = (AppStartDotState) d.get(str);
        if (appStartDotState != null) {
            return appStartDotState.getTimestamp();
        }
        return 0L;
    }

    private final void h(String str) {
        Log.w("zxb_log_dot", str);
    }

    public final void e(AppStartDotState appStartDotState) {
        Intrinsics.h(appStartDotState, "dot");
        if (b) {
            return;
        }
        Map map = d;
        if (map.containsKey(appStartDotState.getState())) {
            return;
        }
        map.put(appStartDotState.getState(), appStartDotState);
        if (Intrinsics.c(appStartDotState.getState(), AppStartDotState.MAIN_CREATE)) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            c = bVar.b().getBoolean("first_open", true);
            bVar.b().putBoolean("first_open", false);
        } else if (Intrinsics.c(appStartDotState.getState(), AppStartDotState.TRENDING_END)) {
            i();
        }
    }

    public final void i() {
        if (b) {
            return;
        }
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new report.1((Continuation) null), 3, (Object) null);
    }

    public final void j() {
        b = false;
    }
}
