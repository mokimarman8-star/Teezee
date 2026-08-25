package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class x {
    private final String a;
    private final String b;
    private final int c;
    private final long d;
    private final d e;
    private final String f;
    private final String g;

    public x(String str, String str2, int i, long j, d dVar, String str3, String str4) {
        Intrinsics.h(str, "sessionId");
        Intrinsics.h(str2, "firstSessionId");
        Intrinsics.h(dVar, "dataCollectionStatus");
        Intrinsics.h(str3, "firebaseInstallationId");
        Intrinsics.h(str4, "firebaseAuthenticationToken");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.e = dVar;
        this.f = str3;
        this.g = str4;
    }

    public final d a() {
        return this.e;
    }

    public final long b() {
        return this.d;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.f;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.c(this.a, xVar.a) && Intrinsics.c(this.b, xVar.b) && this.c == xVar.c && this.d == xVar.d && Intrinsics.c(this.e, xVar.e) && Intrinsics.c(this.f, xVar.f) && Intrinsics.c(this.g, xVar.g);
    }

    public final String f() {
        return this.a;
    }

    public final int g() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + androidx.collection.s.a(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.a + ", firstSessionId=" + this.b + ", sessionIndex=" + this.c + ", eventTimestampUs=" + this.d + ", dataCollectionStatus=" + this.e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.g + ')';
    }
}
