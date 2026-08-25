package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ListVersionsRequest extends AmazonWebServiceRequest {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Integer f;
    private String g;

    public ListVersionsRequest() {
    }

    public ListVersionsRequest(String str, String str2, String str3, String str4, String str5, Integer num) {
        setBucketName(str);
        e(str2);
        d(str3);
        g(str4);
        b(str5);
        setMaxResults(num);
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.d = str;
    }

    public ListVersionsRequest h(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.a = str;
    }

    public void setMaxResults(Integer num) {
        this.f = num;
    }
}
