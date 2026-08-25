package com.transsion.rewardscenter.task.ad;

import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1", f = "MemberTaskAdHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ MemberTaskAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1(MemberTaskAdHelper memberTaskAdHelper, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = memberTaskAdHelper;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1(this.this$0, this.$maxEcpmObject, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        AppCompatActivity appCompatActivity;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        biddingVideoManager = this.this$0.m;
        if (biddingVideoManager != null) {
            appCompatActivity = this.this$0.g;
            Intrinsics.f(appCompatActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            AbsAdBidding.O0(biddingVideoManager, appCompatActivity, this.$maxEcpmObject, false, 4, (Object) null);
        }
        return Unit.a;
    }
}
