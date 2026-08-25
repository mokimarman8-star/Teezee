package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class w extends b implements e2 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(w.class, "cleanedAndPointers$volatile");
    public final long c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public w(long j, w wVar, int i) {
        super(wVar);
        this.c = j;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // kotlinx.coroutines.internal.b
    public boolean k() {
        return d.get(this) == r() && !l();
    }

    public final boolean p() {
        return d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i, Throwable th, CoroutineContext coroutineContext);

    public final void t() {
        if (d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
