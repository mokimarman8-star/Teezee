package io.reactivex.rxjava3.internal.operators.parallel;

import i00.c;
import i00.d;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final c downstream;

    ParallelRunOn$RunOnSubscriber(c cVar, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i, spscArrayQueue, worker);
        this.downstream = cVar;
    }

    @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th;
        int i = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        c cVar = this.downstream;
        int i2 = this.limit;
        int i3 = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z = this.done;
                if (z && (th = this.error) != null) {
                    spscArrayQueue.clear();
                    cVar.onError(th);
                    this.worker.dispose();
                    return;
                }
                T poll = spscArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    if (z2) {
                        break;
                    }
                    cVar.onNext(poll);
                    j2++;
                    i++;
                    if (i == i2) {
                        this.upstream.request(i);
                        i = 0;
                    }
                }
            }
            if (j2 == j) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                if (this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            int i4 = get();
            if (i4 == i3) {
                this.consumed = i;
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                i3 = i4;
            }
        }
    }
}
