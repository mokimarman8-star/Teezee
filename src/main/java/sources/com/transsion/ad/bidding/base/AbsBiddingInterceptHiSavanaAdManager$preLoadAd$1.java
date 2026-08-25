package com.transsion.ad.bidding.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager", f = "AbsBiddingInterceptHiSavanaAdManager.kt", l = {204}, m = "preLoadAd")
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsBiddingInterceptHiSavanaAdManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1(AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, Continuation<? super AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1> continuation) {
        super(continuation);
        this.this$0 = absBiddingInterceptHiSavanaAdManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, null, this);
    }
}
