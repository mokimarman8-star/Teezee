package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import yx.d;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObservableRetryBiPredicate extends a {
    final d b;

    static final class RetryBiObserver<T> extends AtomicInteger implements o {
        private static final long serialVersionUID = -7098360935104053232L;
        final o downstream;
        final d predicate;
        int retries;
        final m source;
        final SequentialDisposable upstream;

        RetryBiObserver(o oVar, d dVar, SequentialDisposable sequentialDisposable, m mVar) {
            this.downstream = oVar;
            this.upstream = sequentialDisposable;
            this.source = mVar;
            this.predicate = dVar;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            try {
                d dVar = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (dVar.a(Integer.valueOf(i), th)) {
                    subscribeNext();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(new CompositeException(new Throwable[]{th, th2}));
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(c cVar) {
            this.upstream.replace(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(j jVar, d dVar) {
        super(jVar);
        this.b = dVar;
    }

    public void D(o oVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        oVar.onSubscribe(sequentialDisposable);
        new RetryBiObserver(oVar, this.b, sequentialDisposable, ((a) this).a).subscribeNext();
    }
}
