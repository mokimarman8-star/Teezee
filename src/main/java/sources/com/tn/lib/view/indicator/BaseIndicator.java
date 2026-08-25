package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BaseIndicator extends View {
    protected a a;
    protected Paint b;
    protected float c;

    public BaseIndicator(Context context) {
        this(context, null);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(0);
        this.b.setColor(this.a.g());
    }

    public a getIndicatorConfig() {
        return this.a;
    }

    @NonNull
    public View getIndicatorView() {
        if (this.a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b = this.a.b();
            if (b == 0) {
                layoutParams.gravity = 8388691;
            } else if (b == 1) {
                layoutParams.gravity = 81;
            } else if (b == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.a.f().a;
            layoutParams.rightMargin = this.a.f().c;
            layoutParams.topMargin = this.a.f().b;
            layoutParams.bottomMargin = this.a.f().d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    public void onPageChanged(int i, int i2) {
        this.a.n(i);
        this.a.m(i2);
        requestLayout();
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.c = f;
        invalidate();
    }

    public void onPageSelected(int i) {
        this.a.m(i);
        invalidate();
    }
}
