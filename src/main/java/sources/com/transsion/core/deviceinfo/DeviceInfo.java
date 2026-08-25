package com.transsion.core.deviceinfo;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.transsion.core.log.LogUtils;
import com.transsion.core.utils.c;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DeviceInfo {
    private static String a = "";
    private static String b = "";

    public static String c() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String string = Settings.Secure.getString(a.a().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String a2 = TextUtils.isEmpty(string) ? "" : c.a(string);
        b = a2;
        return a2;
    }

    public static String d() {
        String str = a;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: com.transsion.core.deviceinfo.DeviceInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = DeviceInfo.a = a.a(a.a()).a();
                        LogUtils.g("advertisingId is " + DeviceInfo.a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return a;
    }

    public static String e() {
        if (g()) {
            return d();
        }
        String str = a;
        if (str != null && str.length() != 0) {
            return a;
        }
        try {
            a = a.a(a.a()).a();
            LogUtils.g("advertisingId is " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static String f() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) a.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean g() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean h() {
        Context a2 = a.a();
        return a2.getResources() != null && (a2.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
