package com.tn.tranpay.event;

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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/Void;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1", f = "FlowEventBus.kt", l = {51}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
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

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowEventBus$observeEvent$1 flowEventBus$observeEvent$1 = new FlowEventBus$observeEvent$1(this.this$0, this.$eventName, this.$isSticky, this.$dispatcher, this.$onReceived, continuation);
        flowEventBus$observeEvent$1.L$0 = obj;
        return flowEventBus$observeEvent$1;
    }

    public final Object invoke(n0 n0Var, Continuation<?> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        w0 eventFlow;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            final n0 n0Var = (n0) this.L$0;
            eventFlow = this.this$0.getEventFlow(this.$eventName, this.$isSticky);
            final i0 i0Var = this.$dispatcher;
            final FlowEventBus flowEventBus = this.this$0;
            final Function1<T, Unit> function1 = this.$onReceived;
            kotlinx.coroutines.flow.b bVar = new kotlinx.coroutines.flow.b() { // from class: com.tn.tranpay.event.FlowEventBus$observeEvent$1.1

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
                @DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1", f = "FlowEventBus.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1, reason: invalid class name and collision with other inner class name */
                static final class C00391 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<Object, Unit> $onReceived;
                    final /* synthetic */ Object $value;
                    int label;
                    final /* synthetic */ FlowEventBus this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00391(FlowEventBus flowEventBus, Object obj, Function1<Object, Unit> function1, Continuation<? super C00391> continuation) {
                        super(2, continuation);
                        this.this$0 = flowEventBus;
                        this.$value = obj;
                        this.$onReceived = function1;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00391(this.this$0, this.$value, this.$onReceived, continuation);
                    }

                    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                        return create(n0Var, continuation).invokeSuspend(Unit.a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        this.this$0.invokeReceived(this.$value, this.$onReceived);
                        return Unit.a;
                    }
                }

                public final Object emit(Object obj2, Continuation continuation) {
                    i.d(n0Var, i0Var, (CoroutineStart) null, new C00391(flowEventBus, obj2, function1, null), 2, (Object) null);
                    return Unit.a;
                }
            };
            this.label = 1;
            if (eventFlow.a(bVar, this) == f) {
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
