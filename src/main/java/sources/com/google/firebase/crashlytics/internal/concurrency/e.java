package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e implements Executor {
    private final ExecutorService a;
    private final Object b = new Object();
    private Task c = Tasks.forResult((Object) null);

    e(ExecutorService executorService) {
        this.a = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task d(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task e(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public ExecutorService c() {
        return this.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public Task f(final Runnable runnable) {
        Task continueWithTask;
        synchronized (this.b) {
            continueWithTask = this.c.continueWithTask(this.a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.d
                public final Object then(Task task) {
                    Task d;
                    d = e.d(runnable, task);
                    return d;
                }
            });
            this.c = continueWithTask;
        }
        return continueWithTask;
    }

    public Task g(final Callable callable) {
        Task continueWithTask;
        synchronized (this.b) {
            continueWithTask = this.c.continueWithTask(this.a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.c
                public final Object then(Task task) {
                    Task e;
                    e = e.e(callable, task);
                    return e;
                }
            });
            this.c = continueWithTask;
        }
        return continueWithTask;
    }
}
