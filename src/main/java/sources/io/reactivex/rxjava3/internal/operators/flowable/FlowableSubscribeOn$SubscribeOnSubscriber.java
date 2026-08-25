package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements io.reactivex.rxjava3.core.f, i00.d, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final i00.c downstream;
    final boolean nonScheduledRequests;
    i00.b source;
    final Scheduler.Worker worker;
    final AtomicReference<i00.d> upstream = new AtomicReference<>();
    final AtomicLong requested = new AtomicLong();

    static final class Request implements Runnable {
        final long n;
        final i00.d upstream;

        Request(i00.d dVar, long j) {
            this.upstream = dVar;
            this.n = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.upstream.request(this.n);
        }
    }

    FlowableSubscribeOn$SubscribeOnSubscriber(i00.c cVar, Scheduler.Worker worker, i00.b bVar, boolean z) {
        this.downstream = cVar;
        this.worker = worker;
        this.source = bVar;
        this.nonScheduledRequests = !z;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable th) {
        this.downstream.onError(th);
        this.worker.dispose();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(i00.d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            long andSet = this.requested.getAndSet(0L);
            if (andSet != 0) {
                requestUpstream(andSet, dVar);
            }
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            i00.d dVar = this.upstream.get();
            if (dVar != null) {
                requestUpstream(j, dVar);
                return;
            }
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j);
            i00.d dVar2 = this.upstream.get();
            if (dVar2 != null) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar2);
                }
            }
        }
    }

    void requestUpstream(long j, i00.d dVar) {
        if (this.nonScheduledRequests || Thread.currentThread() == get()) {
            dVar.request(j);
        } else {
            this.worker.schedule(new Request(dVar, j));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        i00.b bVar = this.source;
        this.source = null;
        bVar.subscribe(this);
    }
}
