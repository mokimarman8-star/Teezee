package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class CircleProgressBar extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 100;
        this.k = 0;
        a(context, attributeSet);
        b();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgressbar, 0, 0);
        this.g = obtainStyledAttributes.getDimension(R.styleable.CircleProgressbar_progressRadius, 80.0f);
        this.h = obtainStyledAttributes.getDimension(R.styleable.CircleProgressbar_progressStrokesWidth, 10.0f);
        this.d = obtainStyledAttributes.getColor(R.styleable.CircleProgressbar_progressBgColor, 15658734);
        this.e = obtainStyledAttributes.getColor(R.styleable.CircleProgressbar_progressRingsColor, 16734911);
        this.f = obtainStyledAttributes.getColor(R.styleable.CircleProgressbar_progressTextsColor, 16777215);
        this.i = obtainStyledAttributes.getInt(R.styleable.CircleProgressbar_progressMax, 100);
        this.j = obtainStyledAttributes.getInt(R.styleable.CircleProgressbar_progressCurrent, 0);
    }

    private void b() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setColor(this.d);
        Paint paint2 = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = this.a;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        this.a.setStrokeWidth(this.h);
        Paint paint4 = new Paint();
        this.b = paint4;
        paint4.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setColor(this.e);
        this.b.setStyle(style);
        this.b.setStrokeCap(cap);
        this.b.setStrokeWidth(this.h);
        Paint paint5 = new Paint();
        this.c = paint5;
        paint5.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(this.f);
        this.c.setTextSize(this.g / 2.0f);
        this.c.getFontMetrics();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.g, this.a);
        if (this.j >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.g, (getHeight() / 2) - this.g, (getWidth() / 2) + this.g, (getHeight() / 2) + this.g);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.b);
            canvas.drawArc(rectF, -90.0f, (this.j / this.i) * 360.0f, false, this.b);
        }
    }

    public void setMax(int i) {
        this.i = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        this.j = i;
        postInvalidate();
    }

    public void setRingColor(int i) {
        this.e = i;
        this.b.setColor(i);
        postInvalidate();
    }
}
