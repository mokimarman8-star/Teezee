package com.transsion.mbwidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.m;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.GslbSdk;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mbwidget.data.SportWidgetPeriodicWorker;
import com.transsion.mbwidget.data.WidgetRefreshWorker;
import com.transsnet.downloader.manager.p;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends ui.a {
    public static final d a;
    private static final Lazy b;
    private static com.transsion.mbwidget.guide.a c;
    private static final long d;

    static {
        d dVar = new d();
        a = dVar;
        b = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.c
            public final Object invoke() {
                MMKV p;
                p = d.p();
                return p;
            }
        });
        d = 604800000L;
        p.a.a(Utils.a()).g(dVar);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        m b2 = new m.a(WidgetRefreshWorker.class, 30L, timeUnit).a("desk_widget").b();
        try {
            Result.Companion companion = Result.Companion;
            Context a2 = Build.VERSION.SDK_INT >= 24 ? androidx.profileinstaller.b.a(GslbSdk.context) : GslbSdk.context;
            WorkManager f = WorkManager.f(a2);
            ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.KEEP;
            f.e("unique_desk_widget", existingPeriodicWorkPolicy, b2);
            Result.constructor-impl(WorkManager.f(a2).e("unique_sport_widget_periodic", existingPeriodicWorkPolicy, new m.a(SportWidgetPeriodicWorker.class, 60L, timeUnit).a("sport_widget_periodic").b()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private d() {
    }

    private final boolean l() {
        String value;
        Boolean m1;
        ConfigBean c2 = cm.f.c.a().c("widget_guide_enable", true);
        if (c2 == null || (value = c2.getValue()) == null || (m1 = StringsKt.m1(value)) == null) {
            return true;
        }
        return m1.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV p() {
        MMKV I = MMKV.I("desk_widget");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public static /* synthetic */ boolean s(d dVar, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return dVar.r(function0);
    }

    @Override // ui.a, ui.m0
    public void e(DownloadBean downloadBean, String str) {
        Intrinsics.h(downloadBean, "bean");
        Activity b2 = com.blankj.utilcode.util.a.b();
        if (Intrinsics.c(b2 != null ? b2.getLocalClassName() : null, "com.transsion.subroom.activity.MainActivity")) {
            s(this, null, 1, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 9, instructions: 23 */
    public final boolean i(Function0 function0) {
        return false;
    }

    public final com.transsion.mbwidget.guide.a j() {
        return c;
    }

    public final MMKV k() {
        return (MMKV) b.getValue();
    }

    public final boolean m() {
        int[] appWidgetIds = AppWidgetManager.getInstance(GslbSdk.context).getAppWidgetIds(new ComponentName(GslbSdk.context, (Class<?>) HotSubjectWidgetProvider.class));
        if (appWidgetIds != null) {
            return !(appWidgetIds.length == 0);
        }
        return false;
    }

    public final boolean n() {
        String str = Build.MANUFACTURER;
        Intrinsics.g(str, "MANUFACTURER");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return StringsKt.H(lowerCase, "xiaomi", true);
    }

    public final boolean o() {
        boolean isRequestPinAppWidgetSupported;
        Object systemService = Utils.a().getSystemService("appwidget");
        AppWidgetManager appWidgetManager = systemService instanceof AppWidgetManager ? (AppWidgetManager) systemService : null;
        if (appWidgetManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        isRequestPinAppWidgetSupported = appWidgetManager.isRequestPinAppWidgetSupported();
        return isRequestPinAppWidgetSupported;
    }

    public final void q(com.transsion.mbwidget.guide.a aVar) {
        c = aVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x0002
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:279)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    public final boolean r(kotlin.jvm.functions.Function0 r13) {
        /*
            r12 = this;
            r0 = 0
            return r0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L7e
            com.tencent.mmkv.MMKV r1 = r12.k()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "desk_widget_guide_show_time"
            r3 = 0
            long r1 = r1.getLong(r2, r3)     // Catch: java.lang.Throwable -> L7e
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7e
            long r3 = r3 - r1
            boolean r1 = r12.m()     // Catch: java.lang.Throwable -> L7e
            boolean r2 = r12.o()     // Catch: java.lang.Throwable -> L7e
            boolean r5 = r12.l()     // Catch: java.lang.Throwable -> L7e
            long r6 = com.transsion.mbwidget.d.d     // Catch: java.lang.Throwable -> L7e
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            r9 = 1
            if (r8 <= 0) goto L2a
            r8 = r9
            goto L2b
        L2a:
            r8 = r0
        L2b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r10.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r11 = "showAddDialog sup:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L7e
            r10.append(r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r11 = "， show:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L7e
            r10.append(r1)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r11 = ", over:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L7e
            r10.append(r8)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r8 = "，guideEnable:"
            r10.append(r8)     // Catch: java.lang.Throwable -> L7e
            r10.append(r5)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r8 = " "
            r10.append(r8)     // Catch: java.lang.Throwable -> L7e
            if (r5 == 0) goto L80
            if (r2 == 0) goto L80
            if (r1 != 0) goto L80
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 <= 0) goto L80
            android.app.Activity r1 = com.blankj.utilcode.util.a.b()     // Catch: java.lang.Throwable -> L7e
            boolean r2 = r1.isFinishing()     // Catch: java.lang.Throwable -> L7e
            if (r2 != 0) goto L80
            boolean r2 = r1.isDestroyed()     // Catch: java.lang.Throwable -> L7e
            if (r2 != 0) goto L80
            com.transsion.mbwidget.guide.AddWidgetDialog r2 = new com.transsion.mbwidget.guide.AddWidgetDialog     // Catch: java.lang.Throwable -> L7e
            r2.<init>()     // Catch: java.lang.Throwable -> L7e
            r2.t0(r13)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r13 = "AddWidgetDialog"
            r2.g0(r1, r13)     // Catch: java.lang.Throwable -> L7e
            r0 = r9
            goto L80
        L7e:
            r13 = move-exception
            goto L86
        L80:
            kotlin.Unit r13 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L7e
            kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L7e
            goto L8f
        L86:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.a(r13)
            kotlin.Result.constructor-impl(r13)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.d.r(kotlin.jvm.functions.Function0):boolean");
    }
}
