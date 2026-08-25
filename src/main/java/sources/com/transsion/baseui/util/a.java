package com.transsion.baseui.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    public static final int b = 8;

    private a() {
    }

    public final float a(Context context, float f) {
        Intrinsics.h(context, "context");
        return TypedValue.applyDimension(1, f, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public final int b(Context context) {
        Intrinsics.h(context, "context");
        return zg.h.a.e(context);
    }

    public final boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            Intrinsics.e(str);
            return packageManager.getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
