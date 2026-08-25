package com.transsion.ad.monopoly.intercept;

import android.app.Application;
import android.text.TextUtils;
import ci.p;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.gslb.BuildConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager$saveShowedTimes$3", f = "NonAdShowedTimesManager.kt", l = {126, 130, 135}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NonAdShowedTimesManager$saveShowedTimes$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdPlans $mAdPlans;
    final /* synthetic */ MbAdDbPlans $nonAdPlans;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NonAdShowedTimesManager$saveShowedTimes$3(MbAdDbPlans mbAdDbPlans, AdPlans adPlans, Continuation<? super NonAdShowedTimesManager$saveShowedTimes$3> continuation) {
        super(2, continuation);
        this.$nonAdPlans = mbAdDbPlans;
        this.$mAdPlans = adPlans;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonAdShowedTimesManager$saveShowedTimes$3(this.$nonAdPlans, this.$mAdPlans, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            MbAdDbPlans mbAdDbPlans = this.$nonAdPlans;
            concurrentHashMap = NonAdShowedTimesManager.b;
            ShowedTimesMemoryBean showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.get(this.$nonAdPlans.getId());
            mbAdDbPlans.setShowedTimes(Boxing.d(showedTimesMemoryBean != null ? showedTimesMemoryBean.getShowedTimes() : 0));
            this.$nonAdPlans.setShowDate(p.a.c());
            MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            uh.a y0 = companion.b(a).y0();
            String id = this.$mAdPlans.getId();
            this.label = 1;
            obj = y0.f(id, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) obj;
        if (TextUtils.equals(mbAdDbPlans2 != null ? mbAdDbPlans2.getAdPlanUpdateTime() : null, this.$nonAdPlans.getAdPlanUpdateTime())) {
            MbAdDatabase.Companion companion2 = MbAdDatabase.INSTANCE;
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            uh.a y02 = companion2.b(a2).y0();
            MbAdDbPlans mbAdDbPlans3 = this.$nonAdPlans;
            this.label = 2;
            if (y02.g(mbAdDbPlans3, this) == f) {
                return f;
            }
        } else {
            if (mbAdDbPlans2 != null) {
                mbAdDbPlans2.setShowedTimes(this.$nonAdPlans.getShowedTimes());
            }
            if (mbAdDbPlans2 != null) {
                mbAdDbPlans2.setShowDate(this.$nonAdPlans.getShowDate());
            }
            if (mbAdDbPlans2 != null) {
                MbAdDatabase.Companion companion3 = MbAdDatabase.INSTANCE;
                Application a3 = Utils.a();
                Intrinsics.g(a3, "getApp(...)");
                uh.a y03 = companion3.b(a3).y0();
                this.label = 3;
                if (y03.g(mbAdDbPlans2, this) == f) {
                    return f;
                }
            }
        }
        return Unit.a;
    }
}
