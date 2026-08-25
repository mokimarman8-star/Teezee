package com.transsion.ad.strategy;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.gslb.BuildConfig;
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
@DebugMetadata(c = "com.transsion.ad.strategy.HotSplashManager$loadHotSplashAd$1", f = "HotSplashManager.kt", l = {176}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HotSplashManager$loadHotSplashAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    HotSplashManager$loadHotSplashAd$1(Continuation<? super HotSplashManager$loadHotSplashAd$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotSplashManager$loadHotSplashAd$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String classTag;
        BiddingInterstitialManager biddingInterstitialManager;
        BiddingInterstitialManager biddingInterstitialManager2;
        BiddingInterstitialManager biddingInterstitialManager3;
        AbsAdBidding L0;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            xh.a aVar = xh.a.a;
            HotSplashManager hotSplashManager = HotSplashManager.d;
            classTag = hotSplashManager.getClassTag();
            xh.a.m(aVar, "ad_int", classTag + " --> loadHotSplashAd() --> App 进入前台符合条件 --> 准备展示开屏广告", 0, false, 4, null);
            biddingInterstitialManager = HotSplashManager.g;
            if (biddingInterstitialManager == null) {
                HotSplashManager.g = new BiddingInterstitialManager();
                biddingInterstitialManager3 = HotSplashManager.g;
                if (biddingInterstitialManager3 != null && (L0 = biddingInterstitialManager3.L0(rh.d.a.a())) != null) {
                    L0.K0(hotSplashManager);
                }
            }
            biddingInterstitialManager2 = HotSplashManager.g;
            if (biddingInterstitialManager2 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingInterstitialManager2, 0, false, this, 3, (Object) null) == f) {
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
