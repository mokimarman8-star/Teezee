package okhttp3.internal.concurrent;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", HttpUrl.FRAGMENT_ENCODE_SET, "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", HttpUrl.FRAGMENT_ENCODE_SET, "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class TaskRunner$RealBackend implements TaskRunner$Backend {
    private final ThreadPoolExecutor executor;

    public TaskRunner$RealBackend(ThreadFactory threadFactory) {
        Intrinsics.h(threadFactory, "threadFactory");
        this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    @Override // okhttp3.internal.concurrent.TaskRunner$Backend
    public void beforeTask(TaskRunner taskRunner) {
        Intrinsics.h(taskRunner, "taskRunner");
    }

    @Override // okhttp3.internal.concurrent.TaskRunner$Backend
    public void coordinatorNotify(TaskRunner taskRunner) {
        Intrinsics.h(taskRunner, "taskRunner");
        taskRunner.notify();
    }

    @Override // okhttp3.internal.concurrent.TaskRunner$Backend
    public void coordinatorWait(TaskRunner taskRunner, long nanos) throws InterruptedException {
        Intrinsics.h(taskRunner, "taskRunner");
        long j = nanos / 1000000;
        long j2 = nanos - (1000000 * j);
        if (j > 0 || nanos > 0) {
            taskRunner.wait(j, (int) j2);
        }
    }

    @Override // okhttp3.internal.concurrent.TaskRunner$Backend
    public void execute(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        this.executor.execute(runnable);
    }

    @Override // okhttp3.internal.concurrent.TaskRunner$Backend
    public long nanoTime() {
        return System.nanoTime();
    }

    public final void shutdown() {
        this.executor.shutdown();
    }
}
