package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class wE implements com.bytedance.sdk.component.HiB.uvD<Bitmap> {
    private final WeakReference<ImageView> Sj;

    public wE(ImageView imageView) {
        this.Sj = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.HiB.uvD
    public void Sj(int i, String str, @Nullable Throwable th) {
        ImageView imageView = this.Sj.get();
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.HiB.uvD
    public void Sj(com.bytedance.sdk.component.HiB.Ym<Bitmap> ym) {
        ImageView imageView = this.Sj.get();
        if (imageView == null) {
            return;
        }
        if (ym != null) {
            try {
                if (ym.sP() != null) {
                    imageView.setImageBitmap(ym.sP());
                    return;
                }
            } catch (Throwable unused) {
                imageView.setVisibility(8);
                return;
            }
        }
        imageView.setVisibility(8);
    }
}
