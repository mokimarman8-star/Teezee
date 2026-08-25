package com.cloud.hisavana.sdk.data.bean.inapp;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DefaultDataDTO {
    private List<DefaultAdDTO> bannerAds;
    private List<DefaultAdDTO> iconAds;
    private List<DefaultAdDTO> interstitialAds;
    private List<DefaultAdDTO> nativeAds;
    private List<PsAppInfo> psAppInfoList;
    private List<DefaultAdDTO> rewardedAds;
    private List<DefaultAdDTO> splashAds;
    private Long version;
    private String zipUrl;

    public int describeContents() {
        return 0;
    }

    public List<DefaultAdDTO> getBannerAds() {
        return this.bannerAds;
    }

    public List<DefaultAdDTO> getIconAds() {
        return this.iconAds;
    }

    public List<DefaultAdDTO> getInterstitialAds() {
        return this.interstitialAds;
    }

    public List<DefaultAdDTO> getNativeAds() {
        return this.nativeAds;
    }

    public List<PsAppInfo> getPsAppInfoList() {
        return this.psAppInfoList;
    }

    public List<DefaultAdDTO> getRewardedAds() {
        return this.rewardedAds;
    }

    public List<DefaultAdDTO> getSplashAds() {
        return this.splashAds;
    }

    public Long getVersion() {
        Long l = this.version;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public void setVersion(Long l) {
        this.version = l;
    }
}
