package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j extends io.reactivex.rxjava3.core.a {
    final io.reactivex.rxjava3.core.m a;

    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {
        final io.reactivex.rxjava3.core.b a;
        io.reactivex.rxjava3.disposables.c b;

        a(io.reactivex.rxjava3.core.b bVar) {
            this.a = bVar;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.b.isDisposed();
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
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.b = cVar;
            this.a.onSubscribe(this);
        }
    }

    public j(io.reactivex.rxjava3.core.m mVar) {
        this.a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.a
    public void b(io.reactivex.rxjava3.core.b bVar) {
        this.a.subscribe(new a(bVar));
    }
}
