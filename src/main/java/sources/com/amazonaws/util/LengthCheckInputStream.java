package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {
    private final long a;
    private final boolean b;
    private long c;
    private long d;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.a = j;
        this.b = z;
    }

    private void l(boolean z) {
        if (z) {
            if (this.c == this.a) {
                return;
            }
            throw new AmazonClientException("Data read (" + this.c + ") has a different length than the expected (" + this.a + ")");
        }
        if (this.c <= this.a) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.c + ") than expected (" + this.a + ")");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.d = this.c;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read >= 0) {
            this.c++;
        }
        l(read == -1);
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        this.c += read >= 0 ? read : 0L;
        l(read == -1);
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        if (super.markSupported()) {
            this.c = this.d;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (this.b && skip > 0) {
            this.c += skip;
            l(false);
        }
        return skip;
    }
}
