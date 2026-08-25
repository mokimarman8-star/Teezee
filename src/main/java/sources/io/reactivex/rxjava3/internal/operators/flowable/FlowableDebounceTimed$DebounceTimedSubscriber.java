package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements io.reactivex.rxjava3.core.f, i00.d {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final i00.c downstream;
    volatile long index;
    final yx.f onDropped;
    final long timeout;
    FlowableDebounceTimed$DebounceEmitter<T> timer;
    final TimeUnit unit;
    i00.d upstream;
    final Scheduler.Worker worker;

    FlowableDebounceTimed$DebounceTimedSubscriber(i00.c cVar, long j, TimeUnit timeUnit, Scheduler.Worker worker, yx.f fVar) {
        this.downstream = cVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = worker;
        this.onDropped = fVar;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    void emit(long j, T t, FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter) {
        if (j == this.index) {
            if (get() == 0) {
                cancel();
                this.downstream.onError(MissingBackpressureException.createDefault());
            } else {
                this.downstream.onNext(t);
                io.reactivex.rxjava3.internal.util.a.d(this, 1L);
                flowableDebounceTimed$DebounceEmitter.dispose();
            }
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter = this.timer;
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.dispose();
        }
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.emit();
        }
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable th) {
        if (this.done) {
            dy.a.r(th);
            return;
        }
        this.done = true;
        FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter = this.timer;
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.dispose();
        }
        this.downstream.onError(th);
        this.worker.dispose();
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter = this.timer;
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.dispose();
        }
        yx.f fVar = this.onDropped;
        if (fVar != null && flowableDebounceTimed$DebounceEmitter != null) {
            try {
                fVar.accept(flowableDebounceTimed$DebounceEmitter.value);
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                this.upstream.cancel();
                this.done = true;
                this.downstream.onError(th);
                this.worker.dispose();
            }
        }
        FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter2 = new FlowableDebounceTimed$DebounceEmitter<>(t, j, this);
        this.timer = flowableDebounceTimed$DebounceEmitter2;
        flowableDebounceTimed$DebounceEmitter2.setResource(this.worker.schedule(flowableDebounceTimed$DebounceEmitter2, this.timeout, this.unit));
    }

    public void onSubscribe(i00.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.rxjava3.internal.util.a.a(this, j);
        }
    }
}
