package com.transsion.api.gateway.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$SerialExecutor implements Executor {
    public Runnable mActive;
    public final Queue<Runnable> mTasks;

    private ThreadManager$SerialExecutor() {
        this.mTasks = new LinkedList();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() { // from class: com.transsion.api.gateway.utils.ThreadManager$SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    ThreadManager$SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            ThreadManager.access$400().execute(this.mActive);
        }
    }
}
