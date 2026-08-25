package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.MiniCardAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0o {
    public void OooO00o(String str, MiniCardAnalyseType miniCardAnalyseType, Bundle bundle) {
        String objectNameZh;
        StringBuilder sb;
        Intrinsics.h(miniCardAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        if (str != null) {
            objectNameZh = miniCardAnalyseType.getObjectNameZh();
            sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("]:");
        } else {
            objectNameZh = miniCardAnalyseType.getObjectNameZh();
            sb = new StringBuilder();
        }
        sb.append(objectNameZh);
        sb.append((Object) "");
        String sb2 = sb.toString();
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString(miniCardAnalyseType.getClass().getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + miniCardAnalyseType.name(), sb2);
        bundle2.putString("object_id", miniCardAnalyseType.getObjectId());
        bundle2.putString("object_name", miniCardAnalyseType.getObjectNameEn());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Unit unit = Unit.a;
        reportProxy.report(str, "miniapp_card", bundle2);
        TmcLogger.d(TmcConstants.MINI_CARD_TAG, sb2);
        a.a(miniCardAnalyseType, sb2);
    }
}
