package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum TEQ {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int EjP;

    TEQ(int i) {
        this.EjP = i;
    }

    public static TEQ Sj(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
