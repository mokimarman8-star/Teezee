package com.tn.tranpay.event;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.event.ObserveEventKt$observeEvent$1", f = "ObserveEvent.kt", l = {TaskResultKt.ERROR_LOAD_NOT_DOWNLOAD}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ObserveEventKt$observeEvent$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1<Object, Unit> $onReceived;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObserveEventKt$observeEvent$1(boolean z, Function1<Object, Unit> function1, Continuation<? super ObserveEventKt$observeEvent$1> continuation) {
        super(2, continuation);
        this.$isSticky = z;
        this.$onReceived = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveEventKt$observeEvent$1(this.$isSticky, this.$onReceived, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            Intrinsics.n(4, "T");
            String name = Object.class.getName();
            Intrinsics.g(name, "T::class.java.name");
            boolean z = this.$isSticky;
            Function1<Object, Unit> function1 = this.$onReceived;
            this.label = 1;
            if (flowEventBus.observeWithoutLifecycle(name, z, function1, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
