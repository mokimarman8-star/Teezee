package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {
    private int a;
    private String b;
    private boolean c;

    public String getETag() {
        return this.b;
    }

    public int getPartNumber() {
        return this.a;
    }

    public void setETag(String str) {
        this.b = str;
    }

    public void setPartNumber(int i) {
        this.a = i;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.c = z;
    }
}
