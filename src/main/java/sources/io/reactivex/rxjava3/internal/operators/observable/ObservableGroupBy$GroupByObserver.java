package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    final io.reactivex.rxjava3.core.o downstream;
    final yx.h keySelector;
    io.reactivex.rxjava3.disposables.c upstream;
    final yx.h valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final Map<Object, i> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(io.reactivex.rxjava3.core.o oVar, yx.h hVar, yx.h hVar2, int i, boolean z) {
        this.downstream = oVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i;
        this.delayError = z;
        lazySet(1);
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th) {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).onError(th);
        }
        this.downstream.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t) {
        boolean z;
        try {
            Object apply = this.keySelector.apply(t);
            Object obj = apply != null ? apply : NULL_KEY;
            i iVar = this.groups.get(obj);
            if (iVar != null) {
                z = false;
            } else {
                if (this.cancelled.get()) {
                    return;
                }
                iVar = i.J(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, iVar);
                getAndIncrement();
                z = true;
            }
            try {
                Object apply2 = this.valueSelector.apply(t);
                Objects.requireNonNull(apply2, "The value supplied is null");
                iVar.onNext(apply2);
                if (z) {
                    this.downstream.onNext(iVar);
                    if (iVar.b.tryAbandon()) {
                        cancel(apply);
                        iVar.onComplete();
                    }
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                this.upstream.dispose();
                if (z) {
                    this.downstream.onNext(iVar);
                }
                onError(th);
            }
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.upstream.dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        if (DisposableHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }
}
