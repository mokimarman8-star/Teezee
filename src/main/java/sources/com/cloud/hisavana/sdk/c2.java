package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c2 {
    private final String a;
    private final String b;
    private final int c;
    private final Double d;
    private final int e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final int j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;

    public c2(String str, String str2, int i, Double d, int i2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.h(str, "ad_creative_id");
        Intrinsics.h(str2, "codeSeatId");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = d;
        this.e = i2;
        this.f = i3;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = i4;
        this.k = str6;
        this.l = str7;
        this.m = str8;
        this.n = str9;
        this.o = str10;
        this.p = str11;
    }

    public final String a() {
        return this.p;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return Intrinsics.c(this.a, c2Var.a) && Intrinsics.c(this.b, c2Var.b) && this.c == c2Var.c && Intrinsics.c(this.d, c2Var.d) && this.e == c2Var.e && this.f == c2Var.f && Intrinsics.c(this.g, c2Var.g) && Intrinsics.c(this.h, c2Var.h) && Intrinsics.c(this.i, c2Var.i) && this.j == c2Var.j && Intrinsics.c(this.k, c2Var.k) && Intrinsics.c(this.l, c2Var.l) && Intrinsics.c(this.m, c2Var.m) && Intrinsics.c(this.n, c2Var.n) && Intrinsics.c(this.o, c2Var.o) && Intrinsics.c(this.p, c2Var.p);
    }

    public final String f() {
        return this.o;
    }

    public final String g() {
        return this.n;
    }

    public final String h() {
        return this.m;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        Double d = this.d;
        int hashCode2 = (((((hashCode + (d == null ? 0 : d.hashCode())) * 31) + this.e) * 31) + this.f) * 31;
        String str = this.g;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.h;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.i;
        int hashCode5 = (((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.j) * 31;
        String str4 = this.k;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.l;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.m;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.n;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.o;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.p;
        return hashCode10 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String i() {
        return this.l;
    }

    public final int j() {
        return this.j;
    }

    public final String k() {
        return this.g;
    }

    public final int l() {
        return this.f;
    }

    public final String m() {
        return this.i;
    }

    public final String n() {
        return this.k;
    }

    public final Double o() {
        return this.d;
    }

    public final String p() {
        return this.h;
    }

    public String toString() {
        return "DefaultAdEntity(ad_creative_id=" + this.a + ", codeSeatId=" + this.b + ", ad_type=" + this.c + ", price=" + this.d + ", ad_request_ver=" + this.e + ", displayed_times=" + this.f + ", displayed_date=" + this.g + ", start_date=" + this.h + ", end_date=" + this.i + ", display_max_times=" + this.j + ", file_path=" + this.k + ", default_country_white=" + this.l + ", default_country_black=" + this.m + ", default_brand_white=" + this.n + ", default_brand_black=" + this.o + ", ad_bean=" + this.p + ')';
    }
}
