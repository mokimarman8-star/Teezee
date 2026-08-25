package com.cloud.sdk.commonutil.pool;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.cloud.sdk.commonutil.util.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class HSPoolExecutor extends ThreadPoolExecutor {
    private final boolean a;

    protected class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask<V>> {
        private Object object;

        public ComparableFutureTask(Runnable runnable, V v) {
            super(runnable, v);
            this.object = runnable;
        }

        public ComparableFutureTask(Callable<V> callable) {
            super(callable);
            this.object = callable;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<V> comparableFutureTask) {
            if (this == comparableFutureTask) {
                return 0;
            }
            if (comparableFutureTask == null) {
                return -1;
            }
            Object obj = this.object;
            if (obj == null || comparableFutureTask.object == null || !obj.getClass().equals(comparableFutureTask.object.getClass())) {
                return 0;
            }
            Object obj2 = this.object;
            if (obj2 instanceof Comparable) {
                return ((Comparable) obj2).compareTo(comparableFutureTask.object);
            }
            return 0;
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final String a;
        private final UncaughtThrowableStrategy b;
        private final boolean c;
        private int d;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.a = str;
            this.b = uncaughtThrowableStrategy;
            this.c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "zero-" + this.a + "-thread-" + this.d) { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.b.handle(th);
                    }
                }
            };
            this.d = this.d + 1;
            return thread;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.cloud.sdk.commonutil.pool.HSPoolExecutor$UncaughtThrowableStrategy, still in use, count: 1, list:
      (r0v1 com.cloud.sdk.commonutil.pool.HSPoolExecutor$UncaughtThrowableStrategy) from 0x0024: SPUT (r0v1 com.cloud.sdk.commonutil.pool.HSPoolExecutor$UncaughtThrowableStrategy) com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.DEFAULT com.cloud.sdk.commonutil.pool.HSPoolExecutor$UncaughtThrowableStrategy
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th) {
                c.Log().e("ssp", "thread pool: uncaught throwable: " + Log.getStackTraceString(th));
            }
        },
        THROW { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th) {
                super.handle(th);
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        public static final UncaughtThrowableStrategy DEFAULT = new UncaughtThrowableStrategy() { // from class: com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.cloud.sdk.commonutil.pool.HSPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th) {
                c.Log().e("ssp", "thread pool: uncaught throwable: " + Log.getStackTraceString(th));
            }
        };

        static {
        }

        private UncaughtThrowableStrategy() {
        }

        /* synthetic */ UncaughtThrowableStrategy(a aVar) {
            this();
        }

        public static UncaughtThrowableStrategy valueOf(String str) {
            return (UncaughtThrowableStrategy) Enum.valueOf(UncaughtThrowableStrategy.class, str);
        }

        public static UncaughtThrowableStrategy[] values() {
            return (UncaughtThrowableStrategy[]) $VALUES.clone();
        }

        protected void handle(Throwable th) {
        }
    }

    public HSPoolExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z, boolean z2) {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z));
        this.a = z2;
        try {
            c.Log().d("ssp", "HSPoolExecutor init, poolSize=" + getPoolSize());
        } catch (Exception e) {
            c.Log().e("ssp", "HSPoolExecutor init error: " + Log.getStackTraceString(e));
        }
    }

    private Future a(Future future) {
        if (this.a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return future;
    }

    public static HSPoolExecutor b() {
        return new HSPoolExecutor(20, "zero", UncaughtThrowableStrategy.DEFAULT, false, false);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.a) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new ComparableFutureTask(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected RunnableFuture newTaskFor(Callable callable) {
        return new ComparableFutureTask(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return a(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return a(super.submit(runnable, obj));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return a(super.submit(callable));
    }
}
