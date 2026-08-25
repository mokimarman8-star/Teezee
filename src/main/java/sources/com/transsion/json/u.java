package com.transsion.json;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class u {
    private a a;
    private int b = 0;
    private String c;

    public u(a aVar) {
        this.a = aVar;
    }

    public void a() {
        this.b = Math.max(this.b - 1, 0);
    }

    public void b(String str) {
        this.c = str;
    }

    public a c() {
        return this.a;
    }

    public void d() {
        this.b++;
    }

    public boolean e() {
        return this.b != 0;
    }
}
