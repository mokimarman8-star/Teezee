package com.bytedance.sdk.openadsdk.core.Ym.TKC;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    public static final List<String> Sj = Arrays.asList("video/mp4", "video/3gpp");

    private static double Sj(int i) {
        int max = Math.max(i, 0);
        if (700 > max || max > 1500) {
            return Math.min(Math.abs(700 - max) / 700.0f, Math.abs(TTAdConstant.STYLE_SIZE_RADIO_3_2 - max) / 1500.0f);
        }
        return 0.0d;
    }

    private static double Sj(int i, double d, int i2, int i3) {
        return (d > 0.0d ? Math.abs(d - (i3 > 0 ? i2 / i3 : 0.0d)) : 0.0d) + (i > 0 ? Math.abs((i - i2) / i) : 0.0d);
    }

    public static double Sj(int i, double d, int i2, int i3, int i4, @Nullable String str) {
        double Sj2 = Sj(i, d, i2, i3);
        return Sj(str) * (1.0d / ((Sj2 + 1.0d) + Sj(i4)));
    }

    private static double Sj(String str) {
        if (str == null) {
            str = "";
        }
        int hashCode = str.hashCode();
        if (hashCode != -1664118616) {
            return (hashCode == 1331848029 && str.equals("video/mp4")) ? 1.5d : 1.0d;
        }
        str.equals("video/3gpp");
        return 1.0d;
    }
}
