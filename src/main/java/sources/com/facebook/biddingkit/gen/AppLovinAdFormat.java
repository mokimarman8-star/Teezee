package com.facebook.biddingkit.gen;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum AppLovinAdFormat {
    INTERSTITIAL(320, 480, 1, "", "banner", "video"),
    BANNER(320, 50, 0, "", "banner"),
    MREC(300, 250, 0, "", "banner"),
    REWARDED_VIDEO(480, 320, 0, "rewarded", "banner", "video");

    private final String mFirstFormatLabel;
    private final int mHeight;
    private final int mInstl;
    private final String mRewarded;
    private final String mSecondFormatLabel;
    private final int mWidth;

    AppLovinAdFormat(int i, int i2, int i3, String str, String str2) {
        this(i, i2, i3, str, str2, "");
    }

    AppLovinAdFormat(int i, int i2, int i3, String str, String str2, String str3) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mInstl = i3;
        this.mRewarded = str;
        this.mFirstFormatLabel = str2;
        this.mSecondFormatLabel = str3;
    }

    public String getFormatLabel() {
        return this.mFirstFormatLabel;
    }

    public int getHeight(boolean z) {
        return z ? this.mWidth : this.mHeight;
    }

    public int getInstl() {
        return this.mInstl;
    }

    public String getRewarded() {
        return this.mRewarded;
    }

    public String getSecondFormatLabelLabel() {
        return this.mSecondFormatLabel;
    }

    public int getWidth(boolean z) {
        return z ? this.mHeight : this.mWidth;
    }
}
