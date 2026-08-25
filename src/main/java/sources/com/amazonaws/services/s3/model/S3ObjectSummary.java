package com.amazonaws.services.s3.model;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class S3ObjectSummary {
    protected String a;
    protected String b;
    protected String c;
    protected long d;
    protected Date e;
    protected String f;
    protected Owner g;

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public void e(Date date) {
        this.e = date;
    }

    public void f(Owner owner) {
        this.g = owner;
    }

    public void g(long j) {
        this.d = j;
    }

    public void h(String str) {
        this.f = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.a + "', key='" + this.b + "', eTag='" + this.c + "', size=" + this.d + ", lastModified=" + this.e + ", storageClass='" + this.f + "', owner=" + this.g + '}';
    }
}
