package com.transsion.push.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.gslb.BuildConfig;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k {
    private static void a(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i2);
        for (int i3 = 0; i3 < i - num.length(); i3++) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static String b(boolean z, boolean z2, int i) {
        char c;
        int i2 = i / 60000;
        if (i2 < 0) {
            i2 = -i2;
            c = '-';
        } else {
            c = '+';
        }
        StringBuilder sb = new StringBuilder(9);
        if (z) {
            sb.append("GMT");
        }
        sb.append(c);
        a(sb, 2, i2 / 60);
        if (z2) {
            sb.append(':');
        }
        a(sb, 2, i2 % 60);
        return sb.toString();
    }

    public static String c() {
        try {
            return b(true, true, TimeZone.getDefault().getRawOffset());
        } catch (Throwable th2) {
            PushLogUtils.LOG.i(Log.getStackTraceString(th2));
            return BuildConfig.FLAVOR;
        }
    }

    public static int d() {
        String f = DeviceInfo.f();
        if (TextUtils.isEmpty(f) || f.length() < 3) {
            return 0;
        }
        try {
            return Integer.parseInt(f.substring(0, 3));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e() {
        String f = DeviceInfo.f();
        if (!TextUtils.isEmpty(f) && f.length() >= 4) {
            try {
                return Integer.parseInt(f.substring(3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String f() {
        try {
            return yj.a.a().getPackageName();
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static boolean h(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
