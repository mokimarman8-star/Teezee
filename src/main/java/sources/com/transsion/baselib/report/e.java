package com.transsion.baselib.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.c;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import pb.i;
import qx.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class e {
    public static final e a = new e();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.b
        public final Object invoke() {
            a j;
            j = e.j();
            return j;
        }
    });
    private static final Regex c = new Regex("VmSize:\\s*(\\d+)\\s*kB");
    private static final Regex d = new Regex("VmRSS:\\s*(\\d+)\\s*kB");

    private e() {
    }

    private final String d(long j) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((j / 1024.0f) / 1024.0f)}, 1));
        Intrinsics.g(format, "format(...)");
        return format + "MB";
    }

    private final void e(File file, Charset charset, Function1 function1) {
        Object m34constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            TextStreamsKt.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
            m34constructorimpl = Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
        }
        Throwable m37exceptionOrNullimpl = Result.m37exceptionOrNullimpl(m34constructorimpl);
        if (m37exceptionOrNullimpl != null) {
            m37exceptionOrNullimpl.printStackTrace();
        }
    }

    static /* synthetic */ void f(e eVar, File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.b;
        }
        eVar.e(file, charset, function1);
    }

    private final Debug.MemoryInfo h(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("activity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        activityManager.getMemoryInfo(new ActivityManager.MemoryInfo());
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
        Intrinsics.g(processMemoryInfo, "getProcessMemoryInfo(...)");
        return processMemoryInfo[0];
    }

    private final String i(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(i / 1024.0f)}, 1));
        Intrinsics.g(format, "format(...)");
        return format + "MB";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a j() {
        return (a) TheRouter.d(a.class, new Object[0]);
    }

    private final int k(Regex regex, String str) {
        List a2;
        String str2;
        MatchResult matchEntire = regex.matchEntire(StringsKt.n1(str).toString());
        if (matchEntire == null || (a2 = matchEntire.a()) == null || (str2 = (String) CollectionsKt.l0(a2, 1)) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Bundle bundle, String str) {
        Intrinsics.h(str, "line");
        if (StringsKt.W(str, "VmSize", false, 2, (Object) null)) {
            if (bundle != null) {
                e eVar = a;
                bundle.putString("vss", eVar.i(eVar.k(c, str)));
            }
        } else if (StringsKt.W(str, "VmRSS", false, 2, (Object) null) && bundle != null) {
            e eVar2 = a;
            bundle.putString("rss", eVar2.i(eVar2.k(d, str)));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(lb.b bVar, String str) {
        Intrinsics.h(str, "line");
        if (StringsKt.W(str, "VmSize", false, 2, (Object) null)) {
            e eVar = a;
            bVar.c("vss", eVar.i(eVar.k(c, str)));
        } else if (StringsKt.W(str, "VmRSS", false, 2, (Object) null)) {
            e eVar2 = a;
            bVar.c("rss", eVar2.i(eVar2.k(d, str)));
        }
        return Unit.a;
    }

    public final a g() {
        return (a) b.getValue();
    }

    public final void l(String str, Bundle bundle, Context context) {
        Intrinsics.h(str, "event");
        FirebaseAnalytics a2 = lb.a.a(c.a);
        Debug.MemoryInfo h = h(context);
        if (h != null) {
            if (bundle != null) {
                bundle.putString("max_heap", a.d(Runtime.getRuntime().maxMemory()));
            }
            if (bundle != null) {
                bundle.putString("total_heap", a.d(Runtime.getRuntime().totalMemory()));
            }
            if (bundle != null) {
                bundle.putString("free_heap", a.d(Runtime.getRuntime().freeMemory()));
            }
            if (bundle != null) {
                bundle.putString("native_pss", a.i(h.nativePss));
            }
            if (bundle != null) {
                bundle.putString("other_pss", a.i(h.otherPss));
            }
            f(a, new File("/proc/self/status"), null, new c(bundle), 1, null);
        }
        a2.logEvent(str, bundle);
    }

    public final void n(String str, Long l, Context context) {
        Intrinsics.h(str, "screenName");
        FirebaseAnalytics a2 = lb.a.a(c.a);
        lb.b bVar = new lb.b();
        bVar.c("screen_name", str);
        bVar.c("screen_class", str);
        if (l != null) {
            bVar.b("engagement_time_msec", l.longValue());
            e eVar = a;
            Debug.MemoryInfo h = eVar.h(context);
            if (h != null) {
                bVar.c("max_heap", eVar.d(Runtime.getRuntime().maxMemory()));
                bVar.c("total_heap", eVar.d(Runtime.getRuntime().totalMemory()));
                bVar.c("free_heap", eVar.d(Runtime.getRuntime().freeMemory()));
                bVar.c("native_pss", eVar.i(h.nativePss));
                bVar.c("other_pss", eVar.i(h.otherPss));
                f(eVar, new File("/proc/self/status"), null, new d(bVar), 1, null);
            }
        }
        a2.logEvent("screen_view", bVar.a());
    }

    public final void p(boolean z) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(Utils.a());
        Intrinsics.g(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.setAnalyticsCollectionEnabled(z);
        i.a(c.a).setCrashlyticsCollectionEnabled(z);
    }

    public final void q() {
        UserInfo i;
        a g = g();
        String userId = (g == null || (i = g.i()) == null) ? null : i.getUserId();
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("firebase_id", "");
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(userId)) {
                userId = TextUtils.isEmpty(userId) ? tg.b.a.h() : string;
            }
            bVar.b().putString("firebase_id", userId);
            string = userId;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(Utils.a());
        Intrinsics.g(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.setUserId(string);
        FirebaseCrashlytics a2 = i.a(c.a);
        if (string != null) {
            a2.setUserId(string);
        }
    }
}
