package com.vungle.ads.internal.presenter;

import com.vungle.ads.VungleError;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {
    void onAdClick(String str);

    void onAdEnd(String str);

    void onAdImpression(String str);

    void onAdLeftApplication(String str);

    void onAdRewarded(String str);

    void onAdStart(String str);

    void onFailure(VungleError vungleError);
}
