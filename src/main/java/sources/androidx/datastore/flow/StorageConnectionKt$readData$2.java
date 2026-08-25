package androidx.datastore.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"T", "Landroidx/datastore/core/s;", "", "it", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class StorageConnectionKt$readData$2 extends SuspendLambda implements Function3<s, Boolean, Continuation<Object>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    StorageConnectionKt$readData$2(Continuation<? super StorageConnectionKt$readData$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(s sVar, boolean z5, Continuation<Object> continuation) {
        StorageConnectionKt$readData$2 storageConnectionKt$readData$2 = new StorageConnectionKt$readData$2(continuation);
        storageConnectionKt$readData$2.L$0 = sVar;
        return storageConnectionKt$readData$2.invokeSuspend(Unit.a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((s) obj, ((Boolean) obj2).booleanValue(), (Continuation<Object>) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            s sVar = (s) this.L$0;
            this.label = 1;
            obj = sVar.c(this);
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
