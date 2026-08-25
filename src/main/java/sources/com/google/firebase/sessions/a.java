package com.google.firebase.sessions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final p e;
    private final List f;

    public a(String str, String str2, String str3, String str4, p pVar, List list) {
        Intrinsics.h(str, "packageName");
        Intrinsics.h(str2, "versionName");
        Intrinsics.h(str3, "appBuildVersion");
        Intrinsics.h(str4, "deviceManufacturer");
        Intrinsics.h(pVar, "currentProcessDetails");
        Intrinsics.h(list, "appProcessDetails");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = pVar;
        this.f = list;
    }

    public final String a() {
        return this.c;
    }

    public final List b() {
        return this.f;
    }

    public final p c() {
        return this.e;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
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
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && Intrinsics.c(this.e, aVar.e) && Intrinsics.c(this.f, aVar.f);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.a + ", versionName=" + this.b + ", appBuildVersion=" + this.c + ", deviceManufacturer=" + this.d + ", currentProcessDetails=" + this.e + ", appProcessDetails=" + this.f + ')';
    }
}
