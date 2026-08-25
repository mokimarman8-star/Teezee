package com.bytedance.sdk.openadsdk.api.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PAGErrorModel {
    private final int Sj;
    private final String sP;

    public PAGErrorModel(int i, String str) {
        this.Sj = i;
        this.sP = str;
    }

    public int getErrorCode() {
        return this.Sj;
    }

    public String getErrorMessage() {
        return this.sP;
    }
}
