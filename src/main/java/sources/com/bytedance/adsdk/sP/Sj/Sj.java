package com.bytedance.adsdk.sP.Sj;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.sP.vS.HiB;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends Paint {
    public Sj() {
    }

    public Sj(int i) {
        super(i);
    }

    public Sj(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    public Sj(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(HiB.Sj(i, 0, 255));
        } else {
            setColor((HiB.Sj(i, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
