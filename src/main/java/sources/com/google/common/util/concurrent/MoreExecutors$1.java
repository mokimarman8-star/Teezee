package com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class MoreExecutors$1 implements Runnable {
    final /* synthetic */ r val$future;
    final /* synthetic */ BlockingQueue val$queue;

    MoreExecutors$1(BlockingQueue blockingQueue, r rVar) {
        this.val$queue = blockingQueue;
        this.val$future = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$queue.add(this.val$future);
    }
}
