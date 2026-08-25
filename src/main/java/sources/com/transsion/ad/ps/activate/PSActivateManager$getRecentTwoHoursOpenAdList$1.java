package com.transsion.ad.ps.activate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.ps.activate.PSActivateManager", f = "PSActivateManager.kt", l = {68}, m = "getRecentTwoHoursOpenAdList")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PSActivateManager$getRecentTwoHoursOpenAdList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PSActivateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PSActivateManager$getRecentTwoHoursOpenAdList$1(PSActivateManager pSActivateManager, Continuation<? super PSActivateManager$getRecentTwoHoursOpenAdList$1> continuation) {
        super(continuation);
        this.this$0 = pSActivateManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
