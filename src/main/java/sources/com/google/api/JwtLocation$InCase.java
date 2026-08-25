package com.google.api;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum JwtLocation$InCase {
    HEADER(1),
    QUERY(2),
    IN_NOT_SET(0);

    private final int value;

    JwtLocation$InCase(int i) {
        this.value = i;
    }

    public static JwtLocation$InCase forNumber(int i) {
        if (i == 0) {
            return IN_NOT_SET;
        }
        if (i == 1) {
            return HEADER;
        }
        if (i != 2) {
            return null;
        }
        return QUERY;
    }

    @Deprecated
    public static JwtLocation$InCase valueOf(int i) {
        return forNumber(i);
    }

    public int getNumber() {
        return this.value;
    }
}
