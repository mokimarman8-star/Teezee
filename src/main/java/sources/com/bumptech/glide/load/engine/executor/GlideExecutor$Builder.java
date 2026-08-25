package com.bumptech.glide.load.engine.executor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class GlideExecutor$Builder {
    public static final long NO_THREAD_TIMEOUT = 0;
    private int corePoolSize;
    private int maximumPoolSize;
    private String name;
    private final boolean preventNetworkOperations;
    private long threadTimeoutMillis;

    @NonNull
    private ThreadFactory threadFactory = new GlideExecutor.DefaultPriorityThreadFactory((GlideExecutor$1) null);

    @NonNull
    private GlideExecutor$UncaughtThrowableStrategy uncaughtThrowableStrategy = GlideExecutor$UncaughtThrowableStrategy.DEFAULT;

    GlideExecutor$Builder(boolean z) {
        this.preventNetworkOperations = z;
    }

    public GlideExecutor build() {
        if (TextUtils.isEmpty(this.name)) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) new PriorityBlockingQueue(), (ThreadFactory) new GlideExecutor.DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
        if (this.threadTimeoutMillis != 0) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return new GlideExecutor(threadPoolExecutor);
    }

    public GlideExecutor$Builder setName(String str) {
        this.name = str;
        return this;
    }

    public GlideExecutor$Builder setThreadCount(int i) {
        this.corePoolSize = i;
        this.maximumPoolSize = i;
        return this;
    }

    @Deprecated
    public GlideExecutor$Builder setThreadFactory(@NonNull ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    public GlideExecutor$Builder setThreadTimeoutMillis(long j) {
        this.threadTimeoutMillis = j;
        return this;
    }

    public GlideExecutor$Builder setUncaughtThrowableStrategy(@NonNull GlideExecutor$UncaughtThrowableStrategy glideExecutor$UncaughtThrowableStrategy) {
        this.uncaughtThrowableStrategy = glideExecutor$UncaughtThrowableStrategy;
        return this;
    }
}
