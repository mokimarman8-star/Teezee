package com.google.firebase.crashlytics.internal.send;

import android.os.SystemClock;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.l;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.a0;
import com.google.firebase.crashlytics.internal.common.l0;
import com.google.firebase.crashlytics.internal.common.z0;
import com.google.firebase.crashlytics.internal.settings.c;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import qb.g;
import t8.d;
import t8.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class ReportQueue {
    private final double a;
    private final double b;
    private final long c;
    private final long d;
    private final int e;
    private final BlockingQueue f;
    private final ThreadPoolExecutor g;
    private final h h;
    private final l0 i;
    private int j;
    private long k;

    ReportQueue(double d, double d2, long j, h hVar, l0 l0Var) {
        this.a = d;
        this.b = d2;
        this.c = j;
        this.h = hVar;
        this.i = l0Var;
        this.d = SystemClock.elapsedRealtime();
        int i = (int) d;
        this.e = i;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i);
        this.f = arrayBlockingQueue;
        this.g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.j = 0;
        this.k = 0L;
    }

    ReportQueue(h hVar, c cVar, l0 l0Var) {
        this(cVar.f, cVar.g, cVar.h * 1000, hVar, l0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.a) * Math.pow(this.b, h()));
    }

    private int h() {
        if (this.k == 0) {
            this.k = o();
        }
        int o = (int) ((o() - this.k) / this.c);
        int min = l() ? Math.min(100, this.j + o) : Math.max(0, this.j - o);
        if (this.j != min) {
            this.j = min;
            this.k = o();
        }
        return min;
    }

    private boolean k() {
        return this.f.size() < this.e;
    }

    private boolean l() {
        return this.f.size() == this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            l.a(this.h, Priority.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z, a0 a0Var, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z) {
            j();
        }
        taskCompletionSource.trySetResult(a0Var);
    }

    private long o() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(a0 a0Var, TaskCompletionSource taskCompletionSource) {
        g.f().b("Sending report through Google DataTransport: " + a0Var.d());
        this.h.b(d.h(a0Var.b()), new c(this, taskCompletionSource, SystemClock.elapsedRealtime() - this.d < 2000, a0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(double d) {
        try {
            Thread.sleep((long) d);
        } catch (InterruptedException unused) {
        }
    }

    TaskCompletionSource i(a0 a0Var, boolean z) {
        synchronized (this.f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z) {
                    p(a0Var, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.i.b();
                if (!k()) {
                    h();
                    g.f().b("Dropping report due to queue being full: " + a0Var.d());
                    this.i.a();
                    taskCompletionSource.trySetResult(a0Var);
                    return taskCompletionSource;
                }
                g.f().b("Enqueueing report: " + a0Var.d());
                g.f().b("Queue size: " + this.f.size());
                this.g.execute(new ReportRunnable(this, a0Var, taskCompletionSource, (a) null));
                g.f().b("Closing task for report: " + a0Var.d());
                taskCompletionSource.trySetResult(a0Var);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread((Runnable) new d(this, countDownLatch)).start();
        z0.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }
}
