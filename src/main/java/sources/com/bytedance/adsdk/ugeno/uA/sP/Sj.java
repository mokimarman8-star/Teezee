package com.bytedance.adsdk.ugeno.uA.sP;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.EjP;
import com.bytedance.adsdk.ugeno.core.TEQ;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends FrameLayout {
    private EjP Sj;
    private Map<Integer, TEQ> sP;

    public Sj(Context context) {
        super(context);
    }

    public void Sj(EjP ejP) {
        this.Sj = ejP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Jcg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Dq();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, TEQ> map = this.sP;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.vS();
        }
        super.onLayout(z, i, i2, i3, i4);
        EjP ejP2 = this.Sj;
        if (ejP2 != null) {
            ejP2.Sj(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        EjP ejP = this.Sj;
        if (ejP != null) {
            int[] Sj = ejP.Sj(i, i2);
            super.onMeasure(Sj[0], Sj[1]);
        } else {
            super.onMeasure(i, i2);
        }
        EjP ejP2 = this.Sj;
        if (ejP2 != null) {
            ejP2.HiB();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.sP(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setEventMap(Map<Integer, TEQ> map) {
        this.sP = map;
    }
}
