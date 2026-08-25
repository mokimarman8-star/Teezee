package com.facebook.biddingkit.http.client;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum HttpMethod {
    GET(true, false),
    POST(true, true);

    private boolean doInput;
    private boolean doOutput;

    HttpMethod(boolean z, boolean z2) {
        this.doInput = z;
        this.doOutput = z2;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public String getMethodName() {
        return toString();
    }
}
