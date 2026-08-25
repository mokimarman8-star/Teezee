package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends sP {
    private final Bitmap TKC;
    private final Rect sP = new Rect();
    private final Paint EjP = new Paint(1);

    public Sj(Bitmap bitmap, sP sPVar) {
        this.TKC = bitmap;
        if (sPVar != null) {
            this.Sj = sPVar.Sj;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sP
    protected void Sj(Canvas canvas) {
        canvas.drawBitmap(this.TKC, this.sP, getBounds(), this.EjP);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.TKC.getWidth();
        int height2 = this.TKC.getHeight();
        this.sP.set(0, 0, width2, height2);
        if (height2 >= height && width2 >= width) {
            if (width2 > width) {
                Rect rect2 = this.sP;
                int i = (width2 - width) / 2;
                rect2.left = i;
                rect2.right = i + width;
            }
            if (height2 > height) {
                Rect rect3 = this.sP;
                int i2 = (height2 - height) / 2;
                rect3.top = i2;
                rect3.bottom = i2 + height;
                return;
            }
            return;
        }
        float f = height;
        float f2 = f * 1.0f;
        float f3 = height2;
        float f4 = f2 / f3;
        float f8 = width;
        float f9 = 1.0f * f8;
        float f10 = width2;
        if (Math.max(f4, f9 / f10) > f4) {
            int i3 = (int) ((f2 / f8) * f10);
            Rect rect4 = this.sP;
            int i4 = (height2 - i3) / 2;
            rect4.top = i4;
            rect4.bottom = i4 + i3;
            return;
        }
        int i8 = (int) ((f9 / f) * f3);
        Rect rect5 = this.sP;
        int i9 = (width2 - i8) / 2;
        rect5.left = i9;
        rect5.right = i9 + i8;
    }
}
