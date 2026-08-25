package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.model.PermissionInfoModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherFrameworkConstants;
import com.cloud.tmc.miniapp.ui.AppBrandProfileActivity;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AppManagerDataProviderBridge implements BridgeExtension {
    public final String OooO00o = "AppManagerDataProviderBridge";
    public final String OooO0O0 = "appList";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeAutoUpdateStatus(@BindingNode(App.class) App app, @BindingParam({"status"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_AUTO_UPDATE_STATUS, z);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeMiniappPermission(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingParam({"scopeName"}) String str2, @BindingParam({"status"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(str2, "scopeName");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ScopeUtils.OooO00o.OooO00o(context, str2, str, z, "", "", false, true);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeMsgSwitchStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingParam({"appSwitchStatus"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Context context;
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(str2, "appSwitchStatus");
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO00o(context, str, str2);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
                unit = Unit.a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changePrefetchState(@BindingNode(App.class) App app, @BindingParam({"status"}) int i, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_STATE, i);
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_TIMESTAMP, System.currentTimeMillis());
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeTotalMsgStatus(@BindingNode(App.class) App app, @BindingParam({"mainSwitchStatus"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "status");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mainSwitchStatus", str);
            jsonObject.addProperty("mainSwitchTimestamp", String.valueOf(System.currentTimeMillis()));
            TmcLogger.d(this.OooO00o, "changeTotalMsgStatus: " + jsonObject);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "mainMsgSwitch", jsonObject.toString());
            bridgeCallback.sendSuccessResponse();
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearAllMiniAppCacheData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.INSTANCE.clearAllMiniAppCacheData(context);
            bridgeCallback.sendSuccessResponse(new JsonObject());
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearAllMiniAppData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.INSTANCE.clearAllMiniAppData(context);
            bridgeCallback.sendSuccessResponse(new JsonObject());
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearCacheMsgData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    TmcLogger.d(this.OooO00o, "clearCacheMsgData");
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).clear(context, "miniMsgCacheData");
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearChangedMsgSwitchList(@BindingNode(App.class) App app, @BindingParam({"timestamp"}) long j, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO00o(context, j);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getAutoUpdateStatus(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    boolean z = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_AUTO_UPDATE_STATUS, false);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("status", Boolean.valueOf(z));
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getCacheMsgData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray jsonArray = new JsonArray();
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                    String[] mMKVFileAllKeys = kVStorageProxy.getMMKVFileAllKeys(context, "miniMsgCacheData");
                    Intrinsics.g(mMKVFileAllKeys, "storageProxy.getMMKVFile…vider.KEY_MSG_CACHE_DATA)");
                    Iterator it = ArraysKt.y0(mMKVFileAllKeys).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((JsonObject) JsonUtil.INSTANCE.fromJson(kVStorageProxy.getString(context, "miniMsgCacheData", (String) it.next()), JsonObject.class));
                    }
                    String jsonElement = jsonArray.toString();
                    Intrinsics.g(jsonElement, "msgDataArray.toString()");
                    TmcLogger.d(this.OooO00o, "getCacheMsgData msgCacheObj = " + jsonElement);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("msgData", jsonElement).build());
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getChangedMsgSwitchList(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray OooO0O0 = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0O0(context);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.add(this.OooO0O0, OooO0O0);
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getLatestAppListMsgSwitch(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Context context;
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            JsonArray jsonArray = new JsonArray();
            List<AppStoreInfo> latestUseApps = LatestUseUtils.getLatestUseApps();
            Unit unit = null;
            if (latestUseApps != null) {
                Intrinsics.g(latestUseApps, "getLatestUseApps()");
                for (AppStoreInfo appStoreInfo : latestUseApps) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(TmcConstants.KEY_MINI_APPID, appStoreInfo.getAppId());
                    jsonObject.addProperty("miniappName", appStoreInfo.getName());
                    jsonObject.addProperty("miniappLogo", appStoreInfo.getLogo());
                    com.cloud.tmc.miniapp.utils.OooO0o oooO0o = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o;
                    String appId = appStoreInfo.getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    String OooO0O0 = oooO0o.OooO0O0(context, appId);
                    if (OooO0O0.length() > 0) {
                        JsonObject jsonObject2 = (JsonObject) GsonUtils.fromJson(OooO0O0, JsonObject.class);
                        JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                        String asString = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString == null) {
                            asString = "";
                        }
                        jsonObject.addProperty("appSwitchStatus", asString);
                        JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        jsonObject.addProperty("appSwitchTimestamp", asString2 != null ? asString2 : "");
                    }
                    jsonArray.add(jsonObject);
                }
            }
            TmcLogger.d(this.OooO00o, jsonArray.toString());
            if (bridgeCallback != null) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.add(this.OooO0O0, jsonArray);
                bridgeCallback.sendSuccessResponse(jsonObject3);
                unit = Unit.a;
            }
            if (unit != null) {
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppCacheSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long miniAppCacheSize = FileUtil.getMiniAppCacheSize(context, str);
            TmcLogger.d(this.OooO00o, "getMiniAppCacheSize: " + miniAppCacheSize);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("cacheSize", Long.valueOf(miniAppCacheSize));
            bridgeCallback.sendSuccessResponse(jsonObject);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppFileSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long miniAppFileSize = FileUtil.getMiniAppFileSize(context, str);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(miniAppFileSize));
            bridgeCallback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getMiniAppFileSize: " + miniAppFileSize);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppTotalCacheSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long allMiniAppCacheSize = FileUtil.getAllMiniAppCacheSize(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalCacheSize", Long.valueOf(allMiniAppCacheSize));
            bridgeCallback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getAllMiniAppCacheSize: " + allMiniAppCacheSize);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppTotalSize(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long allMiniAppFileSize = FileUtil.getAllMiniAppFileSize(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(allMiniAppFileSize));
            bridgeCallback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getMiniAppTotalSize: " + allMiniAppFileSize);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getMiniappPermissionList(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        ArrayList<PermissionInfoModel> arrayList;
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    String OooO0O0 = ScopeUtils.OooO00o.OooO0O0(context, str);
                    TmcLogger.d(this.OooO00o, "permissionMiniappScopeData: " + OooO0O0);
                    if (OooO0O0.length() == 0) {
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("isAuthorized", Boolean.FALSE).build());
                            unit = Unit.a;
                            if (unit != null) {
                                return;
                            }
                        }
                        unit = null;
                        if (unit != null) {
                        }
                    } else {
                        try {
                            Object fromJson = GsonUtils.fromJson(OooO0O0, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getMiniappPermissionList$1$authList$1
                            }.getType());
                            Intrinsics.g(fromJson, "{\n                      …  )\n                    }");
                            arrayList = (ArrayList) fromJson;
                        } catch (Throwable unused) {
                            arrayList = new ArrayList();
                        }
                        for (PermissionInfoModel permissionInfoModel : arrayList) {
                            permissionInfoModel.setScopeDescription(ScopeUtils.OooO00o.OooO0O0(permissionInfoModel.getScopeName(), permissionInfoModel.getScopeName()));
                        }
                        String json = TmcGsonUtilsKt.toJson(arrayList);
                        TmcLogger.d(this.OooO00o, "miniScopeData:-> " + json);
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("isAuthorized", Boolean.TRUE).addProperty("permissionList", json).build());
                            unit = Unit.a;
                            if (unit != null) {
                            }
                        }
                        unit = null;
                        if (unit != null) {
                        }
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgListInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListData");
            TmcLogger.d(this.OooO00o, "getMsgListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            bridgeCallback.sendSuccessResponse(jsonObject);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgSwitchStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext != null && (context = appContext.getContext()) != null) {
            JsonObject jsonObject = new JsonObject();
            String OooO0O0 = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0O0(context, str);
            if (OooO0O0.length() > 0) {
                JsonObject jsonObject2 = (JsonObject) GsonUtils.fromJson(OooO0O0, JsonObject.class);
                JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                String str2 = "";
                if (asString == null) {
                    asString = "";
                } else {
                    Intrinsics.g(asString, "msgProvider[MiniappMsgDa…H_STATUS]?.asString ?: \"\"");
                }
                jsonObject.addProperty("appSwitchStatus", asString);
                JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                r0 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (r0 != null) {
                    Intrinsics.g(r0, "msgProvider[MiniappMsgDa…IMESTAMP]?.asString ?: \"\"");
                    str2 = r0;
                }
                jsonObject.addProperty("appSwitchTimestamp", str2);
            }
            bridgeCallback.sendSuccessResponse(jsonObject);
            r0 = Unit.a;
        }
        if (r0 == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgWithReadStatusListInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListWithReadStatusData");
            TmcLogger.d(this.OooO00o, "getMsgWithReadStatusListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            bridgeCallback.sendSuccessResponse(jsonObject);
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getPermissionStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingParam({"scopeName"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        ArrayList arrayList;
        Object obj;
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(str2, "scopeName");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ScopeUtils scopeUtils = ScopeUtils.OooO00o;
                    String OooO0O0 = scopeUtils.OooO0O0(context, str);
                    Unit unit2 = null;
                    if (OooO0O0.length() == 0) {
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("isAuthorized", Boolean.FALSE).addProperty("scopeName", str2).addProperty("scopeDescription", scopeUtils.OooO0O0(str2, str2)).build());
                            unit = Unit.a;
                            unit2 = unit;
                        }
                        if (unit2 != null) {
                            return;
                        }
                    } else {
                        try {
                            Object fromJson = GsonUtils.fromJson(OooO0O0, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getPermissionStatus$1$authList$1
                            }.getType());
                            Intrinsics.g(fromJson, "{\n                      …  )\n                    }");
                            arrayList = (ArrayList) fromJson;
                        } catch (Throwable unused) {
                            arrayList = new ArrayList();
                        }
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            } else {
                                obj = it.next();
                                if (Intrinsics.c(((PermissionInfoModel) obj).getScopeName(), str2)) {
                                    break;
                                }
                            }
                        }
                        PermissionInfoModel permissionInfoModel = (PermissionInfoModel) obj;
                        if (permissionInfoModel == null) {
                            if (bridgeCallback != null) {
                                bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("isAuthorized", Boolean.FALSE).addProperty("scopeName", str2).addProperty("scopeDescription", ScopeUtils.OooO00o.OooO0O0(str2, str2)).build());
                                unit = Unit.a;
                                unit2 = unit;
                            }
                            if (unit2 != null) {
                            }
                        } else {
                            if (bridgeCallback != null) {
                                bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("isAuthorized", Boolean.TRUE).addProperty("scopeName", str2).addProperty("scopeDescription", ScopeUtils.OooO00o.OooO0O0(str2, str2)).addProperty(TmcConstants.KEY_CHECK_SCOPE_AUTH_RESULT, permissionInfoModel.getAuthStatus()).addProperty("authTimeStamp", permissionInfoModel.getAuthTimeStamp()).addProperty("validityTime", permissionInfoModel.getValidityTime()).build());
                                unit = Unit.a;
                                unit2 = unit;
                            }
                            if (unit2 != null) {
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit3 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getPrefetchState(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    int i = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_STATE);
                    long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_TIMESTAMP);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("status", Integer.valueOf(i));
                        jsonObject.addProperty("timestamp", Long.valueOf(j));
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getTotalMsgStatus(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String str;
        Context context;
        String str2;
        String string;
        str = "";
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext != null && (context = appContext.getContext()) != null) {
            try {
                Intrinsics.h(context, "context");
                try {
                    string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
            }
            if (string != null && string.length() > 0) {
                JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(string, JsonObject.class);
                JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
                JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
                r3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                str2 = r3 != null ? r3 : "";
                str = asString;
                Pair a = TuplesKt.a(str, str2);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("mainSwitchStatus", (String) a.getFirst());
                jsonObject2.addProperty("mainSwitchTimestamp", (String) a.getSecond());
                bridgeCallback.sendSuccessResponse(jsonObject2);
                r3 = Unit.a;
            }
            str2 = "";
            Pair a2 = TuplesKt.a(str, str2);
            JsonObject jsonObject22 = new JsonObject();
            jsonObject22.addProperty("mainSwitchStatus", (String) a2.getFirst());
            jsonObject22.addProperty("mainSwitchTimestamp", (String) a2.getSecond());
            bridgeCallback.sendSuccessResponse(jsonObject22);
            r3 = Unit.a;
        }
        if (r3 == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getUnreadMsgNum(@BindingNode(App.class) App app, @BindingParam(stringDefault = "", value = {"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonElement OooO0Oo = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0Oo(context);
                    if (str != null && str.length() > 0) {
                        JsonElement jsonElement = OooO0Oo.get(str);
                        int asInt = jsonElement != null ? jsonElement.getAsInt() : 0;
                        JsonElement jsonObject = new JsonObject();
                        jsonObject.addProperty(str, Integer.valueOf(asInt));
                        OooO0Oo = jsonObject;
                    }
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("unreadMsgData", OooO0Oo.toString()).build());
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void launcherMiniappBrandPage(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    AppBrandProfileActivity.Companion.launch$default(AppBrandProfileActivity.Companion, context, str, null, 4, null);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void removeMiniAppFile(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "removeMiniAppFile: ");
            FileUtil.removeMiniAppFile(context, str);
            bridgeCallback.sendSuccessResponse(new JsonObject());
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void removeMiniAppFileCache(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "removeMiniAppFileCache: ");
            FileUtil.removeMiniAppFileCache(context, str);
            bridgeCallback.sendSuccessResponse(new JsonObject());
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void requestSendMsgPermission(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && appContext.getContext() != null) {
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void saveMsgListInfo(@BindingNode(App.class) App app, @BindingParam({"msgList"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "msgList");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "saveMsgListInfo: " + str);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListData", str);
            bridgeCallback.sendSuccessResponse();
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void saveMsgWithReadStatusListInfo(@BindingNode(App.class) App app, @BindingParam({"msgList"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "msgList");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "saveMsgWithReadStatusListInfo: " + str);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListWithReadStatusData", str);
            bridgeCallback.sendSuccessResponse();
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void updateUnreadMsgNum(@BindingNode(App.class) App app, @BindingParam({"unreadMsgData"}) JsonObject jsonObject, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(jsonObject, "unreadMsgData");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonObject OooO0Oo = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0Oo(context);
                    Set<String> keySet = jsonObject.keySet();
                    Intrinsics.g(keySet, "unreadMsgData.keySet()");
                    for (String str : keySet) {
                        OooO0Oo.addProperty(str, Integer.valueOf(jsonObject.get(str).getAsInt()));
                    }
                    com.cloud.tmc.miniapp.utils.OooO0o oooO0o = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o;
                    String jsonElement = OooO0Oo.toString();
                    Intrinsics.g(jsonElement, "msgUnreadNumberData.toString()");
                    oooO0o.OooO0Oo(context, jsonElement);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO00o, th);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.a;
        }
    }
}
