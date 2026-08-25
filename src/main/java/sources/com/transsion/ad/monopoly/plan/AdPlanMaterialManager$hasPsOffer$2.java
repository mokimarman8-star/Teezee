package com.transsion.ad.monopoly.plan;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import vh.l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Result;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Result;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$2", f = "AdPlanMaterialManager.kt", l = {51}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdPlanMaterialManager$hasPsOffer$2 extends SuspendLambda implements Function2<n0, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Ref.BooleanRef $hasResource;
    final /* synthetic */ MbAdDbPlans $plan;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdPlanMaterialManager$hasPsOffer$2(MbAdDbPlans mbAdDbPlans, Ref.BooleanRef booleanRef, Continuation<? super AdPlanMaterialManager$hasPsOffer$2> continuation) {
        super(2, continuation);
        this.$plan = mbAdDbPlans;
        this.$hasResource = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdPlanMaterialManager$hasPsOffer$2 adPlanMaterialManager$hasPsOffer$2 = new AdPlanMaterialManager$hasPsOffer$2(this.$plan, this.$hasResource, continuation);
        adPlanMaterialManager$hasPsOffer$2.L$0 = obj;
        return adPlanMaterialManager$hasPsOffer$2;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Result<Unit>> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        l c;
        Ref.BooleanRef booleanRef;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                MbAdDbPlans mbAdDbPlans = this.$plan;
                Ref.BooleanRef booleanRef2 = this.$hasResource;
                Result.Companion companion = Result.Companion;
                String extAdSlot = mbAdDbPlans != null ? mbAdDbPlans.getExtAdSlot() : null;
                c = AdPlanMaterialManager.a.c();
                String valueOf = String.valueOf(extAdSlot);
                this.L$0 = booleanRef2;
                this.label = 1;
                obj = c.c(valueOf, this);
                if (obj == f) {
                    return f;
                }
                booleanRef = booleanRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.b(obj);
            }
            if (((Number) obj).intValue() <= 0) {
                z = false;
            }
            booleanRef.element = z;
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        return Result.box-impl(obj2);
    }
}
