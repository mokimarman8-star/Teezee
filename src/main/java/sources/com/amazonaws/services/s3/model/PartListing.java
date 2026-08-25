package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PartListing implements S3RequesterChargedResult {
    private String a;
    private String b;
    private String c;
    private Integer d;
    private Integer e;
    private String f;
    private Owner g;
    private Owner h;
    private String i;
    private boolean j;
    private Integer k;
    private List l;
    private boolean m;

    public List a() {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        return this.l;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(Owner owner) {
        this.h = owner;
    }

    public void e(String str) {
        this.b = str;
    }

    public void f(int i) {
        this.d = Integer.valueOf(i);
    }

    public void g(int i) {
        this.k = Integer.valueOf(i);
    }

    public void h(Owner owner) {
        this.g = owner;
    }

    public void i(int i) {
        this.e = Integer.valueOf(i);
    }

    public void j(String str) {
        this.i = str;
    }

    public void k(boolean z) {
        this.j = z;
    }

    public void l(String str) {
        this.c = str;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.m = z;
    }
}
