package com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.HiB.dNu;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements dNu {
    private com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, Bitmap> EjP;
    private long Sj = 4194304;
    private int TKC;
    private int sP;

    public Sj(int i, int i2) {
        this.sP = i2;
        this.TKC = i;
        this.EjP = new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<>(i2);
    }

    public static int Sj(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public Bitmap Sj(String str) {
        try {
            return this.EjP.Sj((com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, Bitmap>) str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean Sj(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            try {
                int Sj = Sj(bitmap);
                if (Sj <= this.Sj && Sj != 0) {
                    this.EjP.Sj(str, bitmap);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean sP(String str) {
        return this.EjP.Sj((com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, Bitmap>) str) != null;
    }
}
