package com.cloud.tmc.miniapp.prepare.steps.singlepackage;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.PrepareCallbackParam;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO0OO extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO {
    public final void OooO00o(AppModel appModel, List<File> list, Map<String, String> map, HashMap<String, String> hashMap, IPackageResourceManager iPackageResourceManager, String str) {
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    OooO00o(appModel, Arrays.asList(file.listFiles()), map, hashMap, iPackageResourceManager, str + "/" + file.getName());
                } else {
                    String generateVUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                    StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("StartStep:absPath:");
                    OooO00o.append(file.getAbsolutePath());
                    OooO00o.append(";vUrl:");
                    OooO00o.append(generateVUrl);
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, OooO00o.toString());
                    map.put(file.getName(), generateVUrl);
                    if (file.getName().toLowerCase().contains(".html")) {
                        hashMap.put(file.getName(), generateVUrl);
                    }
                    String str2 = this.OooO00o;
                    StringBuilder OooO00o2 = com.cloud.tmc.miniapp.OooO00o.OooO00o("Step_LoadStep: tar包结构: ");
                    OooO00o2.append(file.getName());
                    TmcLogger.d(str2, OooO00o2.toString());
                    TmcLogger.d(this.OooO00o, "Step_LoadStep: tar包结构: " + generateVUrl);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:99|100|(2:20|21)|(19:23|26|27|(0)|29|(0)(0)|40|41|42|(0)(0)|48|49|50|(0)|54|(0)|65|66|67)|92|29|(0)(0)|40|41|42|(0)(0)|48|49|50|(0)|54|(0)|65|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02b8, code lost:
    
        r4 = r20;
        r28.moveToError(new com.cloud.tmc.miniapp.prepare.steps.PrepareException(r6, r4));
        r7 = r19;
        com.cloud.tmc.kernel.log.TmcLogger.d(r27.OooO00o, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x027a, code lost:
    
        r5 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x025f A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #6 {all -> 0x027a, blocks: (B:42:0x0257, B:44:0x025f), top: B:41:0x0257 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x029d A[Catch: all -> 0x02b8, TRY_LEAVE, TryCatch #3 {all -> 0x02b8, blocks: (B:50:0x0295, B:52:0x029d), top: B:49:0x0295 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02db A[Catch: all -> 0x02f2, TRY_LEAVE, TryCatch #2 {all -> 0x02f2, blocks: (B:60:0x02d3, B:62:0x02db), top: B:59:0x02d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO0OO] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashMap] */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PrepareCallbackParam OooO0OO(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        String str;
        AppModel appModel;
        String str2;
        Class cls;
        String str3;
        ?? r19;
        ?? r20;
        Object obj;
        HashMap hashMap;
        String str4;
        String str5;
        AppModel commonResModel;
        String str6;
        Object obj2;
        Class cls2;
        String str7;
        AppModel appModel2;
        String str8;
        String str9;
        String str10;
        List listFilesInDir;
        AppModel appModel3 = "frameworkConfig 不存在：";
        String str11 = "frameworkConfig.json error";
        TraceLog.i(this.OooO00o, "startStep 创建normal app config");
        AppModel appModel4 = prepareContext.getAppModel();
        if (appModel4.getPermissions() != null) {
            AuthenticationProxy authenticationProxy = (AuthenticationProxy) TmcProxy.get(AuthenticationProxy.class);
            String appId = appModel4.getAppId();
            str = PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION;
            authenticationProxy.setPermissionModel(appId, appModel4.getPermissions());
        } else {
            str = PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION;
        }
        this.OooO0O0.updateAppModel(prepareContext.getStartContext(), appModel4, appModel4.getAppId() + "_used");
        if (this.OooO0O0.getPreUnzipStatus(prepareContext.getStartContext(), appModel4.getAppId())) {
            TmcLogger.d(TmcConstants.TAG, "startStep_使用了预先解压的包");
            ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(appModel4.getAppId(), "preunzip");
            appModel = appModel4;
            this.OooO0O0.updatePreUnzipStatus(prepareContext.getStartContext(), appModel4.getAppId(), false);
        } else {
            appModel = appModel4;
        }
        ?? hashMap2 = new HashMap();
        AppModel hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
        HashMap hashMap6 = hashMap5;
        try {
            r19 = hashMap4;
            try {
                r20 = this.OooO0o0.listFilesInDir(prepareContext.getFrameWorkModel());
                try {
                } catch (Throwable unused) {
                    prepareController.moveToError(new PrepareException("14", "frameworkzip error"));
                    TmcLogger.d(this.OooO00o, "请先下载框架包资源文件：");
                    str5 = r19;
                    str4 = r20;
                    try {
                        listFilesInDir = this.OooO0o0.listFilesInDir(appModel3);
                    } catch (Throwable th) {
                        prepareController.moveToError(new PrepareException(str11, th.getMessage()));
                        TmcLogger.d(this.OooO00o, "资源文件出错");
                    }
                    if (listFilesInDir != null) {
                        OooO00o(appModel3, listFilesInDir, str, hashMap, iPackageResourceManager, "");
                        if (AppUtils.INSTANCE.checkUesCommonresApp(appModel3.getMiniappSubtype())) {
                        }
                        AppLoadResult appLoadResult = new AppLoadResult();
                        appLoadResult.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel3);
                        appLoadResult.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
                        commonResModel = prepareContext.getCommonResModel();
                        if (commonResModel != null) {
                        }
                        String appId2 = appModel3.getAppId();
                        obj2 = obj;
                        str10 = (String) str.get(obj2);
                        if (str10 != null) {
                        }
                        appModel2 = appModel;
                        str7 = str3;
                        str9 = (String) appModel2.get(obj2);
                        if (str9 != null) {
                        }
                        String str12 = str5;
                        String str13 = str4;
                        if (str6 != null) {
                        }
                        appLoadResult.htmlMap = hashMap;
                        appLoadResult.appType = TmcConstants.TYPE_WEB_TINY;
                        appLoadResult.frameWorkModel = prepareContext.getFrameWorkModel();
                        new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult;
                        PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(prepareContext);
                        prepareCallbackParam.appLoadResult = appLoadResult;
                        return prepareCallbackParam;
                    }
                    AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel3);
                    prepareController.moveToError(new PrepareException(str11, "miniappzip error"));
                    AppLoadResult appLoadResult2 = new AppLoadResult();
                    appLoadResult2.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel3);
                    appLoadResult2.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
                    commonResModel = prepareContext.getCommonResModel();
                    if (commonResModel != null) {
                    }
                    String appId22 = appModel3.getAppId();
                    obj2 = obj;
                    str10 = (String) str.get(obj2);
                    if (str10 != null) {
                    }
                    appModel2 = appModel;
                    str7 = str3;
                    str9 = (String) appModel2.get(obj2);
                    if (str9 != null) {
                    }
                    String str122 = str5;
                    String str132 = str4;
                    if (str6 != null) {
                    }
                    appLoadResult2.htmlMap = hashMap;
                    appLoadResult2.appType = TmcConstants.TYPE_WEB_TINY;
                    appLoadResult2.frameWorkModel = prepareContext.getFrameWorkModel();
                    new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult2;
                    PrepareCallbackParam prepareCallbackParam2 = new PrepareCallbackParam(prepareContext);
                    prepareCallbackParam2.appLoadResult = appLoadResult2;
                    return prepareCallbackParam2;
                }
            } catch (Throwable unused2) {
                str2 = "_used";
                cls = MiniAppConfigModel.class;
                str3 = PrepareException.ERROR_MANIFEST_INFO;
                r20 = "frameworkConfig.json error";
                obj = "appConfig.json";
                hashMap = hashMap6;
                hashMap6 = r19;
                str11 = str;
                str = hashMap2;
                r19 = "frameworkConfig 不存在：";
                appModel3 = appModel;
                appModel = hashMap3;
            }
        } catch (Throwable unused3) {
            str2 = "_used";
            cls = MiniAppConfigModel.class;
            str3 = PrepareException.ERROR_MANIFEST_INFO;
            r19 = "frameworkConfig 不存在：";
            r20 = "frameworkConfig.json error";
            obj = "appConfig.json";
            appModel3 = appModel;
            hashMap = hashMap6;
            str11 = str;
            hashMap6 = hashMap4;
            appModel = hashMap3;
            str = hashMap2;
        }
        if (r20 == 0 || r20.isEmpty()) {
            str2 = "_used";
            cls = MiniAppConfigModel.class;
            str3 = PrepareException.ERROR_MANIFEST_INFO;
            str4 = "frameworkConfig.json error";
            obj = "appConfig.json";
            hashMap = hashMap6;
            hashMap6 = r19;
            str = hashMap2;
            str5 = "frameworkConfig 不存在：";
            appModel3 = appModel;
            appModel = hashMap3;
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), prepareContext.getFrameWorkModel());
            prepareController.moveToError(new PrepareException("14", "frameworkzip error"));
            AppLoadResult appLoadResult22 = new AppLoadResult();
            appLoadResult22.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel3);
            appLoadResult22.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
            commonResModel = prepareContext.getCommonResModel();
            if (commonResModel != null) {
                str6 = commonResModel.getAppId();
                if (str6 != null && !str6.isEmpty()) {
                    this.OooO0O0.updateAppModel(prepareContext.getStartContext(), commonResModel, str6 + str2);
                    try {
                        prepareContext.getAppModel().setCurrentUseCommonResVersion(commonResModel.getDeployVersion());
                    } catch (Throwable unused4) {
                    }
                }
            } else {
                str6 = "";
            }
            String appId222 = appModel3.getAppId();
            obj2 = obj;
            str10 = (String) str.get(obj2);
            if (str10 != null) {
                cls2 = cls;
                try {
                    appLoadResult22.appConfigModel = (MiniAppConfigModel) JsonUtil.INSTANCE.fromJson(this.OooO0o0.readFile2String(iPackageResourceManager.getFilePath(appId222, str10)), cls2);
                } catch (Throwable unused5) {
                    TmcLogger.d(this.OooO00o, "appConfig不存在：");
                    str7 = str3;
                    prepareController.moveToError(new PrepareException(str7, "appConfig.json error"));
                    appModel2 = appModel;
                    str9 = (String) appModel2.get(obj2);
                    if (str9 != null) {
                    }
                    String str1222 = str5;
                    String str1322 = str4;
                    if (str6 != null) {
                    }
                    appLoadResult22.htmlMap = hashMap;
                    appLoadResult22.appType = TmcConstants.TYPE_WEB_TINY;
                    appLoadResult22.frameWorkModel = prepareContext.getFrameWorkModel();
                    new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult22;
                    PrepareCallbackParam prepareCallbackParam22 = new PrepareCallbackParam(prepareContext);
                    prepareCallbackParam22.appLoadResult = appLoadResult22;
                    return prepareCallbackParam22;
                }
            } else {
                cls2 = cls;
            }
            appModel2 = appModel;
            str7 = str3;
            str9 = (String) appModel2.get(obj2);
            if (str9 != null) {
                appLoadResult22.frameworkConfigModel = (MiniAppConfigModel) JsonUtil.INSTANCE.fromJson(this.OooO0o0.readFile2String(iPackageResourceManager.getFilePath("100000", str9)), cls2);
            }
            String str12222 = str5;
            String str13222 = str4;
            if (str6 != null && !str6.isEmpty()) {
                try {
                    str8 = (String) hashMap6.get(obj2);
                    if (str8 != null) {
                        appLoadResult22.commonResAppConfigModel = (MiniAppConfigModel) JsonUtil.INSTANCE.fromJson(this.OooO0o0.readFile2String(iPackageResourceManager.getFilePath(str6, str8)), cls2);
                    }
                } catch (Throwable unused6) {
                    prepareController.moveToError(new PrepareException(str7, str13222));
                    TmcLogger.d(this.OooO00o, str12222);
                }
            }
            appLoadResult22.htmlMap = hashMap;
            appLoadResult22.appType = TmcConstants.TYPE_WEB_TINY;
            appLoadResult22.frameWorkModel = prepareContext.getFrameWorkModel();
            new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult22;
            PrepareCallbackParam prepareCallbackParam222 = new PrepareCallbackParam(prepareContext);
            prepareCallbackParam222.appLoadResult = appLoadResult22;
            return prepareCallbackParam222;
        }
        AppModel frameWorkModel = prepareContext.getFrameWorkModel();
        hashMap = hashMap6;
        hashMap6 = r19;
        str5 = "frameworkConfig 不存在：";
        appModel3 = appModel;
        appModel = hashMap3;
        str4 = "frameworkConfig.json error";
        str11 = str;
        str = hashMap2;
        str2 = "_used";
        obj = "appConfig.json";
        cls = MiniAppConfigModel.class;
        str3 = PrepareException.ERROR_MANIFEST_INFO;
        OooO00o(frameWorkModel, r20, appModel, hashMap, iPackageResourceManager, "");
        listFilesInDir = this.OooO0o0.listFilesInDir(appModel3);
        if (listFilesInDir != null && !listFilesInDir.isEmpty()) {
            OooO00o(appModel3, listFilesInDir, str, hashMap, iPackageResourceManager, "");
            if (AppUtils.INSTANCE.checkUesCommonresApp(appModel3.getMiniappSubtype())) {
                try {
                    AppModel commonResModel2 = prepareContext.getCommonResModel();
                    if (commonResModel2 != null) {
                        List listFilesInDir2 = this.OooO0o0.listFilesInDir(commonResModel2);
                        if (listFilesInDir2 != null && !listFilesInDir2.isEmpty()) {
                            OooO00o(commonResModel2, listFilesInDir2, hashMap6, hashMap, iPackageResourceManager, "");
                        }
                        AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), commonResModel2);
                        prepareController.moveToError(new PrepareException(str11, "miniappzip error"));
                    }
                } catch (Throwable th2) {
                    prepareController.moveToError(new PrepareException(str11, th2.getMessage()));
                    TmcLogger.d(this.OooO00o, "资源文件出错");
                }
            }
            AppLoadResult appLoadResult222 = new AppLoadResult();
            appLoadResult222.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel3);
            appLoadResult222.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
            commonResModel = prepareContext.getCommonResModel();
            if (commonResModel != null) {
            }
            String appId2222 = appModel3.getAppId();
            obj2 = obj;
            str10 = (String) str.get(obj2);
            if (str10 != null) {
            }
            appModel2 = appModel;
            str7 = str3;
            str9 = (String) appModel2.get(obj2);
            if (str9 != null) {
            }
            String str122222 = str5;
            String str132222 = str4;
            if (str6 != null) {
                str8 = (String) hashMap6.get(obj2);
                if (str8 != null) {
                }
            }
            appLoadResult222.htmlMap = hashMap;
            appLoadResult222.appType = TmcConstants.TYPE_WEB_TINY;
            appLoadResult222.frameWorkModel = prepareContext.getFrameWorkModel();
            new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult222;
            PrepareCallbackParam prepareCallbackParam2222 = new PrepareCallbackParam(prepareContext);
            prepareCallbackParam2222.appLoadResult = appLoadResult222;
            return prepareCallbackParam2222;
        }
        AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel3);
        prepareController.moveToError(new PrepareException(str11, "miniappzip error"));
        AppLoadResult appLoadResult2222 = new AppLoadResult();
        appLoadResult2222.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel3);
        appLoadResult2222.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
        commonResModel = prepareContext.getCommonResModel();
        if (commonResModel != null) {
        }
        String appId22222 = appModel3.getAppId();
        obj2 = obj;
        str10 = (String) str.get(obj2);
        if (str10 != null) {
        }
        appModel2 = appModel;
        str7 = str3;
        str9 = (String) appModel2.get(obj2);
        if (str9 != null) {
        }
        String str1222222 = str5;
        String str1322222 = str4;
        if (str6 != null) {
        }
        appLoadResult2222.htmlMap = hashMap;
        appLoadResult2222.appType = TmcConstants.TYPE_WEB_TINY;
        appLoadResult2222.frameWorkModel = prepareContext.getFrameWorkModel();
        new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult2222;
        PrepareCallbackParam prepareCallbackParam22222 = new PrepareCallbackParam(prepareContext);
        prepareCallbackParam22222.appLoadResult = appLoadResult2222;
        return prepareCallbackParam22222;
    }
}
