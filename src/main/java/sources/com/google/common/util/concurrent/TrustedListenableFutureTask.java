package com.google.common.util.concurrent;

import com.google.common.util.concurrent.i;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class TrustedListenableFutureTask<V> extends i.a implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<r> {
        private final e callable;

        TrustedFutureInterruptibleAsyncTask(e eVar) {
            android.support.v4.media.session.c.a(com.google.common.base.m.o(eVar));
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(r rVar) {
            TrustedListenableFutureTask.this.setFuture(rVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public r runInterruptibly() throws Exception {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            throw null;
        }
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) com.google.common.base.m.o(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblySuccess(V v) {
            TrustedListenableFutureTask.this.set(v);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    TrustedListenableFutureTask(e eVar) {
        this.task = new TrustedFutureInterruptibleAsyncTask(eVar);
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    static <V> TrustedListenableFutureTask<V> create(e eVar) {
        return new TrustedListenableFutureTask<>(eVar);
    }

    static <V> TrustedListenableFutureTask<V> create(Runnable runnable, V v) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v));
    }

    static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    protected void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    protected String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }
}
