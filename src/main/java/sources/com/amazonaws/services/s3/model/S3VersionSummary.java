package com.amazonaws.services.s3.model;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class S3VersionSummary {
    protected String a;
    private String b;
    private String c;
    private boolean d;
    private Date e;
    private Owner f;
    private String g;
    private long h;
    private String i;
    private boolean j;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public void e(String str) {
        this.b = str;
    }

    public void f(Date date) {
        this.e = date;
    }

    public void g(Owner owner) {
        this.f = owner;
    }

    public void h(long j) {
        this.h = j;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.c = str;
    }
}
