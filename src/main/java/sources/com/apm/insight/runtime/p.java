package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class p {
    private final HandlerThread a;
    private volatile Handler d;
    private final Queue<c> b = new ConcurrentLinkedQueue();
    private final Queue<Message> c = new ConcurrentLinkedQueue();
    private final Object e = new Object();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!p.this.c.isEmpty()) {
                if (p.this.d != null) {
                    try {
                        p.this.d.sendMessageAtFrontOfQueue((Message) p.this.c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!p.this.b.isEmpty()) {
                c cVar = (c) p.this.b.poll();
                if (p.this.d != null) {
                    try {
                        p.this.d.sendMessageAtTime(cVar.a, cVar.b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    class b extends HandlerThread {
        private volatile int a;
        private volatile boolean b;

        b(String str) {
            super(str);
            this.a = 0;
            this.b = false;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (p.this.e) {
                p.this.d = new Handler();
            }
            p.this.d.post(p.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.a < 5) {
                            com.apm.insight.c.a();
                            j.a(th, "NPTH_CATCH");
                        } else if (!this.b) {
                            this.b = true;
                            com.apm.insight.c.a();
                            j.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    static class c {
        Message a;
        long b;

        c(Message message, long j) {
            this.a = message;
            this.b = j;
        }
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.p.1
        };
        new Object() { // from class: com.apm.insight.runtime.p.2
        };
    }

    public p(String str) {
        this.a = new b(str);
    }

    private boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.d, runnable);
    }

    private boolean b(Message message, long j) {
        if (this.d == null) {
            synchronized (this.e) {
                try {
                    if (this.d == null) {
                        this.b.add(new c(message, j));
                        return true;
                    }
                } finally {
                }
            }
        }
        try {
            return this.d.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Nullable
    public final Handler a() {
        return this.d;
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(b(runnable), j);
    }

    public final void b() {
        this.a.start();
    }

    public final HandlerThread c() {
        return this.a;
    }
}
