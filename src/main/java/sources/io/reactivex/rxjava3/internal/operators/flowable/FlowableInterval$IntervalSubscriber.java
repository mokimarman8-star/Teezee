package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableInterval$IntervalSubscriber extends AtomicLong implements i00.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final i00.c downstream;
    final AtomicReference<io.reactivex.rxjava3.disposables.c> resource = new AtomicReference<>();

    FlowableInterval$IntervalSubscriber(i00.c cVar) {
        this.downstream = cVar;
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
        if (this.resource.get() != DisposableHelper.DISPOSED) {
            if (get() != 0) {
                i00.c cVar = this.downstream;
                long j = this.count;
                this.count = j + 1;
                cVar.onNext(Long.valueOf(j));
                io.reactivex.rxjava3.internal.util.a.d(this, 1L);
                return;
            }
            this.downstream.onError(new MissingBackpressureException("Could not emit value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(io.reactivex.rxjava3.disposables.c cVar) {
        DisposableHelper.setOnce(this.resource, cVar);
    }
}
