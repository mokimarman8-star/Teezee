package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class CircleIndicator extends BaseIndicator {
    private int d;
    private int e;
    private int f;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = this.a.h() / 2;
        this.e = this.a.k() / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d = this.a.d();
        if (d <= 1) {
            return;
        }
        float f = 0.0f;
        int i = 0;
        while (i < d) {
            boolean z = this.a.a() == i;
            Paint paint = this.b;
            a aVar = this.a;
            paint.setColor(z ? aVar.j() : aVar.g());
            a aVar2 = this.a;
            int k = z ? aVar2.k() : aVar2.h();
            float f2 = z ? this.e : this.d;
            canvas.drawCircle(f + f2, this.f, f2, this.b);
            f += k + this.a.e();
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
        this.d = this.a.h() / 2;
        int k = this.a.k() / 2;
        this.e = k;
        this.f = Math.max(k, this.d);
        int i3 = d - 1;
        setMeasuredDimension((this.a.e() * i3) + this.a.k() + (this.a.h() * i3), Math.max(this.a.h(), this.a.k()));
    }
}
