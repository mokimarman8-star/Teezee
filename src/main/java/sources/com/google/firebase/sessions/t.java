package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class t {
    private final String a;
    private final String b;
    private final int c;
    private final long d;

    public t(String str, String str2, int i, long j) {
        Intrinsics.h(str, "sessionId");
        Intrinsics.h(str2, "firstSessionId");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.c(this.a, tVar.a) && Intrinsics.c(this.b, tVar.b) && this.c == tVar.c && this.d == tVar.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + androidx.collection.s.a(this.d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.a + ", firstSessionId=" + this.b + ", sessionIndex=" + this.c + ", sessionStartTimestampUs=" + this.d + ')';
    }
}
