package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a implements c {
    private static NullPointerException c(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // io.reactivex.rxjava3.core.c
    public final void a(b bVar) {
        Objects.requireNonNull(bVar, "observer is null");
        try {
            b w = dy.a.w(this, bVar);
            Objects.requireNonNull(w, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(w);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.rxjava3.exceptions.a.b(th);
            dy.a.r(th);
            throw c(th);
        }
    }

    protected abstract void b(b bVar);
}
