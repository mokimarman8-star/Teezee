package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.disposables.d;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class IoScheduler extends Scheduler {
    static final RxThreadFactory e;
    static final RxThreadFactory f;
    static final a i;
    static boolean j;
    static final CachedWorkerPool k;
    final ThreadFactory c;
    final AtomicReference d;
    private static final TimeUnit h = TimeUnit.SECONDS;
    private static final long g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    static final class CachedWorkerPool implements Runnable {
        final a allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<a> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.keepAliveTime = nanos;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new a();
            this.threadFactory = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        static void evictExpiredWorkers(ConcurrentLinkedQueue<a> concurrentLinkedQueue, a aVar) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long now = now();
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.e() > now) {
                    return;
                }
                if (concurrentLinkedQueue.remove(next)) {
                    aVar.a(next);
                }
            }
        }

        static long now() {
            return System.nanoTime();
        }

        a get() {
            if (this.allWorkers.isDisposed()) {
                return IoScheduler.i;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                a poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            a aVar = new a(this.threadFactory);
            this.allWorkers.b(aVar);
            return aVar;
        }

        void release(a aVar) {
            aVar.f(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            evictExpiredWorkers(this.expiringWorkerQueue, this.allWorkers);
        }

        void shutdown() {
            this.allWorkers.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    static final class EventLoopWorker extends Scheduler.Worker implements Runnable {
        private final CachedWorkerPool pool;
        private final a threadWorker;
        final AtomicBoolean once = new AtomicBoolean();
        private final a tasks = new a();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                if (IoScheduler.j) {
                    this.threadWorker.a(this, 0L, TimeUnit.NANOSECONDS, (d) null);
                } else {
                    this.pool.release(this.threadWorker);
                }
            }
        }

        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.pool.release(this.threadWorker);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public c schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.tasks.isDisposed() ? EmptyDisposable.INSTANCE : this.threadWorker.a(runnable, j, timeUnit, this.tasks);
        }
    }

    static {
        a aVar = new a(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        i = aVar;
        aVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        e = rxThreadFactory;
        f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        j = Boolean.getBoolean("rx3.io-scheduled-release");
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        k = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    public IoScheduler() {
        this(e);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.c = threadFactory;
        this.d = new AtomicReference(k);
        g();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new EventLoopWorker((CachedWorkerPool) this.d.get());
    }

    public void g() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(g, h, this.c);
        if (j0.a(this.d, k, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.shutdown();
    }
}
