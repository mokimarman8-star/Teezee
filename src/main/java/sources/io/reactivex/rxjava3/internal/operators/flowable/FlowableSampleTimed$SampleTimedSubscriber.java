package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements io.reactivex.rxjava3.core.f, i00.d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final i00.c downstream;
    final yx.f onDropped;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;
    i00.d upstream;
    final AtomicLong requested = new AtomicLong();
    final SequentialDisposable timer = new SequentialDisposable();

    FlowableSampleTimed$SampleTimedSubscriber(i00.c cVar, long j, TimeUnit timeUnit, Scheduler scheduler, yx.f fVar) {
        this.downstream = cVar;
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.onDropped = fVar;
    }

    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    abstract void complete();

    void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            if (this.requested.get() != 0) {
                this.downstream.onNext(andSet);
                io.reactivex.rxjava3.internal.util.a.d(this.requested, 1L);
            } else {
                cancel();
                this.downstream.onError(MissingBackpressureException.createDefault());
            }
        }
    }

    public void onComplete() {
        cancelTimer();
        complete();
    }

    public void onError(Throwable th) {
        cancelTimer();
        this.downstream.onError(th);
    }

    public void onNext(T t) {
        yx.f fVar;
        T andSet = getAndSet(t);
        if (andSet == null || (fVar = this.onDropped) == null) {
            return;
        }
        try {
            fVar.accept(andSet);
        } catch (Throwable th) {
            io.reactivex.rxjava3.exceptions.a.b(th);
            cancelTimer();
            this.upstream.cancel();
            this.downstream.onError(th);
        }
    }

    public void onSubscribe(i00.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler scheduler = this.scheduler;
            long j = this.period;
            sequentialDisposable.replace(scheduler.f(this, j, j, this.unit));
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j);
        }
    }
}
