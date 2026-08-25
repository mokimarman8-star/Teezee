package com.bytedance.adsdk.ugeno.Jcg;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class TKC {
    public static double Sj(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float Sj(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int Sj(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long Sj(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static boolean Sj(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException unused) {
            return z;
        }
    }
}
