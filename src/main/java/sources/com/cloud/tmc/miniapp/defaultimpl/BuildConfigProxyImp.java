package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BuildConfigProxyImp implements BuildConfigProxy {
    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy
    public Boolean isDebug() {
        return Boolean.valueOf(AppDynamicBuildConfig.isAppDebugAble());
    }
}
