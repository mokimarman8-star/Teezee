package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {
    private int a;
    private final ProgressListenerCallbackExecutor b;
    private int c;
    private boolean d;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.a = 8192;
        this.b = progressListenerCallbackExecutor;
    }

    private void l(int i) {
        int i2 = this.c + i;
        this.c = i2;
        if (i2 >= this.a) {
            this.b.c(new ProgressEvent(i2));
            this.c = 0;
        }
    }

    private void m() {
        if (this.d) {
            ProgressEvent progressEvent = new ProgressEvent(this.c);
            progressEvent.c(4);
            this.c = 0;
            this.b.c(progressEvent);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i = this.c;
        if (i > 0) {
            this.b.c(new ProgressEvent(i));
            this.c = 0;
        }
        super.close();
    }

    public void n(boolean z) {
        this.d = z;
    }

    public void o(int i) {
        this.a = i * 1024;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read == -1) {
            m();
        } else {
            l(1);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            m();
        }
        if (read != -1) {
            l(read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.c);
        progressEvent.c(32);
        this.b.c(progressEvent);
        this.c = 0;
    }
}
