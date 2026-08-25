package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b {
    private int a;
    private String b;
    private long c;
    private String d;

    public b(int i, String str, long j, String str2) {
        Intrinsics.h(str, "pkg");
        Intrinsics.h(str2, "ad_creative_id");
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = str2;
    }

    public /* synthetic */ b(int i, String str, long j, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, (i2 & 4) != 0 ? 0L : j, str2);
    }

    public final String a() {
        return this.d;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.c(this.b, bVar.b) && this.c == bVar.c && Intrinsics.c(this.d, bVar.d);
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + androidx.collection.s.a(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AttrImpressionEntity(_id=" + this.a + ", pkg=" + this.b + ", imp_ts=" + this.c + ", ad_creative_id=" + this.d + ')';
    }
}
