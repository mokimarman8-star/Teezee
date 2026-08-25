package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class i extends n {

    static abstract class a extends i implements AbstractFuture$g {
        a() {
        }

        @Override // com.google.common.util.concurrent.r
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public final Object get() throws InterruptedException, ExecutionException {
            return super.get();
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return super.get(j, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    i() {
    }

    @Deprecated
    public static <V> i from(i iVar) {
        return (i) com.google.common.base.m.o(iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> i from(r rVar) {
        return rVar instanceof i ? (i) rVar : new j(rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addCallback(m mVar, Executor executor) {
        Futures.a(this, mVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <X extends Throwable> i catching(Class<X> cls, com.google.common.base.f fVar, Executor executor) {
        return (i) Futures.b(this, cls, fVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <X extends Throwable> i catchingAsync(Class<X> cls, f fVar, Executor executor) {
        return (i) Futures.c(this, cls, fVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> i transform(com.google.common.base.f fVar, Executor executor) {
        return (i) Futures.f(this, fVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> i transformAsync(f fVar, Executor executor) {
        return (i) Futures.g(this, fVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (i) Futures.h(this, j, timeUnit, scheduledExecutorService);
    }
}
