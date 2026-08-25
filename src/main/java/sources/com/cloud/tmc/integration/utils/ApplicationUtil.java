package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ApplicationUtil {
    private static String firstInstallTime = "";

    public static String getInstallTime() {
        try {
            if (TextUtils.isEmpty(firstInstallTime) && yj.a.a().getApplicationContext() != null) {
                firstInstallTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(yj.a.a().getApplicationContext().getPackageManager().getPackageInfo(yj.a.a().getApplicationContext().getPackageName(), 0).firstInstallTime));
            }
        } catch (Throwable th) {
            TmcLogger.e("ApplicationUtil", "获取安装时间失败：" + th);
        }
        return firstInstallTime;
    }
}
