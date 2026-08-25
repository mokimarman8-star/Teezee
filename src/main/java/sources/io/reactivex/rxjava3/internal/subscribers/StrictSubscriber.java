package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class StrictSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f, i00.d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final i00.c downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<i00.d> upstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(i00.c cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    public void onComplete() {
        this.done = true;
        io.reactivex.rxjava3.internal.util.d.a(this.downstream, this, this.error);
    }

    public void onError(Throwable th) {
        this.done = true;
        io.reactivex.rxjava3.internal.util.d.b(this.downstream, th, this, this.error);
    }

    public void onNext(T t) {
        io.reactivex.rxjava3.internal.util.d.c(this.downstream, t, this, this.error);
    }

    public void onSubscribe(i00.d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    public void request(long j) {
        if (j > 0) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }
}
