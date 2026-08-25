package com.transsion.push.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class StatusBarUtils {
    public static void setNavigationBarColor(Activity activity, int i) {
        activity.getWindow().setNavigationBarColor(activity.getResources().getColor(i, activity.getTheme()));
        activity.setImmersive(true);
    }

    public static void setNavigationBarLightMode(Activity activity, boolean z) {
        try {
            int i = View.class.getField("SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR").getInt(View.class);
            if (i > 0) {
                View decorView = activity.getWindow().getDecorView();
                if (z) {
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (~i));
                } else {
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | i);
                }
            }
        } catch (Exception unused) {
            PushLogUtils.LOG.i("not surport NavigationbarDarkMode");
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        activity.getWindow().setStatusBarColor(activity.getResources().getColor(i, activity.getTheme()));
        activity.setImmersive(true);
    }

    public static void setStatusBarLightMode(Window window, boolean z) {
        int i;
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            window.addFlags(Integer.MIN_VALUE);
            i = systemUiVisibility | 8192;
        } else {
            i = systemUiVisibility & (-8193);
        }
        decorView.setSystemUiVisibility(i);
    }
}
