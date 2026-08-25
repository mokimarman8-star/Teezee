package androidx.datastore.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1", f = "DataStoreImpl.kt", l = {331}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class DataStoreImpl$transformAndWrite$2$newData$1 extends SuspendLambda implements Function2<n0, Continuation<Object>, Object> {
    final /* synthetic */ e $curData;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2$newData$1(Function2<Object, ? super Continuation<Object>, ? extends Object> function2, e eVar, Continuation<? super DataStoreImpl$transformAndWrite$2$newData$1> continuation) {
        super(2, continuation);
        this.$transform = function2;
        this.$curData = eVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, this.$curData, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            Function2<Object, Continuation<Object>, Object> function2 = this.$transform;
            Object c5 = this.$curData.c();
            this.label = 1;
            obj = function2.invoke(c5, this);
            if (obj == f5) {
                return f5;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
