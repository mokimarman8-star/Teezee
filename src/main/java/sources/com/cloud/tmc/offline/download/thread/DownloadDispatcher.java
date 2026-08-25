package com.cloud.tmc.offline.download.thread;

import android.os.Looper;
import android.os.MessageQueue;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.offline.download.model.TaskResult;
import com.cloud.tmc.offline.download.task.base.ITask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/cloud/tmc/offline/download/thread/DownloadDispatcher;", "", "executor", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "mExecutor", "dispatch", "", "task", "Lcom/cloud/tmc/offline/download/task/base/ITask;", "onCompleted", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dispatcherEnd", "execute", "submit", "Ljava/util/concurrent/Future;", "runnable", "Ljava/lang/Runnable;", "Companion", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class DownloadDispatcher {
    private static final String TAG = "TmcOfflineDownload: DownLoadDispatcher";
    private final ExecutorService executor;
    private final ExecutorService mExecutor;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DownloadDispatcher() {
        this(r0, 1, r0);
        ExecutorService executorService = null;
    }

    @JvmOverloads
    public DownloadDispatcher(ExecutorService executorService) {
        this.executor = executorService;
        this.mExecutor = executorService == null ? new ScheduledThreadPoolExecutor(Math.max(8, Runtime.getRuntime().availableProcessors() * 2), new DownloadThreadFactory("DownLoadThreadFactory", false)) : executorService;
    }

    public /* synthetic */ DownloadDispatcher(ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : executorService);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dispatch$default(DownloadDispatcher downloadDispatcher, ITask iTask, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        downloadDispatcher.dispatch(iTask, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dispatch$lambda$1(final ITask iTask, final DownloadDispatcher downloadDispatcher, final Function1 function1) {
        Intrinsics.h(iTask, "$task");
        Intrinsics.h(downloadDispatcher, "this$0");
        TmcLogger.d(TAG, "execute idleHandler task: " + iTask);
        downloadDispatcher.mExecutor.execute(new Runnable() { // from class: com.cloud.tmc.offline.download.thread.c
            @Override // java.lang.Runnable
            public final void run() {
                DownloadDispatcher.dispatch$lambda$1$lambda$0(DownloadDispatcher.this, iTask, function1);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatch$lambda$1$lambda$0(DownloadDispatcher downloadDispatcher, ITask iTask, Function1 function1) {
        Intrinsics.h(downloadDispatcher, "this$0");
        Intrinsics.h(iTask, "$task");
        downloadDispatcher.execute(iTask);
        if (function1 != null) {
            function1.invoke(iTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatch$lambda$2(DownloadDispatcher downloadDispatcher, ITask iTask, Function1 function1) {
        Intrinsics.h(downloadDispatcher, "this$0");
        Intrinsics.h(iTask, "$task");
        downloadDispatcher.execute(iTask);
        if (function1 != null) {
            function1.invoke(iTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execute(final ITask task) {
        TmcLogger.d(TAG, "execute task: " + task);
        try {
            task.run(new Function1<TaskResult<?>, Unit>() { // from class: com.cloud.tmc.offline.download.thread.DownloadDispatcher$execute$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((TaskResult<?>) obj);
                    return Unit.a;
                }

                public final void invoke(TaskResult<?> taskResult) {
                    Intrinsics.h(taskResult, "result");
                    Function2<ITask, TaskResult<?>, Unit> onResult = ITask.this.getOnResult();
                    if (onResult != null) {
                        onResult.invoke(ITask.this, taskResult);
                    }
                    if (taskResult instanceof TaskResult.Retry) {
                        try {
                            Thread.sleep(taskResult.getDelay());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        this.execute(task);
                    }
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "execute task run failed!", th);
        }
    }

    public final void dispatch(final ITask task, final Function1<? super ITask, Unit> onCompleted) {
        Intrinsics.h(task, "task");
        if (task.isIdleRunTask()) {
            Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.cloud.tmc.offline.download.thread.a
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean dispatch$lambda$1;
                    dispatch$lambda$1 = DownloadDispatcher.dispatch$lambda$1(ITask.this, this, onCompleted);
                    return dispatch$lambda$1;
                }
            });
        } else {
            this.mExecutor.execute(new Runnable() { // from class: com.cloud.tmc.offline.download.thread.b
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadDispatcher.dispatch$lambda$2(DownloadDispatcher.this, task, onCompleted);
                }
            });
        }
    }

    public final void dispatcherEnd() {
        if (Intrinsics.c(this.executor, this.mExecutor)) {
            return;
        }
        if (AppDynamicBuildConfig.isAppDebugAble()) {
            TmcLogger.d(TAG, "auto shutdown default executor");
        }
        this.mExecutor.shutdown();
    }

    public final Future<?> submit(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        Future<?> submit = this.mExecutor.submit(runnable);
        Intrinsics.g(submit, "mExecutor.submit(runnable)");
        return submit;
    }
}
