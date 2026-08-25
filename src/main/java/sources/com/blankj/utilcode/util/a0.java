package com.blankj.utilcode.util;

import android.content.res.Resources;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a0 {

    public interface a {
    }

    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
