package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class t {
    public static String a() {
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String b = b();
        return !TextUtils.isEmpty(b) ? b : d();
    }

    private static String b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) Utils.a().getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid && (str = runningAppProcessInfo.processName) != null) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String d() {
        try {
            Application a = Utils.a();
            Field field = a.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(a);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", null).invoke(obj2, null);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean e() {
        return Utils.a().getPackageName().equals(a());
    }
}
