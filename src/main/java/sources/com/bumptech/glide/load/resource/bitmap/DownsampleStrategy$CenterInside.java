package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DownsampleStrategy$CenterInside extends DownsampleStrategy {
    DownsampleStrategy$CenterInside() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return getScaleFactor(i, i2, i3, i4) == 1.0f ? DownsampleStrategy.SampleSizeRounding.QUALITY : DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(i, i2, i3, i4);
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(i, i2, i3, i4));
    }
}
