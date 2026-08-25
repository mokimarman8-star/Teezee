package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$d {
    static final AbstractFuture$d d = new AbstractFuture$d();
    final Runnable a;
    final Executor b;
    AbstractFuture$d c;

    AbstractFuture$d() {
        this.a = null;
        this.b = null;
    }

    AbstractFuture$d(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
