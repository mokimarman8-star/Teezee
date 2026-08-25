package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowKt__LimitKt$dropWhile$1$1 implements b {
    final /* synthetic */ Ref.BooleanRef a;
    final /* synthetic */ b b;
    final /* synthetic */ Function2 c;

    FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, b bVar, Function2 function2) {
        this.a = booleanRef;
        this.b = bVar;
        this.c = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // kotlinx.coroutines.flow.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        ?? r0;
        int i;
        FlowKt__LimitKt$dropWhile$1$1 flowKt__LimitKt$dropWhile$1$1;
        if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
            FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
            int i2 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$dropWhile$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                r0 = flowKt__LimitKt$dropWhile$1$1$emit$1;
                Object obj2 = r0.result;
                Object f = IntrinsicsKt.f();
                i = r0.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    if (this.a.element) {
                        b bVar = this.b;
                        r0.label = 1;
                        if (bVar.emit(obj, r0) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    Function2 function2 = this.c;
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.label = 2;
                    obj2 = function2.invoke(obj, r0);
                    if (obj2 == f) {
                        return f;
                    }
                    flowKt__LimitKt$dropWhile$1$1 = this;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                } else {
                    if (i == 1) {
                        ResultKt.b(obj2);
                        return Unit.a;
                    }
                    if (i == 2) {
                        obj = r0.L$1;
                        flowKt__LimitKt$dropWhile$1$1 = (FlowKt__LimitKt$dropWhile$1$1) r0.L$0;
                        ResultKt.b(obj2);
                        if (!((Boolean) obj2).booleanValue()) {
                            return Unit.a;
                        }
                        flowKt__LimitKt$dropWhile$1$1.a.element = true;
                        b bVar2 = flowKt__LimitKt$dropWhile$1$1.b;
                        r0.L$0 = null;
                        r0.L$1 = null;
                        r0.label = 3;
                        if (bVar2.emit(obj, r0) == f) {
                            return f;
                        }
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj2);
                    }
                }
                return Unit.a;
            }
        }
        r0 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
        Object obj22 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
        if (i != 0) {
        }
        return Unit.a;
    }
}
