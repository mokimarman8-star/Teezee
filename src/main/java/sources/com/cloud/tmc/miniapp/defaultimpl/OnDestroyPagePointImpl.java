package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.KeyboardBridge;
import com.cloud.tmc.integration.point.OnDestroyPagePoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OnDestroyPagePointImpl implements OnDestroyPagePoint {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO00o {
    }

    public void onDestroy(App app, Page page, ExtensionManager extensionManager) {
        Intrinsics.h(page, "page");
        if (extensionManager != null) {
            try {
                KeyboardBridge bridgeExtensionByAction = extensionManager.getBridgeExtensionByAction(page, "offKeyboardHeightChange");
                if (bridgeExtensionByAction instanceof KeyboardBridge) {
                    bridgeExtensionByAction.offKeyboardHeightChange(app, page, (BridgeCallback) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onFinalized() {
        TmcLogger.i("OnDestroyPagePointImpl", "onFinalized");
    }

    public void onInitialized() {
        TmcLogger.i("OnDestroyPagePointImpl", "onInitialized");
    }
}
