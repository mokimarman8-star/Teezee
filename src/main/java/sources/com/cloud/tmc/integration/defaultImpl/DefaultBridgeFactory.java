package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.structure.impl.DefaultNativeBridge;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.proxy.IBridgeFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DefaultBridgeFactory implements IBridgeFactory {
    public NativeBridge createNativeBridge() {
        return new DefaultNativeBridge();
    }
}
