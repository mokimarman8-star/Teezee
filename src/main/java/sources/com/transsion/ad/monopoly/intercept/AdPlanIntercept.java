package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.intercept.a;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlanIntercept {
    public static final AdPlanIntercept a = new AdPlanIntercept();

    private AdPlanIntercept() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(10:5|6|7|(1:(1:10)(2:23|24))(7:25|26|(2:28|(1:30))|22|14|15|(1:20)(2:17|18))|11|(4:13|14|15|(0)(0))|22|14|15|(0)(0)))|33|6|7|(0)(0)|11|(0)|22|14|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x002b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d5, code lost:
    
        r7 = kotlin.Result.Companion;
        r6 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        AdPlanIntercept$isHit$1 adPlanIntercept$isHit$1;
        int i;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof AdPlanIntercept$isHit$1) {
            adPlanIntercept$isHit$1 = (AdPlanIntercept$isHit$1) continuation;
            int i2 = adPlanIntercept$isHit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlanIntercept$isHit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlanIntercept$isHit$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlanIntercept$isHit$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Result.Companion companion = Result.Companion;
                    a b = new a.C0004a().a(new ShowOnNetworkStateHandler()).a(new SceneInWhitelistHandler()).a(new CountryInWhitelistHandler()).a(new InDenyBrandHandler()).a(new BrandInWhitelistHandler()).a(new InDenyModelHandler()).a(new ModelInWhitelistHandler()).a(new ValidTimeHandler()).a(new ValidDispatchTimeHandler()).a(new ValidTimesHandler()).a(new c()).a(new b()).a(new AdResourceDownloadedHandler()).b();
                    if (b != null) {
                        adPlanIntercept$isHit$1.label = 1;
                        obj = b.b(str, mbAdDbPlans, map, adPlanIntercept$isHit$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    adPlansHitResponse = new AdPlansHitResponse(false, "default");
                    Object obj2 = Result.constructor-impl(adPlansHitResponse);
                    Throwable th2 = Result.exceptionOrNull-impl(obj2);
                    return th2 != null ? obj2 : new AdPlansHitResponse(false, th2.getMessage());
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                adPlansHitResponse = (AdPlansHitResponse) obj;
                if (adPlansHitResponse != null) {
                    Object obj22 = Result.constructor-impl(adPlansHitResponse);
                    Throwable th22 = Result.exceptionOrNull-impl(obj22);
                    if (th22 != null) {
                    }
                }
                adPlansHitResponse = new AdPlansHitResponse(false, "default");
                Object obj222 = Result.constructor-impl(adPlansHitResponse);
                Throwable th222 = Result.exceptionOrNull-impl(obj222);
                if (th222 != null) {
                }
            }
        }
        adPlanIntercept$isHit$1 = new AdPlanIntercept$isHit$1(this, continuation);
        Object obj3 = adPlanIntercept$isHit$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlanIntercept$isHit$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj3;
        if (adPlansHitResponse != null) {
        }
        adPlansHitResponse = new AdPlansHitResponse(false, "default");
        Object obj2222 = Result.constructor-impl(adPlansHitResponse);
        Throwable th2222 = Result.exceptionOrNull-impl(obj2222);
        if (th2222 != null) {
        }
    }
}
