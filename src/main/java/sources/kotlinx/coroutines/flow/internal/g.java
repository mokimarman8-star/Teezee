package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.v;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class g extends v {
    public g(CoroutineContext coroutineContext, Continuation continuation) {
        super(coroutineContext, continuation);
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
