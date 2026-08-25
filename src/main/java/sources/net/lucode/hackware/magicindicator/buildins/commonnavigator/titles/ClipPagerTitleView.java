package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import xy.b;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ClipPagerTitleView extends View implements b {
    private String a;
    private int b;
    private int c;
    private boolean d;
    private float e;
    private Paint f;
    private Rect g;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.g = new Rect();
        a(context);
    }

    private void a(Context context) {
        int a = wy.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setTextSize(a);
        int a2 = wy.b.a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.g.height() + getPaddingTop() + getPaddingBottom() : Math.min(this.g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    private void c() {
        Paint paint = this.f;
        String str = this.a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.g);
    }

    private int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.g.width() + getPaddingLeft() + getPaddingRight() : Math.min(this.g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    public int getClipColor() {
        return this.c;
    }

    @Override // xy.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // xy.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.g.width() / 2);
    }

    @Override // xy.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.g.width() / 2);
    }

    @Override // xy.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.a;
    }

    public int getTextColor() {
        return this.b;
    }

    public float getTextSize() {
        return this.f.getTextSize();
    }

    @Override // xy.d
    public void onDeselected(int i, int i2) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = (getWidth() - this.g.width()) / 2;
        Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f.setColor(this.b);
        float f = width;
        float f2 = height;
        canvas.drawText(this.a, f, f2, this.f);
        canvas.save();
        if (this.d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.e, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.e), 0.0f, getWidth(), getHeight());
        }
        this.f.setColor(this.c);
        canvas.drawText(this.a, f, f2, this.f);
        canvas.restore();
    }

    @Override // xy.d
    public void onEnter(int i, int i2, float f, boolean z) {
        this.d = z;
        this.e = f;
        invalidate();
    }

    @Override // xy.d
    public void onLeave(int i, int i2, float f, boolean z) {
        this.d = !z;
        this.e = 1.0f - f;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        c();
        setMeasuredDimension(d(i), b(i2));
    }

    @Override // xy.d
    public void onSelected(int i, int i2) {
    }

    public void setClipColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setText(String str) {
        this.a = str;
        requestLayout();
    }

    public void setTextColor(int i) {
        this.b = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f.setTextSize(f);
        requestLayout();
    }
}
