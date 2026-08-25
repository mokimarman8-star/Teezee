package com.tn.tranpay.event;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus", f = "FlowEventBus.kt", l = {64}, m = "observeWithoutLifecycle")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class FlowEventBus$observeWithoutLifecycle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowEventBus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowEventBus$observeWithoutLifecycle$1(FlowEventBus flowEventBus, Continuation<? super FlowEventBus$observeWithoutLifecycle$1> continuation) {
        super(continuation);
        this.this$0 = flowEventBus;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeWithoutLifecycle(null, false, null, this);
    }
}
