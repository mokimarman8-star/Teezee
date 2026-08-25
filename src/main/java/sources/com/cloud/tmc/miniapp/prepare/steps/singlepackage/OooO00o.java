package com.cloud.tmc.miniapp.prepare.steps.singlepackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.OooO;
import com.cloud.tmc.miniapp.prepare.steps.OooOO0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0 {
    public boolean OooO = true;

    /* renamed from: com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO00o$OooO00o, reason: collision with other inner class name */
    public class C0025OooO00o implements PackageDownloadCallback {
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ PrepareContext OooO0O0;
        public final /* synthetic */ AppModel OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ PrepareController OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ o000oOoO OooO0oO;

        public C0025OooO00o(boolean z, PrepareContext prepareContext, AppModel appModel, String str, String str2, PrepareController prepareController, o000oOoO o000oooo) {
            this.OooO00o = z;
            this.OooO0O0 = prepareContext;
            this.OooO0OO = appModel;
            this.OooO0Oo = str;
            this.OooO0o0 = str2;
            this.OooO0o = prepareController;
            this.OooO0oO = o000oooo;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "IOException").putData(TmcConstants.TRACK_MPU_ERROR_CODE, "D006").putData(TmcConstants.TRACK_MPU_ERROR_MSG, "Canceled"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th) {
                TmcLogger.e(TmcConstants.TAG, th);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String str2, String str3, IOException iOException, String str4) {
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0O0.getStartContext(), this.OooO0OO, false);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, iOException.getClass().getSimpleName()).putData(TmcConstants.TRACK_MPU_ERROR_CODE, str2).putData(TmcConstants.TRACK_MPU_ERROR_MSG, iOException.getMessage()), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th) {
                TmcLogger.e(TmcConstants.TAG, th);
            }
            if (!this.OooO00o) {
                this.OooO0oO.backgroundDownloadZipAsync(this.OooO0OO, false);
                return;
            }
            if (!TextUtils.isEmpty(this.OooO0Oo) && !TextUtils.isEmpty(this.OooO0o0) && MiniAppLaunch.INSTANCE.compareVersion(this.OooO0o0, this.OooO0Oo)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "DOWNLOAD_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_资源包下载失败，" + str3);
            this.OooO0o.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.OooO0OO.getPackageUrl()));
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(@Nullable String str, String str2) {
            TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_资源包下载完成，进行解压");
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0O0.getStartContext(), this.OooO0OO, true);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "SinglePkgDownloadStep Finish:changeZipDownloadStatus true:downloadUrl:" + str + ";appInfo:appId:" + this.OooO0OO.getAppId() + ";deployVersion:" + this.OooO0OO.getDeployVersion() + ";mainPkgUrl:" + this.OooO0OO.getMainPackageUrl() + ";fullPkgUrl:" + this.OooO0OO.getPackageUrl());
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th) {
                TmcLogger.e(TmcConstants.TAG, th);
            }
            if (this.OooO00o) {
                PrepareController prepareController = this.OooO0o;
                prepareController.unlock(prepareController);
                this.OooO0o.moveToNext();
                return;
            }
            try {
                if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                    com.cloud.tmc.miniapp.utils.OooOO0 oooOO0 = com.cloud.tmc.miniapp.utils.OooOO0.OooO00o;
                    Context startContext = this.OooO0O0.getStartContext();
                    AppModel appModel = this.OooO0OO;
                    Intrinsics.h(startContext, "context");
                    Intrinsics.h(appModel, "appModel");
                    com.cloud.tmc.miniapp.utils.OooOO0.OooO00o(oooOO0, startContext, appModel, false, false, 12);
                }
            } catch (Throwable th2) {
                TmcLogger.e(TmcConstants.TAG, th2);
            }
            this.OooO0oO.backgroundDownloadZipAsync(this.OooO0OO, true);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i, String str2) {
            if (this.OooO00o) {
                TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_下载资源包" + i);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i, String str2, long j, long j2) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i, str2, j, j2);
        }
    }

    public final void OooO00o(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo, AppModel appModel, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        com.cloud.tmc.miniapp.prepare.steps.OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
        bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, z ? 2 : 1);
        if (!prepareContext.getVirtualStart()) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        String packageUrl = appModel.getPackageUrl();
        if (packageUrl == null || packageUrl.isEmpty()) {
            if (!z) {
                o000oooo.backgroundDownloadZipAsync(appModel, false);
            }
            prepareController.moveToError(new PrepareException(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty"));
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (z && !TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, z ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC), TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        int i = z ? 2 : 1;
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("SinglePkgDownloadStep startDownload:downloadUrl:");
        OooO00o.append(appModel.getPackageUrl());
        OooO00o.append(";appInfo:appId:");
        OooO00o.append(appModel.getAppId());
        OooO00o.append(";deployVersion:");
        OooO00o.append(appModel.getDeployVersion());
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, OooO00o.toString());
        this.OooO0OO.downloadApp(appModel, i, true, new C0025OooO00o(z, prepareContext, appModel, miniAppVersion, miniAppVersion2, prepareController, o000oooo));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x011d, code lost:
    
        if (r3.compareVersion(r6, r4) != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023e  */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO0OO(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        boolean offlineCache;
        boolean z;
        AppModel appModelFromPre;
        AppModel appModelFromUsed;
        AppModel appModel = prepareContext.getAppModel();
        if (prepareContext.getDevStatus()) {
            this.OooO = true;
            this.OooO0o0.deleteAllFileForVersion(appModel);
            this.OooO0o0.createBaseDirectory(appModel);
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            appPrepareUtils.changeZipDownloadStatus(prepareContext.getStartContext(), appModel, false);
            appPrepareUtils.changeZipUnCompressStatus(prepareContext.getStartContext(), appModel, false);
            appPrepareUtils.changeTarUnCompressStatus(prepareContext.getStartContext(), appModel, false);
            prepareController.lock(prepareController);
            OooO00o(prepareController, prepareContext, o000oooo, appModel, this.OooO);
            Bundle bundle = new Bundle();
            bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, 2);
            if (prepareContext.getVirtualStart()) {
                return;
            }
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
            return;
        }
        if (this.OooO0OO.isDownloaded(prepareContext.getStartContext(), appModel)) {
            TmcLogger.d(this.OooO00o, "Step_FW_Download_资源包已下载，跳转到解压步骤");
            this.OooO = false;
        } else if (appModel.getFromCacheType() == 3 || appModel.getFromCacheType() == 4) {
            this.OooO0o0.deleteAllFileForVersion(appModel);
            this.OooO0o0.createBaseDirectory(appModel);
            if (appModel.getFromCacheType() == 3) {
                offlineCache = this.OooO0OO.getNativeCache(prepareContext.getStartContext(), appModel);
                TmcLogger.d(this.OooO00o, "use native pkg resource");
                z = false;
            } else {
                offlineCache = this.OooO0OO.getOfflineCache(prepareContext.getStartContext(), appModel);
                TmcLogger.d(this.OooO00o, "use offline pkg resource");
                z = true;
            }
            TmcLogger.d(this.OooO00o, "Step_FW_Download_资源包已下载，跳转到解压步骤->" + offlineCache);
            this.OooO = offlineCache ^ true;
            appModelFromPre = this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId());
            if (appModelFromPre != null && !TextUtils.isEmpty(appModelFromPre.getMainPackageUrl())) {
                TmcLogger.d(this.OooO00o, "DownloadStep preAppinfo is  subpackage,not use");
                appModelFromPre = appModel;
            }
            if (z) {
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                String miniAppVersion = miniAppLaunch.getMiniAppVersion(appModelFromPre);
                String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModel);
                if (!TextUtils.isEmpty(miniAppVersion)) {
                    if (!TextUtils.isEmpty(miniAppVersion2)) {
                    }
                }
            }
            appModel = appModelFromPre;
            if (appModel == null) {
                if (this.OooO0OO.isDownloaded(prepareContext.getStartContext(), appModel)) {
                    MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.INSTANCE;
                    String miniAppVersion3 = miniAppLaunch2.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                    String miniAppVersion4 = miniAppLaunch2.getMiniAppVersion(appModel);
                    if (!TextUtils.isEmpty(miniAppVersion3) && !TextUtils.isEmpty(miniAppVersion4) && miniAppLaunch2.compareVersion(miniAppVersion4, miniAppVersion3)) {
                        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion3).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion4), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
                    }
                    String str = this.OooO00o;
                    StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("appModelFromPre is not null,Download_step_当前版本已有缓存");
                    OooO00o.append(miniAppLaunch2.getMiniAppVersion(appModel));
                    TmcLogger.d(str, OooO00o.toString());
                    prepareContext.setAppModel(appModel);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(ChainPoint.DOWNLOAD_APP_MODE, 1);
                    if (!prepareContext.getVirtualStart()) {
                        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
                    }
                    prepareController.moveToNext();
                    return;
                }
                TmcLogger.d(this.OooO00o, "appModelFromPre is not null,Step_Download_删除当前所有缓存");
                this.OooO0o0.deleteAllFileForVersion(appModel);
                this.OooO0o0.createBaseDirectory(appModel);
                MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.INSTANCE;
                if (miniAppLaunch3.checkFocusUpdateMyByteApp(appModel, 2) && (appModelFromUsed = this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId())) != null) {
                    String miniAppVersion5 = miniAppLaunch3.getMiniAppVersion(appModelFromUsed);
                    String lowestOpenedVersion = appModel.getLowestOpenedVersion();
                    if (miniAppLaunch3.compareVersion(lowestOpenedVersion, miniAppVersion5)) {
                        this.OooO = true;
                        TmcLogger.d(this.OooO00o, "Download_step_当前版本缓存不符合可打开版本号，强制更新最低可打开版本:" + lowestOpenedVersion + "参与比对的版本号:" + miniAppVersion5);
                    } else {
                        String str2 = this.OooO00o;
                        StringBuilder OooO00o2 = com.cloud.tmc.miniapp.OooO00o.OooO00o("Download_step_当前版本缓存符合可打开版本号");
                        OooO00o2.append(miniAppLaunch3.getMiniAppVersion(appModelFromUsed));
                        OooO00o2.append("最低可打开版本号:");
                        OooO00o2.append(lowestOpenedVersion);
                        OooO00o2.append("参与比对的版本号:");
                        OooO00o2.append(miniAppVersion5);
                        TmcLogger.d(str2, OooO00o2.toString());
                        this.OooO = false;
                        prepareContext.setAppModel(appModelFromUsed);
                    }
                }
            } else if (!this.OooO) {
                TmcLogger.d(this.OooO00o, "not need download resource pkg");
                Bundle bundle3 = new Bundle();
                bundle3.putInt(ChainPoint.DOWNLOAD_APP_MODE, 1);
                if (!prepareContext.getVirtualStart()) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
                }
                prepareController.moveToNext();
                return;
            }
            if (this.OooO) {
                TmcLogger.d(this.OooO00o, "need download resource pkg");
                prepareController.lock(prepareController);
            }
            TmcLogger.d(this.OooO00o, "Step_Download_开始下载资源包");
            if (appModel == null) {
                int i = this.OooO ? 2 : 1;
                Bundle bundle4 = new Bundle();
                bundle4.putInt(ChainPoint.DOWNLOAD_APP_MODE, i);
                if (!prepareContext.getVirtualStart()) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
                }
                OooO00o(prepareController, prepareContext, o000oooo, appModel, this.OooO);
            } else if (this.OooO) {
                try {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).remove(prepareContext.getStartContext(), prepareContext.getAppId(), prepareContext.getAppId() + "_pre");
                    this.OooO0O0.refreshUpdateTime(prepareContext.getStartContext(), prepareContext.getAppId(), 0L);
                } catch (Throwable th) {
                    TmcLogger.e(this.OooO00o, th);
                }
                prepareController.moveToError(new PrepareException("appModelFromPre is not exist"));
                return;
            }
            if (this.OooO) {
                Bundle bundle5 = new Bundle();
                bundle5.putInt(ChainPoint.DOWNLOAD_APP_MODE, 1);
                if (!prepareContext.getVirtualStart()) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle5);
                }
                prepareController.moveToNext();
                return;
            }
            return;
        }
        z = false;
        appModelFromPre = this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId());
        if (appModelFromPre != null) {
            TmcLogger.d(this.OooO00o, "DownloadStep preAppinfo is  subpackage,not use");
            appModelFromPre = appModel;
        }
        if (z) {
        }
        appModel = appModelFromPre;
        if (appModel == null) {
        }
        if (this.OooO) {
        }
        TmcLogger.d(this.OooO00o, "Step_Download_开始下载资源包");
        if (appModel == null) {
        }
        if (this.OooO) {
        }
    }
}
