package com.bytedance.sdk.openadsdk.api.reward;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PAGRewardItem {
    private final int Sj;
    private final String sP;

    public PAGRewardItem(int i, String str) {
        this.Sj = i;
        this.sP = str;
    }

    public int getRewardAmount() {
        return this.Sj;
    }

    public String getRewardName() {
        return this.sP;
    }
}
