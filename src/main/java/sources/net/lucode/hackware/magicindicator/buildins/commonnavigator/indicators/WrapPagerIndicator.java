package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import wy.b;
import xy.c;
import yy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class WrapPagerIndicator extends View implements c {
    private int a;
    private int b;
    private int c;
    private float d;
    private Interpolator e;
    private Interpolator f;
    private List g;
    private Paint h;
    private RectF i;
    private boolean j;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.e = new LinearInterpolator();
        this.f = new LinearInterpolator();
        this.i = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a = b.a(context, 6.0d);
        this.b = b.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.f;
    }

    public int getFillColor() {
        return this.c;
    }

    public int getHorizontalPadding() {
        return this.b;
    }

    public Paint getPaint() {
        return this.h;
    }

    public float getRoundRadius() {
        return this.d;
    }

    public Interpolator getStartInterpolator() {
        return this.e;
    }

    public int getVerticalPadding() {
        return this.a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.h.setColor(this.c);
        RectF rectF = this.i;
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, this.h);
    }

    @Override // xy.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // xy.c
    public void onPageScrolled(int i, float f, int i2) {
        List list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f2 = uy.a.f(this.g, i);
        a f3 = uy.a.f(this.g, i + 1);
        RectF rectF = this.i;
        int i3 = f2.e;
        rectF.left = (i3 - this.b) + ((f3.e - i3) * this.f.getInterpolation(f));
        RectF rectF2 = this.i;
        rectF2.top = f2.f - this.a;
        int i4 = f2.g;
        rectF2.right = this.b + i4 + ((f3.g - i4) * this.e.getInterpolation(f));
        RectF rectF3 = this.i;
        rectF3.bottom = f2.h + this.a;
        if (!this.j) {
            this.d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // xy.c
    public void onPageSelected(int i) {
    }

    @Override // xy.c
    public void onPositionDataProvide(List<a> list) {
        this.g = list;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f = interpolator;
        if (interpolator == null) {
            this.f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i) {
        this.c = i;
    }

    public void setHorizontalPadding(int i) {
        this.b = i;
    }

    public void setRoundRadius(float f) {
        this.d = f;
        this.j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.e = interpolator;
        if (interpolator == null) {
            this.e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i) {
        this.a = i;
    }
}
