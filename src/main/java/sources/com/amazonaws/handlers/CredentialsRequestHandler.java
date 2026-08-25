package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {
    protected AWSCredentials a;

    public void e(AWSCredentials aWSCredentials) {
        this.a = aWSCredentials;
    }
}
