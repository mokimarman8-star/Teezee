package com.tn.tranpay.event;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$postEvent$1$1", f = "FlowEventBus.kt", l = {77, 78}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class FlowEventBus$postEvent$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ w0 $flow;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ Object $value;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowEventBus$postEvent$1$1(long j, w0 w0Var, Object obj, Continuation<? super FlowEventBus$postEvent$1$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.$flow = w0Var;
        this.$value = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowEventBus$postEvent$1$1(this.$timeMillis, this.$flow, this.$value, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            long j = this.$timeMillis;
            this.label = 1;
            if (u0.a(j, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        w0 w0Var = this.$flow;
        Object obj2 = this.$value;
        this.label = 2;
        if (w0Var.emit(obj2, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
