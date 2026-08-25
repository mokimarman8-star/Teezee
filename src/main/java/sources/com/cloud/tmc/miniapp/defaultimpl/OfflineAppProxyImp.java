package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OfflineAppProxyImp implements OfflineAppProxy {
    public ConcurrentLinkedQueue<OfflineAppProxy.CreateShortCutsListener> OooO00o = new ConcurrentLinkedQueue<>();

    public static final class OooO00o implements com.cloud.tmc.miniapp.offlineapps.scan.OooO00o {
        public final /* synthetic */ OfflineAppProxy.Callback OooO00o;

        public OooO00o(OfflineAppProxy.Callback callback) {
            this.OooO00o = callback;
        }

        @Override // com.cloud.tmc.miniapp.offlineapps.scan.OooO00o
        public void result(List<OfflineAppBean> list) {
            Intrinsics.h(list, "offlineApps");
            OfflineAppProxy.Callback callback = this.OooO00o;
            String json = GsonUtils.toJson(list);
            Intrinsics.g(json, "toJson(offlineApps)");
            callback.onSuccess(json);
        }
    }

    public void addShortCutListener(OfflineAppProxy.CreateShortCutsListener createShortCutsListener) {
        Intrinsics.h(createShortCutsListener, "listener");
        try {
            this.OooO00o.add(createShortCutsListener);
            TmcLogger.e("sam", "addShortCutListener: " + this.OooO00o.size());
        } catch (Throwable unused) {
        }
    }

    public void downloadIcon(String str, String str2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "logoUrl");
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "logoUrl");
        com.cloud.tmc.miniapp.offlineapps.download.OooO0O0.OooO00o.OooO00o(str, str2);
    }

    public void getOfflineAppsForBridgeApi(boolean z, OfflineAppProxy.Callback callback) {
        Intrinsics.h(callback, RenderCallContext.TYPE_CALLBACK);
        OooO00o oooO00o = new OooO00o(callback);
        ScanScene scanScene = ScanScene.SCAN_BRIDGEAPI;
        Intrinsics.h(scanScene, "scanScene");
        com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO00o.OooO00o(z, scanScene, oooO00o);
    }

    public void notifyCreateShortCutsSuccess(String str) {
        Intrinsics.h(str, "appId");
        try {
            Iterator<OfflineAppProxy.CreateShortCutsListener> it = this.OooO00o.iterator();
            Intrinsics.g(it, "offlineAppsShortCutListeners.iterator()");
            TmcLogger.e("sam", "notifyCreateShortCutsSuccess:appId:" + str + ", " + this.OooO00o.size());
            while (it.hasNext()) {
                it.next().createSuccess(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void removeShortCutListener(OfflineAppProxy.CreateShortCutsListener createShortCutsListener) {
        Intrinsics.h(createShortCutsListener, "listener");
        try {
            this.OooO00o.remove(createShortCutsListener);
            TmcLogger.e("sam", "removeShortCutListener: " + this.OooO00o.size());
        } catch (Throwable unused) {
        }
    }

    public void scanForOfflineDownloadDelete() {
        ScanScene scanScene = ScanScene.SCAN_DELETE_OFFLINEDOWNLOAD_APP;
        Intrinsics.h(scanScene, "scanScene");
        com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO00o.OooO00o(true, scanScene, null);
    }

    public void scanForOfflineDownloadSuccess() {
        ScanScene scanScene = ScanScene.SCAN_OFFLINEDOWNLOAD_APP;
        Intrinsics.h(scanScene, "scanScene");
        com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO00o.OooO00o(true, scanScene, null);
    }

    public void scanForUsedAppDelete() {
        ScanScene scanScene = ScanScene.SCAN_DELETE_USED_APP;
        Intrinsics.h(scanScene, "scanScene");
        com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO00o.OooO00o(true, scanScene, null);
    }
}
