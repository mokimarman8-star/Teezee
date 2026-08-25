package com.transsion.rewardscenter.task.ad;

import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenterapi.AdTaskInfo;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.List;
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
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1", f = "BaseStageTaskAdHelper.kt", l = {316}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1(Function0<Unit> function0, Continuation<? super BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1> continuation) {
        super(2, continuation);
        this.$callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0, AdTaskInfo adTaskInfo) {
        List<MemberTaskItem> list;
        if (adTaskInfo != null && (list = adTaskInfo.getList()) != null) {
            u.a.r(list);
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1(this.$callback, continuation);
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
            final Function0<Unit> function0 = this.$callback;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.task.ad.a
                public final Object invoke(Object obj2) {
                    Unit d;
                    d = BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1.d(function0, (AdTaskInfo) obj2);
                    return d;
                }
            };
            this.label = 1;
            if (RewardsCenterApiHelper.o(rewardsCenterApiHelper, null, function1, this, 1, null) == f) {
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
