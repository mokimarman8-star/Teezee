package com.transsion.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    public static String a() {
        return yj.a.a().getPackageName();
    }

    public static int b() {
        Context a = yj.a.a();
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String c() {
        Context a = yj.a.a();
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : BuildConfig.FLAVOR;
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }
}
