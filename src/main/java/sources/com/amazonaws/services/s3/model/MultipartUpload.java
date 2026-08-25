package com.amazonaws.services.s3.model;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MultipartUpload {
    private String a;
    private String b;
    private Owner c;
    private Owner d;
    private String e;
    private Date f;

    public void a(Date date) {
        this.f = date;
    }

    public void b(Owner owner) {
        this.d = owner;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(Owner owner) {
        this.c = owner;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.b = str;
    }
}
