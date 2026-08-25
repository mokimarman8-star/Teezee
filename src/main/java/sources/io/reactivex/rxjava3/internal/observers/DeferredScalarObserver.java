package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements o {
    private static final long serialVersionUID = -266195175408988651L;
    protected io.reactivex.rxjava3.disposables.c upstream;

    public DeferredScalarObserver(o oVar) {
        super(oVar);
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        T t = this.value;
        if (t == null) {
            complete();
        } else {
            this.value = null;
            complete(t);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // io.reactivex.rxjava3.core.o
    public abstract /* synthetic */ void onNext(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        if (DisposableHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }
}
