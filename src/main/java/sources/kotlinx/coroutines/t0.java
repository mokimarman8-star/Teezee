package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface t0 {

    public static final class a {
        public static Object a(t0 t0Var, long j, Continuation continuation) {
            if (j <= 0) {
                return Unit.a;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            t0Var.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result == IntrinsicsKt.f() ? result : Unit.a;
        }

        public static a1 b(t0 t0Var, long j, Runnable runnable, CoroutineContext coroutineContext) {
            return q0.a().invokeOnTimeout(j, runnable, coroutineContext);
        }
    }

    a1 invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext);

    void scheduleResumeAfterDelay(long j, n nVar);
}
