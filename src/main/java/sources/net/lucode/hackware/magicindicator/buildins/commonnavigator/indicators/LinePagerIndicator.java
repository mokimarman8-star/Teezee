package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import wy.a;
import wy.b;
import xy.c;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class LinePagerIndicator extends View implements c {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private int a;
    private Interpolator b;
    private Interpolator c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private Paint i;
    private List j;
    private List k;
    private RectF l;

    public LinePagerIndicator(Context context) {
        super(context);
        this.b = new LinearInterpolator();
        this.c = new LinearInterpolator();
        this.l = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e = b.a(context, 3.0d);
        this.g = b.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.k;
    }

    public Interpolator getEndInterpolator() {
        return this.c;
    }

    public float getLineHeight() {
        return this.e;
    }

    public float getLineWidth() {
        return this.g;
    }

    public int getMode() {
        return this.a;
    }

    public Paint getPaint() {
        return this.i;
    }

    public float getRoundRadius() {
        return this.h;
    }

    public Interpolator getStartInterpolator() {
        return this.b;
    }

    public float getXOffset() {
        return this.f;
    }

    public float getYOffset() {
        return this.d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.l;
        float f = this.h;
        canvas.drawRoundRect(rectF, f, f, this.i);
    }

    @Override // xy.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // xy.c
    public void onPageScrolled(int i, float f, int i2) {
        float b;
        float b2;
        float b3;
        float f2;
        float f3;
        int i3;
        List list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List list2 = this.k;
        if (list2 != null && list2.size() > 0) {
            this.i.setColor(a.a(f, ((Integer) this.k.get(Math.abs(i) % this.k.size())).intValue(), ((Integer) this.k.get(Math.abs(i + 1) % this.k.size())).intValue()));
        }
        yy.a f4 = uy.a.f(this.j, i);
        yy.a f5 = uy.a.f(this.j, i + 1);
        int i4 = this.a;
        if (i4 == 0) {
            float f6 = f4.a;
            f3 = this.f;
            b = f6 + f3;
            f2 = f5.a + f3;
            b2 = f4.c - f3;
            i3 = f5.c;
        } else {
            if (i4 != 1) {
                b = f4.a + ((f4.b() - this.g) / 2.0f);
                float b4 = f5.a + ((f5.b() - this.g) / 2.0f);
                b2 = ((f4.b() + this.g) / 2.0f) + f4.a;
                b3 = ((f5.b() + this.g) / 2.0f) + f5.a;
                f2 = b4;
                this.l.left = b + ((f2 - b) * this.b.getInterpolation(f));
                this.l.right = b2 + ((b3 - b2) * this.c.getInterpolation(f));
                this.l.top = (getHeight() - this.e) - this.d;
                this.l.bottom = getHeight() - this.d;
                invalidate();
            }
            float f7 = f4.e;
            f3 = this.f;
            b = f7 + f3;
            f2 = f5.e + f3;
            b2 = f4.g - f3;
            i3 = f5.g;
        }
        b3 = i3 - f3;
        this.l.left = b + ((f2 - b) * this.b.getInterpolation(f));
        this.l.right = b2 + ((b3 - b2) * this.c.getInterpolation(f));
        this.l.top = (getHeight() - this.e) - this.d;
        this.l.bottom = getHeight() - this.d;
        invalidate();
    }

    @Override // xy.c
    public void onPageSelected(int i) {
    }

    @Override // xy.c
    public void onPositionDataProvide(List<yy.a> list) {
        this.j = list;
    }

    public void setColors(Integer... numArr) {
        this.k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.c = interpolator;
        if (interpolator == null) {
            this.c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        this.e = f;
    }

    public void setLineWidth(float f) {
        this.g = f;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public void setRoundRadius(float f) {
        this.h = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.b = interpolator;
        if (interpolator == null) {
            this.b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.f = f;
    }

    public void setYOffset(float f) {
        this.d = f;
    }
}
