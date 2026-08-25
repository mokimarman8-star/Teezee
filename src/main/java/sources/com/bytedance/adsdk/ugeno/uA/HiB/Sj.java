package com.bytedance.adsdk.ugeno.uA.HiB;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.EjP;
import com.bytedance.adsdk.ugeno.Jcg.Dq;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends FrameLayout {
    private EjP Dq;
    private float EjP;
    private LinearLayout HiB;
    private Context Jcg;
    private float Sj;
    private double TKC;
    private float sP;
    private LinearLayout vS;

    public Sj(Context context) {
        super(context);
        this.Jcg = context;
        this.HiB = new LinearLayout(context);
        this.vS = new LinearLayout(context);
        this.HiB.setOrientation(0);
        this.HiB.setGravity(8388611);
        this.vS.setOrientation(0);
        this.vS.setGravity(8388611);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.Sj, (int) this.sP);
        float f = this.EjP;
        layoutParams.leftMargin = (int) f;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void Sj(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.HiB.removeAllViews();
        this.vS.removeAllViews();
        this.Sj = (int) Dq.Sj(this.Jcg, f);
        this.sP = (int) Dq.Sj(this.Jcg, f);
        this.TKC = d;
        this.EjP = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(com.bytedance.adsdk.ugeno.Jcg.EjP.Sj(this.Jcg, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.vS.addView(starImageView);
        }
        for (int i8 = 0; i8 < 5; i8++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(com.bytedance.adsdk.ugeno.Jcg.EjP.Sj(this.Jcg, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.HiB.addView(starImageView2);
        }
        addView(this.HiB);
        addView(this.vS);
        requestLayout();
    }

    public void Sj(EjP ejP) {
        this.Dq = ejP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EjP ejP = this.Dq;
        if (ejP != null) {
            ejP.Jcg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EjP ejP = this.Dq;
        if (ejP != null) {
            ejP.Dq();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EjP ejP = this.Dq;
        if (ejP != null) {
            ejP.Sj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        EjP ejP = this.Dq;
        if (ejP != null) {
            ejP.Sj(i, i2);
        }
        super.onMeasure(i, i2);
        this.HiB.measure(i, i2);
        double floor = Math.floor(this.TKC);
        this.vS.measure(View.MeasureSpec.makeMeasureSpec((int) (((r0 + r0 + r2) * floor) + this.EjP + ((this.TKC - floor) * this.Sj)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.HiB.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        EjP ejP = this.Dq;
        if (ejP != null) {
            ejP.sP(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
