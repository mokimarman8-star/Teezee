package com.transsion.search.ad;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.ad.SearchHotAdHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.ad.SearchHotAdHelper$loadBiddingAd$1", f = "SearchHotAdHelper.kt", l = {138}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchHotAdHelper$loadBiddingAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SearchHotAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchHotAdHelper$loadBiddingAd$1(SearchHotAdHelper searchHotAdHelper, Continuation<? super SearchHotAdHelper$loadBiddingAd$1> continuation) {
        super(2, continuation);
        this.this$0 = searchHotAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchHotAdHelper$loadBiddingAd$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        SearchHotAdHelper.b bVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.this$0.e = new BiddingNativeManager();
            biddingNativeManager = this.this$0.e;
            if (biddingNativeManager != null) {
                SearchHotAdHelper searchHotAdHelper = this.this$0;
                biddingNativeManager.L0("SearchHotNativeScene");
                bVar = searchHotAdHelper.m;
                biddingNativeManager.K0(bVar);
                this.L$0 = biddingNativeManager;
                this.label = 1;
                if (AbsAdBidding.t0(biddingNativeManager, 0, false, this, 3, (Object) null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
