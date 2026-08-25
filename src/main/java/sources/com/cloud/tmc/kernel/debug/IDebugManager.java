package com.cloud.tmc.kernel.debug;

import com.cloud.tmc.kernel.proxy.Proxiable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IDebugManager extends Proxiable {
    void addObserver(Object obj, DebugCallback debugCallback);

    void notifyObserver();

    void removeObserver(Object obj);
}
