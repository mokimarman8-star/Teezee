package com.cloud.tmc.integration.core;

import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.core.IEngineFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TmcEngineFactory implements IEngineFactory {
    public static final String ENGINE_TYPE_DEFAULT = "default";

    public IEngine createEngine(String str, Node node, String str2) {
        return new TmcEngineImpl(str2, node);
    }

    public String getEngineType(String str) {
        return "default";
    }
}
