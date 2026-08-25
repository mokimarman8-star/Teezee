package com.pgl.ssdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class z {
    private static int a = -1;
    private static int b = -1;

    @SuppressLint({"PrivateApi"})
    public static Application a() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a(Context context) {
        List<ActivityManager.AppTask> appTasks;
        if (context != null && (appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks()) != null && !appTasks.isEmpty()) {
            for (ActivityManager.AppTask appTask : appTasks) {
                if (appTask.getTaskInfo() != null && a(com.cloud.tmc.miniapp.g.a(appTask.getTaskInfo()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(Intent intent) {
        return (intent == null || (intent.getFlags() & 8388608) == 0) ? false : true;
    }

    public static String b() {
        String str;
        try {
            str = Environment.getDataDirectory().getPath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static void b(Context context) {
        try {
            if (a == -1 || b == -1) {
                i(context);
            }
            if (a(context)) {
                a++;
            }
            b++;
            if (a != 0) {
                j(context);
                com.pgl.ssdk.ces.a.meta(160, null, new int[]{a, b});
            }
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        String str;
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String c(Context context) {
        String str;
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String d(Context context) {
        String str;
        try {
            str = context.getFilesDir().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String e(Context context) {
        String str;
        try {
            str = context.getPackageName();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String f(Context context) {
        String str;
        try {
            str = context.getPackageResourcePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean h(Context context) {
        ResolveInfo resolveInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty() || (resolveInfo = queryIntentActivities.get(0)) == null) {
                return false;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(activityInfo.packageName, activityInfo.name));
            return componentEnabledSetting == 0 || componentEnabledSetting == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void i(Context context) {
        String a2 = u0.a(context, "hac_date", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (a2.equals(simpleDateFormat.format(new Date()))) {
                int a3 = u0.a(context, "hac", -1);
                int a4 = u0.a(context, "tac", -1);
                if (a3 != -1 && a4 != -1) {
                    a = a3;
                    b = a4;
                    return;
                }
            }
        }
        a = 0;
        b = 0;
    }

    private static void j(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        u0.b(context, "hac_date", simpleDateFormat.format(new Date()));
        u0.b(context, "hac", a);
        u0.b(context, "tac", b);
    }
}
