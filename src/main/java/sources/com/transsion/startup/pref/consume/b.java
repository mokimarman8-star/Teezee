package com.transsion.startup.pref.consume;

import androidx.collection.s;
import androidx.compose.foundation.e;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final boolean f;

    public b(long j, long j2, long j3, long j4, long j5, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = z;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
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
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
    }

    public final long f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((s.a(this.a) * 31) + s.a(this.b)) * 31) + s.a(this.c)) * 31) + s.a(this.d)) * 31) + s.a(this.e)) * 31) + e.a(this.f);
    }

    public String toString() {
        return "StartupMetrics(splashTTID=" + this.a + ", adWaitDuration=" + this.b + ", mainActivityTTID=" + this.c + ", totalTTFD=" + this.d + ", realTTFD=" + this.e + ", hasAd=" + this.f + ")";
    }
}
