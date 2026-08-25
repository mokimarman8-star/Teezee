package com.transsnet.downloader.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.t;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.n;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.push.bean.MsgType;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.push.utils.u;
import com.transsion.ugcvideodetail.api.UGCPageStyle;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.guard.DownloadGuard;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.manager.p;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import m.c;
import m.f;
import org.mvel2.ast.ASTNode;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadNotificationUtils {
    private static int e;
    public static final DownloadNotificationUtils a = new DownloadNotificationUtils();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.notification.a
        public final Object invoke() {
            g r;
            r = DownloadNotificationUtils.r();
            return r;
        }
    });
    private static boolean c = true;
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.notification.b
        public final Object invoke() {
            NotificationManager F;
            F = DownloadNotificationUtils.F();
            return F;
        }
    });
    private static String f = "";

    private DownloadNotificationUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManager B() {
        return (NotificationManager) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent C(to.a aVar, int i, DownloadBean downloadBean, int i2) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Intent a3 = aVar.a(a2);
        a3.putExtra("extra_notification_id", i);
        a3.putExtra("extra_source", "push");
        a3.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a3.putExtra("extra_message_id", sb.toString());
        a3.addFlags(603979776);
        a3.setAction("android.intent.action.VIEW");
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        if (downloadBean.isShotTV()) {
            if (downloadBean.isUGCVideo()) {
                sb2.append("/ugc_video/detail");
                sb2.append("&");
                sb2.append("id");
                sb2.append("=");
                sb2.append(downloadBean.getUgcVideoId());
                sb2.append("&");
                sb2.append("videoStyle");
                sb2.append("=");
                sb2.append(UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue());
                sb2.append("&");
                sb2.append("id");
                sb2.append("=");
                sb2.append(downloadBean.getUgcVideoId());
                sb2.append("&");
                sb2.append("collection_id");
                sb2.append("=");
                sb2.append(downloadBean.getUgcVideoCollectionId());
                sb2.append("&");
                sb2.append("ops");
                sb2.append("=");
                sb2.append(downloadBean.getOps());
            } else {
                sb2.append(pr.a.a.b());
                sb2.append("&");
                sb2.append("id");
                sb2.append("=");
                sb2.append(downloadBean.getSubjectId());
                sb2.append("&");
                sb2.append("ep");
                sb2.append("=");
                sb2.append(downloadBean.getEp());
                sb2.append("&");
                sb2.append("ops");
                sb2.append("=");
                sb2.append(downloadBean.getOps());
            }
        } else if (!downloadBean.isUGCVideo()) {
            sb2.append("/video/detail");
            sb2.append("&");
            sb2.append("extra_local_path");
            sb2.append("=");
            sb2.append(downloadBean.getPath());
            sb2.append("&");
            sb2.append("extra_name");
            sb2.append("=");
            sb2.append(downloadBean.getName());
            sb2.append("&");
            sb2.append("extra_resource_id");
            sb2.append("=");
            sb2.append(downloadBean.getResourceId());
            sb2.append("&");
            sb2.append("extra_post_id");
            sb2.append("=");
            sb2.append(downloadBean.getPostId());
            sb2.append("&");
            sb2.append("extra_subject_id");
            sb2.append("=");
            sb2.append(downloadBean.getSubjectId());
            sb2.append("&");
            sb2.append("extra_page_from");
            sb2.append("=");
            sb2.append("push");
            sb2.append("&");
            sb2.append("extra_is_series");
            sb2.append("=");
            sb2.append(downloadBean.isSeries());
        } else if (downloadBean.getUgcVideoIsVertical()) {
            sb2.append("/ugc_video/detail");
            sb2.append("&");
            sb2.append("id");
            sb2.append("=");
            sb2.append(downloadBean.getUgcVideoId());
            sb2.append("&");
            sb2.append("videoStyle");
            sb2.append("=");
            sb2.append(UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue());
            sb2.append("&");
            sb2.append("resource_id");
            sb2.append("=");
            sb2.append(downloadBean.getResourceId());
            sb2.append("&");
            sb2.append("ops");
            sb2.append("=");
            sb2.append(downloadBean.getOps());
        } else {
            sb2.append("/ugc_video/local_detail");
            sb2.append("&");
            sb2.append("id");
            sb2.append("=");
            sb2.append(downloadBean.getUgcVideoId());
            sb2.append("&");
            sb2.append("resource_id");
            sb2.append("=");
            sb2.append(downloadBean.getResourceId());
            sb2.append("&");
            sb2.append("ops");
            sb2.append("=");
            sb2.append(downloadBean.getOps());
        }
        a3.setData(Uri.parse(sb2.toString()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a3, i2);
        Intrinsics.g(activity, "getActivity(...)");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String D(int i) {
        Application a2 = Utils.a();
        if (i == 3) {
            String string = a2.getString(R$string.notification_download_waiting);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (i == 4) {
            String string2 = a2.getString(R$string.notification_download_paused);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (i == 5) {
            String string3 = a2.getString(R$string.notification_download_success);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        if (i != 6) {
            return "";
        }
        String string4 = a2.getString(R$string.notification_download_failed);
        Intrinsics.g(string4, "getString(...)");
        return string4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager F() {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(DownloadBean downloadBean) {
        if (downloadBean.getLastPlayTimeStamp() == 0) {
            String string = Utils.a().getString(R$string.notification_download_complete);
            Intrinsics.g(string, "getString(...)");
            String string2 = Utils.a().getString(R$string.notification_download_watch_tip, v(downloadBean));
            Intrinsics.g(string2, "getString(...)");
            o(downloadBean, false, string, string2);
            return;
        }
        Long duration = downloadBean.getDuration();
        if (duration != null) {
            if (duration.longValue() <= 0 || ((downloadBean.getReadProgress() * 1.0f) / r6) * 1.0f >= 0.8d) {
                return;
            }
            String string3 = Utils.a().getString(R$string.notification_continue_watching);
            Intrinsics.g(string3, "getString(...)");
            Application a2 = Utils.a();
            int i = R$string.notification_download_continue_tip;
            DownloadNotificationUtils downloadNotificationUtils = a;
            String string4 = a2.getString(i, downloadNotificationUtils.v(downloadBean));
            Intrinsics.g(string4, "getString(...)");
            downloadNotificationUtils.o(downloadBean, false, string3, string4);
        }
    }

    private final void l(int i) {
        B().cancel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        boolean f2 = c0.f(u.a.b().getLong("download_play_notification_time", 0L));
        int i = Calendar.getInstance().get(11);
        return 19 <= i && i < 21 && !f2;
    }

    private final void o(DownloadBean downloadBean, boolean z, String str, String str2) {
        try {
            RequestBuilder diskCacheStrategy = Glide.with(Utils.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA);
            NotificationUtil notificationUtil = NotificationUtil.a;
            String cover = downloadBean.getCover();
            if (cover == null) {
                cover = "";
            }
            Intrinsics.e(diskCacheStrategy.load(NotificationUtil.K(notificationUtil, cover, 0, 2, null)).into(new a(downloadBean, z, str, str2)));
        } catch (Exception unused) {
            a.a.f(wf.a.a, "DownloadNotificationUtils", "onFailure", false, 4, (Object) null);
        }
    }

    static /* synthetic */ void p(DownloadNotificationUtils downloadNotificationUtils, DownloadBean downloadBean, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        downloadNotificationUtils.o(downloadBean, z, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(DownloadBean downloadBean) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g r() {
        return p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent s(to.a aVar, int i, DownloadBean downloadBean, int i2) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Intent a3 = aVar.a(a2);
        a3.putExtra("extra_notification_id", i);
        a3.putExtra("extra_source", "push");
        a3.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a3.putExtra("extra_message_id", sb.toString());
        a3.addFlags(603979776);
        a3.setAction("android.intent.action.VIEW");
        a3.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail&id=" + downloadBean.getSubjectId() + "&autoPlay=true&resourceId=" + downloadBean.getResourceId()));
        return PendingIntent.getActivity(Utils.a(), 0, a3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent t(to.a aVar, int i, DownloadBean downloadBean, int i2) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Intent a3 = aVar.a(a2);
        a3.putExtra("extra_notification_id", i);
        a3.putExtra("extra_source", "push");
        a3.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a3.putExtra("extra_message_id", sb.toString());
        a3.addFlags(603979776);
        a3.setAction("android.intent.action.VIEW");
        a3.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity&download_notify=10&download_status=" + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a3, i2);
        Intrinsics.g(activity, "getActivity(...)");
        return activity;
    }

    private final int u() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_other_status : R$layout.notification_other_status_v12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v(DownloadBean downloadBean) {
        return (downloadBean.isSeries() ? downloadBean.getSubjectName() : downloadBean.getName()) + " " + (downloadBean.getEpse() > 0 ? downloadBean.getEp() > 0 ? n.b(downloadBean.getEp(), downloadBean.getSe(), downloadBean.isVideo()) : n.c(downloadBean.getEpse(), downloadBean.isVideo()) : "");
    }

    private final int w() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_downloading : R$layout.notification_downloading_v12;
    }

    private final NotificationCompat.m y(int i, DownloadBean downloadBean) {
        Long size;
        int i2 = Build.VERSION.SDK_INT >= 31 ? ASTNode.ARRAY_TYPE_LITERAL : ASTNode.NOJIT;
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        if (aVar == null) {
            return null;
        }
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        Intent a3 = aVar.a(a2);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        a3.putExtra("extra_notification_id", sb.toString());
        a3.putExtra("extra_source", "push");
        a3.putExtra("MESSAGE_TYPE", MsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        a3.putExtra("extra_message_id", sb2.toString());
        a3.addFlags(603979776);
        a3.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity&download_notify=10&download_status=" + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a3, i2);
        String v = v(downloadBean);
        long j = 0;
        long progress = downloadBean.getProgress() < 0 ? 0L : downloadBean.getProgress();
        Long size2 = downloadBean.getSize();
        if ((size2 != null ? size2.longValue() : 0L) >= 0 && (size = downloadBean.getSize()) != null) {
            j = size.longValue();
        }
        int progress2 = (int) (((downloadBean.getProgress() * 1.0f) / (downloadBean.getSize() != null ? r4.longValue() : 1L)) * 100);
        if (progress2 > 100) {
            progress2 = 100;
        }
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), w());
        remoteViews.setProgressBar(R$id.progress, 100, progress2, false);
        remoteViews.setTextViewText(R$id.tv_name, v);
        remoteViews.setTextViewText(R$id.tv_size, zg.b.a(progress, 1) + "/" + zg.b.a(j, 1));
        NotificationCompat.m s = new NotificationCompat.m(Utils.a(), "download_service").J(R$drawable.push_small_logo).r(D(downloadBean.getStatus())).q(v).p(activity).l(false).t(remoteViews).s(remoteViews);
        Intrinsics.g(s, "setCustomBigContentView(...)");
        return s;
    }

    public final int A(String str, String str2) {
        Intrinsics.h(str, "url");
        if (str2 == null) {
            str2 = str;
        }
        int abs = Math.abs(str2.hashCode());
        return abs <= 0 ? Math.abs(str.hashCode()) : abs;
    }

    public final void E() {
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            c.a(B(), f.a("download_service", Utils.a().getString(R$string.download_notifications_name), 2));
            g0.a();
            c.a(B(), f.a("download_service_high", Utils.a().getString(R$string.download_success_notifications_name), 4));
        }
    }

    public final void G() {
        if (m()) {
            x();
        } else {
            NotificationUtil.a.W(new b());
        }
    }

    public final void I(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        int z = z(downloadBean);
        int i = z + 1;
        int status = downloadBean.getStatus();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        if (!downloadBean.isDownloading()) {
            a.a aVar = wf.a.a;
            a.a.f(aVar, "download_notify", "updateCustomView, status = " + status + "， name = " + downloadBean.getTotalTitleName(), false, 4, (Object) null);
            if (e == status && Intrinsics.c(f, resourceId)) {
                a.a.f(aVar, "download_notify", "updateCustomView, return", false, 4, (Object) null);
                return;
            }
        }
        e = status;
        f = resourceId;
        if (status == 3) {
            l(z);
            B().cancel(i);
            return;
        }
        a.a aVar2 = wf.a.a;
        a.a.f(aVar2, "download_notify", "updateCustomView--- 2, status = " + status + "， name = " + downloadBean.getTotalTitleName(), false, 4, (Object) null);
        DownloadGuard.a.p(downloadBean);
        if (status == 6 && (downloadBean.isNoNetError() || !l.a.e())) {
            a.a.f(aVar2, "download_notify", "updateCustomView--- 无网错误不出通知", false, 4, (Object) null);
            l(z);
            B().cancel(i);
            return;
        }
        String v = v(downloadBean);
        if (status == 1 || status == 2) {
            B().cancel(i);
            return;
        }
        if (status == 5) {
            p(this, downloadBean, false, null, null, 14, null);
            return;
        }
        if (status == 7 || status == 57) {
            l(z);
            B().cancel(i);
            return;
        }
        l(z);
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), u());
        remoteViews.setTextViewText(R$id.tv_status, D(downloadBean.getStatus()));
        remoteViews.setTextViewText(R$id.tv_name, v);
        NotificationCompat.m y = y(i, downloadBean);
        if (y != null) {
            try {
                y.l(true);
                y.t(remoteViews).s(remoteViews);
                a.a.v(aVar2, "download_notify", "updateCustomView--- 3, status = " + status + "， name = " + downloadBean.getTotalTitleName(), false, 4, (Object) null);
                t.b(Utils.a()).d(i, y.c());
            } catch (Throwable unused) {
            }
        }
    }

    public final void n(DownloadBean downloadBean) {
        String value;
        Boolean m1;
        Intrinsics.h(downloadBean, "downloadInfo");
        boolean z = false;
        ConfigBean c2 = cm.f.c.a().c("download_foreground_service", false);
        if (c2 != null && (value = c2.getValue()) != null && (m1 = StringsKt.m1(value)) != null) {
            z = m1.booleanValue();
        }
        c = z;
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new createNotification.1(downloadBean, (Continuation) null), 3, (Object) null);
    }

    public final void x() {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new getLatestDownloadVideo.1((Continuation) null), 3, (Object) null);
    }

    public final int z(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadInfo");
        return A(downloadBean.getUrl(), downloadBean.getResourceId());
    }
}
