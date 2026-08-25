package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$e extends AbstractFuture$b {
    final AtomicReferenceFieldUpdater a;
    final AtomicReferenceFieldUpdater b;
    final AtomicReferenceFieldUpdater c;
    final AtomicReferenceFieldUpdater d;
    final AtomicReferenceFieldUpdater e;

    AbstractFuture$e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super();
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean a(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d, AbstractFuture$d abstractFuture$d2) {
        return androidx.concurrent.futures.a.a(this.d, abstractFuture, abstractFuture$d, abstractFuture$d2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
        return androidx.concurrent.futures.a.a(this.e, abstractFuture, obj, obj2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean c(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        return androidx.concurrent.futures.a.a(this.c, abstractFuture, abstractFuture$j, abstractFuture$j2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$d d(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d) {
        return (AbstractFuture$d) this.d.getAndSet(abstractFuture, abstractFuture$d);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$j e(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j) {
        return (AbstractFuture$j) this.c.getAndSet(abstractFuture, abstractFuture$j);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void f(AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        this.b.lazySet(abstractFuture$j, abstractFuture$j2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void g(AbstractFuture$j abstractFuture$j, Thread thread) {
        this.a.lazySet(abstractFuture$j, thread);
    }
}
