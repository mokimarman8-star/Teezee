package com.bytedance.adsdk.ugeno.uA.vS;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.EjP;
import com.bytedance.adsdk.ugeno.Sj.HiB;
import com.bytedance.adsdk.ugeno.Sj.vS;
import com.bytedance.adsdk.ugeno.core.IAnimation;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends TextView implements HiB, IAnimation {
    private EjP Sj;
    private vS TKC;
    private float sP;

    public Sj(Context context) {
        super(context);
        this.TKC = new vS(this);
    }

    public void Sj(EjP ejP) {
        this.Sj = ejP;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.sP(canvas);
        }
    }

    public float getBorderRadius() {
        return this.TKC.Sj();
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getRipple() {
        return this.sP;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getRubIn() {
        return this.TKC.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getShine() {
        return this.TKC.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getStretch() {
        return this.TKC.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Jcg();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Dq();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Sj(canvas, this);
            this.Sj.Sj(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Sj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        EjP ejP = this.Sj;
        if (ejP == null) {
            super.onMeasure(i, i2);
        } else {
            int[] Sj = ejP.Sj(i, i2);
            super.onMeasure(Sj[0], Sj[1]);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.sP(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.TKC.Sj(i);
    }

    public void setBorderRadius(float f) {
        vS vSVar = this.TKC;
        if (vSVar != null) {
            vSVar.Sj(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.sP = f;
        vS vSVar = this.TKC;
        if (vSVar != null) {
            vSVar.sP(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        vS vSVar = this.TKC;
        if (vSVar != null) {
            vSVar.HiB(f);
        }
    }

    public void setShine(float f) {
        vS vSVar = this.TKC;
        if (vSVar != null) {
            vSVar.TKC(f);
        }
    }

    public void setStretch(float f) {
        vS vSVar = this.TKC;
        if (vSVar != null) {
            vSVar.EjP(f);
        }
    }
}
