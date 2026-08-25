package com.transsion.shorttv.ad.common;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.ad.AdLoadState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonVideoAdHelper$loadAd$1", f = "STCommonVideoAdHelper.kt", l = {114}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class STCommonVideoAdHelper$loadAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, String, String, Unit> $loadCallback;
    int label;
    final /* synthetic */ STCommonVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    STCommonVideoAdHelper$loadAd$1(STCommonVideoAdHelper sTCommonVideoAdHelper, Function3<? super Boolean, ? super String, ? super String, Unit> function3, Continuation<? super STCommonVideoAdHelper$loadAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonVideoAdHelper;
        this.$loadCallback = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonVideoAdHelper$loadAd$1(this.this$0, this.$loadCallback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingVideoManager biddingVideoManager3;
        Unit unit;
        STCommonVideoAdHelper$videoListener$1 sTCommonVideoAdHelper$videoListener$1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (i == 0) {
            ResultKt.b(obj);
            STCommonVideoAdHelper sTCommonVideoAdHelper = this.this$0;
            Function3<Boolean, String, String, Unit> function3 = this.$loadCallback;
            Result.Companion companion2 = Result.Companion;
            sTCommonVideoAdHelper.p(3);
            yq.a.a.b(sTCommonVideoAdHelper.r(), "trigger load ad", sTCommonVideoAdHelper.s());
            sTCommonVideoAdHelper.i = AdLoadState.LOADING;
            sTCommonVideoAdHelper.j = false;
            sTCommonVideoAdHelper.e = function3;
            sTCommonVideoAdHelper.c = new BiddingVideoManager();
            biddingVideoManager = sTCommonVideoAdHelper.c;
            if (biddingVideoManager != null) {
                biddingVideoManager.L0(sTCommonVideoAdHelper.s());
            }
            biddingVideoManager2 = sTCommonVideoAdHelper.c;
            if (biddingVideoManager2 != null) {
                sTCommonVideoAdHelper$videoListener$1 = sTCommonVideoAdHelper.k;
                biddingVideoManager2.K0(sTCommonVideoAdHelper$videoListener$1);
            }
            biddingVideoManager3 = sTCommonVideoAdHelper.c;
            if (biddingVideoManager3 == null) {
                unit = null;
                obj2 = Result.constructor-impl(unit);
                STCommonVideoAdHelper sTCommonVideoAdHelper2 = this.this$0;
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    sTCommonVideoAdHelper2.i = AdLoadState.IDLE;
                }
                return Unit.a;
            }
            this.label = 1;
            if (AbsAdBidding.t0(biddingVideoManager3, 0, false, this, 3, (Object) null) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        unit = Unit.a;
        obj2 = Result.constructor-impl(unit);
        STCommonVideoAdHelper sTCommonVideoAdHelper22 = this.this$0;
        if (Result.exceptionOrNull-impl(obj2) != null) {
        }
        return Unit.a;
    }
}
