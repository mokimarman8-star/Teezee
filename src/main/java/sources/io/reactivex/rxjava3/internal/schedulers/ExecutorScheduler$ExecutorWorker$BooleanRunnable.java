package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class ExecutorScheduler$ExecutorWorker$BooleanRunnable extends AtomicBoolean implements Runnable, c {
    private static final long serialVersionUID = -2421395018820541164L;
    final Runnable actual;

    ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    public void dispose() {
        lazySet(true);
    }

    public boolean isDisposed() {
        return get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get()) {
            return;
        }
        try {
            this.actual.run();
        } finally {
        }
    }
}
