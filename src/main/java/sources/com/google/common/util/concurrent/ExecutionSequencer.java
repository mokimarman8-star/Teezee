package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class ExecutionSequencer {

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        Executor delegate;
        ExecutionSequencer sequencer;
        Thread submitting;
        Runnable task;

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
        }

        /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, h hVar) {
            this(executor, executionSequencer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                throw null;
            } catch (Throwable th) {
                this.submitting = null;
                throw th;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread currentThread = Thread.currentThread();
            h hVar = null;
            if (currentThread == this.submitting) {
                new a(hVar).a = currentThread;
                throw null;
            }
            Runnable runnable = this.task;
            Objects.requireNonNull(runnable);
            this.task = null;
            runnable.run();
        }
    }

    private static final class a {
        Thread a;

        private a() {
        }

        /* synthetic */ a(h hVar) {
            this();
        }
    }
}
