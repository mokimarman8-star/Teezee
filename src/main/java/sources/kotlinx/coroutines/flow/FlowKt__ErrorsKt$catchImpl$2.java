package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowKt__ErrorsKt$catchImpl$2 implements b {
    final /* synthetic */ b a;
    final /* synthetic */ Ref.ObjectRef b;

    FlowKt__ErrorsKt$catchImpl$2(b bVar, Ref.ObjectRef objectRef) {
        this.a = bVar;
        this.b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // kotlinx.coroutines.flow.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ?? r0;
        int i;
        FlowKt__ErrorsKt$catchImpl$2 flowKt__ErrorsKt$catchImpl$2;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) {
            FlowKt__ErrorsKt$catchImpl$2$emit$1 flowKt__ErrorsKt$catchImpl$2$emit$1 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) continuation;
            int i2 = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$2$emit$1.label = i2 - Integer.MIN_VALUE;
                r0 = flowKt__ErrorsKt$catchImpl$2$emit$1;
                Object obj2 = r0.result;
                Object f = IntrinsicsKt.f();
                i = r0.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    try {
                        b bVar = this.a;
                        r0.L$0 = this;
                        r0.label = 1;
                        if (bVar.emit(obj, r0) == f) {
                            return f;
                        }
                    } catch (Throwable th) {
                        th = th;
                        flowKt__ErrorsKt$catchImpl$2 = this;
                        flowKt__ErrorsKt$catchImpl$2.b.element = th;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowKt__ErrorsKt$catchImpl$2 = (FlowKt__ErrorsKt$catchImpl$2) r0.L$0;
                    try {
                        ResultKt.b(obj2);
                    } catch (Throwable th2) {
                        th = th2;
                        flowKt__ErrorsKt$catchImpl$2.b.element = th;
                        throw th;
                    }
                }
                return Unit.a;
            }
        }
        r0 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, continuation);
        Object obj22 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
        if (i != 0) {
        }
        return Unit.a;
    }
}
