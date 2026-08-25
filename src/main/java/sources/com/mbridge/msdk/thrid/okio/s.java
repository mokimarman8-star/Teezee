package com.mbridge.msdk.thrid.okio;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface s extends Closeable {
    long b(c cVar, long j) throws IOException;

    t b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
