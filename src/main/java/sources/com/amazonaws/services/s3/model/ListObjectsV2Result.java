package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ListObjectsV2Result {
    private List a = new ArrayList();
    private List b = new ArrayList();
    private boolean c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String l;

    public String a() {
        return this.d;
    }

    public List b() {
        return this.b;
    }

    public String c() {
        return this.f;
    }

    public List d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public void f(String str) {
        this.d = str;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.j = str;
    }

    public void j(int i) {
        this.e = i;
    }

    public void k(int i) {
        this.i = i;
    }

    public void l(String str) {
        this.f = str;
    }

    public void m(String str) {
        this.g = str;
    }

    public void n(String str) {
        this.l = str;
    }

    public void o(boolean z) {
        this.c = z;
    }
}
