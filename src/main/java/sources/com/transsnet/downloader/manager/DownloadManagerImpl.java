package com.transsnet.downloader.manager;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsnet.downloader.callback.DownloadTaskStat;
import com.transsnet.downloader.core.DownloadResponseImpl;
import com.transsnet.downloader.core.DownloadTaskImpl;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ui.m0;
import ui.s0;
import wf.a;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadManagerImpl implements g, com.transsnet.downloader.core.task.c {
    public static final a y = new a((DefaultConstructorMarker) null);
    private static final Lazy z = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.manager.h
        public final Object invoke() {
            DownloadManagerImpl p0;
            p0 = DownloadManagerImpl.p0();
            return p0;
        }
    });
    private com.transsnet.downloader.core.c d;
    private ax.b e;
    private long f;
    private m g;
    private zw.b j;
    private final com.transsnet.downloader.proxy.b t;
    private String a = "DownloadImp";
    private ConcurrentHashMap b = new ConcurrentHashMap();
    private List c = new CopyOnWriteArrayList();
    private ConcurrentHashMap h = new ConcurrentHashMap();
    private ConcurrentHashMap i = new ConcurrentHashMap();
    private final Set k = new CopyOnWriteArraySet();
    private final Set l = new CopyOnWriteArraySet();
    private final Set m = new CopyOnWriteArraySet();
    private final Set n = new CopyOnWriteArraySet();
    private final Lazy o = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.i
        public final Object invoke() {
            si.a i0;
            i0 = DownloadManagerImpl.i0();
            return i0;
        }
    });
    private DownloadTaskStat p = new DownloadTaskStat(0, 0, 0, 0);
    private Set q = new CopyOnWriteArraySet();
    private Set r = new CopyOnWriteArraySet();
    private final Lazy s = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.j
        public final Object invoke() {
            cx.a Q0;
            Q0 = DownloadManagerImpl.Q0();
            return Q0;
        }
    });
    private final n0 u = o0.a(y0.c());
    private final n0 v = o0.a(y0.b());
    private final Lazy w = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.k
        public final Object invoke() {
            ui.n0 G0;
            G0 = DownloadManagerImpl.G0();
            return G0;
        }
    });
    private final Lazy x = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.l
        public final Object invoke() {
            io.b A0;
            A0 = DownloadManagerImpl.A0();
            return A0;
        }
    });

    public DownloadManagerImpl(ax.b bVar) {
        if (bVar == null) {
            this.e = new ax.b();
        } else {
            this.e = bVar;
        }
        com.transsnet.downloader.proxy.b bVar2 = new com.transsnet.downloader.proxy.b();
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        bVar2.g(a);
        m0 e = bVar2.e();
        if (e != null) {
            g(e);
        }
        this.t = bVar2;
        DownloadEsHelper.m.a();
        this.d = new DownloadResponseImpl(this, this.q, this.e);
        DownloadNotificationUtils.a.E();
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new 3(this, (Continuation) null), 3, (Object) null);
        H0();
        DownloadListManager.I(DownloadListManager.m.a(), false, false, null, 7, null);
        g(new FinishDownloadHelper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.b A0() {
        return (io.b) TheRouter.d(io.b.class, new Object[0]);
    }

    private final boolean B0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.c cVar;
        if (z(downloadBean) || downloadBean.isDownloading()) {
            wf.a.a.p(this.a, new String[]{"preDownload, isDownloading name = " + downloadBean.getName() + " "}, true);
            return false;
        }
        if (yg.l.a.e() && downloadBean.isVideo()) {
            Long size = downloadBean.getSize();
            if ((size != null ? size.longValue() : 0L) >= 52428800) {
                if (downloadBean.getProgress() >= 5242880) {
                    wf.a.a.p("download", new String[]{"preDownload, is downloaded do nothing, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                if (this.h.size() > 0) {
                    ConcurrentHashMap concurrentHashMap = this.i;
                    String resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    concurrentHashMap.put(resourceId, downloadBean);
                    wf.a.a.p("download", new String[]{"preDownload, 当前已有任务在预下载，加入等待队列, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                z0(downloadBean);
                downloadBean.setPreDownload(true);
                ConcurrentHashMap concurrentHashMap2 = this.i;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                ax.b bVar = this.e;
                com.transsnet.downloader.core.task.b bVar2 = null;
                if (bVar != null && (cVar = this.d) != null) {
                    bVar2 = k0(bVar, cVar, downloadBean);
                }
                wf.a.a.p("download", new String[]{"start preDownload, name = " + downloadBean.getTotalTitleName()}, true);
                if (bVar2 != null) {
                    ConcurrentHashMap concurrentHashMap3 = this.h;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, bVar2);
                }
                downloadBean.setStatus(1);
                com.transsnet.downloader.core.c cVar2 = this.d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                if (bVar2 != null) {
                    bVar2.start();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        if (yg.l.a.e()) {
            a.a.f(wf.a.a, this.a, "preDownloadNextTask, pool size = " + this.i.size(), false, 4, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.i.entrySet()) {
                String str = (String) entry.getKey();
                DownloadBean downloadBean = (DownloadBean) entry.getValue();
                if (downloadBean.getProgress() < 5242880) {
                    if (downloadBean.getStatus() == 6) {
                        if (downloadBean.getErrorCount() < 3) {
                            downloadBean.setErrorCount(downloadBean.getErrorCount() + 1);
                        }
                    }
                    wf.a.a.p("download", new String[]{"preDownloadNextTask, try start, name = " + downloadBean.getTotalTitleName()}, true);
                    B0(downloadBean);
                    break;
                }
                a.a.f(wf.a.a, this.a, "preDownloadNextTask, is downloaded do nothing, name = " + downloadBean.getName(), false, 4, (Object) null);
                arrayList.add(str);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.i.remove((String) it.next());
            }
        }
    }

    private final void D0(DownloadBean downloadBean) {
        if (ThreadUtils.i()) {
            E0(downloadBean);
        } else {
            kotlinx.coroutines.i.d(this.u, (CoroutineContext) null, (CoroutineStart) null, new prepareDownload.1(this, downloadBean, (Continuation) null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.c cVar;
        a.a aVar = wf.a.a;
        aVar.c("download", n0() + " --> prepareDownloadNext() --> 2- prepareDownload,name = " + downloadBean.getTotalTitleName() + ",resourceId = " + downloadBean.getResourceId() + "，subjectId = " + downloadBean.getSubjectId() + ", status = " + downloadBean.getStatus(), true);
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            a.a.f(aVar, "download", n0() + " --> prepareDownloadNext() --> prepareDownload, status-- name = " + downloadBean.getName() + " ", false, 4, (Object) null);
            if (downloadBean.isPreDownload()) {
                downloadBean.setPreDownload(false);
                a.a.f(aVar, "download", n0() + " --> prepareDownloadNext() --> preDownload 预下载转正变成当前下载 = " + downloadBean.getName() + " , epse = " + downloadBean.getEpse(), false, 4, (Object) null);
                ConcurrentHashMap concurrentHashMap = this.h;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) concurrentHashMap.get(resourceId);
                Set set = this.k;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set.remove(resourceId2);
                Set set2 = this.m;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set2.remove(resourceId3);
                Set set3 = this.l;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                set3.add(resourceId4);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.c cVar2 = this.d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                S0();
                if (bVar != null) {
                    R0();
                    ConcurrentHashMap concurrentHashMap2 = this.b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, bVar);
                    ConcurrentHashMap concurrentHashMap3 = this.h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                }
            }
            if (yg.l.a.e()) {
                return;
            }
            aVar.p("download", new String[]{n0() + " --> prepareDownloadNext() --> not net， 2 error"}, true);
            downloadBean.setStatus(6);
            downloadBean.setException(new DownloadException(9, "noNetWork"));
            u(downloadBean);
            return;
        }
        downloadBean.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap4 = this.b;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        if (concurrentHashMap4.containsKey(resourceId7)) {
            if (downloadBean.isDownloading()) {
                aVar.p("download", new String[]{n0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading name = " + downloadBean.getName()}, true);
                return;
            }
            ConcurrentHashMap concurrentHashMap5 = this.b;
            String resourceId8 = downloadBean.getResourceId();
            if (resourceId8 == null) {
                resourceId8 = downloadBean.getUrl();
            }
            concurrentHashMap5.remove(resourceId8);
            a.a.f(aVar, "download", n0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading, error status , remove  name = " + downloadBean.getName(), false, 4, (Object) null);
        }
        if (u0()) {
            if (!B0(downloadBean)) {
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.c cVar3 = this.d;
                if (cVar3 != null) {
                    cVar3.a(downloadBean);
                }
            }
            Set set4 = this.k;
            String resourceId9 = downloadBean.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean.getUrl();
            }
            set4.add(resourceId9);
            aVar.c("download", n0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add wait, status = " + downloadBean.getStatus() + ",loading  = " + this.l.size() + ", error  = " + this.m.size() + " , wait  = " + this.k.size() + " ", true);
            S0();
            return;
        }
        ConcurrentHashMap concurrentHashMap6 = this.i;
        String resourceId10 = downloadBean.getResourceId();
        if (resourceId10 == null) {
            resourceId10 = downloadBean.getUrl();
        }
        concurrentHashMap6.remove(resourceId10);
        ConcurrentHashMap concurrentHashMap7 = this.h;
        String resourceId11 = downloadBean.getResourceId();
        if (resourceId11 == null) {
            resourceId11 = downloadBean.getUrl();
        }
        concurrentHashMap7.remove(resourceId11);
        if (this.h.isEmpty() && !this.i.isEmpty()) {
            C0();
        }
        ax.b bVar2 = this.e;
        com.transsnet.downloader.core.task.b bVar3 = null;
        if (bVar2 != null && (cVar = this.d) != null) {
            bVar3 = k0(bVar2, cVar, downloadBean);
        }
        com.transsnet.downloader.core.task.b bVar4 = bVar3;
        if (bVar4 != null) {
            ConcurrentHashMap concurrentHashMap8 = this.b;
            String resourceId12 = downloadBean.getResourceId();
            if (resourceId12 == null) {
                resourceId12 = downloadBean.getUrl();
            }
            concurrentHashMap8.put(resourceId12, bVar4);
        }
        downloadBean.setStatus(1);
        com.transsnet.downloader.core.c cVar4 = this.d;
        if (cVar4 != null) {
            cVar4.a(downloadBean);
        }
        j0(downloadBean);
        Set set5 = this.k;
        String resourceId13 = downloadBean.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = downloadBean.getUrl();
        }
        set5.remove(resourceId13);
        Set set6 = this.m;
        String resourceId14 = downloadBean.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = downloadBean.getUrl();
        }
        set6.remove(resourceId14);
        Set set7 = this.l;
        String resourceId15 = downloadBean.getResourceId();
        if (resourceId15 == null) {
            resourceId15 = downloadBean.getUrl();
        }
        set7.add(resourceId15);
        a.a.v(aVar, "download", n0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add loading, loading  = " + this.l.size() + ", error  = " + this.m.size() + " , wait  = " + this.k.size() + " ", false, 4, (Object) null);
        S0();
        if (bVar4 != null) {
            bVar4.start();
        }
    }

    private final void F0() {
        for (DownloadBean downloadBean : this.c) {
            if (downloadBean.getStatus() == 3 || downloadBean.getStatus() == 6 || (downloadBean.isDownloading() && downloadBean.isPreDownload())) {
                if (downloadBean.getStatus() == 6) {
                    if (!yg.l.a.e() || downloadBean.isNoNetError()) {
                        a.a.f(wf.a.a, this.a, "prepareDownloadNextTask, no net，continue, name = " + downloadBean.getName(), false, 4, (Object) null);
                    } else if (downloadBean.getErrorCount() >= 3) {
                        wf.a.a.c("download", "prepareDownloadNextTask, 失败超限~不再执行，name = " + downloadBean.getName(), true);
                    } else {
                        downloadBean.setErrorCount(downloadBean.getErrorCount() + 1);
                    }
                }
                wf.a.a.c("download", "prepareDownloadNextTask, name = " + downloadBean.getName() + ", from next, status: " + downloadBean.getStatus() + ",isPreDownload:" + downloadBean.isPreDownload() + ", progress: " + downloadBean.getProgress() + ",size:" + downloadBean.getSize(), true);
                Set set = this.k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                D0(downloadBean);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ui.n0 G0() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return f1Var.b(a).p1();
    }

    private final void H0() {
        m mVar = new m() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$registerNetwork$1
            private final void a() {
                String str;
                com.transsnet.downloader.proxy.b bVar;
                List<DownloadBean> list;
                String str2;
                String str3;
                a.a aVar = wf.a.a;
                str = DownloadManagerImpl.this.a;
                a.a.f(aVar, str, "---------Download, Network onConnected", false, 4, (Object) null);
                bVar = DownloadManagerImpl.this.t;
                DownloadBean d = bVar.d();
                if (d != null) {
                    DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                    if (!d.isRemoved()) {
                        str3 = downloadManagerImpl.a;
                        a.a.f(aVar, str3, "onConnected, start DownloadingPlay, name = " + d.getName() + ",epse = " + d.getEpse() + ",  cur status = " + d.getStatus(), false, 4, (Object) null);
                        downloadManagerImpl.s(d, true);
                    }
                }
                list = DownloadManagerImpl.this.c;
                DownloadManagerImpl downloadManagerImpl2 = DownloadManagerImpl.this;
                for (DownloadBean downloadBean : list) {
                    if (downloadBean.getStatus() == 6 || downloadBean.getStatus() == 3 || downloadBean.isDownloading()) {
                        a.a aVar2 = wf.a.a;
                        str2 = downloadManagerImpl2.a;
                        aVar2.c(str2, "onConnected, caches, name = " + downloadBean.getName() + ",epse = " + downloadBean.getEpse() + ",  cur status = " + downloadBean.getStatus(), true);
                        if (downloadBean.isDownloading()) {
                            downloadBean.setPreDownload(false);
                            downloadBean.setStatus(3);
                        }
                        downloadManagerImpl2.s(downloadBean, true);
                    }
                }
                kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new netConnected.3(DownloadManagerImpl.this, (Continuation) null), 3, (Object) null);
            }

            public void onConnected() {
                a();
            }

            public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.h(network, "network");
                Intrinsics.h(networkCapabilities, "networkCapabilities");
                a();
            }

            public void onDisconnected() {
                String str;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                a.a aVar = wf.a.a;
                str = DownloadManagerImpl.this.a;
                a.a.f(aVar, str, "---------Download, Network onDisconnected, cancel all request---------", false, 4, (Object) null);
                try {
                    com.transsnet.downloader.core.b.c.a().c().dispatcher().cancelAll();
                } catch (Throwable unused) {
                }
                concurrentHashMap = DownloadManagerImpl.this.b;
                concurrentHashMap.clear();
                concurrentHashMap2 = DownloadManagerImpl.this.i;
                concurrentHashMap2.clear();
                concurrentHashMap3 = DownloadManagerImpl.this.h;
                concurrentHashMap3.clear();
            }
        };
        this.g = mVar;
        yg.l.a.l(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Function1 function1, String str, boolean z2) {
        downloadManagerImpl.K0(downloadBean);
        ConcurrentHashMap concurrentHashMap = downloadManagerImpl.b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = downloadManagerImpl.i;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = downloadManagerImpl.h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        Iterator it = downloadManagerImpl.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadBean downloadBean2 = (DownloadBean) it.next();
            if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                downloadManagerImpl.c.remove(downloadBean2);
                a.a.f(wf.a.a, downloadManagerImpl.a, "remove ~~", false, 4, (Object) null);
                break;
            }
        }
        com.transsnet.downloader.core.c cVar = downloadManagerImpl.d;
        if (cVar != null) {
            cVar.a(downloadBean);
        }
        kotlinx.coroutines.i.d(downloadManagerImpl.v, (CoroutineContext) null, (CoroutineStart) null, new remove.1.1(str, downloadBean, (Continuation) null), 3, (Object) null);
        downloadManagerImpl.F0();
        yw.e eVar = new yw.e(true, false);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = yw.e.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, eVar, 0L);
        yw.a aVar = new yw.a();
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = yw.a.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, aVar, 0L);
        if (z2) {
            downloadManagerImpl.t0(downloadBean.getSubjectId() + downloadBean.getSe() + downloadBean.getEp());
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z2));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Function1 function1, DownloadManagerImpl downloadManagerImpl, boolean z2) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z2));
        }
        a.a.f(wf.a.a, downloadManagerImpl.a, "remove success ,prepareDownloadNextTask", false, 4, (Object) null);
        downloadManagerImpl.S0();
        downloadManagerImpl.F0();
        return Unit.a;
    }

    private final void K0(DownloadBean downloadBean) {
        Set set = this.l;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        Set set3 = this.k;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        set3.remove(resourceId3);
        Set set4 = this.n;
        String resourceId4 = downloadBean.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean.getUrl();
        }
        set4.remove(resourceId4);
        S0();
    }

    private final void L0(List list, int i, Function1 function1) {
        DownloadBean downloadBean = (DownloadBean) list.get(i);
        l0(downloadBean, false, new o(downloadBean, this, i, list, function1, downloadBean.getPath()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(DownloadBean downloadBean, DownloadManagerImpl downloadManagerImpl, int i, List list, Function1 function1, String str, boolean z2) {
        wf.a.a.u("download", "removeDownload ,db success, remove file, name = " + downloadBean.getName() + ", resourceId：" + downloadBean.getResourceId(), true);
        downloadManagerImpl.K0(downloadBean);
        ConcurrentHashMap concurrentHashMap = downloadManagerImpl.b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = downloadManagerImpl.i;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = downloadManagerImpl.h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        downloadManagerImpl.c.remove(downloadBean);
        com.transsnet.downloader.core.c cVar = downloadManagerImpl.d;
        if (cVar != null) {
            cVar.a(downloadBean);
        }
        kotlinx.coroutines.i.d(downloadManagerImpl.v, (CoroutineContext) null, (CoroutineStart) null, new removeDownload.1.1(str, downloadBean, (Continuation) null), 3, (Object) null);
        if (i >= list.size() - 1) {
            yw.e eVar = new yw.e(true, false);
            AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
            FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name = yw.e.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, eVar, 0L);
            yw.a aVar = new yw.a();
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = yw.a.class.getName();
            Intrinsics.g(name2, "getName(...)");
            flowEventBus2.postEvent(name2, aVar, 0L);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else {
            downloadManagerImpl.L0(list, i + 1, function1);
        }
        return Unit.a;
    }

    private final void N0(DownloadBean downloadBean) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new requestNewSource.1(this, downloadBean, (Continuation) null), 3, (Object) null);
    }

    private final void O0(boolean z2) {
        if (v0()) {
            wf.a.a.c("download", "resumeAll, " + z2, true);
            for (DownloadBean downloadBean : this.c) {
                wf.a.a.c("download", "resumeAll, " + z2 + ", pauseInner:" + downloadBean.getTotalTitleName() + ", isAutoPause:" + downloadBean.isAutoPause(), true);
                if (!z2) {
                    D0(downloadBean);
                } else if (downloadBean.isAutoPause() && !downloadBean.isDownloading()) {
                    if (this.b.isEmpty()) {
                        D0(downloadBean);
                    } else {
                        downloadBean.setStatus(3);
                        com.transsnet.downloader.core.c cVar = this.d;
                        if (cVar != null) {
                            cVar.a(downloadBean);
                        }
                    }
                }
            }
        }
    }

    private final void P0(List list) {
        boolean z2;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        Iterator it;
        a.a.f(wf.a.a, this.a, "resumeAllDownloading , uncomplete size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, (Object) null);
        int i = 4;
        int i2 = 2;
        int i3 = 3;
        int i4 = 1;
        if (list != null) {
            Iterator it2 = list.iterator();
            z2 = false;
            downloadBean = null;
            downloadBean2 = null;
            while (it2.hasNext()) {
                DownloadBean downloadBean3 = (DownloadBean) it2.next();
                int status = downloadBean3.getStatus();
                if (status == i4 || status == i2) {
                    it = it2;
                    Iterator it3 = this.c.iterator();
                    boolean z3 = false;
                    while (it3.hasNext()) {
                        if (Intrinsics.c(downloadBean3.getResourceId(), ((DownloadBean) it3.next()).getResourceId())) {
                            z3 = true;
                        }
                    }
                    ConcurrentHashMap concurrentHashMap = this.b;
                    String resourceId = downloadBean3.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean3.getUrl();
                    }
                    if (!concurrentHashMap.containsKey(resourceId)) {
                        z3 = false;
                    }
                    if (downloadBean3.isPreDownload()) {
                        z3 = false;
                    }
                    if (!z3) {
                        a.a aVar = wf.a.a;
                        String resourceId2 = downloadBean3.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean3.getUrl();
                        }
                        a.a.f(aVar, "DownloadStatus", "init resume , resId = " + resourceId2, false, 4, (Object) null);
                        String str = this.a;
                        String resourceId3 = downloadBean3.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean3.getUrl();
                        }
                        aVar.c(str, "resumeAllDownloading init resume  , resId = " + resourceId3 + ", name = " + downloadBean3.getName(), true);
                        downloadBean3.setStatus(3);
                        s(downloadBean3, true);
                    }
                    z2 = true;
                } else if (status == i3 || status == i) {
                    if (downloadBean == null) {
                        downloadBean = downloadBean3;
                    }
                    if (downloadBean3.getStatus() == i3 && downloadBean3.getProgress() < 5242880) {
                        a.a.f(wf.a.a, this.a, "init-----preDownload ，add to pool, name = " + downloadBean3.getName() + ", epse = " + downloadBean3.getEpse(), false, 4, (Object) null);
                        ConcurrentHashMap concurrentHashMap2 = this.i;
                        String resourceId4 = downloadBean3.getResourceId();
                        if (resourceId4 == null) {
                            resourceId4 = downloadBean3.getUrl();
                        }
                        concurrentHashMap2.put(resourceId4, downloadBean3);
                    }
                    a.a aVar2 = wf.a.a;
                    a.a.f(aVar2, "DownloadStatus", "init add waitSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName(), false, 4, (Object) null);
                    it = it2;
                    a.a.f(aVar2, this.a, "init add waitSet , resId = " + downloadBean3.getResourceId() + ", epse = " + downloadBean3.getEpse() + ", name = " + downloadBean3.getName() + ", status = " + downloadBean3.getStatus() + ",progress = " + downloadBean3.getProgress(), false, 4, (Object) null);
                    Set set = this.k;
                    String resourceId5 = downloadBean3.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean3.getUrl();
                    }
                    set.add(resourceId5);
                } else {
                    if (status == 6) {
                        if (downloadBean2 == null) {
                            downloadBean2 = downloadBean3;
                        }
                        a.a aVar3 = wf.a.a;
                        a.a.f(aVar3, "DownloadStatus", "init add errorSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName() + ", name = " + downloadBean3.getName(), false, 4, (Object) null);
                        String str2 = this.a;
                        String resourceId6 = downloadBean3.getResourceId();
                        StringBuilder sb = new StringBuilder();
                        sb.append("init add errorSet , resId = ");
                        sb.append(resourceId6);
                        a.a.f(aVar3, str2, sb.toString(), false, 4, (Object) null);
                        Set set2 = this.m;
                        String resourceId7 = downloadBean3.getResourceId();
                        if (resourceId7 == null) {
                            resourceId7 = downloadBean3.getUrl();
                        }
                        set2.add(resourceId7);
                    }
                    it = it2;
                }
                S0();
                if (!this.c.contains(downloadBean3)) {
                    wf.a.a.c(this.a, "resumeAllDownloading， add 2 cache, name = " + downloadBean3.getName(), true);
                    this.c.add(downloadBean3);
                }
                it2 = it;
                i = 4;
                i2 = 2;
                i3 = 3;
                i4 = 1;
            }
        } else {
            z2 = false;
            downloadBean = null;
            downloadBean2 = null;
        }
        if (z2) {
            return;
        }
        if (downloadBean != null) {
            if (!(downloadBean.getStatus() == 4)) {
                wf.a.a.c(this.a, "------ has no loading, use wait, name = " + downloadBean.getName(), true);
                Set set3 = this.k;
                String resourceId8 = downloadBean.getResourceId();
                if (resourceId8 == null) {
                    resourceId8 = downloadBean.getUrl();
                }
                set3.remove(resourceId8);
                downloadBean.setStatus(3);
                g.a.a(this, downloadBean, false, 2, (Object) null);
                S0();
                return;
            }
        }
        if (downloadBean2 != null) {
            wf.a.a.c(this.a, "------ has no loading, use error, name = " + downloadBean2.getName(), true);
            Set set4 = this.m;
            String resourceId9 = downloadBean2.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean2.getUrl();
            }
            set4.remove(resourceId9);
            downloadBean2.setStatus(3);
            g.a.a(this, downloadBean2, false, 2, (Object) null);
            S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a Q0() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    private final void R0() {
        String str;
        int size = this.b.size();
        ax.b bVar = this.e;
        if (size >= (bVar != null ? bVar.b() : 2)) {
            Iterator it = this.b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                str = (String) entry.getKey();
                DownloadBean b = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
                b.setStatus(3);
                com.transsnet.downloader.core.c cVar = this.d;
                if (cVar != null) {
                    cVar.a(b);
                }
                Set set = this.l;
                String resourceId = b.getResourceId();
                if (resourceId == null) {
                    resourceId = b.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.k;
                String resourceId2 = b.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = b.getUrl();
                }
                set2.add(resourceId2);
                wf.a.a.c("download", "有其他资源进入边下边播 当前资源转换为waiting setCurDownloadingToWait() --> 2--downloading2wait,resourceId=" + b.getResourceId() + ",name = " + b.getTotalTitleName() + " ", true);
                S0();
            } else {
                str = null;
            }
            if (str != null) {
            }
        }
    }

    private final void S0() {
        zw.b bVar = this.j;
        if (bVar != null) {
            this.p.setWaitCount(this.k.size());
            this.p.setLoadingCount(this.l.size());
            this.p.setErrorCount(this.m.size());
            this.p.setDoneCount(this.n.size());
            a.a.f(wf.a.a, this.a, "-------- statChange, downloadStat = " + this.p + " ", false, 4, (Object) null);
            bVar.a(this.p);
        }
    }

    private final void T0(DownloadBean downloadBean) {
        if (downloadBean.getRootPathType() == 1) {
            downloadBean.setTransferFailed(false);
        } else {
            if (downloadBean.getType() == 1) {
                return;
            }
            kotlinx.coroutines.i.d(this.v, (CoroutineContext) null, (CoroutineStart) null, new transferFile.1(downloadBean, (Continuation) null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(DownloadBean downloadBean) {
        Set set = this.m;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.add(resourceId);
        Set set2 = this.l;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        S0();
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(DownloadBean downloadBean) {
        Set set = this.k;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        D0(downloadBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(DownloadBean downloadBean) {
        DownloadBean downloadBean2;
        com.transsnet.downloader.core.c cVar;
        if (downloadBean.isCompleted() || downloadBean.isRemoved()) {
            return;
        }
        a.a aVar = wf.a.a;
        a.a.v(aVar, this.a, "1- waitDownloadingAndStartNewTask,进入边下边播 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name = " + downloadBean.getTotalTitleName() + ",status = " + downloadBean.getStatus(), false, 4, (Object) null);
        downloadBean.setDownloadingPlay(true);
        boolean z2 = false;
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            aVar.p("download", new String[]{"下载中的 变成当前边下边播的 waitDownloadingAndStartNewTask, subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",status-- name = " + downloadBean.getName() + " "}, true);
            if (downloadBean.isPreDownload()) {
                downloadBean.setPreDownload(false);
                aVar.p("download", new String[]{"preDownload 预下载的 转正变成当前边下边播的 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name= " + downloadBean.getName() + " , epse = " + downloadBean.getEpse()}, true);
                Set set = this.k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                Set set3 = this.l;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set3.add(resourceId3);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.c cVar2 = this.d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                S0();
                ConcurrentHashMap concurrentHashMap = this.h;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) concurrentHashMap.get(resourceId4);
                if (bVar != null) {
                    R0();
                    ConcurrentHashMap concurrentHashMap2 = this.b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, bVar);
                    ConcurrentHashMap concurrentHashMap3 = this.h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                    return;
                }
                return;
            }
            return;
        }
        ConcurrentHashMap concurrentHashMap4 = this.i;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        concurrentHashMap4.remove(resourceId7);
        ConcurrentHashMap concurrentHashMap5 = this.h;
        String resourceId8 = downloadBean.getResourceId();
        if (resourceId8 == null) {
            resourceId8 = downloadBean.getUrl();
        }
        concurrentHashMap5.remove(resourceId8);
        downloadBean.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap6 = this.b;
        String resourceId9 = downloadBean.getResourceId();
        if (resourceId9 == null) {
            resourceId9 = downloadBean.getUrl();
        }
        if (concurrentHashMap6.containsKey(resourceId9)) {
            if (downloadBean.isDownloading()) {
                aVar.p("download", new String[]{"waitDownloadingAndStartNewTask, isDownloading name = " + downloadBean.getName() + " "}, true);
                return;
            }
            ConcurrentHashMap concurrentHashMap7 = this.b;
            String resourceId10 = downloadBean.getResourceId();
            if (resourceId10 == null) {
                resourceId10 = downloadBean.getUrl();
            }
            concurrentHashMap7.remove(resourceId10);
            a.a.f(aVar, this.a, "waitDownloadingAndStartNewTask, isDownloading,error status , remove  name = " + downloadBean.getName(), false, 4, (Object) null);
        }
        R0();
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadBean2 = downloadBean;
                break;
            }
            downloadBean2 = (DownloadBean) it.next();
            if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            this.c.add(downloadBean2);
        }
        ax.b bVar2 = this.e;
        com.transsnet.downloader.core.task.b bVar3 = null;
        if (bVar2 != null && (cVar = this.d) != null) {
            bVar3 = k0(bVar2, cVar, downloadBean);
        }
        if (bVar3 != null) {
            ConcurrentHashMap concurrentHashMap8 = this.b;
            String resourceId11 = downloadBean2.getResourceId();
            if (resourceId11 == null) {
                resourceId11 = downloadBean2.getUrl();
            }
            concurrentHashMap8.put(resourceId11, bVar3);
        }
        downloadBean2.setStatus(1);
        com.transsnet.downloader.core.c cVar3 = this.d;
        if (cVar3 != null) {
            cVar3.a(downloadBean2);
        }
        j0(downloadBean2);
        Set set4 = this.k;
        String resourceId12 = downloadBean2.getResourceId();
        if (resourceId12 == null) {
            resourceId12 = downloadBean2.getUrl();
        }
        set4.remove(resourceId12);
        Set set5 = this.m;
        String resourceId13 = downloadBean2.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = downloadBean2.getUrl();
        }
        set5.remove(resourceId13);
        Set set6 = this.l;
        String resourceId14 = downloadBean2.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = downloadBean2.getUrl();
        }
        set6.add(resourceId14);
        wf.a.a.p("download", new String[]{"由边下边播触发的下载要开始了 2--prepareDownload, name = " + downloadBean2.getName() + ", add loading, loading  = " + this.l.size() + ", error  = " + this.m.size() + " , wait  = " + this.k.size() + " "}, true);
        S0();
        if (bVar3 != null) {
            bVar3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final si.a i0() {
        Application a = Utils.a();
        if (a != null) {
            return AppDatabase.p.b(a).n1();
        }
        return null;
    }

    private final void j0(DownloadBean downloadBean) {
        DownloadNotificationUtils.a.n(downloadBean);
    }

    private final com.transsnet.downloader.core.task.b k0(ax.b bVar, com.transsnet.downloader.core.c cVar, DownloadBean downloadBean) {
        return DownloadTaskUtil.a.j() ? new DownloadTaskImpl2(cVar, this.t, downloadBean, bVar, this) : new DownloadTaskImpl(cVar, this.t, downloadBean, bVar, this);
    }

    private final void l0(DownloadBean downloadBean, boolean z2, Function1 function1) {
        kotlinx.coroutines.i.d(this.v, (CoroutineContext) null, (CoroutineStart) null, new deleteItem.1(downloadBean, this, function1, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final si.a m0() {
        return (si.a) this.o.getValue();
    }

    private final String n0() {
        return DownloadManagerImpl.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadManagerImpl p0() {
        return new DownloadManagerImpl(null);
    }

    private final io.b q0() {
        return (io.b) this.x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ui.n0 r0() {
        return (ui.n0) this.w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cx.a s0() {
        return (cx.a) this.s.getValue();
    }

    private final void t0(String str) {
        io.b q0 = q0();
        if (q0 != null) {
            q0.m(str);
        }
    }

    private final boolean u0() {
        String str;
        int size = this.b.size();
        ax.b bVar = this.e;
        boolean z2 = false;
        if (size >= (bVar != null ? bVar.b() : 2)) {
            Iterator it = this.b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                str = (String) entry.getKey();
                DownloadBean b = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
                a.a.f(wf.a.a, this.a, "curTask, name = " + b.getTotalTitleName() + ",status = " + b.getStatus(), false, 4, (Object) null);
                z2 = b.isDownloading();
            } else {
                str = "";
            }
            if (!z2 && str.length() > 0) {
                this.b.remove(str);
            }
        }
        return z2;
    }

    private final boolean v0() {
        if (SystemClock.elapsedRealtime() - this.f <= 500) {
            return false;
        }
        this.f = SystemClock.elapsedRealtime();
        return true;
    }

    private final void w0(boolean z2) {
        a.a aVar = wf.a.a;
        aVar.c(this.a, "isAutoPause, isAutoPause:" + z2, true);
        if (v0()) {
            aVar.c("download", "pauseAll, " + z2, true);
            for (DownloadBean downloadBean : this.c) {
                if (!z2) {
                    x0(downloadBean, false);
                } else if (downloadBean.getStatus() != 4) {
                    wf.a.a.c("download", "pauseAll, pauseInner:" + downloadBean.getTotalTitleName(), true);
                    downloadBean.setAutoPause(true);
                    x0(downloadBean, false);
                }
            }
        }
    }

    private final void x0(DownloadBean downloadBean, boolean z2) {
        DownloadBean downloadBean2;
        downloadBean.setPreDownload(false);
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadBean2 = null;
                break;
            } else {
                downloadBean2 = (DownloadBean) it.next();
                if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                    break;
                }
            }
        }
        if (downloadBean2 == null) {
            this.c.add(downloadBean);
            downloadBean2 = downloadBean;
        }
        com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) this.b.get(downloadBean.getResourceId());
        if (bVar != null && !Intrinsics.c(bVar.b(), downloadBean2)) {
            wf.a.a.c(this.a, "------pause, name: " + downloadBean2.getTotalTitleName() + ", info:" + bVar.b(), true);
            bVar.b().setStatus(4);
        }
        Set set = this.l;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.m;
        String resourceId2 = downloadBean2.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean2.getUrl();
        }
        set2.remove(resourceId2);
        Set set3 = this.k;
        String resourceId3 = downloadBean2.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean2.getUrl();
        }
        set3.add(resourceId3);
        wf.a.a.c(this.a, "pause, name: " + downloadBean2.getTotalTitleName() + ", downloadNext:" + z2 + "， info:" + downloadBean2, true);
        S0();
        downloadBean2.setStatus(4);
        ConcurrentHashMap concurrentHashMap = this.b;
        String resourceId4 = downloadBean2.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean2.getUrl();
        }
        concurrentHashMap.remove(resourceId4);
        ConcurrentHashMap concurrentHashMap2 = this.h;
        String resourceId5 = downloadBean2.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadBean2.getUrl();
        }
        concurrentHashMap2.remove(resourceId5);
        ConcurrentHashMap concurrentHashMap3 = this.i;
        String resourceId6 = downloadBean2.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = downloadBean2.getUrl();
        }
        concurrentHashMap3.remove(resourceId6);
        com.transsnet.downloader.core.c cVar = this.d;
        if (cVar != null) {
            cVar.a(downloadBean2);
        }
        if (z2) {
            F0();
        }
    }

    static /* synthetic */ void y0(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        downloadManagerImpl.x0(downloadBean, z2);
    }

    private final void z0(DownloadBean downloadBean) {
        if (this.h.isEmpty()) {
            return;
        }
        for (Map.Entry entry : this.h.entrySet()) {
            String str = (String) entry.getKey();
            DownloadBean b = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
            wf.a.a.c("download", "pause current preDownload, add to pool, name = " + b.getTotalTitleName() + "，HashCode = " + System.identityHashCode(downloadBean) + " ", true);
            this.i.put(str, b);
            if (!Intrinsics.c(b.getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                b.setStatus(3);
            }
            this.h.remove(str);
        }
    }

    public void A() {
        z0(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object B(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r12)
            goto L60
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            kotlin.ResultKt.b(r12)
            goto L4a
        L38:
            kotlin.ResultKt.b(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r4
            java.lang.Object r12 = r12.C(r0)
            if (r12 != r1) goto L4a
            return r1
        L4a:
            java.util.List r12 = (java.util.List) r12
            r11.P0(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r3
            r2 = 0
            r3 = 0
            java.lang.Object r12 = com.transsnet.downloader.manager.DownloadEsHelper.B(r12, r2, r0, r4, r3)
            if (r12 != r1) goto L60
            return r1
        L60:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto Lbb
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L6a:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto Lbb
            java.lang.Object r0 = r12.next()
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0
            int r1 = r0.isRead()
            if (r1 == r4) goto L8f
            java.util.Set r1 = r11.n
            java.lang.String r2 = r0.getResourceId()
            if (r2 != 0) goto L88
            java.lang.String r2 = r0.getUrl()
        L88:
            boolean r1 = r1.remove(r2)
            kotlin.coroutines.jvm.internal.Boxing.a(r1)
        L8f:
            wf.a$a r5 = wf.a.a
            java.lang.String r1 = r0.getResourceId()
            int r0 = r0.isRead()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "init add doneSet, resId = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "， it.isRead = "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DownloadStatus"
            r8 = 0
            wf.a.a.f(r5, r6, r7, r8, r9, r10)
            goto L6a
        Lbb:
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void C(List list) {
        Intrinsics.h(list, "list");
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            p((DownloadBean) list.get(0));
            return;
        }
        ax.b bVar = this.e;
        int b = bVar != null ? bVar.b() : 1;
        for (int i = 0; i < b; i++) {
            if (i < list.size()) {
                p((DownloadBean) list.get(i));
            }
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            long j = i2;
            downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis() + j));
            downloadBean.setCreateAt(System.currentTimeMillis() + j);
            if (i2 >= b && i2 != list.size() - 1) {
                ConcurrentHashMap concurrentHashMap = this.i;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                concurrentHashMap.put(resourceId, downloadBean);
                ConcurrentHashMap concurrentHashMap2 = this.h;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                if (!this.c.contains(downloadBean)) {
                    this.c.add(downloadBean);
                }
                downloadBean.setPreDownload(false);
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.c cVar = this.d;
                if (cVar != null) {
                    cVar.a(downloadBean);
                }
                Set set = this.k;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set.add(resourceId3);
                S0();
            }
            i2 = i3;
        }
        int size = list.size() - 1;
        if (size >= b - 1) {
            DownloadBean downloadBean2 = (DownloadBean) list.get(size);
            if (!this.c.contains(downloadBean2)) {
                this.c.add(downloadBean2);
            }
            if (!B0(downloadBean2)) {
                downloadBean2.setStatus(3);
                com.transsnet.downloader.core.c cVar2 = this.d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean2);
                }
            }
            Set set2 = this.k;
            String resourceId4 = downloadBean2.getResourceId();
            if (resourceId4 == null) {
                resourceId4 = downloadBean2.getUrl();
            }
            set2.add(resourceId4);
        }
        S0();
    }

    public void D() {
        S0();
    }

    public void E(s0 s0Var) {
        Intrinsics.h(s0Var, "listener");
        this.r.add(s0Var);
    }

    public void F(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        if (v0()) {
            y0(this, downloadBean, false, 2, null);
        }
    }

    public void G(ax.b bVar) {
        Intrinsics.h(bVar, "config");
        ax.b bVar2 = this.e;
        if (bVar2 == null || bVar2 == null || bVar2.b() != bVar.b()) {
            if (bVar.b() > 1 && this.b.size() < bVar.b()) {
                for (DownloadBean downloadBean : this.c) {
                    if (!downloadBean.isDownloading() && downloadBean.getStatus() != 4 && bVar.b() - this.b.size() > 0) {
                        wf.a.a.p("download", new String[]{n0() + " --> set new config, start other task, task:" + bVar.b() + ", cur:" + this.b.size() + " "}, true);
                        p(downloadBean);
                    }
                }
            } else if (this.b.size() > 1 && this.b.size() > bVar.b()) {
                for (int size = this.c.size() - 1; size > 0; size--) {
                    DownloadBean downloadBean2 = (DownloadBean) this.c.get(size);
                    if (downloadBean2.isDownloading() && bVar.b() <= this.b.size()) {
                        x0(downloadBean2, false);
                        wf.a.a.p("download", new String[]{n0() + " --> set new config, pause task, task:" + bVar.b() + ", cur:" + this.b.size() + " "}, true);
                    }
                }
            }
        }
        this.e = bVar;
    }

    public void H() {
        this.t.c();
    }

    public void I(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        kotlinx.coroutines.i.d(this.u, (CoroutineContext) null, (CoroutineStart) null, new onPreDownloadSuccess.1(this, downloadBean, (Continuation) null), 3, (Object) null);
    }

    public Object a(String str, int i, String str2, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new transformDownloadPlayUrl.3(str, i, str2, this, (Continuation) null), continuation);
    }

    public void b(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        T0(downloadBean);
        ConcurrentHashMap concurrentHashMap = this.i;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = this.b;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = this.h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        boolean remove = this.c.remove(downloadBean);
        a.a aVar = wf.a.a;
        a.a.f(aVar, this.a, "remove index " + remove, false, 4, (Object) null);
        Set set = this.n;
        String resourceId4 = downloadBean.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean.getUrl();
        }
        set.add(resourceId4);
        Set set2 = this.k;
        String resourceId5 = downloadBean.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadBean.getUrl();
        }
        set2.remove(resourceId5);
        DownloadStatusIconManager.h.a().w(false);
        Set set3 = this.l;
        String resourceId6 = downloadBean.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = downloadBean.getUrl();
        }
        set3.remove(resourceId6);
        aVar.p("download", new String[]{"onDownloadSuccess, name = " + downloadBean.getName() + " subjectId=" + downloadBean.getSubjectId() + " resourceId=" + downloadBean.getResourceId() + ", status = " + downloadBean.getStatus() + " "}, true);
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            ((s0) it.next()).b(downloadBean);
        }
        S0();
        F0();
    }

    public void c(DownloadBean downloadBean, boolean z2) {
        Intrinsics.h(downloadBean, "downloadInfo");
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            ((s0) it.next()).c(downloadBean, z2);
        }
    }

    public void d() {
        C0();
    }

    public Object e(String str, Continuation continuation) {
        return DownloadEsHelper.m.a().o(str, continuation);
    }

    public void f(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        Set set = this.k;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        D0(downloadBean);
    }

    public void g(m0 m0Var) {
        Intrinsics.h(m0Var, "listener");
        this.q.add(m0Var);
    }

    public String h(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "bean");
        return this.t.f(downloadBean);
    }

    public boolean i() {
        return !this.b.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.manager.DownloadManagerImpl.getDownloadedPlayBean.2
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl.getDownloadedPlayBean.2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.m
            com.transsnet.downloader.manager.DownloadEsHelper r2 = r6.a()
            com.transsion.baselib.db.download.DownloadBean r2 = r2.S(r5)
            if (r2 != 0) goto L50
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            r0.label = r3
            java.lang.Object r6 = r6.R(r5, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r2 = r6
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2
        L50:
            if (r2 == 0) goto L65
            boolean r5 = r2.isCompleted()
            if (r5 != r3) goto L65
            java.lang.String r5 = r2.getPath()
            if (r5 == 0) goto L65
            int r5 = r5.length()
            if (r5 <= 0) goto L65
            goto L66
        L65:
            r2 = 0
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.j(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void k(m0 m0Var) {
        Intrinsics.h(m0Var, "listener");
        if (this.q.contains(m0Var)) {
            this.q.remove(m0Var);
        }
    }

    public void l(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        if (ThreadUtils.i()) {
            W0(downloadBean);
        } else {
            kotlinx.coroutines.i.d(this.u, (CoroutineContext) null, (CoroutineStart) null, new waitDownloadingAndStartNewTask.1(this, downloadBean, (Continuation) null), 3, (Object) null);
        }
    }

    public void m(DownloadBean downloadBean, Function1 function1) {
        Intrinsics.h(downloadBean, "downloadInfo");
        l0(downloadBean, true, new n(this, downloadBean, function1, downloadBean.getPath()));
    }

    public void n() {
        w0(false);
    }

    public void o() {
        this.t.h();
    }

    public Object o0(Continuation continuation) {
        return DownloadEsHelper.m.a().y(continuation);
    }

    public void p(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        a.a aVar = wf.a.a;
        aVar.c("download", n0() + " --> download() --> downloadInfo = " + downloadBean, false);
        if (z(downloadBean)) {
            a.a.f(aVar, "download", n0() + " --> download() --> 任务已存在", false, 4, (Object) null);
            return;
        }
        DownloadEsHelper.m.a().h();
        if (!this.c.contains(downloadBean)) {
            this.c.add(downloadBean);
        }
        aVar.p("download", new String[]{n0() + " --> download() -->, 添加新的任务 -- name = " + downloadBean.getName() + " "}, true);
        D0(downloadBean);
    }

    public void q() {
        this.t.b();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.transsion.baselib.db.download.DownloadBean, java.lang.Object] */
    public void r(String str, Function1 function1) {
        Intrinsics.h(function1, "callback");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ?? r1 = (DownloadBean) it.next();
            if (TextUtils.equals(r1.getResourceId(), str)) {
                ref$ObjectRef.element = r1;
                function1.invoke((Object) r1);
                break;
            }
        }
        if (ref$ObjectRef.element == 0) {
            kotlinx.coroutines.i.d(this.u, (CoroutineContext) null, (CoroutineStart) null, new getDownloadByResId.2(ref$ObjectRef, str, function1, this, (Continuation) null), 3, (Object) null);
        }
    }

    public void s(DownloadBean downloadBean, boolean z2) {
        Intrinsics.h(downloadBean, "downloadInfo");
        if (v0() || z2) {
            if (!this.c.contains(downloadBean)) {
                this.c.add(downloadBean);
            }
            wf.a.a.c(this.a, "resume, name = " + downloadBean.getTotalTitleName() + ", cur status = " + downloadBean.getStatus() + ", " + downloadBean, true);
            Set set = this.k;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            set.remove(resourceId);
            Set set2 = this.m;
            String resourceId2 = downloadBean.getResourceId();
            if (resourceId2 == null) {
                resourceId2 = downloadBean.getUrl();
            }
            set2.remove(resourceId2);
            D0(downloadBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object t(java.lang.String r5, int r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadManagerImpl.getDownloadedPlayBean.1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl.getDownloadedPlayBean.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r8)
            com.transsnet.downloader.manager.DownloadEsHelper$a r8 = com.transsnet.downloader.manager.DownloadEsHelper.m
            com.transsnet.downloader.manager.DownloadEsHelper r2 = r8.a()
            com.transsion.baselib.db.download.DownloadBean r2 = r2.K(r5, r6, r7)
            if (r2 != 0) goto L50
            com.transsnet.downloader.manager.DownloadEsHelper r8 = r8.a()
            r0.label = r3
            java.lang.Object r8 = r8.J(r5, r6, r7, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            r2 = r8
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2
        L50:
            if (r2 == 0) goto L65
            boolean r5 = r2.isCompleted()
            if (r5 != r3) goto L65
            java.lang.String r5 = r2.getPath()
            if (r5 == 0) goto L65
            int r5 = r5.length()
            if (r5 <= 0) goto L65
            goto L66
        L65:
            r2 = 0
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.t(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void u(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        downloadBean.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap = this.b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        com.transsnet.downloader.core.c cVar = this.d;
        if (cVar != null) {
            cVar.a(downloadBean);
        }
        ConcurrentHashMap concurrentHashMap2 = this.i;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = this.h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        if (DownloadUtil.a.E(downloadBean)) {
            N0(downloadBean);
            return;
        }
        Set set = this.m;
        String resourceId4 = downloadBean.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean.getUrl();
        }
        set.add(resourceId4);
        Set set2 = this.l;
        String resourceId5 = downloadBean.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadBean.getUrl();
        }
        set2.remove(resourceId5);
        wf.a.a.i("download", "Download Failed, name = " + downloadBean.getName() + ", resourceId = " + downloadBean.getResourceId() + "，subjectId = " + downloadBean.getSubjectId() + "，remove from loading, add to error， loading  = " + this.l.size() + ", error  = " + this.m.size() + " , wait  = " + this.k.size() + " ", true);
        S0();
        F0();
    }

    public void v() {
        O0(false);
    }

    public Long w() {
        Iterator it = this.c.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((DownloadBean) it.next()).getProgress();
        }
        return Long.valueOf(j);
    }

    public void x(zw.b bVar) {
        Intrinsics.h(bVar, "listener");
        this.p.setWaitCount(this.k.size());
        this.p.setLoadingCount(this.l.size());
        this.p.setErrorCount(this.m.size());
        this.p.setDoneCount(this.n.size());
        bVar.a(this.p);
        this.j = bVar;
    }

    public void y(List list, Function1 function1) {
        a.a.f(wf.a.a, this.a, "remove list ,size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, (Object) null);
        if (list != null) {
            L0(list, 0, new m(function1, this));
        }
    }

    public boolean z(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        ConcurrentHashMap concurrentHashMap = this.b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        return concurrentHashMap.containsKey(resourceId);
    }
}
