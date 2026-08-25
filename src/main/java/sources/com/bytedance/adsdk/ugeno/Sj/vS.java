package com.bytedance.adsdk.ugeno.Sj;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS implements HiB {
    private float EjP;
    private float HiB;
    private View Sj;
    private float TKC;
    private float sP;
    private float vS;

    public vS(View view) {
        this.Sj = view;
    }

    public void EjP(float f) {
        this.HiB = f;
        this.Sj.postInvalidate();
    }

    public void HiB(float f) {
        this.vS = f;
        this.Sj.postInvalidate();
    }

    public float Sj() {
        return this.sP;
    }

    public void Sj(float f) {
        View view = this.Sj;
        if (view == null) {
            return;
        }
        this.sP = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public void Sj(int i) {
        View view = this.Sj;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }

    public void TKC(float f) {
        View view = this.Sj;
        if (view == null) {
            return;
        }
        this.EjP = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getRipple() {
        return this.TKC;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getRubIn() {
        return this.vS;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getShine() {
        return this.EjP;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.HiB
    public float getStretch() {
        return this.HiB;
    }

    public void sP(float f) {
        View view = this.Sj;
        if (view == null) {
            return;
        }
        this.TKC = f;
        view.postInvalidate();
    }
}
