package com.wecloud.load.lib;

import androidx.collection.s;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class n {
    public static final a m = new a(null);
    private final String a;
    private final String b;
    private final boolean c;
    private final int d;
    private final String e;
    private final String f;
    private final int g;
    private final Map h;
    private final String i;
    private final long j;
    private final long k;
    private final String l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n(String url, String method, boolean z, int i, String serverIp, String errorMessage, int i2, Map httpHeaders, String httpBody, long j, long j2, String httpProtocol) {
        Intrinsics.h(url, "url");
        Intrinsics.h(method, "method");
        Intrinsics.h(serverIp, "serverIp");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(httpHeaders, "httpHeaders");
        Intrinsics.h(httpBody, "httpBody");
        Intrinsics.h(httpProtocol, "httpProtocol");
        this.a = url;
        this.b = method;
        this.c = z;
        this.d = i;
        this.e = serverIp;
        this.f = errorMessage;
        this.g = i2;
        this.h = httpHeaders;
        this.i = httpBody;
        this.j = j;
        this.k = j2;
        this.l = httpProtocol;
    }

    public final n a(String url, String method, boolean z, int i, String serverIp, String errorMessage, int i2, Map httpHeaders, String httpBody, long j, long j2, String httpProtocol) {
        Intrinsics.h(url, "url");
        Intrinsics.h(method, "method");
        Intrinsics.h(serverIp, "serverIp");
        Intrinsics.h(errorMessage, "errorMessage");
        Intrinsics.h(httpHeaders, "httpHeaders");
        Intrinsics.h(httpBody, "httpBody");
        Intrinsics.h(httpProtocol, "httpProtocol");
        return new n(url, method, z, i, serverIp, errorMessage, i2, httpHeaders, httpBody, j, j2, httpProtocol);
    }

    public final long c() {
        return this.k;
    }

    public final int d() {
        return this.g;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(this.a, nVar.a) && Intrinsics.c(this.b, nVar.b) && this.c == nVar.c && this.d == nVar.d && Intrinsics.c(this.e, nVar.e) && Intrinsics.c(this.f, nVar.f) && this.g == nVar.g && Intrinsics.c(this.h, nVar.h) && Intrinsics.c(this.i, nVar.i) && this.j == nVar.j && this.k == nVar.k && Intrinsics.c(this.l, nVar.l);
    }

    public final String f() {
        return this.i;
    }

    public final Map g() {
        return this.h;
    }

    public final String h() {
        return this.l;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.c)) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + s.a(this.j)) * 31) + s.a(this.k)) * 31) + this.l.hashCode();
    }

    public final String i() {
        return this.b;
    }

    public final long j() {
        return this.j;
    }

    public final String k() {
        return this.e;
    }

    public final int l() {
        return this.d;
    }

    public final boolean m() {
        return this.c;
    }

    public final String n() {
        return this.a;
    }

    public String toString() {
        return "ProbeResult(url=" + this.a + ", method=" + this.b + ", success=" + this.c + ", statusCode=" + this.d + ", serverIp=" + this.e + ", errorMessage=" + this.f + ", errorCode=" + this.g + ", httpHeaders=" + this.h + ", httpBody=" + this.i + ", requestTime=" + this.j + ", duration=" + this.k + ", httpProtocol=" + this.l + ")";
    }
}
