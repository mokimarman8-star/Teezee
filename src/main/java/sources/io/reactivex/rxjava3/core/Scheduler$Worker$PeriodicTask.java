package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class Scheduler$Worker$PeriodicTask implements Runnable {
    long count;
    final Runnable decoratedRun;
    long lastNowNanoseconds;
    final long periodInNanoseconds;
    final SequentialDisposable sd;
    long startInNanoseconds;
    final /* synthetic */ Scheduler.Worker this$0;

    Scheduler$Worker$PeriodicTask(Scheduler.Worker worker, long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
        this.this$0 = worker;
        this.decoratedRun = runnable;
        this.sd = sequentialDisposable;
        this.periodInNanoseconds = j3;
        this.lastNowNanoseconds = j2;
        this.startInNanoseconds = j;
    }

    public Runnable getWrappedRunnable() {
        return this.decoratedRun;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        this.decoratedRun.run();
        if (this.sd.isDisposed()) {
            return;
        }
        Scheduler.Worker worker = this.this$0;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long now = worker.now(timeUnit);
        long j2 = Scheduler.b;
        long j3 = now + j2;
        long j4 = this.lastNowNanoseconds;
        if (j3 >= j4) {
            long j5 = this.periodInNanoseconds;
            if (now < j4 + j5 + j2) {
                long j6 = this.startInNanoseconds;
                long j7 = this.count + 1;
                this.count = j7;
                j = j6 + (j7 * j5);
                this.lastNowNanoseconds = now;
                this.sd.replace(this.this$0.schedule(this, j - now, timeUnit));
            }
        }
        long j8 = this.periodInNanoseconds;
        long j9 = now + j8;
        long j10 = this.count + 1;
        this.count = j10;
        this.startInNanoseconds = j9 - (j8 * j10);
        j = j9;
        this.lastNowNanoseconds = now;
        this.sd.replace(this.this$0.schedule(this, j - now, timeUnit));
    }
}
