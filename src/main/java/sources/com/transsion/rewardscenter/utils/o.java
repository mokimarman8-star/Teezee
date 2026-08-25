package com.transsion.rewardscenter.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    private static Context b;
    public static final o a = new o();
    public static final int c = 8;

    private o() {
    }

    public final boolean a(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "packageName");
        if (b == null) {
            b(context);
        }
        try {
            Context context2 = b;
            if (context2 == null) {
                Intrinsics.y("applicationContext");
                context2 = null;
            }
            return context2.getPackageManager().getApplicationInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        b = context.getApplicationContext();
    }
}
