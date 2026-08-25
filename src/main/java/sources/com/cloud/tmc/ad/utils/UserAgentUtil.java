package com.cloud.tmc.ad.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.player.BuildConfig;
import com.cloud.tmc.kernel.utils.TraceLog;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class UserAgentUtil {
    private static String ua = "";

    private static boolean checkAgent() {
        try {
            if (TextUtils.isEmpty(ua)) {
                init();
            }
            if (ua.contains("windows NT") || ua.contains("Macintosh")) {
                return false;
            }
            return !ua.contains("Dalvik");
        } catch (Throwable th) {
            TraceLog.e(CommonLogUtil.TAG_AD, "checkAgent is error , error msg is :=" + Log.getStackTraceString(th));
            return false;
        }
    }

    private static String getDefaultUserAgent() {
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36", stringBuffer);
    }

    public static String getUserAgent() {
        try {
            return checkAgent() ? ua : "";
        } catch (Throwable th) {
            TraceLog.e(CommonLogUtil.TAG_AD, "UserAgentUtil getUserAgent is error , error infor is :=" + Log.getStackTraceString(th));
            return "";
        }
    }

    public static void init() {
        try {
            if (TextUtils.isEmpty(ua)) {
                ua = getDefaultUserAgent();
            }
        } catch (Throwable th) {
            TraceLog.e(CommonLogUtil.TAG_AD, "init is error , error infor is :=" + Log.getStackTraceString(th));
        }
    }
}
