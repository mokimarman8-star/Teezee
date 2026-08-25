package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class x extends JobSupport implements w {
    public x(t1 t1Var) {
        super(true);
        initParentJob(t1Var);
    }

    @Override // kotlinx.coroutines.w
    public boolean b(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new b0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.r0
    public Object d() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.r0
    public Object f(Continuation continuation) {
        Object awaitInternal = awaitInternal(continuation);
        IntrinsicsKt.f();
        return awaitInternal;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlinx.coroutines.w
    public boolean l(Object obj) {
        return makeCompleting$kotlinx_coroutines_core(obj);
    }
}
