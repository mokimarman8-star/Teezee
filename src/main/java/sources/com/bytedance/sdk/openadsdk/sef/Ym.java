package com.bytedance.sdk.openadsdk.sef;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Ym extends View {
    private final Paint Sj;
    private float TKC;
    private float sP;

    public Ym(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#8A8A8A"));
        Paint paint = new Paint();
        this.Sj = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.TKC;
        if (f > 0.0f) {
            float f2 = this.sP;
            canvas.drawLine(0.0f, f2, f, f2, this.Sj);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2;
        this.sP = (1.0f * f) / 2.0f;
        this.Sj.setStrokeWidth(f);
    }

    public void setProgress(float f) {
        this.TKC = getWidth() * f;
        invalidate();
    }
}
