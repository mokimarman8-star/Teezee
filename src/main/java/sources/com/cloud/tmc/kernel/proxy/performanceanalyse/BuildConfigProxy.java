package com.cloud.tmc.kernel.proxy.performanceanalyse;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.BuildConfigProxyImp")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface BuildConfigProxy extends Proxiable {
    Boolean isDebug();
}
