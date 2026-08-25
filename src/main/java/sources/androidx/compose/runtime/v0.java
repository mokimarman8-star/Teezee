package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v0 {
    public static final u0 a(CoroutineContext coroutineContext) {
        u0 u0Var = (u0) coroutineContext.get(u0.Z0);
        if (u0Var != null) {
            return u0Var;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
    }

    public static final Object b(Function1 function1, Continuation continuation) {
        return a(continuation.getContext()).j(function1, continuation);
    }
}
