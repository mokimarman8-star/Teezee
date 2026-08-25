package io.reactivex.rxjava3.internal.subscriptions;

import i00.d;
import io.reactivex.rxjava3.internal.util.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z) {
        this.cancelOnReplace = z;
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        int i = 1;
        long j = 0;
        d dVar = null;
        do {
            d dVar2 = this.missedSubscription.get();
            if (dVar2 != null) {
                dVar2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = a.b(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.cancelOnReplace) {
                        dVar3.cancel();
                    }
                    this.actual = dVar2;
                    if (j4 != 0) {
                        j = a.b(j, j4);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && j2 != 0) {
                    j = a.b(j, j2);
                    dVar = dVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            dVar.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.missedProduced, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                SubscriptionHelper.reportMoreProduced(j3);
                j3 = 0;
            }
            this.requested = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.missedRequested, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long b = a.b(j2, j);
            this.requested = b;
            if (b == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        d dVar = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (dVar != null) {
            dVar.request(j);
        }
    }

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        Objects.requireNonNull(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d andSet = this.missedSubscription.getAndSet(dVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        d dVar2 = this.actual;
        if (dVar2 != null && this.cancelOnReplace) {
            dVar2.cancel();
        }
        this.actual = dVar;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            dVar.request(j);
        }
    }
}
