package io.reactivex.rxjava3.core;

import dy.a;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.e;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class Scheduler {
    static boolean a = Boolean.getBoolean("rx3.scheduler.use-nanotime");
    static final long b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    static final class DisposeTask implements c, Runnable {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.w = worker;
        }

        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                e eVar = this.w;
                if (eVar instanceof e) {
                    eVar.d();
                    return;
                }
            }
            this.w.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
            }
        }
    }

    public static abstract class Worker implements c {
        public long now(TimeUnit timeUnit) {
            return Scheduler.b(timeUnit);
        }

        public c schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract c schedule(Runnable runnable, long j, TimeUnit timeUnit);

        public c schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable t = a.t(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            EmptyDisposable schedule = schedule(new PeriodicTask(this, now + timeUnit.toNanos(j), t, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    static long a(long j, String str) {
        return "seconds".equalsIgnoreCase(str) ? TimeUnit.SECONDS.toNanos(j) : "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j) : TimeUnit.MINUTES.toNanos(j);
    }

    static long b(TimeUnit timeUnit) {
        return !a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract Worker c();

    public c d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public c e(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker c = c();
        DisposeTask disposeTask = new DisposeTask(a.t(runnable), c);
        c.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public c f(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker c = c();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(a.t(runnable), c);
        EmptyDisposable schedulePeriodically = c.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }
}
