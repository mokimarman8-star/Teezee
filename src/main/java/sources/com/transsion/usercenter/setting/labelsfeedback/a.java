package com.transsion.usercenter.setting.labelsfeedback;

import android.content.res.Resources;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    public static final int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5d);
    }

    public static final int b(int i) {
        return (int) ((i * Resources.getSystem().getDisplayMetrics().density) + 0.5d);
    }
}
