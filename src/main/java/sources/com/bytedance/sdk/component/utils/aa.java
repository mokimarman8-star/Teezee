package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class aa {

    @SuppressLint({"StaticFieldLeak"})
    private static Context Sj;

    public static void Sj(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            Sj = context.createConfigurationContext(sP(context, str, str2));
        } catch (Throwable th) {
            th.getMessage();
        }
        ib.Sj(Sj);
    }

    private static Configuration sP(Context context, String str, String str2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str, str2));
        return configuration;
    }
}
