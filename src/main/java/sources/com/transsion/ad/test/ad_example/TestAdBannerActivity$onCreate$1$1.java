package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.gslb.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdBannerActivity$onCreate$1$1", f = "TestAdBannerActivity.kt", l = {65}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdBannerActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdBannerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdBannerActivity$onCreate$1$1(TestAdBannerActivity testAdBannerActivity, Continuation<? super TestAdBannerActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdBannerActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdBannerActivity$onCreate$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        com.transsion.ad.bidding.banner.a aVar;
        com.transsion.ad.bidding.banner.a aVar2;
        com.transsion.ad.bidding.banner.a aVar3;
        com.transsion.ad.bidding.banner.a aVar4;
        com.transsion.ad.bidding.banner.a aVar5;
        com.transsion.ad.bidding.banner.a aVar6;
        TestAdBannerActivity$bannerListener$1 testAdBannerActivity$bannerListener$1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            aVar = this.this$0.bannerManager;
            if (aVar != null) {
                aVar.U();
            }
            this.this$0.bannerManager = new com.transsion.ad.bidding.banner.a();
            aVar2 = this.this$0.bannerManager;
            if (aVar2 != null) {
                aVar2.L0("MBBannerTestId");
            }
            aVar3 = this.this$0.bannerManager;
            if (aVar3 != null) {
                aVar3.J0((Map) null);
            }
            aVar4 = this.this$0.bannerManager;
            if (aVar4 != null) {
                aVar4.I0(this.this$0);
            }
            aVar5 = this.this$0.bannerManager;
            if (aVar5 != null) {
                testAdBannerActivity$bannerListener$1 = this.this$0.bannerListener;
                aVar5.K0(testAdBannerActivity$bannerListener$1);
            }
            aVar6 = this.this$0.bannerManager;
            if (aVar6 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(aVar6, 0, false, this, 3, (Object) null) == f) {
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
