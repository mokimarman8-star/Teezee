package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class s0 extends a implements r0 {
    public s0(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    static /* synthetic */ Object U(s0 s0Var, Continuation continuation) {
        Object awaitInternal = s0Var.awaitInternal(continuation);
        IntrinsicsKt.f();
        return awaitInternal;
    }

    @Override // kotlinx.coroutines.r0
    public Object d() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.r0
    public Object f(Continuation continuation) {
        return U(this, continuation);
    }
}
