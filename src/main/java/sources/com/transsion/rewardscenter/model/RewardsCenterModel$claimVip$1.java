package com.transsion.rewardscenter.model;

import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenterapi.ClaimResultData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.model.RewardsCenterModel$claimVip$1", f = "RewardsCenterModel.kt", l = {228}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RewardsCenterModel$claimVip$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $drawResultId;
    int label;
    final /* synthetic */ RewardsCenterModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RewardsCenterModel$claimVip$1(RewardsCenterModel rewardsCenterModel, String str, Continuation<? super RewardsCenterModel$claimVip$1> continuation) {
        super(2, continuation);
        this.this$0 = rewardsCenterModel;
        this.$drawResultId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(RewardsCenterModel rewardsCenterModel, String str, String str2) {
        rewardsCenterModel.o().n(Boolean.FALSE);
        rewardsCenterModel.A(null);
        rewardsCenterModel.m().n(new Pair(str, str2));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(RewardsCenterModel rewardsCenterModel, String str, ClaimResultData claimResultData) {
        rewardsCenterModel.o().n(Boolean.FALSE);
        rewardsCenterModel.A(null);
        rewardsCenterModel.n().n(new Pair(str, Boolean.TRUE));
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RewardsCenterModel$claimVip$1(this.this$0, this.$drawResultId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.this$0.o().q(Boxing.a(true));
            RewardsCenterApiHelper rewardsCenterApiHelper = RewardsCenterApiHelper.a;
            String str = this.$drawResultId;
            final RewardsCenterModel rewardsCenterModel = this.this$0;
            Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.model.h
                public final Object invoke(Object obj2, Object obj3) {
                    Unit g;
                    g = RewardsCenterModel$claimVip$1.g(RewardsCenterModel.this, (String) obj2, (String) obj3);
                    return g;
                }
            };
            final RewardsCenterModel rewardsCenterModel2 = this.this$0;
            final String str2 = this.$drawResultId;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.model.i
                public final Object invoke(Object obj2) {
                    Unit h;
                    h = RewardsCenterModel$claimVip$1.h(RewardsCenterModel.this, str2, (ClaimResultData) obj2);
                    return h;
                }
            };
            this.label = 1;
            if (rewardsCenterApiHelper.l(str, function2, function1, this) == f) {
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
