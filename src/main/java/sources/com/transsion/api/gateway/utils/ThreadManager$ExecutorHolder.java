package com.transsion.api.gateway.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$ExecutorHolder {
    private static ExecutorService mExecutor = new ThreadPoolExecutor(0, 8, 20, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.transsion.api.gateway.utils.ThreadManager$GatewayThreadFactory
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "gateway-pool-" + poolNumber.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    private ThreadManager$ExecutorHolder() {
    }
}
