package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements n0 {
    private final CoroutineContext a;

    public d(CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }

    @Override // kotlinx.coroutines.n0
    public CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
