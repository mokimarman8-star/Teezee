package com.vungle.ads.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class w {
    public static final w INSTANCE = new w();

    private w() {
    }

    public final int dpToPixels(Context context, int i) {
        Intrinsics.h(context, "context");
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Pair<Integer, Integer> getDeviceWidthAndHeightWithOrientation(Context context, int i) {
        Intrinsics.h(context, "context");
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i2 = resources.getConfiguration().orientation;
        if (i == 0) {
            i = i2;
        }
        return i == i2 ? new Pair<>(Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density))) : new Pair<>(Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)));
    }

    public final WebView getWebView(Context context) throws InstantiationException {
        Intrinsics.h(context, "context");
        try {
            return new WebView(context);
        } catch (Resources.NotFoundException e) {
            throw new InstantiationException("Cannot instantiate WebView due to Resources.NotFoundException: " + e + ".message");
        } catch (Exception e2) {
            throw new InstantiationException(e2.getMessage());
        }
    }
}
