package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableTimer$TimerSubscriber extends AtomicReference<io.reactivex.rxjava3.disposables.c> implements i00.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final i00.c downstream;
    volatile boolean requested;

    FlowableTimer$TimerSubscriber(i00.c cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.requested = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            if (!this.requested) {
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onError(MissingBackpressureException.createDefault());
            } else {
                this.downstream.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }

    public void setResource(io.reactivex.rxjava3.disposables.c cVar) {
        DisposableHelper.trySet(this, cVar);
    }
}
