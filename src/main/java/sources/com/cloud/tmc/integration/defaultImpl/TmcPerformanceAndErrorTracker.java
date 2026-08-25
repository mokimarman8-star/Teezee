package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.integration.proxy.PerformanceProxy;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.perf.ErrReportBean;
import com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TmcPerformanceAndErrorTracker implements IPerformanceAndErrorTracker {
    private static final String TAG = "peTracker";

    public void sendErr(Context context, ErrReportBean errReportBean) {
        String.valueOf(errReportBean);
    }

    public void sendPerf(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
    }

    public void sendPerfStageLog(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        ((PerformanceProxy) TmcProxy.get(PerformanceProxy.class)).sendPerfStageLog(str, str2);
    }

    public void sendPerfV2(String str) {
        ((PerformanceProxy) TmcProxy.get(PerformanceProxy.class)).sendPerfV2(str);
    }
}
