package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a extends InputStream {
    private com.bykv.vk.openvk.preload.geckox.buffer.a a;
    private long b;

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.a = aVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long b = this.a.b() - this.a.c();
        if (b > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.b = i;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.a.d();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.a.b(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.a.b(this.b);
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        return this.a.a(j);
    }
}
