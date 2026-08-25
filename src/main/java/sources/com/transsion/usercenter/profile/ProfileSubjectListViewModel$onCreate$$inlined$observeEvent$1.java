package com.transsion.usercenter.profile;

import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V", "com/transsnet/flow/event/ObserveEventKt$observeEvent$1"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.flow.event.ObserveEventKt$observeEvent$1", f = "ObserveEvent.kt", l = {Sdk$SDKError.Reason.INVALID_REQUEST_BUILDER_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1 $onReceived;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1(boolean z, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$isSticky = z;
        this.$onReceived = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1(this.$isSticky, this.$onReceived, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            boolean z = this.$isSticky;
            Function1 function1 = this.$onReceived;
            this.label = 1;
            if (applicationScopeViewModel.observeWithoutLifecycle(name, z, function1, this) == f) {
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
