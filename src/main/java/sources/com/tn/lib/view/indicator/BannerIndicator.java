package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.blankj.utilcode.util.a0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BannerIndicator extends BaseIndicator {
    private float d;

    public BannerIndicator(Context context) {
        this(context, null);
    }

    public BannerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = a0.a(16.0f);
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
            if (z) {
                float h = this.a.h();
                float f2 = this.d;
                canvas.drawRoundRect(f, 0.0f, f + k, h, f2, f2, this.b);
            } else {
                float h2 = this.a.h() / 2;
                canvas.drawCircle(f + h2, h2, h2, this.b);
            }
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
        int i3 = d - 1;
        setMeasuredDimension((this.a.e() * i3) + this.a.k() + (this.a.h() * i3), this.a.h());
    }
}
