package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.test.ad_example.TestAdNativeSspActivity;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeSspActivity$onCreate$1$1", f = "TestAdNativeSspActivity.kt", l = {85}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdNativeSspActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeSspActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdNativeSspActivity$onCreate$1$1(TestAdNativeSspActivity testAdNativeSspActivity, Continuation<? super TestAdNativeSspActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeSspActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeSspActivity$onCreate$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        TestAdNativeSspActivity.a aVar;
        AbsAdBidding absAdBidding;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            AbsAdBidding absAdBidding2 = this.this$0.nativeManager;
            if (absAdBidding2 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding2 = null;
            }
            absAdBidding2.L0("MBNativeTestId");
            AbsAdBidding absAdBidding3 = this.this$0.nativeManager;
            if (absAdBidding3 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding3 = null;
            }
            absAdBidding3.J0((Map) null);
            AbsAdBidding absAdBidding4 = this.this$0.nativeManager;
            if (absAdBidding4 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding4 = null;
            }
            absAdBidding4.I0(this.this$0);
            AbsAdBidding absAdBidding5 = this.this$0.nativeManager;
            if (absAdBidding5 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding5 = null;
            }
            aVar = this.this$0.nativeListener;
            absAdBidding5.K0(aVar);
            AbsAdBidding absAdBidding6 = this.this$0.nativeManager;
            if (absAdBidding6 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding = null;
            } else {
                absAdBidding = absAdBidding6;
            }
            this.label = 1;
            if (AbsAdBidding.t0(absAdBidding, 3, false, this, 2, (Object) null) == f) {
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
