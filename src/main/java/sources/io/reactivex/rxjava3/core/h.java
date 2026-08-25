package io.reactivex.rxjava3.core;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface h {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.rxjava3.disposables.c cVar);

    void onSuccess(Object obj);
}
