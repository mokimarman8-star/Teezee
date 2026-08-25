package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<c> implements h, c, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final boolean delayError;
    final h downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;
    T value;

    MaybeDelay$DelayMaybeObserver(h hVar, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.downstream = hVar;
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

    @Override // io.reactivex.rxjava3.core.h
    public void onComplete() {
        schedule(this.delay);
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onError(Throwable th) {
        this.error = th;
        schedule(this.delayError ? this.delay : 0L);
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSubscribe(c cVar) {
        if (DisposableHelper.setOnce(this, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSuccess(T t) {
        this.value = t;
        schedule(this.delay);
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.downstream.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    void schedule(long j) {
        DisposableHelper.replace(this, this.scheduler.e(this, j, this.unit));
    }
}
