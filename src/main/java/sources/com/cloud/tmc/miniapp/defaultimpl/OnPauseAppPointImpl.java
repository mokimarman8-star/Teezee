package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.audio.recording.RecorderClient;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.point.OnPauseAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.ScreenUtils;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OnPauseAppPointImpl implements OnPauseAppPoint {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO00o {
    }

    public void onFinalized() {
        TmcLogger.d("OnPauseAppPointImpl", "onFinalized");
    }

    public void onInitialized() {
        TmcLogger.d("OnPauseAppPointImpl", "onInitialized");
    }

    public void onPause(App app, ExtensionManager extensionManager) {
        HashMap recorderClientCache;
        RecorderClient recorderClient;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        try {
            AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class);
            if (audioRecordCache != null && (recorderClientCache = audioRecordCache.getRecorderClientCache()) != null && (recorderClient = (RecorderClient) recorderClientCache.get(app.getAppId())) != null && !recorderClient.isStopped() && (!recorderClient.isRecording() || !recorderClient.isPaused())) {
                recorderClient.pauseRecording();
            }
            ScreenUtils.INSTANCE.release();
        } catch (Throwable th) {
            TmcLogger.e("OnPauseAppPointImpl", th);
        }
    }
}
