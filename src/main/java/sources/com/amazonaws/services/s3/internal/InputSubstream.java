package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class InputSubstream extends SdkFilterInputStream {
    private long a;
    private final long b;
    private final long c;
    private final boolean d;
    private long e;

    public InputSubstream(InputStream inputStream, long j, long j2, boolean z) {
        super(inputStream);
        this.e = 0L;
        this.a = 0L;
        this.c = j2;
        this.b = j;
        this.d = z;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        long j = this.a;
        long j2 = this.b;
        return (int) Math.min(j < j2 ? this.c : (this.c + j2) - j, super.available());
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            super.close();
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.e = this.a;
        super.mark(i);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        long j;
        long j2;
        while (true) {
            j = this.a;
            j2 = this.b;
            if (j >= j2) {
                break;
            }
            this.a += super.skip(j2 - j);
        }
        long j3 = (this.c + j2) - j;
        if (j3 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i, (int) Math.min(i2, j3));
        this.a += read;
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.a = this.e;
        super.reset();
    }
}
