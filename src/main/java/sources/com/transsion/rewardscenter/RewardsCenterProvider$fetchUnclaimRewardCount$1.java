package com.transsion.rewardscenter;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.utils.n;
import com.transsion.rewardscenterapi.MineLotteryInfo;
import com.transsion.rewardscenterapi.PriceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import wf.a;
import xo.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.RewardsCenterProvider$fetchUnclaimRewardCount$1", f = "RewardsCenterProvider.kt", l = {54}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RewardsCenterProvider$fetchUnclaimRewardCount$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RewardsCenterProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RewardsCenterProvider$fetchUnclaimRewardCount$1(RewardsCenterProvider rewardsCenterProvider, Continuation<? super RewardsCenterProvider$fetchUnclaimRewardCount$1> continuation) {
        super(2, continuation);
        this.this$0 = rewardsCenterProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RewardsCenterProvider$fetchUnclaimRewardCount$1 rewardsCenterProvider$fetchUnclaimRewardCount$1 = new RewardsCenterProvider$fetchUnclaimRewardCount$1(this.this$0, continuation);
        rewardsCenterProvider$fetchUnclaimRewardCount$1.L$0 = obj;
        return rewardsCenterProvider$fetchUnclaimRewardCount$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        b0 b0Var;
        List<PriceInfo> priceItems;
        xo.a h;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                RewardsCenterProvider rewardsCenterProvider = this.this$0;
                Result.Companion companion = Result.Companion;
                h = rewardsCenterProvider.h();
                this.label = 1;
                obj = a.C0103a.e(h, null, this, 1, null);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            obj2 = Result.constructor-impl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        RewardsCenterProvider rewardsCenterProvider2 = this.this$0;
        if (Result.isSuccess-impl(obj2)) {
            BaseDto baseDto = (BaseDto) obj2;
            if (n.a(baseDto)) {
                MineLotteryInfo mineLotteryInfo = (MineLotteryInfo) baseDto.getData();
                int size = (mineLotteryInfo == null || (priceItems = mineLotteryInfo.getPriceItems()) == null) ? 0 : priceItems.size();
                b0Var = rewardsCenterProvider2.b;
                b0Var.n(Boxing.d(size));
                a.a.f(wf.a.a, "RewardsCenter", "fetchUnclaimRewardCount: " + size, false, 4, (Object) null);
            }
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            a.a.f(wf.a.a, "RewardsCenter", "fetchUnclaimRewardCount error: " + th3.getMessage(), false, 4, (Object) null);
        }
        return Unit.a;
    }
}
