package com.cloud.tmc.miniapp.utils.athena.strategy.steps;

import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO implements OooOO0 {
    @Override // com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0
    public com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o OooO00o(OooOO0.OooO00o oooO00o) {
        Intrinsics.h(oooO00o, "chain");
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0 oooO0O0 = (com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0) oooO00o;
        String str = oooO0O0.OooO0O0;
        boolean checkMiniAppPrivacyAgreementDialogWhiteList = str != null ? AppUtils.INSTANCE.checkMiniAppPrivacyAgreementDialogWhiteList(str) : false;
        TmcLogger.d("AthenaUtil", "report AthenaWhiteListStep -> inWhiteList:" + checkMiniAppPrivacyAgreementDialogWhiteList);
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o oooO00o2 = oooO0O0.OooO0o0;
        oooO00o2.OooO00o = checkMiniAppPrivacyAgreementDialogWhiteList ^ true;
        oooO00o2.OooO0O0 = false;
        oooO00o2.OooO0OO = false;
        oooO0O0.OooO00o(checkMiniAppPrivacyAgreementDialogWhiteList);
        return oooO0O0.OooO0o0;
    }
}
