package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(b bVar) {
        if (bVar instanceof k1) {
            throw ((k1) bVar).a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object c(b bVar, Function3 function3, Throwable th, Continuation continuation) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        int i;
        try {
            if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
                flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
                int i2 = flowKt__EmittersKt$invokeSafely$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__EmittersKt$invokeSafely$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = flowKt__EmittersKt$invokeSafely$1.result;
                    Object f = IntrinsicsKt.f();
                    i = flowKt__EmittersKt$invokeSafely$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        flowKt__EmittersKt$invokeSafely$1.L$0 = th;
                        flowKt__EmittersKt$invokeSafely$1.label = 1;
                        if (function3.invoke(bVar, th, flowKt__EmittersKt$invokeSafely$1) == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$0;
                        ResultKt.b(obj);
                    }
                    return Unit.a;
                }
            }
            if (i != 0) {
            }
            return Unit.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ExceptionsKt.a(th2, th);
            }
            throw th2;
        }
        flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
        Object obj2 = flowKt__EmittersKt$invokeSafely$1.result;
        Object f2 = IntrinsicsKt.f();
        i = flowKt__EmittersKt$invokeSafely$1.label;
    }

    public static final a d(a aVar, Function3 function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(aVar, function3);
    }

    public static final a e(a aVar, Function2 function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(function2, aVar);
    }
}
