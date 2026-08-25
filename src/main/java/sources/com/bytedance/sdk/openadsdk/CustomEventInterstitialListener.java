package com.bytedance.sdk.openadsdk;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface CustomEventInterstitialListener {
    void onInterstitialClicked();

    void onInterstitialDismissed();

    void onInterstitialImpression();

    void onInterstitialShowFail();

    void onInterstitialShown();

    void onLeaveApplication();
}
