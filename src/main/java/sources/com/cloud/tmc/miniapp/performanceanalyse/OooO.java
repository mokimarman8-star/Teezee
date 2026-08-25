package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO {
    public void OooO00o(String str, OfflineDownloadAnalyseType offlineDownloadAnalyseType, String str2, Bundle bundle) {
        String objectNameZh;
        StringBuilder sb;
        Intrinsics.h(offlineDownloadAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        if (str2 == null) {
            str2 = "";
        }
        if (str != null) {
            objectNameZh = offlineDownloadAnalyseType.getObjectNameZh();
            sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("]:");
        } else {
            objectNameZh = offlineDownloadAnalyseType.getObjectNameZh();
            sb = new StringBuilder();
        }
        sb.append(objectNameZh);
        sb.append(" ");
        sb.append((Object) str2);
        String sb2 = sb.toString();
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString(offlineDownloadAnalyseType.getClass().getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + offlineDownloadAnalyseType.name(), sb2);
        bundle2.putString("object_id", offlineDownloadAnalyseType.getObjectId());
        bundle2.putString("object_name", offlineDownloadAnalyseType.getObjectNameEn());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Unit unit = Unit.a;
        reportProxy.report(str, "miniapp_offline_download", bundle2);
        TmcLogger.d(TmcConstants.PERFERENCE_OFFLINE_DOWNLOAD_TAG, sb2);
        a.a(offlineDownloadAnalyseType, sb2);
    }
}
