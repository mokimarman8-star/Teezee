package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableConcatMap$SimpleScalarSubscription<T> extends AtomicBoolean implements i00.d {
    private static final long serialVersionUID = -7606889335172043256L;
    final i00.c downstream;
    final T value;

    FlowableConcatMap$SimpleScalarSubscription(T t, i00.c cVar) {
        this.value = t;
        this.downstream = cVar;
    }

    public void cancel() {
    }

    public void request(long j) {
        if (j <= 0 || !compareAndSet(false, true)) {
            return;
        }
        i00.c cVar = this.downstream;
        cVar.onNext(this.value);
        cVar.onComplete();
    }
}
