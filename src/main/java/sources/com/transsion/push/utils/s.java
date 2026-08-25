package com.transsion.push.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PushExtButtonList;
import com.transsion.push.bean.PushExtensionBtn;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.tracker.Tracker;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s {
    public static void a(long j) {
        try {
            NotificationManager notificationManager = (NotificationManager) yj.a.a().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            notificationManager.cancel((int) j);
        } catch (Exception unused) {
        }
    }

    private static PushMessage b(PushMessage pushMessage, int i, String str) {
        PushMessage pushMessage2 = new PushMessage();
        pushMessage2.setMessageId(pushMessage.messageId);
        pushMessage2.setChannelName(pushMessage.channelName);
        pushMessage2.setNotiOpenType(i);
        pushMessage2.setNotiOpenContent(str);
        pushMessage2.setPackageName(pushMessage.packageName);
        return pushMessage2;
    }

    private static List c(PushMessage pushMessage) {
        if (TextUtils.isEmpty(pushMessage.notiExtensionBtn)) {
            return null;
        }
        try {
            PushExtButtonList pushExtButtonList = (PushExtButtonList) com.transsion.json.b.a(pushMessage.notiExtensionBtn, PushExtButtonList.class);
            if (pushExtButtonList.list.size() == 0) {
                return null;
            }
            return pushExtButtonList.list;
        } catch (Exception e) {
            PushLogUtils.LOG.i(e);
            return null;
        }
    }

    private static PushMessage d(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return (PushMessage) com.transsion.json.b.a(intent.getStringExtra("message"), PushMessage.class);
        } catch (Exception unused) {
            PushLogUtils.LOG.i("Notification service message is empty");
            return null;
        }
    }

    public static Notification.Builder e(Context context, PushMessage pushMessage) {
        Notification.Builder builder;
        if (pushMessage == null) {
            PushLogUtils.LOG.i("Get the notification object, the message is empty");
            return null;
        }
        int i = pushMessage.notiType;
        if (i != 1 && i != 3) {
            PushLogUtils.LOG.i("Notification type is not supported，notiType:" + pushMessage.notiType);
            return null;
        }
        int i2 = pushMessage.notiExType;
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            PushLogUtils.LOG.i("Notification expansion type is not supported，notiExType:" + pushMessage.notiExType);
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            r.a();
            builder = q.a(context, TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setWhen(System.currentTimeMillis()).setShowWhen(true).setAutoCancel(true).setDefaults(2).setDefaults(1).setContentIntent(k0.b(context, pushMessage));
        if (MsgStyle.CUSTOM_LEFT_PIC.equals(pushMessage.floatNotice)) {
            PushLogUtils.LOG.g("head up");
            builder.setPriority(2);
        } else {
            PushLogUtils.LOG.g("no head up");
            builder.setPriority(0);
        }
        List<PushExtensionBtn> c = c(pushMessage);
        if (c != null && c.size() > 0) {
            for (PushExtensionBtn pushExtensionBtn : c) {
                builder.addAction(new Notification.Action(0, pushExtensionBtn.txt, k0.b(context, b(pushMessage, pushExtensionBtn.type, pushExtensionBtn.content))));
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            m.e.a(builder, TextUtils.isEmpty(pushMessage.channelId) ? "twibida" : pushMessage.channelId);
            if (MsgStyle.CUSTOM_LEFT_PIC.equals(pushMessage.floatNotice)) {
                m.e.a(builder, "headup");
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushConstants.EXTRA_PUSH_FROM_TPUSH_NOTI, true);
        builder.addExtras(bundle);
        return builder;
    }

    public static void f(Context context, Intent intent) {
        PushMessage d = d(intent);
        if (d == null) {
            PushLogUtils.LOG.i("handler notification messages, message empty");
            return;
        }
        int i = d.notiOpenType;
        if (1 == i) {
            try {
                Intent intent2 = new Intent();
                if (TextUtils.isEmpty(d.notiOpenContent) || !d.notiOpenContent.contains("://")) {
                    intent2.setClassName(d.packageName, d.notiOpenContent);
                } else {
                    intent2.setData(Uri.parse(d.notiOpenContent));
                }
                intent2.setFlags(276824064);
                context.startActivity(intent2);
            } catch (Exception e) {
                PushLogUtils.LOG.z("e:" + e.getMessage());
                g(context, d);
                if (PushManager.getInstance().getPushListener() != null) {
                    PushManager.getInstance().getPushListener().onClickException(d.messageId, e.getMessage());
                }
            }
        } else if (2 == i) {
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(d.notiOpenContent));
                intent3.setFlags(268435456);
                context.startActivity(intent3);
            } catch (Exception e2) {
                PushLogUtils.LOG.z("e:" + e2.getMessage());
                g(context, d);
                if (PushManager.getInstance().getPushListener() != null) {
                    PushManager.getInstance().getPushListener().onClickException(d.messageId, e2.getMessage());
                }
            }
        }
        a(d.messageId);
        PushUtils.x(d.messageId);
        Tracker.getInstance().trackClick(d.messageId, d);
    }

    private static void g(Context context, PushMessage pushMessage) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(pushMessage.packageName);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.get(0).activityInfo == null) {
            return;
        }
        try {
            Intent intent2 = new Intent();
            intent2.setFlags(343932928);
            intent2.setClassName(queryIntentActivities.get(0).activityInfo.packageName, queryIntentActivities.get(0).activityInfo.name);
            context.startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
            PushLogUtils.LOG.i("e:" + e.getMessage());
        }
    }
}
