package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DownsampleStrategy$AtMost extends DownsampleStrategy {
    DownsampleStrategy$AtMost() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
        return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
    }
}
