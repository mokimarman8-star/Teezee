package com.transsion.core.pool;

import android.os.Process;
import android.os.StrictMode;
import com.transsion.core.log.LogUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TranssionPoolExecutor extends ThreadPoolExecutor {
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
            if (obj != null && comparableFutureTask.object != null && obj.getClass().equals(comparableFutureTask.object.getClass())) {
                Object obj2 = this.object;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(comparableFutureTask.object);
                }
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
            thread = new Thread(runnable, "zero-" + this.a + "-thread-" + this.d) { // from class: com.transsion.core.pool.TranssionPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.b.handle(th2);
                    }
                }
            };
            this.d = this.d + 1;
            return thread;
        }
    }

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th2) {
                LogUtils.d("ZeroPoolExecutor", new Object[]{"Request threw uncaught throwable", th2});
            }
        },
        THROW { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th2) {
                super.handle(th2);
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        };

        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        /* synthetic */ UncaughtThrowableStrategy(a aVar) {
            this();
        }

        protected void handle(Throwable th2) {
        }
    }

    static class a implements FilenameFilter {
        final /* synthetic */ Pattern a;

        a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public TranssionPoolExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z, boolean z2) {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z));
        this.a = z2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("size is :");
            sb.append(getPoolSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int a() {
        File[] fileArr;
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th2) {
            LogUtils.d("ZeroPoolExecutor", new Object[]{"Failed to calculate accurate cpu count", th2});
            fileArr = null;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0));
    }

    private Future b(Future future) {
        if (this.a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return future;
    }

    public static TranssionPoolExecutor c() {
        return d(a(), "source", UncaughtThrowableStrategy.DEFAULT);
    }

    public static TranssionPoolExecutor d(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new TranssionPoolExecutor(i, str, uncaughtThrowableStrategy, false, false);
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
        return b(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return b(super.submit(runnable, obj));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return b(super.submit(callable));
    }
}
