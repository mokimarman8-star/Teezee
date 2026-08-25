package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.apm.insight.l.o;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class b {
    private static String a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String d = d();
        a = d;
        if (!TextUtils.isEmpty(d)) {
            return a;
        }
        String c = c();
        a = c;
        if (!TextUtils.isEmpty(c)) {
            return a;
        }
        String b = b(context);
        a = b;
        return b;
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return TtmlNode.ANONYMOUS_REGION_ID;
    }

    private static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            return invoke instanceof String ? (String) invoke : TtmlNode.ANONYMOUS_REGION_ID;
        } catch (Throwable th) {
            th.printStackTrace();
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    private static String d() {
        return Build.VERSION.SDK_INT >= 28 ? o.a() : TtmlNode.ANONYMOUS_REGION_ID;
    }
}
