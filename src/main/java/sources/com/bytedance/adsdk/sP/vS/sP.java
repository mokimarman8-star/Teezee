package com.bytedance.adsdk.sP.vS;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private static float Sj(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int Sj(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float sP = sP(((i >> 16) & 255) / 255.0f);
        float sP2 = sP(((i >> 8) & 255) / 255.0f);
        float sP3 = sP((i & 255) / 255.0f);
        float sP4 = sP(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float sP5 = sP2 + ((sP(((i2 >> 8) & 255) / 255.0f) - sP2) * f);
        float sP6 = sP3 + (f * (sP((i2 & 255) / 255.0f) - sP3));
        return (Math.round(Sj(sP + ((sP4 - sP) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(Sj(sP5) * 255.0f) << 8) | Math.round(Sj(sP6) * 255.0f);
    }

    private static float sP(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }
}
