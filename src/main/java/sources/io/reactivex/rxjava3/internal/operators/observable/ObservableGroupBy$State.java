package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ObservableGroupBy$State<T, K> extends AtomicInteger implements io.reactivex.rxjava3.disposables.c, io.reactivex.rxjava3.core.m {
    static final int ABANDONED = 2;
    static final int ABANDONED_HAS_SUBSCRIBER = 3;
    static final int FRESH = 0;
    static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    final io.reactivex.rxjava3.operators.h queue;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicReference<io.reactivex.rxjava3.core.o> actual = new AtomicReference<>();
    final AtomicInteger once = new AtomicInteger();

    ObservableGroupBy$State(int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k, boolean z) {
        this.queue = new io.reactivex.rxjava3.operators.h(i);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = k;
        this.delayError = z;
    }

    void cancelParent() {
        if ((this.once.get() & 2) == 0) {
            this.parent.cancel(this.key);
        }
    }

    boolean checkTerminated(boolean z, boolean z2, io.reactivex.rxjava3.core.o oVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.actual.lazySet(null);
            cancelParent();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable th = this.error;
            this.actual.lazySet(null);
            if (th != null) {
                oVar.onError(th);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            this.queue.clear();
            this.actual.lazySet(null);
            oVar.onError(th2);
            return true;
        }
        if (!z2) {
            return false;
        }
        this.actual.lazySet(null);
        oVar.onComplete();
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.actual.lazySet(null);
            cancelParent();
        }
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.operators.h hVar = this.queue;
        boolean z = this.delayError;
        io.reactivex.rxjava3.core.o oVar = this.actual.get();
        int i = 1;
        while (true) {
            if (oVar != null) {
                while (true) {
                    boolean z2 = this.done;
                    Object poll = hVar.poll();
                    boolean z3 = poll == null;
                    if (checkTerminated(z2, z3, oVar, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    } else {
                        oVar.onNext(poll);
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (oVar == null) {
                oVar = this.actual.get();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.m
    public void subscribe(io.reactivex.rxjava3.core.o oVar) {
        int i;
        do {
            i = this.once.get();
            if ((i & 1) != 0) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), oVar);
                return;
            }
        } while (!this.once.compareAndSet(i, i | 1));
        oVar.onSubscribe(this);
        this.actual.lazySet(oVar);
        if (this.cancelled.get()) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }
}
