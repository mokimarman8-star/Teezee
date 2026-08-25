package com.transsion.core.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a implements b {
    private static volatile a b;
    private ThreadPoolExecutor a;

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                        b.a = TranssionPoolExecutor.c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // com.transsion.core.pool.b
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
