package com.transsnet.flow.event;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowEventBus$a implements kotlinx.coroutines.flow.b {
    final /* synthetic */ FlowEventBus a;
    final /* synthetic */ Function1 b;

    FlowEventBus$a(FlowEventBus flowEventBus, Function1 function1) {
        this.a = flowEventBus;
        this.b = function1;
    }

    @Override // kotlinx.coroutines.flow.b
    public final Object emit(Object obj, Continuation continuation) {
        FlowEventBus.access$invokeReceived(this.a, obj, this.b);
        return Unit.a;
    }
}
