package androidx.datastore.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¨\u0006\u0002"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "androidx/datastore/core/MultiProcessCoordinator$withLazyCounter$2", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1", f = "MultiProcessCoordinator.android.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1 extends SuspendLambda implements Function2<n0, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ q this$0;

    public MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(q qVar, Continuation continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(null, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Integer> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        q.f(null);
        throw null;
    }
}
