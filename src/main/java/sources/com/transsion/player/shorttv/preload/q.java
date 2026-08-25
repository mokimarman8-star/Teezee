package com.transsion.player.shorttv.preload;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.Requirements;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.exo.DemoDownloadService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sn.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q {
    public static final q a;
    private static final ConcurrentHashMap b;
    private static final Lazy c;
    private static final HandlerThread d;
    private static final Handler e;
    private static final long f;
    private static final Function0 g;
    private static final b h;
    private static boolean i;

    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Intrinsics.h(message, "msg");
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final class b implements DownloadManager.d {
        b() {
        }

        public void a(DownloadManager downloadManager, boolean z) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onWaitingForRequirementsChanged:");
        }

        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(cVar, "download");
            Log.e("VideoPreloadUtil", "onDownloadRemoved:");
        }

        public void c(DownloadManager downloadManager, boolean z) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onDownloadsPausedChanged:");
        }

        public void d(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onIdle:");
            q.a.B();
        }

        public void e(DownloadManager downloadManager, Requirements requirements, int i) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(requirements, "requirements");
            Log.e("VideoPreloadUtil", "onRequirementsStateChanged:");
        }

        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, Exception exc) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(cVar, "download");
            Log.e("VideoPreloadUtil", "onDownloadChanged:  download.requestId:" + cVar.a.id + "     bytesDownloaded:" + cVar.a() + "  contentLength:" + cVar.e + "  percentDownloaded:" + cVar.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) q.b.get(cVar.a.id);
            if (aVar != null) {
                aVar.h(cVar.a());
                aVar.g(cVar.e);
                int i = cVar.b;
                if (i == 2) {
                    long b = aVar.b();
                    long d = aVar.d();
                    if (1 <= d && d < b) {
                        q qVar = q.a;
                        String str = aVar.e().id;
                        Intrinsics.g(str, "id");
                        qVar.D(str);
                    }
                } else if (i == 1 || i == 3) {
                    q qVar2 = q.a;
                    String str2 = aVar.e().id;
                    Intrinsics.g(str2, "id");
                    qVar2.x(str2);
                }
            }
            q.a.A();
        }

        public void g(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
        }
    }

    static {
        q qVar = new q();
        a = qVar;
        b = new ConcurrentHashMap();
        c = LazyKt.b(new Function0() { // from class: com.transsion.player.shorttv.preload.h
            public final Object invoke() {
                Application m;
                m = q.m();
                return m;
            }
        });
        HandlerThread handlerThread = new HandlerThread("VideoPreloadUtil");
        d = handlerThread;
        f = 100L;
        g = new Function0() { // from class: com.transsion.player.shorttv.preload.i
            public final Object invoke() {
                Unit F;
                F = q.F();
                return F;
            }
        };
        b bVar = new b();
        h = bVar;
        handlerThread.start();
        e = new a(handlerThread.getLooper());
        in.a.h(qVar.o()).d(bVar);
    }

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        if (i) {
            return;
        }
        i = true;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        i = false;
        Handler handler = e;
        final Function0 function0 = g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.k
            @Override // java.lang.Runnable
            public final void run() {
                q.C(function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(String str) {
        sn.e.d(sn.e.a, "VideoPreloadUtil", "stopPreload   key:" + str, false, 4, null);
        DownloadService.z(a.o(), DemoDownloadService.class, str, 10086, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F() {
        for (Object obj : in.a.h(a.o()).e()) {
            Intrinsics.g(obj, "next(...)");
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) obj;
            if (cVar.b == 2) {
                String str = cVar.a.id;
                long a2 = cVar.a();
                long j = cVar.e;
                float b2 = cVar.b();
                StringBuilder sb = new StringBuilder();
                sb.append("progress 111:  download.requestId:");
                sb.append(str);
                sb.append("     bytesDownloaded:");
                sb.append(a2);
                sb.append("  contentLength:");
                sb.append(j);
                sb.append("  percentDownloaded:");
                sb.append(b2);
                com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) b.get(cVar.a.id);
                if (aVar != null) {
                    aVar.h(cVar.a());
                    aVar.g(cVar.e);
                    long b3 = aVar.b();
                    long d2 = aVar.d();
                    if (1 <= d2 && d2 < b3) {
                        q qVar = a;
                        String str2 = aVar.e().id;
                        Intrinsics.g(str2, "id");
                        qVar.x(str2);
                    }
                }
            }
        }
        if (i) {
            a.p();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Application m() {
        return Utils.a();
    }

    private final Context o() {
        Object value = c.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (Context) value;
    }

    private final void p() {
        Handler handler = e;
        final Function0 function0 = g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.n
            @Override // java.lang.Runnable
            public final void run() {
                q.q(function0);
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.transsion.player.shorttv.preload.o
            @Override // java.lang.Runnable
            public final void run() {
                q.r(function0);
            }
        }, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(gn.e eVar) {
        q qVar = a;
        qVar.s(qVar.n(eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(com.transsion.player.shorttv.preload.a aVar) {
        Log.e("VideoPreloadUtil", "preloadVideo id:" + aVar.c() + " downloadLength:" + aVar.b() + "  maxLength:" + aVar.d() + " contentLength:" + aVar.a());
        if (aVar.d() == -1 || aVar.b() < aVar.d()) {
            if (aVar.f()) {
                DownloadService.z(a.o(), DemoDownloadService.class, aVar.c(), 0, false);
                Log.e("VideoPreloadUtil", "checkToStart restart  shortTVItem:" + aVar);
                return;
            }
            DownloadService.x(a.o(), DemoDownloadService.class, aVar.e(), false);
            Log.e("VideoPreloadUtil", "checkToStart add    shortTVItem:" + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str) {
        sn.e.d(sn.e.a, "VideoPreloadUtil", "removePreload   key:" + str, false, 4, null);
        DownloadService.y(a.o(), DemoDownloadService.class, str, false);
    }

    public final void D(final String str) {
        Intrinsics.h(str, "key");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.m
            @Override // java.lang.Runnable
            public final void run() {
                q.E(str);
            }
        });
    }

    public final String G(String str) {
        int o0 = str != null ? StringsKt.o0(str, "?", 0, false, 6, (Object) null) : -1;
        if (str != null && o0 >= 0) {
            return sn.d.a.a((String) StringsKt.S0(str, new String[]{"?"}, false, 0, 6, (Object) null).get(0));
        }
        d.a aVar = sn.d.a;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        return aVar.a(str);
    }

    public final com.transsion.player.shorttv.preload.a n(gn.e eVar) {
        DownloadRequest downloadRequest;
        Intrinsics.h(eVar, "shortTVItem");
        ConcurrentHashMap concurrentHashMap = b;
        com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) concurrentHashMap.get(eVar.f());
        if (aVar != null) {
            sn.e.b(sn.e.a, "VideoPreloadUtil", "createDownloadRequest [from map]  shortTVItem:" + eVar, false, 4, null);
            return aVar;
        }
        androidx.media3.exoplayer.offline.c h2 = in.a.h(Utils.a()).f().h(eVar.f());
        if (Intrinsics.c((h2 == null || (downloadRequest = h2.a) == null) ? null : downloadRequest.id, eVar.f())) {
            sn.e.b(sn.e.a, "VideoPreloadUtil", "createDownloadRequest [from currentDownloads]   shortTVItem:" + eVar, false, 4, null);
            String f2 = eVar.f();
            String j = eVar.j();
            DownloadRequest downloadRequest2 = h2.a;
            Intrinsics.g(downloadRequest2, "request");
            return new com.transsion.player.shorttv.preload.a(f2, j, downloadRequest2, h2.e, h2.a(), 307200L, true);
        }
        String f3 = eVar.f();
        String j2 = eVar.j();
        DownloadRequest a2 = new DownloadRequest.b(f3, Uri.parse(j2)).b(f3).a();
        Intrinsics.g(a2, "build(...)");
        com.transsion.player.shorttv.preload.a aVar2 = new com.transsion.player.shorttv.preload.a(f3, j2, a2, -1L, 0L, 307200L, false);
        concurrentHashMap.put(f3, aVar2);
        sn.e.b(sn.e.a, "VideoPreloadUtil", "createDownloadRequest [from new]  shortTVItem:" + eVar, false, 4, null);
        return aVar2;
    }

    public final com.transsion.player.shorttv.preload.a s(final com.transsion.player.shorttv.preload.a aVar) {
        Intrinsics.h(aVar, "shortTVDownloadBean");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.p
            @Override // java.lang.Runnable
            public final void run() {
                q.v(a.this);
            }
        });
        return aVar;
    }

    public final void t(final gn.e eVar) {
        Intrinsics.h(eVar, "shortTVItem");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.j
            @Override // java.lang.Runnable
            public final void run() {
                q.u(gn.e.this);
            }
        });
    }

    public final com.transsion.player.shorttv.preload.a w(gn.e eVar) {
        Intrinsics.h(eVar, "shortTVItem");
        com.transsion.player.shorttv.preload.a n = n(eVar);
        s(n);
        return n;
    }

    public final void x(final String str) {
        Intrinsics.h(str, "key");
        b.remove(str);
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.l
            @Override // java.lang.Runnable
            public final void run() {
                q.y(str);
            }
        });
    }

    public final void z(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        e.post(runnable);
    }
}
