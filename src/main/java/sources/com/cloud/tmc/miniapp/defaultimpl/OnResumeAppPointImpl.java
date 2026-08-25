package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.point.OnResumeAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OnResumeAppPointImpl implements OnResumeAppPoint {
    public void onFinalized() {
    }

    public void onInitialized() {
    }

    public void onResume(App app, ExtensionManager extensionManager) {
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        if (extensionManager != null) {
            try {
                ForegroundAudioBridge bridgeExtensionByAction = extensionManager.getBridgeExtensionByAction(app, "restoreAppAudio");
                if (bridgeExtensionByAction instanceof ForegroundAudioBridge) {
                    bridgeExtensionByAction.restoreAppAudio(app);
                }
                AudioEffectBridge bridgeExtensionByAction2 = extensionManager.getBridgeExtensionByAction(app, "restoreAppAudioEffect");
                if (bridgeExtensionByAction2 instanceof AudioEffectBridge) {
                    bridgeExtensionByAction2.restoreAppAudioEffect(app);
                }
            } catch (Throwable th) {
                TmcLogger.e("OnResumeAppPoint", th);
            }
        }
    }
}
