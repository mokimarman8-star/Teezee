package com.transsion.ad.monopoly.plan;

import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final AdMaterialList a(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty()) || (adMaterialList2 = adPlans.getAdMaterialList()) == null) {
            return null;
        }
        return adMaterialList2.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RecommendInfo b(AdPlans adPlans) {
        Object obj;
        RecommendInfo recommendInfo;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (AdPlanSourceManager.a.i(adPlans)) {
            List<AdMaterialList> adMaterialList = adPlans != null ? adPlans.getAdMaterialList() : null;
            List<AdMaterialList> list = adMaterialList;
            if (list != null && !list.isEmpty()) {
                recommendInfo = adMaterialList.get(0).getPsRecommendInfo();
                obj = Result.constructor-impl(recommendInfo);
                return (RecommendInfo) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
            }
        }
        recommendInfo = null;
        obj = Result.constructor-impl(recommendInfo);
        return (RecommendInfo) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
    }
}
