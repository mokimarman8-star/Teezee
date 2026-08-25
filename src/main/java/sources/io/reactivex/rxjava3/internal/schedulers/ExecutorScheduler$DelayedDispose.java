package io.reactivex.rxjava3.internal.schedulers;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ExecutorScheduler$DelayedDispose implements Runnable {
    private final ExecutorScheduler$DelayedRunnable dr;
    final /* synthetic */ ExecutorScheduler this$0;

    ExecutorScheduler$DelayedDispose(ExecutorScheduler executorScheduler, ExecutorScheduler$DelayedRunnable executorScheduler$DelayedRunnable) {
        this.this$0 = executorScheduler;
        this.dr = executorScheduler$DelayedRunnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExecutorScheduler$DelayedRunnable executorScheduler$DelayedRunnable = this.dr;
        executorScheduler$DelayedRunnable.direct.replace(this.this$0.d(executorScheduler$DelayedRunnable));
    }
}
