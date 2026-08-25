package com.transsion.push.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.utils.f;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.BitmapDownloadUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.d0;
import com.transsion.push.utils.g0;
import com.transsion.push.utils.k;
import com.transsion.push.utils.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushServiceHelper {
    private static final Object a = new Object();

    class a implements BitmapDownloadUtils.a {
        a() {
        }

        @Override // com.transsion.push.utils.BitmapDownloadUtils.a
        public void a(PushMessage pushMessage, HashMap hashMap) {
            PushServiceHelper.k(pushMessage, hashMap);
        }
    }

    private static List b(String str, NotificationManager notificationManager) {
        Bundle bundle;
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && (bundle = notification.extras) != null && bundle.getBoolean(PushConstants.EXTRA_PUSH_FROM_TPUSH_NOTI)) {
                if (notification.getGroup() == null && TextUtils.isEmpty(str)) {
                    arrayList.add(statusBarNotification);
                } else if (notification.getGroup() != null && notification.getGroup().equals(str)) {
                    arrayList.add(statusBarNotification);
                }
            }
        }
        return arrayList;
    }

    public static void c(PushMessage pushMessage, NotificationManager notificationManager) {
        int i;
        List b;
        if (pushMessage == null || notificationManager == null) {
            return;
        }
        try {
            i = Integer.parseInt(pushMessage.groupMaxCount);
        } catch (Exception unused) {
            i = 0;
        }
        if (i <= 0 || (b = b(pushMessage.groupId, notificationManager)) == null || b.size() < i) {
            return;
        }
        int size = b.size() - i;
        l(b);
        for (int i2 = 0; i2 <= size; i2++) {
            try {
                notificationManager.cancel(((StatusBarNotification) b.get((b.size() - 1) - i2)).getId());
            } catch (Exception e) {
                PushLogUtils.LOG.i("handle max limit message fail, e:" + e.getMessage());
            }
        }
    }

    public static boolean d() {
        return yj.a.a() != null && Settings.Global.getInt(yj.a.a().getContentResolver(), "auto_time", 0) == 1;
    }

    private static void e() {
        try {
            if (PushRepository.getInstance().isReported()) {
                return;
            }
            PushRepository.getInstance().syncActive();
            PushLogUtils.LOG.g(" active reporting");
        } catch (Exception e) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e.getMessage());
        }
    }

    public static void f(Intent intent) {
        if (intent == null) {
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_SERVICE_TYPE);
        PushLogUtils.LOG.g("PushJobIntentService ---> onHandleWork, type:" + stringExtra);
        if (stringExtra == null) {
            return;
        }
        switch (stringExtra) {
            case "sync_config":
                h(intent);
                break;
            case "init":
                break;
            case "token":
                j(intent);
                break;
            case "force_update":
                e();
                break;
            case "message":
                i(intent);
                break;
            default:
                PushLogUtils.LOG.z("service type error");
                break;
        }
    }

    private static void g() {
        Tracker.getInstance().trackActiveSyncProcess();
        PushLogUtils.LOG.g("onHandleSyncActive");
        if (PushUtils.p()) {
            PushLogUtils.LOG.g("onHandleSyncActive force update");
            e();
            return;
        }
        try {
            if (PushUtils.r()) {
                PushLogUtils.LOG.g("tpms sync");
                if (d0.b(yj.a.a())) {
                    d0.c(yj.a.a());
                    PushRepository.getInstance().saveTpmsReportTime(System.currentTimeMillis() + 86400000);
                }
            }
            if (!PushUtils.q() || d0.b(yj.a.a())) {
                return;
            }
            PushRepository.getInstance().syncActive();
        } catch (Exception e) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e.getMessage());
        }
    }

    private static void h(Intent intent) {
        if (intent == null) {
            return;
        }
        g();
    }

    private static void i(Intent intent) {
        PushLogUtils.LOG.g("onHandleTargetMessage--->");
        if (intent == null) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(0L, "intent_null");
            PushLogUtils.LOG.g("onHandleTargetMessage---> intent is null");
            return;
        }
        PushMessage i = PushUtils.i(intent);
        if (i == null) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(0L, "msg_null");
            PushLogUtils.LOG.g("onHandleTargetMessage---> message is null");
            return;
        }
        if (g0.h()) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i.messageId, "self_destroy");
            PushLogUtils.LOG.z("push self-destroying");
            return;
        }
        if (!PushUtils.a(i, 1)) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i.messageId, "check_fail");
            PushLogUtils.LOG.g("onHandleTargetMessage---> checkMessage return ");
            return;
        }
        if (PushUtils.u(i)) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i.messageId, "msg_retreat");
            PushLogUtils.LOG.g("onHandleTargetMessage---> retraceMessage return, retrace msgId:" + i.retraceMsgId);
            return;
        }
        PushUtils.z(i);
        Tracker.getInstance().trackTarget(i.messageId, i.type, i.timeStamp, i.rpkg, "success", i);
        PushUtils.y(i.messageId);
        PushLogUtils.LOG.g("onHandleTargetMessage---> type:" + i.type);
        int i2 = i.type;
        if (i2 != 1) {
            if (i2 == 2) {
                m(i);
                return;
            } else if (i2 != 5 && i2 != 6) {
                if (i2 != 7) {
                    PushLogUtils.LOG.z("Display message, message type is not supported");
                    return;
                }
                return;
            }
        }
        if (i.sdkShow == 0) {
            PushLogUtils.LOG.g("sdkShow no show");
            if (PushManager.getInstance().getPushListener() != null) {
                PushManager.getInstance().getPushListener().onPushReceive(i.messageId, i, i.priority);
            }
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i.messageId, "sdk_show_fail");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PushLogUtils.LOG.g("message ignoreExpire? " + i.ignoreExpire);
            PushLogUtils.LOG.g("isTimeAutomatic: " + d());
            PushLogUtils.LOG.g("message schedule time: " + i.getTimeStamp());
            PushLogUtils.LOG.g("message delay: " + (currentTimeMillis - Long.parseLong(i.getTimeStamp())));
            PushLogUtils.LOG.g("message ttl: " + (i.getMsgTtl() * 1000));
            if (i.ignoreExpire == 0) {
                PushLogUtils.LOG.g("message expiration check");
                if (d() && currentTimeMillis - Long.parseLong(i.getTimeStamp()) > i.getMsgTtl() * 1000) {
                    PushLogUtils.LOG.g("message expired, no show");
                    Tracker.getInstance().trackShow(i.messageId, i.type, i.timeStamp, true, 999);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        if (!PushManager.getInstance().getNotificationSwitch()) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i.messageId, "noti_off");
            PushLogUtils.LOG.g("notification switch is off, do not show noti");
        } else if (BitmapDownloadUtils.a(i)) {
            BitmapDownloadUtils.b(i, new a());
        } else {
            k(i, null);
        }
    }

    private static void j(Intent intent) {
        Tracker.getInstance().trackTokenUpdateProcess("start");
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_TOKEN);
        if (TextUtils.isEmpty(stringExtra)) {
            PushLogUtils.LOG.z("Initialize token to empty");
            return;
        }
        try {
            if (yj.a.a() == null) {
                return;
            }
            synchronized (a) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Initialize push_token， packageName:");
                    sb.append(k.f());
                    sb.append(", token：");
                    sb.append(stringExtra);
                    if (stringExtra.equals((String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, BuildConfig.FLAVOR)) && !TextUtils.isEmpty((CharSequence) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, BuildConfig.FLAVOR))) {
                        Tracker.getInstance().trackTokenUpdateProcess("same");
                        PushLogUtils.LOG.g("token does not need to report without modification");
                        PushUtils.w();
                        f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
                        return;
                    }
                    Tracker.getInstance().trackTokenUpdateProcess("update");
                    PushLogUtils.LOG.g("token updated, do network request");
                    try {
                        f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    PushRepository.getInstance().updateNewToken(stringExtra);
                    e();
                    try {
                        d0.b(yj.a.a());
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(PushMessage pushMessage, HashMap hashMap) {
        PushLogUtils.LOG.g("display messages，message：" + pushMessage);
        if (pushMessage == null) {
            return;
        }
        try {
            k0.g(pushMessage, hashMap);
        } catch (Exception e) {
            PushLogUtils.LOG.i("Notification show exception:" + e.getMessage());
        }
    }

    private static void l(List list) {
        Collections.sort(list, new Comparator<StatusBarNotification>() { // from class: com.transsion.push.service.PushServiceHelper.2
            @Override // java.util.Comparator
            public int compare(StatusBarNotification statusBarNotification, StatusBarNotification statusBarNotification2) {
                return (int) (statusBarNotification2.getPostTime() - statusBarNotification.getPostTime());
            }
        });
    }

    private static synchronized void m(PushMessage pushMessage) {
        synchronized (PushServiceHelper.class) {
            try {
                try {
                    if (TextUtils.isEmpty(pushMessage.packageName)) {
                        pushMessage.packageName = com.transsion.core.utils.a.a();
                    }
                    if (pushMessage.packageName.equals(com.transsion.core.utils.a.a())) {
                        if (PushManager.getInstance().getPushListener() != null) {
                            PushManager.getInstance().getPushListener().onMessageReceive(pushMessage.messageId, pushMessage.transData, pushMessage.priority);
                        } else {
                            Log.e("PUSH_", "tpush listener is not registered");
                        }
                    }
                } catch (Exception e) {
                    PushLogUtils.LOG.i("transmitMessage---> e:" + e.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
