package com.transsion.baseui.util;

import java.text.DecimalFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class n {
    public static final String a(int i) {
        return "S" + new DecimalFormat("00").format(Integer.valueOf(i));
    }

    public static final String b(int i, int i2, boolean z) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        if (i2 <= 0) {
            return (z ? "EP" : "Ch") + decimalFormat.format(Integer.valueOf(i));
        }
        return "S" + decimalFormat.format(Integer.valueOf(i2)) + (z ? " EP" : " Ch") + decimalFormat.format(Integer.valueOf(i));
    }

    public static final String c(int i, boolean z) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        if (i < 100) {
            return (z ? "EP" : "Ch") + decimalFormat.format(Integer.valueOf(i));
        }
        int i2 = i / 100;
        int i3 = i % 100;
        return "S" + decimalFormat.format(Integer.valueOf(i2)) + (z ? " EP" : " Ch") + decimalFormat.format(Integer.valueOf(i3));
    }
}
