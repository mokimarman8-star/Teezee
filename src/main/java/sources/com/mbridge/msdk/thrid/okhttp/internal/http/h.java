package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.z;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h extends z {
    private final String a;
    private final long b;
    private final com.mbridge.msdk.thrid.okio.e c;

    public h(String str, long j, com.mbridge.msdk.thrid.okio.e eVar) {
        this.a = str;
        this.b = j;
        this.c = eVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public long h() {
        return this.b;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public com.mbridge.msdk.thrid.okio.e k() {
        return this.c;
    }
}
