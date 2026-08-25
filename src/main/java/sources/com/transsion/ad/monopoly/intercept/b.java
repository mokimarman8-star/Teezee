package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseAdSceneCtxExprHandler {
    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String h(String str, MbAdDbPlans mbAdDbPlans, Map map) {
        Intrinsics.h(str, "sceneId");
        Intrinsics.h(map, "ctxMap");
        if (mbAdDbPlans != null) {
            return mbAdDbPlans.getCtxDisableExpr();
        }
        return null;
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String i() {
        return "命中 黑名单,当前广告计划 不满足展示条件";
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public String j() {
        return "未命中 黑名单,当前广告计划 满足展示条件";
    }

    @Override // com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler
    public boolean k(boolean z) {
        return !z;
    }
}
