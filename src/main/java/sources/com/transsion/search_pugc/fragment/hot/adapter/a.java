package com.transsion.search_pugc.fragment.hot.adapter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final int a;
    private final String b;

    public a(int i, String str) {
        Intrinsics.h(str, "strVal");
        this.a = i;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && Intrinsics.c(this.b, aVar.b);
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "HistoryVal(type=" + this.a + ", strVal=" + this.b + ")";
    }
}
