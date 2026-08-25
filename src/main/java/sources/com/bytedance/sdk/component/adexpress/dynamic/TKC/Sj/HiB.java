package com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB implements View.OnTouchListener {
    private com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq EjP;
    private int HiB;
    private float Sj;
    private boolean TKC;
    private float sP;

    public HiB(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq, int i) {
        this.EjP = dq;
        this.HiB = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Sj = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.sP = y;
                if (Math.abs(y - this.Sj) > 10.0f) {
                    this.TKC = true;
                }
            }
        } else {
            if (!this.TKC) {
                return false;
            }
            int sP = com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), Math.abs(this.sP - this.Sj));
            if (this.sP - this.Sj < 0.0f && sP > this.HiB && (dq = this.EjP) != null) {
                dq.Sj();
                this.Sj = 0.0f;
                this.sP = 0.0f;
                this.TKC = false;
            }
        }
        return true;
    }
}
