package io.reactivex.rxjava3.core;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface o {
    void onComplete();

    void onError(Throwable th);

    void onNext(Object obj);

    void onSubscribe(io.reactivex.rxjava3.disposables.c cVar);
}
