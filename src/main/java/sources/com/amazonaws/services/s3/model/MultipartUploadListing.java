package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MultipartUploadListing {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private boolean h;
    private String i;
    private String j;
    private List k;
    private List l = new ArrayList();

    public List a() {
        return this.l;
    }

    public List b() {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        return this.k;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(int i) {
        this.f = i;
    }

    public void h(String str) {
        this.i = str;
    }

    public void i(String str) {
        this.j = str;
    }

    public void j(String str) {
        this.d = str;
    }

    public void k(boolean z) {
        this.h = z;
    }

    public void l(String str) {
        this.e = str;
    }
}
