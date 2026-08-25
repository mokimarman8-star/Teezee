package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class MoreExecutors$a implements Executor {
    final /* synthetic */ Executor a;
    final /* synthetic */ AbstractFuture b;

    MoreExecutors$a(Executor executor, AbstractFuture abstractFuture) {
        this.a = executor;
        this.b = abstractFuture;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.b.setException(e);
        }
    }
}
