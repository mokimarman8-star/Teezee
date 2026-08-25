package com.transsion.rewardscenter.task.member;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskRewards;
import fh.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.member.BaseTaskCommonProvider$startClaim$1", f = "BaseTaskCommonProvider.kt", l = {122}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseTaskCommonProvider$startClaim$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ MemberTaskItem $item;
    int label;
    final /* synthetic */ BaseTaskCommonProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseTaskCommonProvider$startClaim$1(MemberTaskItem memberTaskItem, BaseTaskCommonProvider baseTaskCommonProvider, Continuation<? super BaseTaskCommonProvider$startClaim$1> continuation) {
        super(2, continuation);
        this.$item = memberTaskItem;
        this.this$0 = baseTaskCommonProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(BaseTaskCommonProvider baseTaskCommonProvider, String str, String str2) {
        baseTaskCommonProvider.B().c().o().n(Boolean.FALSE);
        String string = baseTaskCommonProvider.k().getString(R$string.claim_points_failed_tips);
        Intrinsics.g(string, "getString(...)");
        p.a(false, string);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(BaseTaskCommonProvider baseTaskCommonProvider, TaskRewards taskRewards) {
        List data;
        MemberTaskItem memberTaskItem;
        Integer rewardAmount;
        Integer currentPoint;
        List data2;
        List data3;
        MemberTaskItem memberTaskItem2;
        MemberTaskItem taskInfo;
        baseTaskCommonProvider.B().c().o().n(Boolean.FALSE);
        BaseProviderMultiAdapter g = baseTaskCommonProvider.g();
        int i = -1;
        if (g != null && (data2 = g.getData()) != null) {
            int i2 = 0;
            for (Object obj : data2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                MemberTaskItem memberTaskItem3 = (MemberTaskItem) obj;
                if (Intrinsics.c(memberTaskItem3.getTaskId(), (taskRewards == null || (taskInfo = taskRewards.getTaskInfo()) == null) ? null : taskInfo.getTaskId()) && memberTaskItem3.getTaskId() != null) {
                    MemberTaskItem taskInfo2 = taskRewards != null ? taskRewards.getTaskInfo() : null;
                    BaseProviderMultiAdapter g2 = baseTaskCommonProvider.g();
                    if (g2 != null && (data3 = g2.getData()) != null && (memberTaskItem2 = (MemberTaskItem) data3.get(i2)) != null) {
                        memberTaskItem2.setStatus(taskInfo2 != null ? taskInfo2.getStatus() : null);
                        memberTaskItem2.setProgress(taskInfo2 != null ? taskInfo2.getProgress() : null);
                        memberTaskItem2.setTotalProgress(taskInfo2 != null ? taskInfo2.getTotalProgress() : null);
                    }
                    i = i2;
                }
                i2 = i3;
            }
        }
        if (taskRewards != null && (currentPoint = taskRewards.getCurrentPoint()) != null) {
            baseTaskCommonProvider.B().c().C(currentPoint.intValue());
        }
        if (i < 0) {
            return Unit.a;
        }
        BaseProviderMultiAdapter g3 = baseTaskCommonProvider.g();
        int intValue = (g3 == null || (data = g3.getData()) == null || (memberTaskItem = (MemberTaskItem) data.get(i)) == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue();
        b.a aVar = fh.b.a;
        int i4 = R$layout.claim_succeed_layout;
        String string = baseTaskCommonProvider.k().getString(R$string.claim_points_receive_tips, Integer.valueOf(intValue));
        Intrinsics.g(string, "getString(...)");
        b.a.h(aVar, i4, string, 80, 0, a0.a(66.0f), 8, (Object) null);
        baseTaskCommonProvider.G();
        BaseProviderMultiAdapter g4 = baseTaskCommonProvider.g();
        if (g4 != null) {
            g4.notifyItemChanged(i);
        }
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseTaskCommonProvider$startClaim$1(this.$item, this.this$0, continuation);
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
            String taskId = this.$item.getTaskId();
            final BaseTaskCommonProvider baseTaskCommonProvider = this.this$0;
            Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.task.member.b
                public final Object invoke(Object obj2, Object obj3) {
                    Unit g;
                    g = BaseTaskCommonProvider$startClaim$1.g(BaseTaskCommonProvider.this, (String) obj2, (String) obj3);
                    return g;
                }
            };
            final BaseTaskCommonProvider baseTaskCommonProvider2 = this.this$0;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.task.member.c
                public final Object invoke(Object obj2) {
                    Unit h;
                    h = BaseTaskCommonProvider$startClaim$1.h(BaseTaskCommonProvider.this, (TaskRewards) obj2);
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
