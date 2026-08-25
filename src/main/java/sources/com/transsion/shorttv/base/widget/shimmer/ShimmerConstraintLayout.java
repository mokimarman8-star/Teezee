package com.transsion.shorttv.base.widget.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.shimmer.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ShimmerConstraintLayout extends ConstraintLayout {
    private final Paint a;
    private final b b;
    private boolean c;

    public ShimmerConstraintLayout(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        init(context, null);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        init(context, attributeSet);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        init(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(1, null);
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0060a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShortTvShimmerConstraintLayout, 0, 0);
        try {
            setShimmer(((obtainStyledAttributes.hasValue(R.styleable.ShortTvShimmerConstraintLayout_short_tv_shimmer_colored) && obtainStyledAttributes.getBoolean(R.styleable.ShortTvShimmerConstraintLayout_short_tv_shimmer_colored, false)) ? new a.c() : new a.C0060a()).c(obtainStyledAttributes).a());
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            this.b.draw(canvas);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hideShimmer() {
        stopShimmer();
        this.c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.b.a();
    }

    public boolean isShimmerVisible() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.c && getVisibility() == 0) {
            this.b.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        stopShimmer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.setBounds(0, 0, getWidth(), getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onVisibilityChanged(View view, int i) {
        super/*android.view.ViewGroup*/.onVisibilityChanged(view, i);
        if (i != 0) {
            stopShimmer();
        } else if (this.c && isAttachedToWindow()) {
            this.b.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShimmerConstraintLayout setShimmer(@Nullable a aVar) {
        this.b.d(aVar);
        if (aVar == null || !aVar.o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.a);
        }
        return this;
    }

    public void setShimmerListener(Animator.AnimatorListener animatorListener) {
        this.b.e(animatorListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showShimmer(boolean z) {
        this.c = true;
        if (z) {
            startShimmer();
        }
        invalidate();
    }

    public void startShimmer() {
        this.b.f();
    }

    public void startShimmer(int i, AnimatorListenerAdapter animatorListenerAdapter) {
        this.b.g(i, animatorListenerAdapter);
    }

    public void stopShimmer() {
        this.b.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean verifyDrawable(Drawable drawable) {
        return super/*android.view.ViewGroup*/.verifyDrawable(drawable) || drawable == this.b;
    }
}
