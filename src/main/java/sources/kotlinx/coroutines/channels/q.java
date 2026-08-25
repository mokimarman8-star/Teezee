package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.s2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class q implements s2 {
    public final CancellableContinuationImpl a;

    public q(CancellableContinuationImpl cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.s2
    public void invokeOnCancellation(w wVar, int i) {
        this.a.invokeOnCancellation(wVar, i);
    }
}
