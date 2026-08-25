package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.t0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r extends kotlinx.coroutines.i0 implements t0 {
    private final /* synthetic */ t0 a;
    private final kotlinx.coroutines.i0 b;
    private final String c;

    public r(kotlinx.coroutines.i0 i0Var, String str) {
        t0 t0Var = i0Var instanceof t0 ? (t0) i0Var : null;
        this.a = t0Var == null ? q0.a() : t0Var;
        this.b = i0Var;
        this.c = str;
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.b.dispatch(coroutineContext, runnable);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.b.dispatchYield(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.t0
    public a1 invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.a.invokeOnTimeout(j, runnable, coroutineContext);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.b.isDispatchNeeded(coroutineContext);
    }

    @Override // kotlinx.coroutines.t0
    public void scheduleResumeAfterDelay(long j, kotlinx.coroutines.n nVar) {
        this.a.scheduleResumeAfterDelay(j, nVar);
    }

    public String toString() {
        return this.c;
    }
}
