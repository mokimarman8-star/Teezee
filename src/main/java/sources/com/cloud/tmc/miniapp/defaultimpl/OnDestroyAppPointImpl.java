package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.audio.recording.RecorderClient;
import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.bridge.KeyboardBridge;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.integration.bridge.WifiBridge;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.model.FileCache;
import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.model.WebViewStore;
import com.cloud.tmc.integration.point.OnDestroyAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OnDestroyAppPointImpl implements OnDestroyAppPoint {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO00o {
    }

    public void onDestroy(App app, ExtensionManager extensionManager) {
        WeakHashMap pageCache;
        Iterator it;
        HashMap store;
        BridgeCallback bridgeCallback;
        BridgeCallback bridgeCallback2;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        if (extensionManager != null) {
            try {
                ForegroundAudioBridge bridgeExtensionByAction = extensionManager.getBridgeExtensionByAction(app, "releaseAppAudio");
                if (bridgeExtensionByAction instanceof ForegroundAudioBridge) {
                    bridgeExtensionByAction.releaseAppAudio(app);
                }
                AudioEffectBridge bridgeExtensionByAction2 = extensionManager.getBridgeExtensionByAction(app, "releaseAppAudioEffect");
                if (bridgeExtensionByAction2 instanceof AudioEffectBridge) {
                    bridgeExtensionByAction2.releaseAppAudioEffect(app);
                }
            } catch (Throwable th) {
                TmcLogger.e("OnDestroyAppPoint", th);
            }
        }
        if (extensionManager != null) {
            try {
                KeyboardBridge bridgeExtensionByAction3 = extensionManager.getBridgeExtensionByAction(app, "offKeyboardHeightChange");
                if (bridgeExtensionByAction3 instanceof KeyboardBridge) {
                    bridgeExtensionByAction3.checkEventSubscriber(app, false);
                }
            } catch (Throwable th2) {
                TmcLogger.e("OnDestroyAppPointImpl", "releaseKeyboardBridge", th2);
            }
        }
        if (extensionManager != null) {
            try {
                WifiBridge bridgeExtensionByAction4 = extensionManager.getBridgeExtensionByAction(app, "destroyAppWifi");
                if (bridgeExtensionByAction4 instanceof WifiBridge) {
                    bridgeExtensionByAction4.destroyAppWifi(app);
                }
            } catch (Throwable th3) {
                TmcLogger.e("OnDestroyAppPointImpl", "OnDestroyAppPoint", th3);
            }
        }
        if (extensionManager != null) {
            try {
                NetworkBridge bridgeExtensionByAction5 = extensionManager.getBridgeExtensionByAction(app, "onNetworkStatusChange");
                if (bridgeExtensionByAction5 instanceof NetworkBridge) {
                    bridgeExtensionByAction5.clearNetworkChangeListenModel(app);
                }
            } catch (Throwable th4) {
                TmcLogger.e("OnDestroyAppPointImpl", "onNetworkStatusChange", th4);
            }
        }
        try {
            AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class);
            if (audioRecordCache != null) {
                BridgeCallback bridgeCallback3 = (BridgeCallback) audioRecordCache.getOnStarts().remove(app.getAppId());
                if (bridgeCallback3 != null) {
                    bridgeCallback3.close();
                }
                BridgeCallback bridgeCallback4 = (BridgeCallback) audioRecordCache.getOnStops().remove(app.getAppId());
                if (bridgeCallback4 != null) {
                    bridgeCallback4.close();
                }
                BridgeCallback bridgeCallback5 = (BridgeCallback) audioRecordCache.getOnPauses().remove(app.getAppId());
                if (bridgeCallback5 != null) {
                    bridgeCallback5.close();
                }
                BridgeCallback bridgeCallback6 = (BridgeCallback) audioRecordCache.getOnResumes().remove(app.getAppId());
                if (bridgeCallback6 != null) {
                    bridgeCallback6.close();
                }
                BridgeCallback bridgeCallback7 = (BridgeCallback) audioRecordCache.getOnErrors().remove(app.getAppId());
                if (bridgeCallback7 != null) {
                    bridgeCallback7.close();
                }
                RecorderClient recorderClient = (RecorderClient) audioRecordCache.getRecorderClientCache().remove(app.getAppId());
                if (recorderClient != null && !recorderClient.isStopped()) {
                    recorderClient.stopRecording();
                }
            }
        } catch (Throwable th5) {
            TmcLogger.e("OnDestroyAppPointImpl", th5);
        }
        try {
            WebViewStore webViewStore = (WebViewStore) app.getData(WebViewStore.class);
            if (webViewStore != null && (bridgeCallback2 = (BridgeCallback) webViewStore.getOnDownloads().remove(app.getAppId())) != null) {
                bridgeCallback2.close();
            }
        } catch (Throwable th6) {
            TmcLogger.e("OnDestroyAppPointImpl", th6);
        }
        try {
            FileCache fileCache = (FileCache) app.getData(FileCache.class);
            if (fileCache != null) {
                fileCache.getFileCache().clear();
                fileCache.getFlags().clear();
            }
        } catch (Throwable th7) {
            TmcLogger.e("OnDestroyAppPointImpl", th7);
        }
        AddToHomeScreenStore addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class);
        if (addToHomeScreenStore != null && (store = addToHomeScreenStore.getStore()) != null && (bridgeCallback = (BridgeCallback) store.remove(app.getAppId())) != null) {
            bridgeCallback.sendFailResponse();
        }
        TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class);
        if (tabReSelectedStore != null && (pageCache = tabReSelectedStore.getPageCache()) != null && (it = pageCache.entrySet().iterator()) != null) {
            while (it.hasNext()) {
                ((BridgeCallback) ((Map.Entry) it.next()).getValue()).close();
                it.remove();
            }
        }
        if (extensionManager != null) {
            try {
                BridgeExtension bridgeExtensionByAction6 = extensionManager.getBridgeExtensionByAction(app, "changePrefetchStatus");
                if (bridgeExtensionByAction6 instanceof PrefetchStrategyBridge) {
                    ((PrefetchStrategyBridge) bridgeExtensionByAction6).changePrefetchStatus(app);
                }
            } catch (Throwable th8) {
                try {
                    TmcLogger.e("OnDestroyAppPointImpl", "releaseKeyboardBridge", th8);
                } catch (Throwable th9) {
                    TmcLogger.e("OnDestroyAppPointImpl", th9);
                }
            }
        }
    }

    public void onFinalized() {
        TmcLogger.d("OnDestroyAppPointImpl", "onFinalized");
    }

    public void onInitialized() {
        TmcLogger.d("OnDestroyAppPointImpl", "onInitialized");
    }
}
