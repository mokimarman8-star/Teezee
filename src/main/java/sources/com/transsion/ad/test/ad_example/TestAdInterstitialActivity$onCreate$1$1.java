package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.test.ad_example.TestAdInterstitialActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.util.Map;
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
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdInterstitialActivity$onCreate$1$1", f = "TestAdInterstitialActivity.kt", l = {68}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdInterstitialActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdInterstitialActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdInterstitialActivity$onCreate$1$1(TestAdInterstitialActivity testAdInterstitialActivity, Continuation<? super TestAdInterstitialActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdInterstitialActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdInterstitialActivity$onCreate$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        TestAdInterstitialActivity.a aVar;
        AbsAdBidding absAdBidding;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            AbsAdBidding absAdBidding2 = this.this$0.interstitialManager;
            if (absAdBidding2 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding2 = null;
            }
            absAdBidding2.L0("MBInterstitialTestId");
            AbsAdBidding absAdBidding3 = this.this$0.interstitialManager;
            if (absAdBidding3 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding3 = null;
            }
            absAdBidding3.J0((Map) null);
            AbsAdBidding absAdBidding4 = this.this$0.interstitialManager;
            if (absAdBidding4 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding4 = null;
            }
            absAdBidding4.I0(this.this$0);
            AbsAdBidding absAdBidding5 = this.this$0.interstitialManager;
            if (absAdBidding5 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding5 = null;
            }
            aVar = this.this$0.interstitialListener;
            absAdBidding5.K0(aVar);
            Map a = com.transsion.ad.strategy.c.a.a("test4");
            a.put("channelId", MsgStyle.NATIVE_STANDARD);
            AbsAdBidding absAdBidding6 = this.this$0.interstitialManager;
            if (absAdBidding6 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding6 = null;
            }
            absAdBidding6.J0(a);
            AbsAdBidding absAdBidding7 = this.this$0.interstitialManager;
            if (absAdBidding7 == null) {
                Intrinsics.y("interstitialManager");
                absAdBidding = null;
            } else {
                absAdBidding = absAdBidding7;
            }
            this.label = 1;
            if (AbsAdBidding.t0(absAdBidding, 0, false, this, 3, (Object) null) == f) {
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
