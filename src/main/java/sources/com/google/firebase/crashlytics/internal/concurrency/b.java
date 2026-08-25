package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import v3.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b {
    private static final Executor a = new m();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task b(TaskCompletionSource taskCompletionSource, AtomicBoolean atomicBoolean, CancellationTokenSource cancellationTokenSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else if (task.getException() != null) {
            taskCompletionSource.trySetException(task.getException());
        } else if (atomicBoolean.getAndSet(true)) {
            cancellationTokenSource.cancel();
        }
        return Tasks.forResult((Object) null);
    }

    public static Task c(Task task, Task task2) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Continuation continuation = new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.a
            public final Object then(Task task3) {
                Task b;
                b = b.b(taskCompletionSource, atomicBoolean, cancellationTokenSource, task3);
                return b;
            }
        };
        Executor executor = a;
        task.continueWithTask(executor, continuation);
        task2.continueWithTask(executor, continuation);
        return taskCompletionSource.getTask();
    }
}
