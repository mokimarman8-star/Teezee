package com.bytedance.adsdk.ugeno.Jcg;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.params.TmcStartParams;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {

    /* renamed from: com.bytedance.adsdk.ugeno.Jcg.Sj$Sj, reason: collision with other inner class name */
    public static class C0025Sj {
        public GradientDrawable.Orientation Sj;
        public float[] TKC;
        public int[] sP;
    }

    public static GradientDrawable.Orientation EjP(String str) {
        try {
            int parseInt = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            return parseInt == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : parseInt == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : parseInt == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : parseInt == 135 ? GradientDrawable.Orientation.TL_BR : parseInt == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static int Sj(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            Log.e("ColorUtils", "alpha must be between 0 and 255. ");
            i2 = 255;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public static int Sj(String str) {
        return Sj(str, -16777216);
    }

    public static int Sj(String str, char c) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static int Sj(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equals(TmcStartParams.KEY_TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb = new StringBuilder("#");
            char[] charArray = str.toCharArray();
            for (int i2 = 1; i2 < charArray.length; i2++) {
                sb.append(charArray[i2]);
                sb.append(charArray[i2]);
            }
            return Color.parseColor(sb.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba")) {
            return -16777216;
        }
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (split == null || split.length != 4) {
            return i;
        }
        return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
    }

    public static boolean TKC(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static C0025Sj sP(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String substring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int Sj = Sj(substring, '%');
            int indexOf = substring.indexOf(",");
            String substring2 = substring.substring(0, indexOf);
            C0025Sj c0025Sj = new C0025Sj();
            c0025Sj.Sj = EjP(substring2);
            String substring3 = substring.substring(indexOf + 1);
            int[] iArr = new int[Sj];
            float[] fArr = new float[Sj];
            for (int i = 0; i < Sj; i++) {
                int indexOf2 = substring3.indexOf("%");
                String trim = substring3.substring(0, indexOf2 + 1).trim();
                int indexOf3 = (trim.contains("rgba") ? trim.indexOf(")") : trim.indexOf(" ")) + 1;
                iArr[i] = Sj(trim.substring(0, indexOf3).trim());
                fArr[i] = TKC.Sj(trim.substring(indexOf3, trim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i2 = indexOf2 + 2;
                if (substring3.length() <= i2) {
                    break;
                }
                substring3 = substring3.substring(i2);
            }
            if (Sj < 2) {
                return null;
            }
            c0025Sj.sP = iArr;
            c0025Sj.TKC = fArr;
            return c0025Sj;
        } catch (Throwable unused) {
            return null;
        }
    }
}
