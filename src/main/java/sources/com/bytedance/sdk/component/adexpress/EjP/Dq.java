package com.bytedance.sdk.component.adexpress.EjP;

import android.graphics.drawable.GradientDrawable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Dq {
    public static GradientDrawable Sj(int i, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i8 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i2, i2, i3, i3, i4, i4, i8, i8});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }
}
