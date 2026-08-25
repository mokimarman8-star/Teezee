package com.transsion.ad.monopoly.plan;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.y0;
import vh.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlanMaterialManager {
    public static final AdPlanMaterialManager a = new AdPlanMaterialManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.plan.a
        public final Object invoke() {
            l e;
            e = AdPlanMaterialManager.e();
            return e;
        }
    });

    private AdPlanMaterialManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l c() {
        return (l) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l e() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).z0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        AdPlanMaterialManager$hasPsOffer$1 adPlanMaterialManager$hasPsOffer$1;
        int i;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof AdPlanMaterialManager$hasPsOffer$1) {
            adPlanMaterialManager$hasPsOffer$1 = (AdPlanMaterialManager$hasPsOffer$1) continuation;
            int i2 = adPlanMaterialManager$hasPsOffer$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlanMaterialManager$hasPsOffer$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlanMaterialManager$hasPsOffer$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlanMaterialManager$hasPsOffer$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    i0 b2 = y0.b();
                    AdPlanMaterialManager$hasPsOffer$2 adPlanMaterialManager$hasPsOffer$2 = new AdPlanMaterialManager$hasPsOffer$2(mbAdDbPlans, booleanRef2, null);
                    adPlanMaterialManager$hasPsOffer$1.L$0 = booleanRef2;
                    adPlanMaterialManager$hasPsOffer$1.label = 1;
                    if (i.g(b2, adPlanMaterialManager$hasPsOffer$2, adPlanMaterialManager$hasPsOffer$1) == f) {
                        return f;
                    }
                    booleanRef = booleanRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) adPlanMaterialManager$hasPsOffer$1.L$0;
                    ResultKt.b(obj);
                }
                return Boxing.a(booleanRef.element);
            }
        }
        adPlanMaterialManager$hasPsOffer$1 = new AdPlanMaterialManager$hasPsOffer$1(this, continuation);
        Object obj2 = adPlanMaterialManager$hasPsOffer$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlanMaterialManager$hasPsOffer$1.label;
        if (i != 0) {
        }
        return Boxing.a(booleanRef.element);
    }
}
