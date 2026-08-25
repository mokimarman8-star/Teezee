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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeActivity$onCreate$1$1", f = "TestAdNativeActivity.kt", l = {69}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdNativeActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdNativeActivity$onCreate$1$1(TestAdNativeActivity testAdNativeActivity, Continuation<? super TestAdNativeActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeActivity$onCreate$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        AbsAdBidding absAdBidding;
        AbsAdBidding absAdBidding2;
        AbsAdBidding absAdBidding3;
        AbsAdBidding absAdBidding4;
        TestAdNativeActivity$nativeListener$1 testAdNativeActivity$nativeListener$1;
        AbsAdBidding absAdBidding5;
        AbsAdBidding absAdBidding6;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            absAdBidding = this.this$0.nativeManager;
            if (absAdBidding == null) {
                Intrinsics.y("nativeManager");
                absAdBidding = null;
            }
            absAdBidding.L0("MBNativeTestId");
            absAdBidding2 = this.this$0.nativeManager;
            if (absAdBidding2 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding2 = null;
            }
            absAdBidding2.J0((Map) null);
            absAdBidding3 = this.this$0.nativeManager;
            if (absAdBidding3 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding3 = null;
            }
            absAdBidding3.I0(this.this$0);
            absAdBidding4 = this.this$0.nativeManager;
            if (absAdBidding4 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding4 = null;
            }
            testAdNativeActivity$nativeListener$1 = this.this$0.nativeListener;
            absAdBidding4.K0(testAdNativeActivity$nativeListener$1);
            absAdBidding5 = this.this$0.nativeManager;
            if (absAdBidding5 == null) {
                Intrinsics.y("nativeManager");
                absAdBidding6 = null;
            } else {
                absAdBidding6 = absAdBidding5;
            }
            this.label = 1;
            if (AbsAdBidding.t0(absAdBidding6, 0, false, this, 3, (Object) null) == f) {
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
