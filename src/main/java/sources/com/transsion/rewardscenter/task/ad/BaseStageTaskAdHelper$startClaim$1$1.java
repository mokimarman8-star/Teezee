package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskRewards;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$startClaim$1$1", f = "BaseStageTaskAdHelper.kt", l = {268}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseStageTaskAdHelper$startClaim$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ MemberTaskItem $it;
    final /* synthetic */ v $item;
    int label;
    final /* synthetic */ BaseStageTaskAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStageTaskAdHelper$startClaim$1$1(MemberTaskItem memberTaskItem, BaseStageTaskAdHelper baseStageTaskAdHelper, v vVar, Function0<Unit> function0, Continuation<? super BaseStageTaskAdHelper$startClaim$1$1> continuation) {
        super(2, continuation);
        this.$it = memberTaskItem;
        this.this$0 = baseStageTaskAdHelper;
        this.$item = vVar;
        this.$callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(BaseStageTaskAdHelper baseStageTaskAdHelper, String str, String str2) {
        BaseStageTaskAdHelper.a aVar;
        Context context;
        aVar = baseStageTaskAdHelper.d;
        if (aVar != null) {
            aVar.b();
        }
        if (str2 == null) {
            context = baseStageTaskAdHelper.a;
            str2 = context.getString(R$string.claim_failed);
            Intrinsics.g(str2, "getString(...)");
        }
        com.transsion.rewardscenter.utils.p.a(false, str2);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(v vVar, BaseStageTaskAdHelper baseStageTaskAdHelper, Function0 function0, TaskRewards taskRewards) {
        BaseStageTaskAdHelper.a aVar;
        if (taskRewards != null) {
            String tips = taskRewards.getTips();
            if (tips != null) {
                com.transsion.rewardscenter.utils.p.a(true, tips);
            }
            a.a.f(wf.a.a, "StageTaskAd", "----> claimMemberShipReward: " + taskRewards.getTaskInfo() + ", " + taskRewards.getCurrentPoint(), false, 4, (Object) null);
            u.a.b(vVar, taskRewards.getTaskInfo());
            aVar = baseStageTaskAdHelper.d;
            if (aVar != null) {
                aVar.a(taskRewards.getCurrentPoint());
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseStageTaskAdHelper$startClaim$1$1(this.$it, this.this$0, this.$item, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            RewardsCenterApiHelper rewardsCenterApiHelper = RewardsCenterApiHelper.a;
            String taskId = this.$it.getTaskId();
            final BaseStageTaskAdHelper baseStageTaskAdHelper = this.this$0;
            Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.task.ad.b
                public final Object invoke(Object obj2, Object obj3) {
                    Unit g;
                    g = BaseStageTaskAdHelper$startClaim$1$1.g(BaseStageTaskAdHelper.this, (String) obj2, (String) obj3);
                    return g;
                }
            };
            final v vVar = this.$item;
            final BaseStageTaskAdHelper baseStageTaskAdHelper2 = this.this$0;
            final Function0<Unit> function0 = this.$callback;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.task.ad.c
                public final Object invoke(Object obj2) {
                    Unit h;
                    h = BaseStageTaskAdHelper$startClaim$1$1.h(v.this, baseStageTaskAdHelper2, function0, (TaskRewards) obj2);
                    return h;
                }
            };
            this.label = 1;
            if (rewardsCenterApiHelper.u(taskId, function2, function1, this) == f) {
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
