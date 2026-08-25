package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e extends Scheduler.Worker {
    private final ScheduledExecutorService a;
    volatile boolean b;

    public e(ThreadFactory threadFactory) {
        this.a = g.a(threadFactory);
    }

    public ScheduledRunnable a(Runnable runnable, long j, TimeUnit timeUnit, io.reactivex.rxjava3.disposables.d dVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(dy.a.t(runnable), dVar);
        if (dVar != null && !dVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j <= 0 ? this.a.submit((Callable) scheduledRunnable) : this.a.schedule((Callable) scheduledRunnable, j, timeUnit));
        } catch (RejectedExecutionException e) {
            if (dVar != null) {
                dVar.a(scheduledRunnable);
            }
            dy.a.r(e);
        }
        return scheduledRunnable;
    }

    public io.reactivex.rxjava3.disposables.c b(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(dy.a.t(runnable), true);
        try {
            scheduledDirectTask.setFuture(j <= 0 ? this.a.submit(scheduledDirectTask) : this.a.schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            dy.a.r(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public io.reactivex.rxjava3.disposables.c c(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable t = dy.a.t(runnable);
        if (j2 <= 0) {
            c cVar = new c(t, this.a);
            try {
                cVar.b(j <= 0 ? this.a.submit(cVar) : this.a.schedule(cVar, j, timeUnit));
                return cVar;
            } catch (RejectedExecutionException e) {
                dy.a.r(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(t, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            dy.a.r(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void d() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdown();
    }

    public void dispose() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.shutdownNow();
    }

    public boolean isDisposed() {
        return this.b;
    }

    public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b ? EmptyDisposable.INSTANCE : a(runnable, j, timeUnit, null);
    }
}
