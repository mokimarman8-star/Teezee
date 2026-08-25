package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final o downstream;
    protected T value;

    public DeferredScalarDisposable(o oVar) {
        this.downstream = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void complete(T t) {
        int i = get();
        if ((i & 54) != 0) {
            return;
        }
        o oVar = this.downstream;
        if (i == 8) {
            this.value = t;
            lazySet(16);
            oVar.onNext(null);
        } else {
            lazySet(2);
            oVar.onNext(t);
        }
        if (get() != 4) {
            oVar.onComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispose() {
        set(4);
        this.value = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            dy.a.r(th);
        } else {
            lazySet(2);
            this.downstream.onError(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisposed() {
        return get() == 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isEmpty() {
        return get() != 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }
}
