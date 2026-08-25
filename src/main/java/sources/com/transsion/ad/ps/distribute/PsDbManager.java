package com.transsion.ad.ps.distribute;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import vh.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsDbManager {
    public static final PsDbManager a = new PsDbManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.b
        public final Object invoke() {
            l m;
            m = PsDbManager.m();
            return m;
        }
    });

    private PsDbManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = PsDbManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final l i() {
        return (l) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l m() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).z0();
    }

    public final Object c(String str, List list, Continuation continuation) {
        Object d = i().d(str, list, continuation);
        return d == IntrinsicsKt.f() ? d : Unit.a;
    }

    public final Object d(Continuation continuation) {
        return i().a(continuation);
    }

    public final Object f(String str, Continuation continuation) {
        return i().c(String.valueOf(str), continuation);
    }

    public final Object g(int i, Continuation continuation) {
        return i().f(i, continuation);
    }

    public final Object h(String str, Continuation continuation) {
        return i().g(str, continuation);
    }

    public final Object j(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        Object b2 = i().b(psLinkAdPlan, continuation);
        return b2 == IntrinsicsKt.f() ? b2 : Unit.a;
    }

    public final void k(AdPlans adPlans) {
        AdMaterialList a2;
        PsLinkAdPlan psLinkAdPlan;
        if (!AdPlanSourceManager.a.i(adPlans) || (a2 = com.transsion.ad.monopoly.plan.b.a.a(adPlans)) == null || (psLinkAdPlan = a2.getPsLinkAdPlan()) == null) {
            return;
        }
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PsDbManager$onBiddingBuyOutClick$1(psLinkAdPlan, null), 3, (Object) null);
    }

    public final void l(AdPlans adPlans) {
        AdMaterialList a2;
        PsLinkAdPlan psLinkAdPlan;
        if (!AdPlanSourceManager.a.i(adPlans) || (a2 = com.transsion.ad.monopoly.plan.b.a.a(adPlans)) == null || (psLinkAdPlan = a2.getPsLinkAdPlan()) == null) {
            return;
        }
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PsDbManager$onBiddingBuyOutDisplay$1(psLinkAdPlan, null), 3, (Object) null);
    }

    public final Object n(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        Object e;
        return (psLinkAdPlan == null || (e = a.i().e(psLinkAdPlan, continuation)) != IntrinsicsKt.f()) ? Unit.a : e;
    }
}
