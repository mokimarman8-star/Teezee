package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsAdPlanRetryManager$retry$1", f = "PsAdPlanRetryManager.kt", l = {49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PsAdPlanRetryManager$retry$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdPlans $plan;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PsAdPlanRetryManager$retry$1(AdPlans adPlans, Continuation<? super PsAdPlanRetryManager$retry$1> continuation) {
        super(2, continuation);
        this.$plan = adPlans;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsAdPlanRetryManager$retry$1(this.$plan, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        AdPlans adPlans;
        String extAdSlot;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            AdPlans adPlans2 = this.$plan;
            int i2 = -1;
            if (!TextUtils.isEmpty(adPlans2 != null ? adPlans2.getExtAdSlot() : null) && (adPlans = this.$plan) != null && (extAdSlot = adPlans.getExtAdSlot()) != null) {
                i2 = Integer.parseInt(extAdSlot);
            }
            if (i2 < 0) {
                return Unit.a;
            }
            PsDistributeRequestManager psDistributeRequestManager = PsDistributeRequestManager.a;
            Integer d = Boxing.d(i2);
            AdPlans adPlans3 = this.$plan;
            if (adPlans3 == null || (str = adPlans3.getId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = str;
            this.label = 1;
            if (psDistributeRequestManager.n(0, 10, d, str2, this) == f) {
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
