package com.transsion.push.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.transsion.gslb.Utils;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    private static HashMap a = new HashMap();

    public static void a(PushNotification pushNotification) {
        if (pushNotification == null) {
            return;
        }
        a.put(c(pushNotification.getType(), pushNotification.getStyleId()), pushNotification);
    }

    public static RemoteViews b(Context context, PushMessage pushMessage, HashMap hashMap, boolean z) {
        if (pushMessage.notiType != 3) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R$layout.tpush_notification_expand_31);
        if (hashMap == null || hashMap.get(pushMessage.notiIcon) == null) {
            remoteViews.setViewVisibility(R$id.tpush_largeIconImg, 0);
            if (Build.VERSION.SDK_INT >= 31) {
                remoteViews.setViewLayoutWidth(R$id.tpush_largeIconImg, 1.0f, 1);
            }
        } else {
            remoteViews.setImageViewBitmap(R$id.tpush_largeIconImg, (Bitmap) hashMap.get(pushMessage.notiIcon));
            remoteViews.setViewVisibility(R$id.tpush_largeIconImg, 0);
        }
        remoteViews.setTextViewText(R$id.tpush_titleTv, pushMessage.notiTitle);
        remoteViews.setTextViewText(R$id.tpush_descriptionTv, pushMessage.notiDes);
        if (TextUtils.isEmpty(pushMessage.notiBtn)) {
            remoteViews.setViewVisibility(R$id.tpush_actionBtn, 8);
        } else {
            remoteViews.setTextViewText(R$id.tpush_actionBtn, pushMessage.notiBtn);
            remoteViews.setViewVisibility(R$id.tpush_actionBtn, 0);
        }
        return remoteViews;
    }

    public static String c(int i, int i2) {
        return i + Utils.SEPARATOR + i2;
    }

    public static PushNotification d(int i, int i2) {
        return (PushNotification) a.get(c(i, i2));
    }

    public static RemoteViews e(Context context, PushMessage pushMessage, HashMap hashMap, boolean z) {
        if (pushMessage.notiType != 3) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R$layout.tpush_notification_31);
            remoteViews.setTextViewText(R$id.tpush_titleTv, pushMessage.notiTitle);
            remoteViews.setTextViewText(R$id.tpush_descriptionTv, pushMessage.notiDes);
            if (TextUtils.isEmpty(pushMessage.notiBtn)) {
                remoteViews.setViewVisibility(R$id.tpush_actionBtn, 8);
            } else {
                remoteViews.setTextViewText(R$id.tpush_actionBtn, pushMessage.notiBtn);
                remoteViews.setViewVisibility(R$id.tpush_actionBtn, 0);
            }
            return remoteViews;
        }
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R$layout.tpush_custom_button_style);
        try {
            remoteViews2.setImageViewBitmap(R$id.tpush_smallIconImg, b.d(context, PushUtils.g(context, TextUtils.isEmpty(pushMessage.rpkg) ? context.getPackageName() : pushMessage.rpkg)));
        } catch (Exception e) {
            PushLogUtils.LOG.g("set imageview Exception" + e);
        }
        String h = PushUtils.h(context, pushMessage);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(h)) {
            sb.append(h);
        }
        try {
            String format = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());
            sb.append(" · ");
            sb.append(format);
        } catch (Exception e2) {
            PushLogUtils.LOG.i(e2);
        }
        remoteViews2.setTextViewText(R$id.tpush_smallTitleTv, sb.toString());
        if (hashMap == null || hashMap.get(pushMessage.notiIcon) == null || f()) {
            remoteViews2.setViewVisibility(R$id.tpush_largeIconImg, 8);
        } else {
            remoteViews2.setImageViewBitmap(R$id.tpush_largeIconImg, (Bitmap) hashMap.get(pushMessage.notiIcon));
            remoteViews2.setViewVisibility(R$id.tpush_largeIconImg, 0);
        }
        remoteViews2.setTextViewText(R$id.tpush_titleTv, pushMessage.notiTitle);
        remoteViews2.setTextViewText(R$id.tpush_descriptionTv, pushMessage.notiDes);
        if (TextUtils.isEmpty(pushMessage.notiBtn)) {
            remoteViews2.setViewVisibility(R$id.tpush_actionBtn, 8);
        } else {
            remoteViews2.setTextViewText(R$id.tpush_actionBtn, pushMessage.notiBtn);
            remoteViews2.setViewVisibility(R$id.tpush_actionBtn, 0);
        }
        return remoteViews2;
    }

    public static boolean f() {
        try {
            return Build.VERSION.SDK_INT >= 31;
        } catch (Exception unused) {
            return false;
        }
    }
}
