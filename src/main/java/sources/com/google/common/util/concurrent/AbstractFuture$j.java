package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$j {
    static final AbstractFuture$j c = new AbstractFuture$j(false);
    volatile Thread a;
    volatile AbstractFuture$j b;

    AbstractFuture$j() {
        AbstractFuture.access$200().g(this, Thread.currentThread());
    }

    AbstractFuture$j(boolean z) {
    }

    void a(AbstractFuture$j abstractFuture$j) {
        AbstractFuture.access$200().f(this, abstractFuture$j);
    }

    void b() {
        Thread thread = this.a;
        if (thread != null) {
            this.a = null;
            LockSupport.unpark(thread);
        }
    }
}
