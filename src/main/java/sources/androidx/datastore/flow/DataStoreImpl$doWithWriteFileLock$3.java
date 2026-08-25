package androidx.datastore.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {416}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class DataStoreImpl$doWithWriteFileLock$3 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$doWithWriteFileLock$3(Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<? super DataStoreImpl$doWithWriteFileLock$3> continuation) {
        super(1, continuation);
        this.$block = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DataStoreImpl$doWithWriteFileLock$3(this.$block, continuation);
    }

    public final Object invoke(Continuation<Object> continuation) {
        return create(continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            Function1<Continuation<Object>, Object> function1 = this.$block;
            this.label = 1;
            obj = function1.invoke(this);
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
