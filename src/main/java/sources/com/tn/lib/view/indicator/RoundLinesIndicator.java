package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a.d() <= 1) {
            return;
        }
        this.b.setColor(this.a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.a.c()), this.a.i(), this.a.i(), this.b);
        this.b.setColor(this.a.j());
        canvas.drawRoundRect(new RectF(this.a.a() * this.a.k(), 0.0f, r0 + this.a.k(), this.a.c()), this.a.i(), this.a.i(), this.b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int d = this.a.d();
        if (d <= 1) {
            return;
        }
        setMeasuredDimension(this.a.k() * d, this.a.c());
    }
}
