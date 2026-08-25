package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PAGMediaView extends FrameLayout {
    protected Integer Sj;

    public PAGMediaView(@NonNull Context context) {
        super(context);
    }

    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void close() {
    }

    public void setMrcTrackerKey(Integer num) {
        this.Sj = num;
    }

    public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
    }
}
