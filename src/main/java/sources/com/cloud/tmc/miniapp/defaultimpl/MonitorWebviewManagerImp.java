package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import com.cloud.tmc.render.MonitorWebviewListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MonitorWebviewManagerImp implements IMonitorWebviewManagerProxy {
    public final List<MonitorWebviewListener> OooO00o = new ArrayList();

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void registerMonitorListener(MonitorWebviewListener monitorWebviewListener) {
        Intrinsics.h(monitorWebviewListener, "listener");
        if (this.OooO00o.contains(monitorWebviewListener)) {
            return;
        }
        this.OooO00o.add(monitorWebviewListener);
    }

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void reportDomLoadTime(int i, String str) {
        Intrinsics.h(str, "uniqueId");
        try {
            for (MonitorWebviewListener monitorWebviewListener : this.OooO00o) {
                if (Intrinsics.c(String.valueOf(monitorWebviewListener.hashCode()), str)) {
                    monitorWebviewListener.reportDomLoadTime(i, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void unRegisterMonitorListener(MonitorWebviewListener monitorWebviewListener) {
        Intrinsics.h(monitorWebviewListener, "listener");
        if (this.OooO00o.contains(monitorWebviewListener)) {
            this.OooO00o.remove(monitorWebviewListener);
        }
    }
}
