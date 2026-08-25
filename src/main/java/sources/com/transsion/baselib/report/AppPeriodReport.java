package com.transsion.baselib.report;

import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.f;
import androidx.lifecycle.g0;
import androidx.lifecycle.u;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class AppPeriodReport implements f {
    public static final AppPeriodReport a;
    private static Timer b;
    private static TimerTask c;
    private static final boolean d;
    private static long e;
    private static boolean f;
    private static Long g;
    private static long h;

    static {
        AppPeriodReport appPeriodReport = new AppPeriodReport();
        a = appPeriodReport;
        boolean c2 = appPeriodReport.c("app_period_report_debug", 3);
        d = c2;
        e = c2 ? 5000L : 300000L;
        f = true;
        h = c2 ? 300L : 3000L;
    }

    private AppPeriodReport() {
    }

    private final boolean c(String str, int i) {
        try {
            return Log.isLoggable(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ void e(AppPeriodReport appPeriodReport, Long l, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        appPeriodReport.d(l, z);
    }

    public final void b() {
        String value;
        Long x;
        ConfigBean c2 = cm.f.c.a().c("key_app_period_report", false);
        long longValue = (c2 == null || (value = c2.getValue()) == null || (x = StringsKt.x(value)) == null) ? e : x.longValue();
        if (longValue == 0) {
            longValue = e;
        }
        e = longValue;
        if (longValue > 0) {
            f(true);
            g0.i.a().getLifecycle().a(a);
            return;
        }
        a.a.f(a.a, "AppPeriodReport", "event close period " + e + " ", false, 4, (Object) null);
        g0.i.a().getLifecycle().d(a);
    }

    public final void d(Long l, boolean z) {
        Long valueOf;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = e;
        if (l != null && l.longValue() == j) {
            valueOf = Long.valueOf(e);
        } else {
            Long l2 = g;
            valueOf = l2 != null ? Long.valueOf(elapsedRealtime - l2.longValue()) : null;
        }
        g = Long.valueOf(elapsedRealtime);
        if (valueOf == null || valueOf.longValue() <= h) {
            return;
        }
        String str2 = z ? "app_background" : "app_foreground";
        a.a.f(a.a, "AppPeriodReport", "report event " + str2 + " " + valueOf, false, 4, (Object) null);
        HashMap hashMap = new HashMap();
        ConfigBean c2 = cm.f.c.a().c("keyAliveOff", true);
        if (c2 == null || (str = c2.getValue()) == null) {
            str = "0";
        }
        hashMap.put("alive_off", str);
        h.a.C("", str2, valueOf.longValue(), hashMap);
    }

    public final void f(final boolean z) {
        if (e <= 0) {
            a.a.f(a.a, "AppPeriodReport", "close period " + e + " ", false, 4, (Object) null);
            Timer timer = b;
            if (timer != null) {
                timer.purge();
            }
            Timer timer2 = b;
            if (timer2 != null) {
                timer2.cancel();
            }
            TimerTask timerTask = c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            g0.i.a().getLifecycle().d(a);
            return;
        }
        boolean z2 = f;
        Unit unit = null;
        if (z != z2) {
            e(this, null, z2, 1, null);
        }
        f = z;
        TimerTask timerTask2 = c;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        c = null;
        Timer timer3 = b;
        if (timer3 != null) {
            timer3.cancel();
        }
        Timer timer4 = b;
        if (timer4 != null) {
            timer4.purge();
        }
        b = null;
        b = new Timer();
        c = new TimerTask() { // from class: com.transsion.baselib.report.AppPeriodReport$startTimer$$inlined$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long j;
                long j2;
                a.a aVar = a.a;
                boolean z3 = z;
                j = AppPeriodReport.e;
                a.a.f(aVar, "AppPeriodReport", "period event " + z3 + " period " + j + " ", false, 4, (Object) null);
                AppPeriodReport appPeriodReport = AppPeriodReport.a;
                j2 = AppPeriodReport.e;
                appPeriodReport.d(Long.valueOf(j2), z);
            }
        };
        try {
            Result.Companion companion = Result.Companion;
            Timer timer5 = b;
            if (timer5 != null) {
                TimerTask timerTask3 = c;
                long j = e;
                timer5.schedule(timerTask3, j, j);
                unit = Unit.a;
            }
            Result.m34constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
    }

    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    public void onStart(u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.e(this, uVar);
        a.a.f(a.a, "AppPeriodReport", "onStart " + e + " ", false, 4, (Object) null);
        if (g == null) {
            g = Long.valueOf(SystemClock.elapsedRealtime());
        }
        f(false);
    }

    public void onStop(u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.f(this, uVar);
        a.a.f(a.a, "AppPeriodReport", "onStop " + e + " ", false, 4, (Object) null);
        f(true);
    }
}
