package com.cloud.tmc.miniapp.prepare.impl;

import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.OooOOO;
import com.cloud.tmc.miniutils.util.ResourceUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.utils.Utils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TmcAppInfoManagerImpl implements TmcAppInfoManager, IAppInfoManagerProxy {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO00o {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076 A[Catch: all -> 0x001b, TryCatch #1 {all -> 0x001b, blocks: (B:51:0x0014, B:13:0x0022, B:15:0x0028, B:18:0x0032, B:21:0x003e, B:24:0x0047, B:27:0x004e, B:30:0x0056, B:32:0x0076, B:34:0x007c, B:35:0x0094, B:38:0x009a, B:41:0x00a1, B:44:0x00a9, B:46:0x00c9), top: B:50:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #1 {all -> 0x001b, blocks: (B:51:0x0014, B:13:0x0022, B:15:0x0028, B:18:0x0032, B:21:0x003e, B:24:0x0047, B:27:0x004e, B:30:0x0056, B:32:0x0076, B:34:0x007c, B:35:0x0094, B:38:0x009a, B:41:0x00a1, B:44:0x00a9, B:46:0x00c9), top: B:50:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AppModel OooO00o(Context context, String str, AppModel appModel) {
        boolean z;
        AppInfoModel appModelFromCDN;
        MiniAppLaunch miniAppLaunch;
        AppModel generateAppModel;
        String str2;
        String miniAppVersion;
        String miniAppVersion2;
        boolean compareVersion;
        String miniAppVersion3;
        String miniAppVersion4;
        boolean compareVersion2;
        boolean z2 = false;
        try {
            z = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_APPINFO_ENABLE_CDN, false);
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            return null;
        }
        if (str != null) {
            try {
                if (str.length() == 0) {
                }
            } catch (Throwable th) {
                TmcLogger.e("TmcAppInfoManagerImpl", th);
            }
            if (z2 && (appModelFromCDN = getAppModelFromCDN(context, str)) != null && (generateAppModel = (miniAppLaunch = MiniAppLaunch.INSTANCE).generateAppModel(appModelFromCDN)) != null) {
                generateAppModel.setFromCacheType(6);
                str2 = "";
                if (appModel != null && !AppPrepareUtils.INSTANCE.isShellType(generateAppModel)) {
                    miniAppVersion3 = miniAppLaunch.getMiniAppVersion(generateAppModel);
                    if (miniAppVersion3 == null) {
                        miniAppVersion3 = "";
                    }
                    miniAppVersion4 = miniAppLaunch.getMiniAppVersion(appModel);
                    if (miniAppVersion4 == null) {
                        str2 = miniAppVersion4;
                    }
                    compareVersion2 = miniAppLaunch.compareVersion(miniAppVersion3, str2);
                    TmcLogger.d("TmcAppInfoManagerImpl", "appId ->" + str + ",cdn appinfo compare result " + compareVersion2);
                    if (compareVersion2) {
                        if (appModel.getFromCacheType() != 1) {
                            TmcLogger.d("TmcAppInfoManagerImpl", "update pre appinfo use cdn");
                            updateAppModel(context, generateAppModel, str + "_pre");
                        } else {
                            TmcLogger.d("TmcAppInfoManagerImpl", "current appinfo from pre,not update cdn appinfo ");
                        }
                    }
                    return null;
                }
                miniAppVersion = miniAppLaunch.getMiniAppVersion(generateAppModel);
                if (miniAppVersion == null) {
                    miniAppVersion = "";
                }
                miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModel);
                if (miniAppVersion2 == null) {
                    str2 = miniAppVersion2;
                }
                compareVersion = miniAppLaunch.compareVersion(miniAppVersion, str2);
                TmcLogger.d("TmcAppInfoManagerImpl", "appModel is null,appId ->" + str + ",cdn appinfo compare result " + compareVersion);
                if (compareVersion) {
                    updateAppModel(context, generateAppModel, str + "_pre");
                    ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(str, TmcConstants.CHANNEL_REQUEST_CDN);
                    return generateAppModel;
                }
                return null;
            }
            return null;
        }
        z2 = true;
        if (z2) {
            return null;
        }
        generateAppModel.setFromCacheType(6);
        str2 = "";
        if (appModel != null) {
            miniAppVersion3 = miniAppLaunch.getMiniAppVersion(generateAppModel);
            if (miniAppVersion3 == null) {
            }
            miniAppVersion4 = miniAppLaunch.getMiniAppVersion(appModel);
            if (miniAppVersion4 == null) {
            }
            compareVersion2 = miniAppLaunch.compareVersion(miniAppVersion3, str2);
            TmcLogger.d("TmcAppInfoManagerImpl", "appId ->" + str + ",cdn appinfo compare result " + compareVersion2);
            if (compareVersion2) {
            }
            return null;
        }
        miniAppVersion = miniAppLaunch.getMiniAppVersion(generateAppModel);
        if (miniAppVersion == null) {
        }
        miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModel);
        if (miniAppVersion2 == null) {
        }
        compareVersion = miniAppLaunch.compareVersion(miniAppVersion, str2);
        TmcLogger.d("TmcAppInfoManagerImpl", "appModel is null,appId ->" + str + ",cdn appinfo compare result " + compareVersion);
        if (compareVersion) {
        }
        return null;
    }

    public final String OooO00o(Context context, String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, str, str2);
    }

    public final void OooO00o(AppModel appModel, AppModel appModel2, Context context, AppModel appModel3) {
        if (Intrinsics.c(appModel.getPackageUrl_MD5(), appModel2 != null ? appModel2.getPackageUrl_MD5() : null)) {
            TmcLogger.d("TmcAppInfoManagerImpl", "url 地址一致，不删除旧版本包");
            return;
        }
        TmcLogger.d("TmcAppInfoManagerImpl", "packageUrl_MD5 old -> " + appModel.getPackageUrl_MD5() + ",current-> " + appModel3.getPackageUrl_MD5() + ",used -> " + (appModel2 != null ? appModel2.getPackageUrl_MD5() : null));
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "删除全部" + appModel.getPackageUrl_MD5() + ",currentAppVersion:" + appModel3.getDeployVersion() + "，oldAppVersion：" + appModel.getDeployVersion() + ",usedAppVersion:" + (appModel2 != null ? appModel2.getDeployVersion() : null));
        SubpackageAppPrepareUtils.clearAllFilesForVersion$default(SubpackageAppPrepareUtils.INSTANCE, context, appModel, (String) null, 4, (Object) null);
    }

    public final AppModel OooO0O0(Context context, String str, AppModel appModel) {
        AppInfoModel appModelFromConfig;
        MiniAppLaunch miniAppLaunch;
        AppModel generateAppModel;
        if (str != null) {
            try {
                if (str.length() != 0 && (appModelFromConfig = getAppModelFromConfig(context, str)) != null && (generateAppModel = (miniAppLaunch = MiniAppLaunch.INSTANCE).generateAppModel(appModelFromConfig)) != null) {
                    generateAppModel.setFromCacheType(5);
                    String str2 = "";
                    if (appModel != null && !AppPrepareUtils.INSTANCE.isShellType(generateAppModel)) {
                        String miniAppVersion = miniAppLaunch.getMiniAppVersion(generateAppModel);
                        if (miniAppVersion == null) {
                            miniAppVersion = "";
                        }
                        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModel);
                        if (miniAppVersion2 != null) {
                            str2 = miniAppVersion2;
                        }
                        boolean compareVersion = miniAppLaunch.compareVersion(miniAppVersion, str2);
                        TmcLogger.d("TmcAppInfoManagerImpl", "appid ->" + str + ",config appinfo compare result " + compareVersion);
                        if (compareVersion) {
                            if (appModel.getFromCacheType() != 1) {
                                TmcLogger.d("TmcAppInfoManagerImpl", "update pre appinfo use config");
                                updateAppModel(context, generateAppModel, str + "_pre");
                            } else {
                                TmcLogger.d("TmcAppInfoManagerImpl", "current appinfo from pre,not update config");
                            }
                        }
                    }
                    TmcLogger.d("TmcAppInfoManagerImpl", "appmodel is null ,use config appinfo");
                    String miniAppVersion3 = miniAppLaunch.getMiniAppVersion(generateAppModel);
                    if (miniAppVersion3 == null) {
                        miniAppVersion3 = "";
                    }
                    String miniAppVersion4 = miniAppLaunch.getMiniAppVersion(appModel);
                    if (miniAppVersion4 != null) {
                        str2 = miniAppVersion4;
                    }
                    boolean compareVersion2 = miniAppLaunch.compareVersion(miniAppVersion3, str2);
                    TmcLogger.d("TmcAppInfoManagerImpl", "appmodel == null,appid ->" + str + ",config appinfo compare result " + compareVersion2);
                    if (compareVersion2) {
                        updateAppModel(context, generateAppModel, str + "_pre");
                        ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(str, "config");
                        return generateAppModel;
                    }
                }
                return null;
            } catch (Throwable th) {
                TmcLogger.e("TmcAppInfoManagerImpl", "getAppModelFromConfig", th);
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void delectOldVersionFilesAndUpdate(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        String appId = appModel.getAppId();
        if (appId == null) {
            appId = "";
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        TmcLogger.d("TmcAppInfoManagerImpl", "当次->" + appId + "," + miniAppLaunch.getMiniAppVersion(appModel));
        String appId2 = appModel.getAppId();
        if (appId2 == null) {
            appId2 = "";
        }
        AppModel appModelFromOld = getAppModelFromOld(context, appId2);
        if (appModelFromOld != null) {
            TmcLogger.d("TmcAppInfoManagerImpl", "删除_" + miniAppLaunch.getMiniAppVersion(appModelFromOld));
            String appId3 = appModel.getAppId();
            if (appId3 == null) {
                appId3 = "";
            }
            AppModel appModelFromUsed = getAppModelFromUsed(context, appId3);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "delectOldVersionFilesAndUpdate,oldVersion:" + appModelFromOld.getDeployVersion() + ",oldUrl:" + appModelFromOld.getPackageUrl_MD5() + "，currentAppVersion：" + appModel.getDeployVersion() + ",currentUrl:" + appModel.getPackageUrl_MD5() + ",usedAppVersion:" + (appModelFromUsed != null ? appModelFromUsed.getDeployVersion() : null) + ",usedUrl:" + (appModelFromUsed != null ? appModelFromUsed.getPackageUrl_MD5() : null));
            if (!Intrinsics.c(appModelFromOld.getPackageUrl_MD5(), appModel.getPackageUrl_MD5())) {
                if (!Intrinsics.c(appModelFromOld.getPackageUrl_MD5(), appModelFromUsed != null ? appModelFromUsed.getPackageUrl_MD5() : null)) {
                    AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModelFromOld);
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "删除旧版本全量包:" + appModelFromOld.getPackageUrl_MD5() + "，currentAppVersion：" + appModel.getDeployVersion() + ",oldAppVersion:" + appModelFromOld.getDeployVersion() + ",usedAppVersion:" + (appModelFromUsed != null ? appModelFromUsed.getDeployVersion() : null));
                }
            }
            TmcLogger.d("TmcAppInfoManagerImpl", "全量包 url 版本一致,不删除");
        }
        String appId4 = appModel.getAppId();
        AppModel appModelFromUsed2 = getAppModelFromUsed(context, appId4 != null ? appId4 : "");
        if (appModelFromUsed2 != null) {
            updateAppModel(context, appModelFromUsed2, appModelFromUsed2.getAppId() + "_old");
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appID:" + appModelFromUsed2.getAppId() + " updateAppModel version:" + miniAppLaunch.getMiniAppVersion(appModelFromUsed2) + " to old");
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void deleteOldVersionFiles(Context context, AppModel appModel, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        String appId = appModel.getAppId();
        if (appId == null) {
            appId = "";
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        TmcLogger.d("TmcAppInfoManagerImpl", "当次->" + appId + "," + miniAppLaunch.getMiniAppVersion(appModel));
        String appId2 = appModel.getAppId();
        if (appId2 == null) {
            appId2 = "";
        }
        AppModel appModelFromOld = getAppModelFromOld(context, appId2);
        if (appModelFromOld != null) {
            TmcLogger.d("TmcAppInfoManagerImpl", "删除_" + miniAppLaunch.getMiniAppVersion(appModelFromOld));
            String appId3 = appModel.getAppId();
            AppModel subpackageAppModelFromUsed = getSubpackageAppModelFromUsed(context, appId3 != null ? appId3 : "");
            OooO00o(appModelFromOld, subpackageAppModelFromUsed, context, appModel);
            String miniAppVersion = miniAppLaunch.getMiniAppVersion(appModel);
            String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(subpackageAppModelFromUsed);
            if (subpackageAppModelFromUsed == null || miniAppVersion == null || miniAppVersion.length() == 0 || miniAppVersion2 == null || miniAppVersion2.length() == 0 || !z || !miniAppLaunch.compareVersion(miniAppVersion, miniAppVersion2)) {
                return;
            }
            OooO00o(subpackageAppModelFromUsed, appModel, context, appModel);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public String findUrlMappedAppId(Context context, String str) {
        Intrinsics.h(context, "context");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppInfoModel(Context context, AppInfoQuery appInfoQuery) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appInfoQuery, "query");
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, appInfoQuery.getAppId(), "APP_INFO_MODEL");
        if (string == null || string.length() == 0) {
            return null;
        }
        return (AppInfoModel) JsonUtil.INSTANCE.fromJson(string, AppInfoModel.class);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModel(Context context, AppInfoQuery appInfoQuery) {
        boolean checkZipDownloadStatus;
        Intrinsics.h(context, "context");
        Intrinsics.h(appInfoQuery, "query");
        AppModel OooO00o2 = com.cloud.tmc.miniapp.prestrategy.strategy.OooO00o.OooO00o.OooO00o(appInfoQuery.getAppId());
        if (OooO00o2 != null) {
            TmcLogger.d("TmcAppInfoManagerImpl", "getPreAppinfoModel from memory");
            return OooO00o2;
        }
        AppModel appModelFromPre = getAppModelFromPre(context, appInfoQuery.getAppId());
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "get preAppModel,appVersion:" + (appModelFromPre != null ? appModelFromPre.getDeployVersion() : null));
        if (appModelFromPre != null) {
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            if (!appPrepareUtils.isShellType(appModelFromPre) && !(checkZipDownloadStatus = appPrepareUtils.checkZipDownloadStatus(context, appModelFromPre))) {
                if (OooOOO.OooO00o(appModelFromPre)) {
                    checkZipDownloadStatus = appPrepareUtils.checkZipDownloadStatus(context, appModelFromPre.getAppId(), appModelFromPre.getMainPackageUrlEncryption());
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "get preAppModel,appVersion:" + appModelFromPre.getDeployVersion() + ",downloaded");
                }
                if (!checkZipDownloadStatus) {
                    appModelFromPre = null;
                }
            }
        }
        if (appModelFromPre == null) {
            appModelFromPre = getAppModelFromUsed(context, appInfoQuery.getAppId());
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "get usedAppModel,appVersion:" + (appModelFromPre != null ? appModelFromPre.getDeployVersion() : null));
        }
        if (appModelFromPre != null && appModelFromPre.isTestVersion()) {
            TmcLogger.e("TmcAppInfoManagerImpl", "当前使用的非正式版本，不启用替换内置和 cdn、config 能力");
            return appModelFromPre;
        }
        AppModel appModelFromPackage = getAppModelFromPackage(context, appInfoQuery.getAppId());
        if (appModelFromPackage != null) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            String miniAppVersion = miniAppLaunch.getMiniAppVersion(appModelFromPackage);
            if (miniAppVersion == null) {
                miniAppVersion = "0";
            }
            String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModelFromPre);
            if (miniAppVersion2 == null) {
                miniAppVersion2 = "0";
            }
            boolean compareVersion = miniAppLaunch.compareVersion(miniAppVersion, miniAppVersion2);
            if (appModelFromPre == null || compareVersion) {
                resetAppPreModel(context, appInfoQuery.getAppId());
                appModelFromPre = appModelFromPackage;
            }
        }
        if (!Intrinsics.c(appInfoQuery.getAppId(), "100000")) {
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "getAppModel,appVersion:" + (appModelFromPre != null ? appModelFromPre.getDeployVersion() : null));
            String appId = appInfoQuery.getAppId();
            String miniAppVersion3 = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModelFromPre);
            AppModel appModelFromOffline = getAppModelFromOffline(context, appId, miniAppVersion3 != null ? miniAppVersion3 : "0");
            if (appModelFromOffline != null) {
                appModelFromPre = appModelFromOffline;
            }
        }
        AppModel OooO0O0 = OooO0O0(context, appInfoQuery.getAppId(), appModelFromPre);
        if (OooO0O0 != null) {
            appModelFromPre = OooO0O0;
        }
        AppModel OooO00o3 = OooO00o(context, appInfoQuery.getAppId(), appModelFromPre);
        return OooO00o3 != null ? OooO00o3 : appModelFromPre;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppModelFromCDN(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        String OooO00o2 = OooO00o(context, str, str + "_cdn");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            return (AppInfoModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppInfoModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppModelFromConfig(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        String OooO00o2 = OooO00o(context, str, str + "_config");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            return (AppInfoModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppInfoModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromDev(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        if (!AppDynamicBuildConfig.getDEV_MODE()) {
            return null;
        }
        String OooO00o2 = OooO00o(context, str, str + "_dev");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppModel.class);
            appModel.setFromCacheType(1);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromOffline(Context context, String str, String str2) {
        String appVersionFromOfflinePkgCache;
        OffPkgConfig manifest;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "currentVersion");
        if (!ProcessUtils.isMiniProcess()) {
            TmcLogger.d("TmcAppInfoManagerImpl", "getAppModelFromOffline failed! current process is not miniProcess");
            return null;
        }
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "getAppModelFromOffline,appVersion:" + str2);
        OfflinePkgCachePath offlinePkgFwCachePath = OfflineManager.getOfflinePkgFwCachePath(str);
        if (offlinePkgFwCachePath == null || (appVersionFromOfflinePkgCache = Utils.INSTANCE.getAppVersionFromOfflinePkgCache(offlinePkgFwCachePath)) == null) {
            return null;
        }
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "getAppModelFromOffline,appVersion:" + str2 + ",offlineAppVersion:" + appVersionFromOfflinePkgCache);
        if (Intrinsics.c(appVersionFromOfflinePkgCache, str2) || MiniAppLaunch.INSTANCE.compareVersion(appVersionFromOfflinePkgCache, str2)) {
            List<ZipFileInfo> zipFileInfo = offlinePkgFwCachePath.getZipFileInfo();
            ZipFileInfo zipFileInfo2 = zipFileInfo != null ? (ZipFileInfo) CollectionsKt.i0(zipFileInfo) : null;
            AppInfoModel appInfo = (zipFileInfo2 == null || (manifest = zipFileInfo2.getManifest()) == null) ? null : manifest.getAppInfo();
            AppModel generateAppModel = appInfo != null ? MiniAppLaunch.INSTANCE.generateAppModel(appInfo) : null;
            if (generateAppModel != null) {
                generateAppModel.setZipPath((zipFileInfo2 != null ? zipFileInfo2.getZipUnCompressPath() : null) + "/" + str + ".zip");
            }
            if (generateAppModel != null) {
                generateAppModel.setFromCacheType(4);
                TmcLogger.d("TmcAppInfoManagerImpl", str + ":" + appVersionFromOfflinePkgCache + " -> 命中离线包");
                return generateAppModel;
            }
            TmcLogger.d("TmcAppInfoManagerImpl", str + ":" + appVersionFromOfflinePkgCache + " -> offlineModel 为空,不使用离线包");
        } else {
            TmcLogger.d("TmcAppInfoManagerImpl", str + ":" + appVersionFromOfflinePkgCache + " 离线包版本号未大于或等于当前资源包 " + str2 + " ,不使用离线包");
        }
        return null;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromOld(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        if (str.length() == 0) {
            return null;
        }
        String OooO00o2 = OooO00o(context, str, str + "_old");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppModel.class);
            appModel.setFromCacheType(2);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromPackage(Context context, String str) {
        AppModel appModel;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        String str2 = "";
        try {
            str2 = OooO00o(context, str, str + "_native_" + GlobalPackageConfig.Companion.getSDK_DEV_VERSION());
            if (str2 == null || str2.length() <= 0) {
                appModel = null;
            } else {
                appModel = (AppModel) JsonUtil.INSTANCE.fromJson(str2, AppModel.class);
                appModel.setFromCacheType(3);
            }
            if (appModel != null) {
                return appModel;
            }
        } catch (Throwable th) {
            TmcLogger.e("TmcAppInfoManagerImpl", "getAppModelFromPackage", th);
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        GlobalPackageConfig.Companion companion = GlobalPackageConfig.Companion;
        boolean z = false;
        if (kVStorageProxy.getBoolean(context, str, "isReadAssets_" + str + "_" + companion.getSDK_DEV_VERSION(), false)) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = ResourceUtils.readAssets2String("mini_offline/" + str + "/" + str + ".json");
            z = true;
        }
        try {
            AppModel appModel2 = (AppModel) JsonUtil.INSTANCE.fromJson(str2, AppModel.class);
            appModel2.setFromCacheType(3);
            if (z) {
                updateAppModel(context, appModel2, str + "_native_" + companion.getSDK_DEV_VERSION());
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, str, "isReadAssets_" + str + "_" + companion.getSDK_DEV_VERSION(), true);
            }
            return appModel2;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromPre(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        String OooO00o2 = OooO00o(context, str, str + "_pre");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppModel.class);
            appModel.setFromCacheType(1);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromUsed(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        if (str.length() == 0) {
            return null;
        }
        String OooO00o2 = OooO00o(context, str, str + "_used");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppModel.class);
            appModel.setFromCacheType(2);
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            boolean checkZipDownloadStatus = appPrepareUtils.checkZipDownloadStatus(context, str, appModel.getPackageUrl_MD5());
            if (!checkZipDownloadStatus && OooOOO.OooO00o(appModel)) {
                checkZipDownloadStatus = appPrepareUtils.checkZipDownloadStatus(context, appModel.getAppId(), appModel.getMainPackageUrlEncryption());
                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "get AppModelFromUsed,appVersion:" + appModel.getDeployVersion() + ",downloaded:" + checkZipDownloadStatus);
            }
            if (!checkZipDownloadStatus) {
                if (!appPrepareUtils.isShellType(appModel)) {
                    return null;
                }
            }
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    public AppModel getAppModelHasNotOffline(Context context, AppInfoQuery appInfoQuery) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appInfoQuery, "query");
        AppModel appModelFromPre = getAppModelFromPre(context, appInfoQuery.getAppId());
        if (appModelFromPre != null) {
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            if (!appPrepareUtils.isShellType(appModelFromPre) && !appPrepareUtils.checkZipDownloadStatus(context, appModelFromPre)) {
                appModelFromPre = null;
            }
        }
        if (appModelFromPre == null) {
            appModelFromPre = getAppModelFromUsed(context, appInfoQuery.getAppId());
        }
        AppModel appModelFromPackage = getAppModelFromPackage(context, appInfoQuery.getAppId());
        if (appModelFromPackage == null) {
            return appModelFromPre;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(appModelFromPackage);
        if (miniAppVersion == null) {
            miniAppVersion = "0";
        }
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModelFromPre);
        boolean compareVersion = miniAppLaunch.compareVersion(miniAppVersion, miniAppVersion2 != null ? miniAppVersion2 : "0");
        if (appModelFromPre != null && !compareVersion) {
            return appModelFromPre;
        }
        resetAppPreModel(context, appInfoQuery.getAppId());
        return appModelFromPackage;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppWarmupModel(Context context, AppInfoQuery appInfoQuery) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appInfoQuery, "query");
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, appInfoQuery.getAppId(), appInfoQuery.getAppId() + "_warmup");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return (AppModel) JsonUtil.INSTANCE.fromJson(string, AppModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public long getLastUpdateTime(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, str, "APP_LAST_UPDATE_TIME_" + GlobalPackageConfig.Companion.getSDK_DEV_VERSION());
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public boolean getPreUnzipStatus(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, str, str + "_preunzip", false);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getSubpackageAppModelFromUsed(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        if (str.length() == 0) {
            return null;
        }
        String OooO00o2 = OooO00o(context, str, str + "_used");
        if (OooO00o2 == null || OooO00o2.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) JsonUtil.INSTANCE.fromJson(OooO00o2, AppModel.class);
            appModel.setFromCacheType(2);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void refreshUpdateTime(Context context, String str, long j) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, str, "APP_LAST_UPDATE_TIME_" + GlobalPackageConfig.Companion.getSDK_DEV_VERSION(), j);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void resetAppPreModel(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, str, str + "_pre", "");
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateAppModel(Context context, AppModel appModel, String str) {
        String appId;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "key");
        if (appModel == null || (appId = appModel.getAppId()) == null) {
            return;
        }
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, appId, str, JsonUtil.INSTANCE.toJsonStr(appModel));
    }

    public void updateAppModelByOffline(Context context, AppModel appModel, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "key");
        updateAppModel(context, appModel, str);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateAppWarmupModel(Context context, AppModel appModel) {
        String appId;
        Intrinsics.h(context, "context");
        if (appModel == null || (appId = appModel.getAppId()) == null) {
            return;
        }
        String jsonStr = JsonUtil.INSTANCE.toJsonStr(appModel);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, appId, appModel.getAppId() + "_warmup", jsonStr);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateOldVersion(Context context, AppModel appModel, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        if (str == null || str.length() == 0) {
            String appId = appModel.getAppId();
            if (appId == null) {
                appId = "";
            }
            AppModel subpackageAppModelFromUsed = getSubpackageAppModelFromUsed(context, appId);
            if (subpackageAppModelFromUsed != null) {
                updateAppModel(context, subpackageAppModelFromUsed, subpackageAppModelFromUsed.getAppId() + "_old");
                String appId2 = subpackageAppModelFromUsed.getAppId();
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                TmcLogger.d("TmcAppInfoManagerImpl", "appID:" + appId2 + " updateAppModel version:" + miniAppLaunch.getMiniAppVersion(subpackageAppModelFromUsed) + " to old");
                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appID:" + subpackageAppModelFromUsed.getAppId() + " updateAppModel version:" + miniAppLaunch.getMiniAppVersion(subpackageAppModelFromUsed) + " to old");
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updatePreUnzipStatus(Context context, String str, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, str, str + "_preunzip", z);
    }
}
