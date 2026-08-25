package com.cloud.tmc.miniapp.utils.athena.strategy.steps;

import android.content.Context;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0o implements OooOO0 {
    @Override // com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0
    public com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o OooO00o(OooOO0.OooO00o oooO00o) {
        Intrinsics.h(oooO00o, "chain");
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0 oooO0O0 = (com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0) oooO00o;
        Context context = oooO0O0.OooO00o;
        boolean z = context != null ? ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, "100000", TmcConstants.KEY_PRIVACY_AGREEMENT, false) : false;
        TmcLogger.d("AthenaUtil", "report AthenaPrivacyStep -> agree:" + z);
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o oooO00o2 = oooO0O0.OooO0o0;
        oooO00o2.OooO00o = z ^ true;
        oooO00o2.OooO0O0 = true;
        oooO00o2.OooO0OO = false;
        oooO0O0.OooO00o(z);
        return oooO0O0.OooO0o0;
    }
}
