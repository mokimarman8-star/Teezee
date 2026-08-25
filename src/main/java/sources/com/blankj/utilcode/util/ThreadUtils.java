package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ThreadUtils {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final Map b = new HashMap();
    private static final Map c = new ConcurrentHashMap();
    private static final int d = Runtime.getRuntime().availableProcessors();
    private static final Timer e = new Timer();
    private static Executor f;

    private static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile b mPool;

        LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        LinkedBlockingQueue4Util(int i) {
            this.mCapacity = i;
        }

        LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }
    }

    static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + a.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new a(this));
            thread.setPriority(this.priority);
            return thread;
        }
    }

    public static ExecutorService d() {
        return g(-2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Executor e() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    public static Handler f() {
        return a;
    }

    private static ExecutorService g(int i) {
        return h(i, 5);
    }

    private static ExecutorService h(int i, int i2) {
        ExecutorService executorService;
        Map map = b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(Integer.valueOf(i));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorService = b.a(i, i2);
                    concurrentHashMap.put(Integer.valueOf(i2), executorService);
                    map.put(Integer.valueOf(i), concurrentHashMap);
                } else {
                    executorService = (ExecutorService) map2.get(Integer.valueOf(i2));
                    if (executorService == null) {
                        executorService = b.a(i, i2);
                        map2.put(Integer.valueOf(i2), executorService);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void j(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void k(Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }
}
