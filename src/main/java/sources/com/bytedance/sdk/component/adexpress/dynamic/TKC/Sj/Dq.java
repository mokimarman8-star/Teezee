package com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Dq implements View.OnTouchListener {
    private float EjP;
    private float HiB;
    private float Jcg;
    private final com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq Sj;
    private final int TKC = 10;
    private final boolean sP;
    private float vS;

    public Dq(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq, boolean z) {
        this.Sj = dq;
        this.sP = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq;
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.EjP = motionEvent.getX();
            this.HiB = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.HiB);
        } else if (action == 1) {
            this.vS = motionEvent.getX();
            this.Jcg = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.Jcg);
            if (this.sP || (dq2 = this.Sj) == null) {
                float f = this.vS - this.EjP;
                float f2 = this.Jcg - this.HiB;
                if (com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), Math.abs((float) Math.sqrt((f * f) + (f2 * f2)))) > 10.0f && (dq = this.Sj) != null) {
                    dq.Sj();
                }
            } else {
                dq2.Sj();
            }
        }
        return true;
    }
}
