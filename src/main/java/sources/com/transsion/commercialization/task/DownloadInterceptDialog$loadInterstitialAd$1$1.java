package com.transsion.commercialization.task;

import android.content.Context;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.commercialization.task.DownloadInterceptDialog;
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
@DebugMetadata(c = "com.transsion.commercialization.task.DownloadInterceptDialog$loadInterstitialAd$1$1", f = "DownloadInterceptDialog.kt", l = {497}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class DownloadInterceptDialog$loadInterstitialAd$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $it;
    int label;
    final /* synthetic */ DownloadInterceptDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadInterceptDialog$loadInterstitialAd$1$1(DownloadInterceptDialog downloadInterceptDialog, Context context, Continuation<? super DownloadInterceptDialog$loadInterstitialAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadInterceptDialog;
        this.$it = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadInterceptDialog$loadInterstitialAd$1$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingInterstitialManager biddingInterstitialManager;
        BiddingInterstitialManager biddingInterstitialManager2;
        BiddingInterstitialManager biddingInterstitialManager3;
        BiddingInterstitialManager biddingInterstitialManager4;
        BiddingInterstitialManager biddingInterstitialManager5;
        DownloadInterceptDialog.d dVar;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            biddingInterstitialManager = this.this$0.interstitialAdManager;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.U();
            }
            this.this$0.interstitialAdManager = new BiddingInterstitialManager();
            biddingInterstitialManager2 = this.this$0.interstitialAdManager;
            if (biddingInterstitialManager2 != null) {
                str = this.this$0.interceptSceneId;
                biddingInterstitialManager2.L0(str);
            }
            biddingInterstitialManager3 = this.this$0.interstitialAdManager;
            if (biddingInterstitialManager3 != null) {
                biddingInterstitialManager3.I0(this.$it);
            }
            biddingInterstitialManager4 = this.this$0.interstitialAdManager;
            if (biddingInterstitialManager4 != null) {
                dVar = this.this$0.rewardInterceptListener;
                biddingInterstitialManager4.K0(dVar);
            }
            biddingInterstitialManager5 = this.this$0.interstitialAdManager;
            if (biddingInterstitialManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingInterstitialManager5, 0, false, this, 3, (Object) null) == f) {
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
