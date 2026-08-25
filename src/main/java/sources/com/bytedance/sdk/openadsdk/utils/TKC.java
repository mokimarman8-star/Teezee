package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    public static int Sj = -1;

    public static int Sj(Context context, int i) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null && (configuration = resources.getConfiguration()) != null) {
                    int i2 = configuration.orientation;
                    if (i == 0) {
                        i = i2;
                    }
                    return i == i2 ? Math.round(displayMetrics.heightPixels / displayMetrics.density) : Math.round(displayMetrics.widthPixels / displayMetrics.density);
                }
            } catch (Throwable unused) {
                return Sj;
            }
        }
        return Sj;
    }

    public static int Sj(Context context, int i, int i2) {
        int Sj2 = Sj(context, i2);
        if (Sj2 == -1) {
            return Sj;
        }
        return Math.max(Math.min(i > 655 ? Math.round((i / 728.0f) * 90.0f) : i > 632 ? 81 : i > 526 ? Math.round((i / 468.0f) * 60.0f) : i > 432 ? 68 : Math.round((i / 320.0f) * 50.0f), Math.min(90, Math.round(Sj2 * 0.15f))), 50);
    }
}
