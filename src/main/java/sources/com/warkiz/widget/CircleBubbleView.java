package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class CircleBubbleView extends View {
    private int a;
    private int b;
    private float c;
    private Context d;
    private Path e;
    private Paint f;
    private float g;
    private float h;
    private float i;
    private String j;

    CircleBubbleView(Context context, float f, int i, int i2, String str) {
        super(context, null, 0);
        this.d = context;
        this.c = f;
        this.a = i;
        this.b = i2;
        a(str);
    }

    private void a(String str) {
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.f.setStrokeWidth(1.0f);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(this.c);
        this.f.getTextBounds(str, 0, str.length(), new Rect());
        this.g = r0.width() + g.a(this.d, 4.0f);
        float a = g.a(this.d, 36.0f);
        if (this.g < a) {
            this.g = a;
        }
        this.i = r0.height();
        this.h = this.g * 1.2f;
        b();
    }

    private void b() {
        this.e = new Path();
        float f = this.g;
        this.e.arcTo(new RectF(0.0f, 0.0f, f, f), 135.0f, 270.0f);
        this.e.lineTo(this.g / 2.0f, this.h);
        this.e.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f.setColor(this.b);
        canvas.drawPath(this.e, this.f);
        this.f.setColor(this.a);
        canvas.drawText(this.j, this.g / 2.0f, (this.h / 2.0f) + (this.i / 4.0f), this.f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.g, (int) this.h);
    }

    void setProgress(String str) {
        this.j = str;
        invalidate();
    }
}
