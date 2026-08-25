package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
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
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.JsonObjectUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.dialog.o00oO0o;
import com.cloud.tmc.miniapp.dialog.o0OOO0o;
import com.cloud.tmc.miniapp.dialog.o0ooOOo;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.EmptyUtils;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.cloud.tmc.miniutils.util.StringUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PermissionScopeBridge implements BridgeExtension {
    public static final int ERROR_CODE_HAPPENED_EXCEPTION = 500;
    public static final int ERROR_CODE_SCOPE_NAME_IS_EMPTY = 601;
    public static final int ERROR_CODE_SCOPE_NAME_NOT_FOUND = 602;
    public static final String ERROR_MSG_SCOPE_NAME_IS_EMPTY = "scopeName is empty";
    public static final String ERROR_MSG_SCOPE_NAME_NOT_FOUND = "No specified scopeName found";
    public static final String TAG = "PermissionScopeBridge::";
    public static final OooO00o Companion = new OooO00o();
    public static final ConcurrentHashMap<String, o00oO0o> OooO00o = new ConcurrentHashMap<>();

    public static final class OooO00o {
        public final boolean OooO00o(String str) {
            if (str != null) {
                try {
                    if (str.length() != 0 && PermissionScopeBridge.OooO00o.containsKey(str)) {
                        return ((o00oO0o) PermissionScopeBridge.OooO00o.get(str)) != null;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    public static final class OooO0O0 implements o0OOO0o {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Ref.BooleanRef OooO0O0;

        public OooO0O0(BridgeCallback bridgeCallback, Ref.BooleanRef booleanRef) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = booleanRef;
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OOO0o
        public void OooO00o(int i) {
            TmcLogger.d(PermissionScopeBridge.TAG, "onClick postion = " + i);
            this.OooO00o.sendSuccessResponse(JsonObjectUtils.create().addProperty("click", Integer.valueOf(i)).addProperty("isClickNotShowAgain", Boolean.valueOf(this.OooO0O0.element)).build());
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OOO0o
        public void clickNotShowAgagin(boolean z) {
            TmcLogger.d(PermissionScopeBridge.TAG, "clickNotShowAgagin status = " + z);
            this.OooO0O0.element = z;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void checkScopePermissionAuthStatus(@BindingNode(App.class) App app, @BindingParam({"scopeName"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(str, "scopeName");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    if (EmptyUtils.textIsEmpty(str)) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, Integer.valueOf(ERROR_CODE_SCOPE_NAME_IS_EMPTY));
                        jsonObject.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_IS_EMPTY);
                        bridgeCallback.sendFailResponse(jsonObject);
                    } else {
                        ConcurrentHashMap<String, ScopeModel> concurrentHashMap = com.cloud.tmc.miniapp.defaultimpl.OooO0O0.OooO0Oo;
                        if (concurrentHashMap.containsKey(str)) {
                            ScopeModel scopeModel = concurrentHashMap.get(str);
                            if (scopeModel != null) {
                                ScopeUtils scopeUtils = ScopeUtils.OooO00o;
                                long validityTime = scopeModel.getValidityTime();
                                String appId = app.getAppId();
                                Intrinsics.g(appId, "app.appId");
                                boolean OooO00o2 = scopeUtils.OooO00o(context, str, validityTime, appId);
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty(TmcConstants.KEY_CHECK_SCOPE_AUTH_RESULT, Boolean.valueOf(OooO00o2));
                                bridgeCallback.sendSuccessResponse(jsonObject2);
                            } else {
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                                jsonObject3.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                                bridgeCallback.sendFailResponse(jsonObject3);
                            }
                        } else {
                            JsonObject jsonObject4 = new JsonObject();
                            jsonObject4.addProperty(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                            jsonObject4.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                            bridgeCallback.sendFailResponse(jsonObject4);
                        }
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, Integer.valueOf(ERROR_CODE_HAPPENED_EXCEPTION));
                jsonObject5.addProperty("errMsg", th.getMessage());
                bridgeCallback.sendFailResponse(jsonObject5);
                return;
            }
        }
        bridgeCallback.sendFailResponse();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:18:0x000b, B:20:0x0011, B:7:0x001a, B:9:0x002a, B:11:0x005d, B:16:0x0030), top: B:17:0x000b }] */
    @ActionFilter
    @ThreadType(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getTempUniqueId(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                    if (context != null) {
                        return;
                    }
                    String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, app.getAppId(), "tempUniqueId");
                    if (string == null || string.length() == 0) {
                        string = EncryptUtils.encryptMD5ToString(System.currentTimeMillis() + "_" + app.getAppId());
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, app.getAppId(), "tempUniqueId", string);
                    }
                    bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("tempUniqueId", string).build());
                    return;
                }
            } catch (Throwable unused) {
                bridgeCallback.sendFailResponse();
                return;
            }
        }
        context = null;
        if (context != null) {
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void listScope(@BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            Set<Map.Entry<String, ScopeModel>> entrySet = com.cloud.tmc.miniapp.defaultimpl.OooO0O0.OooO0Oo.entrySet();
            Intrinsics.g(entrySet, "SHOW_SCOPE_MAP.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() != null) {
                    Object value = entry.getValue();
                    Intrinsics.g(value, "it.value");
                    jsonArray.add(TmcGsonUtilsKt.toJson(value));
                }
            }
            Unit unit = Unit.a;
            jsonObject.addProperty(TmcConstants.KEY_BRIDGE_RESULT_DATA, TmcGsonUtilsKt.toJson(jsonArray));
            bridgeCallback.sendSuccessResponse(jsonObject);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, Integer.valueOf(ERROR_CODE_HAPPENED_EXCEPTION));
            jsonObject2.addProperty("errMsg", th.getMessage());
            bridgeCallback.sendFailResponse(jsonObject2);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d(TAG, "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d(TAG, "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:11:0x000e, B:13:0x0014, B:5:0x001e, B:8:0x0022), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {all -> 0x0019, blocks: (B:11:0x000e, B:13:0x0014, B:5:0x001e, B:8:0x0022), top: B:10:0x000e }] */
    @ActionFilter
    @ThreadType(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void queryAddScreenNotShowAgainStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                    if (context != null) {
                        bridgeCallback.sendFailResponse();
                        return;
                    } else {
                        bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("timestamp", Long.valueOf(((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, str, TmcConstants.KEY_STORAGE_ADD_HOME_TIME_STAMP))).build());
                        return;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("timestamp", (Number) 0L).build());
                return;
            }
        }
        context = null;
        if (context != null) {
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryDynamicScopeConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty(LauncherMiniAppConfigHelper.KEY_MINI_SCOPE_CONFIG, MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_SCOPE_CONFIG, LauncherMiniAppConfigHelper.DEFATULT_TEST)).build());
        } catch (Throwable unused) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryEnableDevUserAgreement(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, Boolean.valueOf(MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_DEV_USER_AGREEMENT, false))).build());
        } catch (Throwable unused) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryEnableduaWhitlist(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("duaWhitlist", MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_ENABLE_DUA_WHITLIST, "[]")).build());
        } catch (Throwable unused) {
            bridgeCallback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0020 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:11:0x0010, B:13:0x0016, B:5:0x0020, B:8:0x0024), top: B:10:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:11:0x0010, B:13:0x0016, B:5:0x0020, B:8:0x0024), top: B:10:0x0010 }] */
    @ActionFilter
    @ThreadType(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void queryMsgNotShowAgainStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(str, TmcConstants.KEY_MINI_APPID);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                    if (context != null) {
                        bridgeCallback.sendFailResponse();
                        return;
                    }
                    Pair<Boolean, Long> OooO00o2 = ScopeUtils.OooO00o.OooO00o(context, str);
                    TmcLogger.d(TAG, "msgStatusPair,-> " + OooO00o2.getFirst() + "," + OooO00o2.getSecond());
                    bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("notShowAgain", (Boolean) OooO00o2.getFirst()).addProperty("timestamp", (Number) OooO00o2.getSecond()).build());
                    return;
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("timestamp", (Number) 0L).build());
                return;
            }
        }
        context = null;
        if (context != null) {
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryScopeContentConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            JsonObject jsonObject = new JsonObject();
            for (String str : ScopeUtils.OooO0O0) {
                jsonObject.addProperty(str, ScopeUtils.OooO00o.OooO0O0(str, ""));
            }
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("scope", TmcGsonUtilsKt.toJson(jsonObject)).build());
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:12|(1:14)(1:134)|15|(1:17)|18|19|20|(1:22)|24|(3:125|126|(33:128|(1:130)(1:131)|29|30|31|32|33|34|35|36|37|38|(3:83|84|(19:86|(1:88)(8:89|90|(1:92)|93|94|95|96|97)|44|45|46|(1:48)(1:79)|49|50|51|(1:53)(1:77)|54|(2:(1:74)(1:76)|75)(1:56)|57|(1:59)(1:72)|(1:61)(1:71)|62|(1:67)|69|70))|40|41|(1:43)|44|45|46|(0)(0)|49|50|51|(0)(0)|54|(0)(0)|57|(0)(0)|(0)(0)|62|(2:64|67)|69|70))|26|(1:28)(1:124)|29|30|31|32|33|34|35|36|37|38|(0)|40|41|(0)|44|45|46|(0)(0)|49|50|51|(0)(0)|54|(0)(0)|57|(0)(0)|(0)(0)|62|(0)|69|70) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x012f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0130, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnThree:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x011c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x011d, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnTwo:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0105, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0106, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnOne:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ac, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setAppName", r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bc A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f3 A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7 A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #4 {all -> 0x01ab, blocks: (B:46:0x019c, B:79:0x01a7), top: B:45:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @ActionFilter
    @ThreadType(ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showScopePermissionDialog(@BindingNode(App.class) App app, @BindingParam({"logo"}) String str, @BindingParam({"title"}) String str2, @BindingParam({"titleTips"}) String str3, @BindingParam({"scopeName"}) String str4, @BindingParam({"customContent"}) String str5, @BindingParam({"button1"}) JsonObject jsonObject, @BindingParam({"button2"}) JsonObject jsonObject2, @BindingParam({"button3"}) JsonObject jsonObject3, @BindingParam({"notShowAgain"}) JsonObject jsonObject4, @BindingCallback BridgeCallback bridgeCallback) {
        AppModel appModel;
        int i;
        String str6;
        Group group;
        String asString;
        TextView OooO0O02;
        TextView textView;
        TextView textView2;
        AppContext appContext;
        Intrinsics.h(str, "logo");
        Intrinsics.h(str2, "title");
        Intrinsics.h(str3, "titleTips");
        Intrinsics.h(str4, "scopeName");
        Intrinsics.h(str5, "customContent");
        Intrinsics.h(jsonObject, "button1");
        Intrinsics.h(jsonObject2, "button2");
        Intrinsics.h(jsonObject3, "button3");
        Intrinsics.h(jsonObject4, "notShowAgain");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null || (appModel = app.getAppModel()) == null) {
            return;
        }
        String logo = appModel.getLogo();
        String str7 = "";
        String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(str, logo == null ? "" : logo);
        String name = appModel.getName();
        if (name == null) {
            name = "";
        }
        String orDefaultAndCheckEmpty2 = StringExtKt.orDefaultAndCheckEmpty(str2, name);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        o0ooOOo o0ooooo = new o0ooOOo(context);
        Intrinsics.h(orDefaultAndCheckEmpty, "iconUrl");
        try {
            ImageView imageView = (AppCompatImageView) o0ooooo.OooO0OO.getValue();
            if (imageView != null) {
                ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
                Context context2 = o0ooooo.getContext();
                int dp2px = SizeUtils.dp2px(4.0f);
                int i2 = R.drawable.drawable_app_icon_place_holder;
                imageLoaderProxy.loadImgRoundCorners(context2, orDefaultAndCheckEmpty, imageView, dp2px, i2, i2);
            }
        } catch (Throwable th) {
            TmcLogger.e(o0ooooo.OooO00o, "setAppLogo", th);
        }
        Intrinsics.h(str4, "scopeType");
        if (str5 != null) {
            try {
            } catch (Throwable th2) {
                TmcLogger.e(o0ooooo.OooO00o, "setAppName", th2);
            }
            if (str5.length() > 0) {
                TextView textView3 = (TextView) o0ooooo.OooO0o.getValue();
                if (textView3 != null) {
                    textView3.setText(str5);
                }
                Intrinsics.h(jsonObject, "config");
                o0ooooo.OooO00o((TextView) o0ooooo.OooO0oO.getValue(), jsonObject);
                Intrinsics.h(jsonObject2, "config");
                o0ooooo.OooO00o((TextView) o0ooooo.OooO0oo.getValue(), jsonObject2);
                Intrinsics.h(jsonObject3, "config");
                o0ooooo.OooO00o(o0ooooo.OooO0O0(), jsonObject3);
                if (str3 != null) {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                        i = 0;
                    }
                    if (str3.length() == 0) {
                        TextView textView4 = (TextView) o0ooooo.OooO0o0.getValue();
                        if (textView4 == null) {
                            i = 0;
                        } else {
                            try {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                                String string = o0ooooo.getString(R.string.mini_permission_dialog_title);
                                if (string == null) {
                                    string = "";
                                }
                                Object[] objArr = new Object[1];
                                i = 0;
                                try {
                                    objArr[0] = " ";
                                    str6 = String.format(string, Arrays.copyOf(objArr, 1));
                                    Intrinsics.g(str6, "format(format, *args)");
                                } catch (Throwable th4) {
                                    th = th4;
                                    try {
                                        TmcLogger.e(o0ooooo.OooO00o, th);
                                        str6 = "";
                                        textView4.setText(str6);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        TmcLogger.e(o0ooooo.OooO00o, "setAppTitleTips", th);
                                        textView2 = (TextView) o0ooooo.OooO0o0.getValue();
                                        if (textView2 != null) {
                                        }
                                        Intrinsics.h(orDefaultAndCheckEmpty2, "appName");
                                        textView = (TextView) o0ooooo.OooO0Oo.getValue();
                                        if (textView != null) {
                                        }
                                        Intrinsics.h(jsonObject4, "config");
                                        JsonElement jsonElement = jsonObject4.get(o0ooooo.OooOOO);
                                        if (jsonElement != null) {
                                        }
                                        group = (Group) o0ooooo.OooOO0.getValue();
                                        if (group != null) {
                                        }
                                        JsonElement jsonElement2 = jsonObject4.get(o0ooooo.OooOOOo);
                                        if (jsonElement2 != null) {
                                        }
                                        if (asString != null) {
                                        }
                                        if (str7.length() > 0) {
                                        }
                                        OooO0O0 oooO0O0 = new OooO0O0(bridgeCallback, booleanRef);
                                        Intrinsics.h(oooO0O0, RenderCallContext.TYPE_CALLBACK);
                                        o0ooooo.OooO0O0 = oooO0O0;
                                        o0ooooo.show();
                                    }
                                    Intrinsics.h(orDefaultAndCheckEmpty2, "appName");
                                    textView = (TextView) o0ooooo.OooO0Oo.getValue();
                                    if (textView != null) {
                                    }
                                    Intrinsics.h(jsonObject4, "config");
                                    JsonElement jsonElement3 = jsonObject4.get(o0ooooo.OooOOO);
                                    if (jsonElement3 != null) {
                                    }
                                    group = (Group) o0ooooo.OooOO0.getValue();
                                    if (group != null) {
                                    }
                                    JsonElement jsonElement22 = jsonObject4.get(o0ooooo.OooOOOo);
                                    if (jsonElement22 != null) {
                                    }
                                    if (asString != null) {
                                    }
                                    if (str7.length() > 0) {
                                    }
                                    OooO0O0 oooO0O02 = new OooO0O0(bridgeCallback, booleanRef);
                                    Intrinsics.h(oooO0O02, RenderCallContext.TYPE_CALLBACK);
                                    o0ooooo.OooO0O0 = oooO0O02;
                                    o0ooooo.show();
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i = 0;
                            }
                            textView4.setText(str6);
                        }
                        Intrinsics.h(orDefaultAndCheckEmpty2, "appName");
                        textView = (TextView) o0ooooo.OooO0Oo.getValue();
                        if (textView != null) {
                            textView.setText(orDefaultAndCheckEmpty2);
                        }
                        Intrinsics.h(jsonObject4, "config");
                        JsonElement jsonElement32 = jsonObject4.get(o0ooooo.OooOOO);
                        int asBoolean = jsonElement32 != null ? jsonElement32.getAsBoolean() : i;
                        group = (Group) o0ooooo.OooOO0.getValue();
                        if (group != null) {
                            if (asBoolean == 0) {
                                i = 8;
                            }
                            group.setVisibility(i);
                        }
                        JsonElement jsonElement222 = jsonObject4.get(o0ooooo.OooOOOo);
                        asString = jsonElement222 != null ? jsonElement222.getAsString() : null;
                        if (asString != null) {
                            Intrinsics.g(asString, "config.get(KEY_TEXT)?.asString ?: \"\"");
                            str7 = asString;
                        }
                        if (str7.length() > 0 && (OooO0O02 = o0ooooo.OooO0O0()) != null) {
                            OooO0O02.setText(str7);
                        }
                        OooO0O0 oooO0O022 = new OooO0O0(bridgeCallback, booleanRef);
                        Intrinsics.h(oooO0O022, RenderCallContext.TYPE_CALLBACK);
                        o0ooooo.OooO0O0 = oooO0O022;
                        o0ooooo.show();
                    }
                }
                i = 0;
                textView2 = (TextView) o0ooooo.OooO0o0.getValue();
                if (textView2 != null) {
                    textView2.setText(str3);
                }
                Intrinsics.h(orDefaultAndCheckEmpty2, "appName");
                textView = (TextView) o0ooooo.OooO0Oo.getValue();
                if (textView != null) {
                }
                Intrinsics.h(jsonObject4, "config");
                JsonElement jsonElement322 = jsonObject4.get(o0ooooo.OooOOO);
                if (jsonElement322 != null) {
                }
                group = (Group) o0ooooo.OooOO0.getValue();
                if (group != null) {
                }
                JsonElement jsonElement2222 = jsonObject4.get(o0ooooo.OooOOOo);
                if (jsonElement2222 != null) {
                }
                if (asString != null) {
                }
                if (str7.length() > 0) {
                    OooO0O02.setText(str7);
                }
                OooO0O0 oooO0O0222 = new OooO0O0(bridgeCallback, booleanRef);
                Intrinsics.h(oooO0O0222, RenderCallContext.TYPE_CALLBACK);
                o0ooooo.OooO0O0 = oooO0O0222;
                o0ooooo.show();
            }
        }
        TextView textView5 = (TextView) o0ooooo.OooO0o.getValue();
        if (textView5 != null) {
            textView5.setText(ScopeUtils.OooO00o.OooO00o(str4, ""));
        }
        Intrinsics.h(jsonObject, "config");
        o0ooooo.OooO00o((TextView) o0ooooo.OooO0oO.getValue(), jsonObject);
        Intrinsics.h(jsonObject2, "config");
        o0ooooo.OooO00o((TextView) o0ooooo.OooO0oo.getValue(), jsonObject2);
        Intrinsics.h(jsonObject3, "config");
        o0ooooo.OooO00o(o0ooooo.OooO0O0(), jsonObject3);
        if (str3 != null) {
        }
        i = 0;
        textView2 = (TextView) o0ooooo.OooO0o0.getValue();
        if (textView2 != null) {
        }
        Intrinsics.h(orDefaultAndCheckEmpty2, "appName");
        textView = (TextView) o0ooooo.OooO0Oo.getValue();
        if (textView != null) {
        }
        Intrinsics.h(jsonObject4, "config");
        JsonElement jsonElement3222 = jsonObject4.get(o0ooooo.OooOOO);
        if (jsonElement3222 != null) {
        }
        group = (Group) o0ooooo.OooOO0.getValue();
        if (group != null) {
        }
        JsonElement jsonElement22222 = jsonObject4.get(o0ooooo.OooOOOo);
        if (jsonElement22222 != null) {
        }
        if (asString != null) {
        }
        if (str7.length() > 0) {
        }
        OooO0O0 oooO0O02222 = new OooO0O0(bridgeCallback, booleanRef);
        Intrinsics.h(oooO0O02222, RenderCallContext.TYPE_CALLBACK);
        o0ooooo.OooO0O0 = oooO0O02222;
        o0ooooo.show();
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void userAgreementDialogShow(@BindingNode(App.class) App app, @BindingParam({"titleMode"}) JsonObject jsonObject, @BindingParam({"content"}) String str, @BindingParam({"agreementContent"}) String str2, @BindingParam({"privacyPolicyTv"}) String str3, @BindingParam({"userAgreementTv"}) String str4, @BindingParam({"privacyPolicyUrl"}) String str5, @BindingParam({"userAgreementUrl"}) String str6, @BindingParam({"btnBgColor"}) String str7, @BindingParam({"agreeBtn"}) String str8, @BindingParam({"cancelBtn"}) JsonObject jsonObject2, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.h(jsonObject, "titleMode");
        Intrinsics.h(str, "content");
        Intrinsics.h(str2, "agreementContent");
        Intrinsics.h(str3, "privacyPolicyTv");
        Intrinsics.h(str4, "userAgreementTv");
        Intrinsics.h(str5, "privacyPolicyUrl");
        Intrinsics.h(str6, "userAgreementUrl");
        Intrinsics.h(str7, "btnBgColor");
        Intrinsics.h(str8, "agreeBtn");
        Intrinsics.h(jsonObject2, "cancelBtn");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        TmcLogger.d(TAG, "userAgreementDialogShow titleMode = " + jsonObject);
        String appId = app != null ? app.getAppId() : null;
        if (appId == null) {
            TmcLogger.d(TAG, "app is null");
            return;
        }
        AppContext appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            TmcLogger.d(TAG, "context is null");
            return;
        }
        ConcurrentHashMap<String, o00oO0o> concurrentHashMap = OooO00o;
        if (concurrentHashMap.containsKey(appId)) {
            TmcLogger.d(TAG, "dialog is exist remove it");
            o00oO0o o00oo0o = concurrentHashMap.get(appId);
            if (o00oo0o != null) {
                o00oo0o.dismiss();
            }
            concurrentHashMap.remove(appId);
        }
        o00oO0o o00oo0o2 = new o00oO0o(context);
        Intrinsics.h(appId, "appId");
        o00oo0o2.OooO0oo = appId;
        AppModel appModel = app.getAppModel();
        String name = appModel != null ? appModel.getName() : null;
        Intrinsics.h(jsonObject, "config");
        JsonElement jsonElement3 = jsonObject.get(o00oo0o2.OooO);
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString == null) {
            asString = "1";
        } else {
            Intrinsics.g(asString, "config.get(KEY_MODE)?.asString ?: \"1\"");
        }
        JsonElement jsonElement4 = jsonObject.get(o00oo0o2.OooOO0);
        String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        if (asString2 == null) {
            asString2 = "";
        } else {
            Intrinsics.g(asString2, "config.get(KEY_TEXT)?.asString ?: \"\"");
        }
        if (asString2.length() > 0) {
            TextView textView = (TextView) o00oo0o2.OooO0OO.getValue();
            if (textView != null) {
                textView.setText(asString2);
            }
        } else {
            TextView textView2 = (TextView) o00oo0o2.OooO0OO.getValue();
            if (textView2 != null) {
                textView2.setText(Intrinsics.c(asString, o00oo0o2.OooOO0o) ? o00oo0o2.getString(R.string.mini_dau_title_notice) : Intrinsics.c(asString, o00oo0o2.OooOOO0) ? StringUtils.format(o00oo0o2.getString(R.string.mini_dau_title_welcome), name) : o00oo0o2.getString(R.string.mini_dau_title_notice));
            }
        }
        if (str == null || str.length() <= 0) {
            TextView OooO0Oo = o00oo0o2.OooO0Oo();
            if (OooO0Oo != null) {
                OooO0Oo.setText(o00oo0o2.getString(R.string.mini_dau_content));
            }
            TextView OooO0Oo2 = o00oo0o2.OooO0Oo();
            if (OooO0Oo2 != null) {
                OooO0Oo2.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        } else {
            TextView OooO0Oo3 = o00oo0o2.OooO0Oo();
            if (OooO0Oo3 != null) {
                OooO0Oo3.setText(str);
            }
        }
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        o00oo0o2.OooO0O0 = bridgeCallback;
        String name2 = app.getAppModel().getName();
        o00oO0o OooO00o2 = o00oo0o2.OooO00o(name2 == null ? "" : name2, str2, str3, str4, str5, str6, str7).OooO00o(str7, str8);
        String asString3 = (jsonObject2 == null || (jsonElement2 = jsonObject2.get(OooO00o2.OooOO0)) == null) ? null : jsonElement2.getAsString();
        if (asString3 == null) {
            asString3 = "";
        } else {
            Intrinsics.g(asString3, "config?.get(KEY_TEXT)?.asString ?: \"\"");
        }
        String asString4 = (jsonObject2 == null || (jsonElement = jsonObject2.get(OooO00o2.OooO)) == null) ? null : jsonElement.getAsString();
        if (asString4 == null) {
            asString4 = "";
        } else {
            Intrinsics.g(asString4, "config?.get(KEY_MODE)?.asString ?: \"\"");
        }
        TextView textView3 = (TextView) OooO00o2.OooO0oO.getValue();
        if (textView3 != null) {
            if (asString3.length() <= 0) {
                asString3 = Intrinsics.c(asString4, OooO00o2.OooOOO) ? OooO00o2.getString(R.string.mini_can_open_exit) : Intrinsics.c(asString4, OooO00o2.OooOOOO) ? OooO00o2.getString(R.string.mini_dau_guest_mode) : OooO00o2.getString(R.string.mini_can_open_exit);
            }
            textView3.setText(asString3);
        }
        OooO00o2.show();
        try {
            concurrentHashMap.put(appId, o00oo0o2);
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("status", "show");
            bridgeCallback.sendSuccessResponse(jsonObject3);
        } catch (Throwable unused) {
            callbackFail(bridgeCallback, "", Boolean.TRUE);
        }
    }
}
