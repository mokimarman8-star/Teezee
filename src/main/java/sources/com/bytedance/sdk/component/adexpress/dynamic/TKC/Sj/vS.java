package com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS implements View.OnTouchListener {
    private static int TKC = 10;
    private boolean EjP;
    private com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq HiB;
    private float Sj;
    private float sP;

    public vS(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq) {
        this.HiB = dq;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Sj = motionEvent.getX();
            this.sP = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.Sj) >= TKC || Math.abs(y - this.sP) >= TKC) {
                    this.EjP = true;
                }
            } else if (action == 3) {
                this.EjP = false;
            }
        } else {
            if (this.EjP) {
                this.EjP = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.Sj) >= TKC || Math.abs(y2 - this.sP) >= TKC) {
                this.EjP = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq = this.HiB;
                if (dq != null) {
                    dq.Sj();
                }
            }
        }
        return true;
    }
}
