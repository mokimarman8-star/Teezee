package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements io.reactivex.rxjava3.core.f {
    private static final long serialVersionUID = 897683679971470653L;
    final b parent;
    long produced;

    FlowableConcatMap$ConcatMapInner(b bVar) {
        super(false);
        this.parent = bVar;
    }

    public void onComplete() {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerComplete();
    }

    public void onError(Throwable th) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerError(th);
    }

    public void onNext(R r) {
        this.produced++;
        this.parent.innerNext(r);
    }

    public void onSubscribe(i00.d dVar) {
        setSubscription(dVar);
    }
}
