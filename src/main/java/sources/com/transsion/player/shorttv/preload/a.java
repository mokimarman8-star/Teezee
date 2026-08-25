package com.transsion.player.shorttv.preload;

import androidx.collection.s;
import androidx.media3.exoplayer.offline.DownloadRequest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final String a;
    private final String b;
    private final DownloadRequest c;
    private long d;
    private long e;
    private long f;
    private final boolean g;

    public a(String str, String str2, DownloadRequest downloadRequest, long j, long j2, long j3, boolean z) {
        Intrinsics.h(str, "id");
        Intrinsics.h(str2, "url");
        Intrinsics.h(downloadRequest, "request");
        this.a = str;
        this.b = str2;
        this.c = downloadRequest;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = z;
    }

    public final long a() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }

    public final String c() {
        return this.a;
    }

    public final long d() {
        return this.f;
    }

    public final DownloadRequest e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g;
    }

    public final boolean f() {
        return this.g;
    }

    public final void g(long j) {
        this.d = j;
    }

    public final void h(long j) {
        this.e = j;
    }

    public int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + s.a(this.d)) * 31) + s.a(this.e)) * 31) + s.a(this.f)) * 31) + androidx.compose.foundation.e.a(this.g);
    }

    public final void i(long j) {
        this.f = j;
    }

    public String toString() {
        return "VideoDownloadBean(id=" + this.a + ", url=" + this.b + ", request=" + this.c + ", contentLength=" + this.d + ", downloadLength=" + this.e + ", maxLength=" + this.f + ", isAdd=" + this.g + ")";
    }
}
