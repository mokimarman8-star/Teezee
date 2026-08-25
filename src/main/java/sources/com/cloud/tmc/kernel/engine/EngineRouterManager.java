package com.cloud.tmc.kernel.engine;

import com.cloud.tmc.kernel.proxy.Proxiable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface EngineRouterManager extends Proxiable {
    EngineRouter get(long j);

    EngineRouter getByWorkerId(String str);

    EngineRouter remove(EngineRouter engineRouter);
}
