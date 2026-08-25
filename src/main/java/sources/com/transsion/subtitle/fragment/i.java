package com.transsion.subtitle.fragment;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i {
    private final String a;
    private final int b;
    private final int c;

    public i(String name, int i, int i2) {
        Intrinsics.h(name, "name");
        this.a = name;
        this.b = i;
        this.c = i2;
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.c(this.a, iVar.a) && this.b == iVar.b && this.c == iVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "SubtitleSearchKeyword(name=" + this.a + ", season=" + this.b + ", episode=" + this.c + ")";
    }
}
