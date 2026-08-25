package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class RectangleIndicator extends BaseIndicator {
    RectF d;

    public RectangleIndicator(Context context) {
        this(context, null);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d = this.a.d();
        if (d <= 1) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        while (i < d) {
            this.b.setColor(this.a.a() == i ? this.a.j() : this.a.g());
            this.d.set(f, 0.0f, (this.a.a() == i ? this.a.k() : this.a.h()) + f, this.a.c());
            f += r4 + this.a.e();
            canvas.drawRoundRect(this.d, this.a.i(), this.a.i(), this.b);
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
        setMeasuredDimension((this.a.e() * i3) + (this.a.h() * i3) + this.a.k(), this.a.c());
    }
}
