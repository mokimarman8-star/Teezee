package com.transsion.ad.strategy;

import android.app.Activity;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
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
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.strategy.HotSplashManager$onBiddingLoad$1$1$1", f = "HotSplashManager.kt", l = {111}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HotSplashManager$onBiddingLoad$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    final /* synthetic */ Activity $topAct;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.strategy.HotSplashManager$onBiddingLoad$1$1$1$1", f = "HotSplashManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.strategy.HotSplashManager$onBiddingLoad$1$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
        final /* synthetic */ Activity $topAct;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$topAct = activity;
            this.$maxEcpmObject = biddingIntermediateMaterialBean;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$topAct, this.$maxEcpmObject, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            BiddingInterstitialManager biddingInterstitialManager;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            boolean k = com.transsion.ad.scene.a.a.k(rh.d.a.a());
            biddingInterstitialManager = HotSplashManager.g;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.N0(this.$topAct, this.$maxEcpmObject, k);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HotSplashManager$onBiddingLoad$1$1$1(Activity activity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super HotSplashManager$onBiddingLoad$1$1$1> continuation) {
        super(2, continuation);
        this.$topAct = activity;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotSplashManager$onBiddingLoad$1$1$1(this.$topAct, this.$maxEcpmObject, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            a2 c = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$topAct, this.$maxEcpmObject, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
                return f;
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
