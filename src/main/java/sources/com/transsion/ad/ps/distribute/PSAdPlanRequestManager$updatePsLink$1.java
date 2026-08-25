package com.transsion.ad.ps.distribute;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PSAdPlanRequestManager", f = "PSAdPlanRequestManager.kt", l = {38, 58, 66, 79, 91}, m = "updatePsLink")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PSAdPlanRequestManager$updatePsLink$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PSAdPlanRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PSAdPlanRequestManager$updatePsLink$1(PSAdPlanRequestManager pSAdPlanRequestManager, Continuation<? super PSAdPlanRequestManager$updatePsLink$1> continuation) {
        super(continuation);
        this.this$0 = pSAdPlanRequestManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
