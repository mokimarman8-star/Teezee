package com.transsion.baseui.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class i extends ViewOutlineProvider {
    private float a;
    private int b = 0;

    public i(float f) {
        this.a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        view.getGlobalVisibleRect(new Rect());
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.b;
        outline.setRoundRect(i == 1 ? new Rect(0, 0, (int) Math.ceil(measuredWidth + (this.a * 2.0f)), measuredHeight) : i == 2 ? new Rect((int) Math.floor(this.a * (-2.0f)), 0, measuredWidth, measuredHeight) : i == 3 ? new Rect(0, 0, measuredWidth, (int) Math.ceil(measuredHeight + (this.a * 2.0f))) : i == 4 ? new Rect(0, (int) Math.floor(this.a * (-2.0f)), measuredWidth, measuredHeight) : new Rect(0, 0, measuredWidth, measuredHeight), this.a);
    }
}
