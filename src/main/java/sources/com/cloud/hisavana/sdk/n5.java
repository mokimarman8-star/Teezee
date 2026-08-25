package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class n5 {
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;

    public n5(int i, int i2, String str, String str2, String str3, long j, String str4) {
        Intrinsics.h(str, "pkg");
        Intrinsics.h(str2, "dl_type");
        Intrinsics.h(str3, "codeSeatId");
        Intrinsics.h(str4, "ad_creative_id");
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = str4;
    }

    public /* synthetic */ n5(int i, int i2, String str, String str2, String str3, long j, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, str, str2, str3, (i3 & 32) != 0 ? 0L : j, str4);
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.g;
    }

    public final long c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n5)) {
            return false;
        }
        n5 n5Var = (n5) obj;
        return this.a == n5Var.a && this.b == n5Var.b && Intrinsics.c(this.c, n5Var.c) && Intrinsics.c(this.d, n5Var.d) && Intrinsics.c(this.e, n5Var.e) && this.f == n5Var.f && Intrinsics.c(this.g, n5Var.g);
    }

    public final String f() {
        return this.c;
    }

    public final int g() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + androidx.collection.s.a(this.f)) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "AttrClickEntity(_id=" + this.a + ", ac_type=" + this.b + ", pkg=" + this.c + ", dl_type=" + this.d + ", codeSeatId=" + this.e + ", click_ts=" + this.f + ", ad_creative_id=" + this.g + ')';
    }
}
