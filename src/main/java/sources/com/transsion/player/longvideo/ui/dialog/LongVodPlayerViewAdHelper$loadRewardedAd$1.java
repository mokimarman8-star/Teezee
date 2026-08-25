package com.transsion.player.longvideo.ui.dialog;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$loadRewardedAd$1", f = "LongVodPlayerViewAdHelper.kt", l = {932}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$loadRewardedAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$loadRewardedAd$1(Context context, LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$loadRewardedAd$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.this$0 = longVodPlayerViewAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$loadRewardedAd$1(this.$ctx, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingVideoManager biddingVideoManager3;
        BiddingVideoManager biddingVideoManager4;
        BiddingVideoManager biddingVideoManager5;
        LongVodPlayerViewAdHelper.a aVar;
        String j0;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            AppCompatActivity appCompatActivity = this.$ctx;
            AppCompatActivity appCompatActivity2 = null;
            AppCompatActivity appCompatActivity3 = appCompatActivity instanceof AppCompatActivity ? appCompatActivity : null;
            if (appCompatActivity3 != null) {
                if (!appCompatActivity3.isDestroyed() && !appCompatActivity3.isFinishing()) {
                    appCompatActivity2 = appCompatActivity3;
                }
                if (appCompatActivity2 != null) {
                    this.this$0.W = new BiddingVideoManager();
                    biddingVideoManager = this.this$0.W;
                    if (biddingVideoManager != null) {
                        str = this.this$0.i0;
                        biddingVideoManager.L0(str);
                    }
                    biddingVideoManager2 = this.this$0.W;
                    if (biddingVideoManager2 != null) {
                        com.transsion.ad.strategy.c cVar = com.transsion.ad.strategy.c.a;
                        j0 = this.this$0.j0();
                        biddingVideoManager2.J0(cVar.a(j0));
                    }
                    biddingVideoManager3 = this.this$0.W;
                    if (biddingVideoManager3 != null) {
                        biddingVideoManager3.I0(appCompatActivity2);
                    }
                    biddingVideoManager4 = this.this$0.W;
                    if (biddingVideoManager4 != null) {
                        aVar = this.this$0.t0;
                        biddingVideoManager4.K0(aVar);
                    }
                    biddingVideoManager5 = this.this$0.W;
                    if (biddingVideoManager5 != null) {
                        this.label = 1;
                        if (AbsAdBidding.t0(biddingVideoManager5, 0, false, this, 3, (Object) null) == f) {
                            return f;
                        }
                    }
                }
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Unit.a;
    }
}
