package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, io.reactivex.rxjava3.disposables.c {
    private static final long serialVersionUID = -4101336210206799084L;
    final SequentialDisposable direct;
    final SequentialDisposable timed;

    ExecutorScheduler$DelayedRunnable(Runnable runnable) {
        super(runnable);
        this.timed = new SequentialDisposable();
        this.direct = new SequentialDisposable();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (getAndSet(null) != null) {
            this.timed.dispose();
            this.direct.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = get();
        return runnable != null ? runnable : Functions.b;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return get() == null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = get();
        if (runnable != null) {
            try {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.timed;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.direct.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            } catch (Throwable th2) {
                dy.a.r(th2);
                throw th2;
            }
        }
    }
}
