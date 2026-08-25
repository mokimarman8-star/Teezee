package com.bytedance.sdk.openadsdk.api;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface PAGLoadCallback<Ad> {
    void onAdLoaded(Ad ad);

    void onError(@NonNull PAGErrorModel pAGErrorModel);
}
