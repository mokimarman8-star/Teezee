package com.transsion.transfer.androidasync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class c {
    Semaphore a = new Semaphore(0);

    public void a() {
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        c cVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.a.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable remove = orCreateThreadQueue.remove();
                if (remove == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.a.tryAcquire()) {
                        return;
                    }
                } else {
                    remove.run();
                }
            }
        } finally {
            orCreateThreadQueue.waiter = cVar;
        }
    }

    public void b() {
        this.a.release();
        ThreadQueue.release(this);
    }

    public boolean c(long j, TimeUnit timeUnit) {
        long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        c cVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.a.tryAcquire()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable remove = orCreateThreadQueue.remove();
                if (remove != null) {
                    remove.run();
                } else {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), convert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.a.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - currentTimeMillis >= convert) {
                        return false;
                    }
                }
            }
        } finally {
            orCreateThreadQueue.waiter = cVar;
        }
    }
}
