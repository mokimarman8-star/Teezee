package com.cloud.hisavana.sdk.data.bean.response;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ConfigTotalDTO$ExtInfo {
    int oldStyle = 20;
    int scoreStyle = 40;
    int downloadStyle = 40;
    float scoreCount = 4.0f;
    long downloadCount = 100000;
    Boolean requestStatusOff = Boolean.TRUE;
    boolean isUseCustomTabsToOpenLandingPage = false;
    long adReqInterval = 0;
    int clientSamplingRatio = 10;
    boolean enableClientSampling = true;
    int showWebLetterAdPrice = 10;

    public long getAdReqInterval() {
        return this.adReqInterval;
    }

    public int getClientSamplingRatio() {
        return this.clientSamplingRatio;
    }

    public long getDownloadCount() {
        return this.downloadCount;
    }

    public int getDownloadStyle() {
        return this.downloadStyle;
    }

    public int getOldStyle() {
        return this.oldStyle;
    }

    public boolean getRequestStatusOff() {
        Boolean bool = this.requestStatusOff;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public float getScoreCount() {
        return this.scoreCount;
    }

    public int getScoreStyle() {
        return this.scoreStyle;
    }

    public int getShowWebLetterAdPrice() {
        return this.showWebLetterAdPrice;
    }

    public boolean isEnableClientSampling() {
        return this.enableClientSampling;
    }

    public boolean isUseCustomTabsToOpenLandingPage() {
        return this.isUseCustomTabsToOpenLandingPage;
    }

    public void setClientSamplingRatio(int i) {
        this.clientSamplingRatio = i;
    }
}
