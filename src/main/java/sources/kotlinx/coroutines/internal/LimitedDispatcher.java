package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.t0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class LimitedDispatcher extends i0 implements t0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    private final /* synthetic */ t0 a;
    private final i0 b;
    private final int c;
    private final String d;
    private final l e;
    private final Object f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    public LimitedDispatcher(i0 i0Var, int i, String str) {
        t0 t0Var = i0Var instanceof t0 ? (t0) i0Var : null;
        this.a = t0Var == null ? q0.a() : t0Var;
        this.b = i0Var;
        this.c = i;
        this.d = str;
        this.e = new l(false);
        this.f = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable s() {
        while (true) {
            Runnable runnable = (Runnable) this.e.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f) {
                g.decrementAndGet(this);
                if (this.e.c() == 0) {
                    return null;
                }
                g.incrementAndGet(this);
            }
        }
    }

    private final boolean t() {
        synchronized (this.f) {
            if (g.get(this) >= this.c) {
                return false;
            }
            g.incrementAndGet(this);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable s;
        this.e.a(runnable);
        if (g.get(this) >= this.c || !t() || (s = s()) == null) {
            return;
        }
        this.b.dispatch(this, new Worker(this, s));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.i0
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable s;
        this.e.a(runnable);
        if (g.get(this) >= this.c || !t() || (s = s()) == null) {
            return;
        }
        this.b.dispatchYield(this, new Worker(this, s));
    }

    public a1 invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.a.invokeOnTimeout(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int i, String str) {
        i.a(i);
        return i >= this.c ? i.b(this, str) : super.limitedParallelism(i, str);
    }

    public void scheduleResumeAfterDelay(long j, n nVar) {
        this.a.scheduleResumeAfterDelay(j, nVar);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return this.b + ".limitedParallelism(" + this.c + ')';
    }
}
