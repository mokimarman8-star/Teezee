package com.blankj.utilcode.util;

import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class ThreadUtils$b extends ThreadPoolExecutor {
    private final AtomicInteger a;
    private ThreadUtils.LinkedBlockingQueue4Util b;

    ThreadUtils$b(int i, int i2, long j, TimeUnit timeUnit, ThreadUtils.LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, (BlockingQueue<Runnable>) linkedBlockingQueue4Util, threadFactory);
        this.a = new AtomicInteger();
        ThreadUtils.LinkedBlockingQueue4Util.access$302(linkedBlockingQueue4Util, this);
        this.b = linkedBlockingQueue4Util;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutorService b(int i, int i2) {
        if (i == -8) {
            return new ThreadUtils$b(ThreadUtils.a() + 1, (ThreadUtils.a() * 2) + 1, 30L, TimeUnit.SECONDS, new ThreadUtils.LinkedBlockingQueue4Util(true), new ThreadUtils.UtilsThreadFactory("cpu", i2));
        }
        if (i == -4) {
            return new ThreadUtils$b((ThreadUtils.a() * 2) + 1, (ThreadUtils.a() * 2) + 1, 30L, TimeUnit.SECONDS, new ThreadUtils.LinkedBlockingQueue4Util(), new ThreadUtils.UtilsThreadFactory("io", i2));
        }
        if (i == -2) {
            return new ThreadUtils$b(0, 128, 60L, TimeUnit.SECONDS, new ThreadUtils.LinkedBlockingQueue4Util(true), new ThreadUtils.UtilsThreadFactory("cached", i2));
        }
        if (i == -1) {
            return new ThreadUtils$b(1, 1, 0L, TimeUnit.MILLISECONDS, new ThreadUtils.LinkedBlockingQueue4Util(), new ThreadUtils.UtilsThreadFactory("single", i2));
        }
        return new ThreadUtils$b(i, i, 0L, TimeUnit.MILLISECONDS, new ThreadUtils.LinkedBlockingQueue4Util(), new ThreadUtils.UtilsThreadFactory("fixed(" + i + ")", i2));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        this.a.decrementAndGet();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (isShutdown()) {
            return;
        }
        this.a.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException unused) {
            Log.e("ThreadUtils", "This will not happen!");
            this.b.offer(runnable);
        } catch (Throwable unused2) {
            this.a.decrementAndGet();
        }
    }
}
