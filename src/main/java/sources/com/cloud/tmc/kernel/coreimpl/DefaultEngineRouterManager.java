package com.cloud.tmc.kernel.coreimpl;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DefaultEngineRouterManager implements EngineRouterManager {
    Map<Long, EngineRouter> routerMap = new HashMap(16);

    @Override // com.cloud.tmc.kernel.engine.EngineRouterManager
    public EngineRouter get(long j) {
        EngineRouter defaultEngineRouter = this.routerMap.containsKey(Long.valueOf(j)) ? this.routerMap.get(Long.valueOf(j)) : new DefaultEngineRouter();
        this.routerMap.put(Long.valueOf(j), defaultEngineRouter);
        return defaultEngineRouter;
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouterManager
    @Nullable
    public EngineRouter getByWorkerId(String str) {
        for (Long l : this.routerMap.keySet()) {
            l.longValue();
            EngineRouter engineRouter = this.routerMap.get(l);
            if (engineRouter.getWorkerById(str) != null) {
                return engineRouter;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouterManager
    @Nullable
    public EngineRouter remove(EngineRouter engineRouter) {
        try {
            this.routerMap.remove(-1L);
        } catch (Throwable unused) {
        }
        for (Long l : this.routerMap.keySet()) {
            l.longValue();
            if (engineRouter == this.routerMap.get(l)) {
                return this.routerMap.remove(l);
            }
        }
        return null;
    }
}
