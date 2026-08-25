package com.cloud.tmc.miniapp.prestrategy.strategy;

import android.content.Context;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.OooO0OO;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public static final OooO00o OooO00o = new OooO00o();
    public static ConcurrentHashMap<String, AppModel> OooO0O0 = new ConcurrentHashMap<>();
    public static final String OooO0OO = "PreCdnAppinfoStrategy";

    public final AppModel OooO00o(String str) {
        Intrinsics.h(str, "appId");
        try {
            if (OooO0OO.OooO00o.OooO0O0()) {
                return null;
            }
            TmcLogger.d(OooO0OO, "getPreAppinfoModel " + str);
            return OooO0O0.get(str);
        } catch (Throwable th) {
            TmcLogger.e(OooO0OO, "getPreAppinfoModel", th);
            return null;
        }
    }

    public final void OooO00o(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        try {
            if (OooO0O0.contains(str)) {
                TmcLogger.e(OooO0OO, "preAppinfoCdn appId is exist");
                return;
            }
            AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(context, AppInfoQuery.Companion.make(str));
            if (appModel != null) {
                TmcLogger.d(OooO0OO, "preAppinfoCdn put " + str);
                OooO0O0.put(str, appModel);
            }
        } catch (Throwable th) {
            TmcLogger.e(OooO0OO, "preAppinfoCdn", th);
        }
    }
}
