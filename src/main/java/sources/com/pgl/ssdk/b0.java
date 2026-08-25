package com.pgl.ssdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b0 {
    private static double a = -1.0d;

    public static String a() {
        return (Build.VERSION.SDK_INT >= 24 ? n0.d.a(n0.b.a(), 0) : Locale.getDefault()).getLanguage();
    }

    public static String a(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String b() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str.trim();
    }

    public static String b(Context context) {
        double d = a;
        double d2 = 0.0d;
        if (d >= 0.0d) {
            return Integer.toString((int) d);
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
            declaredMethod.setAccessible(true);
            d2 = ((Double) declaredMethod.invoke(newInstance, "battery.capacity")).doubleValue();
        } catch (Throwable unused) {
        }
        a = d2;
        return Integer.toString((int) d2);
    }

    public static String c() {
        return TtmlNode.ANONYMOUS_REGION_ID;
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        return TtmlNode.ANONYMOUS_REGION_ID;
    }
}
