package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends io.reactivex.rxjava3.core.e {
    private final m b;

    static final class a implements o, i00.d {
        final i00.c a;
        io.reactivex.rxjava3.disposables.c b;

        a(i00.c cVar) {
            this.a = cVar;
        }

        public void cancel() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            this.a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.b = cVar;
            this.a.onSubscribe(this);
        }

        public void request(long j) {
        }
    }

    public c(m mVar) {
        this.b = mVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(i00.c cVar) {
        this.b.subscribe(new a(cVar));
    }
}
