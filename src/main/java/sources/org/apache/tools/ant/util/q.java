package org.apache.tools.ant.util;

import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class q extends OutputStream {
    private OutputStream a;
    private OutputStream b;

    public q(OutputStream outputStream, OutputStream outputStream2) {
        this.a = outputStream;
        this.b = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.a.close();
        } finally {
            this.b.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.a.flush();
        this.b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.a.write(i);
        this.b.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.a.write(bArr);
        this.b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
        this.b.write(bArr, i, i2);
    }
}
