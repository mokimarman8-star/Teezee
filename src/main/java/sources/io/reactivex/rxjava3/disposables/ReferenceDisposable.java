package io.reactivex.rxjava3.disposables;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReferenceDisposable(T t) {
        super(t);
        Objects.requireNonNull(t, "value is null");
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return get() == null;
    }

    protected abstract void onDisposed(T t);
}
