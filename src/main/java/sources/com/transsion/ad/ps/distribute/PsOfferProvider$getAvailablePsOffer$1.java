package com.transsion.ad.ps.distribute;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsOfferProvider", f = "PsOfferProvider.kt", l = {65, 80, 92, 121}, m = "getAvailablePsOffer")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PsOfferProvider$getAvailablePsOffer$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PsOfferProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PsOfferProvider$getAvailablePsOffer$1(PsOfferProvider psOfferProvider, Continuation<? super PsOfferProvider$getAvailablePsOffer$1> continuation) {
        super(continuation);
        this.this$0 = psOfferProvider;
    }

    public final Object invokeSuspend(Object obj) {
        Object c;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c = this.this$0.c(null, this);
        return c;
    }
}
