package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface DownloadFileOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j) throws IOException, IllegalAccessException;

    void setLength(long j) throws IOException, IllegalAccessException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
