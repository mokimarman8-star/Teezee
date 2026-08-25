package com.tn.lib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ThreadPool {
    public static final b a = new b(null);
    private static final Lazy b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.tn.lib.thread.d
        public final Object invoke() {
            ThreadPool b2;
            b2 = ThreadPool.b();
            return b2;
        }
    });
    private static final int c;
    private static final int d;
    private static final int e;
    private static final BlockingQueue f;
    private static final ThreadFactory g;
    private static ThreadPoolExecutor h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tn/lib/thread/ThreadPool$BackgroundThread;", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "name", "", "<init>", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "thread_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class BackgroundThread extends Thread {
        public BackgroundThread(Runnable runnable, String str) {
            super(runnable, str);
            setPriority(5);
        }
    }

    public static final class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            return new BackgroundThread(runnable, "or_threadpool_" + this.a.getAndIncrement());
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ThreadPool a() {
            return (ThreadPool) ThreadPool.b.getValue();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = RangesKt.h(availableProcessors - 1, 4);
        e = RangesKt.h((availableProcessors * 2) + 1, 8);
        f = new LinkedBlockingQueue(64);
        g = new a();
    }

    private ThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 30L, TimeUnit.SECONDS, f, g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        h = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPool b() {
        return new ThreadPool();
    }

    public static final ThreadPool e() {
        return a.a();
    }

    public final void d(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
