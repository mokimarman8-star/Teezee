package com.transsion.transfer.androidasync;

import java.io.Closeable;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class x implements Closeable {
    private Selector a;
    public AtomicBoolean b = new AtomicBoolean(false);
    Semaphore c = new Semaphore(0);

    public x(Selector selector) {
        this.a = selector;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public Selector d() {
        return this.a;
    }

    public Set h() {
        return this.a.keys();
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public void k() {
        l(0L);
    }

    public void l(long j) {
        try {
            this.c.drainPermits();
            this.a.select(j);
        } finally {
            this.c.release(Integer.MAX_VALUE);
        }
    }

    public int m() {
        return this.a.selectNow();
    }

    public Set n() {
        return this.a.selectedKeys();
    }

    public boolean o() {
        for (int i = 0; i < 100; i++) {
            try {
                this.c.tryAcquire(10L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        boolean tryAcquire = this.c.tryAcquire();
        this.a.wakeup();
        if (tryAcquire) {
            if (this.b.getAndSet(true)) {
                this.a.wakeup();
                return;
            }
            try {
                o();
                this.a.wakeup();
            } finally {
                this.b.set(false);
            }
        }
    }
}
