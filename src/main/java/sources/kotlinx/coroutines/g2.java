package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class g2 extends w1 {
    private final CancellableContinuationImpl e;

    public g2(CancellableContinuationImpl cancellableContinuationImpl) {
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        Object state$kotlinx_coroutines_core = t().getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b0) {
            CancellableContinuationImpl cancellableContinuationImpl = this.e;
            Result$Companion result$Companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.constructor-impl(ResultKt.a(((b0) state$kotlinx_coroutines_core).a)));
        } else {
            CancellableContinuationImpl cancellableContinuationImpl2 = this.e;
            Result$Companion result$Companion2 = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.constructor-impl(x1.h(state$kotlinx_coroutines_core)));
        }
    }
}
