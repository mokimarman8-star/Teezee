package com.transsion.push.tracker;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.core.utils.a;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.utils.PushUtils;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class Tracker {
    private static Tracker c;
    private static HashMap d = new HashMap();
    private static HashMap e = new HashMap();
    private String a;
    private String b;

    public enum KEY {
        INFOEYE_FOR_BROADCAST(0, "infoeye", "hipush_broadcast"),
        INFOEYE_FOR_BROADCAST_GCM(0, "infoeye", "hipush_broadcast_gcm"),
        INFOEYE_FOR_REACH_ERROR(0, "infoeye", "hipush_reach_error"),
        INFOEYE_FOR_TOKEN_INIT(0, "infoeye", "hipush_token_init"),
        INFOEYE_FOR_TOKEN_PROCESS(0, "infoeye", "hipush_token_process"),
        INFOEYE_FOR_SYNC_INIT(0, "infoeye", "hipush_sync_init"),
        INFOEYE_FOR_SYNC_PROCESS(0, "infoeye", "hipush_sync_process"),
        ATHENA_TID_FOR_APP_INIT(10410001, "init"),
        ATHENA_TID_FOR_APP_TOKEN(10410002, "token"),
        ATHENA_TID_FOR_APP_TRIG(10410003, "trig"),
        ATHENA_TID_FOR_APP_REPORT(10410004, "report"),
        ATHENA_TID_FOR_APP_CFG(10410005, "cfg"),
        ATHENA_TID_FOR_APP_MSG(10410006, "msg", "hipush_reach_init"),
        ATHENA_TID_FOR_APP_TARGET(10410007, "arrive", "hipush_reach_process"),
        ATHENA_TID_FOR_APP_SHOW(10410008, "show", "hipush_show"),
        ATHENA_TID_FOR_APP_CLICK(10410009, "click", "hipush_click"),
        ATHENA_TID_FOR_APP_IMG_DOWNLOAD(10410010, "img"),
        ATHENA_TID_FOR_APP_TRACE(10410011, "trace"),
        ATHENA_TID_FOR_APP_UNINSTALL(10410012, "uninstall"),
        ATHENA_TID_FOR_APP_CONVERSION(10410013, "conversion"),
        ATHENA_TID_FOR_APP_INSTALL(10410014, "install");

        public String event;
        public String infoeyeEvent;
        public int tid;

        KEY(int i, String str) {
            this.event = str;
            this.tid = i;
        }

        KEY(int i, String str, String str2) {
            this.event = str;
            this.tid = i;
            this.infoeyeEvent = str2;
        }
    }

    private Tracker() {
        try {
            this.a = a.a();
            this.b = a.c();
        } catch (Exception unused) {
        }
        d.put("all", 0);
        d.put("success", 1);
        d.put("fail", 2);
        e.put("success", 3);
        e.put("handled", 4);
    }

    private void a(Bundle bundle, PushMessage pushMessage) {
        if (pushMessage != null) {
            bundle.putInt("head_up", c(pushMessage) ? 1 : 0);
            bundle.putString("material_id", pushMessage.materialId);
            bundle.putString("seq", pushMessage.seq);
            bundle.putString("sourceType", pushMessage.sourceType);
            bundle.putString("scheduleDate", pushMessage.scheduleDate);
            bundle.putString("tag", pushMessage.tag);
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("pkg", this.a);
        bundle.putString("ver", this.b);
        bundle.putString("sdk", "2.0.2.01");
        bundle.putString(SafeStringUtils.SP_APPID, PushUtils.e());
        return bundle;
    }

    private boolean c(PushMessage pushMessage) {
        return (pushMessage == null || TextUtils.isEmpty(pushMessage.floatNotice) || !pushMessage.floatNotice.equals("1")) ? false : true;
    }

    public static Tracker getInstance() {
        if (c == null) {
            c = new Tracker();
        }
        return c;
    }

    public void init() {
        AthenaTracker.getInstance().b();
    }

    public void trackActiveSyncInit() {
    }

    public void trackActiveSyncProcess() {
    }

    public void trackBroadcastGcmInfoeye() {
    }

    public void trackBroadcastInfoeye() {
    }

    public void trackClick(long j) {
        trackClick(j, PushUtils.m(j));
        PushUtils.b(j);
    }

    public void trackClick(long j, PushMessage pushMessage) {
        Bundle b = b();
        b.putLong("id", j);
        a(b, pushMessage);
        StringBuilder sb = new StringBuilder();
        sb.append("trackClick, message is :  ");
        sb.append(pushMessage);
        AthenaTracker.getInstance().e(KEY.ATHENA_TID_FOR_APP_CLICK, b);
    }

    public void trackConfig(int i, int i2) {
        Bundle b = b();
        b.putInt("cfgv", i);
        b.putInt("cfgt", i2);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CFG;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackConversion(long j) {
        Bundle b = b();
        b.putLong("id", j);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CONVERSION;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackHandleMsgErrorInfoeye(long j, String str) {
    }

    public void trackImg(String str, int i) {
        Bundle b = b();
        b.putString("url", str);
        b.putInt("result", i);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_IMG_DOWNLOAD;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackInit() {
        if (((Boolean) PushRepository.getInstance().getSpValue("init", Boolean.FALSE)).booleanValue()) {
            return;
        }
        Bundle b = b();
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_INIT;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
        PushRepository.getInstance().putSpValue("init", Boolean.TRUE);
    }

    public void trackInstall() {
        if (((Boolean) PushRepository.getInstance().getSpValue("is_track_install", Boolean.FALSE)).booleanValue()) {
            return;
        }
        PushRepository.getInstance().putSpValue("is_track_install", Boolean.TRUE);
        PushTracker.getInstance().i(KEY.ATHENA_TID_FOR_APP_INSTALL, null);
    }

    public void trackMessage(long j, int i, String str, String str2, int i2) {
        Bundle b = b();
        b.putLong("id", j);
        b.putLong("type", i);
        b.putLong("do", i2);
        b.putString("pts", str);
        b.putString("result", str2);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_MSG;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackReport() {
        Bundle b = b();
        b.putString("pkg", this.a);
        b.putString("ver", this.b);
        b.putString("sdk", "2.0.2.01");
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_REPORT;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
        try {
            PushTracker.getInstance().i(key, null);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void trackShow(long j, int i, String str, boolean z, int i2) {
        trackShow(j, i, str, z, i2, PushUtils.m(j));
    }

    public void trackShow(long j, int i, String str, boolean z, int i2, PushMessage pushMessage) {
        Bundle b = b();
        b.putLong("id", j);
        b.putInt("type", i);
        b.putBoolean("able", z);
        b.putString("pts", str);
        b.putInt("status", i2);
        b.putInt("show_status", i2);
        a(b, pushMessage);
        StringBuilder sb = new StringBuilder();
        sb.append("trackShow, message is :  ");
        sb.append(pushMessage);
        AthenaTracker.getInstance().e(KEY.ATHENA_TID_FOR_APP_SHOW, b);
    }

    public void trackTarget(long j, int i, String str, String str2, String str3) {
        Bundle b = b();
        b.putLong("id", j);
        b.putLong("type", i);
        b.putString("pts", str);
        b.putString("rpkg", str2);
        b.putString("result", str3);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TARGET;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackTarget(long j, int i, String str, String str2, String str3, PushMessage pushMessage) {
        Bundle b = b();
        b.putLong("id", j);
        b.putLong("type", i);
        b.putString("pts", str);
        b.putString("rpkg", str2);
        b.putString("result", str3);
        a(b, pushMessage);
        StringBuilder sb = new StringBuilder();
        sb.append("trackTarget, message is :  ");
        sb.append(pushMessage);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TARGET;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackToken(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (str.length() > 8) {
            str = str.substring(0, 8);
        }
        Bundle b = b();
        b.putString("token", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TOKEN;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackTokenUpdateInit() {
    }

    public void trackTokenUpdateProcess(String str) {
    }

    public void trackTrace(int i, String str) {
        Bundle b = b();
        b.putInt("type", i);
        b.putInt("osV", Build.VERSION.SDK_INT);
        b.putString("data", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRACE;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackTrigger(int i) {
        Bundle b = b();
        b.putInt("reason", i);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRIG;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void trackUninstall(long j, String str) {
        Bundle b = b();
        b.putLong("id", j);
        b.putString("tpkg", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_UNINSTALL;
        athenaTracker.e(key, b);
        FirebaseTracker.getInstance().a(key, b);
    }

    public void tracks() {
        PushTracker.getInstance().tracks();
    }
}
