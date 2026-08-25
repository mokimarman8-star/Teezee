package com.blankj.utilcode.util;

import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ThreadUtils$2 extends TimerTask {
    final /* synthetic */ ExecutorService val$pool;
    final /* synthetic */ ThreadUtils$Task val$task;

    ThreadUtils$2(ExecutorService executorService, ThreadUtils$Task threadUtils$Task) {
        this.val$pool = executorService;
        this.val$task = threadUtils$Task;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.val$pool.execute(this.val$task);
    }
}
