package com.transsion.ad.ps.attribution;

import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AttributionProduceManager extends BaseAttributionProvider {
    public static final AttributionProduceManager c = new AttributionProduceManager();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AttributionPoint.AttributionType.values().length];
            try {
                iArr[AttributionPoint.AttributionType.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttributionPoint.AttributionType.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttributionPoint.AttributionType.GP_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private AttributionProduceManager() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (r0 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k(AdPlans adPlans, AttributionPoint.AttributionType attributionType) {
        String showAttributionLink;
        try {
            Result.Companion companion = Result.Companion;
            List<AdMaterialList> adMaterialList = adPlans != null ? adPlans.getAdMaterialList() : null;
            if (adMaterialList != null && (!adMaterialList.isEmpty())) {
                RecommendInfo psRecommendInfo = adMaterialList.get(0).getPsRecommendInfo();
                int i = a.a[attributionType.ordinal()];
                String str = BuildConfig.FLAVOR;
                if (i == 1) {
                    if (psRecommendInfo != null) {
                        showAttributionLink = psRecommendInfo.getShowAttributionLink();
                    }
                    c.n(psRecommendInfo, attributionType, str);
                } else if (i == 2) {
                    if (psRecommendInfo != null) {
                        showAttributionLink = psRecommendInfo.getAttributionLink();
                        if (showAttributionLink == null) {
                        }
                        str = showAttributionLink;
                    }
                    c.n(psRecommendInfo, attributionType, str);
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (psRecommendInfo != null) {
                        showAttributionLink = psRecommendInfo.getGpAttributionLink();
                        if (showAttributionLink == null) {
                        }
                        str = showAttributionLink;
                    }
                    c.n(psRecommendInfo, attributionType, str);
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void n(RecommendInfo recommendInfo, AttributionPoint.AttributionType attributionType, String str) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AttributionProduceManager$reportUrl$1(str, recommendInfo, attributionType, null), 3, (Object) null);
    }

    public final void l(AdPlans adPlans, AttributionPoint.AttributionType attributionType) {
        Intrinsics.h(attributionType, "type");
        if (AdPlanSourceManager.a.i(adPlans)) {
            k(adPlans, attributionType);
        }
    }

    public final void m(AdPlans adPlans) {
        if (AdPlanSourceManager.a.i(adPlans)) {
            k(adPlans, AttributionPoint.AttributionType.DISPLAY);
        }
    }
}
