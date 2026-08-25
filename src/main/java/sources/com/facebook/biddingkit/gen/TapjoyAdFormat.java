package com.facebook.biddingkit.gen;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum TapjoyAdFormat {
    INTERSTITIAL(true, false, "video"),
    REWARDED_VIDEO(false, true, "video");

    private final String mFormatLabel;
    private final boolean mIsRewarded;
    private final boolean mIsSkippable;

    TapjoyAdFormat(boolean z, boolean z2, String str) {
        this.mIsSkippable = z;
        this.mIsRewarded = z2;
        this.mFormatLabel = str;
    }

    public String getFormatLabel() {
        return this.mFormatLabel;
    }

    public int isRewarded() {
        return this.mIsRewarded ? 1 : 0;
    }

    public int isSkippable() {
        return this.mIsSkippable ? 1 : 0;
    }
}
