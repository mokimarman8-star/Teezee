package com.cloud.tmc.miniapp.utils;

import android.app.Application;
import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.net.TmcResponseCallback;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MessageBubbleUtils {
    public static final MessageBubbleUtils OooO00o = new MessageBubbleUtils();

    public final void OooO00o(Context context, TmcResponseCallback<LauncherMiniAppMsgModel> tmcResponseCallback) {
        String str;
        try {
            String uRL_MINI_QUERY_NEW_MSG_mini = UrlKt.getURL_MINI_QUERY_NEW_MSG_mini();
            TmcLogger.d("MessageBubbleUtils", "requestUrl -> " + uRL_MINI_QUERY_NEW_MSG_mini);
            try {
                str = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, TmcConstants.KEY_MINI_SDK_STORAGE, "device_util_ga_id");
                if (str == null) {
                    str = "";
                }
                TmcLogger.d("MessageBubbleUtils", "requestQueryMsgStatus mGAId:" + str);
            } catch (Throwable unused) {
                str = "";
            }
            if (str.length() == 0) {
                tmcResponseCallback.onFailure(TmcConstants.COLD_OPEN_TYPE, "gaid is null", "");
                TmcLogger.d("MessageBubbleUtils", "mGAId is null ");
                return;
            }
            OooO0o oooO0o = OooO0o.OooO00o;
            Pair<String, String> OooO0o0 = oooO0o.OooO0o0(context);
            HashMap hashMap = new HashMap();
            hashMap.put("originType", "3");
            hashMap.put("uid", str);
            hashMap.put("webQueryTimestamp", Long.valueOf(System.currentTimeMillis()));
            String str2 = (String) OooO0o0.getFirst();
            String str3 = (String) OooO0o0.getSecond();
            if (str2.length() > 0) {
                hashMap.put("mainSwitchStatus", str2);
            }
            if (str3.length() > 0) {
                hashMap.put("mainSwitchTimestamp", str3);
            }
            JsonArray OooO0O0 = oooO0o.OooO0O0(context);
            if (!OooO0O0.isEmpty()) {
                hashMap.put("miniAppSwitchOnOffs", OooO0O0);
                TmcLogger.d("MessageBubbleUtils", "miniAppSwitchOnOffs:" + TmcGsonUtilsKt.toJson(hashMap));
            }
            ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).postJson(uRL_MINI_QUERY_NEW_MSG_mini, new LinkedHashMap(), new LinkedHashMap(), hashMap, Boolean.TRUE, tmcResponseCallback);
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", th);
        }
    }

    public final void OooO00o(Context context, String str, String str2, PopWindowManager.IPopWindowManagerController iPopWindowManagerController) {
        int configInt;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "miniAppPopWindowToken");
        Intrinsics.h(iPopWindowManagerController, "controller");
        if (str.length() == 0) {
            return;
        }
        TmcLogger.d("MessageBubbleUtils", "checkAndShowMsgBubble");
        if (OooO00o(str)) {
            return;
        }
        long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, str, TmcConstants.KEY_SHOW_MSG_BUBBLE_TIME);
        TmcLogger.d("MessageBubbleUtils", "checkAndShowMsgBubble showAddHomeTime->" + j + " currentTimeMillis->" + System.currentTimeMillis() + " diff ->" + (System.currentTimeMillis() - j));
        int i = 43200000;
        try {
            i = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_INTERVAL, 43200000);
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", th);
        }
        if (System.currentTimeMillis() - j >= i && (configInt = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_DELAY, 60000)) > 0) {
            TmcLogger.d("MessageBubbleUtils", "addPopWindow msg bubble:->" + configInt);
            PopWindowManager.INSTANCE.addPopWindow(str2, new PopWindowManager.PopWindowData(str, (long) configInt, 2, iPopWindowManagerController, false, 16, (DefaultConstructorMarker) null));
        }
    }

    public final void OooO00o(App app, OooO0O0 oooO0O0) {
        Application application$com_cloud_tmc_miniapp_sdk;
        AppContext appContext;
        try {
            TmcLogger.d("MessageBubbleUtils", "requestMsgBubbleStatus");
            Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            if (context == null) {
                return;
            }
            OooO0o oooO0o = OooO0o.OooO00o;
            String OooO0OO = oooO0o.OooO0OO(context);
            if (OooO0OO.length() == 0) {
                TmcLogger.d("MessageBubbleUtils", "latestUnreadMsg is null or empty");
                return;
            }
            JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(OooO0OO, JsonObject.class);
            JsonElement jsonElement = jsonObject.get(TmcConstants.KEY_MINI_APPID);
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            String str = "";
            if (asString == null) {
                asString = "";
            }
            JsonElement jsonElement2 = jsonObject.get("miniappName");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString2 == null) {
                asString2 = "";
            }
            if (Intrinsics.c(app.getAppId(), asString)) {
                return;
            }
            if (!oooO0o.OooO00o(context, asString)) {
                TmcLogger.d("MessageBubbleUtils", "requestMsgBubbleStatus msg switch is closed -> " + asString);
                return;
            }
            TmcLogger.d("MessageBubbleUtils", "checkAndShowMessageBubble appId " + asString);
            String appId = app.getAppId();
            if (appId != null) {
                str = appId;
            }
            if (str.length() == 0 || (application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk()) == null) {
                return;
            }
            if (System.currentTimeMillis() - ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, str, "MessageBubbleLatestTime") < TmcConstants.MINI_POPWINDOW_MSG_BUBBLE_INTERVAL) {
                return;
            }
            TmcLogger.d("MessageBubbleUtils", "show msg bubble");
            if (oooO0O0 != null) {
                oooO0O0.show(str, asString2);
            }
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", "requestMsgBubbleStatus", th);
        }
    }

    public final boolean OooO00o() {
        try {
            if (OooO0O0()) {
                return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_BOTTOM_ENABLE, false);
            }
            return false;
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", th);
            return false;
        }
    }

    public final boolean OooO00o(String str) {
        try {
            Object fromJson = GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_FORBID_ID, "[\"1000391591855976448\",\"1000886706715795456\"]"), (Class<Object>) List.class);
            List list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList();
            }
            return list.contains(str);
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO0O0(final App app, final OooO0O0 oooO0O0) {
        String str;
        String str2;
        String string;
        AppContext appContext;
        str = "";
        final Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null) {
            return;
        }
        if (((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, "100000", TmcConstants.KEY_IS_NEW_USER, true)) {
            TmcLogger.d("MessageBubbleUtils", "updateDateMsgStatus isFirst = true");
            return;
        }
        Intrinsics.h(context, "context");
        try {
            string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
        } catch (Throwable unused) {
        }
        if (string != null && string.length() > 0) {
            JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(string, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            if (asString == null) {
                asString = "";
            }
            JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            str2 = asString2 != null ? asString2 : "";
            str = asString;
            if (Intrinsics.c(TuplesKt.a(str, str2).getFirst(), "1")) {
                TmcLogger.d("MessageBubbleUtils", "main msg switch is closed,return");
                return;
            } else {
                OooO00o(context, new TmcResponseCallback<LauncherMiniAppMsgModel>() { // from class: com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1
                    public Type getType() {
                        Type type = new TypeToken<BaseResponse<? extends LauncherMiniAppMsgModel>>() { // from class: com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1$getType$1
                        }.getType();
                        Intrinsics.g(type, "object :\n               …iAppMsgModel?>>() {}.type");
                        return type;
                    }

                    public void onFail(BaseResponse<? extends Object> baseResponse, Map<String, String> map) {
                        Intrinsics.h(baseResponse, "fail");
                        TmcLogger.e("MessageBubbleUtils", "updateDateMsgStatus ErrCode:" + baseResponse.getCode() + ",errMsg:" + baseResponse.getMessage());
                    }

                    public void onSuccess(BaseResponse<LauncherMiniAppMsgModel> baseResponse, Map<String, String> map) {
                        String str3;
                        Unit unit;
                        Intrinsics.h(baseResponse, "bean");
                        try {
                            LauncherMiniAppMsgModel launcherMiniAppMsgModel = (LauncherMiniAppMsgModel) baseResponse.getData();
                            if (launcherMiniAppMsgModel == null || (str3 = TmcGsonUtilsKt.toJson(launcherMiniAppMsgModel)) == null) {
                                str3 = "";
                            }
                            if (launcherMiniAppMsgModel != null) {
                                TmcLogger.d("MessageBubbleUtils", "updateDateMsgStatus dataObj = " + str3);
                                Boolean successUpdateSwitchStatus = launcherMiniAppMsgModel.getSuccessUpdateSwitchStatus();
                                boolean booleanValue = successUpdateSwitchStatus != null ? successUpdateSwitchStatus.booleanValue() : true;
                                Long webQueryTimestamp = launcherMiniAppMsgModel.getWebQueryTimestamp();
                                long longValue = webQueryTimestamp != null ? webQueryTimestamp.longValue() : System.currentTimeMillis();
                                if (booleanValue) {
                                    OooO0o.OooO00o.OooO00o(context, longValue);
                                }
                                ArrayList<LauncherMiniAppMsgInfoBean> miniappMessageInfos = launcherMiniAppMsgModel.getMiniappMessageInfos();
                                if (miniappMessageInfos != null && miniappMessageInfos.size() > 0) {
                                    TmcLogger.d("MessageBubbleUtils", "updateDateMsgStatus msgInfo = $" + miniappMessageInfos.size());
                                    Context context2 = context;
                                    Intrinsics.h(context2, "context");
                                    Intrinsics.h(str3, "msgDataStr");
                                    try {
                                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context2, "miniMsgCacheData", String.valueOf(System.currentTimeMillis()), str3);
                                    } catch (Throwable th) {
                                        TmcLogger.e("MiniappMsgDataProvider", th);
                                    }
                                }
                                LauncherLastlyMessageInfo lastlyMessageInfo = launcherMiniAppMsgModel.getLastlyMessageInfo();
                                if (lastlyMessageInfo != null) {
                                    Context context3 = context;
                                    JsonObject jsonObject2 = new JsonObject();
                                    String miniappId = lastlyMessageInfo.getMiniappId();
                                    if (miniappId == null) {
                                        miniappId = "";
                                    }
                                    String miniappName = lastlyMessageInfo.getMiniappName();
                                    if (miniappName == null) {
                                        miniappName = "";
                                    }
                                    if (miniappId.length() <= 0 || miniappName.length() <= 0) {
                                        TmcLogger.d("MessageBubbleUtils", "miniappId or miniappName is null ");
                                    } else {
                                        OooO0o oooO0o = OooO0o.OooO00o;
                                        if (oooO0o.OooO00o(context3, miniappId)) {
                                            jsonObject2.addProperty(TmcConstants.KEY_MINI_APPID, miniappId);
                                            jsonObject2.addProperty("miniappName", miniappName);
                                            TmcLogger.d("MessageBubbleUtils", "updateLatestUnreadMsg miniappId " + miniappId);
                                            oooO0o.OooO0OO(context3, TmcGsonUtilsKt.toJson(jsonObject2));
                                        } else {
                                            TmcLogger.d("MessageBubbleUtils", "miniappId ->" + miniappId + " msg switch is closed");
                                        }
                                    }
                                    unit = Unit.a;
                                } else {
                                    unit = null;
                                }
                                if (unit == null) {
                                    TmcLogger.d("MessageBubbleUtils", "latestMsgInfo is null");
                                }
                            } else {
                                TmcLogger.d("MessageBubbleUtils", "updateDateMsgStatus no new msg ");
                            }
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_MSG_LATEST_UPDATE, System.currentTimeMillis());
                            MessageBubbleUtils.OooO00o.OooO00o(app, oooO0O0);
                        } catch (Throwable th2) {
                            TmcLogger.e("MessageBubbleUtils", "", th2);
                        }
                    }
                });
                return;
            }
        }
        str2 = "";
        if (Intrinsics.c(TuplesKt.a(str, str2).getFirst(), "1")) {
        }
    }

    public final boolean OooO0O0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_ENABLE, false);
        } catch (Throwable th) {
            TmcLogger.e("MessageBubbleUtils", th);
            return false;
        }
    }
}
