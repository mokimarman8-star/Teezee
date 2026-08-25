package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class p extends AbstractResolvableFuture implements ScheduledFuture {
    private final ScheduledFuture h;

    class a implements b {
        a() {
        }

        @Override // com.google.firebase.concurrent.p.b
        public void a(Throwable th) {
            p.this.v(th);
        }

        @Override // com.google.firebase.concurrent.p.b
        public void set(Object obj) {
            p.this.u(obj);
        }
    }

    interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    interface c {
        ScheduledFuture a(b bVar);
    }

    p(c cVar) {
        this.h = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.h.compareTo(delayed);
    }

    protected void d() {
        this.h.cancel(x());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.h.getDelay(timeUnit);
    }
}
