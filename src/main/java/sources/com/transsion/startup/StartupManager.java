package com.transsion.startup;

import ag.a;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import bt.a;
import com.blankj.utilcode.util.f;
import com.blankj.utilcode.util.n;
import com.bumptech.glide.Glide;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import com.therouter.TheRouter;
import com.therouter.router.NavigatorKt;
import com.tn.lib.logger.xlog.LogType;
import com.tn.lib.net.cons.PrefetchDnsUrls;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.config.WorkMode;
import com.transsion.baselib.config.CrashHandler;
import com.transsion.baselib.locale.LocaleChangedHelper;
import com.transsion.baselib.report.AppPeriodReport;
import com.transsion.baselib.report.e;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.push.tpush.PushRegisterManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.version.update.UpdateManager;
import com.transsnet.loginapi.bean.UserInfo;
import com.wecloud.load.lib.DySoLoadManager;
import fh.b;
import ij.o;
import ij.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jg.b;
import kj.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import mg.b;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONArray;
import qi.h;
import qx.b;
import sg.c;
import t6.j;
import wf.a;
import xf.c;
import yg.l;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class StartupManager implements qx.b, m {
    public static final a g = new a((DefaultConstructorMarker) null);
    private static final Lazy h = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.startup.b
        public final Object invoke() {
            StartupManager e;
            e = StartupManager.e();
            return e;
        }
    });
    private boolean a;
    private Application c;
    private final List b = new ArrayList();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.startup.c
        public final Object invoke() {
            a e0;
            e0 = StartupManager.e0();
            return e0;
        }
    });
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.startup.d
        public final Object invoke() {
            a E;
            E = StartupManager.E();
            return E;
        }
    });
    private final n0 f = o0.a(y0.b().plus(l2.b((t1) null, 1, (Object) null)));

    private final void B() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("current_env", "release");
        boolean z = !Intrinsics.c(string, "release");
        StringBuilder sb = new StringBuilder();
        sb.append("env=");
        sb.append(string);
        sb.append("  ");
        sb.append(z);
        if (!Intrinsics.c(string, "release")) {
            Application application = this.c;
            if (application == null) {
                Intrinsics.y("app");
                application = null;
            }
            C(application);
        }
        bVar.b().putString("current_env", "release");
    }

    private final void C(Context context) {
        f.a();
        f.b();
        f.c();
        f.d();
        n.c(context != null ? context.getFilesDir() : null);
        Log.e("StartupManager", "clear");
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final void D() {
        Application application;
        Y();
        R();
        b0();
        S();
        N();
        AppPeriodReport appPeriodReport = AppPeriodReport.a;
        appPeriodReport.b();
        k.a.a();
        com.transsion.baselib.locale.d.f.e();
        LocaleChangedHelper localeChangedHelper = LocaleChangedHelper.a;
        Application application2 = this.c;
        if (application2 == null) {
            Intrinsics.y("app");
            application2 = null;
        }
        localeChangedHelper.b(application2);
        Application application3 = this.c;
        if (application3 == null) {
            Intrinsics.y("app");
            application3 = null;
        }
        yj.a.b(application3);
        Application application4 = this.c;
        if (application4 == null) {
            Intrinsics.y("app");
            application4 = null;
        }
        com.google.firebase.f.q(application4);
        i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new StartupManager$coldBootStage$1(this, null), 3, (Object) null);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new StartupManager$coldBootStage$2(this, null), 3, (Object) null);
        B();
        appPeriodReport.b();
        J();
        l.a.l(this);
        FileDownloadTaskManager fileDownloadTaskManager = FileDownloadTaskManager.a;
        Application application5 = this.c;
        if (application5 == null) {
            Intrinsics.y("app");
            application = null;
        } else {
            application = application5;
        }
        fileDownloadTaskManager.j(application, false, false, false, new com.transsion.baselib.report.i(), "wefeed-mobile-bff");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a E() {
        return (a) kg.c.e.a().h(a.class);
    }

    private final String F(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            sb.append((String) obj);
            sb.append(i == list.size() + (-1) ? "" : ",");
            i = i2;
        }
        return sb.toString();
    }

    private final a G() {
        return (a) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a H() {
        return (a) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        String string;
        MMKV c = mg.a.a.c();
        String str = "";
        if (c != null && (string = c.getString("sp_code", "")) != null) {
            str = string;
        }
        if (TextUtils.isEmpty(str)) {
            str = tg.b.a.o();
        }
        String str2 = str;
        try {
            Result.Companion companion = Result.Companion;
            Application application = this.c;
            if (application == null) {
                Intrinsics.y("app");
                application = null;
            }
            Z(application, false, new com.transsion.baselib.report.i(), str2, false);
            Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
    }

    private final void J() {
        com.transsion.baselib.report.k.a.g(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        e eVar = e.a;
        eVar.q();
        eVar.p(true);
        L();
    }

    private final void L() {
        com.transsion.baselib.config.e.c.a().e(new e(this));
        CrashHandler a = CrashHandler.c.a();
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        a.f(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(StartupManager startupManager, boolean z, com.google.firebase.remoteconfig.a aVar) {
        Intrinsics.h(aVar, "remoteConfig");
        if (z) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new StartupManager$initFirebaseConfig$1$1(startupManager, aVar, null), 3, (Object) null);
        }
        return Unit.a;
    }

    private final void N() {
        com.transsnet.flow.event.b bVar = com.transsnet.flow.event.b.a;
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        bVar.c(application);
    }

    private final void O() {
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        GateWaySdk.init(application, "4U01pxRu278GqCZKY9", WorkMode.MODE_ONLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        Glide.with(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(boolean z) {
        a H = H();
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        H.a(application, z);
    }

    private final void R() {
        c.a aVar = xf.c.a;
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        c.a.g(aVar, application, LogType.TYPE_XLOG, false, (String) null, 0L, 24, (Object) null);
    }

    private final void S() {
        dj.a aVar = dj.a.a;
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        aVar.a(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        try {
            a.a.f(wf.a.a, "ShortTv", "initShortTv", false, 4, (Object) null);
            io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
            if (bVar != null) {
                Application application = this.c;
                if (application == null) {
                    Intrinsics.y("app");
                    application = null;
                }
                bVar.j(application);
            }
        } catch (Throwable th) {
            a.a.l(wf.a.a, "ShortTv", "initShortTv fail-- " + th, false, 4, (Object) null);
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        ag.b bVar = new ag.b();
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        PackageManager packageManager = application.getPackageManager();
        Application application2 = this.c;
        if (application2 == null) {
            Intrinsics.y("app");
            application2 = null;
        }
        int i = 0;
        PackageInfo packageInfo = packageManager.getPackageInfo(application2.getPackageName(), 0);
        Intrinsics.g(packageInfo, "getPackageInfo(...)");
        bVar.g(packageInfo.firstInstallTime);
        bVar.e(false);
        bVar.f(false);
        String str = packageInfo.versionName;
        if (str == null) {
            str = "";
        }
        bVar.h(str);
        a.a aVar = ag.a.a;
        Application application3 = this.c;
        if (application3 == null) {
            Intrinsics.y("app");
            application3 = null;
        }
        aVar.f(application3, bVar);
        aVar.h(false);
        O();
        String value = (t.a.b() ? PlayMode.STREAM : PlayMode.DOWNLOAD).getValue();
        b.a aVar2 = jg.b.a;
        aVar2.b("X-Play-Mode", value);
        o oVar = o.a;
        if (oVar.j()) {
            com.transsion.baselib.report.launch.b.a.b().putBoolean("k_is_family_mode", false);
        } else {
            i = 1;
            aVar2.b("X-Family-Mode", com.transsion.baselib.report.launch.b.a.b().getBoolean("k_is_family_mode", true) ? "1" : "0");
        }
        oVar.n();
        com.transsion.baselib.report.launch.b bVar2 = com.transsion.baselib.report.launch.b.a;
        aVar2.b("X-Idle-Data", bVar2.b().getBoolean("k_setting_privacy_idle", true) ? "1" : "0");
        n0(kg.c.e.a().g());
        bm.e eVar = bm.e.a;
        eVar.r(new d(this));
        bm.e.p(eVar, null, null, 3, null);
        bVar2.b().putLong("app_config_fetch_time", System.currentTimeMillis());
        qx.a aVar3 = (qx.a) TheRouter.d(qx.a.class, new Object[i]);
        if (aVar3 != null) {
            aVar3.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        sn.e.a.g(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        PushRegisterManager pushRegisterManager = PushRegisterManager.a;
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        pushRegisterManager.C(application);
    }

    private final void Y() {
        TheRouter.p(false);
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        TheRouter.j(application, true);
        NavigatorKt.l(new f());
        NavigatorKt.h(new g());
    }

    private final void Z(Application application, boolean z, qi.i iVar, String str, boolean z2) {
        h.a.j(application, z, iVar, "Oneroom", 2570, true, str, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        UpdateManager.f.a().e("5603aeef91bb9cca8a85955d1c7170e6");
    }

    private final void b0() {
        b.a aVar = fh.b.a;
        Application application = this.c;
        Application application2 = null;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        aVar.c(application);
        c.a aVar2 = sg.c.a;
        Application application3 = this.c;
        if (application3 == null) {
            Intrinsics.y("app");
        } else {
            application2 = application3;
        }
        aVar2.a(application2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartupManager e() {
        return new StartupManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bt.a e0() {
        return new bt.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        com.transsion.baselib.report.launch.b.a.b().getString("current_env", "release");
        MMKV m = tg.b.a.m();
        if (m != null) {
            m.getString("apkgaid", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        j.b(new BaseLoadMoreView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        qx.a aVar = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        if (aVar != null) {
            Application application = this.c;
            if (application == null) {
                Intrinsics.y("app");
                application = null;
            }
            aVar.l(application);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        List R0;
        synchronized (this.b) {
            R0 = CollectionsKt.R0(this.b);
            this.b.clear();
        }
        Iterator it = R0.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(com.google.firebase.remoteconfig.a aVar) {
        com.transsion.startup.pref.anr.c cVar = com.transsion.startup.pref.anr.c.a;
        cVar.a("firebase --> the remote configuration is obtained");
        cm.f.c.a().i(aVar);
        com.transsion.startup.pref.anr.a.a.a(aVar.n("watch_dog_timeout"));
        String p = aVar.p("endpoints");
        Intrinsics.g(p, "getString(...)");
        CacheIpPool.a.n(p);
        cVar.a("firebase --> endpoints " + p);
        String p2 = aVar.p("k_dy_so_control_config");
        Intrinsics.g(p2, "getString(...)");
        Log.w("StartupManager", "remoteConfig " + aVar.n("key_total_show_times") + " k_dy_so_control_config=" + p2);
        a.a aVar2 = wf.a.a;
        a.a.f(aVar2, "download_notify", "isOpenDownloadForegroundService = " + aVar + ".getBoolean(RoomAppMMKV.DOWNLOAD_FOREGROUND_SERVICE)", false, 4, (Object) null);
        DySoLoadManager dySoLoadManager = DySoLoadManager.a;
        Application application = this.c;
        if (application == null) {
            Intrinsics.y("app");
            application = null;
        }
        dySoLoadManager.i(application, p2);
        String p3 = aVar.p("prefetch_dns_hosts");
        Intrinsics.g(p3, "getString(...)");
        if (p3.length() <= 0) {
            try {
                a.a.f(aVar2, "prefetchDns", "has no config~ prefetch def dns", false, 4, (Object) null);
                Dns dns = Dns.SYSTEM;
                dns.lookup("vgorigin.hakunaymatata.com");
                dns.lookup("vacdn.hakunaymatata.com");
                return;
            } catch (Throwable th) {
                a.a.f(wf.a.a, "prefetchDns", "prefetch error = " + th, false, 4, (Object) null);
                Unit unit = Unit.a;
                return;
            }
        }
        try {
            PrefetchDnsUrls prefetchDnsUrls = (PrefetchDnsUrls) com.blankj.utilcode.util.o.d(p3, PrefetchDnsUrls.class);
            a.a.f(aVar2, "prefetchDns", "prefetch dns config = " + p3 + ", data = " + prefetchDnsUrls, false, 4, (Object) null);
            for (String str : prefetchDnsUrls.getHosts()) {
                try {
                    a.a.f(wf.a.a, "prefetchDns", "prefetch dns hots = " + str, false, 4, (Object) null);
                    Dns.SYSTEM.lookup(str);
                } catch (Throwable th2) {
                    a.a.f(wf.a.a, "prefetchDns", "1 prefetch error = " + th2, false, 4, (Object) null);
                }
            }
        } catch (Throwable th3) {
            a.a.f(wf.a.a, "prefetchDns", "prefetch error = " + th3, false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        i.d(this.f, (CoroutineContext) null, (CoroutineStart) null, new scheduleDelayTask.1(this, (Continuation) null), 3, (Object) null);
    }

    private final void n0(OkHttpClient okHttpClient) {
        GateWaySdk.setOkHttpClient(okHttpClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|8|(1:(1:11)(2:17|18))(2:19|(2:21|22)(3:23|24|(1:26)))|12|13|14))|29|6|7|8|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002b, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        wf.a.a.l(wf.a.a, "StartupManager", "probeAllFromStProbeAndReport error: " + r12, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsion.startup.StartupManager.startupNetworkProbe.1
            if (r0 == 0) goto L14
            r0 = r12
            com.transsion.startup.StartupManager$startupNetworkProbe$1 r0 = (com.transsion.startup.StartupManager.startupNetworkProbe.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.startup.StartupManager$startupNetworkProbe$1 r0 = new com.transsion.startup.StartupManager$startupNetworkProbe$1
            r0.<init>(r11, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L2b
            goto L6c
        L2b:
            r12 = move-exception
            goto L79
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L35:
            kotlin.ResultKt.b(r12)
            yg.l r12 = yg.l.a
            boolean r12 = r12.e()
            if (r12 != 0) goto L4f
            wf.a$a r5 = wf.a.a
            r9 = 4
            r10 = 0
            java.lang.String r6 = "StartupManager"
            java.lang.String r7 = "network not connected, skip startupNetworkProbe!"
            r8 = 0
            wf.a.a.l(r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        L4f:
            com.wecloud.load.lib.StProbeIntegration r1 = com.wecloud.load.lib.StProbeIntegration.a
            r12 = 0
            r1.l(r12)
            com.wecloud.load.lib.j r12 = com.wecloud.load.lib.j.a
            com.transsion.startup.StartupManager$h r3 = new com.transsion.startup.StartupManager$h
            r3.<init>()
            r12.b(r3)
            r4.label = r2     // Catch: java.lang.Throwable -> L2b
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r12 = com.wecloud.load.lib.StProbeIntegration.k(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2b
            if (r12 != r0) goto L6c
            return r0
        L6c:
            wf.a$a r1 = wf.a.a     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "StartupManager"
            java.lang.String r3 = "probeAllFromStProbeAndReport completed"
            r5 = 4
            r6 = 0
            r4 = 0
            wf.a.a.f(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2b
            goto L94
        L79:
            wf.a$a r0 = wf.a.a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "probeAllFromStProbeAndReport error: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = r1.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "StartupManager"
            r3 = 0
            wf.a.a.l(r0, r1, r2, r3, r4, r5)
        L94:
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.startup.StartupManager.o0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void A(Context context) {
        AppStartReport.a.e(new AppStartDotState(AppStartDotState.APP_START, 0L, 2, null));
        if (context != null) {
            File filesDir = context.getFilesDir();
            MMKV.E(context, (filesDir != null ? filesDir.getAbsolutePath() : null) + "/mmkv", null, MMKVLogLevel.LevelInfo, new b());
        }
        f.c(context);
    }

    public final void V(Application application) {
        Intrinsics.h(application, "application");
        this.c = application;
        Q(false);
        S();
    }

    public final void c0(Application application) {
        Intrinsics.h(application, "application");
        this.c = application;
        D();
    }

    public final boolean d0() {
        return this.a;
    }

    public final void j0(int i, boolean z) {
        a.a.f(wf.a.a, "StartupManager", "onTrimMemory " + i, false, 4, (Object) null);
        if (i == 5 || i == 40) {
            H().c();
        }
    }

    public final void k0(Function0 function0) {
        Intrinsics.h(function0, "callback");
        synchronized (this.b) {
            this.b.remove(function0);
        }
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        kk.a aVar = (kk.a) TheRouter.d(kk.a.class, new Object[0]);
        if (aVar != null) {
            aVar.c(false);
        }
        if (aVar != null) {
            aVar.i(false);
        }
        bm.e.a.m();
    }

    public void onDisconnected() {
        bm.e.a.n();
    }

    public void onLogin(UserInfo userInfo) {
        Intrinsics.h(userInfo, "user");
        b.a.a(this, userInfo);
        bm.e.p(bm.e.a, null, null, 3, null);
    }

    public void onLogout() {
        b.a.b(this);
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }

    public final void p0(List list, Function1 function1) {
        Intrinsics.h(list, "ids");
        Intrinsics.h(function1, "callback");
        String F = F(list);
        if (F != null) {
            com.transsion.baselib.helper.l.b.a().d(F);
        }
        a.a.f(wf.a.a, "UserPrefer-tag", "userPrefer = " + F, false, 4, (Object) null);
        StringBuilder sb = new StringBuilder("{\"ids\":");
        sb.append(new JSONArray((Collection) list));
        sb.append("}");
        b.a aVar = mg.b.a;
        Intrinsics.e(sb);
        RequestBody a = aVar.a(sb);
        if (a != null) {
            G().a(gg.a.a.a(), a).f(dg.d.a.c()).subscribe(new i(function1));
        }
    }

    public final void z(Function0 function0) {
        Intrinsics.h(function0, "callback");
        if (this.a) {
            function0.invoke();
            return;
        }
        synchronized (this.b) {
            this.b.add(function0);
        }
    }
}
