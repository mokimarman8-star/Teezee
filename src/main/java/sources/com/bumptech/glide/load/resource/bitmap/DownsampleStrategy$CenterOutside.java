package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DownsampleStrategy$CenterOutside extends DownsampleStrategy {
    DownsampleStrategy$CenterOutside() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        return Math.max(i3 / i, i4 / i2);
    }
}
