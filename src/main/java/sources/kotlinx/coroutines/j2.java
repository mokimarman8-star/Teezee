package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class j2 extends kotlinx.coroutines.internal.v {
    public j2(CoroutineContext coroutineContext, Continuation continuation) {
        super(coroutineContext, continuation);
    }

    public boolean childCancelled(Throwable th) {
        return false;
    }
}
