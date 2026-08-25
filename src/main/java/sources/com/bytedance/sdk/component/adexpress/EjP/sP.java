package com.bytedance.sdk.component.adexpress.EjP;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    public static boolean Sj(Context context) {
        return context != null && TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1 && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
