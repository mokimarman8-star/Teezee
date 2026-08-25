package com.bytedance.sdk.component.adexpress.vS;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA extends View {
    private int Dq;
    private Paint EjP;
    private Paint HiB;
    private Paint Jcg;
    private int Sj;
    private final RectF TKC;
    private int sP;
    private int vS;

    public uA(Context context) {
        super(context);
        this.TKC = new RectF();
        Sj();
    }

    private void Sj() {
        Paint paint = new Paint();
        this.EjP = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.Jcg = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.HiB = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.TKC;
        int i = this.vS;
        canvas.drawRoundRect(rectF, i, i, this.HiB);
        RectF rectF2 = this.TKC;
        int i2 = this.vS;
        canvas.drawRoundRect(rectF2, i2, i2, this.EjP);
        int i3 = this.Sj;
        int i4 = this.sP;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.Jcg);
        int i8 = this.Sj;
        int i9 = this.sP;
        canvas.drawLine(i8 * 0.7f, i9 * 0.3f, i8 * 0.3f, i9 * 0.7f, this.Jcg);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Sj = i;
        this.sP = i2;
        RectF rectF = this.TKC;
        int i8 = this.Dq;
        rectF.set(i8, i8, i - i8, i2 - i8);
    }

    public void setBgColor(int i) {
        this.HiB.setStyle(Paint.Style.FILL);
        this.HiB.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.Jcg.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.Jcg.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.vS = i;
    }

    public void setStrokeColor(int i) {
        this.EjP.setStyle(Paint.Style.STROKE);
        this.EjP.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.EjP.setStrokeWidth(i);
        this.Dq = i;
    }
}
