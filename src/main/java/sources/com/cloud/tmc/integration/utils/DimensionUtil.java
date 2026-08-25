package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.cloud.tmc.kernel.log.TmcLogger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DimensionUtil {
    private static final String TAG = "TmcKernel:DimensionUtil";
    private static float sScale;
    private static float sScaledDensity;
    private static int sScreenHeight;
    private static int sScreenWidth;

    public static int dip2px(Context context, float f) {
        initScale(context);
        return (int) ((f * sScale) + 0.5f);
    }

    public static float getDensity(Context context) {
        initScale(context);
        return sScale;
    }

    public static float getFontSize(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        return f == 1.375f ? 22.0f : 16.0f;
    }

    public static int getRelativeLeft(View view) {
        return view.getId() == 16908290 ? view.getLeft() : view.getLeft() + getRelativeLeft((View) view.getParent());
    }

    public static int getRelativeTop(View view) {
        return view.getId() == 16908290 ? view.getTop() : view.getTop() + getRelativeTop((View) view.getParent());
    }

    public static int getScreenHeight(Context context) {
        int i = sScreenHeight;
        if (i != 0) {
            return i;
        }
        int height = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        sScreenHeight = height;
        return height;
    }

    public static int getScreenWidth(Context context) {
        int i = sScreenWidth;
        if (i != 0) {
            return i;
        }
        int width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        sScreenWidth = width;
        return width;
    }

    private static void initScale(Context context) {
        try {
            if (sScale == 0.0f) {
                sScale = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private static void initScaledDensity(Context context) {
        try {
            if (sScaledDensity == 0.0f) {
                sScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    public static boolean isValueEqule(float f, float f2) {
        return ((int) f) == ((int) f2);
    }

    public static int px2dip(Context context, float f) {
        initScale(context);
        return (int) ((f / sScale) + 0.5f);
    }

    public static float px2sp(Context context, float f) {
        initScaledDensity(context);
        return f / sScaledDensity;
    }

    public static void resetDimensions() {
        sScreenWidth = 0;
        sScreenHeight = 0;
        sScaledDensity = 0.0f;
        sScale = 0.0f;
    }

    public static int sp2px(Context context, float f) {
        initScaledDensity(context);
        return (int) ((f * sScaledDensity) + 0.5f);
    }
}
