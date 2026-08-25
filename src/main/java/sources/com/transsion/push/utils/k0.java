package com.transsion.push.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.R$drawable;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.service.PushServiceHelper;
import com.transsion.push.tracker.Tracker;
import com.transsion.pushui.activity.TransparentActivity;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class k0 {
    public static void a(PushMessage pushMessage) {
        if (pushMessage == null) {
            return;
        }
        PushNotification d = j.d(pushMessage.notiType, pushMessage.layoutStyleId);
        String str = pushMessage.channelId;
        try {
            if (TextUtils.isEmpty(str)) {
                str = d.getChannelId();
            }
            if (TextUtils.isEmpty(str)) {
                str = BuildConfig.FLAVOR;
            }
        } catch (Exception unused) {
        }
        pushMessage.channelId = str;
    }

    public static PendingIntent b(Context context, PushMessage pushMessage) {
        Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
        intent.setPackage(context.getPackageName());
        intent.putExtra("message", com.transsion.json.b.b(pushMessage));
        intent.putExtra(PushConstants.EXTRA_PUSH_NOTI_CLICK, true);
        return PendingIntent.getActivity(context, UUID.randomUUID().hashCode(), intent, 67108864);
    }

    public static int c() {
        return 0;
    }

    public static String d() {
        if (PushManager.getInstance().getTestEnv()) {
            return PushConstants.BASE_TEST_URL_V2;
        }
        if (PushManager.getInstance().getDebug()) {
            return PushConstants.BASE_DEBUG_URL_V2;
        }
        try {
            String domain = GslbSdk.getDomain(PushConstants.BASE_RELEASE_URL_V2, false);
            if (TextUtils.isEmpty(domain)) {
                PushLogUtils.LOG.g("gslb domain is empty");
                return BuildConfig.FLAVOR;
            }
            PushLogUtils.LOG.g("gslb domain is" + domain);
            return domain;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static boolean e() {
        return false;
    }

    public static void f(String[] strArr, int i) {
    }

    public static void g(PushMessage pushMessage, HashMap hashMap) {
        Context context;
        boolean z;
        try {
            context = yj.a.a();
        } catch (Exception unused) {
            context = null;
        }
        if (context == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, true, 2, pushMessage);
            return;
        }
        boolean isOpenNotification = NotificationAssistUtils.isOpenNotification(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, isOpenNotification, 3, pushMessage);
            return;
        }
        a(pushMessage);
        Notification.Builder e = s.e(context, pushMessage);
        if (e == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, isOpenNotification, 4, pushMessage);
            return;
        }
        Notification j = j(context, pushMessage, hashMap, e);
        if (j == null) {
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, isOpenNotification, 5, pushMessage);
            return;
        }
        try {
            String str = TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId;
            String str2 = TextUtils.isEmpty(pushMessage.channelName) ? "cloud messaging" : pushMessage.channelName;
            int i = Build.VERSION.SDK_INT;
            int i2 = 0;
            if (i >= 26) {
                if (TextUtils.isEmpty(pushMessage.floatNotice) || !pushMessage.floatNotice.equals(MsgStyle.CUSTOM_LEFT_PIC)) {
                    z = false;
                } else {
                    str = "headup";
                    str2 = "head up messaging";
                    PushLogUtils.LOG.g("float notice");
                    z = true;
                }
                androidx.media3.common.util.g0.a();
                NotificationChannel a = m.f.a(str, str2, z ? 4 : 3);
                if (z) {
                    a.setShowBadge(true);
                    a.setLockscreenVisibility(1);
                    if (i >= 36 && !TextUtils.isEmpty(pushMessage.floatNotice) && pushMessage.floatNotice.equals(MsgStyle.CUSTOM_LEFT_PIC)) {
                        e.setGroup("float_" + pushMessage.messageId);
                    }
                }
                PushLogUtils.LOG.g("message.channelId" + pushMessage.channelId + pushMessage.channelName);
                m.c.a(notificationManager, a);
            }
            PushServiceHelper.c(pushMessage, notificationManager);
            notificationManager.notify((int) pushMessage.messageId, j);
            Tracker tracker = Tracker.getInstance();
            long j2 = pushMessage.messageId;
            int i3 = pushMessage.type;
            String str3 = pushMessage.timeStamp;
            if (!isOpenNotification) {
                i2 = 6;
            }
            tracker.trackShow(j2, i3, str3, isOpenNotification, i2, pushMessage);
            if (PushManager.getInstance().getPushListener() != null) {
                PushManager.getInstance().getPushListener().onNotificationShow(pushMessage.messageId, pushMessage.notiOpenContent);
            }
        } catch (Exception e2) {
            PushLogUtils.LOG.i(e2);
            Tracker.getInstance().trackShow(pushMessage.messageId, pushMessage.type, pushMessage.timeStamp, isOpenNotification, 7, pushMessage);
        }
    }

    public static void h(PushRequest.ReportContentData reportContentData) {
    }

    private static void i(Notification.Builder builder, PushMessage pushMessage) {
        try {
            if (!TextUtils.isEmpty(pushMessage.iconColor)) {
                builder.setColor(Color.parseColor(pushMessage.iconColor));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PushNotification d = j.d(pushMessage.notiType, pushMessage.layoutStyleId);
        try {
            if (TextUtils.isEmpty(d.getIconColor())) {
                return;
            }
            builder.setColor(Color.parseColor(d.getIconColor()));
        } catch (Exception unused) {
        }
    }

    public static Notification j(Context context, PushMessage pushMessage, HashMap hashMap, Notification.Builder builder) {
        if (pushMessage == null || builder == null) {
            return null;
        }
        PushNotification d = j.d(pushMessage.notiType, pushMessage.layoutStyleId);
        if (hashMap != null && hashMap.get(pushMessage.notiSmallIcon) != null) {
            builder.setSmallIcon(Icon.createWithBitmap((Bitmap) hashMap.get(pushMessage.notiSmallIcon)));
        } else if (d == null || d.getSmallIcon() <= 0) {
            builder.setSmallIcon(R$drawable.tpush_notify_icon);
        } else {
            builder.setSmallIcon(d.getSmallIcon());
        }
        if (hashMap != null && hashMap.get(pushMessage.notiOptionalIcon) != null) {
            builder.setLargeIcon(Icon.createWithBitmap((Bitmap) hashMap.get(pushMessage.notiOptionalIcon)));
        }
        i(builder, pushMessage);
        if (pushMessage.notiType == 1) {
            builder.setContentTitle(pushMessage.notiTitle).setContentText(pushMessage.notiDes);
            int i = pushMessage.notiExType;
            if (i == 2) {
                builder.setStyle(new Notification.BigTextStyle().bigText(pushMessage.notiTxtEx));
            } else if (i == 3 && hashMap != null && hashMap.get(pushMessage.notiImgEx) != null) {
                builder.setLargeIcon((Bitmap) hashMap.get(pushMessage.notiImgEx));
                builder.setStyle(new Notification.BigPictureStyle().bigPicture((Bitmap) hashMap.get(pushMessage.notiImgEx)).bigLargeIcon((Bitmap) null));
            }
            builder.setContentIntent(b(yj.a.a(), pushMessage));
            return builder.build();
        }
        RemoteViews e = j.e(context, pushMessage, hashMap, false);
        if (e == null) {
            return builder.build();
        }
        builder.setContentTitle(pushMessage.notiTitle);
        builder.setContentText(pushMessage.notiDes);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            builder.setCustomContentView(e);
        } else {
            builder.setContent(e);
        }
        if (i2 >= 31) {
            builder.setStyle(h0.a());
            builder.setCustomBigContentView(j.b(context, pushMessage, hashMap, false));
        }
        return builder.build();
    }
}
