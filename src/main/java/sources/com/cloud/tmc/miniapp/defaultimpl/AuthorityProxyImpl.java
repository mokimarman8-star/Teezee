package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AuthorityProxyImpl implements AuthorityProxy {
    public boolean checkFullScreenAuthority(Page page) {
        return com.cloud.tmc.miniapp.utils.OooO00o.OooO00o.OooO00o(page);
    }

    public void clearPermissionData(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        try {
            ScopeUtils.OooO00o.OooO0OO(context, str);
        } catch (Throwable th) {
            TmcLogger.e("AuthorityProxyImpl", "clearPermissionData", th);
        }
    }
}
