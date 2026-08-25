package com.transsion.shorttv.ad.common;

import android.content.Context;
import com.cloud.sdk.commonutil.util.e;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.ad.AdLoadState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonNativeAdHelper$loadAd$1", f = "STCommonNativeAdHelper.kt", l = {134}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class STCommonNativeAdHelper$loadAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    int label;
    final /* synthetic */ STCommonNativeAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    STCommonNativeAdHelper$loadAd$1(STCommonNativeAdHelper sTCommonNativeAdHelper, Function1<? super Boolean, Unit> function1, Continuation<? super STCommonNativeAdHelper$loadAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonNativeAdHelper;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonNativeAdHelper$loadAd$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        Unit unit;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        BiddingNativeManager biddingNativeManager5;
        STCommonNativeAdHelper$nativeAdListener$1 sTCommonNativeAdHelper$nativeAdListener$1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (i == 0) {
            ResultKt.b(obj);
            STCommonNativeAdHelper sTCommonNativeAdHelper = this.this$0;
            Function1<Boolean, Unit> function1 = this.$callback;
            Result.Companion companion2 = Result.Companion;
            sTCommonNativeAdHelper.m(3);
            yq.a.a.b(sTCommonNativeAdHelper.o(), "trigger load ad", sTCommonNativeAdHelper.p());
            sTCommonNativeAdHelper.i = AdLoadState.LOADING;
            sTCommonNativeAdHelper.e = function1;
            sTCommonNativeAdHelper.c = new BiddingNativeManager();
            biddingNativeManager = sTCommonNativeAdHelper.c;
            if (biddingNativeManager != null) {
                biddingNativeManager.L0(sTCommonNativeAdHelper.p());
            }
            biddingNativeManager2 = sTCommonNativeAdHelper.c;
            unit = null;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.J0((Map) null);
            }
            biddingNativeManager3 = sTCommonNativeAdHelper.c;
            if (biddingNativeManager3 != null) {
                Context a = e.a();
                Intrinsics.g(a, "getContext(...)");
                biddingNativeManager3.I0(a);
            }
            biddingNativeManager4 = sTCommonNativeAdHelper.c;
            if (biddingNativeManager4 != null) {
                sTCommonNativeAdHelper$nativeAdListener$1 = sTCommonNativeAdHelper.j;
                biddingNativeManager4.K0(sTCommonNativeAdHelper$nativeAdListener$1);
            }
            biddingNativeManager5 = sTCommonNativeAdHelper.c;
            if (biddingNativeManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingNativeManager5, 0, false, this, 3, (Object) null) == f) {
                    return f;
                }
            }
            obj2 = Result.constructor-impl(unit);
            STCommonNativeAdHelper sTCommonNativeAdHelper2 = this.this$0;
            if (Result.exceptionOrNull-impl(obj2) != null) {
                sTCommonNativeAdHelper2.i = AdLoadState.IDLE;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        unit = Unit.a;
        obj2 = Result.constructor-impl(unit);
        STCommonNativeAdHelper sTCommonNativeAdHelper22 = this.this$0;
        if (Result.exceptionOrNull-impl(obj2) != null) {
        }
        return Unit.a;
    }
}
