package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ResponseHeaderOverrides extends AmazonWebServiceRequest {
    private static final String[] g = {"response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires"};
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String g() {
        return this.b;
    }

    public String getContentType() {
        return this.a;
    }

    public String i() {
        return this.c;
    }
}
