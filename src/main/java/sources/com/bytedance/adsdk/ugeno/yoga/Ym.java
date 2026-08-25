package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Ym {
    public static long Sj(float f, float f2) {
        return Float.floatToRawIntBits(f2) | (Float.floatToRawIntBits(f) << 32);
    }

    public static long Sj(int i, int i2) {
        return Sj(i, i2);
    }
}
