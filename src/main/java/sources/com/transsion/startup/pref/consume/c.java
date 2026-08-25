package com.transsion.startup.pref.consume;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Arrays;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private static long b;
    private static long c;
    private static long d;
    private static long e;
    private static long f;
    private static long g;
    private static boolean i;
    private static boolean j;
    private static boolean k;
    private static boolean l;
    private static boolean m;
    public static final c a = new c();
    private static boolean h = true;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver;
            View view = this.a;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            c cVar = c.a;
            c.f = SystemClock.elapsedRealtime();
            long j = c.f - c.b;
            long h = c.a.h();
            a.a aVar = wf.a.a;
            a.a.l(aVar, "AppStartup", "🚀 [Phase 3] MainActivity TTID:", false, 4, (Object) null);
            a.a.l(aVar, "AppStartup", "   ├─ 总耗时 (含广告等待): " + j + "ms", false, 4, (Object) null);
            a.a.l(aVar, "AppStartup", "   ├─ 广告等待时长: " + h + "ms", false, 4, (Object) null);
            a.a.l(aVar, "AppStartup", "   └─ 真实启动时间 (TTID): " + (j - h) + "ms", false, 4, (Object) null);
            c.j = true;
            return true;
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver;
            View view = this.a;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            c cVar = c.a;
            c.c = SystemClock.elapsedRealtime();
            long j = c.c - c.b;
            a.a.l(wf.a.a, "AppStartup", "🚀 [Phase 1] Splash TTID: " + j + "ms (进程启动 → Splash首帧)", false, 4, (Object) null);
            c.i = true;
            return true;
        }
    }

    private c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
    
        if (r10 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (r10 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r10 = r8 - r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n() {
        long j2;
        long j3 = c;
        long j4 = 0;
        long j5 = j3 > 0 ? j3 - b : 0L;
        long h2 = h();
        long j6 = f;
        if (j6 > 0) {
            j2 = e;
        }
        if (j6 > 0) {
            j2 = c;
        }
        long j7 = 0;
        long j8 = g;
        if (j8 > 0 && j6 > 0) {
            j4 = j8 - j6;
        }
        long j9 = j8 - b;
        long j10 = j9 - h2;
        String valueOf = m ? String.valueOf(h2) : "无广告";
        a.a aVar = wf.a.a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%6d", Arrays.copyOf(new Object[]{Long.valueOf(j5)}, 1));
        Intrinsics.g(format, "format(...)");
        String format2 = String.format("%6s", Arrays.copyOf(new Object[]{valueOf}, 1));
        Intrinsics.g(format2, "format(...)");
        String format3 = String.format("%6d", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
        Intrinsics.g(format3, "format(...)");
        String format4 = String.format("%6d", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
        Intrinsics.g(format4, "format(...)");
        String format5 = String.format("%6d", Arrays.copyOf(new Object[]{Long.valueOf(j9)}, 1));
        Intrinsics.g(format5, "format(...)");
        String format6 = String.format("%6d", Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
        Intrinsics.g(format6, "format(...)");
        a.a.l(aVar, "AppStartup", StringsKt.p("\n            |\n            |╔══════════════════════════════════════════════════════════════╗\n            |║                    🚀 启动性能分析报告                        ║\n            |╠══════════════════════════════════════════════════════════════╣\n            |║ 阶段分解：                                                    ║\n            |║   [1] 进程启动 → Splash首帧:        " + format + "ms              ║\n            |║   [2] 广告等待时长:                 " + format2 + "ms  (已排除)    ║\n            |║   [3] 广告结束 → MainActivity首帧:  " + format3 + "ms              ║\n            |║   [4] MainActivity首帧 → 数据加载:  " + format4 + "ms              ║\n            |╠══════════════════════════════════════════════════════════════╣\n            |║ 汇总：                                                        ║\n            |║   总耗时 (含广告等待):             " + format5 + "ms              ║\n            |║   真实启动时间 (TTFD):             " + format6 + "ms              ║\n            |╚══════════════════════════════════════════════════════════════╝\n        ", null, 1, null), false, 4, (Object) null);
    }

    private final void p() {
        c = 0L;
        d = 0L;
        e = 0L;
        f = 0L;
        g = 0L;
        h = true;
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
    }

    public final long h() {
        boolean z = m;
        if (z) {
            long j2 = e;
            long j3 = d;
            if (j2 > j3) {
                return j2 - j3;
            }
        }
        if (z && l) {
            return SystemClock.elapsedRealtime() - d;
        }
        return 0L;
    }

    public final com.transsion.startup.pref.consume.b i() {
        long h2 = h();
        long j2 = g;
        long j3 = j2 > 0 ? j2 - b : 0L;
        long j4 = c;
        long j5 = j4 > 0 ? j4 - b : 0L;
        long j6 = f;
        return new com.transsion.startup.pref.consume.b(j5, h2, j6 > 0 ? (j6 - b) - h2 : 0L, j3, j3 - h2, m);
    }

    public final void j() {
        b = Build.VERSION.SDK_INT >= 24 ? com.google.firebase.perf.metrics.a.a() : SystemClock.elapsedRealtime();
        p();
        a.a.l(wf.a.a, "AppStartup", "📍 [Phase 0] App Process Started at: " + b, false, 4, (Object) null);
    }

    public final void k(Activity activity) {
        View findViewById;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(activity, "activity");
        if (!h || j || (findViewById = activity.findViewById(R.id.content)) == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new a(findViewById));
    }

    public final void l(Activity activity) {
        View findViewById;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(activity, "activity");
        if (!h || i || (findViewById = activity.findViewById(R.id.content)) == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new b(findViewById));
    }

    public final void m() {
        if (!h || l) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d = elapsedRealtime;
        l = true;
        m = true;
        long j2 = elapsedRealtime - b;
        a.a.l(wf.a.a, "AppStartup", "⏸️ [Phase 2] Paused for Ad at: " + d + " (已运行 " + j2 + "ms)", false, 4, (Object) null);
    }

    public final void o(Activity activity) {
        if (!h || k) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        g = elapsedRealtime;
        long j2 = elapsedRealtime - b;
        long h2 = h();
        a.a aVar = wf.a.a;
        a.a.l(aVar, "AppStartup", "✅ [Phase 4] TTFD (Full Display):", false, 4, (Object) null);
        a.a.l(aVar, "AppStartup", "   ├─ 总耗时 (含广告等待): " + j2 + "ms", false, 4, (Object) null);
        a.a.l(aVar, "AppStartup", "   ├─ 广告等待时长: " + h2 + "ms", false, 4, (Object) null);
        a.a.l(aVar, "AppStartup", "   └─ 真实启动时间 (TTFD): " + (j2 - h2) + "ms", false, 4, (Object) null);
        n();
        com.transsion.startup.pref.consume.b i2 = i();
        h.a.q("app_startup_stat_ab_new", "app_perf", MapsKt.l(TuplesKt.a("splash_ttid", String.valueOf(i2.e())), TuplesKt.a("ad_wait_duration", String.valueOf(i2.a())), TuplesKt.a("main_activity_ttid", String.valueOf(i2.c())), TuplesKt.a("total_ttfd", String.valueOf(i2.f())), TuplesKt.a("real_ttfd", String.valueOf(i2.d())), TuplesKt.a("has_ad", String.valueOf(i2.b()))));
        k = true;
        h = false;
    }

    public final void q() {
        if (h && l) {
            e = SystemClock.elapsedRealtime();
            l = false;
            long h2 = h();
            a.a.l(wf.a.a, "AppStartup", "▶️ [Phase 2] Resumed after Ad, Wait Duration: " + h2 + "ms (广告等待时间，已从统计中排除)", false, 4, (Object) null);
        }
    }

    public final void r() {
        if (h) {
            if (l) {
                a.a.l(wf.a.a, "AppStartup", "⏭️ [Phase 2] Ad Skipped - No ad shown, resuming timer", false, 4, (Object) null);
            }
            l = false;
            m = false;
            d = 0L;
            e = 0L;
        }
    }
}
