package com.transsion.ninegridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class NineGridViewWrapper extends ShapeableImageView {
    private TextPaint A;
    private String B;
    private int w;
    private int x;
    private float y;
    private int z;

    public NineGridViewWrapper(Context context) {
        this(context, null);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NineGridViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 0;
        this.x = -2013265920;
        this.y = 35.0f;
        this.z = -1;
        this.B = BuildConfig.FLAVOR;
        this.y = TypedValue.applyDimension(2, 35.0f, getContext().getResources().getDisplayMetrics());
        TextPaint textPaint = new TextPaint();
        this.A = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.A.setAntiAlias(true);
        this.A.setTextSize(this.y);
        this.A.setColor(this.z);
    }

    public int getMaskColor() {
        return this.x;
    }

    public int getMoreNum() {
        return this.w;
    }

    public int getTextColor() {
        return this.z;
    }

    public float getTextSize() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.w > 0) {
            canvas.drawColor(this.x);
            canvas.drawText(this.B, getWidth() / 2, (getHeight() / 2) - ((this.A.ascent() + this.A.descent()) / 2.0f), this.A);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super/*android.widget.ImageView*/.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaskColor(int i) {
        this.x = i;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMoreNum(int i) {
        this.w = i;
        this.B = "+" + i;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int i) {
        this.z = i;
        this.A.setColor(i);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextSize(float f) {
        this.y = f;
        this.A.setTextSize(f);
        invalidate();
    }
}
