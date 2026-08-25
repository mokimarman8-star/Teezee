package com.google.common.util.concurrent;

import com.google.common.collect.s3;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class ListenerCallQueue {
    private static final q a = new q(ListenerCallQueue.class);

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<a> waitQueue = s3.a();
        final Queue<Object> labelQueue = s3.a();

        PerListenerQueue(L l, Executor executor) {
            this.listener = (L) com.google.common.base.m.o(l);
            this.executor = (Executor) com.google.common.base.m.o(executor);
        }

        synchronized void add(a aVar, Object obj) {
            this.waitQueue.add(aVar);
            this.labelQueue.add(obj);
        }

        void dispatch() {
            boolean z;
            synchronized (this) {
                try {
                    if (this.isThreadScheduled) {
                        z = false;
                    } else {
                        z = true;
                        this.isThreadScheduled = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (Exception e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.a.a().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            r2.call(r9.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.a.a().log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.listener + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Throwable th;
            while (true) {
                boolean z2 = true;
                try {
                    synchronized (this) {
                        try {
                            com.google.common.base.m.u(this.isThreadScheduled);
                            a poll = this.waitQueue.poll();
                            Object poll2 = this.labelQueue.poll();
                            if (poll == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                    while (true) {
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            z = true;
                            th = th4;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        boolean z3 = z;
                        th = th5;
                        z2 = z3;
                        if (z2) {
                            synchronized (this) {
                                this.isThreadScheduled = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (z2) {
                    }
                    throw th;
                }
            }
        }
    }

    interface a {
        void call(Object obj);
    }
}
