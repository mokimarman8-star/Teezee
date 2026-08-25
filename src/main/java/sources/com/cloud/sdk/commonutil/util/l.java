package com.cloud.sdk.commonutil.util;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class l {
    private static boolean a;
    private static boolean b;

    public static boolean a() {
        if (b) {
            return a;
        }
        boolean z = true;
        b = true;
        try {
            String packageName = e.a().getPackageName();
            if (packageName == null) {
                return a;
            }
            c.Log().d("LauncherUtil", "isLauncherHost: packageName = " + packageName);
            if (!packageName.equals("com.transsion.launcher") && !packageName.equals("com.transsion.XOSlauncher")) {
                z = false;
            }
            a = z;
            return z;
        } catch (Exception e) {
            c.Log().e("LauncherUtil", "isLauncherHost: " + Log.getStackTraceString(e));
            return a;
        }
    }
}
