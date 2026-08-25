package org.apache.tools.ant.taskdefs;

import java.util.Vector;
import org.apache.tools.ant.u;
import org.apache.tools.ant.v;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Parallel extends u implements v {
    private long k;
    private volatile boolean l;
    private boolean m;
    private boolean n;
    private Vector g = new Vector();
    private final Object h = new Object();
    private int i = 0;
    private int j = 0;
    private int o = 0;

    /* renamed from: org.apache.tools.ant.taskdefs.Parallel$1, reason: invalid class name */
    class AnonymousClass1 extends Thread {
        AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            try {
                wait(Parallel.this.k);
                synchronized (Parallel.this.h) {
                    Parallel.this.l = false;
                    Parallel.this.m = true;
                    Parallel.this.h.notifyAll();
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    private class TaskRunnable implements Runnable {
        private Throwable exception;
        private boolean finished;
        private u task;

        TaskRunnable(u uVar) {
            this.task = uVar;
        }

        public Throwable getException() {
            return this.exception;
        }

        boolean isFinished() {
            return this.finished;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.task.o();
                synchronized (Parallel.this.h) {
                    this.finished = true;
                    Parallel.this.h.notifyAll();
                }
            } catch (Throwable th) {
                try {
                    this.exception = th;
                    if (Parallel.this.n) {
                        Parallel.this.l = false;
                    }
                    synchronized (Parallel.this.h) {
                        this.finished = true;
                        Parallel.this.h.notifyAll();
                    }
                } catch (Throwable th2) {
                    synchronized (Parallel.this.h) {
                        this.finished = true;
                        Parallel.this.h.notifyAll();
                        throw th2;
                    }
                }
            }
        }
    }

    @Override // org.apache.tools.ant.v
    public void b(u uVar) {
        this.g.addElement(uVar);
    }
}
