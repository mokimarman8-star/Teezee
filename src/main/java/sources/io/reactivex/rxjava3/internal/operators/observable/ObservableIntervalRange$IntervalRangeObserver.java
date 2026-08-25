package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<io.reactivex.rxjava3.disposables.c> implements io.reactivex.rxjava3.disposables.c, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final io.reactivex.rxjava3.core.o downstream;
    final long end;

    ObservableIntervalRange$IntervalRangeObserver(io.reactivex.rxjava3.core.o oVar, long j, long j2) {
        this.downstream = oVar;
        this.count = j;
        this.end = j2;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed()) {
            return;
        }
        long j = this.count;
        this.downstream.onNext(Long.valueOf(j));
        if (j != this.end) {
            this.count = j + 1;
            return;
        }
        if (!isDisposed()) {
            this.downstream.onComplete();
        }
        DisposableHelper.dispose(this);
    }

    public void setResource(io.reactivex.rxjava3.disposables.c cVar) {
        DisposableHelper.setOnce(this, cVar);
    }
}
