package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class IndicatorView extends View implements a {
    private final Interpolator a;
    private Interpolator b;
    private Path c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final Paint i;
    private final RectF j;
    private RelativeLayout.LayoutParams k;
    private int l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new DecelerateInterpolator();
        this.g = -7829368;
        this.h = -1;
        this.m = a(3.5f);
        this.n = 1.0f;
        this.o = a(3.5f);
        this.p = 1.0f;
        this.q = a(10.0f);
        this.j = new RectF();
        this.i = new Paint(1);
    }

    private int a(float f) {
        return (int) (f * getContext().getResources().getDisplayMetrics().density);
    }

    private void b(Canvas canvas, float f) {
        g(canvas, f);
        if (this.c == null) {
            this.c = new Path();
        }
        if (this.b == null) {
            this.b = new AccelerateInterpolator();
        }
        float h = h(this.e);
        float h2 = h((this.e + 1) % this.f) - h;
        float interpolation = (this.b.getInterpolation(this.d) * h2) + h;
        float i = h + (h2 * i());
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = this.o * 0.57f;
        float f3 = this.p * f2;
        float i2 = ((f3 - ratioSelectedRadius) * i()) + ratioSelectedRadius;
        float interpolation2 = f3 + ((ratioSelectedRadius - f3) * this.b.getInterpolation(this.d));
        float i3 = (this.o - f2) * i();
        float interpolation3 = (this.o - f2) * this.b.getInterpolation(this.d);
        this.i.setColor(this.h);
        float f4 = this.o;
        this.j.set(interpolation - i2, (f - f4) + i3, interpolation + i2, (f4 + f) - i3);
        canvas.drawRoundRect(this.j, i2, i2, this.i);
        float f5 = (f - f2) - interpolation3;
        float f6 = f2 + f + interpolation3;
        this.j.set(i - interpolation2, f5, i + interpolation2, f6);
        canvas.drawRoundRect(this.j, interpolation2, interpolation2, this.i);
        this.c.reset();
        this.c.moveTo(i, f);
        this.c.lineTo(i, f5);
        float f7 = ((interpolation - i) / 2.0f) + i;
        this.c.quadTo(f7, f, interpolation, (f - this.o) + i3);
        this.c.lineTo(interpolation, (this.o + f) - i3);
        this.c.quadTo(f7, f, i, f6);
        this.c.close();
        canvas.drawPath(this.c, this.i);
    }

    private void c(Canvas canvas, float f) {
        g(canvas, f);
        float i = i();
        float h = h(this.e);
        float h2 = h((this.e + 1) % this.f);
        float ratioRadius = getRatioRadius();
        float f2 = this.o;
        float f3 = this.p * f2;
        float f4 = (f3 - ratioRadius) * i;
        float f5 = f3 - f4;
        float f6 = ratioRadius + f4;
        float f7 = (f2 - this.m) * i;
        this.i.setColor(this.h);
        if (i < 0.99f) {
            RectF rectF = this.j;
            rectF.set(h - f5, (f - f2) + f7, h + f5, (f2 + f) - f7);
            canvas.drawRoundRect(this.j, f5, f5, this.i);
        }
        if (i > 0.1f) {
            float f10 = this.m;
            float f11 = f + f10 + f7;
            RectF rectF2 = this.j;
            rectF2.set(h2 - f6, (f - f10) - f7, h2 + f6, f11);
            canvas.drawRoundRect(this.j, f6, f6, this.i);
        }
    }

    private void d(Canvas canvas, float f) {
        g(canvas, f);
        float h = h(this.e);
        float h2 = h((this.e + 1) % this.f);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = h - ratioSelectedRadius;
        float f3 = h + ratioSelectedRadius;
        float f4 = h2 - ratioSelectedRadius;
        float i = f2 + ((f4 - f2) * i());
        float i2 = f3 + (((h2 + ratioSelectedRadius) - f3) * i());
        RectF rectF = this.j;
        float f5 = this.o;
        rectF.set(i, f - f5, i2, f + f5);
        this.i.setColor(this.h);
        RectF rectF2 = this.j;
        float f6 = this.o;
        canvas.drawRoundRect(rectF2, f6, f6, this.i);
    }

    private void e(Canvas canvas, float f) {
        float max;
        float min;
        g(canvas, f);
        float h = h(this.e);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = h - ratioSelectedRadius;
        float f3 = h + ratioSelectedRadius;
        float i = i();
        float max2 = this.q + (Math.max(getRatioRadius(), ratioSelectedRadius) * 2.0f);
        if ((this.e + 1) % this.f == 0) {
            float f4 = max2 * (-r1);
            max = f2 + Math.max(f4 * i * 2.0f, f4);
            min = Math.min(f4 * (i - 0.5f) * 2.0f, 0.0f);
        } else {
            max = f2 + Math.max((i - 0.5f) * max2 * 2.0f, 0.0f);
            min = Math.min(i * max2 * 2.0f, max2);
        }
        float f5 = f3 + min;
        RectF rectF = this.j;
        float f6 = this.o;
        rectF.set(max, f - f6, f5, f + f6);
        this.i.setColor(this.h);
        RectF rectF2 = this.j;
        float f7 = this.o;
        canvas.drawRoundRect(rectF2, f7, f7, this.i);
    }

    private void f(Canvas canvas, float f) {
        float i = i();
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float f2 = ratioSelectedRadius - ratioRadius;
        float f3 = f2 * i;
        int i2 = (this.e + 1) % this.f;
        boolean z = i2 == 0;
        this.i.setColor(this.g);
        for (int i3 = 0; i3 < this.f; i3++) {
            float h = h(i3);
            if (z) {
                h += f3;
            }
            float f4 = h - ratioRadius;
            float f5 = this.m;
            float f6 = f - f5;
            float f7 = h + ratioRadius;
            float f10 = f + f5;
            if (this.e + 1 <= i3) {
                this.j.set(f4 + f2, f6, f7 + f2, f10);
            } else {
                this.j.set(f4, f6, f7, f10);
            }
            RectF rectF = this.j;
            float f11 = this.m;
            canvas.drawRoundRect(rectF, f11, f11, this.i);
        }
        this.i.setColor(this.h);
        if (i < 0.99f) {
            float h2 = h(this.e) - ratioSelectedRadius;
            if (z) {
                h2 += f3;
            }
            RectF rectF2 = this.j;
            float f12 = this.o;
            rectF2.set(h2, f - f12, (((ratioSelectedRadius * 2.0f) + h2) + f2) - f3, f + f12);
            RectF rectF3 = this.j;
            float f13 = this.o;
            canvas.drawRoundRect(rectF3, f13, f13, this.i);
        }
        if (i > 0.1f) {
            float h3 = h(i2) + ratioSelectedRadius;
            if (z) {
                f2 = f3;
            }
            float f14 = h3 + f2;
            RectF rectF4 = this.j;
            float f15 = this.o;
            rectF4.set((f14 - (ratioSelectedRadius * 2.0f)) - f3, f - f15, f14, f + f15);
            RectF rectF5 = this.j;
            float f16 = this.o;
            canvas.drawRoundRect(rectF5, f16, f16, this.i);
        }
    }

    private void g(Canvas canvas, float f) {
        this.i.setColor(this.g);
        for (int i = 0; i < this.f; i++) {
            float h = h(i);
            float ratioRadius = getRatioRadius();
            float f2 = this.m;
            this.j.set(h - ratioRadius, f - f2, h + ratioRadius, f2 + f);
            RectF rectF = this.j;
            float f3 = this.m;
            canvas.drawRoundRect(rectF, f3, f3, this.i);
        }
    }

    private float getRatioRadius() {
        return this.m * this.n;
    }

    private float getRatioSelectedRadius() {
        return this.o * this.p;
    }

    private float h(int i) {
        float ratioRadius = getRatioRadius();
        float max = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + max + (((max * 2.0f) + this.q) * i) + (this.l == 3 ? 0.0f : (max - ratioRadius) / 2.0f);
    }

    private float i() {
        return this.a.getInterpolation(this.d);
    }

    private int j(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int k(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        return (int) ((Math.max(ratioSelectedRadius, ratioRadius) * 2.0f * this.f) + ((r2 - 1) * this.q) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
    }

    @Override // com.to.aboomy.pager2banner.a
    public RelativeLayout.LayoutParams getParams() {
        if (this.k == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.k = layoutParams;
            layoutParams.addRule(12);
            this.k.addRule(14);
            this.k.bottomMargin = a(10.0f);
        }
        return this.k;
    }

    @Override // com.to.aboomy.pager2banner.a
    public View getView() {
        return this;
    }

    @Override // com.to.aboomy.pager2banner.a
    public void initIndicatorCount(int i, int i2) {
        this.f = i;
        setVisibility(i > 1 ? 0 : 8);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f == 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        int i = this.l;
        if (i == 0) {
            d(canvas, height);
            return;
        }
        if (i == 1) {
            e(canvas, height);
            return;
        }
        if (i == 2) {
            b(canvas, height);
        } else if (i == 3) {
            f(canvas, height);
        } else if (i == 4) {
            c(canvas, height);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(k(i), j(i2));
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrolled(int i, float f, int i2) {
        this.e = i;
        this.d = f;
        invalidate();
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageSelected(int i) {
    }

    public IndicatorView setIndicatorColor(int i) {
        this.g = i;
        return this;
    }

    public IndicatorView setIndicatorRadius(float f) {
        int a = a(f);
        if (this.m == this.o) {
            this.o = a;
        }
        this.m = a;
        return this;
    }

    public IndicatorView setIndicatorRatio(float f) {
        if (this.n == this.p) {
            this.p = f;
        }
        this.n = f;
        return this;
    }

    public IndicatorView setIndicatorSelectedRadius(float f) {
        this.o = a(f);
        return this;
    }

    public IndicatorView setIndicatorSelectedRatio(float f) {
        this.p = f;
        return this;
    }

    public IndicatorView setIndicatorSelectorColor(int i) {
        this.h = i;
        return this;
    }

    public IndicatorView setIndicatorSpacing(float f) {
        this.q = a(f);
        return this;
    }

    public IndicatorView setIndicatorStyle(int i) {
        this.l = i;
        return this;
    }

    public IndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        this.k = layoutParams;
        return this;
    }
}
