package com.cloud.sdk.commonutil.util;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class h {
    public static int a(float f) {
        return (int) ((f * b()) + 0.5f);
    }

    public static float b() {
        try {
            DisplayMetrics d = d();
            if (d == null) {
                return -1.0f;
            }
            return d.density;
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static float c() {
        try {
            DisplayMetrics d = d();
            if (d == null) {
                return -1.0f;
            }
            return d.scaledDensity;
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    private static DisplayMetrics d() {
        if (e.a() == null) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) e.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics;
        } catch (Exception e) {
            c.Log().e("ssp", "getRealMetrics error: " + Log.getStackTraceString(e));
            return null;
        }
    }

    public static int e() {
        if (e.a() == null || e.a().getResources() == null) {
            return 0;
        }
        return e.a().getResources().getConfiguration().orientation;
    }

    public static int f() {
        if (e.a() == null) {
            return -1;
        }
        return d().heightPixels;
    }

    public static int g() {
        if (e.a() == null) {
            return -1;
        }
        return d().widthPixels;
    }

    public static int h(float f) {
        return (int) ((f / c()) + 0.5f);
    }

    public static int i(float f) {
        return (int) ((f * c()) + 0.5f);
    }
}
