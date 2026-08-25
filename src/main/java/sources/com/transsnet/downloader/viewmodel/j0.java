package com.transsnet.downloader.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j0 {
    private int a;
    private String b;
    private String c;
    private String d;
    private Long e;
    private Long f;
    private Long g;
    private int h;
    private int i;

    public j0(int i, String str, String str2, String str3, Long l, Long l2, Long l3, int i2, int i3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = l;
        this.f = l2;
        this.g = l3;
        this.h = i2;
        this.i = i3;
    }

    public final Long a() {
        return this.g;
    }

    public final int b() {
        return this.i;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.a == j0Var.a && Intrinsics.c(this.b, j0Var.b) && Intrinsics.c(this.c, j0Var.c) && Intrinsics.c(this.d, j0Var.d) && Intrinsics.c(this.e, j0Var.e) && Intrinsics.c(this.f, j0Var.f) && Intrinsics.c(this.g, j0Var.g) && this.h == j0Var.h && this.i == j0Var.i;
    }

    public final int f() {
        return this.h;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.e;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.f;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.g;
        return ((((hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31) + this.h) * 31) + this.i;
    }

    public String toString() {
        return "Video(id=" + this.a + ", path=" + this.b + ", name=" + this.c + ", resolution=" + this.d + ", size=" + this.e + ", date=" + this.f + ", duration=" + this.g + ", width=" + this.h + ", height=" + this.i + ")";
    }
}
