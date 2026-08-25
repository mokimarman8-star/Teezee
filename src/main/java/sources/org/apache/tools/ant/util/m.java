package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class m {
    private OutputStream a;
    private int b = 0;
    private boolean c;
    private long d;

    private final class a extends OutputStream {
        private boolean a;

        private a() {
            this.a = false;
            synchronized (m.this) {
                m.a(m.this);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m.this.h(this);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            synchronized (m.this) {
                m.this.f();
                m.this.a.flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            synchronized (m.this) {
                m.this.f();
                m.this.a.write(i);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            synchronized (m.this) {
                m.this.f();
                m.this.a.write(bArr);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            synchronized (m.this) {
                m.this.f();
                m.this.a.write(bArr, i, i2);
            }
        }
    }

    public m(OutputStream outputStream, long j) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStreamFunneler.<init>:  out == null");
        }
        this.a = outputStream;
        this.c = false;
        i(j);
    }

    static /* synthetic */ int a(m mVar) {
        int i = mVar.b + 1;
        mVar.b = i;
        return i;
    }

    private synchronized void e() {
        try {
            f();
            this.a.close();
        } finally {
            this.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (this.c) {
            throw new IOException("The funneled OutputStream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(a aVar) {
        try {
            if (!aVar.a) {
                try {
                    long j = this.d;
                    if (j > 0) {
                        try {
                            wait(j);
                        } catch (InterruptedException unused) {
                        }
                    }
                    int i = this.b - 1;
                    this.b = i;
                    if (i == 0) {
                        e();
                    }
                    aVar.a = true;
                } catch (Throwable th) {
                    aVar.a = true;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized OutputStream g() {
        f();
        try {
        } finally {
            notifyAll();
        }
        return new a();
    }

    public synchronized void i(long j) {
        this.d = j;
    }
}
