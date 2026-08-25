package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class CombinedFuture extends c {

    private final class AsyncCallableInterruptibleTask extends CombinedFutureInterruptibleTask<r> {
        private final e callable;
        final /* synthetic */ CombinedFuture this$0;

        AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, e eVar, Executor executor) {
            super(combinedFuture, executor);
            android.support.v4.media.session.c.a(com.google.common.base.m.o(eVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: runInterruptibly, reason: merged with bridge method [inline-methods] */
        public r m40runInterruptibly() throws Exception {
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setValue(r rVar) {
            throw null;
        }

        String toPendingString() {
            throw null;
        }
    }

    private final class CallableInterruptibleTask extends CombinedFutureInterruptibleTask<Object> {
        private final Callable<Object> callable;
        final /* synthetic */ CombinedFuture this$0;

        CallableInterruptibleTask(CombinedFuture combinedFuture, Callable<Object> callable, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (Callable) com.google.common.base.m.o(callable);
        }

        Object runInterruptibly() throws Exception {
            return this.callable.call();
        }

        void setValue(Object obj) {
            throw null;
        }

        String toPendingString() {
            return this.callable.toString();
        }
    }

    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;

        CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            this.listenerExecutor = (Executor) com.google.common.base.m.o(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptiblyFailure(Throwable th) {
            CombinedFuture.s(null, null);
            if (th instanceof ExecutionException) {
                ((ExecutionException) th).getCause();
                throw null;
            }
            if (!(th instanceof CancellationException)) {
                throw null;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptiblySuccess(T t) {
            CombinedFuture.s(null, null);
            setValue(t);
        }

        final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                throw null;
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            throw null;
        }

        abstract void setValue(T t);
    }

    static /* synthetic */ CombinedFutureInterruptibleTask s(CombinedFuture combinedFuture, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
        throw null;
    }
}
