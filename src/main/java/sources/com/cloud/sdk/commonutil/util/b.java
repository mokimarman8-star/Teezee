package com.cloud.sdk.commonutil.util;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a) && e.a().getApplicationContext() != null) {
            try {
                a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(e.a().getApplicationContext().getPackageManager().getPackageInfo(e.a().getApplicationContext().getPackageName(), 0).firstInstallTime));
            } catch (Exception e) {
                c.Log().d("ssp", "get installTime is error: " + e.getMessage());
            }
        }
        return a;
    }
}
