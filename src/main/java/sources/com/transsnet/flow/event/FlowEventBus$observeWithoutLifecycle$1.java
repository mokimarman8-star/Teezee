package com.transsnet.flow.event;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.flow.event.FlowEventBus", f = "FlowEventBus.kt", l = {WebSocketProtocol.B0_FLAG_RSV1}, m = "observeWithoutLifecycle")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowEventBus$observeWithoutLifecycle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowEventBus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowEventBus$observeWithoutLifecycle$1(FlowEventBus flowEventBus, Continuation<? super FlowEventBus$observeWithoutLifecycle$1> continuation) {
        super(continuation);
        this.this$0 = flowEventBus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeWithoutLifecycle((String) null, false, (Function1) null, this);
    }
}
