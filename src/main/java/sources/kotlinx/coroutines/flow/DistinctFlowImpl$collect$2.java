package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DistinctFlowImpl$collect$2 implements b {
    final /* synthetic */ DistinctFlowImpl a;
    final /* synthetic */ Ref.ObjectRef b;
    final /* synthetic */ b c;

    DistinctFlowImpl$collect$2(DistinctFlowImpl distinctFlowImpl, Ref.ObjectRef objectRef, b bVar) {
        this.a = distinctFlowImpl;
        this.b = objectRef;
        this.c = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // kotlinx.coroutines.flow.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ?? r0;
        int i;
        if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
            DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
            int i2 = distinctFlowImpl$collect$2$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                distinctFlowImpl$collect$2$emit$1.label = i2 - Integer.MIN_VALUE;
                r0 = distinctFlowImpl$collect$2$emit$1;
                Object obj2 = r0.result;
                Object f = IntrinsicsKt.f();
                i = r0.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    Object invoke = this.a.b.invoke(obj);
                    Object obj3 = this.b.element;
                    if (obj3 != kotlinx.coroutines.flow.internal.m.a && ((Boolean) this.a.c.invoke(obj3, invoke)).booleanValue()) {
                        return Unit.a;
                    }
                    this.b.element = invoke;
                    b bVar = this.c;
                    r0.label = 1;
                    if (bVar.emit(obj, r0) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj2);
                }
                return Unit.a;
            }
        }
        r0 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
        Object obj22 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
        if (i != 0) {
        }
        return Unit.a;
    }
}
