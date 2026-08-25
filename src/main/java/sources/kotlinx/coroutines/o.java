package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class o implements Function3 {
    public final /* synthetic */ Function1 a;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return CancellableContinuationImpl.a(this.a, (Throwable) obj, obj2, (CoroutineContext) obj3);
    }
}
