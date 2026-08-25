package com.transsnet.downloader.core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadExecutor {
    public static final b a = new b((DefaultConstructorMarker) null);
    private static final Lazy b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.core.thread.c
        public final Object invoke() {
            DownloadExecutor b2;
            b2 = DownloadExecutor.b();
            return b2;
        }
    });
    private static final int c;
    private static final int d;
    private static final int e;
    private static final BlockingQueue f;
    private static final ThreadFactory g;
    private static ThreadPoolExecutor h;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = RangesKt.e(availableProcessors, 8);
        e = RangesKt.e(availableProcessors, 8);
        f = new LinkedBlockingQueue(64);
        g = new a();
    }

    private DownloadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 20L, TimeUnit.SECONDS, f, g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        h = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadExecutor b() {
        return new DownloadExecutor();
    }

    public final void e(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
