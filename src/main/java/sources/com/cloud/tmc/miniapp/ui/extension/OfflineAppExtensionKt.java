package com.cloud.tmc.miniapp.ui.extension;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0;
import com.cloud.tmc.miniapp.widget.MiniNoNetworkView;
import com.cloud.tmc.miniapp.widget.OfflineAppView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OfflineAppExtensionKt {
    private static final String TAG = "OfflineAppExtension";
    private static final int offlineAppViews = 4;

    public static final void createShortCutsSuccess(MiniNoNetworkView miniNoNetworkView, String str, LinearLayout linearLayout, Function3<? super String, ? super String, ? super String, Unit> function3) {
        Intrinsics.h(miniNoNetworkView, "<this>");
        Intrinsics.h(str, "appId");
        realCreateShortCutsSuccess(str, linearLayout, function3);
    }

    public static final void createShortCutsSuccess(StatusLayout statusLayout, String str, LinearLayout linearLayout, Function3<? super String, ? super String, ? super String, Unit> function3) {
        Intrinsics.h(statusLayout, "<this>");
        Intrinsics.h(str, "appId");
        realCreateShortCutsSuccess(str, linearLayout, function3);
    }

    public static final void offlineAppOnResume(MiniNoNetworkView miniNoNetworkView, LinearLayout linearLayout) {
        Intrinsics.h(miniNoNetworkView, "<this>");
        realOfflineAppOnResume(linearLayout);
    }

    public static final void offlineAppOnResume(StatusLayout statusLayout, LinearLayout linearLayout) {
        Intrinsics.h(statusLayout, "<this>");
        realOfflineAppOnResume(linearLayout);
    }

    public static final void offlineAppUpdate(MiniNoNetworkView miniNoNetworkView, Context context, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout) {
        Intrinsics.h(miniNoNetworkView, "<this>");
        Intrinsics.h(context, "context");
        realOfflineAppUpdate(context, linearLayout, linearLayout2, constraintLayout);
    }

    public static final void offlineAppUpdate(StatusLayout statusLayout, Context context, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout) {
        Intrinsics.h(statusLayout, "<this>");
        Intrinsics.h(context, "context");
        realOfflineAppUpdate(context, linearLayout, linearLayout2, constraintLayout);
    }

    private static final void realCreateShortCutsSuccess(String str, LinearLayout linearLayout, Function3<? super String, ? super String, ? super String, Unit> function3) {
        try {
            int i = offlineAppViews;
            for (int i2 = 0; i2 < i; i2++) {
                KeyEvent.Callback callback = linearLayout != null ? ViewGroupKt.get(linearLayout, i2) : null;
                OfflineAppView offlineAppView = callback instanceof OfflineAppView ? (OfflineAppView) callback : null;
                if (offlineAppView != null) {
                    offlineAppView.OooO00o(str, function3);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "offlineAppOnResume fail:", th);
        }
    }

    private static final void realOfflineAppOnResume(LinearLayout linearLayout) {
        try {
            int i = offlineAppViews;
            for (int i2 = 0; i2 < i; i2++) {
                View view = linearLayout != null ? ViewGroupKt.get(linearLayout, i2) : null;
                OfflineAppView offlineAppView = view instanceof OfflineAppView ? (OfflineAppView) view : null;
                if (offlineAppView != null) {
                    offlineAppView.OooO00o(null, null);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "offlineAppOnResume fail:", th);
        }
    }

    private static final void realOfflineAppUpdate(Context context, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout) {
        int networkStatus = NetworkUtils.getNetworkStatus();
        if (networkStatus == 1) {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            TmcLogger.d(TAG, "NetworkUtils.getNetworkStatus:" + networkStatus);
            return;
        }
        if (!((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_OFFLINE_APPS_SWITCH, true)) {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            TmcLogger.d(TAG, "offlineAppsSwitch is close");
        } else {
            ScanScene scanScene = ScanScene.SCAN_PINFORLATER;
            OfflineAppExtensionKt$realOfflineAppUpdate$1 offlineAppExtensionKt$realOfflineAppUpdate$1 = new OfflineAppExtensionKt$realOfflineAppUpdate$1(constraintLayout, linearLayout, linearLayout2, context);
            Intrinsics.h(scanScene, "scanScene");
            OooO0O0.OooO00o.OooO00o(false, scanScene, offlineAppExtensionKt$realOfflineAppUpdate$1);
        }
    }
}
