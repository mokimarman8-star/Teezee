package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l1 extends k1 implements t0 {
    private final Executor b;

    public l1(Executor executor) {
        this.b = executor;
        if (p() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) p()).setRemoveOnCancelPolicy(true);
        }
    }

    private final void q(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        v1.c(coroutineContext, i1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture r(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            q(coroutineContext, e);
            return null;
        }
    }

    public void close() {
        Executor p = p();
        ExecutorService executorService = p instanceof ExecutorService ? (ExecutorService) p : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b bVar;
        b bVar2;
        Runnable runnable2;
        try {
            Executor p = p();
            bVar2 = c.a;
            if (bVar2 != null) {
                runnable2 = bVar2.h(runnable);
                if (runnable2 == null) {
                }
                p.execute(runnable2);
            }
            runnable2 = runnable;
            p.execute(runnable2);
        } catch (RejectedExecutionException e) {
            bVar = c.a;
            if (bVar != null) {
                bVar.e();
            }
            q(coroutineContext, e);
            y0.b().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof l1) && ((l1) obj).p() == p();
    }

    public int hashCode() {
        return System.identityHashCode(p());
    }

    @Override // kotlinx.coroutines.t0
    public a1 invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        Executor p = p();
        ScheduledExecutorService scheduledExecutorService = p instanceof ScheduledExecutorService ? (ScheduledExecutorService) p : null;
        ScheduledFuture r = scheduledExecutorService != null ? r(scheduledExecutorService, runnable, coroutineContext, j) : null;
        return r != null ? new z0(r) : DefaultExecutor.INSTANCE.invokeOnTimeout(j, runnable, coroutineContext);
    }

    public Executor p() {
        return this.b;
    }

    @Override // kotlinx.coroutines.t0
    public void scheduleResumeAfterDelay(long j, n nVar) {
        Executor p = p();
        ScheduledExecutorService scheduledExecutorService = p instanceof ScheduledExecutorService ? (ScheduledExecutorService) p : null;
        ScheduledFuture r = scheduledExecutorService != null ? r(scheduledExecutorService, new ResumeUndispatchedRunnable(this, nVar), nVar.getA(), j) : null;
        if (r != null) {
            q.c(nVar, new l(r));
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j, nVar);
        }
    }

    public String toString() {
        return p().toString();
    }
}
