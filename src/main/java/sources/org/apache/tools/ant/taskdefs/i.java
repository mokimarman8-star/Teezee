package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.util.Watchdog;
import org.apache.tools.ant.util.r;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class i implements r {
    private Process a;
    private volatile boolean b = false;
    private Exception c = null;
    private volatile boolean d = false;
    private Watchdog e;

    public i(long j) {
        Watchdog watchdog = new Watchdog(j);
        this.e = watchdog;
        watchdog.addTimeoutObserver(this);
    }

    public synchronized void a() {
        if (this.c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception in ExecuteWatchdog.run: ");
            stringBuffer.append(this.c.getMessage());
            throw new BuildException(stringBuffer.toString(), this.c);
        }
    }

    protected synchronized void b() {
        this.b = false;
        this.a = null;
    }

    public boolean c() {
        return this.d;
    }

    public synchronized void d(Process process) {
        if (process == null) {
            throw new NullPointerException("process is null.");
        }
        if (this.a != null) {
            throw new IllegalStateException("Already running.");
        }
        this.c = null;
        this.d = false;
        this.b = true;
        this.a = process;
        this.e.start();
    }

    public synchronized void e() {
        this.e.stop();
        b();
    }

    @Override // org.apache.tools.ant.util.r
    public synchronized void timeoutOccured(Watchdog watchdog) {
        try {
            try {
                try {
                    this.a.exitValue();
                } catch (IllegalThreadStateException unused) {
                    if (this.b) {
                        this.d = true;
                        this.a.destroy();
                    }
                }
            } catch (Exception e) {
                this.c = e;
            }
        } finally {
            b();
        }
    }
}
