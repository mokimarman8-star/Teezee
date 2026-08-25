package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import wy.a;
import wy.b;
import xy.c;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class BezierPagerIndicator extends View implements c {
    private List a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private Paint i;
    private Path j;
    private List k;
    private Interpolator l;
    private Interpolator m;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.j = new Path();
        this.l = new AccelerateInterpolator();
        this.m = new DecelerateInterpolator();
        b(context);
    }

    private void a(Canvas canvas) {
        this.j.reset();
        float height = (getHeight() - this.f) - this.g;
        this.j.moveTo(this.e, height);
        this.j.lineTo(this.e, height - this.d);
        Path path = this.j;
        float f = this.e;
        float f2 = this.c;
        path.quadTo(f + ((f2 - f) / 2.0f), height, f2, height - this.b);
        this.j.lineTo(this.c, this.b + height);
        Path path2 = this.j;
        float f3 = this.e;
        path2.quadTo(((this.c - f3) / 2.0f) + f3, height, f3, this.d + height);
        this.j.close();
        canvas.drawPath(this.j, this.i);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.g = b.a(context, 3.5d);
        this.h = b.a(context, 2.0d);
        this.f = b.a(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.g;
    }

    public float getMinCircleRadius() {
        return this.h;
    }

    public float getYOffset() {
        return this.f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.c, (getHeight() - this.f) - this.g, this.b, this.i);
        canvas.drawCircle(this.e, (getHeight() - this.f) - this.g, this.d, this.i);
        a(canvas);
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
        List list2 = this.k;
        if (list2 != null && list2.size() > 0) {
            this.i.setColor(a.a(f, ((Integer) this.k.get(Math.abs(i) % this.k.size())).intValue(), ((Integer) this.k.get(Math.abs(i + 1) % this.k.size())).intValue()));
        }
        yy.a f2 = uy.a.f(this.a, i);
        yy.a f3 = uy.a.f(this.a, i + 1);
        int i3 = f2.a;
        float f4 = i3 + ((f2.c - i3) / 2);
        int i4 = f3.a;
        float f5 = (i4 + ((f3.c - i4) / 2)) - f4;
        this.c = (this.l.getInterpolation(f) * f5) + f4;
        this.e = f4 + (f5 * this.m.getInterpolation(f));
        float f6 = this.g;
        this.b = f6 + ((this.h - f6) * this.m.getInterpolation(f));
        float f7 = this.h;
        this.d = f7 + ((this.g - f7) * this.l.getInterpolation(f));
        invalidate();
    }

    @Override // xy.c
    public void onPageSelected(int i) {
    }

    @Override // xy.c
    public void onPositionDataProvide(List<yy.a> list) {
        this.a = list;
    }

    public void setColors(Integer... numArr) {
        this.k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.m = interpolator;
        if (interpolator == null) {
            this.m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f) {
        this.g = f;
    }

    public void setMinCircleRadius(float f) {
        this.h = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.l = interpolator;
        if (interpolator == null) {
            this.l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f) {
        this.f = f;
    }
}
