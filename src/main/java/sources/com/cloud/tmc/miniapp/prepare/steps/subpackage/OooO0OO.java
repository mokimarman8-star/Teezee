package com.cloud.tmc.miniapp.prepare.steps.subpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.OooOOO0;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0 {
    public String OooO;
    public final Integer OooOO0;
    public final OooOO0 OooOO0O;
    public boolean OooOO0o;

    public static final class OooO00o implements PackageDownloadCallback {
        public final /* synthetic */ o000oOoO OooO;
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ OooO0OO OooO0O0;
        public final /* synthetic */ AppModel OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ PrepareContext OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ String OooO0oO;
        public final /* synthetic */ PrepareController OooO0oo;
        public final /* synthetic */ String OooOO0;

        public OooO00o(boolean z, OooO0OO oooO0OO, AppModel appModel, String str, String str2, PrepareContext prepareContext, String str3, PrepareController prepareController, o000oOoO o000oooo, String str4) {
            this.OooO00o = z;
            this.OooO0O0 = oooO0OO;
            this.OooO0OO = appModel;
            this.OooO0Oo = str;
            this.OooO0o0 = str2;
            this.OooO0o = prepareContext;
            this.OooO0oO = str3;
            this.OooO0oo = prepareController;
            this.OooO = o000oooo;
            this.OooOO0 = str4;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            try {
                PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "IOException").putData(TmcConstants.TRACK_MPU_ERROR_CODE, "D006").putData(TmcConstants.TRACK_MPU_ERROR_MSG, "Canceled").putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, this.OooO0o.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                Intrinsics.g(putData, "POINT_PACKAGE_DOWNLOAD_U…                        )");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o.getAppId(), this.OooO0O0.OooOO0O.OooO00o(putData), "");
                try {
                    this.OooO0O0.OooO0OO.removeDownloadAppMap(this.OooO0oO);
                } catch (Throwable th) {
                    TmcLogger.e(TmcConstants.TAG, th);
                }
            } catch (Throwable th2) {
                TmcLogger.e(TmcConstants.TAG, th2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onFailed(String str, String str2, String str3, IOException iOException, String str4) {
            String str5;
            String simpleName;
            String str6;
            try {
                SubpackageAppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0o.getStartContext(), this.OooO0OO.getAppId(), this.OooO0oO, false);
                PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0);
                if (iOException != null) {
                    try {
                        simpleName = iOException.getClass().getSimpleName();
                    } catch (Throwable th) {
                        th = th;
                        str5 = TmcConstants.TAG;
                        TmcLogger.e(str5, th);
                        if (this.OooO00o) {
                        }
                    }
                } else {
                    simpleName = null;
                }
                PointAnalyseType putData2 = putData.putData(TmcConstants.TRACK_MPU_RESULT, simpleName).putData(TmcConstants.TRACK_MPU_ERROR_CODE, str2).putData(TmcConstants.TRACK_MPU_ERROR_MSG, iOException != null ? iOException.getMessage() : null).putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, this.OooO0o.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                Intrinsics.g(putData2, "POINT_PACKAGE_DOWNLOAD_F…                        )");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o.getAppId(), this.OooO0O0.OooOO0O.OooO00o(putData2), "");
                try {
                    this.OooO0O0.OooO0OO.removeDownloadAppMap(this.OooO0oO);
                } catch (Throwable th2) {
                    TmcLogger.e(TmcConstants.TAG, th2);
                }
            } catch (Throwable th3) {
                th = th3;
                str = TmcConstants.TAG;
                str5 = str;
                TmcLogger.e(str5, th);
                if (this.OooO00o) {
                    this.OooO0oo.moveToError(new PrepareException("download error"));
                    return;
                }
                return;
            }
            try {
                if (!this.OooO00o) {
                    this.OooO.backgroundDownloadZipAsync(this.OooO0OO, false);
                    return;
                }
                if (!TextUtils.isEmpty(this.OooO0Oo) && !TextUtils.isEmpty(this.OooO0o0) && (str6 = this.OooO0o0) != null) {
                    String str7 = this.OooO0Oo;
                    AppModel appModel = this.OooO0OO;
                    PrepareContext prepareContext = this.OooO0o;
                    OooO0OO oooO0OO = this.OooO0O0;
                    if (str7 != null) {
                        if (MiniAppLaunch.INSTANCE.compareVersion(str6, str7)) {
                            PointAnalyseType putData3 = PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData(TmcConstants.TRACK_MPU_APPID, appModel.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, str7).putData(TmcConstants.TRACK_MPU_NEW_V, str6).putData(TmcConstants.TRACK_MPU_RESULT, "DOWNLOAD_FAIL").putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, prepareContext.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                            Intrinsics.g(putData3, "POINT_PACKAGE_UPDATE_FAI…                        )");
                            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), oooO0OO.OooOO0O.OooO00o(putData3), "");
                        }
                        TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_资源包下载失败，" + str3);
                        this.OooO0oo.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.OooOO0));
                    }
                }
                TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_资源包下载失败，" + str3);
                this.OooO0oo.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.OooOO0));
            } catch (Throwable th4) {
                th = th4;
                str5 = str;
                TmcLogger.e(str5, th);
                if (this.OooO00o) {
                }
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            try {
                TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_资源包下载完成，进行解压");
                SubpackageAppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0o.getStartContext(), this.OooO0OO.getAppId(), this.OooO0oO, true);
                PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, this.OooO0o.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                Intrinsics.g(putData, "POINT_PACKAGE_DOWNLOAD_S…                        )");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o.getAppId(), this.OooO0O0.OooOO0O.OooO00o(putData), "");
                try {
                    this.OooO0O0.OooO0OO.removeDownloadAppMap(this.OooO0oO);
                } catch (Throwable th) {
                    TmcLogger.e(TmcConstants.TAG, th);
                }
                if (this.OooO00o) {
                    PrepareController prepareController = this.OooO0oo;
                    prepareController.unlock(prepareController);
                    this.OooO0oo.moveToNext();
                } else {
                    try {
                        if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                            OooOOO0.OooO00o.OooO0O0(this.OooO0o.getStartContext(), this.OooO0OO, this.OooO0O0.OooOO0O.OooO0O0(), false, true);
                        }
                    } catch (Throwable th2) {
                        TmcLogger.e(TmcConstants.TAG, th2);
                    }
                    this.OooO.backgroundDownloadZipAsync(this.OooO0OO, true);
                }
            } catch (Throwable th3) {
                TmcLogger.e(TmcConstants.TAG, th3);
                if (this.OooO00o) {
                    this.OooO0oo.moveToError(new PrepareException("download error"));
                }
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i, String str2) {
            if (this.OooO00o) {
                TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_下载资源包" + i);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i, String str2, long j, long j2) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i, str2, j, j2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0OO() {
        this(null, 0 == true ? 1 : 0, 3);
    }

    public OooO0OO(String str, Integer num) {
        this.OooO = str;
        this.OooOO0 = num;
        this.OooOO0O = new OooOO0();
        this.OooOO0o = true;
    }

    public /* synthetic */ OooO0OO(String str, Integer num, int i) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 1 : null);
    }

    public static final void OooO00o(OooO0OO oooO0OO, PrepareContext prepareContext, o000oOoO o000oooo) {
        Intrinsics.h(oooO0OO, "this$0");
        Intrinsics.h(prepareContext, "$context");
        Intrinsics.h(o000oooo, "$callback");
        oooO0OO.getClass();
        try {
            ((IClientStarter) TmcProxy.get(IClientStarter.class)).createSubpackagePrepareController(prepareContext, o000oooo, 2, oooO0OO.OooOO0O.OooO0OO).start();
        } catch (Throwable th) {
            TmcLogger.e(oooO0OO.OooO00o, th);
        }
    }

    public final void OooO00o(PrepareContext prepareContext, PrepareController prepareController) {
        if (!prepareContext.getVirtualStart()) {
            Bundle bundle = new Bundle();
            bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, 1);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
        }
        prepareController.moveToNext();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo, AppModel appModel, String str, boolean z) {
        Class cls;
        String mainPackageUrl;
        String str2;
        OooOO0 oooOO0;
        String mainPackageZipPath;
        String str3;
        KVStorageProxy kVStorageProxy;
        String format;
        if (!prepareContext.getVirtualStart()) {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
            com.cloud.tmc.miniapp.prepare.steps.OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
            bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, z ? 2 : 1);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        OooOO0 oooOO02 = this.OooOO0O;
        oooOO02.getClass();
        String mainPackageUrl2 = appModel != null ? appModel.getMainPackageUrl() : null;
        if (mainPackageUrl2 == null || mainPackageUrl2.length() == 0) {
            SubPackageInfo subPackageInfo = oooOO02.OooO00o;
            String subPackageUrl = subPackageInfo != null ? subPackageInfo.getSubPackageUrl() : null;
            if (subPackageUrl == null || subPackageUrl.length() == 0) {
                if (!z) {
                    o000oooo.backgroundDownloadZipAsync(appModel, false);
                }
                prepareController.moveToError(new PrepareException(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty"));
                return;
            }
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getSubpackageAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (!z || TextUtils.isEmpty(miniAppVersion) || TextUtils.isEmpty(miniAppVersion2) || miniAppVersion2 == null || miniAppVersion == null || !miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
            cls = PerformanceAnalyseProxy.class;
        } else {
            PointAnalyseType OooO00o2 = com.cloud.tmc.miniapp.prepare.steps.OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, com.cloud.tmc.miniapp.prepare.steps.OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID);
            Intrinsics.g(OooO00o2, "POINT_PACKAGE_UPDATE_STA…                        )");
            cls = PerformanceAnalyseProxy.class;
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), this.OooOO0O.OooO00o(OooO00o2), "");
        }
        PointAnalyseType OooO00o3 = com.cloud.tmc.miniapp.prepare.steps.OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, com.cloud.tmc.miniapp.prepare.steps.OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, z ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC), TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID);
        Intrinsics.g(OooO00o3, "POINT_PACKAGE_DOWNLOAD_S…N_ID, \"-1\")\n            )");
        ((PerformanceAnalyseProxy) TmcProxy.get(cls)).record(prepareContext.getAppId(), this.OooOO0O.OooO00o(OooO00o3), "");
        int i = z ? 2 : 1;
        OooOO0 oooOO03 = this.OooOO0O;
        if (oooOO03.OooO0O0) {
            SubPackageInfo subPackageInfo2 = oooOO03.OooO00o;
            if (subPackageInfo2 == null) {
                str2 = null;
                if (str2 != null && str2.length() != 0 && this.OooOO0O.OooO0O0 && this.OooO0OO.isDownloaded(prepareContext.getStartContext(), appModel.getAppId(), str2) && !SubpackageAppPrepareUtils.INSTANCE.checkTarUnCompressStatus(prepareContext.getStartContext(), appModel.getAppId(), str2)) {
                    kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    SubPackageInfo OooO0O0 = this.OooOO0O.OooO0O0();
                    format = String.format(TmcConstants.SUBPACKAGE_STORAGE_KEY_DECOMPRESSION_COUNT_FORMAT, Arrays.copyOf(new Object[]{OooO0O0 == null ? OooO0O0.getSubPackageUrlMD5() : null}, 1));
                    Intrinsics.g(format, "format(format, *args)");
                    if (kVStorageProxy.getInt(prepareContext.getStartContext(), TmcConstants.SUBPACKAGE_STORAGE_FILE, format) <= 1) {
                        prepareController.moveToNext();
                        return;
                    }
                }
                TmcResourceManager tmcResourceManager = this.OooO0OO;
                String appId = appModel.getAppId();
                oooOO0 = this.OooOO0O;
                if (oooOO0.OooO0O0) {
                    mainPackageZipPath = appModel.getMainPackageZipPath();
                } else {
                    SubPackageInfo subPackageInfo3 = oooOO0.OooO00o;
                    if (subPackageInfo3 == null) {
                        str3 = null;
                        tmcResourceManager.downloadApp(appId, str2, str, str3, i, true, new OooO00o(z, this, appModel, miniAppVersion, miniAppVersion2, prepareContext, str, prepareController, o000oooo, str2));
                    }
                    mainPackageZipPath = subPackageInfo3.getSubZipPath();
                }
                str3 = mainPackageZipPath;
                tmcResourceManager.downloadApp(appId, str2, str, str3, i, true, new OooO00o(z, this, appModel, miniAppVersion, miniAppVersion2, prepareContext, str, prepareController, o000oooo, str2));
            }
            mainPackageUrl = subPackageInfo2.getSubPackageUrl();
        } else {
            mainPackageUrl = appModel.getMainPackageUrl();
        }
        str2 = mainPackageUrl;
        if (str2 != null) {
            kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            SubPackageInfo OooO0O02 = this.OooOO0O.OooO0O0();
            format = String.format(TmcConstants.SUBPACKAGE_STORAGE_KEY_DECOMPRESSION_COUNT_FORMAT, Arrays.copyOf(new Object[]{OooO0O02 == null ? OooO0O02.getSubPackageUrlMD5() : null}, 1));
            Intrinsics.g(format, "format(format, *args)");
            if (kVStorageProxy.getInt(prepareContext.getStartContext(), TmcConstants.SUBPACKAGE_STORAGE_FILE, format) <= 1) {
            }
        }
        TmcResourceManager tmcResourceManager2 = this.OooO0OO;
        String appId2 = appModel.getAppId();
        oooOO0 = this.OooOO0O;
        if (oooOO0.OooO0O0) {
        }
        str3 = mainPackageZipPath;
        tmcResourceManager2.downloadApp(appId2, str2, str, str3, i, true, new OooO00o(z, this, appModel, miniAppVersion, miniAppVersion2, prepareContext, str, prepareController, o000oooo, str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0477 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0483 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x050c A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04bb A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0463 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ce A[Catch: all -> 0x01b4, TryCatch #0 {all -> 0x01b4, blocks: (B:37:0x01ce, B:38:0x01d4, B:40:0x01ea, B:42:0x01fa, B:43:0x024b, B:45:0x0265, B:47:0x027f, B:51:0x0288, B:54:0x028f, B:56:0x0295, B:57:0x02d7, B:137:0x01ff, B:139:0x0205, B:140:0x0209, B:142:0x020f, B:144:0x021b, B:146:0x0226, B:148:0x022c, B:149:0x0236, B:152:0x0240, B:183:0x0174, B:185:0x01a9, B:186:0x01c3, B:187:0x01b9), top: B:182:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ea A[Catch: all -> 0x01b4, TryCatch #0 {all -> 0x01b4, blocks: (B:37:0x01ce, B:38:0x01d4, B:40:0x01ea, B:42:0x01fa, B:43:0x024b, B:45:0x0265, B:47:0x027f, B:51:0x0288, B:54:0x028f, B:56:0x0295, B:57:0x02d7, B:137:0x01ff, B:139:0x0205, B:140:0x0209, B:142:0x020f, B:144:0x021b, B:146:0x0226, B:148:0x022c, B:149:0x0236, B:152:0x0240, B:183:0x0174, B:185:0x01a9, B:186:0x01c3, B:187:0x01b9), top: B:182:0x0174 }] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0OO] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.cloud.tmc.miniapp.prepare.controller.PrepareController, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.cloud.tmc.miniapp.prepare.controller.PrepareController, java.lang.Object] */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO0OO(PrepareController prepareController, final PrepareContext prepareContext, final o000oOoO o000oooo) {
        PrepareController prepareController2;
        AppModel appModel;
        String str;
        PrepareContext prepareContext2;
        String str2;
        int i;
        int i2;
        String str3;
        OooOO0 oooOO0;
        Iterator it;
        String str4;
        AppModel subpackageAppModelFromUsed;
        Iterator it2;
        String str5;
        ?? r92 = prepareController;
        Intrinsics.h((Object) r92, "controller");
        Intrinsics.h(prepareContext, "context");
        Intrinsics.h(o000oooo, RenderCallContext.TYPE_CALLBACK);
        try {
            AppModel appModel2 = prepareContext.getAppModel();
            this.OooOO0O.OooO00o(appModel2, this.OooO, prepareContext, this.OooOO0);
            String OooO00o2 = this.OooOO0O.OooO00o(appModel2);
            if (appModel2 != null && OooO00o2 != null && OooO00o2.length() != 0) {
                OooOO0 oooOO02 = this.OooOO0O;
                if (!oooOO02.OooO0O0 && oooOO02.OooO00o != null) {
                    ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.prepare.steps.subpackage.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            OooO0OO.OooO00o(OooO0OO.this, prepareContext, o000oooo);
                        }
                    });
                }
                if (prepareContext.getDevStatus()) {
                    this.OooOO0o = true;
                    this.OooO0o0.deleteAllFileForVersion(appModel2, OooO00o2);
                    this.OooO0o0.createBaseDirectory(appModel2);
                    SubpackageAppPrepareUtils subpackageAppPrepareUtils = SubpackageAppPrepareUtils.INSTANCE;
                    subpackageAppPrepareUtils.changeZipDownloadStatus(prepareContext.getStartContext(), appModel2.getAppId(), OooO00o2, false);
                    subpackageAppPrepareUtils.changeZipUnCompressStatus(prepareContext.getStartContext(), appModel2.getAppId(), OooO00o2, false);
                    subpackageAppPrepareUtils.changeTarUnCompressStatus(prepareContext.getStartContext(), appModel2.getAppId(), OooO00o2, false);
                    r92.lock(r92);
                    OooO00o(prepareController, prepareContext, o000oooo, appModel2, OooO00o2, this.OooOO0o);
                    if (prepareContext.getVirtualStart()) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, 2);
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
                    return;
                }
                boolean isDownloaded = this.OooO0OO.isDownloaded(prepareContext.getStartContext(), appModel2.getAppId(), OooO00o2);
                AppModel appModelFromPre = this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId());
                String mainPackageUrl = appModelFromPre != null ? appModelFromPre.getMainPackageUrl() : null;
                if (mainPackageUrl == null || mainPackageUrl.length() == 0) {
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "subpackageDownload Step 检查是 preAppinfo 否为全量包：true（appInfo主包地址为空），appVersion：" + appModelFromPre.getDeployVersion());
                    appModelFromPre = appModel2;
                }
                AppModel subpackageAppModelFromUsed2 = this.OooO0O0.getSubpackageAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId());
                if (!isDownloaded) {
                    Integer num = this.OooOO0;
                    if (num != null && num.intValue() == 1) {
                        if (appModel2.getFromCacheType() == 3 || appModel2.getFromCacheType() == 4) {
                            String deployVersion = appModel2.getDeployVersion();
                            String deployVersion2 = appModelFromPre != null ? appModelFromPre.getDeployVersion() : null;
                            if (subpackageAppModelFromUsed2 != null) {
                                appModel = subpackageAppModelFromUsed2;
                                str = subpackageAppModelFromUsed2.getDeployVersion();
                            } else {
                                appModel = subpackageAppModelFromUsed2;
                                str = null;
                            }
                            try {
                                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "删除子包" + OooO00o2 + ",currentAppVersion:" + deployVersion + "，preAppVersion：" + deployVersion2 + ",usedAppVersion:" + str);
                                this.OooO0o0.deleteAllFileForVersion(appModel2, OooO00o2);
                                this.OooO0o0.createBaseDirectory(appModel2);
                                boolean nativeCache = appModel2.getFromCacheType() == 3 ? this.OooO0OO.getNativeCache(prepareContext.getStartContext(), appModel2) : this.OooO0OO.getOfflineCache(prepareContext.getStartContext(), appModel2);
                                TmcLogger.d(this.OooO00o, "Step_FW_Download_资源包已下载，跳转到解压步骤");
                                this.OooOO0o = !nativeCache;
                                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appModelFromPre:" + (appModelFromPre == null ? appModelFromPre.getDeployVersion() : null));
                                if (appModelFromPre == null) {
                                    TmcResourceManager tmcResourceManager = this.OooO0OO;
                                    Context startContext = prepareContext.getStartContext();
                                    String appId = appModelFromPre.getAppId();
                                    OooOO0 oooOO03 = this.OooOO0O;
                                    if (oooOO03.OooO0O0) {
                                        List subPackagePages = appModelFromPre.getSubPackagePages();
                                        if (subPackagePages != null) {
                                            Iterator it3 = subPackagePages.iterator();
                                            while (it3.hasNext()) {
                                                SubPackageInfo subPackageInfo = (SubPackageInfo) it3.next();
                                                String root = subPackageInfo.getRoot();
                                                if (root == null || root.length() == 0) {
                                                    oooOO0 = oooOO03;
                                                    it = it3;
                                                } else {
                                                    it = it3;
                                                    SubPackageInfo subPackageInfo2 = oooOO03.OooO00o;
                                                    if (subPackageInfo2 != null) {
                                                        str4 = subPackageInfo2.getRoot();
                                                        oooOO0 = oooOO03;
                                                    } else {
                                                        oooOO0 = oooOO03;
                                                        str4 = null;
                                                    }
                                                    if (TextUtils.equals(str4, subPackageInfo.getRoot())) {
                                                        str3 = subPackageInfo.getSubPackageUrlMD5();
                                                        break;
                                                    }
                                                }
                                                it3 = it;
                                                oooOO03 = oooOO0;
                                            }
                                        }
                                        str3 = null;
                                    } else {
                                        str3 = appModelFromPre.getMainPackageUrlEncryption();
                                    }
                                    boolean isDownloaded2 = tmcResourceManager.isDownloaded(startContext, appId, str3);
                                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appModelFromPre preDownloaded:" + isDownloaded2);
                                    if (isDownloaded2) {
                                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                                        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getSubpackageAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
                                        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(appModelFromPre);
                                        if (miniAppVersion != null && miniAppVersion.length() != 0 && miniAppVersion2 != null && miniAppVersion2.length() != 0 && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
                                            PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_UPDATE_START.putData(TmcConstants.TRACK_MPU_APPID, appModelFromPre.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2).putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, prepareContext.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                                            Intrinsics.g(putData, "POINT_PACKAGE_UPDATE_STA…                        )");
                                            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), this.OooOO0O.OooO00o(putData), "");
                                        }
                                        TmcLogger.d(this.OooO00o, "Download_step_当前版本已有缓存" + miniAppLaunch.getMiniAppVersion(appModelFromPre));
                                        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appModelFromPre set:" + appModelFromPre.getDeployVersion());
                                        prepareContext.setAppModel(appModelFromPre);
                                        OooO00o(prepareContext, prepareController);
                                        return;
                                    }
                                    PrepareController prepareController3 = prepareController;
                                    prepareContext2 = prepareContext;
                                    TmcLogger.d(this.OooO00o, "Step_Download_删除当前所有缓存");
                                    if (this.OooOO0O.OooO0O0) {
                                        List subPackagePages2 = appModelFromPre.getSubPackagePages();
                                        if (subPackagePages2 != null) {
                                            Iterator it4 = subPackagePages2.iterator();
                                            while (it4.hasNext()) {
                                                SubPackageInfo subPackageInfo3 = (SubPackageInfo) it4.next();
                                                if (TextUtils.equals(this.OooO, subPackageInfo3.getRoot())) {
                                                    this.OooO0o0.deleteAllFileForVersion(appModelFromPre, subPackageInfo3.getSubPackageUrlMD5());
                                                    String subPackageUrlMD5 = subPackageInfo3.getSubPackageUrlMD5();
                                                    String deployVersion3 = appModelFromPre.getDeployVersion();
                                                    if (appModel != null) {
                                                        str5 = appModel.getDeployVersion();
                                                        it2 = it4;
                                                    } else {
                                                        it2 = it4;
                                                        str5 = null;
                                                    }
                                                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "删除子包" + OooO00o2 + ",currentAppVersion:" + subPackageUrlMD5 + "，preAppVersion：" + deployVersion3 + ",usedAppVersion:" + str5);
                                                    it4 = it2;
                                                }
                                            }
                                        }
                                        str2 = OooO00o2;
                                    } else {
                                        this.OooO0o0.deleteAllFileForVersion(appModelFromPre, appModelFromPre.getMainPackageUrlEncryption());
                                        String mainPackageUrlEncryption = appModelFromPre.getMainPackageUrlEncryption();
                                        String deployVersion4 = appModel2.getDeployVersion();
                                        String deployVersion5 = appModelFromPre.getDeployVersion();
                                        String deployVersion6 = appModel != null ? appModel.getDeployVersion() : null;
                                        StringBuilder sb = new StringBuilder();
                                        str2 = OooO00o2;
                                        sb.append("删除主包");
                                        sb.append(mainPackageUrlEncryption);
                                        sb.append(",currentAppVersion:");
                                        sb.append(deployVersion4);
                                        sb.append("，preAppVersion：");
                                        sb.append(deployVersion5);
                                        sb.append(",usedAppVersion:");
                                        sb.append(deployVersion6);
                                        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, sb.toString());
                                    }
                                    this.OooO0o0.createBaseDirectory(appModelFromPre);
                                    MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.INSTANCE;
                                    i2 = 2;
                                    if (miniAppLaunch2.checkFocusUpdateMyByteApp(appModelFromPre, 2) && (subpackageAppModelFromUsed = this.OooO0O0.getSubpackageAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId())) != null) {
                                        String miniAppVersion3 = miniAppLaunch2.getMiniAppVersion(subpackageAppModelFromUsed);
                                        String lowestOpenedVersion = appModelFromPre.getLowestOpenedVersion();
                                        if (lowestOpenedVersion != null && lowestOpenedVersion.length() != 0 && miniAppVersion3 != null && miniAppVersion3.length() != 0 && miniAppLaunch2.compareVersion(lowestOpenedVersion, miniAppVersion3)) {
                                            TmcLogger.d(this.OooO00o, "Download_step_当前版本缓存符合可打开版本号" + miniAppLaunch2.getMiniAppVersion(subpackageAppModelFromUsed) + "最低可打开版本号:" + lowestOpenedVersion + "参与比对的版本号:" + miniAppVersion3);
                                            this.OooOO0o = false;
                                            prepareContext2.setAppModel(subpackageAppModelFromUsed);
                                        }
                                        i = 1;
                                        this.OooOO0o = true;
                                        TmcLogger.d(this.OooO00o, "Download_step_当前版本缓存不符合可打开版本号，强制更新最低可打开版本:" + lowestOpenedVersion + "参与比对的版本号:" + miniAppVersion3);
                                        r92 = prepareController3;
                                    }
                                    i = 1;
                                    r92 = prepareController3;
                                } else {
                                    PrepareController prepareController4 = prepareController;
                                    prepareContext2 = prepareContext;
                                    str2 = OooO00o2;
                                    i = 1;
                                    i2 = 2;
                                    r92 = prepareController4;
                                    if (!this.OooOO0o) {
                                        OooO00o(prepareContext2, prepareController4);
                                        return;
                                    }
                                }
                                if (this.OooOO0o) {
                                    r92.lock(r92);
                                }
                                TmcLogger.d(this.OooO00o, "Step_Download_开始下载资源包");
                                if (appModelFromPre == null) {
                                    int i3 = this.OooOO0o ? i2 : i;
                                    if (!prepareContext.getVirtualStart()) {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putInt(ChainPoint.DOWNLOAD_APP_MODE, i3);
                                        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
                                    }
                                    OooO00o(prepareController, prepareContext, o000oooo, appModelFromPre, str2, this.OooOO0o);
                                } else if (this.OooOO0o) {
                                    try {
                                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).remove(prepareContext.getStartContext(), prepareContext.getAppId(), prepareContext.getAppId() + "_pre");
                                        this.OooO0O0.refreshUpdateTime(prepareContext.getStartContext(), prepareContext.getAppId(), 0L);
                                    } catch (Throwable th) {
                                        TmcLogger.e(this.OooO00o, th);
                                    }
                                    r92.moveToError(new PrepareException("appModelFromPre is not exist"));
                                    return;
                                }
                                if (this.OooOO0o) {
                                    OooO00o(prepareContext2, r92);
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                prepareController2 = prepareController;
                                TmcLogger.e(this.OooO00o, th);
                                prepareController2.moveToError(new PrepareException("download error"));
                            }
                        }
                    }
                    r92.lock(r92);
                    Intrinsics.g(subpackageAppModelFromUsed2, "usedModel");
                    OooO00o(prepareController, prepareContext, o000oooo, subpackageAppModelFromUsed2, OooO00o2, this.OooOO0o);
                    return;
                }
                TmcLogger.d(this.OooO00o, "Step_FW_Download_资源包已下载，跳转到解压步骤");
                this.OooOO0o = false;
                appModel = subpackageAppModelFromUsed2;
                if (appModelFromPre == null) {
                }
                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "appModelFromPre:" + (appModelFromPre == null ? appModelFromPre.getDeployVersion() : null));
                if (appModelFromPre == null) {
                }
                if (this.OooOO0o) {
                }
                TmcLogger.d(this.OooO00o, "Step_Download_开始下载资源包");
                if (appModelFromPre == null) {
                }
                if (this.OooOO0o) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            prepareController2 = r92;
            TmcLogger.e(this.OooO00o, th);
            prepareController2.moveToError(new PrepareException("download error"));
        }
    }
}
