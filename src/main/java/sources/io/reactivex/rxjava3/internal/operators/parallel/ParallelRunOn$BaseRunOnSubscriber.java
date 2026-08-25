package io.reactivex.rxjava3.internal.operators.parallel;

import dy.a;
import i00.d;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.f;
import io.reactivex.rxjava3.exceptions.QueueOverflowException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements f, d, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    d upstream;
    final Scheduler.Worker worker;

    ParallelRunOn$BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        this.prefetch = i;
        this.queue = spscArrayQueue;
        this.limit = i - (i >> 2);
        this.worker = worker;
    }

    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        schedule();
    }

    public final void onError(Throwable th) {
        if (this.done) {
            a.r(th);
            return;
        }
        this.error = th;
        this.done = true;
        schedule();
    }

    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.queue.offer(t)) {
            schedule();
        } else {
            this.upstream.cancel();
            onError(new QueueOverflowException());
        }
    }

    public abstract /* synthetic */ void onSubscribe(d dVar);

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j);
            schedule();
        }
    }

    final void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.schedule(this);
        }
    }
}
