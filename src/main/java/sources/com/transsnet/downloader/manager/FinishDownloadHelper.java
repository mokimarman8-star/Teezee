package com.transsnet.downloader.manager;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.fragment.DownloadedShortsDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FinishDownloadHelper extends ui.a {
    private final String a = "FinishDownloadHelper";
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.v
        public final Object invoke() {
            cx.a o;
            o = FinishDownloadHelper.o();
            return o;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.w
        public final Object invoke() {
            kk.a l;
            l = FinishDownloadHelper.l();
            return l;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final kk.a l() {
        return (kk.a) TheRouter.d(kk.a.class, new Object[0]);
    }

    private final kk.a m() {
        return (kk.a) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cx.a n() {
        return (cx.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a o() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    private final void p(DownloadBean downloadBean) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null && (resourceId = downloadBean.getPostId()) == null) {
            resourceId = downloadBean.getUrl();
        }
        if (resourceId == null || resourceId.length() == 0) {
            return;
        }
        String str = "SHORTS_DIALOG_SHOWN_" + resourceId;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (bVar.b().getBoolean(str, false)) {
            return;
        }
        Activity b = com.blankj.utilcode.util.a.b();
        if (com.blankj.utilcode.util.c.j() && (b instanceof FragmentActivity)) {
            FragmentActivity fragmentActivity = (FragmentActivity) b;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) b).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                DialogFragment k0 = supportFragmentManager.k0("DownloadedShortsDialog");
                if (k0 instanceof DialogFragment) {
                    k0.dismissAllowingStateLoss();
                }
                DownloadedShortsDialog.e.a(resourceId).k0(b, "DownloadedShortsDialog");
                com.transsion.baselib.helper.a.a.c("", "short_download_view");
                bVar.b().putBoolean(str, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e(DownloadBean downloadBean, String str) {
        Intrinsics.h(downloadBean, "bean");
        super.e(downloadBean, str);
        kk.a m = m();
        if (m != null && m.enable()) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new onDownloadSuccess.1(downloadBean, this, (Continuation) null), 3, (Object) null);
        }
        if (downloadBean.isShorts()) {
            p(downloadBean);
        }
    }
}
