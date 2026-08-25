package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DownsampleStrategy$FitCenter extends DownsampleStrategy {
    DownsampleStrategy$FitCenter() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED ? DownsampleStrategy.SampleSizeRounding.QUALITY : DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
            return Math.min(i3 / i, i4 / i2);
        }
        if (Math.max(i2 / i4, i / i3) == 0) {
            return 1.0f;
        }
        return 1.0f / Integer.highestOneBit(r2);
    }
}
