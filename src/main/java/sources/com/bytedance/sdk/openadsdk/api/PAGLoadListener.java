package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.vS;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface PAGLoadListener<Ad> extends vS {
    void onAdLoaded(Ad ad);

    @Override // com.bytedance.sdk.openadsdk.common.vS
    void onError(int i, String str);
}
