package com.google.common.util.concurrent;

import java.util.Deque;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class SequentialExecutor implements Executor {
    private static final q a = new q(SequentialExecutor.class);

    /* renamed from: com.google.common.util.concurrent.SequentialExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;
        final /* synthetic */ Runnable val$task;

        AnonymousClass1(SequentialExecutor sequentialExecutor, Runnable runnable) {
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$task.run();
        }

        public String toString() {
            return this.val$task.toString();
        }
    }

    private final class QueueWorker implements Runnable {
        Runnable task;
        final /* synthetic */ SequentialExecutor this$0;

        private QueueWorker(SequentialExecutor sequentialExecutor) {
        }

        /* synthetic */ QueueWorker(SequentialExecutor sequentialExecutor, AnonymousClass1 anonymousClass1) {
            this(sequentialExecutor);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            r8.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
        
            r8.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        
            com.google.common.util.concurrent.SequentialExecutor.a.a().log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.task, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void workOnQueue() {
            boolean z = false;
            boolean z2 = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.a(null)) {
                        if (!z) {
                            WorkerRunningState b = SequentialExecutor.b(null);
                            WorkerRunningState workerRunningState = WorkerRunningState.RUNNING;
                            if (b != workerRunningState) {
                                SequentialExecutor.d(null);
                                SequentialExecutor.c(null, workerRunningState);
                                z = true;
                            }
                        }
                        Runnable runnable = (Runnable) SequentialExecutor.a(null).poll();
                        this.task = runnable;
                        if (runnable == null) {
                            SequentialExecutor.c(null, WorkerRunningState.IDLE);
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } finally {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.a(null)) {
                    SequentialExecutor.c(null, WorkerRunningState.IDLE);
                    throw e;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.b(null) + "}";
        }
    }

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ Deque a(SequentialExecutor sequentialExecutor) {
        throw null;
    }

    static /* synthetic */ WorkerRunningState b(SequentialExecutor sequentialExecutor) {
        throw null;
    }

    static /* synthetic */ WorkerRunningState c(SequentialExecutor sequentialExecutor, WorkerRunningState workerRunningState) {
        throw null;
    }

    static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        throw null;
    }
}
