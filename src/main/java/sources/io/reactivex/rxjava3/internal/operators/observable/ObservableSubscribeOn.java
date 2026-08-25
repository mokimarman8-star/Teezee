package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObservableSubscribeOn extends a {
    final Scheduler b;

    static final class SubscribeOnObserver<T> extends AtomicReference<c> implements o, c {
        private static final long serialVersionUID = 8094547886072529208L;
        final o downstream;
        final AtomicReference<c> upstream = new AtomicReference<>();

        SubscribeOnObserver(o oVar) {
            this.downstream = oVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this.upstream, cVar);
        }

        void setDisposable(c cVar) {
            DisposableHelper.setOnce(this, cVar);
        }
    }

    final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<Object> parent;

        SubscribeTask(SubscribeOnObserver<Object> subscribeOnObserver) {
            this.parent = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((a) ObservableSubscribeOn.this).a.subscribe(this.parent);
        }
    }

    public ObservableSubscribeOn(m mVar, Scheduler scheduler) {
        super(mVar);
        this.b = scheduler;
    }

    public void D(o oVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(oVar);
        oVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.b.d(new SubscribeTask(subscribeOnObserver)));
    }
}
