package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class YuanProgressBar extends AppCompatButton {
    private Paint a;
    private float b;
    private RectF c;
    private RectF d;
    private int e;
    private int f;
    private Paint g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public YuanProgressBar(Context context) {
        super(context);
        this.e = 100;
        this.f = 0;
        this.i = Color.parseColor("#99ffffff");
        this.j = Color.parseColor("#ffffff");
        this.k = 0;
        this.l = 0;
        init(context, null);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 100;
        this.f = 0;
        this.i = Color.parseColor("#99ffffff");
        this.j = Color.parseColor("#ffffff");
        this.k = 0;
        this.l = 0;
        init(context, attributeSet);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 100;
        this.f = 0;
        this.i = Color.parseColor("#99ffffff");
        this.j = Color.parseColor("#ffffff");
        this.k = 0;
        this.l = 0;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Canvas canvas) {
        Paint paint;
        canvas.save();
        if (this.h == 0) {
            this.h = zg.h.a.a(getContext(), 1.0f);
        }
        int i = this.f;
        if (i != 0 && (paint = this.g) != null) {
            paint.setColor(i);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - this.h, this.g);
        }
        this.a.setColor(this.i);
        if (this.k <= 0) {
            this.k = this.h;
        }
        this.a.setStrokeWidth(this.k);
        canvas.drawArc(this.c, -90.0f, 360.0f, false, this.a);
        this.a.setColor(this.j);
        if (this.l <= 0) {
            this.l = this.h * 3;
        }
        this.a.setStrokeWidth(this.l);
        canvas.drawArc(this.c, -90.0f, (this.b * 360.0f) / this.e, false, this.a);
        canvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#2f9ceb"));
        this.c = new RectF();
        this.d = new RectF();
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(zg.h.a.a(getContext(), 2.0f));
        this.a.setStrokeCap(Paint.Cap.ROUND);
        setBackground(null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Base_YuanProgressBar);
            this.f = obtainStyledAttributes.getColor(R.styleable.Base_YuanProgressBar_base_insideColor, 0);
            this.i = obtainStyledAttributes.getColor(R.styleable.Base_YuanProgressBar_base_circleColor, this.i);
            this.j = obtainStyledAttributes.getColor(R.styleable.Base_YuanProgressBar_base_yuan_progressColor, this.j);
            this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Base_YuanProgressBar_base_yuanCircleStrokeWidth, this.k);
            this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Base_YuanProgressBar_base_yuanProgressStrokeWidth, this.l);
            Paint paint2 = new Paint();
            this.g = paint2;
            paint2.setAntiAlias(true);
            obtainStyledAttributes.recycle();
        }
        setTextSize(2, 12.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        a(canvas);
        super/*android.widget.Button*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.widget.Button*/.onSizeChanged(i, i2, i3, i4);
        RectF rectF = this.c;
        zg.h hVar = zg.h.a;
        rectF.left = hVar.a(getContext(), 2.0f);
        this.c.top = hVar.a(getContext(), 2.0f);
        this.c.right = i - hVar.a(getContext(), 2.0f);
        this.c.bottom = i2 - hVar.a(getContext(), 2.0f);
        this.d.left = hVar.a(getContext(), 4.0f);
        this.d.top = hVar.a(getContext(), 4.0f);
        this.d.right = i - hVar.a(getContext(), 4.0f);
        this.d.bottom = i2 - hVar.a(getContext(), 4.0f);
    }

    public void setColorNetDetect() {
        this.i = Color.parseColor("#33000000");
        this.j = Color.parseColor("#3ECAF2");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setProgress(float f) {
        this.b = f;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
