package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.MiniAppAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import com.cloud.tmc.miniutils.util.GsonUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO {
    public void OooO00o(String str, MiniAppAnalyseType miniAppAnalyseType) {
        String str2;
        Intrinsics.h(miniAppAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(PointConstants.POINT_PAGE_PATH, miniAppAnalyseType.pagePath);
        bundle.putString("event_name", miniAppAnalyseType.eventName);
        Object obj = miniAppAnalyseType.data;
        if (obj != null) {
            bundle.putString(TmcConstants.KEY_BRIDGE_RESULT_DATA, GsonUtils.toJson(obj));
        }
        Unit unit = Unit.a;
        reportProxy.report(str, "inner_miniapp_developer", bundle);
        if (str != null) {
            str2 = "[" + str + "]:" + GsonUtils.toJson(miniAppAnalyseType) + "";
        } else {
            str2 = GsonUtils.toJson(miniAppAnalyseType) + "";
        }
        a.a(miniAppAnalyseType, str2);
    }
}
