package com.transsion.athena.taaneh;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.gslb.BuildConfig;
import com.transsion.sdk.oneid.OneID;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m4.a;
import m4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {
    private static volatile String a;
    private static final Map<String, String> b = new ConcurrentHashMap();
    private static boolean c = true;
    private static long d = 0;
    public static final /* synthetic */ int e = 0;

    public static int a(long j) {
        if (j > 999) {
            return Integer.parseInt(String.valueOf(j).substring(0, 4));
        }
        return 0;
    }

    @NonNull
    public static String a() {
        return a == null ? BuildConfig.FLAVOR : a;
    }

    public static String a(int i) {
        StringBuilder sb;
        String str;
        if (i > 10) {
            sb = new StringBuilder();
            str = BuildConfig.FLAVOR;
        } else {
            sb = new StringBuilder();
            str = "0";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            try {
                a = athena.a(context).a();
                if (!TextUtils.isEmpty(a)) {
                    a a2 = a.a(context);
                    if (!TextUtils.equals(a, a2.i("athena_id"))) {
                        a2.g("athena_id", a);
                    }
                }
            } catch (Exception e2) {
                aethna.b(e2.getMessage());
            }
            if (TextUtils.isEmpty(a)) {
                a = a.a(context).i("athena_id");
            }
        }
        return a;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("Athena", "------------------------------------------------------------");
        Log.e("Athena", BuildConfig.FLAVOR);
        Log.e("Athena", str);
        Log.e("Athena", BuildConfig.FLAVOR);
        Log.e("Athena", "------------------------------------------------------------");
    }

    public static boolean a(Context context, String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                String[] strArr = packageInfo.requestedPermissions;
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null && applicationInfo.uid == 1000 && strArr != null) {
                    for (String str2 : strArr) {
                        if (TextUtils.equals(str2, str)) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception e2) {
                aethna.b(e2.getMessage());
            }
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e3) {
            aethna.b(e3.getMessage());
            return false;
        }
    }

    public static String b(Context context, String str) {
        Map<String, String> map = b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            if (!OneID.f()) {
                return BuildConfig.FLAVOR;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = d;
            if (j != 0 && elapsedRealtime - j < 600000) {
                return BuildConfig.FLAVOR;
            }
            String a2 = b.b(context).a(str);
            if (TextUtils.isEmpty(a2)) {
                d = elapsedRealtime;
                return BuildConfig.FLAVOR;
            }
            map.put(str, a2);
            d = 0L;
            return a2;
        } catch (Exception e2) {
            aethna.b(e2.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static void b(String str) {
        a = str;
    }

    public static boolean b() {
        return com.transsion.athena.config.data.model.ehanat.q() || com.transsion.athena.config.data.model.ehanat.v();
    }

    public static boolean b(long j) {
        return j > 999 && j <= 9999;
    }

    public static boolean b(Context context) {
        try {
            if (c) {
                if (TextUtils.isEmpty(a.a(context).i("first_launch"))) {
                    if (new File(context.getFilesDir() + File.separator + com.transsion.athena.config.data.model.ehanat.j, "global.cfg").exists()) {
                        c = false;
                    }
                } else {
                    c = false;
                }
            }
        } catch (Exception e2) {
            aethna.b(Log.getStackTraceString(e2));
        }
        return c;
    }

    public static boolean c(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo("com.hoffnung", 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if ("com.transsion.dataservice.provider".equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            aethna.b(Log.getStackTraceString(e2));
        }
        return false;
    }
}
