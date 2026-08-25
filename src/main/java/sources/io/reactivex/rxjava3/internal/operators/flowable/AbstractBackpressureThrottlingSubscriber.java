package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class AbstractBackpressureThrottlingSubscriber<T, R> extends AtomicInteger implements io.reactivex.rxjava3.core.f, i00.d {
    private static final long serialVersionUID = -5050301752721603566L;
    volatile boolean cancelled;
    volatile boolean done;
    final i00.c downstream;
    Throwable error;
    i00.d upstream;
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<R> current = new AtomicReference<>();

    AbstractBackpressureThrottlingSubscriber(i00.c cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            this.current.lazySet(null);
        }
    }

    boolean checkTerminated(boolean z, boolean z2, i00.c cVar, AtomicReference<R> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th = this.error;
        if (th != null) {
            atomicReference.lazySet(null);
            cVar.onError(th);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        i00.c cVar = this.downstream;
        AtomicLong atomicLong = this.requested;
        AtomicReference<R> atomicReference = this.current;
        int i = 1;
        do {
            long j = 0;
            while (true) {
                if (j == atomicLong.get()) {
                    break;
                }
                boolean z = this.done;
                R andSet = atomicReference.getAndSet(null);
                boolean z2 = andSet == null;
                if (checkTerminated(z, z2, cVar, atomicReference)) {
                    return;
                }
                if (z2) {
                    break;
                }
                cVar.onNext(andSet);
                j++;
            }
            if (j == atomicLong.get()) {
                if (checkTerminated(this.done, atomicReference.get() == null, cVar, atomicReference)) {
                    return;
                }
            }
            if (j != 0) {
                io.reactivex.rxjava3.internal.util.a.d(atomicLong, j);
            }
            i = addAndGet(-i);
        } while (i != 0);
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

    public abstract void onNext(T t);

    public void onSubscribe(i00.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j);
            drain();
        }
    }
}
