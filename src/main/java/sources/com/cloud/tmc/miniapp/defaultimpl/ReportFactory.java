package com.cloud.tmc.miniapp.defaultimpl;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.proxy.ReportFactoryProxy;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ReportFactory implements ReportFactoryProxy {

    public enum ReportType {
        ATHENA(0),
        FIREBASE(1);

        private final int type;

        ReportType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void report(String str, String str2, Bundle bundle, Integer num, Integer num2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (num != null) {
            if (num.intValue() != ReportType.ATHENA.getType()) {
                if (num.intValue() == ReportType.FIREBASE.getType()) {
                    ((LauncherReportProxy) TmcProxy.get(LauncherReportProxy.class)).report(str2, bundle);
                } else {
                    TmcLogger.e("report", "上报类型不支持");
                }
                if (AppDynamicBuildConfig.isAppDebugAble()) {
                    return;
                }
                com.cloud.tmc.kernel.proxy.performanceanalyse.a.a(PointAnalyseType.CONSOLE, "[埋点上报-" + str + "]: tag: " + str2 + " reportType: " + num + " athenaAppId: " + num2 + " reportData: " + bundle);
                return;
            }
        }
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(str, str2, bundle, num2);
        if (AppDynamicBuildConfig.isAppDebugAble()) {
        }
    }
}
