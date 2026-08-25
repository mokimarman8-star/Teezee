package com.transsion.rewardscenter.task.ad;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$loadRegularAd$1", f = "MemberTaskAdHelper.kt", l = {185}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberTaskAdHelper$loadRegularAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MemberTaskAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberTaskAdHelper$loadRegularAd$1(MemberTaskAdHelper memberTaskAdHelper, Continuation<? super MemberTaskAdHelper$loadRegularAd$1> continuation) {
        super(2, continuation);
        this.this$0 = memberTaskAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberTaskAdHelper$loadRegularAd$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingSspNativeManager biddingSspNativeManager;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            int e = RangesKt.e(MemberTaskAdHelper.r.a(), 2);
            biddingSspNativeManager = this.this$0.k;
            if (biddingSspNativeManager != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingSspNativeManager, e, false, this, 2, (Object) null) == f) {
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
