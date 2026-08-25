package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class CompletableDelay$Delay extends AtomicReference<c> implements b, Runnable, c {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final b downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;

    CompletableDelay$Delay(b bVar, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.downstream = bVar;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.e(this, this.delay, this.unit));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.e(this, this.delayError ? this.delay : 0L, this.unit));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void onSubscribe(c cVar) {
        if (DisposableHelper.setOnce(this, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        this.error = null;
        if (th != null) {
            this.downstream.onError(th);
        } else {
            this.downstream.onComplete();
        }
    }
}
