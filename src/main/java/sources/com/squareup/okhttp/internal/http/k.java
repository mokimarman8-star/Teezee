package com.squareup.okhttp.internal.http;

import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class k implements Sink {
    private boolean a;
    private final int b;
    private final Buffer c;

    public k() {
        this(-1);
    }

    public k(int i) {
        this.c = new Buffer();
        this.b = i;
    }

    public void close() {
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.c.size() >= this.b) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.size());
    }

    public long d() {
        return this.c.size();
    }

    public void f(Sink sink) {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.c;
        buffer2.copyTo(buffer, 0L, buffer2.size());
        sink.write(buffer, buffer.size());
    }

    public void flush() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j) {
        if (this.a) {
            throw new IllegalStateException("closed");
        }
        com.squareup.okhttp.internal.g.a(buffer.size(), 0L, j);
        if (this.b == -1 || this.c.size() <= this.b - j) {
            this.c.write(buffer, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    }
}
