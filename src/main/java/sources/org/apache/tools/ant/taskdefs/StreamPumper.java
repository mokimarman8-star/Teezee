package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class StreamPumper implements Runnable {
    private static final int SMALL_BUFFER_SIZE = 128;
    private boolean autoflush;
    private int bufferSize;
    private boolean closeWhenExhausted;
    private Exception exception;
    private volatile boolean finish;
    private volatile boolean finished;

    /* renamed from: is, reason: collision with root package name */
    private InputStream f12is;

    /* renamed from: os, reason: collision with root package name */
    private OutputStream f13os;
    private boolean started;

    public StreamPumper(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    public StreamPumper(InputStream inputStream, OutputStream outputStream, boolean z) {
        this.autoflush = false;
        this.exception = null;
        this.bufferSize = 128;
        this.started = false;
        this.f12is = inputStream;
        this.f13os = outputStream;
        this.closeWhenExhausted = z;
    }

    public synchronized int getBufferSize() {
        return this.bufferSize;
    }

    public synchronized Exception getException() {
        return this.exception;
    }

    public boolean isFinished() {
        return this.finished;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.started = true;
        }
        this.finished = false;
        this.finish = false;
        byte[] bArr = new byte[this.bufferSize];
        while (true) {
            try {
                try {
                    int read = this.f12is.read(bArr);
                    if (read <= 0 || this.finish) {
                        break;
                    }
                    this.f13os.write(bArr, 0, read);
                    if (this.autoflush) {
                        this.f13os.flush();
                    }
                } catch (Exception e) {
                    synchronized (this) {
                        this.exception = e;
                        if (this.closeWhenExhausted) {
                            try {
                                this.f13os.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.finished = true;
                        synchronized (this) {
                            notifyAll();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                if (this.closeWhenExhausted) {
                    try {
                        this.f13os.close();
                    } catch (IOException unused2) {
                    }
                }
                this.finished = true;
                synchronized (this) {
                    notifyAll();
                    throw th;
                }
            }
        }
        this.f13os.flush();
        if (this.closeWhenExhausted) {
            try {
                this.f13os.close();
            } catch (IOException unused3) {
            }
        }
        this.finished = true;
        synchronized (this) {
            notifyAll();
        }
    }

    void setAutoflush(boolean z) {
        this.autoflush = z;
    }

    public synchronized void setBufferSize(int i) {
        if (this.started) {
            throw new IllegalStateException("Cannot set buffer size on a running StreamPumper");
        }
        this.bufferSize = i;
    }

    synchronized void stop() {
        this.finish = true;
        notifyAll();
    }

    public synchronized void waitFor() throws InterruptedException {
        while (!isFinished()) {
            wait();
        }
    }
}
