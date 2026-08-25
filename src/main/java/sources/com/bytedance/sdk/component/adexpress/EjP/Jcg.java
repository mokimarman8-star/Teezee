package com.bytedance.sdk.component.adexpress.EjP;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.h;
import com.bytedance.sdk.component.utils.ib;
import java.util.Locale;
import n0.d;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg {
    private static boolean Sj;

    private static float EjP(Context context) {
        try {
            if (Sj) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", null).setAccessible(true);
                return ((Integer) r1.invoke(r0, null)).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static float Sj(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return (f * EjP(context)) + 0.5f;
    }

    public static int Sj(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static int Sj(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String Sj(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }

    public static float TKC(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return f * EjP(context);
    }

    public static String TKC(@NonNull Context context) {
        String str;
        try {
            Locale a = Build.VERSION.SDK_INT >= 24 ? d.a(h.a(ib.sP(context).getConfiguration()), 0) : Locale.getDefault();
            str = a.getLanguage();
            try {
                if (a.getCountry().equals("TW")) {
                    str = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return Sj(str);
    }

    public static int sP(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int sP(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        float EjP = EjP(context);
        if (EjP <= 0.0f) {
            EjP = 1.0f;
        }
        return (int) ((f / EjP) + 0.5f);
    }
}
