package com.transsion.push.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$SerialExecutor implements Executor {
    final Queue a;
    Runnable b;

    private ThreadManager$SerialExecutor() {
        this.a = new LinkedList();
    }

    protected synchronized void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.b = runnable;
        if (runnable != null) {
            ThreadManager.a().execute(this.b);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.a.offer(new Runnable() { // from class: com.transsion.push.utils.ThreadManager$SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    ThreadManager$SerialExecutor.this.a();
                }
            }
        });
        if (this.b == null) {
            a();
        }
    }
}
