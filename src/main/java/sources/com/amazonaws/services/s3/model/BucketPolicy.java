package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class BucketPolicy implements Serializable {
    private String policyText;

    public String getPolicyText() {
        return this.policyText;
    }

    public void setPolicyText(String str) {
        this.policyText = str;
    }
}
