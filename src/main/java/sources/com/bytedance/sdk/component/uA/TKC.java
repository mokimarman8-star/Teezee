package com.bytedance.sdk.component.uA;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class TKC implements View.OnTouchListener {
    private ViewConfiguration Sj;
    private int sP = -1;

    abstract void Sj(View.OnTouchListener onTouchListener);

    boolean Sj(float f, float f2, float f3, float f4, Context context) {
        if (this.Sj == null) {
            this.Sj = ViewConfiguration.get(context);
        }
        if (this.sP == -1) {
            this.sP = this.Sj.getScaledTouchSlop();
        }
        return Math.abs(f - f3) <= ((float) this.sP) && Math.abs(f2 - f4) <= ((float) this.sP);
    }
}
