package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final LogEnvironment e;
    private final a f;

    public b(String str, String str2, String str3, String str4, LogEnvironment logEnvironment, a aVar) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "deviceModel");
        Intrinsics.h(str3, "sessionSdkVersion");
        Intrinsics.h(str4, "osVersion");
        Intrinsics.h(logEnvironment, "logEnvironment");
        Intrinsics.h(aVar, "androidAppInfo");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = logEnvironment;
        this.f = aVar;
    }

    public final a a() {
        return this.f;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final LogEnvironment d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && Intrinsics.c(this.d, bVar.d) && this.e == bVar.e && Intrinsics.c(this.f, bVar.f);
    }

    public final String f() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.a + ", deviceModel=" + this.b + ", sessionSdkVersion=" + this.c + ", osVersion=" + this.d + ", logEnvironment=" + this.e + ", androidAppInfo=" + this.f + ')';
    }
}
