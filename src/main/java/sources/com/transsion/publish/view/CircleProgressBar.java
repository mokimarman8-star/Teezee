package com.transsion.publish.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.publish.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class CircleProgressBar extends View {
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 100;
        this.i = 0;
        a(context, attributeSet);
        b();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressbar, 0, 0);
        this.e = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_ra, 80.0f);
        this.f = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_strokesWidth, 10.0f);
        this.c = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_ringsColor, 16711680);
        this.d = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_textsColor, 16777215);
    }

    private void b() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setColor(this.c);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStrokeWidth(this.f);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(this.d);
        this.b.setTextSize(this.e / 2.0f);
        this.b.getFontMetrics();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.h >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.e, (getHeight() / 2) - this.e, (getWidth() / 2) + this.e, (getHeight() / 2) + this.e);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.a);
            canvas.drawArc(rectF, -90.0f, (this.h / this.g) * 360.0f, false, this.a);
        }
    }

    public void setProgress(int i) {
        this.h = i;
        postInvalidate();
    }

    public void setRingColor(int i) {
        this.c = i;
        this.a.setColor(i);
        postInvalidate();
    }
}
