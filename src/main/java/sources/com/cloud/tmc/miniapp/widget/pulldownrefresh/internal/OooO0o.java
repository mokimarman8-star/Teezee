package com.cloud.tmc.miniapp.widget.pulldownrefresh.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class OooO0o extends Drawable {
    public Paint OooO00o;

    public OooO0o() {
        Paint paint = new Paint();
        this.OooO00o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.OooO00o.setAntiAlias(true);
        this.OooO00o.setColor(-5592406);
    }

    public void OooO00o(int i) {
        this.OooO00o.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.OooO00o.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.OooO00o.setColorFilter(colorFilter);
    }
}
