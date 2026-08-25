package com.mbridge.msdk.advanced.request;

import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.a;
    }

    public void d(int i) {
        this.a = i;
    }

    public String e() {
        return this.b;
    }

    @NonNull
    public String toString() {
        return "NativeAdvancedV3ParamsEntity{reqType=" + this.a + ", session_id='" + this.b + "', offset=" + this.c + ", expectWidth=" + this.d + ", expectHeight=" + this.e + '}';
    }
}
