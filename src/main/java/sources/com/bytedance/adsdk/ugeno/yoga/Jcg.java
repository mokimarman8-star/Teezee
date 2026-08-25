package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum Jcg {
    FLEX_START(0, "flex_start"),
    CENTER(1, "center"),
    FLEX_END(2, "flex_end"),
    SPACE_BETWEEN(3, "space_between"),
    SPACE_AROUND(4, "space_around"),
    SPACE_EVENLY(5, "space_evenly");

    private final String Dq;
    private final int Jcg;

    Jcg(int i, String str) {
        this.Jcg = i;
        this.Dq = str;
    }

    public static Jcg Sj(int i) {
        if (i == 0) {
            return FLEX_START;
        }
        if (i == 1) {
            return CENTER;
        }
        if (i == 2) {
            return FLEX_END;
        }
        if (i == 3) {
            return SPACE_BETWEEN;
        }
        if (i == 4) {
            return SPACE_AROUND;
        }
        if (i == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static Jcg Sj(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return CENTER;
            case "space_around":
                return SPACE_AROUND;
            case "space_evenly":
                return SPACE_EVENLY;
            case "flex_start":
                return FLEX_START;
            case "space_between":
                return SPACE_BETWEEN;
            case "flex_end":
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.Jcg;
    }
}
