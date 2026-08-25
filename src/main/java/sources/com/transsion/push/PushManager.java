package com.transsion.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.transsion.core.utils.f;
import com.transsion.crypto.TCrypterSdk;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.bean.PushConfig;
import com.transsion.push.bean.PushNotification;
import com.transsion.push.broadcast.PushBroadcastReceiver;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ThreadManager;
import com.transsion.push.utils.j;
import java.util.concurrent.atomic.AtomicBoolean;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PushManager {
    public static final int SHOW_STATUS_FAIL_NOTI_CLOSE = 6;
    public static final int SHOW_STATUS_FAIL_PRIORITY = 12;
    public static final int SHOW_STATUS_FAIL_REPEAT = 11;
    public static final int SHOW_STATUS_SUCCESS = 0;
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d;
    private PushBroadcastReceiver a;
    private TPushListener b;

    private PushManager() {
    }

    private boolean a() {
        return true;
    }

    private void b() {
        if (a()) {
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            if (this.a == null) {
                this.a = new PushBroadcastReceiver();
            }
            try {
                a.a().registerReceiver(this.a, intentFilter);
            } catch (Exception e) {
                PushLogUtils.LOG.i("registerReceiver fail, e:" + e.getMessage());
            }
        }
    }

    public static PushManager getInstance() {
        return c.a();
    }

    public void addCustomNotification(PushNotification pushNotification) {
        if (a()) {
            j.a(pushNotification);
        }
    }

    public void getClientId(IClientIdListener iClientIdListener) {
        if (a()) {
            PushRepository.getInstance().getClientId(iClientIdListener);
        }
    }

    public boolean getDebug() {
        if (a()) {
            return PushUtils.o();
        }
        return false;
    }

    public boolean getIsSdkInitFinished() {
        return d;
    }

    public boolean getNotificationSwitch() {
        if (!a()) {
            return false;
        }
        try {
            return f.e("sp_push").c("sp_key_push_switch", true);
        } catch (Exception unused) {
            return false;
        }
    }

    public TPushListener getPushListener() {
        return this.b;
    }

    public boolean getTestEnv() {
        if (a()) {
            return PushUtils.s();
        }
        return false;
    }

    public String getToken(Context context) {
        if (a()) {
            return (String) PushRepository.getInstance().getSpValue("push_token", "");
        }
        return null;
    }

    public void init(Context context) {
        if (a()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a.b(context.getApplicationContext());
                if (c.get()) {
                    return;
                }
                GslbSdk.init(context, new String[]{"https://api.twibida.com/tcm/v2/instance/"}, new b(this, context));
                c.set(true);
                TCrypterSdk.b(context.getApplicationContext());
                ThreadManager.executeInBackground(new 4(this));
                b();
                d = true;
                PushLogUtils.LOG.i("sdk init time: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                PushLogUtils.LOG.i("init fail, e:" + e.getMessage());
                d = false;
            }
        }
    }

    public void init(Context context, String str, String str2, boolean z) {
        if (a()) {
            try {
                a.b(context.getApplicationContext());
                if (c.get()) {
                    return;
                }
                GslbSdk.init(context, new String[]{"https://api.twibida.com/tcm/v2/instance/"}, new a(this, context));
                c.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                TCrypterSdk.b(context.getApplicationContext());
                ThreadManager.executeInBackground(new 2(this, str, str2, z));
                b();
                d = true;
                PushLogUtils.LOG.i("sdk init time: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                PushLogUtils.LOG.i("init fail, e:" + e.getMessage());
                d = false;
            }
        }
    }

    public void registerPushListener(TPushListener tPushListener) {
        this.b = tPushListener;
    }

    @Deprecated
    public void registerReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (a()) {
            try {
                PushLogUtils.LOG.g("registerReceiver --> ");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("tpush.intent.action.TPUSH_RECEIVER");
                intentFilter.addAction("tpush.intent.action.INIT_COMPLETE");
                context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    public void setAppInfo(String str, String str2) {
        if (a()) {
            String e = PushUtils.e();
            String f = PushUtils.f();
            try {
                if (e.equalsIgnoreCase(str) && f.equalsIgnoreCase(str2)) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    PushRepository.getInstance().putSpValue("push_app_id", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    PushRepository.getInstance().putSpValue("push_app_key", str2);
                }
                ThreadManager.executeInBackground(new 6(this));
            } catch (Exception unused) {
            }
        }
    }

    public void setNotificationSwitch(boolean z) {
        if (a()) {
            try {
                f.e("sp_push").l("sp_key_push_switch", z);
            } catch (Exception unused) {
            }
        }
    }

    public void setPushConfig(PushConfig pushConfig) {
        if (a()) {
            ThreadManager.executeInBackground(new 5(this, pushConfig));
        }
    }

    public void subscribeToTopic(String str, ITopicListener iTopicListener) {
        if (a()) {
            PushRepository.getInstance().subscribeToTopic(str, iTopicListener);
        }
    }

    public void trackArrive(long j) {
        if (a()) {
            try {
                Tracker.getInstance().trackTarget(j, 2, "", "", "success");
            } catch (Exception unused) {
            }
        }
    }

    public void trackClick(long j) {
        if (a()) {
            Tracker.getInstance().trackClick(j);
        }
    }

    public void trackConversion(long j) {
        if (a()) {
            try {
                Tracker.getInstance().trackConversion(j);
            } catch (Exception unused) {
            }
        }
    }

    public void trackShow(long j, int i) {
        if (a()) {
            try {
                Tracker.getInstance().trackShow(j, 2, String.valueOf(System.currentTimeMillis()), NotificationAssistUtils.isOpenNotification(a.a()), i);
            } catch (Exception unused) {
            }
        }
    }

    public void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (a()) {
            try {
                context.getApplicationContext().unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
        }
    }

    public void unsubscribeFromTopic(String str, ITopicListener iTopicListener) {
        if (a()) {
            PushRepository.getInstance().unsubscribeFromTopic(str, iTopicListener);
        }
    }

    public void updateToken(String str) {
        if (a()) {
            PushUtils.B(str);
        }
    }
}
