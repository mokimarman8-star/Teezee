package com.transsion.ad.ps.attribution;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.ps.attribution.AttributionConsumeManager", f = "AttributionConsumeManager.kt", l = {75, 86, 93}, m = "safeCall")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AttributionConsumeManager$safeCall$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttributionConsumeManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AttributionConsumeManager$safeCall$1(AttributionConsumeManager attributionConsumeManager, Continuation<? super AttributionConsumeManager$safeCall$1> continuation) {
        super(continuation);
        this.this$0 = attributionConsumeManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q = this.this$0.q(this);
        return q;
    }
}
