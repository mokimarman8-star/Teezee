package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ListObjectsRequest extends AmazonWebServiceRequest {
    private String a;
    private String b;
    private String c;
    private String d;
    private Integer e;
    private String f;

    public ListObjectsRequest() {
    }

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        e(str2);
        setMarker(str3);
        b(str4);
        d(num);
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(Integer num) {
        this.e = num;
    }

    public void e(String str) {
        this.b = str;
    }

    public ListObjectsRequest g(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.a = str;
    }

    public void setMarker(String str) {
        this.c = str;
    }
}
