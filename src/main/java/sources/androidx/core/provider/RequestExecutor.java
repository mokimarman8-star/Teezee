package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class RequestExecutor {

    private static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f7038a;

        /* renamed from: b, reason: collision with root package name */
        private int f7039b;

        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable runnable, String str, int i5) {
                super(runnable, str);
                this.mPriority = i5;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(String str, int i5) {
            this.f7038a = str;
            this.f7039b = i5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f7038a, this.f7039b);
        }
    }

    private static class ReplyRunnable<T> implements Runnable {
        private Callable<T> mCallable;
        private androidx.core.util.a mConsumer;
        private Handler mHandler;

        ReplyRunnable(Handler handler, Callable<T> callable, androidx.core.util.a aVar) {
            this.mCallable = callable;
            this.mConsumer = aVar;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t5;
            try {
                t5 = this.mCallable.call();
            } catch (Exception unused) {
                t5 = null;
            }
            final androidx.core.util.a aVar = this.mConsumer;
            this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.accept(t5);
                }
            });
        }
    }

    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f7040a;

        a(Handler handler) {
            this.f7040a = (Handler) androidx.core.util.i.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f7040a.post((Runnable) androidx.core.util.i.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f7040a + " is shutting down");
        }
    }

    static ThreadPoolExecutor a(String str, int i5, int i6) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i6, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i5));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(Handler handler) {
        return new a(handler);
    }

    static void c(Executor executor, Callable callable, androidx.core.util.a aVar) {
        executor.execute(new ReplyRunnable(androidx.core.provider.a.a(), callable, aVar));
    }

    static Object d(ExecutorService executorService, Callable callable, int i5) {
        try {
            return executorService.submit(callable).get(i5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e5) {
            throw e5;
        } catch (ExecutionException e6) {
            throw new RuntimeException(e6);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
