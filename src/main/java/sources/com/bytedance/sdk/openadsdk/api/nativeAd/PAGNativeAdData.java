package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface PAGNativeAdData {

    public enum PAGNativeMediaType {
        PAGNativeMediaTypeImage,
        PAGNativeMediaTypeVideo
    }

    @Nullable
    View getAdChoicesView();

    View getAdLogoView();

    String getButtonText();

    String getDescription();

    PAGImageItem getIcon();

    PAGNativeMediaType getMediaType();

    PAGMediaView getMediaView();

    String getTitle();
}
