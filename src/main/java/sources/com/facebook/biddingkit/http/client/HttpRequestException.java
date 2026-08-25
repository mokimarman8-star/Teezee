package com.facebook.biddingkit.http.client;

import n8.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class HttpRequestException extends Exception {
    private static final long serialVersionUID = -2413629666163901633L;
    private e httpResponse;

    public HttpRequestException(Exception exc, e eVar) {
        super(exc);
        this.httpResponse = eVar;
    }

    public e getHttpResponse() {
        return this.httpResponse;
    }
}
