package com.bytedance.sdk.openadsdk.core.HiB;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.ad.TaErrorCode;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS extends FrameLayout {
    private boolean Dq;
    private Drawable EjP;
    private Drawable HiB;
    private ValueAnimator Jcg;
    private int Sj;
    private Drawable TKC;
    private int sP;
    private boolean vS;

    public vS(Context context) {
        super(context);
        this.Sj = 100;
    }

    public vS(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Sj = 100;
    }

    private void Sj() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, TaErrorCode.UNKNOWN_ERROR_CODE);
        this.Jcg = ofInt;
        ofInt.setDuration(2000L);
        this.Jcg.setRepeatCount(-1);
        this.Jcg.setInterpolator(new LinearInterpolator());
        this.Jcg.setRepeatMode(1);
        this.Jcg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.HiB.vS.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                vS.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.Jcg.start();
        setMax(TaErrorCode.UNKNOWN_ERROR_CODE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.vS = true;
        if (this.HiB != null) {
            Sj();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.vS = false;
        ValueAnimator valueAnimator = this.Jcg;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.Jcg.removeAllUpdateListeners();
            this.Jcg = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ValueAnimator valueAnimator = this.Jcg;
            if (valueAnimator == null || this.Dq) {
                return;
            }
            this.Dq = true;
            valueAnimator.pause();
            return;
        }
        if (this.Dq) {
            this.Dq = false;
            ValueAnimator valueAnimator2 = this.Jcg;
            if (valueAnimator2 != null) {
                valueAnimator2.resume();
            } else {
                Sj();
            }
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.HiB = drawable;
        setProgressDrawable(drawable);
        if (this.vS && this.Jcg == null) {
            Sj();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(uA.Sj(this, layoutParams));
    }

    public void setMax(int i) {
        this.Sj = i;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    public void setProgress(int i) {
        this.sP = i;
        Drawable drawable = this.TKC;
        if (drawable != null) {
            drawable.setLevel((int) ((i * 10000.0f) / this.Sj));
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        this.EjP = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.EjP;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                Drawable drawable3 = ((LayerDrawable) this.EjP).getDrawable(i);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.TKC = drawable3;
                }
            }
        }
        Drawable drawable4 = this.EjP;
        if (drawable4 instanceof RotateDrawable) {
            this.TKC = drawable4;
        }
    }
}
