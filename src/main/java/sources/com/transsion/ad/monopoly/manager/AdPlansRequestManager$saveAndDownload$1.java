package com.transsion.ad.monopoly.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansRequestManager", f = "AdPlansRequestManager.kt", l = {184, 222, 232, 237}, m = "saveAndDownload")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdPlansRequestManager$saveAndDownload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdPlansRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdPlansRequestManager$saveAndDownload$1(AdPlansRequestManager adPlansRequestManager, Continuation<? super AdPlansRequestManager$saveAndDownload$1> continuation) {
        super(continuation);
        this.this$0 = adPlansRequestManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object v;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v = this.this$0.v(null, this);
        return v;
    }
}
