package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class InitiateMultipartUploadResult extends SSEResultBase {
    private String a;
    private String b;
    private String c;

    public String a() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public void setBucketName(String str) {
        this.a = str;
    }

    public void setKey(String str) {
        this.b = str;
    }
}
