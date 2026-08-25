package com.transsion.athena.taaneh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.gslb.BuildConfig;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class hatnea {
    private static String a = "";
    private static String b = "";

    @SuppressLint({"PrivateApi"})
    public static String a() {
        if (TextUtils.isEmpty(a)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, "ro.tranos.version", BuildConfig.FLAVOR);
                a = str;
                if (TextUtils.isEmpty(str)) {
                    a = (String) method.invoke(null, "ro.os_product.version", BuildConfig.FLAVOR);
                }
            } catch (Exception e) {
                aethna.b(e.getMessage());
            }
        }
        return a;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "os_small_version");
            b = string;
            return string;
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            return BuildConfig.FLAVOR;
        }
    }
}
