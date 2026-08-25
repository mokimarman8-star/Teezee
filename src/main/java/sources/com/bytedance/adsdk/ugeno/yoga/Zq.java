package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum Zq {
    STATIC(0, "static"),
    RELATIVE(1, "relative"),
    ABSOLUTE(2, "absolute");

    private final int EjP;
    private final String HiB;

    Zq(int i, String str) {
        this.EjP = i;
        this.HiB = str;
    }

    public static Zq Sj(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static Zq Sj(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.EjP;
    }
}
