package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class g extends io.reactivex.rxjava3.core.e {
    final io.reactivex.rxjava3.processors.a b;
    final AtomicBoolean c = new AtomicBoolean();

    g(io.reactivex.rxjava3.processors.a aVar) {
        this.b = aVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(i00.c cVar) {
        this.b.subscribe(cVar);
        this.c.set(true);
    }

    boolean h() {
        return !this.c.get() && this.c.compareAndSet(false, true);
    }
}
