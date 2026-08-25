package com.transsnet.downloader.manager;

import com.blankj.utilcode.util.Utils;
import com.transsnet.downloader.callback.DownloadTaskStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadStatusIconManager implements zw.b {
    public static final a h = new a((DefaultConstructorMarker) null);
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.q
        public final Object invoke() {
            DownloadStatusIconManager s;
            s = DownloadStatusIconManager.s();
            return s;
        }
    });
    private int c;
    private int d;
    private int e;
    private int f;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.r
        public final Object invoke() {
            g p;
            p = DownloadStatusIconManager.p();
            return p;
        }
    });
    private final List b = new ArrayList();
    private boolean g = com.transsion.baselib.report.launch.b.a.b().getBoolean("k_download_done_status", true);

    public DownloadStatusIconManager() {
        q().x(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g p() {
        return p.a.a(Utils.a());
    }

    private final g q() {
        return (g) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadStatusIconManager s() {
        return new DownloadStatusIconManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int i2, int i3) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((zw.e) it.next()).a(i2, i3);
        }
    }

    static /* synthetic */ void u(DownloadStatusIconManager downloadStatusIconManager, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        downloadStatusIconManager.t(i2, i3);
    }

    public void a(DownloadTaskStat downloadTaskStat) {
        Intrinsics.h(downloadTaskStat, "downloadTaskStat");
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new DownloadStatusIconManager$onChange$1(this, downloadTaskStat, null), 3, (Object) null);
    }

    public final void o(zw.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (!this.b.contains(eVar)) {
            this.b.add(eVar);
        }
        q().D();
    }

    public final void r() {
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new DownloadStatusIconManager$initDownloadUnreadList$1(this, null), 3, (Object) null);
    }

    public final void v(zw.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.b.remove(eVar);
    }

    public final void w(boolean z) {
        com.transsion.baselib.report.launch.b.a.b().putBoolean("k_download_done_status", z);
        this.g = z;
    }
}
