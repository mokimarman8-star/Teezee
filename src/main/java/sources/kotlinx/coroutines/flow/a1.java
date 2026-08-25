package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a1 extends AbstractFlow {
    private final Function2 a;

    public a1(Function2 function2) {
        this.a = function2;
    }

    public Object g(b bVar, Continuation continuation) {
        Object invoke = this.a.invoke(bVar, continuation);
        return invoke == IntrinsicsKt.f() ? invoke : Unit.a;
    }
}
