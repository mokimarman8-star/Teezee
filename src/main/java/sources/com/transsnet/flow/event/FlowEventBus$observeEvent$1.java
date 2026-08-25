package com.transsnet.flow.event;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/Void;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.flow.event.FlowEventBus$observeEvent$1", f = "FlowEventBus.kt", l = {51}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class FlowEventBus$observeEvent$1 extends SuspendLambda implements Function2<n0, Continuation<?>, Object> {
    final /* synthetic */ i0 $dispatcher;
    final /* synthetic */ String $eventName;
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1<T, Unit> $onReceived;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowEventBus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowEventBus$observeEvent$1(FlowEventBus flowEventBus, String str, boolean z, i0 i0Var, Function1<? super T, Unit> function1, Continuation<? super FlowEventBus$observeEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = flowEventBus;
        this.$eventName = str;
        this.$isSticky = z;
        this.$dispatcher = i0Var;
        this.$onReceived = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowEventBus$observeEvent$1 flowEventBus$observeEvent$1 = new FlowEventBus$observeEvent$1(this.this$0, this.$eventName, this.$isSticky, this.$dispatcher, this.$onReceived, continuation);
        flowEventBus$observeEvent$1.L$0 = obj;
        return flowEventBus$observeEvent$1;
    }

    public final Object invoke(n0 n0Var, Continuation<?> continuation) {
        return ((FlowEventBus$observeEvent$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        w0 eventFlow;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            eventFlow = this.this$0.getEventFlow(this.$eventName, this.$isSticky);
            1 r3 = new 1(n0Var, this.$dispatcher, this.this$0, this.$onReceived);
            this.label = 1;
            if (eventFlow.a(r3, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
