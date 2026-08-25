package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RiZ extends Drawable {
    private RectF EjP;
    private Paint Sj;
    private int TKC;
    private int sP;

    public RiZ(int i, int i2) {
        this.TKC = i;
        this.sP = i2;
        Paint paint = new Paint();
        this.Sj = paint;
        paint.setColor(0);
        this.Sj.setAntiAlias(true);
        this.Sj.setShadowLayer(i2, 0.0f, 0.0f, -16777216);
        this.Sj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        RectF rectF = this.EjP;
        int i = this.TKC;
        canvas.drawRoundRect(rectF, i, i, this.Sj);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Sj.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i8 = this.sP;
        this.EjP = new RectF(i + i8, i2 + i8, i3 - i8, i4 - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.Sj.setColorFilter(colorFilter);
    }
}
