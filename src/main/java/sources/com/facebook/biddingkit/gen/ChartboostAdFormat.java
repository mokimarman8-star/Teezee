package com.facebook.biddingkit.gen;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum ChartboostAdFormat {
    INTERSTITIAL(true, 1, 480, 320, 7, "interstitial"),
    REWARDED_VIDEO(true, 1, 480, 320, 7, "rewarded"),
    BANNER(false, 0, 50, 320, 1, "banner");

    private final boolean mHasVideo;
    private final int mHeight;
    private final int mInstl;
    private final String mPlacementType;
    private final int mPos;
    private final int mWidth;

    ChartboostAdFormat(boolean z, int i, int i2, int i3, int i4, String str) {
        this.mHasVideo = z;
        this.mInstl = i;
        this.mHeight = i2;
        this.mWidth = i3;
        this.mPos = i4;
        this.mPlacementType = str;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getInstl() {
        return this.mInstl;
    }

    public String getPlacementType() {
        return this.mPlacementType;
    }

    public int getPos() {
        return this.mPos;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasVideo() {
        return this.mHasVideo;
    }
}
