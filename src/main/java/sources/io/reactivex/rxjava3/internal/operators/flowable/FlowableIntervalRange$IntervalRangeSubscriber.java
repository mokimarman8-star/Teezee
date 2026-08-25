package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements i00.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final i00.c downstream;
    final long end;
    final AtomicReference<io.reactivex.rxjava3.disposables.c> resource = new AtomicReference<>();

    FlowableIntervalRange$IntervalRangeSubscriber(i00.c cVar, long j, long j2) {
        this.downstream = cVar;
        this.count = j;
        this.end = j2;
    }

    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.rxjava3.internal.util.a.a(this, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        io.reactivex.rxjava3.disposables.c cVar = this.resource.get();
        io.reactivex.rxjava3.disposables.c cVar2 = DisposableHelper.DISPOSED;
        if (cVar != cVar2) {
            long j = get();
            if (j == 0) {
                this.downstream.onError(new MissingBackpressureException("Could not emit value " + this.count + " due to lack of requests"));
                DisposableHelper.dispose(this.resource);
                return;
            }
            long j2 = this.count;
            this.downstream.onNext(Long.valueOf(j2));
            if (j2 == this.end) {
                if (this.resource.get() != cVar2) {
                    this.downstream.onComplete();
                }
                DisposableHelper.dispose(this.resource);
            } else {
                this.count = j2 + 1;
                if (j != Long.MAX_VALUE) {
                    decrementAndGet();
                }
            }
        }
    }

    public void setResource(io.reactivex.rxjava3.disposables.c cVar) {
        DisposableHelper.setOnce(this.resource, cVar);
    }
}
