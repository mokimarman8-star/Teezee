package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import wy.b;
import xy.c;
import yy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class TriangularPagerIndicator extends View implements c {
    private List a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private float h;
    private Path i;
    private Interpolator j;
    private float k;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.i = new Path();
        this.j = new LinearInterpolator();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = b.a(context, 3.0d);
        this.f = b.a(context, 14.0d);
        this.e = b.a(context, 8.0d);
    }

    public int getLineColor() {
        return this.d;
    }

    public int getLineHeight() {
        return this.c;
    }

    public Interpolator getStartInterpolator() {
        return this.j;
    }

    public int getTriangleHeight() {
        return this.e;
    }

    public int getTriangleWidth() {
        return this.f;
    }

    public float getYOffset() {
        return this.h;
    }

    public boolean isReverse() {
        return this.g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.b.setColor(this.d);
        if (this.g) {
            canvas.drawRect(0.0f, (getHeight() - this.h) - this.e, getWidth(), ((getHeight() - this.h) - this.e) + this.c, this.b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.c) - this.h, getWidth(), getHeight() - this.h, this.b);
        }
        this.i.reset();
        if (this.g) {
            this.i.moveTo(this.k - (this.f / 2), (getHeight() - this.h) - this.e);
            this.i.lineTo(this.k, getHeight() - this.h);
            this.i.lineTo(this.k + (this.f / 2), (getHeight() - this.h) - this.e);
        } else {
            this.i.moveTo(this.k - (this.f / 2), getHeight() - this.h);
            this.i.lineTo(this.k, (getHeight() - this.e) - this.h);
            this.i.lineTo(this.k + (this.f / 2), getHeight() - this.h);
        }
        this.i.close();
        canvas.drawPath(this.i, this.b);
    }

    @Override // xy.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // xy.c
    public void onPageScrolled(int i, float f, int i2) {
        List list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f2 = uy.a.f(this.a, i);
        a f3 = uy.a.f(this.a, i + 1);
        int i3 = f2.a;
        float f4 = i3 + ((f2.c - i3) / 2);
        int i4 = f3.a;
        this.k = f4 + (((i4 + ((f3.c - i4) / 2)) - f4) * this.j.getInterpolation(f));
        invalidate();
    }

    @Override // xy.c
    public void onPageSelected(int i) {
    }

    @Override // xy.c
    public void onPositionDataProvide(List<a> list) {
        this.a = list;
    }

    public void setLineColor(int i) {
        this.d = i;
    }

    public void setLineHeight(int i) {
        this.c = i;
    }

    public void setReverse(boolean z) {
        this.g = z;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.j = interpolator;
        if (interpolator == null) {
            this.j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i) {
        this.e = i;
    }

    public void setTriangleWidth(int i) {
        this.f = i;
    }

    public void setYOffset(float f) {
        this.h = f;
    }
}
