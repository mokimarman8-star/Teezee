package com.cloud.tmc.miniapp.prepare.steps;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
import com.cloud.tmc.integration.chain.endState.FwResDownloadStepEndState;
import com.cloud.tmc.integration.chain.startState.FwResLoadStepStartState;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooOOOO extends OooO00o {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(4:(3:66|67|(14:71|72|73|74|35|36|37|38|39|40|41|42|43|44))|42|43|44)|36|37|38|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00df, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void OooO00o(AppModel appModel, PrepareContext prepareContext, Context context, PrepareController prepareController, boolean z, String str) {
        String str2;
        String str3;
        OooOOOO oooOOOO;
        AppModel appModel2;
        String str4;
        String str5;
        PrepareContext prepareContext2;
        Exception exc;
        String miniAppVersion;
        String miniAppVersion2;
        String str6;
        if (!z) {
            TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: tar 包解压失败");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            String miniAppVersion3 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
            String miniAppVersion4 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
            if (!TextUtils.isEmpty(miniAppVersion3) && !TextUtils.isEmpty(miniAppVersion4) && miniAppLaunch.checkFwVersionUpdate(miniAppVersion3, miniAppVersion4)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion3).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion4).putData(TmcConstants.TRACK_MPU_RESULT, "INSTALL_APP_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
            prepareController.moveToError(new PrepareException("5", "unzip error" + str));
            return;
        }
        try {
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            try {
                String manifestJson = appPrepareUtils.getManifestJson(appModel);
                str2 = PrepareException.ERROR_MANIFEST_INFO;
                try {
                    if (JsonUtil.INSTANCE.getValueFromJson(manifestJson, "appId").equals(appModel.getAppId())) {
                        TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: tar 包解压完成");
                        appPrepareUtils.changeTarUnCompressStatus(context, appModel, true);
                        this.OooO0o0.delectDownloadFileForVersion(appModel);
                        this.OooO0O0.delectOldVersionFilesAndUpdate(context, appModel);
                        MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.INSTANCE;
                        String miniAppVersion5 = miniAppLaunch2.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
                        String miniAppVersion6 = miniAppLaunch2.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
                        if (!TextUtils.isEmpty(miniAppVersion5) && !TextUtils.isEmpty(miniAppVersion6) && miniAppLaunch2.checkFwVersionUpdate(miniAppVersion5, miniAppVersion6)) {
                            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion5).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion6), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
                        }
                        prepareController.unlock(prepareController);
                        prepareController.moveToNext();
                        return;
                    }
                    try {
                        MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.INSTANCE;
                        String miniAppVersion7 = miniAppLaunch3.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
                        String miniAppVersion8 = miniAppLaunch3.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
                        try {
                            try {
                                if (!TextUtils.isEmpty(miniAppVersion7)) {
                                    try {
                                        if (!TextUtils.isEmpty(miniAppVersion8) && miniAppLaunch3.checkFwVersionUpdate(miniAppVersion7, miniAppVersion8)) {
                                            str6 = "100000";
                                            try {
                                                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData(TmcConstants.TRACK_MPU_APPID, appModel.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, miniAppVersion7).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion8).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL").putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, prepareContext.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)), "");
                                                appModel2 = appModel;
                                                appPrepareUtils.clearAllFilesForVersion(context, appModel2);
                                                str4 = "manifest error";
                                                str3 = str6;
                                                prepareController.moveToError(new PrepareException(str2, str4));
                                                return;
                                            } catch (Exception e) {
                                                e = e;
                                                oooOOOO = this;
                                                appModel2 = appModel;
                                                exc = e;
                                                str5 = TmcConstants.TRACK_MPU_APPID;
                                                str4 = "manifest error";
                                                str3 = str6;
                                                prepareContext2 = prepareContext;
                                                MiniAppLaunch miniAppLaunch4 = MiniAppLaunch.INSTANCE;
                                                String str7 = str4;
                                                miniAppVersion = miniAppLaunch4.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), str3));
                                                miniAppVersion2 = miniAppLaunch4.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), str3));
                                                if (!TextUtils.isEmpty(miniAppVersion)) {
                                                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext2, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str5, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
                                                }
                                                AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel2);
                                                StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o(str7);
                                                OooO00o.append(exc.getMessage());
                                                prepareController.moveToError(new PrepareException(str2, OooO00o.toString()));
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        str6 = "100000";
                                    }
                                }
                                prepareController.moveToError(new PrepareException(str2, str4));
                                return;
                            } catch (Exception e3) {
                                e = e3;
                                exc = e;
                                str5 = TmcConstants.TRACK_MPU_APPID;
                                str2 = str2;
                                oooOOOO = this;
                                prepareContext2 = prepareContext;
                                MiniAppLaunch miniAppLaunch42 = MiniAppLaunch.INSTANCE;
                                String str72 = str4;
                                miniAppVersion = miniAppLaunch42.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), str3));
                                miniAppVersion2 = miniAppLaunch42.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), str3));
                                if (!TextUtils.isEmpty(miniAppVersion)) {
                                }
                                AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel2);
                                StringBuilder OooO00o2 = com.cloud.tmc.miniapp.OooO00o.OooO00o(str72);
                                OooO00o2.append(exc.getMessage());
                                prepareController.moveToError(new PrepareException(str2, OooO00o2.toString()));
                            }
                            appPrepareUtils.clearAllFilesForVersion(context, appModel2);
                            str4 = "manifest error";
                            str3 = str6;
                        } catch (Exception e4) {
                            e = e4;
                            str4 = "manifest error";
                            str3 = str6;
                            exc = e;
                            str5 = TmcConstants.TRACK_MPU_APPID;
                            oooOOOO = this;
                            prepareContext2 = prepareContext;
                            MiniAppLaunch miniAppLaunch422 = MiniAppLaunch.INSTANCE;
                            String str722 = str4;
                            miniAppVersion = miniAppLaunch422.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), str3));
                            miniAppVersion2 = miniAppLaunch422.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), str3));
                            if (!TextUtils.isEmpty(miniAppVersion)) {
                            }
                            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel2);
                            StringBuilder OooO00o22 = com.cloud.tmc.miniapp.OooO00o.OooO00o(str722);
                            OooO00o22.append(exc.getMessage());
                            prepareController.moveToError(new PrepareException(str2, OooO00o22.toString()));
                        }
                        str6 = "100000";
                        appModel2 = appModel;
                    } catch (Exception e5) {
                        e = e5;
                        appModel2 = appModel;
                        str3 = "100000";
                        str4 = "manifest error";
                    }
                } catch (Exception e6) {
                    e = e6;
                    str5 = TmcConstants.TRACK_MPU_APPID;
                    str3 = "100000";
                    prepareContext2 = prepareContext;
                    oooOOOO = this;
                    appModel2 = appModel;
                    str4 = "manifest error";
                    exc = e;
                    MiniAppLaunch miniAppLaunch4222 = MiniAppLaunch.INSTANCE;
                    String str7222 = str4;
                    miniAppVersion = miniAppLaunch4222.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), str3));
                    miniAppVersion2 = miniAppLaunch4222.getMiniAppVersion(oooOOOO.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), str3));
                    if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch4222.checkFwVersionUpdate(miniAppVersion, miniAppVersion2)) {
                        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext2, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str5, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
                    }
                    AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel2);
                    StringBuilder OooO00o222 = com.cloud.tmc.miniapp.OooO00o.OooO00o(str7222);
                    OooO00o222.append(exc.getMessage());
                    prepareController.moveToError(new PrepareException(str2, OooO00o222.toString()));
                }
            } catch (Exception e7) {
                e = e7;
                str5 = TmcConstants.TRACK_MPU_APPID;
                str2 = PrepareException.ERROR_MANIFEST_INFO;
                prepareContext2 = prepareContext;
                str3 = "100000";
            }
        } catch (Exception e10) {
            e = e10;
            str2 = PrepareException.ERROR_MANIFEST_INFO;
            str3 = "100000";
            oooOOOO = this;
            appModel2 = appModel;
            str4 = "manifest error";
            str5 = TmcConstants.TRACK_MPU_APPID;
            prepareContext2 = prepareContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void OooO00o(PrepareController prepareController, PrepareContext prepareContext, AppModel appModel, boolean z, String str) {
        if (z) {
            TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: zip 包解压完成");
            OooO00o(prepareController, prepareContext, appModel);
            return;
        }
        TmcLogger.d(this.OooO00o, "zip 包解压失败，删除已下载数据");
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
        if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.checkFwVersionUpdate(miniAppVersion, miniAppVersion2)) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "INSTALL_ZIP_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        }
        AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel);
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("unzip error");
        OooO00o.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("5", OooO00o.toString()));
    }

    public final void OooO00o(final PrepareContext prepareContext, final PrepareController prepareController, final AppModel appModel) {
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
        bundle.putInt(ChainPoint.ZIP_FRAMEWORK_MODE, 2);
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.OooO0OO.installZip(prepareContext.getStartContext(), appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.f
            public final void onResult(boolean z, String str) {
                OooOOOO.this.OooO00o(prepareController, prepareContext, appModel, z, str);
            }
        });
    }

    public final void OooO00o(final PrepareController prepareController, final PrepareContext prepareContext, final AppModel appModel) {
        final Context startContext = prepareContext.getStartContext();
        TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: sha256 校验");
        AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
        if (appPrepareUtils.checkSHA256(appModel)) {
            TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: sha256 校验正确，解压 tar 包");
            this.OooO0OO.installApp(appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.e
                public final void onResult(boolean z, String str) {
                    OooOOOO.this.OooO00o(appModel, prepareContext, startContext, prepareController, z, str);
                }
            });
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
        if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.checkFwVersionUpdate(miniAppVersion, miniAppVersion2)) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "SIGN_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        }
        TmcLogger.d(this.OooO00o, "Step_FW_LoadStep: sha256 校验不一致，删除所有缓存");
        appPrepareUtils.clearAllFilesForVersion(startContext, appModel);
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("sign error");
        OooO00o.append(appModel.getAppId());
        OooO00o.append("   ");
        OooO00o.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("7", OooO00o.toString()));
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public StepType OooO0O0() {
        return StepType.FW_LOAD;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public void OooO0O0(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) throws PrepareException {
        if (!prepareContext.getVirtualStart()) {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
            OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_END, ChainPoint.FwResDownloadStep, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_START, ChainPoint.FwResLoadStep, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.AppFwResDownloadStep, new Bundle());
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.AppFwResLoadStep, new Bundle());
            new FwResDownloadStepEndState(new Bundle()).setChainContext(prepareContext.getAppChainContext());
            new FwResLoadStepStartState(new Bundle()).setChainContext(prepareContext.getAppChainContext());
        }
        AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
        if (appPrepareUtils.isShellType(prepareContext.getAppModel())) {
            prepareController.moveToNext();
            return;
        }
        super.OooO0O0(prepareController, prepareContext, o000oooo);
        prepareController.lock(prepareController);
        TmcLogger.d(this.OooO00o, "Step_FW_进度:LoadStep");
        AppModel frameWorkModel = prepareContext.getFrameWorkModel();
        if (appPrepareUtils.checkTarUnCompressStatus(prepareContext.getStartContext(), frameWorkModel)) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), "100000"));
            String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), "100000"));
            if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.checkFwVersionUpdate(miniAppVersion, miniAppVersion2)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(frameWorkModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            TmcLogger.d(this.OooO00o, "Step_FW_LoadStep:tar包已解压，跳转到 startStep");
            prepareController.unlock(prepareController);
            prepareController.moveToNext();
            return;
        }
        TmcLogger.d(this.OooO00o, "Step_FW_LoadStep:删除旧的已解压文件");
        this.OooO0o0.deleteFile(this.OooO0Oo.getZipUnCompressPath(frameWorkModel));
        TmcLogger.d(this.OooO00o, "Step_FW_LoadStep:解压 zip 包");
        try {
            OooO00o(prepareContext, prepareController, frameWorkModel);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, th);
            StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("unzip error ");
            OooO00o.append(th.getMessage());
            prepareController.moveToError(new PrepareException("5", OooO00o.toString()));
        }
    }
}
