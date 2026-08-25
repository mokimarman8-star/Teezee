package com.cloud.tmc.integration.internalBridge;

import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.a;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.Permission;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class NativeLogBridge implements BridgeExtension {
    private static final String TAG = "NativeLog";

    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void nativeLog(@BindingParam(name = {"msg"}) String str) {
        TmcLogger.e(TAG, str);
    }

    public void onFinalized() {
    }

    public void onInitialized() {
    }

    public Permission permit() {
        return null;
    }
}
