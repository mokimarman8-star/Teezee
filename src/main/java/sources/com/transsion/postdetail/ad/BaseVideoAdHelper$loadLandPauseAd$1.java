package com.transsion.postdetail.ad;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ad.BaseVideoAdHelper$loadLandPauseAd$1", f = "BaseVideoAdHelper.kt", l = {278}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseVideoAdHelper$loadLandPauseAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BaseVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseVideoAdHelper$loadLandPauseAd$1(Context context, BaseVideoAdHelper baseVideoAdHelper, String str, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super BaseVideoAdHelper$loadLandPauseAd$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.this$0 = baseVideoAdHelper;
        this.$sceneId = str;
        this.$callback = function0;
        this.$onFail = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseVideoAdHelper$loadLandPauseAd$1(this.$ctx, this.this$0, this.$sceneId, this.$callback, this.$onFail, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BaseVideoAdHelper$wrapperAdListener$1 m2;
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
                    this.this$0.y1(new BiddingInterstitialManager());
                    BiddingInterstitialManager v0 = this.this$0.v0();
                    if (v0 != null) {
                        v0.L0(this.$sceneId);
                    }
                    BiddingInterstitialManager v02 = this.this$0.v0();
                    if (v02 != null) {
                        v02.J0(com.transsion.ad.strategy.c.a.a(this.this$0.j0()));
                    }
                    BiddingInterstitialManager v03 = this.this$0.v0();
                    if (v03 != null) {
                        v03.I0(appCompatActivity2);
                    }
                    BiddingInterstitialManager v04 = this.this$0.v0();
                    if (v04 != null) {
                        m2 = this.this$0.m2(this.$sceneId, this.$callback, this.$onFail);
                        v04.K0(m2);
                    }
                    BiddingInterstitialManager v05 = this.this$0.v0();
                    if (v05 != null) {
                        this.label = 1;
                        if (AbsAdBidding.t0(v05, 0, false, this, 3, (Object) null) == f) {
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
