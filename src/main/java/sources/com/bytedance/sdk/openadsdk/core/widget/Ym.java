package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Ym extends com.bytedance.sdk.openadsdk.core.HiB.TKC {
    public float Sj;

    public Ym(Context context) {
        this(context, null);
    }

    public Ym(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Ym(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Sj = 0.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.HiB.TKC, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = getLayoutParams().width;
        int i4 = getLayoutParams().height;
        float f = this.Sj;
        if (f > 0.0f) {
            if (i3 == -2) {
                size = (int) (size2 * f);
                mode = 1073741824;
            } else if (i4 == -2) {
                size2 = (int) (size / f);
                mode2 = 1073741824;
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setRatio(float f) {
        this.Sj = f;
    }
}
