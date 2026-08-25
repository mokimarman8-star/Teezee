package com.google.common.util.concurrent;

import com.google.common.base.m;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class MoreExecutors {
    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static t b(ExecutorService executorService) {
        if (executorService instanceof t) {
            return (t) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new c(executorService);
    }

    static Executor c(Executor executor, AbstractFuture abstractFuture) {
        m.o(executor);
        m.o(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
