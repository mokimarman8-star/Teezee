package oj;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static DisplayMetrics b;

    private a() {
    }

    public final int a(Context context) {
        Intrinsics.h(context, "context");
        if (b == null) {
            b = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = b;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }
}
