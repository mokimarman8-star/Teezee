package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import wy.b;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class CircleNavigator extends View implements vy.a {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Interpolator g;
    private Paint h;
    private List i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private int n;
    private boolean o;

    public interface a {
    }

    public CircleNavigator(Context context) {
        super(context);
        this.g = new LinearInterpolator();
        this.h = new Paint(1);
        this.i = new ArrayList();
        this.o = true;
        c(context);
    }

    private void a(Canvas canvas) {
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(this.c);
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            PointF pointF = (PointF) this.i.get(i);
            canvas.drawCircle(pointF.x, pointF.y, this.a, this.h);
        }
    }

    private void b(Canvas canvas) {
        this.h.setStyle(Paint.Style.FILL);
        if (this.i.size() > 0) {
            canvas.drawCircle(this.j, (int) ((getHeight() / 2.0f) + 0.5f), this.a, this.h);
        }
    }

    private void c(Context context) {
        this.n = ViewConfiguration.get(context).getScaledTouchSlop();
        this.a = b.a(context, 3.0d);
        this.d = b.a(context, 8.0d);
        this.c = b.a(context, 1.0d);
    }

    private int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.a * 2) + (this.c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i2 = this.f;
            return (this.c * 2) + (this.a * i2 * 2) + ((i2 - 1) * this.d) + getPaddingLeft() + getPaddingRight();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private void f() {
        this.i.clear();
        if (this.f > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i = this.a;
            int i2 = (i * 2) + this.d;
            int paddingLeft = i + ((int) ((this.c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i3 = 0; i3 < this.f; i3++) {
                this.i.add(new PointF(paddingLeft, height));
                paddingLeft += i2;
            }
            this.j = ((PointF) this.i.get(this.e)).x;
        }
    }

    public a getCircleClickListener() {
        return null;
    }

    public int getCircleColor() {
        return this.b;
    }

    public int getCircleCount() {
        return this.f;
    }

    public int getCircleSpacing() {
        return this.d;
    }

    public int getRadius() {
        return this.a;
    }

    public Interpolator getStartInterpolator() {
        return this.g;
    }

    public int getStrokeWidth() {
        return this.c;
    }

    public boolean isFollowTouch() {
        return this.o;
    }

    public boolean isTouchable() {
        return this.k;
    }

    @Override // vy.a
    public void notifyDataSetChanged() {
        f();
        invalidate();
    }

    @Override // vy.a
    public void onAttachToMagicIndicator() {
    }

    @Override // vy.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.h.setColor(this.b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        f();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(e(i), d(i2));
    }

    @Override // vy.a
    public void onPageScrollStateChanged(int i) {
    }

    @Override // vy.a
    public void onPageScrolled(int i, float f, int i2) {
        if (!this.o || this.i.isEmpty()) {
            return;
        }
        int min = Math.min(this.i.size() - 1, i);
        int min2 = Math.min(this.i.size() - 1, i + 1);
        PointF pointF = (PointF) this.i.get(min);
        PointF pointF2 = (PointF) this.i.get(min2);
        float f2 = pointF.x;
        this.j = f2 + ((pointF2.x - f2) * this.g.getInterpolation(f));
        invalidate();
    }

    @Override // vy.a
    public void onPageSelected(int i) {
        this.e = i;
        if (this.o) {
            return;
        }
        this.j = ((PointF) this.i.get(i)).x;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() != 0 || !this.k) {
            return super.onTouchEvent(motionEvent);
        }
        this.l = x;
        this.m = y;
        return true;
    }

    public void setCircleClickListener(a aVar) {
        if (this.k) {
            return;
        }
        this.k = true;
    }

    public void setCircleColor(int i) {
        this.b = i;
        invalidate();
    }

    public void setCircleCount(int i) {
        this.f = i;
    }

    public void setCircleSpacing(int i) {
        this.d = i;
        f();
        invalidate();
    }

    public void setFollowTouch(boolean z) {
        this.o = z;
    }

    public void setRadius(int i) {
        this.a = i;
        f();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.g = interpolator;
        if (interpolator == null) {
            this.g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i) {
        this.c = i;
        invalidate();
    }

    public void setTouchable(boolean z) {
        this.k = z;
    }
}
