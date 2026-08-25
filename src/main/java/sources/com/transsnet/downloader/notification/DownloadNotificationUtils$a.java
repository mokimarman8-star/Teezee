package com.transsnet.downloader.notification;

import android.app.Application;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.t;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.lib.push.R;
import com.transsion.push.utils.u;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadNotificationUtils$a extends CustomTarget {
    final /* synthetic */ DownloadBean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    DownloadNotificationUtils$a(DownloadBean downloadBean, boolean z, String str, String str2) {
        this.a = downloadBean;
        this.b = z;
        this.c = str;
        this.d = str2;
    }

    public void onLoadCleared(Drawable drawable) {
        a.a.f(a.a, "download_notify", "onFailure", false, 4, (Object) null);
    }

    public void onResourceReady(Bitmap resource, Transition transition) {
        NotificationCompat.m t;
        Intrinsics.h(resource, "resource");
        a.a.f(a.a, "download_notify", "onSuccess", false, 4, (Object) null);
        int i = Build.VERSION.SDK_INT;
        int i2 = i >= 31 ? 67108864 : 134217728;
        DownloadNotificationUtils downloadNotificationUtils = DownloadNotificationUtils.a;
        int z = downloadNotificationUtils.z(this.a);
        int i3 = z + 1;
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        if (aVar != null) {
            String g = DownloadNotificationUtils.g(downloadNotificationUtils, this.a);
            int status = this.a.getStatus();
            PendingIntent f = DownloadNotificationUtils.f(downloadNotificationUtils, aVar, i3, this.a, i2);
            PendingIntent e = this.a.getType() == 1 ? DownloadNotificationUtils.e(downloadNotificationUtils, aVar, i3, this.a, i2) : DownloadNotificationUtils.i(downloadNotificationUtils, aVar, i3, this.a, i2);
            String j = this.b ? DownloadNotificationUtils.j(downloadNotificationUtils, status) : this.c;
            if (!this.b) {
                g = this.d;
            }
            String str = g;
            if (i >= 31) {
                RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), R.layout.push_notification_custom_left_pic_s_small);
                remoteViews.setTextViewText(R.id.notification_title_tv, j);
                remoteViews.setTextViewText(R.id.notification_content_tv, str);
                remoteViews.setImageViewResource(R.id.iv_icon, com.tn.lib.widget.R.mipmap.icon_play_white);
                remoteViews.setTextViewText(R.id.tv_tips, Utils.a().getString(com.transsion.baseui.R.string.play));
                remoteViews.setOnClickPendingIntent(R.id.ll_download, e);
                int dimension = (int) Utils.a().getResources().getDimension(R.dimen.push_notification_transition_rectangle_img_width);
                int dimension2 = (int) Utils.a().getResources().getDimension(R.dimen.push_notification_transition_rectangle_img_height);
                com.transsion.push.utils.a aVar2 = com.transsion.push.utils.a.a;
                Application a = Utils.a();
                Intrinsics.g(a, "getApp(...)");
                Bitmap f2 = com.transsion.push.utils.a.f(aVar2, a, resource, dimension, dimension2, false, 0, 32, (Object) null);
                RemoteViews remoteViews2 = new RemoteViews(Utils.a().getPackageName(), R.layout.push_notification_custom_left_pic_s_big);
                remoteViews2.setTextViewText(R.id.notification_title_tv, j);
                remoteViews2.setTextViewText(R.id.notification_content_tv, str);
                remoteViews2.setImageViewBitmap(R.id.notification_content_image, f2);
                remoteViews2.setImageViewResource(R.id.iv_icon, com.tn.lib.widget.R.mipmap.icon_play_white);
                remoteViews2.setTextViewText(R.id.tv_tips, Utils.a().getString(com.transsion.baseui.R.string.play));
                remoteViews2.setOnClickPendingIntent(R.id.ll_download, e);
                t = new NotificationCompat.m(Utils.a(), "download_service").J(com.tn.lib.widget.R.drawable.push_small_logo).r(j).q(str).p(f).l(true).t(remoteViews).s(remoteViews2);
            } else {
                RemoteViews remoteViews3 = new RemoteViews(Utils.a().getPackageName(), R.layout.push_notification_custom_left_pic);
                remoteViews3.setTextViewText(R.id.notification_title_tv, j);
                remoteViews3.setTextViewText(R.id.notification_content_tv, str);
                remoteViews3.setImageViewBitmap(R.id.notification_content_image, resource);
                remoteViews3.setImageViewResource(R.id.iv_icon, com.tn.lib.widget.R.mipmap.icon_play_white);
                remoteViews3.setTextViewText(R.id.tv_tips, Utils.a().getString(com.transsion.baseui.R.string.play));
                remoteViews3.setOnClickPendingIntent(R.id.ll_download, e);
                remoteViews3.setLong(R.id.time, "setTime", System.currentTimeMillis());
                t = new NotificationCompat.m(Utils.a(), "download_service_high").J(com.tn.lib.widget.R.drawable.push_small_logo).p(f).r(j).q(str).l(true).t(remoteViews3);
            }
            Intrinsics.e(t);
            DownloadNotificationUtils.h(downloadNotificationUtils).cancel(z);
            try {
                Result$Companion result$Companion = Result.Companion;
                t.b(Utils.a()).d(i3, t.c());
                Result.constructor-impl(Unit.a);
            } catch (Throwable th) {
                Result$Companion result$Companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th));
            }
            if (this.b) {
                return;
            }
            u.a.b().putLong("download_play_notification_time", System.currentTimeMillis());
        }
    }
}
