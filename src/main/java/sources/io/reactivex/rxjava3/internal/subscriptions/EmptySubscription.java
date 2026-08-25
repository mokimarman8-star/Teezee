package io.reactivex.rxjava3.internal.subscriptions;

import i00.c;
import io.reactivex.rxjava3.operators.d;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum EmptySubscription implements d {
    INSTANCE;

    public static void complete(c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    public void cancel() {
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.operators.g
    public Object poll() {
        return null;
    }

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.rxjava3.operators.c
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
