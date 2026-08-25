package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class StaticCredentialsProvider implements AWSCredentialsProvider {
    private final AWSCredentials a;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.a = aWSCredentials;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials a() {
        return this.a;
    }
}
