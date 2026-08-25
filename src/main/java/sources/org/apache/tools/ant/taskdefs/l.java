package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class l implements h {
    private Thread a;
    private Thread b;
    private StreamPumper c;
    private OutputStream d;
    private OutputStream e;
    private InputStream f;

    public l() {
        this(System.out, System.err);
    }

    public l(OutputStream outputStream) {
        this(outputStream, outputStream);
    }

    public l(OutputStream outputStream, OutputStream outputStream2) {
        this(outputStream, outputStream2, null);
    }

    public l(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream) {
        this.d = outputStream;
        this.e = outputStream2;
        this.f = inputStream;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void a(InputStream inputStream) {
        OutputStream outputStream = this.e;
        if (outputStream != null) {
            e(inputStream, outputStream);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void b(OutputStream outputStream) {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            this.c = d(inputStream, outputStream, true);
        } else {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void c(InputStream inputStream) {
        f(inputStream, this.d);
    }

    StreamPumper d(InputStream inputStream, OutputStream outputStream, boolean z) {
        StreamPumper streamPumper = new StreamPumper(inputStream, outputStream, z);
        streamPumper.setAutoflush(true);
        return streamPumper;
    }

    protected void e(InputStream inputStream, OutputStream outputStream) {
        this.b = g(inputStream, outputStream);
    }

    protected void f(InputStream inputStream, OutputStream outputStream) {
        this.a = g(inputStream, outputStream);
    }

    protected Thread g(InputStream inputStream, OutputStream outputStream) {
        return h(inputStream, outputStream, false);
    }

    protected Thread h(InputStream inputStream, OutputStream outputStream, boolean z) {
        Thread thread = new Thread(new StreamPumper(inputStream, outputStream, z));
        thread.setDaemon(true);
        return thread;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void start() {
        this.a.start();
        this.b.start();
        if (this.c != null) {
            Thread thread = new Thread(this.c);
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void stop() {
        try {
            this.a.join();
        } catch (InterruptedException unused) {
        }
        try {
            this.b.join();
        } catch (InterruptedException unused2) {
        }
        StreamPumper streamPumper = this.c;
        if (streamPumper != null) {
            streamPumper.stop();
        }
        try {
            this.e.flush();
        } catch (IOException unused3) {
        }
        try {
            this.d.flush();
        } catch (IOException unused4) {
        }
    }
}
