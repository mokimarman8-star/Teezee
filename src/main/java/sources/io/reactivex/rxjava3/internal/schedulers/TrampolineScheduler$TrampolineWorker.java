package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class TrampolineScheduler$TrampolineWorker extends Scheduler.Worker {
    final PriorityBlockingQueue a = new PriorityBlockingQueue();
    private final AtomicInteger b = new AtomicInteger();
    final AtomicInteger c = new AtomicInteger();
    volatile boolean d;

    final class AppendToQueueTask implements Runnable {
        final TrampolineScheduler$a timedRunnable;

        AppendToQueueTask(TrampolineScheduler$a trampolineScheduler$a) {
            this.timedRunnable = trampolineScheduler$a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timedRunnable.d = true;
            TrampolineScheduler$TrampolineWorker.this.a.remove(this.timedRunnable);
        }
    }

    TrampolineScheduler$TrampolineWorker() {
    }

    io.reactivex.rxjava3.disposables.c a(Runnable runnable, long j) {
        if (this.d) {
            return EmptyDisposable.INSTANCE;
        }
        TrampolineScheduler$a trampolineScheduler$a = new TrampolineScheduler$a(runnable, Long.valueOf(j), this.c.incrementAndGet());
        this.a.add(trampolineScheduler$a);
        if (this.b.getAndIncrement() != 0) {
            return io.reactivex.rxjava3.disposables.b.b(new AppendToQueueTask(trampolineScheduler$a));
        }
        int i = 1;
        while (!this.d) {
            TrampolineScheduler$a trampolineScheduler$a2 = (TrampolineScheduler$a) this.a.poll();
            if (trampolineScheduler$a2 == null) {
                i = this.b.addAndGet(-i);
                if (i == 0) {
                    return EmptyDisposable.INSTANCE;
                }
            } else if (!trampolineScheduler$a2.d) {
                trampolineScheduler$a2.a.run();
            }
        }
        this.a.clear();
        return EmptyDisposable.INSTANCE;
    }

    public void dispose() {
        this.d = true;
    }

    public boolean isDisposed() {
        return this.d;
    }

    public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
        return a(runnable, now(TimeUnit.MILLISECONDS));
    }

    public io.reactivex.rxjava3.disposables.c schedule(final Runnable runnable, long j, TimeUnit timeUnit) {
        final long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
        return a(new Runnable(runnable, this, now) { // from class: io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler$SleepingRunnable
            private final long execTime;
            private final Runnable run;
            private final TrampolineScheduler$TrampolineWorker worker;

            {
                this.run = runnable;
                this.worker = this;
                this.execTime = now;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.worker.d) {
                    return;
                }
                long now2 = this.worker.now(TimeUnit.MILLISECONDS);
                long j2 = this.execTime;
                if (j2 > now2) {
                    try {
                        Thread.sleep(j2 - now2);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        dy.a.r(e);
                        return;
                    }
                }
                if (this.worker.d) {
                    return;
                }
                this.run.run();
            }
        }, now);
    }
}
