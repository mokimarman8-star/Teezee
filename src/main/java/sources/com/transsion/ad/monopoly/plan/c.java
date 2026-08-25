package com.transsion.ad.monopoly.plan;

import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final MbAdImage a(AdPlans adPlans) {
        Intrinsics.h(adPlans, "plan");
        return adPlans.getExtImage();
    }

    public final MbAdImage b(AdPlans adPlans) {
        Intrinsics.h(adPlans, "plan");
        AdMaterialList c = c(adPlans);
        if (c != null) {
            return c.getImage();
        }
        return null;
    }

    public final AdMaterialList c(AdPlans adPlans) {
        Intrinsics.h(adPlans, "plan");
        List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
        if (adMaterialList == null || !(!adMaterialList.isEmpty())) {
            return null;
        }
        return adMaterialList.get(0);
    }
}
