package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ScreenAdapterLayout extends LinearLayout {
    private boolean a;
    private boolean b;
    private float c;
    private float d;

    public ScreenAdapterLayout(Context context) {
        super(context);
        this.a = false;
        this.b = false;
    }

    public ScreenAdapterLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.a && !this.b) {
            this.b = true;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i3).getLayoutParams();
                int i4 = layoutParams.width;
                if (i4 > 0) {
                    layoutParams.width = (int) (i4 * this.c);
                    layoutParams.height = (int) (layoutParams.height * this.d);
                }
                float f = layoutParams.topMargin;
                float f2 = this.d;
                layoutParams.topMargin = (int) (f * f2);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * f2);
            }
            this.a = false;
        }
        super.onMeasure(i, i2);
    }

    public void setScale(float f, float f2) {
        this.a = true;
        this.c = f;
        this.d = f2;
    }
}
