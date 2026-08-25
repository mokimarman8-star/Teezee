package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class k implements Continuation {
    public static final k a = new k();
    private static final CoroutineContext b = EmptyCoroutineContext.INSTANCE;

    private k() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
