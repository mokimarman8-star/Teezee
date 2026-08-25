package com.transsion.ad.monopoly.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager", f = "NonAdShowedTimesManager.kt", l = {40}, m = "getShowedTimes")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NonAdShowedTimesManager$getShowedTimes$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NonAdShowedTimesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NonAdShowedTimesManager$getShowedTimes$1(NonAdShowedTimesManager nonAdShowedTimesManager, Continuation<? super NonAdShowedTimesManager$getShowedTimes$1> continuation) {
        super(continuation);
        this.this$0 = nonAdShowedTimesManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
