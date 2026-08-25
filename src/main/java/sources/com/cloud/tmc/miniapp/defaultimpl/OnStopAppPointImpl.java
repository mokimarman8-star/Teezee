package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.point.OnStopAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OnStopAppPointImpl implements OnStopAppPoint {
    public void onFinalized() {
    }

    public void onInitialized() {
    }

    public void onStop(App app, ExtensionManager extensionManager) {
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        if (app.isDestroyed() || extensionManager == null) {
            return;
        }
        try {
            ForegroundAudioBridge bridgeExtensionByAction = extensionManager.getBridgeExtensionByAction(app, "pauseAppAudio");
            if (bridgeExtensionByAction instanceof ForegroundAudioBridge) {
                bridgeExtensionByAction.pauseAppAudio(app);
            }
            AudioEffectBridge bridgeExtensionByAction2 = extensionManager.getBridgeExtensionByAction(app, "stopAppAudioEffect");
            if (bridgeExtensionByAction2 instanceof AudioEffectBridge) {
                bridgeExtensionByAction2.stopAppAudioEffect(app);
            }
        } catch (Throwable th) {
            TmcLogger.e("OnResumeAppPoint", th);
        }
    }
}
