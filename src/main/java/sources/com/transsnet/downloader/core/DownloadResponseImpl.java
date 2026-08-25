package com.transsnet.downloader.core;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ax.b;
import cm.f;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadResponseImpl implements c {
    public static final a j = new a((DefaultConstructorMarker) null);
    private final Set a;
    private final b b;
    private int c;
    private String d;
    private Handler e;
    private final int f;
    private g g;
    private final Lazy h;
    private n0 i;

    public DownloadResponseImpl(g gVar, Set set, b bVar) {
        Intrinsics.h(gVar, "downloadManager");
        Intrinsics.h(set, "downloadListeners");
        this.a = set;
        this.b = bVar;
        this.c = -1;
        this.e = new b(this, Looper.getMainLooper());
        this.f = 40;
        this.h = LazyKt.b(new d());
        this.i = o0.a(y0.b());
        this.g = gVar;
    }

    private final void h(DownloadBean downloadBean) {
        if (downloadBean.getStatus() == 7) {
            return;
        }
        i.d(this.i, (CoroutineContext) null, (CoroutineStart) null, new createOrUpdateDownloadInfo.1(downloadBean, this, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ui.n0 i() {
        return (ui.n0) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(com.transsion.baselib.db.download.DownloadBean r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.DownloadResponseImpl.j(com.transsion.baselib.db.download.DownloadBean, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ui.n0 k() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return f1Var.b(a).p1();
    }

    private final void l(DownloadBean downloadBean) {
        Object obj;
        if (downloadBean.isPreDownload()) {
            return;
        }
        if (downloadBean.getStatus() == 6) {
            ConfigBean c = f.c.a().c("download_error_opt_off", true);
            if (c == null || (obj = c.getValue()) == null) {
                obj = 0;
            }
            DownloadException exception = downloadBean.getException();
            if (exception != null && exception.getCode() == downloadBean.getPreErrorCode() && Intrinsics.c(obj, 0)) {
                return;
            }
            DownloadException exception2 = downloadBean.getException();
            downloadBean.setPreErrorCode(exception2 != null ? exception2.getCode() : DownloadException.Companion.a());
        }
        i.d(this.i, (CoroutineContext) null, (CoroutineStart) null, new report.1(downloadBean, this, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.transsion.baselib.db.download.DownloadBean r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.DownloadResponseImpl.m(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void n(DownloadBean downloadBean) {
        DownloadNotificationUtils.a.I(downloadBean);
    }

    public void a(DownloadBean downloadBean) {
        int status = downloadBean != null ? downloadBean.getStatus() : -1;
        if (downloadBean != null && (!downloadBean.isDownloading()) && this.c == status && Intrinsics.c(this.d, downloadBean.getResourceId())) {
            a.a.w("DownloadImp-ResponseImpl", "onStatusChanged, intercept status = " + status + " resourceId= " + downloadBean.getResourceId(), true);
            return;
        }
        this.c = status;
        this.d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            h(downloadBean);
            if (ThreadUtils.i()) {
                j(downloadBean, downloadBean.getStatus(), downloadBean.isPreDownload());
            } else {
                Message obtainMessage = this.e.obtainMessage(downloadBean.getStatus());
                Intrinsics.g(obtainMessage, "obtainMessage(...)");
                obtainMessage.obj = downloadBean;
                obtainMessage.arg1 = downloadBean.isPreDownload() ? 1 : 0;
                obtainMessage.sendToTarget();
            }
        }
        a.a aVar = a.a;
        String str = "onStatusChanged，name = " + (downloadBean != null ? downloadBean.getTotalTitleName() : null) + ",status =" + (downloadBean != null ? Integer.valueOf(downloadBean.getStatus()) : null) + ",  progress:" + (downloadBean != null ? Long.valueOf(downloadBean.getProgress()) : null) + ", size:" + (downloadBean != null ? downloadBean.getSize() : null) + ", " + downloadBean;
        boolean z = false;
        if (downloadBean != null && downloadBean.isDownloading()) {
            z = true;
        }
        aVar.c("DownloadImp-ResponseImpl", str, !z);
    }

    public void b(DownloadBean downloadBean, DownloadException downloadException) {
        g gVar;
        if (downloadBean != null) {
            downloadBean.setStatus(6);
        }
        if (this.c == 6) {
            if (Intrinsics.c(this.d, downloadBean != null ? downloadBean.getResourceId() : null)) {
                a.a.f(a.a, "DownloadImp-ResponseImpl", "handleException, intercept", false, 4, (Object) null);
                return;
            }
        }
        this.c = 6;
        this.d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            downloadBean.setException(downloadException);
        }
        if (downloadBean != null) {
            h(downloadBean);
            if (ThreadUtils.i()) {
                j(downloadBean, downloadBean.getStatus(), downloadBean.isPreDownload());
            } else {
                Message obtainMessage = this.e.obtainMessage(6);
                Intrinsics.g(obtainMessage, "obtainMessage(...)");
                obtainMessage.obj = downloadBean;
                obtainMessage.arg1 = downloadBean.isPreDownload() ? 1 : 0;
                obtainMessage.sendToTarget();
            }
        }
        a.a.w("download", "handleException: code = " + (downloadException != null ? Integer.valueOf(downloadException.getCode()) : null) + ",responseCode = " + (downloadException != null ? Integer.valueOf(downloadException.getResponseCode()) : null) + ", msg = " + (downloadException != null ? downloadException.getLocalizedMessage() : null), true);
        if (downloadBean == null || (gVar = this.g) == null) {
            return;
        }
        gVar.u(downloadBean);
    }
}
