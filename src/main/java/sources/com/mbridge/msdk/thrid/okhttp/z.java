package com.mbridge.msdk.thrid.okhttp;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class z implements Closeable {

    static class a extends z {
        final /* synthetic */ long a;
        final /* synthetic */ com.mbridge.msdk.thrid.okio.e b;

        a(s sVar, long j, com.mbridge.msdk.thrid.okio.e eVar) {
            this.a = j;
            this.b = eVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public long h() {
            return this.a;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public com.mbridge.msdk.thrid.okio.e k() {
            return this.b;
        }
    }

    public static z a(s sVar, long j, com.mbridge.msdk.thrid.okio.e eVar) {
        if (eVar != null) {
            return new a(sVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static z a(s sVar, byte[] bArr) {
        return a(sVar, bArr.length, new com.mbridge.msdk.thrid.okio.c().write(bArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(k());
    }

    public final InputStream d() {
        return k().j();
    }

    public abstract long h();

    public abstract com.mbridge.msdk.thrid.okio.e k();
}
