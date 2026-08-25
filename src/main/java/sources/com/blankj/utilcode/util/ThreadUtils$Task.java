package com.blankj.utilcode.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ThreadUtils$Task<T> implements Runnable {
    private static final int CANCELLED = 4;
    private static final int COMPLETING = 3;
    private static final int EXCEPTIONAL = 2;
    private static final int INTERRUPTED = 5;
    private static final int NEW = 0;
    private static final int RUNNING = 1;
    private static final int TIMEOUT = 6;
    private Executor deliver;
    private volatile boolean isSchedule;
    private a mTimeoutListener;
    private long mTimeoutMillis;
    private Timer mTimer;
    private volatile Thread runner;
    private final AtomicInteger state = new AtomicInteger(0);

    /* renamed from: com.blankj.utilcode.util.ThreadUtils$Task$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ThreadUtils$Task.this.isDone()) {
                return;
            }
            ThreadUtils$Task.access$400(ThreadUtils$Task.this);
        }
    }

    public interface a {
    }

    static /* synthetic */ a access$400(ThreadUtils$Task threadUtils$Task) {
        threadUtils$Task.getClass();
        return null;
    }

    private Executor getDeliver() {
        Executor executor = this.deliver;
        return executor == null ? ThreadUtils.b() : executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSchedule(boolean z) {
        this.isSchedule = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeout() {
        synchronized (this.state) {
            try {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(6);
                if (this.runner != null) {
                    this.runner.interrupt();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cancel() {
        cancel(true);
    }

    public void cancel(boolean z) {
        synchronized (this.state) {
            try {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(4);
                if (z && this.runner != null) {
                    this.runner.interrupt();
                }
                getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils$Task.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ThreadUtils$Task.this.onCancel();
                        ThreadUtils$Task.this.onDone();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract T doInBackground() throws Throwable;

    public boolean isCanceled() {
        return this.state.get() >= 4;
    }

    public boolean isDone() {
        return this.state.get() > 1;
    }

    public abstract void onCancel();

    protected void onDone() {
        ThreadUtils.c().remove(this);
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public abstract void onFail(Throwable th);

    public abstract void onSuccess(T t);

    @Override // java.lang.Runnable
    public void run() {
        if (this.isSchedule) {
            if (this.runner == null) {
                if (!this.state.compareAndSet(0, 1)) {
                    return;
                } else {
                    this.runner = Thread.currentThread();
                }
            } else if (this.state.get() != 1) {
                return;
            }
        } else if (!this.state.compareAndSet(0, 1)) {
            return;
        } else {
            this.runner = Thread.currentThread();
        }
        try {
            final T doInBackground = doInBackground();
            if (this.isSchedule) {
                if (this.state.get() != 1) {
                    return;
                }
                getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils$Task.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ThreadUtils$Task.this.onSuccess(doInBackground);
                    }
                });
            } else if (this.state.compareAndSet(1, 3)) {
                getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils$Task.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ThreadUtils$Task.this.onSuccess(doInBackground);
                        ThreadUtils$Task.this.onDone();
                    }
                });
            }
        } catch (InterruptedException unused) {
            this.state.compareAndSet(4, 5);
        } catch (Throwable th) {
            if (this.state.compareAndSet(1, 2)) {
                getDeliver().execute(new Runnable() { // from class: com.blankj.utilcode.util.ThreadUtils$Task.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ThreadUtils$Task.this.onFail(th);
                        ThreadUtils$Task.this.onDone();
                    }
                });
            }
        }
    }

    public ThreadUtils$Task<T> setDeliver(Executor executor) {
        this.deliver = executor;
        return this;
    }

    public ThreadUtils$Task<T> setTimeout(long j, a aVar) {
        this.mTimeoutMillis = j;
        return this;
    }
}
