package com.transsion.ad.bidding.nativead;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider", f = "BiddingHiSspNativeProvider.kt", l = {246}, m = "preLoadAd")
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class BiddingHiSspNativeProvider$preLoadAd$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BiddingHiSspNativeProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BiddingHiSspNativeProvider$preLoadAd$1(BiddingHiSspNativeProvider biddingHiSspNativeProvider, Continuation<? super BiddingHiSspNativeProvider$preLoadAd$1> continuation) {
        super(continuation);
        this.this$0 = biddingHiSspNativeProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(null, 0, null, this);
    }
}
