package q8;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a implements Executor {
    public static final Executor b = new a("GENERAL_EXECUTOR", 4, 32);
    public static final ScheduledExecutorService c = Executors.newScheduledThreadPool(4);
    private static int d = 32;
    private ThreadPoolExecutor a;

    /* renamed from: q8.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0061a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);
        final /* synthetic */ String b;

        ThreadFactoryC0061a(String str) {
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format(Locale.US, "BiddingKit:%s #%d", this.b, Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0061a(str));
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        int size = this.a.getQueue().size();
        synchronized (a.class) {
            try {
                int i = d;
                if (size == i) {
                    d = i * 2;
                    com.facebook.biddingkit.logging.b.a("MultiAsyncTaskExecutor", "Tasks queue too long. Size = " + i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.execute(runnable);
    }
}
