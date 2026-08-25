package sk;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final GradientDrawable a(String str, String str2, GradientDrawable.Orientation orientation) {
        Intrinsics.h(str, "startColor");
        Intrinsics.h(str2, "endColor");
        Intrinsics.h(orientation, "orientation");
        return b(new int[]{Color.parseColor(str), Color.parseColor(str2)}, orientation);
    }

    public static final GradientDrawable b(int[] iArr, GradientDrawable.Orientation orientation) {
        Intrinsics.h(iArr, "colors");
        Intrinsics.h(orientation, "orientation");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(iArr);
        gradientDrawable.setOrientation(orientation);
        return gradientDrawable;
    }

    public static /* synthetic */ GradientDrawable c(String str, String str2, GradientDrawable.Orientation orientation, int i, Object obj) {
        if ((i & 4) != 0) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        }
        return a(str, str2, orientation);
    }

    public static final int d() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 8388613 : 8388611;
    }
}
