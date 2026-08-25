package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/cloud/tmc/integration/bridge/CommunicationBridge;", "Lcom/cloud/tmc/kernel/extension/BridgeExtension;", "()V", "onFinalized", "", "onInitialized", "openByteBridge", EventConstants.ABILITY_NAME_CALLBACK, "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "permit", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class CommunicationBridge implements BridgeExtension {
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    public void onFinalized() {
    }

    public void onInitialized() {
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void openByteBridge(@BindingCallback BridgeCallback callback) {
        String configTargetStr = MiniAppConfigHelper.INSTANCE.getConfigTargetStr("byteBridge", MiniAppConfigHelper.DEFAULT_BYTEBRIDGE);
        if (configTargetStr == null) {
            if (callback != null) {
                callback.sendFailResponse();
            }
        } else if (callback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("data", configTargetStr);
            callback.sendSuccessResponse(jsonObject);
        }
    }

    public Void permit() {
        return null;
    }
}
