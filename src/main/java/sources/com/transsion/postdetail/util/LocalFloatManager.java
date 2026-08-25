package com.transsion.postdetail.util;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p003enum.PlayMimeType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalFloatManager extends com.transsion.videofloat.manager.b {
    public static final LocalFloatManager b = new LocalFloatManager();

    private LocalFloatManager() {
    }

    private final DownloadBean c(dw.a aVar) {
        Object obj;
        String p;
        Iterator it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((DownloadBean) obj).getResourceId(), aVar != null ? aVar.p() : null)) {
                break;
            }
        }
        DownloadBean downloadBean = (DownloadBean) obj;
        if (downloadBean != null) {
            return downloadBean;
        }
        if (aVar == null || (p = aVar.p()) == null) {
            return null;
        }
        return DownloadEsHelper.m.a().q(p);
    }

    private final StringBuilder d(DownloadBean downloadBean) {
        StringBuilder sb = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb.append("/video/detail");
        sb.append("&");
        sb.append("extra_resource_id");
        sb.append("=");
        sb.append(downloadBean.getResourceId());
        sb.append("&");
        sb.append("extra_local_path");
        sb.append("=");
        sb.append(downloadBean.getPath());
        sb.append("&");
        sb.append("extra_url");
        sb.append("=");
        sb.append(downloadBean.getUrl());
        sb.append("&");
        sb.append("extra_page_from");
        sb.append("=");
        sb.append("media_notification");
        sb.append("&");
        sb.append("extra_completed");
        sb.append("=");
        sb.append(downloadBean.isCompleted());
        Intrinsics.g(sb, "append(...)");
        return sb;
    }

    private final MediaItem e(DownloadBean downloadBean) {
        String titleName = downloadBean.getTitleName();
        String subjectId = downloadBean.getSubjectId();
        return new MediaItem(titleName, BuildConfig.FLAVOR, downloadBean.getCover(), null, null, null, f(downloadBean), null, subjectId, downloadBean.getResourceId(), Boolean.FALSE, null, null, null, 14520, null);
    }

    private final PendingIntent f(DownloadBean downloadBean) {
        Intent intent;
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        StringBuilder d = d(downloadBean);
        if (aVar != null) {
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            intent = aVar.a(a);
            if (intent != null) {
                intent.addFlags(603979776);
                intent.setData(Uri.parse(d.toString()));
                return PendingIntent.getActivity(Utils.a(), 0, intent, g());
            }
        }
        intent = null;
        return PendingIntent.getActivity(Utils.a(), 0, intent, g());
    }

    private final int g() {
        return Build.VERSION.SDK_INT >= 31 ? 67108864 : 134217728;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(dw.a aVar) {
        LocalFloatManager localFloatManager = b;
        DownloadBean c = localFloatManager.c(aVar);
        if (c != null) {
            localFloatManager.i();
            StringBuilder d = localFloatManager.d(c);
            wf.a.a.i("VideoFloat", localFloatManager.getClass().getSimpleName() + " open page deeplink:" + ((Object) d), true);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(d.toString()));
            intent.setFlags(268435456);
            Utils.a().startActivity(intent);
        } else {
            a.a.l(wf.a.a, "video_float", localFloatManager.getClass().getSimpleName() + " getCurPlayingBean null", false, 4, (Object) null);
        }
        return Unit.a;
    }

    private final void n(dw.a aVar, Function0 function0) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LocalFloatManager$saveHistoryInner$1(aVar, function0, null), 3, (Object) null);
    }

    static /* synthetic */ void o(LocalFloatManager localFloatManager, dw.a aVar, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        localFloatManager.n(aVar, function0);
    }

    public final String h(String str) {
        Intrinsics.h(str, "tag");
        return "LOCAL" + str;
    }

    public void i() {
        a().clear();
    }

    public void j(final dw.a aVar) {
        wf.a.a.c("VideoFloat", LocalFloatManager.class.getSimpleName() + " --- openDetail", true);
        n(aVar, new Function0() { // from class: com.transsion.postdetail.util.a
            public final Object invoke() {
                Unit k;
                k = LocalFloatManager.k(aVar);
                return k;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(dw.a aVar) {
        DownloadBean downloadBean;
        String h;
        String str;
        String path;
        Iterator it = a().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            DownloadBean downloadBean2 = (DownloadBean) it.next();
            if (aVar != null && downloadBean2.getEp() == aVar.c()) {
                break;
            }
            i++;
        }
        int size = a().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                downloadBean = null;
                break;
            }
            downloadBean = (DownloadBean) a().get(i2);
            if (i2 > i && downloadBean.getCanPlay() && (!downloadBean.isCompleted() || downloadBean.isFileExist())) {
                break;
            }
            i2++;
        }
        if (downloadBean == null) {
            return false;
        }
        boolean isCompleted = downloadBean.isCompleted();
        String str2 = BuildConfig.FLAVOR;
        if (isCompleted) {
            h = downloadBean.getPath();
            if (h == null) {
                str = BuildConfig.FLAVOR;
                a.a aVar2 = wf.a.a;
                Integer valueOf = aVar != null ? Integer.valueOf(aVar.c()) : null;
                aVar2.c("VideoFloat", "local----playNext , ep:" + valueOf + ", nextEp:" + downloadBean.getEp(), true);
                path = downloadBean.getPath();
                if (path != null) {
                    str2 = path;
                }
                gn.e eVar = new gn.e(String.valueOf(str2.hashCode()), str, 0, PlayMimeType.DEFAULT, e(downloadBean), 4, null);
                if (aVar != null) {
                    aVar.z(downloadBean.getEp());
                    aVar.H(downloadBean.getSe());
                    aVar.G(downloadBean.getResourceId());
                    aVar.F(0L);
                    aVar.f().clearScreen();
                    aVar.f().stop();
                    aVar.f().reset();
                    aVar.f().setDataSource(eVar);
                    aVar.f().prepare();
                    aVar.f().play();
                }
                return true;
            }
        } else {
            h = com.transsnet.downloader.manager.p.a.a(Utils.a()).h(downloadBean);
        }
        str = h;
        a.a aVar22 = wf.a.a;
        if (aVar != null) {
        }
        aVar22.c("VideoFloat", "local----playNext , ep:" + valueOf + ", nextEp:" + downloadBean.getEp(), true);
        path = downloadBean.getPath();
        if (path != null) {
        }
        gn.e eVar2 = new gn.e(String.valueOf(str2.hashCode()), str, 0, PlayMimeType.DEFAULT, e(downloadBean), 4, null);
        if (aVar != null) {
        }
        return true;
    }

    public void m(dw.a aVar) {
        o(this, aVar, null, 2, null);
    }

    public void p(List list) {
        Intrinsics.h(list, "list");
        a().clear();
        a().addAll(list);
    }
}
