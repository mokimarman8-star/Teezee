package com.transsion.photoview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
abstract class o {
    static void a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static int b(int i) {
        return (i & 65280) >> 8;
    }

    static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    static boolean d(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    static boolean e(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
