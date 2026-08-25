package org.apache.tools.ant.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class h extends OutputStream {
    private FileOutputStream a;
    private File b;
    private boolean c;
    private boolean d;
    private boolean e = false;
    private boolean f = false;

    public h(File file, boolean z, boolean z2) {
        this.b = file;
        this.c = z;
        this.d = z2;
    }

    private synchronized void d() {
        if (this.f) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.b);
            stringBuffer.append(" has already been closed.");
            throw new IOException(stringBuffer.toString());
        }
        if (!this.e) {
            this.a = new FileOutputStream(this.b.getAbsolutePath(), this.c);
            this.e = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.d && !this.f) {
                d();
            }
            if (this.e) {
                this.a.close();
            }
            this.f = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        d();
        this.a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        d();
        this.a.write(bArr, i, i2);
    }
}
