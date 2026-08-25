package com.cloud.tmc.miniapp.prepare.steps.singlepackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
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
import com.cloud.tmc.miniapp.prepare.steps.OooO;
import com.cloud.tmc.miniapp.prepare.steps.OooOO0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO0O0 extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO00o {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void OooO00o(AppModel appModel, Context context, PrepareController prepareController, PrepareContext prepareContext, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        PrepareContext prepareContext2;
        String str5;
        String miniAppVersion;
        String miniAppVersion2;
        AppPrepareUtils appPrepareUtils;
        MiniAppLaunch miniAppLaunch;
        String miniAppVersion3;
        String str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
        if (!z) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep: tar 包解压失败，删除数据");
            MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.INSTANCE;
            String miniAppVersion4 = miniAppLaunch2.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
            String miniAppVersion5 = miniAppLaunch2.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
            if (!TextUtils.isEmpty(miniAppVersion4) && !TextUtils.isEmpty(miniAppVersion5) && miniAppLaunch2.compareVersion(miniAppVersion5, miniAppVersion4)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion4).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion5).putData(TmcConstants.TRACK_MPU_RESULT, "INSTALL_APP_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
            StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("unzip error");
            OooO00o.append(appModel.getPackageUrl());
            prepareController.moveToError(new PrepareException("5", OooO00o.toString()));
            return;
        }
        TmcLogger.d(this.OooO00o, "Step_LoadStep: tar 包解压完成");
        try {
            appPrepareUtils = AppPrepareUtils.INSTANCE;
            try {
            } catch (Throwable unused) {
                str2 = "manifest error";
                str3 = PrepareException.ERROR_MANIFEST_INFO;
                str4 = TmcConstants.COLD_OPEN_TYPE;
                str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
            }
        } catch (Throwable unused2) {
            str2 = "manifest error";
            str3 = PrepareException.ERROR_MANIFEST_INFO;
            str4 = TmcConstants.COLD_OPEN_TYPE;
        }
        try {
            if (JsonUtil.INSTANCE.getValueFromJson(appPrepareUtils.getManifestJson(appModel), "appId").equals(appModel.getAppId())) {
                MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.INSTANCE;
                String miniAppVersion6 = miniAppLaunch3.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                String miniAppVersion7 = miniAppLaunch3.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
                if (!TextUtils.isEmpty(miniAppVersion6) && !TextUtils.isEmpty(miniAppVersion7) && miniAppLaunch3.compareVersion(miniAppVersion7, miniAppVersion6)) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion6).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion7), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
                }
                TmcLogger.d(this.OooO00o, "Step_LoadStep: manifest 内容校验成功");
                appPrepareUtils.changeTarUnCompressStatus(context, appModel, true);
                this.OooO0o0.delectDownloadFileForVersion(appModel);
                this.OooO0O0.delectOldVersionFilesAndUpdate(context, appModel);
                prepareController.unlock(prepareController);
                prepareController.moveToNext();
                return;
            }
            try {
                appPrepareUtils.clearAllFilesForVersion(context, appModel);
                prepareController.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                miniAppLaunch = MiniAppLaunch.INSTANCE;
                miniAppVersion3 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                str2 = "manifest error";
            } catch (Throwable unused3) {
                str2 = "manifest error";
            }
            try {
                String miniAppVersion8 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
                if (TextUtils.isEmpty(miniAppVersion3) || TextUtils.isEmpty(miniAppVersion8) || !miniAppLaunch.compareVersion(miniAppVersion8, miniAppVersion3)) {
                    return;
                }
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                String appId = prepareContext.getAppId();
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL;
                str3 = PrepareException.ERROR_MANIFEST_INFO;
                try {
                    PointAnalyseType putData = pointAnalyseType.putData(TmcConstants.TRACK_MPU_APPID, appModel.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, miniAppVersion3).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion8).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL");
                    Bundle startParams = prepareContext.getStartParams();
                    str4 = TmcConstants.COLD_OPEN_TYPE;
                    try {
                        String string = startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, str4);
                        str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
                        try {
                            PointAnalyseType putData2 = putData.putData(str6, string);
                            str5 = "";
                            try {
                                performanceAnalyseProxy.record(appId, putData2, str5);
                            } catch (Throwable unused4) {
                                prepareContext2 = prepareContext;
                                MiniAppLaunch miniAppLaunch4 = MiniAppLaunch.INSTANCE;
                                miniAppVersion = miniAppLaunch4.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                                miniAppVersion2 = miniAppLaunch4.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
                                if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch4.compareVersion(miniAppVersion2, miniAppVersion)) {
                                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext2, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, str4, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL"), str6), str5);
                                }
                                AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
                                prepareController.moveToError(new PrepareException(str3, str2));
                            }
                        } catch (Throwable unused5) {
                            str5 = "";
                            prepareContext2 = prepareContext;
                            MiniAppLaunch miniAppLaunch42 = MiniAppLaunch.INSTANCE;
                            miniAppVersion = miniAppLaunch42.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                            miniAppVersion2 = miniAppLaunch42.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
                            if (!TextUtils.isEmpty(miniAppVersion)) {
                            }
                            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
                            prepareController.moveToError(new PrepareException(str3, str2));
                        }
                    } catch (Throwable unused6) {
                        str5 = "";
                        str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
                    }
                } catch (Throwable unused7) {
                    str5 = "";
                    str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
                    str4 = TmcConstants.COLD_OPEN_TYPE;
                }
            } catch (Throwable unused8) {
                str3 = PrepareException.ERROR_MANIFEST_INFO;
                str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
                str4 = TmcConstants.COLD_OPEN_TYPE;
                str5 = "";
                prepareContext2 = prepareContext;
                MiniAppLaunch miniAppLaunch422 = MiniAppLaunch.INSTANCE;
                miniAppVersion = miniAppLaunch422.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                miniAppVersion2 = miniAppLaunch422.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
                if (!TextUtils.isEmpty(miniAppVersion)) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext2, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, str4, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "MANIFEST_FAIL"), str6), str5);
                }
                AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
                prepareController.moveToError(new PrepareException(str3, str2));
            }
        } catch (Throwable unused9) {
            str2 = "manifest error";
            str3 = PrepareException.ERROR_MANIFEST_INFO;
            str6 = TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID;
            str4 = TmcConstants.COLD_OPEN_TYPE;
            prepareContext2 = prepareContext;
            str5 = "";
            MiniAppLaunch miniAppLaunch4222 = MiniAppLaunch.INSTANCE;
            miniAppVersion = miniAppLaunch4222.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
            miniAppVersion2 = miniAppLaunch4222.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
            if (!TextUtils.isEmpty(miniAppVersion)) {
            }
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
            prepareController.moveToError(new PrepareException(str3, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void OooO00o(PrepareController prepareController, PrepareContext prepareContext, AppModel appModel, boolean z, String str) {
        if (z) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep: zip 包解压完成");
            OooO00o(prepareController, prepareContext, appModel);
            return;
        }
        TmcLogger.d(this.OooO00o, "Step_LoadStep: zip 包解压失败");
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
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
        com.cloud.tmc.miniapp.prepare.steps.OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
        bundle.putInt(ChainPoint.ZIP_APP_MODE, 2);
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.OooO0OO.installZip(prepareContext.getStartContext(), appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.singlepackage.b
            public final void onResult(boolean z, String str) {
                OooO0O0.this.OooO00o(prepareController, prepareContext, appModel, z, str);
            }
        });
    }

    public final void OooO00o(final PrepareController prepareController, final PrepareContext prepareContext, final AppModel appModel) {
        final Context startContext = prepareContext.getStartContext();
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验");
        AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
        if (appPrepareUtils.checkSHA256(appModel)) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this.OooO0OO.installApp(appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.singlepackage.a
                public final void onResult(boolean z, String str) {
                    OooO0O0.this.OooO00o(appModel, startContext, prepareController, prepareContext, z, str);
                }
            });
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_RESULT, "SIGN_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        }
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        appPrepareUtils.clearAllFilesForVersion(startContext, appModel);
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("sign error");
        OooO00o.append(appModel.getAppId());
        OooO00o.append("   ");
        OooO00o.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("7", OooO00o.toString()));
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO00o
    public void OooO0OO(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        AppModel appModel = prepareContext.getAppModel();
        if (AppPrepareUtils.INSTANCE.checkTarUnCompressStatus(prepareContext.getStartContext(), appModel)) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
            String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
            if (!TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            TmcLogger.d(this.OooO00o, "Step_LoadStep:tar包已解压，跳转到 startStep");
            prepareController.unlock(prepareController);
            prepareController.moveToNext();
            return;
        }
        TmcLogger.d(this.OooO00o, "Step_LoadStep:删除旧的已解压文件");
        this.OooO0o0.deleteFile(this.OooO0Oo.getZipUnCompressPath(appModel));
        TmcLogger.d(this.OooO00o, "Step_LoadStep:解压 zip 包");
        try {
            OooO00o(prepareContext, prepareController, appModel);
            o000oooo.updateStepProgress(LoadStepAction.STEP_FINISH_DECOMPRESS);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, th);
            StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("unzip error");
            OooO00o.append(th.getMessage());
            prepareController.moveToError(new PrepareException("5", OooO00o.toString()));
        }
    }
}
