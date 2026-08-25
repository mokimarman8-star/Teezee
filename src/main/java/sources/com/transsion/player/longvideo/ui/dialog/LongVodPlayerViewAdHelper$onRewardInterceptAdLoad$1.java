package com.transsion.player.longvideo.ui.dialog;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
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
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1", f = "LongVodPlayerViewAdHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1(this.this$0, this.$maxEcpmObject, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        str = this.this$0.i0;
        if (Intrinsics.c(str, "StreamVideoInterceptRewarded")) {
            this.this$0.P4(this.$maxEcpmObject);
        } else if (Intrinsics.c(str, "StreamVideoInterceptInterstitial")) {
            this.this$0.I4(this.$maxEcpmObject);
        }
        return Unit.a;
    }
}
