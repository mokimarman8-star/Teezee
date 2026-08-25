package com.amazonaws.services.s3.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DeleteObjectsResponse implements S3RequesterChargedResult {
    private List a;
    private List b;
    private boolean c;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public DeleteObjectsResponse(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public List a() {
        return this.a;
    }

    public List b() {
        return this.b;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.c = z;
    }
}
