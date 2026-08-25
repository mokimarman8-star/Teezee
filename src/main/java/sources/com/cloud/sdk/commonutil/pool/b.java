package com.cloud.sdk.commonutil.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b {
    private static volatile b b;
    private static ThreadPoolExecutor c;
    private ThreadPoolExecutor a;

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                        b bVar = b;
                        ThreadPoolExecutor threadPoolExecutor = c;
                        if (threadPoolExecutor == null) {
                            threadPoolExecutor = HSPoolExecutor.b();
                        }
                        bVar.a = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.a.prestartAllCoreThreads();
            }
            this.a.execute(runnable);
        }
    }
}
