package com.cloud.tmc.miniapp.ipc.helper;

import android.os.Bundle;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO {
    public static final OooO OooO00o = new OooO();

    public static final void OooO0O0(String str, String str2, Bundle bundle) {
        int i;
        try {
            if (Intrinsics.c(str, "miniappWarmup")) {
                if (bundle != null) {
                    try {
                        i = bundle.getInt("warmupType");
                    } catch (Throwable th) {
                        TmcLogger.e("MiniAppPerformanceHelper", th);
                        return;
                    }
                } else {
                    i = 0;
                }
                try {
                    if (i == 0) {
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                        miniAppLaunch.warmUpWorker();
                        miniAppLaunch.warmupRender();
                    } else if (i != 1) {
                    } else {
                        ((IInnerH5WebviewPool) TmcProxy.get(IInnerH5WebviewPool.class)).createWebview();
                    }
                } catch (Throwable th2) {
                    TmcLogger.e("MiniAppPerformanceHelper", th2);
                }
            }
        } catch (Throwable th3) {
            TmcLogger.e("MiniAppPerformanceHelper", "protocolInvoke", th3);
        }
    }

    public void OooO00o(final String str, final String str2, final Bundle bundle) {
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ipc.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    OooO.OooO0O0(str, str2, bundle);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e("MiniAppPerformanceHelper", "protocolInvoke", th);
        }
    }
}
