package com.transsion.home.adapter.trending;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.trending.BannerADDataHelper;
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
@DebugMetadata(c = "com.transsion.home.adapter.trending.BannerADDataHelper$fetchData$1", f = "BannerADDataHelper.kt", l = {49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BannerADDataHelper$fetchData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    BannerADDataHelper$fetchData$1(Continuation<? super BannerADDataHelper$fetchData$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BannerADDataHelper$fetchData$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BannerADDataHelper.a aVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            BannerADDataHelper bannerADDataHelper = BannerADDataHelper.a;
            BannerADDataHelper.c = new BiddingNativeManager();
            biddingNativeManager = BannerADDataHelper.c;
            if (biddingNativeManager != null) {
                biddingNativeManager.L0("TrendingNativeBannerScene");
            }
            biddingNativeManager2 = BannerADDataHelper.c;
            if (biddingNativeManager2 != null) {
                aVar = BannerADDataHelper.h;
                biddingNativeManager2.K0(aVar);
            }
            biddingNativeManager3 = BannerADDataHelper.c;
            if (biddingNativeManager3 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingNativeManager3, 0, false, this, 3, (Object) null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BannerADDataHelper bannerADDataHelper2 = BannerADDataHelper.a;
        BannerADDataHelper.b = com.transsion.ad.scene.a.o(com.transsion.ad.scene.a.a, "TrendingNativeBannerScene", 0, 2, null);
        return Unit.a;
    }
}
