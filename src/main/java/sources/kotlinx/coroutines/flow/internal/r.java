package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r implements kotlinx.coroutines.flow.b {
    private final kotlinx.coroutines.channels.s a;

    public r(kotlinx.coroutines.channels.s sVar) {
        this.a = sVar;
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(Object obj, Continuation continuation) {
        Object n = this.a.n(obj, continuation);
        return n == IntrinsicsKt.f() ? n : Unit.a;
    }
}
