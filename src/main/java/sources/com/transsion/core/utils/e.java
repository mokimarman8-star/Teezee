package com.transsion.core.utils;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class e {
    public static int a(float f) {
        return (int) ((f * b()) + 0.5f);
    }

    public static float b() {
        DisplayMetrics d = d();
        if (d == null) {
            return -1.0f;
        }
        return d.density;
    }

    public static float c() {
        DisplayMetrics d = d();
        if (d == null) {
            return -1.0f;
        }
        return d.scaledDensity;
    }

    private static DisplayMetrics d() {
        if (yj.a.a() == null) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) yj.a.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int e() {
        if (yj.a.a() == null) {
            return -1;
        }
        return d().heightPixels;
    }

    public static int f() {
        if (yj.a.a() == null) {
            return -1;
        }
        return d().widthPixels;
    }

    public static int g(float f) {
        return (int) ((f * c()) + 0.5f);
    }
}
