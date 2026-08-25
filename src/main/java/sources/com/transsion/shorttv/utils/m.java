package com.transsion.shorttv.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class m {
    public static final String a(int i) {
        Object valueOf;
        Object valueOf2;
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        if (i5 <= 0) {
            String valueOf3 = i4 > 0 ? Integer.valueOf(i4) : "0";
            if (i3 < 10) {
                valueOf = "0" + i3;
            } else {
                valueOf = Integer.valueOf(i3);
            }
            return valueOf3 + ":" + valueOf;
        }
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = Integer.valueOf(i3);
        }
        return i5 + ":" + i4 + ":" + valueOf2;
    }
}
