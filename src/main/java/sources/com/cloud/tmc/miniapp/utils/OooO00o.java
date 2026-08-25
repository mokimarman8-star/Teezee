package com.cloud.tmc.miniapp.utils;

import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public static final OooO00o OooO00o = new OooO00o();

    public final boolean OooO00o(Page page) {
        ScopeUtils scopeUtils = ScopeUtils.OooO00o;
        ScopesV2Bean OooO00o2 = scopeUtils.OooO00o("fullScreen", scopeUtils.OooO00o(page));
        TmcLogger.d("AuthorityUtils", "checkFullScreenAuthority: " + OooO00o2);
        return OooO00o2 != null;
    }
}
