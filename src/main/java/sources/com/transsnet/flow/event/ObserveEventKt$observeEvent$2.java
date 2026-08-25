package com.transsnet.flow.event;

import androidx.lifecycle.v0;
import androidx.lifecycle.y0;
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
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.flow.event.ObserveEventKt$observeEvent$2", f = "ObserveEvent.kt", l = {Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ObserveEventKt$observeEvent$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1<Object, Unit> $onReceived;
    final /* synthetic */ y0 $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObserveEventKt$observeEvent$2(y0 y0Var, boolean z, Function1<Object, Unit> function1, Continuation<? super ObserveEventKt$observeEvent$2> continuation) {
        super(2, continuation);
        this.$scope = y0Var;
        this.$isSticky = z;
        this.$onReceived = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveEventKt$observeEvent$2(this.$scope, this.$isSticky, this.$onReceived, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ObserveEventKt$observeEvent$2) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            FlowEventBus a = new v0(this.$scope).a(FlowEventBus.class);
            Intrinsics.n(4, "T");
            String name = Object.class.getName();
            Intrinsics.g(name, "getName(...)");
            boolean z = this.$isSticky;
            Function1<Object, Unit> function1 = this.$onReceived;
            this.label = 1;
            if (a.observeWithoutLifecycle(name, z, function1, this) == f) {
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
