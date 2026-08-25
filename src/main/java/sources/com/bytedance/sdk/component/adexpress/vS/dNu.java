package com.bytedance.sdk.component.adexpress.vS;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class dNu extends View {
    private float EjP;
    private ValueAnimator HiB;
    private boolean Jcg;
    private Context Sj;
    private RectF TKC;
    private Paint sP;
    private int vS;

    public dNu(Context context) {
        super(context);
        this.vS = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.Sj = context;
        Paint paint = new Paint();
        this.sP = paint;
        paint.setAntiAlias(true);
        this.sP.setStyle(Paint.Style.STROKE);
        this.sP.setStrokeWidth(10.0f);
        this.sP.setColor(Color.parseColor("#80FFFFFF"));
        this.TKC = new RectF();
    }

    public void Sj() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.HiB = ofFloat;
        ofFloat.setDuration(this.vS);
        this.HiB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vS.dNu.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dNu.this.EjP = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dNu.this.requestLayout();
            }
        });
        this.HiB.start();
    }

    public void TKC() {
        this.Jcg = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Jcg) {
            return;
        }
        canvas.drawArc(this.TKC, 270.0f, this.EjP, false, this.sP);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.TKC.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void sP() {
        ValueAnimator valueAnimator = this.HiB;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setDuration(int i) {
        this.vS = i;
    }
}
