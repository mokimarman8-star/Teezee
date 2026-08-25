package com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements View.OnTouchListener {
    private static int TKC = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq EjP;
    private int HiB;
    private float Sj;
    private float sP;
    private RectF vS = new RectF();
    private long Jcg = 0;
    private final int Dq = 200;
    private final int uA = 3;
    private SoftReference<ViewGroup> TEQ = new SoftReference<>(null);

    public Sj(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq, int i, final ViewGroup viewGroup) {
        this.HiB = TKC;
        this.EjP = dq;
        if (i > 0) {
            this.HiB = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj.Sj.1
                @Override // java.lang.Runnable
                public void run() {
                    Sj.this.TEQ = new SoftReference(viewGroup);
                }
            });
        }
    }

    private RectF Sj(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.vS = Sj(this.TEQ.get());
            this.Sj = motionEvent.getRawX();
            this.sP = motionEvent.getRawY();
            this.Jcg = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.vS;
            if (rectF != null && !rectF.contains(this.Sj, this.sP)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.Sj);
            float abs2 = Math.abs(rawY - this.sP);
            int i = this.HiB;
            if (abs >= i && abs2 >= i) {
                com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq2 = this.EjP;
                if (dq2 != null) {
                    dq2.Sj();
                }
            } else if ((System.currentTimeMillis() - this.Jcg < 200 || (abs < 3.0f && abs2 < 3.0f)) && (dq = this.EjP) != null) {
                dq.Sj();
            }
        }
        return true;
    }
}
