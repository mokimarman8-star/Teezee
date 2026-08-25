package com.bytedance.sdk.openadsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint({"ViewConstructor"})
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef extends View {
    private final Sj Sj;
    private View sP;

    public interface Sj {
        View Sj(Context context);
    }

    public sef(Context context, Sj sj) {
        super(context);
        this.Sj = sj;
        Sj();
    }

    private void Sj() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    private void Sj(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    private View sP() {
        Sj sj;
        if (this.sP == null && (sj = this.Sj) != null) {
            this.sP = sj.Sj(getContext());
            Sj(this.sP, (ViewGroup) getParent());
        }
        return this.sP;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        View view = this.sP;
        if (view != null) {
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            sP();
        }
    }
}
