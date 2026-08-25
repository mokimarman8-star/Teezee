package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class AbstractDisposableAutoRelease extends AtomicReference<io.reactivex.rxjava3.disposables.c> implements io.reactivex.rxjava3.disposables.c {
    private static final long serialVersionUID = 8924480688481408726L;
    final AtomicReference<io.reactivex.rxjava3.disposables.d> composite;
    final yx.a onComplete;
    final yx.f onError;

    AbstractDisposableAutoRelease(io.reactivex.rxjava3.disposables.d dVar, yx.f fVar, yx.a aVar) {
        this.onError = fVar;
        this.onComplete = aVar;
        this.composite = new AtomicReference<>(dVar);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        DisposableHelper.dispose(this);
        removeSelf();
    }

    public final boolean hasCustomOnError() {
        return this.onError != Functions.f;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public final void onComplete() {
        DisposableHelper disposableHelper = get();
        DisposableHelper disposableHelper2 = DisposableHelper.DISPOSED;
        if (disposableHelper != disposableHelper2) {
            lazySet(disposableHelper2);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                dy.a.r(th);
            }
        }
        removeSelf();
    }

    public final void onError(Throwable th) {
        DisposableHelper disposableHelper = get();
        DisposableHelper disposableHelper2 = DisposableHelper.DISPOSED;
        if (disposableHelper != disposableHelper2) {
            lazySet(disposableHelper2);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                dy.a.r(new CompositeException(th, th2));
            }
        } else {
            dy.a.r(th);
        }
        removeSelf();
    }

    public final void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        DisposableHelper.setOnce(this, cVar);
    }

    final void removeSelf() {
        io.reactivex.rxjava3.disposables.d andSet = this.composite.getAndSet(null);
        if (andSet != null) {
            andSet.c(this);
        }
    }
}
