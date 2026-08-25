package com.google.common.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class MoreExecutors$Application$1 implements Runnable {
    final /* synthetic */ MoreExecutors$b this$0;
    final /* synthetic */ ExecutorService val$service;
    final /* synthetic */ long val$terminationTimeout;
    final /* synthetic */ TimeUnit val$timeUnit;

    MoreExecutors$Application$1(MoreExecutors$b moreExecutors$b, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.val$service = executorService;
        this.val$terminationTimeout = j;
        this.val$timeUnit = timeUnit;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$service.shutdown();
            this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
        } catch (InterruptedException unused) {
        }
    }
}
