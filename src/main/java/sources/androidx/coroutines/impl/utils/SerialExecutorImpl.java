package androidx.coroutines.impl.utils;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import k4.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SerialExecutorImpl implements a {
    private final Executor b;
    private Runnable c;
    private final ArrayDeque a = new ArrayDeque();
    final Object d = new Object();

    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(@NonNull SerialExecutorImpl serialExecutorImpl, @NonNull Runnable runnable) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this.mSerialExecutor.d) {
                    this.mSerialExecutor.a();
                }
            } catch (Throwable th) {
                synchronized (this.mSerialExecutor.d) {
                    this.mSerialExecutor.a();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.b = executor;
    }

    void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.c = runnable;
        if (runnable != null) {
            this.b.execute(runnable);
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.d) {
            try {
                this.a.add(new Task(this, runnable));
                if (this.c == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean n() {
        boolean z;
        synchronized (this.d) {
            z = !this.a.isEmpty();
        }
        return z;
    }
}
