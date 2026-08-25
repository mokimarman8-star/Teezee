package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class e {
    private static volatile Context a;
    private static volatile boolean b;
    private static volatile boolean c;
    private static volatile long d;

    public static Context a() {
        if (a == null) {
            c.Log().e("u should init first");
        }
        return a;
    }

    public static File b(Context context) {
        boolean z = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e) {
            c.Log().e("ssp", "getExternalCacheDir error: " + Log.getStackTraceString(e));
            return null;
        }
    }

    public static long c() {
        return d;
    }

    public static String d() {
        return a == null ? "" : a().getPackageName();
    }

    public static int e() {
        Context a2 = a();
        if (a2 == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e) {
            c.Log().e("ssp", "getVersionCode error: " + Log.getStackTraceString(e));
            return -1;
        }
    }

    public static String f() {
        Context a2 = a();
        if (a2 == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception e) {
            c.Log().e("ssp", "getVersionCode error: " + Log.getStackTraceString(e));
            return "";
        }
    }

    public static synchronized void g(Context context) {
        synchronized (e.class) {
            if (!h()) {
                c = true;
                a = context.getApplicationContext();
                i.a(a());
                d = System.currentTimeMillis();
                c.Log().d("HSCoreUtil", "init time is " + d);
            }
        }
    }

    public static boolean h() {
        return c && a != null;
    }

    public static void i(Context context) {
        try {
            a = context.getApplicationContext();
        } catch (Throwable unused) {
            c.Log().e("context is null, please check it");
        }
    }

    public static void j(boolean z) {
        b = z;
    }
}
