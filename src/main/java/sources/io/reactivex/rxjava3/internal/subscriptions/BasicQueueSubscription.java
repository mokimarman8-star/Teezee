package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.operators.d;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements d {
    private static final long serialVersionUID = -6671519529404341862L;

    public abstract /* synthetic */ void cancel();

    @Override // io.reactivex.rxjava3.operators.g
    public abstract /* synthetic */ void clear();

    @Override // io.reactivex.rxjava3.operators.g
    public abstract /* synthetic */ boolean isEmpty();

    @Override // io.reactivex.rxjava3.operators.g
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.operators.g
    public abstract /* synthetic */ Object poll() throws Throwable;

    public abstract /* synthetic */ void request(long j);

    @Override // io.reactivex.rxjava3.operators.c
    public abstract /* synthetic */ int requestFusion(int i);
}
