package com.cloud.tmc.miniapp.widget.pulldownrefresh.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o extends OooO0o {
    public int OooO0O0 = 0;
    public int OooO0OO = 0;
    public Path OooO0Oo = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.OooO0O0 != width || this.OooO0OO != height) {
            this.OooO0Oo.reset();
            float f = (width * 30) / 225;
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = width;
            float f5 = f4 / 2.0f;
            float f6 = height;
            this.OooO0Oo.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.OooO0Oo.lineTo(0.0f, f7);
            float f10 = f7 - f2;
            this.OooO0Oo.lineTo(f2, f10);
            float f11 = f / 2.0f;
            float f12 = f5 - f11;
            float f13 = (f6 - f3) - f11;
            this.OooO0Oo.lineTo(f12, f13);
            this.OooO0Oo.lineTo(f12, 0.0f);
            float f14 = f5 + f11;
            this.OooO0Oo.lineTo(f14, 0.0f);
            this.OooO0Oo.lineTo(f14, f13);
            this.OooO0Oo.lineTo(f4 - f2, f10);
            this.OooO0Oo.lineTo(f4, f7);
            this.OooO0Oo.close();
            this.OooO0O0 = width;
            this.OooO0OO = height;
        }
        canvas.drawPath(this.OooO0Oo, this.OooO00o);
    }
}
