package com.tn.lib.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DrawableIndicator extends BaseIndicator {
    private Bitmap d;
    private Bitmap e;

    public DrawableIndicator(Context context) {
        this(context, null);
    }

    public DrawableIndicator(Context context, int i, int i2) {
        super(context);
        this.d = BitmapFactory.decodeResource(getResources(), i);
        this.e = BitmapFactory.decodeResource(getResources(), i2);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawableIndicator);
        if (obtainStyledAttributes != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_normal_drawable);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_selected_drawable);
            this.d = bitmapDrawable.getBitmap();
            this.e = bitmapDrawable2.getBitmap();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d = this.a.d();
        if (d <= 1 || this.d == null || this.e == null) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        while (i < d) {
            canvas.drawBitmap(this.a.a() == i ? this.e : this.d, f, 0.0f, this.b);
            f += this.d.getWidth() + this.a.e();
            i++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int d = this.a.d();
        if (d <= 1) {
            return;
        }
        int i3 = d - 1;
        setMeasuredDimension((this.e.getWidth() * i3) + this.e.getWidth() + (this.a.e() * i3), Math.max(this.d.getHeight(), this.e.getHeight()));
    }
}
