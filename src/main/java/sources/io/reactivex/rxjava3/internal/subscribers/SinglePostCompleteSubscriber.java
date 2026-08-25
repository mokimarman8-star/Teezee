package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements io.reactivex.rxjava3.core.f, i00.d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final i00.c downstream;
    protected long produced;
    protected i00.d upstream;
    protected R value;

    public SinglePostCompleteSubscriber(i00.c cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    protected final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            io.reactivex.rxjava3.internal.util.a.d(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & COMPLETE_MASK) != 0) {
                onDrop(r);
                return;
            }
            if ((j2 & REQUEST_MASK) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, COMPLETE_MASK)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    public abstract /* synthetic */ void onComplete();

    protected void onDrop(R r) {
    }

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    public void onSubscribe(i00.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & COMPLETE_MASK) != 0) {
                    if (compareAndSet(COMPLETE_MASK, -9223372036854775807L)) {
                        this.downstream.onNext(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, io.reactivex.rxjava3.internal.util.a.b(j2, j)));
            this.upstream.request(j);
        }
    }
}
