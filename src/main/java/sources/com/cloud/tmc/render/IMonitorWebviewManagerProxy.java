package com.cloud.tmc.render;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.Proxiable;
import kotlin.Metadata;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.MonitorWebviewManagerImp")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/render/IMonitorWebviewManagerProxy;", "Lcom/cloud/tmc/kernel/proxy/Proxiable;", "registerMonitorListener", "", "listener", "Lcom/cloud/tmc/render/MonitorWebviewListener;", "reportDomLoadTime", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "uniqueId", "", "unRegisterMonitorListener", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IMonitorWebviewManagerProxy extends Proxiable {
    void registerMonitorListener(MonitorWebviewListener listener);

    void reportDomLoadTime(int type, String uniqueId);

    void unRegisterMonitorListener(MonitorWebviewListener listener);
}
