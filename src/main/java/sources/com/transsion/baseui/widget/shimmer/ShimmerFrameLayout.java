package com.transsion.baseui.widget.shimmer;

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
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.transsion.baseui.R$styleable;
import com.transsion.baseui.widget.shimmer.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint a;
    private final b b;
    private boolean c;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        a(context, null);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setLayerType(1, null);
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0018a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            setShimmer(((obtainStyledAttributes.hasValue(R$styleable.ShimmerFrameLayout_shimmer_colored) && obtainStyledAttributes.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new a.c() : new a.C0018a()).c(obtainStyledAttributes).a());
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            this.b.draw(canvas);
        }
    }

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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c && getVisibility() == 0) {
            this.b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            stopShimmer();
        } else if (this.c && isAttachedToWindow()) {
            this.b.b();
        }
    }

    public ShimmerFrameLayout setShimmer(@Nullable a aVar) {
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

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b;
    }
}
