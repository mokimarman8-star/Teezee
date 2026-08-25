package com.transsion.subroom.activity;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.MainDialogAdManager$loadAd$1", f = "MainDialogAdManager.kt", l = {Sdk$SDKError.Reason.API_RESPONSE_DECODE_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class MainDialogAdManager$loadAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainDialogAdManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainDialogAdManager$loadAd$1(MainDialogAdManager mainDialogAdManager, Continuation<? super MainDialogAdManager$loadAd$1> continuation) {
        super(2, continuation);
        this.this$0 = mainDialogAdManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainDialogAdManager$loadAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MainDialogAdManager$loadAd$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        BiddingInterstitialManager biddingInterstitialManager;
        BiddingInterstitialManager biddingInterstitialManager2;
        BiddingInterstitialManager biddingInterstitialManager3;
        BiddingInterstitialManager biddingInterstitialManager4;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            biddingInterstitialManager = this.this$0.e;
            if (biddingInterstitialManager == null) {
                this.this$0.e = new BiddingInterstitialManager();
            }
            biddingInterstitialManager2 = this.this$0.e;
            if (biddingInterstitialManager2 != null) {
                biddingInterstitialManager2.L0("MainDialogInterstitialScene");
            }
            biddingInterstitialManager3 = this.this$0.e;
            if (biddingInterstitialManager3 != null) {
                biddingInterstitialManager3.K0(this.this$0);
            }
            biddingInterstitialManager4 = this.this$0.e;
            if (biddingInterstitialManager4 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingInterstitialManager4, 0, false, this, 3, (Object) null) == f) {
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
