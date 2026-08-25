package com.transsion.ad.ps.distribute;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsDistributeRequestManager", f = "PsDistributeRequestManager.kt", l = {182, 186, 192}, m = "analyzeData")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PsDistributeRequestManager$analyzeData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PsDistributeRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PsDistributeRequestManager$analyzeData$1(PsDistributeRequestManager psDistributeRequestManager, Continuation<? super PsDistributeRequestManager$analyzeData$1> continuation) {
        super(continuation);
        this.this$0 = psDistributeRequestManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object h;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h = this.this$0.h(null, null, null, this);
        return h;
    }
}
