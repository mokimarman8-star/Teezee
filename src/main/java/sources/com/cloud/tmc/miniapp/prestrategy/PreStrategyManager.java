package com.cloud.tmc.miniapp.prestrategy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.LauncherPreDataModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyBaseModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyModel;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.MccMncUtils;
import com.cloud.tmc.integration.utils.UrlUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.KUrlUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PreStrategyManager {
    public static long OooO0O0;
    public static HashMap<String, Boolean> OooO0Oo;
    public static long OooO0o0;
    public static final PreStrategyManager OooO00o = new PreStrategyManager();
    public static Map<String, String> OooO0OO = MapsKt.m(new Pair[]{TuplesKt.a("keyZeroRecentData", "zeroRecent"), TuplesKt.a("keyZeroMinicardData", "zeroCard"), TuplesKt.a("keyZeroMinicardUpdate", "zeroCard"), TuplesKt.a("keyFullRecentMiniData", "fullSearchRecent"), TuplesKt.a("keyFullMinicardData", "fullSearchCard"), TuplesKt.a("keyAzRecentData", "azRecent"), TuplesKt.a("keyFullSearchAppData", "fullSearchApp"), TuplesKt.a("keyZeroBannerData", "zeroBanner"), TuplesKt.a("keyMiniAppStart", "miniappStart"), TuplesKt.a(TmcConstants.KEY_MC_RECOMMEND_START, "miniappCenterRecommend")});
    public static final long OooO0o = 3600000;

    public static final void OooO0OO(Context context, String str, String str2, Function1 function1) {
        Intrinsics.h(str, "$type");
        OooO00o.OooO00o(context, str, str2, (Function1<? super Boolean, Unit>) function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0163 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:48:0x0146, B:50:0x0150, B:53:0x015d, B:55:0x0163, B:56:0x0169, B:58:0x0171, B:59:0x0177, B:62:0x0189, B:67:0x0197, B:74:0x01a0), top: B:47:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0171 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:48:0x0146, B:50:0x0150, B:53:0x015d, B:55:0x0163, B:56:0x0169, B:58:0x0171, B:59:0x0177, B:62:0x0189, B:67:0x0197, B:74:0x01a0), top: B:47:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(Context context, String str, String str2, Function1<? super Boolean, Unit> function1) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        JsonObject config;
        ArrayList<String> arrayList;
        Object obj;
        try {
            ArrayList<LauncherPreDataModel> OooO0O02 = OooO0O0(context, str, str2);
            if (OooO0O02.isEmpty()) {
                TmcLogger.e("Prefetch:PreStrategyManager", "getLauncherData is empty");
                return;
            }
            OooO0OO oooO0OO = OooO0OO.OooO00o;
            if (oooO0OO.OooO0O0()) {
                oooO0OO.OooO00o(context, str, OooO0O02);
                return;
            }
            LauncherPreStrategyBaseModel OooO0O03 = OooO00o.OooO00o.OooO0O0(context);
            if (OooO0O03 == null) {
                TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyConfig is null");
                return;
            }
            for (LauncherPreDataModel launcherPreDataModel : OooO0O02) {
                String appId = launcherPreDataModel.getAppId();
                Bundle bundle = new Bundle();
                if (appId == null || appId.length() == 0) {
                    String schemeUrl = launcherPreDataModel.getSchemeUrl();
                    if (schemeUrl == null || schemeUrl.length() == 0) {
                        TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing schemeUrl is null");
                    } else {
                        boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_FIX_ENCODE_URL, true);
                        UrlUtil urlUtil = UrlUtil.INSTANCE;
                        Uri parse = Uri.parse(urlUtil.fixEncodeUrl(schemeUrl, configTargetBool));
                        String queryParameter = parse.getQueryParameter("appId");
                        if (queryParameter == null || queryParameter.length() == 0) {
                            TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
                        } else {
                            String queryParameter2 = parse.getQueryParameter("query");
                            if (queryParameter2 != null) {
                                Intrinsics.g(queryParameter2, "it");
                                bundle.putString("query", urlUtil.getFixDecodeUrl(queryParameter2, configTargetBool));
                            }
                            String queryParameter3 = parse.getQueryParameter("h5Path");
                            if (queryParameter3 != null) {
                                Intrinsics.g(queryParameter3, "it");
                                bundle.putString("h5Path", urlUtil.getFixDecodeUrl(queryParameter3, configTargetBool));
                            }
                            String queryParameter4 = parse.getQueryParameter("hybridPath");
                            if (queryParameter4 != null) {
                                String decode = UrlUtils.decode(queryParameter4);
                                if (decode == null) {
                                    decode = "";
                                }
                                Intrinsics.g(decode, "UrlUtils.decode(it) ?: \"\"");
                                bundle.putString("hybridPath", urlUtil.getFixDecodeUrl(decode, configTargetBool));
                            }
                            launcherPreDataModel.setAppId(queryParameter);
                            launcherPreDataModel.setBundle(bundle);
                            appId = queryParameter;
                        }
                    }
                }
                ArrayList configList = OooO0O03.getConfigList();
                if (configList != null) {
                    Iterator it = configList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.c(((LauncherPreStrategyModel) obj).getAppId(), appId)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    launcherPreStrategyModel = (LauncherPreStrategyModel) obj;
                } else {
                    launcherPreStrategyModel = null;
                }
                if (launcherPreStrategyModel == null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("failReason", "get configModel is null");
                    bundle2.putString("failAppId", String.valueOf(appId));
                    preHtmStrategyProxy.trackPreStrategyFailPoint(bundle2);
                }
                if (launcherPreStrategyModel == null || (config = launcherPreStrategyModel.getConfig()) == null) {
                    TmcLogger.e("Prefetch:PreStrategyManager", ((Object) appId) + " preStrategyConfig.configList.config is null");
                } else {
                    PreStrategyManager preStrategyManager = OooO00o;
                    if (preStrategyManager.OooO00o(context, launcherPreStrategyModel)) {
                        try {
                            String str3 = OooO0OO.get(str);
                            if (str3 != null) {
                                if (str3.length() == 0) {
                                }
                                JsonElement jsonElement = config.get(str3);
                                String jsonElement2 = jsonElement == null ? jsonElement.toString() : null;
                                JsonElement jsonElement3 = config.get("preHtmlWhiteList");
                                String jsonElement4 = jsonElement3 == null ? jsonElement3.toString() : null;
                                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategyProcessing$1$setType$1
                                }.getType();
                                arrayList = (ArrayList) GsonUtils.fromJson(jsonElement2, type);
                                if (arrayList == null) {
                                    arrayList = null;
                                }
                                ArrayList<String> arrayList2 = (ArrayList) GsonUtils.fromJson(jsonElement4, type);
                                ArrayList<String> arrayList3 = arrayList2 != null ? arrayList2 : null;
                                if (arrayList != null || arrayList.isEmpty()) {
                                    TmcLogger.e("Prefetch:PreStrategyManager", ((Object) appId) + "-> " + str3 + " config is null ");
                                } else {
                                    TmcLogger.e("Prefetch:PreStrategyManager", ((Object) appId) + "-> " + str3 + " start fetch config");
                                    try {
                                        preStrategyManager.OooO00o(launcherPreDataModel, arrayList, arrayList3, function1);
                                    } catch (Throwable th) {
                                        th = th;
                                        TmcLogger.e("Prefetch:PreStrategyManager", th);
                                    }
                                }
                            }
                            str3 = str;
                            JsonElement jsonElement5 = config.get(str3);
                            if (jsonElement5 == null) {
                            }
                            JsonElement jsonElement32 = config.get("preHtmlWhiteList");
                            if (jsonElement32 == null) {
                            }
                            Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategyProcessing$1$setType$1
                            }.getType();
                            arrayList = (ArrayList) GsonUtils.fromJson(jsonElement2, type2);
                            if (arrayList == null) {
                            }
                            ArrayList<String> arrayList22 = (ArrayList) GsonUtils.fromJson(jsonElement4, type2);
                            if (arrayList22 != null) {
                            }
                            if (arrayList != null) {
                            }
                            TmcLogger.e("Prefetch:PreStrategyManager", ((Object) appId) + "-> " + str3 + " config is null ");
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", ((Object) appId) + " preStrategyConfig config is not suitable.");
                    }
                }
            }
        } catch (Throwable th3) {
            TmcLogger.e("Prefetch:PreStrategyManager", "perStrategyProcessing", th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:35:0x00ac, B:39:0x00b6, B:42:0x00c1, B:44:0x00c7, B:45:0x00cd, B:47:0x00d5, B:48:0x00db, B:51:0x00ed, B:56:0x00fa, B:64:0x0101, B:60:0x0120), top: B:34:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:35:0x00ac, B:39:0x00b6, B:42:0x00c1, B:44:0x00c7, B:45:0x00cd, B:47:0x00d5, B:48:0x00db, B:51:0x00ed, B:56:0x00fa, B:64:0x0101, B:60:0x0120), top: B:34:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(Context context, List<String> list, String str) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, FrameworkConstants.GLOBAL_DATA_KEY_SCENE);
        if (list == null || list.isEmpty()) {
            return;
        }
        OooO0OO oooO0OO = OooO0OO.OooO00o;
        if (oooO0OO.OooO0O0()) {
            oooO0OO.OooO00o(context, str, list, null);
            return;
        }
        LauncherPreStrategyBaseModel OooO0O02 = OooO00o.OooO00o.OooO0O0(context);
        if (OooO0O02 == null) {
            TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyConfig is null");
            return;
        }
        for (String str2 : list) {
            ArrayList configList = OooO0O02.getConfigList();
            if (configList != null) {
                Iterator it = configList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.c(((LauncherPreStrategyModel) obj).getAppId(), str2)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                launcherPreStrategyModel = (LauncherPreStrategyModel) obj;
            } else {
                launcherPreStrategyModel = null;
            }
            JsonObject config = launcherPreStrategyModel != null ? launcherPreStrategyModel.getConfig() : null;
            if (config == null) {
                TmcLogger.e("Prefetch:PreStrategyManager", str2 + " preStrategyConfig.configList.config is null");
            } else if (OooO00o(context, launcherPreStrategyModel)) {
                LauncherPreDataModel launcherPreDataModel = new LauncherPreDataModel(str2, (String) null, new Bundle());
                try {
                    String str3 = OooO0OO.get(str);
                    if (str3 != null) {
                        if (str3.length() == 0) {
                        }
                        JsonElement jsonElement = config.get(str3);
                        String jsonElement2 = jsonElement == null ? jsonElement.toString() : null;
                        JsonElement jsonElement3 = config.get("preHtmlWhiteList");
                        String jsonElement4 = jsonElement3 == null ? jsonElement3.toString() : null;
                        Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategy$setType$1
                        }.getType();
                        arrayList = (ArrayList) GsonUtils.fromJson(jsonElement2, type);
                        if (arrayList == null) {
                            arrayList = null;
                        }
                        arrayList2 = (ArrayList) GsonUtils.fromJson(jsonElement4, type);
                        if (arrayList2 == null) {
                            arrayList2 = null;
                        }
                        if (arrayList != null && !arrayList.isEmpty()) {
                            TmcLogger.e("Prefetch:PreStrategyManager", str2 + "-> " + str3 + " start fetch config");
                            OooO00o(launcherPreDataModel, arrayList, arrayList2, (Function1<? super Boolean, Unit>) null);
                        }
                        TmcLogger.e("Prefetch:PreStrategyManager", str2 + "-> " + str3 + " config is null ");
                    }
                    str3 = str;
                    JsonElement jsonElement5 = config.get(str3);
                    if (jsonElement5 == null) {
                    }
                    JsonElement jsonElement32 = config.get("preHtmlWhiteList");
                    if (jsonElement32 == null) {
                    }
                    Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategy$setType$1
                    }.getType();
                    arrayList = (ArrayList) GsonUtils.fromJson(jsonElement2, type2);
                    if (arrayList == null) {
                    }
                    arrayList2 = (ArrayList) GsonUtils.fromJson(jsonElement4, type2);
                    if (arrayList2 == null) {
                    }
                    if (arrayList != null) {
                        TmcLogger.e("Prefetch:PreStrategyManager", str2 + "-> " + str3 + " start fetch config");
                        OooO00o(launcherPreDataModel, arrayList, arrayList2, (Function1<? super Boolean, Unit>) null);
                    }
                    TmcLogger.e("Prefetch:PreStrategyManager", str2 + "-> " + str3 + " config is null ");
                } catch (Throwable th) {
                    TmcLogger.e("Prefetch:PreStrategyManager", th);
                }
            } else {
                TmcLogger.e("Prefetch:PreStrategyManager", str2 + " preStrategyConfig config is not suitable.");
            }
        }
    }

    public final void OooO00o(LauncherPreDataModel launcherPreDataModel, ArrayList<String> arrayList, ArrayList<String> arrayList2, Function1<? super Boolean, Unit> function1) {
        Unit unit;
        String str;
        ExtendModel extend;
        Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        if (application$com_cloud_tmc_miniapp_sdk == null) {
            TmcLogger.e("Prefetch:PreStrategyManager", "executePrefetchConfig application is null");
            return;
        }
        String appId = launcherPreDataModel.getAppId();
        if (appId == null || appId.length() == 0) {
            TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
            return;
        }
        TmcLogger.e("Prefetch:PreStrategyManager", appId + " start pre strategy.");
        if (arrayList != null) {
            for (String str2 : arrayList) {
                if (Intrinsics.c(str2, "preHtml")) {
                    if (OooO00o.OooO0Oo()) {
                        AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(application$com_cloud_tmc_miniapp_sdk, AppInfoQuery.Companion.make(appId));
                        if (appModel == null) {
                            PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("failReason", "get appModel is null");
                            bundle.putString("failAppId", String.valueOf(appId));
                            preHtmStrategyProxy.trackPreStrategyFailPoint(bundle);
                        }
                        if (appModel == null || (extend = appModel.getExtend()) == null || (str = extend.getH5Url()) == null) {
                            str = "";
                        }
                        if (str.length() == 0) {
                            TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->h5Url is empty ,return!");
                        } else {
                            String generateShellUrl = KUrlUtils.generateShellUrl(str, launcherPreDataModel.getBundle());
                            TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_PREHTML ->" + appId + "  ->" + generateShellUrl);
                            if (arrayList2 == null || arrayList2.isEmpty()) {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->preWhiteList is null or empty");
                                Object obj = TmcProxy.get(PreHtmStrategyProxy.class);
                                Intrinsics.g(obj, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.DefaultImpls.requestHtml$default((PreHtmStrategyProxy) obj, application$com_cloud_tmc_miniapp_sdk, generateShellUrl, (Function1) null, 4, (Object) null);
                            } else if (arrayList2.contains(UrlUtils.getHost(generateShellUrl))) {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->host is preWhiteList ->" + generateShellUrl);
                                Object obj2 = TmcProxy.get(PreHtmStrategyProxy.class);
                                Intrinsics.g(obj2, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.DefaultImpls.requestHtml$default((PreHtmStrategyProxy) obj2, application$com_cloud_tmc_miniapp_sdk, generateShellUrl, (Function1) null, 4, (Object) null);
                            } else {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->host is not preWhiteList ->" + generateShellUrl + " ");
                            }
                        }
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", appId + " ->checkEnablePreHtmlConfig enable status is false");
                    }
                } else if (Intrinsics.c(str2, "preAppInfo")) {
                    if (OooO00o.OooO0O0()) {
                        TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO ->" + appId + " ");
                        com.cloud.tmc.miniapp.prestrategy.strategy.OooO00o.OooO00o.OooO00o(application$com_cloud_tmc_miniapp_sdk, appId);
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO enable status is false");
                    }
                } else if (Intrinsics.c(str2, "rendering")) {
                    TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_RENDERING ->" + appId);
                } else if (Intrinsics.c(str2, "preOfflinePackage")) {
                    if (OooO00o.OooO0o0()) {
                        TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE ->" + appId + " ");
                        com.cloud.tmc.miniapp.prestrategy.strategy.OooO0O0.OooO00o.OooO00o(application$com_cloud_tmc_miniapp_sdk, appId);
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE enable status is false");
                    }
                } else if (Intrinsics.c(str2, LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER)) {
                    TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_OFF_SCREEN_RENDER ->" + appId);
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
            unit = Unit.a;
        } else {
            unit = null;
        }
        if (unit == null) {
            TmcLogger.e("Prefetch:PreStrategyManager", "executePrefetchConfig list is null");
        }
    }

    public final boolean OooO00o() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_OPEN_BROWSER_CONFIG, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ab, code lost:
    
        if (r6.length() != 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02ae, code lost:
    
        r3 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE;
        kotlin.jvm.internal.Intrinsics.g(r11, "curSDKVersion");
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02b7, code lost:
    
        if (r3.compareVersion(r11, r6) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b9, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e("Prefetch:PreStrategyManager", r12.getAppId() + " cur sdk:" + r11 + " > " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02d8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x007e, code lost:
    
        if (r2 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0080, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e("Prefetch:PreStrategyManager", r12.getAppId() + " netType disallow, config.netType = " + r12.getNetType());
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x009f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x006e, code lost:
    
        if (r2 != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean OooO00o(Context context, LauncherPreStrategyModel launcherPreStrategyModel) {
        String str;
        String str2;
        Object obj;
        ArrayList whiteModelList;
        Object obj2;
        if (context == null) {
            return false;
        }
        try {
            Long validTime = launcherPreStrategyModel.getValidTime();
            long longValue = validTime != null ? validTime.longValue() : -1L;
            if (longValue > 0 && System.currentTimeMillis() > longValue) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " config is already expired.");
                return false;
            }
            if (!NetworkUtils.isConnected()) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " current network is not connected.");
                return false;
            }
            boolean isMobileData = NetworkUtils.isMobileData();
            Integer netType = launcherPreStrategyModel.getNetType();
            if (netType != null) {
                if (netType.intValue() == 1) {
                }
            }
            Integer netType2 = launcherPreStrategyModel.getNetType();
            if (netType2 != null) {
                if (netType2.intValue() == 2) {
                }
            }
            String str3 = Build.MODEL;
            ArrayList blackModelList = launcherPreStrategyModel.getBlackModelList();
            String str4 = null;
            if (blackModelList != null) {
                Iterator it = blackModelList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (StringsKt.H((String) obj2, str3, true)) {
                        break;
                    }
                }
                str = (String) obj2;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " " + str3 + " in blackModelList. ");
                return false;
            }
            ArrayList whiteModelList2 = launcherPreStrategyModel.getWhiteModelList();
            if (whiteModelList2 != null && !whiteModelList2.isEmpty() && (whiteModelList = launcherPreStrategyModel.getWhiteModelList()) != null && !whiteModelList.contains(str3)) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " " + str3 + " not in whiteModelList. ");
                return false;
            }
            String countryCode = MccMncUtils.getCountryCode(context);
            ArrayList blackCountryList = launcherPreStrategyModel.getBlackCountryList();
            if (blackCountryList != null) {
                Iterator it2 = blackCountryList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (StringsKt.H((String) obj, countryCode, true)) {
                        break;
                    }
                }
                str2 = (String) obj;
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " " + countryCode + " in blackCountryList. ");
                return false;
            }
            ArrayList whiteCountryList = launcherPreStrategyModel.getWhiteCountryList();
            if (whiteCountryList != null && !whiteCountryList.isEmpty()) {
                ArrayList whiteCountryList2 = launcherPreStrategyModel.getWhiteCountryList();
                if (whiteCountryList2 != null) {
                    Iterator it3 = whiteCountryList2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object next = it3.next();
                        if (StringsKt.H((String) next, countryCode, true)) {
                            str4 = next;
                            break;
                        }
                    }
                    str4 = str4;
                }
                if (str4 == null || str4.length() == 0) {
                    TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " " + countryCode + " not in whiteCountryList. ");
                    return false;
                }
            }
            AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(context, new AppInfoQuery("100000"));
            if (appModel == null) {
                return false;
            }
            String deployVersion = appModel.getDeployVersion();
            if (deployVersion == null) {
                deployVersion = "";
            }
            String lowestFrameworkVersion = launcherPreStrategyModel.getLowestFrameworkVersion();
            String highestFrameworkVersion = launcherPreStrategyModel.getHighestFrameworkVersion();
            if (lowestFrameworkVersion != null && lowestFrameworkVersion.length() != 0 && MiniAppLaunch.INSTANCE.compareVersion(lowestFrameworkVersion, deployVersion)) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur framework:" + deployVersion + " < " + lowestFrameworkVersion);
                return false;
            }
            if (highestFrameworkVersion != null && highestFrameworkVersion.length() != 0 && MiniAppLaunch.INSTANCE.compareVersion(deployVersion, highestFrameworkVersion)) {
                TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur framework:" + deployVersion + " > " + highestFrameworkVersion);
                return false;
            }
            String devSDKVersion = ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getDevSDKVersion();
            String lowestSDKVersion = launcherPreStrategyModel.getLowestSDKVersion();
            String highestSDKVersion = launcherPreStrategyModel.getHighestSDKVersion();
            if (lowestSDKVersion != null && lowestSDKVersion.length() != 0) {
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                Intrinsics.g(devSDKVersion, "curSDKVersion");
                if (miniAppLaunch.compareVersion(lowestSDKVersion, devSDKVersion)) {
                    TmcLogger.e("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur sdk:" + devSDKVersion + " < " + lowestSDKVersion);
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:PreStrategyManager", th);
            return false;
        }
    }

    public final boolean OooO00o(Context context, String str, String str2) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        JsonArray asJsonArray;
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        try {
            if (OooO0OO.OooO00o.OooO0O0()) {
                TmcLogger.e("Prefetch:PreStrategyManager", "new prefetch config. not open browser.");
                return false;
            }
            if (!OooO00o()) {
                TmcLogger.e("Prefetch:PreStrategyManager", "checkEnableOpenBrowserConfig is false");
                return false;
            }
            String OooO0O02 = OooO0O0(str2);
            if (OooO0O02 != null && OooO0O02.length() != 0) {
                LauncherPreStrategyBaseModel OooO0O03 = OooO00o.OooO00o.OooO0O0(context);
                if (OooO0O03 == null) {
                    TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyConfig is null");
                    return false;
                }
                ArrayList configList = OooO0O03.getConfigList();
                Object obj2 = null;
                if (configList != null) {
                    Iterator it = configList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.c(((LauncherPreStrategyModel) obj).getAppId(), str)) {
                            break;
                        }
                    }
                    launcherPreStrategyModel = (LauncherPreStrategyModel) obj;
                } else {
                    launcherPreStrategyModel = null;
                }
                JsonObject commonConfig = launcherPreStrategyModel != null ? launcherPreStrategyModel.getCommonConfig() : null;
                if (commonConfig == null) {
                    TmcLogger.e("Prefetch:PreStrategyManager", str + " preStrategyConfig.commonConfig is null");
                    return false;
                }
                Long openBrowserTime = launcherPreStrategyModel.getOpenBrowserTime();
                long longValue = openBrowserTime != null ? openBrowserTime.longValue() : -1L;
                if (longValue >= 0 && longValue <= System.currentTimeMillis()) {
                    JsonElement jsonElement = commonConfig.get(OooO0O02);
                    if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
                        Iterator it2 = asJsonArray.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.c(((JsonElement) next).getAsString(), "allowOpenBrowser")) {
                                obj2 = next;
                                break;
                            }
                        }
                        if (((JsonElement) obj2) != null) {
                            return true;
                        }
                    }
                    return false;
                }
                TmcLogger.e("Prefetch:PreStrategyManager", str + " preStrategyConfig.openBrowserTime = " + longValue + " is not suitable.");
                return false;
            }
            TmcLogger.e("Prefetch:PreStrategyManager", "openScene is null");
            return false;
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:PreStrategyManager", th);
            return false;
        }
    }

    public final boolean OooO00o(String str) {
        try {
            if (OooO0Oo == null || System.currentTimeMillis() - OooO0o0 > OooO0o) {
                OooO0o0 = System.currentTimeMillis();
                OooO0Oo = (HashMap) GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PRE_MANAGER_ENABLE_CONFIG, LauncherMiniAppConfigHelper.DEFAULT_PRE_MANAGER_ENABLE_CONFIG), (Type) HashMap.class);
            }
            HashMap<String, Boolean> hashMap = OooO0Oo;
            Boolean bool = hashMap != null ? hashMap.get(str) : null;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String OooO0O0(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 1448635040:
                    if (str.equals(TmcConstants.KEY_PREFETCH_ZERO_CARD)) {
                        return "fullSearchApp";
                    }
                    break;
                case 1448635042:
                    if (str.equals(TmcConstants.KEY_PREFETCH_ZERO_BANNER)) {
                        return "zeroCard";
                    }
                    break;
                case 1448635048:
                    if (str.equals(TmcConstants.KEY_PREFETCH_PIN)) {
                        return "miniappCenterRecommend";
                    }
                    break;
                case 1449558561:
                    if (!str.equals("110001")) {
                    }
                    break;
                case 1449558562:
                    if (str.equals("110002")) {
                        return "fullSearchRecent";
                    }
                    break;
                case 1449558564:
                    if (str.equals("110004")) {
                        return "azRecent";
                    }
                    break;
                case 1449558565:
                    if (str.equals("110005")) {
                        return "zeroRecent";
                    }
                    break;
                case 1449558594:
                    if (str.equals("110013")) {
                        return "fullSearchCard";
                    }
                    break;
            }
        }
        return null;
    }

    public final ArrayList<LauncherPreDataModel> OooO0O0(Context context, String str, String str2) {
        ArrayList<LauncherPreDataModel> arrayList;
        Intrinsics.h(str, "key");
        if (context == null || str2 == null) {
            arrayList = null;
        } else {
            try {
                TmcLogger.d("Prefetch:PreStrategyManager", "preStrategyProcessing -> " + str + " -> " + str2);
                arrayList = (ArrayList) GsonUtils.fromJson(str2, new TypeToken<List<LauncherPreDataModel>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$getLauncherData$1$1$1
                }.getType());
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:PreStrategyManager", "getLauncherData", th);
                return new ArrayList<>();
            }
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final void OooO0O0(final Context context, final String str, final String str2, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_TYPE);
        if (ProcessUtils.isMiniProcess()) {
            try {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.prestrategy.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreStrategyManager.OooO0OO(context, str, str2, function1);
                    }
                });
                return;
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:PreStrategyManager", th);
                return;
            }
        }
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_TYPE);
        IpcMiniLauncherService.OooO00o oooO00o = IpcMiniLauncherService.OooO00o;
        OooO0O0 oooO0O0 = new OooO0O0(str, str2, context, function1);
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_TYPE);
        try {
            TmcLogger.d(":IpcTaskManagerService", "preLauncherData");
            if (ProcessUtils.isMiniProcess()) {
                TmcLogger.d(":IpcTaskManagerService", "preLauncherData isMiniProcess");
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                Utils.setAppIfNecessary(applicationContext instanceof Application ? (Application) applicationContext : null);
                oooO0O0.OooO00o(false);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) IpcMiniLauncherService.class);
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, context);
            if (context != null) {
                context.bindService(intent, new com.cloud.tmc.miniapp.ipc.OooO0OO(str, context, oooO0O0, str2), 1);
            }
        } catch (Throwable th2) {
            TmcLogger.e(":IpcTaskManagerService", th2);
            oooO0O0.OooO00o(0, th2);
        }
    }

    public final boolean OooO0O0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_APPINFO_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean OooO0OO() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_MANAGER_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r8.equals("keyFullRecentMiniData") != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x0028, B:15:0x004a, B:17:0x005f, B:26:0x00b7, B:28:0x0078, B:31:0x0092, B:33:0x009f, B:35:0x00a5, B:37:0x0081, B:40:0x008a, B:42:0x00af, B:44:0x00bb, B:46:0x00c8, B:48:0x00ce), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x0028, B:15:0x004a, B:17:0x005f, B:26:0x00b7, B:28:0x0078, B:31:0x0092, B:33:0x009f, B:35:0x00a5, B:37:0x0081, B:40:0x008a, B:42:0x00af, B:44:0x00bb, B:46:0x00c8, B:48:0x00ce), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO0Oo(Context context, String str, String str2, Function1<? super Boolean, Unit> function1) {
        Intrinsics.h(str, "key");
        if (context != null) {
            try {
                if (!ByteAppManager.INSTANCE.checkPreInitConfig(context)) {
                    TmcLogger.e("Prefetch:PreStrategyManager", "close pre init subprocess");
                    return;
                }
                PreStrategyManager preStrategyManager = OooO00o;
                if (!preStrategyManager.OooO0OO()) {
                    TmcLogger.e("Prefetch:PreStrategyManager", "checkEnablePreConfig enable status is false  return");
                    return;
                }
                TmcLogger.d("Prefetch:PreStrategyManager", "updateLauncherData " + str + " -> " + str2);
                if (!preStrategyManager.OooO00o(str)) {
                    TmcLogger.e("Prefetch:PreStrategyManager", str + " is not allow execute");
                    return;
                }
                int hashCode = str.hashCode();
                if (hashCode != -2066930763) {
                    if (hashCode != -1879995062) {
                        if (hashCode == -605809219) {
                            if (!str.equals("keyAzRecentData")) {
                            }
                            if (System.currentTimeMillis() - OooO0O0 >= 500) {
                            }
                        } else if (hashCode == 936969644) {
                            if (!str.equals("keyZeroRecentData")) {
                            }
                            if (System.currentTimeMillis() - OooO0O0 >= 500) {
                                TmcLogger.e("Prefetch:PreStrategyManager", "recent update diff < 500ms");
                                return;
                            } else {
                                OooO0O0 = System.currentTimeMillis();
                                preStrategyManager.OooO0O0(context, str, str2, function1);
                                return;
                            }
                        }
                    }
                } else if (str.equals("keyFullSearchAppData")) {
                    if (System.currentTimeMillis() - OooO0O0 < 300) {
                        TmcLogger.e("Prefetch:PreStrategyManager", "KEY_FULL_SEARCH_APP_DATA diff < 500ms");
                        return;
                    } else {
                        OooO0O0 = System.currentTimeMillis();
                        preStrategyManager.OooO0O0(context, str, str2, function1);
                        return;
                    }
                }
                preStrategyManager.OooO0O0(context, str, str2, function1);
            } catch (Throwable th) {
                TmcLogger.e("Prefetch:PreStrategyManager", "updateLauncherData", th);
            }
        }
    }

    public final boolean OooO0Oo() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_HTML_CONFIG, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean OooO0o0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_OFFLINE_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }
}
