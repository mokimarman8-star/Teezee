package com.transsion.shorttv.ad.common;

import android.app.Activity;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonVideoAdHelper$showAd$1", f = "STCommonVideoAdHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class STCommonVideoAdHelper$showAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1<Boolean, Unit> $closeCallback;
    final /* synthetic */ Function0<Unit> $rewardedCallback;
    int label;
    final /* synthetic */ STCommonVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    STCommonVideoAdHelper$showAd$1(STCommonVideoAdHelper sTCommonVideoAdHelper, Function0<Unit> function0, Function1<? super Boolean, Unit> function1, Activity activity, Continuation<? super STCommonVideoAdHelper$showAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonVideoAdHelper;
        this.$rewardedCallback = function0;
        this.$closeCallback = function1;
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonVideoAdHelper$showAd$1(this.this$0, this.$rewardedCallback, this.$closeCallback, this.$activity, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.this$0;
        Function0<Unit> function0 = this.$rewardedCallback;
        Function1<Boolean, Unit> function1 = this.$closeCallback;
        Activity activity = this.$activity;
        try {
            Result.Companion companion = Result.Companion;
            yq.a aVar = yq.a.a;
            String r = sTCommonVideoAdHelper.r();
            biddingVideoManager = sTCommonVideoAdHelper.c;
            Unit unit = null;
            aVar.b(r, "trigger show ad", biddingVideoManager != null ? biddingVideoManager.getSceneId() : null);
            sTCommonVideoAdHelper.f = function0;
            sTCommonVideoAdHelper.g = function1;
            biddingVideoManager2 = sTCommonVideoAdHelper.c;
            if (biddingVideoManager2 != null) {
                biddingIntermediateMaterialBean = sTCommonVideoAdHelper.d;
                biddingVideoManager2.N0(activity, biddingIntermediateMaterialBean, false);
                unit = Unit.a;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }
}
