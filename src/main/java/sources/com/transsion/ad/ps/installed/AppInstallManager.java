package com.transsion.ad.ps.installed;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.push.PushConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import xh.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppInstallManager {
    public static final AppInstallManager a = new AppInstallManager();

    private AppInstallManager() {
    }

    public static /* synthetic */ Object c(AppInstallManager appInstallManager, Context context, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 7200000;
        }
        return appInstallManager.b(context, j, continuation);
    }

    public final AppInstalledBean a(String str) {
        Intrinsics.h(str, PushConstants.PROVIDER_FIELD_PKG);
        AppInstalledBean appInstalledBean = new AppInstalledBean(str, null, null, null, null, null, null, null, null, DownloadException.EXCEPTION_IO_SSL_HANDSHAKE, null);
        appInstalledBean.setInstallTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return appInstalledBean;
    }

    public final Object b(Context context, long j, Continuation continuation) {
        return i.g(y0.b(), new AppInstallManager$getRecentHoursOpenEvent$2(j, context, null), continuation);
    }

    public final Object d(Context context, String str, Continuation continuation) {
        return i.g(y0.b(), new AppInstallManager$isMbTriggerApp$2(context, str, null), continuation);
    }

    public final void e(Context context, AppInstalledBean appInstalledBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appInstalledBean, "appInfo");
        if (!TextUtils.isEmpty(appInstalledBean.getPackageName())) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AppInstallManager$onInstallEvent$1(context, appInstalledBean, null), 3, (Object) null);
            return;
        }
        a.k(a.a, "AppInstallManager --> onInstallEvent(包名为空) --> appInfo = " + appInstalledBean, 0, false, 6, null);
    }

    public final void f(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "packageName");
        if (!TextUtils.isEmpty(str)) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AppInstallManager$onOpenEvent$1(context, str, null), 3, (Object) null);
            return;
        }
        a.k(a.a, "AppInstallManager --> onOpenEvent(包名为空) --> packageName = " + str, 0, false, 6, null);
    }
}
