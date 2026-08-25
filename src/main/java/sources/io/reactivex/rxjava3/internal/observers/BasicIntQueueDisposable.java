package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.operators.b;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b {
    private static final long serialVersionUID = -1001730202384742097L;

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ void dispose();

    public abstract /* synthetic */ boolean isDisposed();

    public abstract /* synthetic */ boolean isEmpty();

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public abstract /* synthetic */ Object poll() throws Throwable;

    public abstract /* synthetic */ int requestFusion(int i);
}
