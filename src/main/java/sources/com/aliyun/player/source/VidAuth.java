package com.aliyun.player.source;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class VidAuth extends VidSourceBase {
    private String mPlayAuth;
    private String mRegion;
    private String mVid;

    public String getPlayAuth() {
        return this.mPlayAuth;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public String getVid() {
        return this.mVid;
    }

    public void setPlayAuth(String str) {
        this.mPlayAuth = str;
    }

    public void setQuality(String str, boolean z) {
        this.mQuality = str;
        this.mForceQuality = z;
    }

    public void setRegion(String str) {
        this.mRegion = str;
    }

    public void setVid(String str) {
        this.mVid = str;
    }
}
