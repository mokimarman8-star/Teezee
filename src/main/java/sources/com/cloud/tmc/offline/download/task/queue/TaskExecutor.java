package com.cloud.tmc.offline.download.task.queue;

import android.util.Log;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.task.base.ITask;
import com.cloud.tmc.offline.download.thread.DownloadDispatcher;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/offline/download/task/queue/TaskExecutor;", "Ljava/lang/Runnable;", "dispatcher", "Lcom/cloud/tmc/offline/download/thread/DownloadDispatcher;", "parallelism", "", "mTask", "Ljava/util/concurrent/BlockingQueue;", "Lcom/cloud/tmc/offline/download/task/base/ITask;", "(Lcom/cloud/tmc/offline/download/thread/DownloadDispatcher;ILjava/util/concurrent/BlockingQueue;)V", "inFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "waitCountLimit", "log", "", "", "printStack", "", "quit", "run", "sleep", "startQueue", "Companion", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TaskExecutor implements Runnable {
    private static final int MAX_WAIT_COUNT_LIMIT = 3;
    private static final long MAX_WAIT_TIMEOUT = 10000;
    private static final String TAG = "TmcOfflineDownload: TaskExecutor";
    private final DownloadDispatcher dispatcher;
    private final AtomicInteger inFlightTasks;
    private final AtomicBoolean isRunning;
    private final BlockingQueue<ITask> mTask;
    private final int parallelism;
    private final AtomicInteger waitCountLimit;

    public TaskExecutor(DownloadDispatcher downloadDispatcher, int i, BlockingQueue<ITask> blockingQueue) {
        Intrinsics.h(downloadDispatcher, "dispatcher");
        Intrinsics.h(blockingQueue, "mTask");
        this.dispatcher = downloadDispatcher;
        this.parallelism = i;
        this.mTask = blockingQueue;
        this.isRunning = new AtomicBoolean(false);
        this.inFlightTasks = new AtomicInteger(0);
        this.waitCountLimit = new AtomicInteger(0);
    }

    public /* synthetic */ TaskExecutor(DownloadDispatcher downloadDispatcher, int i, BlockingQueue blockingQueue, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadDispatcher, (i2 & 2) != 0 ? 1 : i, blockingQueue);
    }

    private final void log(String log, boolean printStack) {
        TmcLogger.d(TAG, log + " " + (printStack ? Log.getStackTraceString(new Throwable("Just Print")) : ""));
    }

    static /* synthetic */ void log$default(TaskExecutor taskExecutor, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        taskExecutor.log(str, z);
    }

    private final void sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            TmcLogger.e(TAG, "InterruptedException while sleeping.", e);
        }
    }

    public final void quit() {
        if (this.isRunning.getAndSet(false)) {
            log$default(this, "quit", false, 2, null);
            try {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.isRunning.get() && !Thread.currentThread().isInterrupted()) {
            log$default(this, "Start Waiting...", false, 2, null);
            try {
                final ITask poll = this.mTask.poll(MAX_WAIT_TIMEOUT, TimeUnit.MILLISECONDS);
                log$default(this, "Waiting for task: " + poll, false, 2, null);
                if (poll == null) {
                    int incrementAndGet = this.waitCountLimit.incrementAndGet();
                    log$default(this, "incrementAndGet: " + incrementAndGet, false, 2, null);
                    if (incrementAndGet >= 3) {
                        log$default(this, "When the maximum number of acquisition timeouts is reached, exit the current thread", false, 2, null);
                        quit();
                        return;
                    }
                    poll = null;
                }
                if (poll != null) {
                    this.waitCountLimit.set(0);
                }
                int incrementAndGet2 = this.inFlightTasks.incrementAndGet();
                log$default(this, "inFlight: " + incrementAndGet2, false, 2, null);
                if (incrementAndGet2 > this.parallelism) {
                    sleep();
                    if (poll != null) {
                        log$default(this, "Reached the maximum parallelism, re-throw into the queue " + poll, false, 2, null);
                        this.mTask.add(poll);
                    }
                    this.inFlightTasks.decrementAndGet();
                } else if (poll != null) {
                    log$default(this, "Run task: " + poll, false, 2, null);
                    this.dispatcher.dispatch(poll, new Function1<ITask, Unit>() { // from class: com.cloud.tmc.offline.download.task.queue.TaskExecutor$run$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ITask) obj);
                            return Unit.a;
                        }

                        public final void invoke(ITask iTask) {
                            AtomicInteger atomicInteger;
                            Intrinsics.h(iTask, "it");
                            TaskExecutor.log$default(TaskExecutor.this, "Run task finished: " + poll, false, 2, null);
                            atomicInteger = TaskExecutor.this.inFlightTasks;
                            atomicInteger.decrementAndGet();
                        }
                    });
                } else {
                    this.inFlightTasks.decrementAndGet();
                }
            } catch (InterruptedException unused) {
                if (!this.isRunning.get()) {
                    quit();
                    return;
                }
            }
        }
    }

    public final void startQueue() {
        if (this.isRunning.getAndSet(true)) {
            return;
        }
        log$default(this, "startQueue", false, 2, null);
        this.inFlightTasks.set(0);
        this.waitCountLimit.set(0);
        this.dispatcher.submit(this);
    }
}
