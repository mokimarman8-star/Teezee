package io.reactivex.rxjava3.internal.schedulers;

import dy.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.disposables.d;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ExecutorScheduler extends Scheduler {
    final boolean c;
    final boolean d;
    final Executor e;

    public ExecutorScheduler(Executor executor, boolean z, boolean z2) {
        this.e = executor;
        this.c = z;
        this.d = z2;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new ExecutorWorker(this.e, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c d(Runnable runnable) {
        Runnable t = a.t(runnable);
        try {
            if (this.e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t, this.c);
                scheduledDirectTask.setFuture(((ExecutorService) this.e).submit((Callable) scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.c) {
                Runnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(t, (d) null);
                this.e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorScheduler$ExecutorWorker$BooleanRunnable executorScheduler$ExecutorWorker$BooleanRunnable = new ExecutorScheduler$ExecutorWorker$BooleanRunnable(t);
            this.e.execute(executorScheduler$ExecutorWorker$BooleanRunnable);
            return executorScheduler$ExecutorWorker$BooleanRunnable;
        } catch (RejectedExecutionException e) {
            a.r(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c e(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable t = a.t(runnable);
        if (!(this.e instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(t);
            delayedRunnable.timed.replace(a.a.e(new DelayedDispose(this, delayedRunnable), j, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t, this.c);
            scheduledDirectTask.setFuture(((ScheduledExecutorService) this.e).schedule((Callable) scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            a.r(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c f(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.e instanceof ScheduledExecutorService)) {
            return super.f(runnable, j, j2, timeUnit);
        }
        try {
            Runnable scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(a.t(runnable), this.c);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e) {
            a.r(e);
            return EmptyDisposable.INSTANCE;
        }
    }
}
