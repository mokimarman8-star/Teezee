package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MaybeToFlowable extends e {
    final i b;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements h {
        private static final long serialVersionUID = 7603343402964826922L;
        c upstream;

        MaybeToFlowableSubscriber(i00.c cVar) {
            super(cVar);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.h
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToFlowable(i iVar) {
        this.b = iVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(i00.c cVar) {
        this.b.a(new MaybeToFlowableSubscriber(cVar));
    }
}
