package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ArrowView extends View {
    private final int a;
    private final int b;
    private final Path c;
    private final Paint d;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int a = g.a(context, 12.0f);
        this.a = a;
        int a2 = g.a(context, 7.0f);
        this.b = a2;
        Path path = new Path();
        this.c = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo(a, 0.0f);
        path.lineTo(a / 2.0f, a2);
        path.close();
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(this.c, this.d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.a, this.b);
    }

    void setColor(int i) {
        this.d.setColor(i);
        invalidate();
    }
}
