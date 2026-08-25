package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef extends com.bytedance.sdk.openadsdk.core.HiB.Dq {
    private Paint Sj;
    private int TKC;
    private RectF sP;

    public sef(Context context) {
        this(context, null);
    }

    public sef(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public sef(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TKC = 0;
        Sj();
    }

    private void Sj() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.Sj = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Sj.setColor(Color.parseColor("#99333333"));
        this.Sj.setAntiAlias(true);
        this.Sj.setStrokeWidth(0.0f);
        this.sP = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.sP;
        float f = rectF.bottom;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.Sj);
        canvas.translate((this.sP.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // com.bytedance.sdk.openadsdk.core.HiB.Dq, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.sP.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int measureText = (int) getPaint().measureText("00");
        this.TKC = measureText;
        if (measuredWidth < measureText) {
            measuredWidth = measureText;
        }
        int i3 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i3, measuredHeight);
        this.sP.set(0.0f, 0.0f, i3, measuredHeight);
    }
}
