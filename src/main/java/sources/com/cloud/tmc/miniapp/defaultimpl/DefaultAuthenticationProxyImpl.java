package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.extension.IgnorePermissionPoint;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppInfoScene;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.ApiPermissionCheckResult;
import com.cloud.tmc.integration.permission.AppPermissionUtils;
import com.cloud.tmc.integration.permission.model.ApiPermissionInfo;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.bridge.BridgePermission;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.DefaultPermission;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.JSONUtils;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DefaultAuthenticationProxyImpl implements AuthenticationProxy {
    public static String OooO0o = "Tmcintegration:DefaultAuthenticationProxyImpl";
    public Context OooO00o;
    public OooO0O0 OooO0o0;
    public String OooO0Oo = "";
    public Map<String, ApiPermissionInfo> OooO0O0 = new ConcurrentHashMap();
    public Map<String, PermissionModel> OooO0OO = new ConcurrentHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add("sms");
        arrayList.add("geo");
    }

    public DefaultAuthenticationProxyImpl(Context context) {
        this.OooO00o = context;
        this.OooO0o0 = new OooO0O0(context);
    }

    public final boolean OooO00o(ApiPermissionInfo apiPermissionInfo, String str, String str2) {
        if (!TextUtils.equals(str2, "Valid_SubResMimeList") && !str2.startsWith("JSAPI_SP_Config") && !TextUtils.equals(str2, "EVENT_List") && !TextUtils.equals(str2, "HttpLink_SubResMimeList") && !str2.startsWith("Webview_Config") && !TextUtils.equals(str2, "validDomain")) {
            return apiPermissionInfo.getApiLevelList(str2).contains(str);
        }
        List apiLevelList = apiPermissionInfo.getApiLevelList(str2);
        if (apiLevelList == null || apiLevelList.isEmpty()) {
            return false;
        }
        Iterator it = apiLevelList.iterator();
        while (it.hasNext()) {
            try {
            } catch (Exception e) {
                TmcLogger.e(OooO0o, "hasPermission Regex Exception", e);
            }
            if (Pattern.compile((String) it.next()).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEventPermission(String str, String str2, Page page) {
        if (this.OooO0O0.containsKey(str)) {
            return hasPermission(str, str2, "EVENT_List", page);
        }
        return true;
    }

    public ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app) {
        String str = OooO0o;
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("checkJSApi,page i新日志##########");
        OooO00o.append(nativeCallContext.getSource());
        TmcLogger.d(str, OooO00o.toString());
        if (app == null) {
            TmcLogger.d(OooO0o, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY;
        }
        IgnorePermissionPoint create = ExtensionPoint.as(IgnorePermissionPoint.class).node(app).create();
        if (create != null && create.ignoreAppPermission(app.getAppId())) {
            TmcLogger.d(OooO0o, "checkJSApi,IgnorePermissionPoint ignoreAppPermission");
            return ApiPermissionCheckResult.IGNORE;
        }
        AppModel appModel = app.getAppModel();
        if (appModel != null) {
            boolean isDevSource = AppInfoScene.isDevSource(app.getStartParams());
            String string = JSONUtils.getString(appModel.getExtendInfos(), "checkPermission", "YES");
            if (isDevSource && "NO".equalsIgnoreCase(string)) {
                TmcLogger.d(OooO0o, "checkJSApi, KEY_CHECK_PERMISSION ignoreAppPermission");
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        String appId = app.getAppId();
        PermissionModel permissionModel = this.OooO0OO.get(appId);
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.d(OooO0o, String.format("%s not have permission file", appId));
            return ApiPermissionCheckResult.IGNORE;
        }
        permissionModel.getJsapiList();
        return ScopeUtils.OooO00o.OooO00o(permission);
    }

    public boolean checkSPJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app) {
        return true;
    }

    public boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page) {
        PermissionModel permissionModel = this.OooO0OO.get(page.getApp().getAppId());
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.d(OooO0o, "checkShowPermissionDialog permsionModel is null");
            return false;
        }
        OooO0O0 oooO0O0 = this.OooO0o0;
        oooO0O0.getClass();
        if (page.getApp() != null) {
            AppModel appModel = page.getApp().getAppModel();
            PermissionModel permissions = appModel.getPermissions();
            String appId = page.getApp().getAppId();
            String authority = permission.authority();
            if ("0".equals(((ConfigService) TmcProxy.get(ConfigService.class)).getConfig("ta_permissionDialogSwitch", "1"))) {
                TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...dialogSwitch closed");
            } else {
                String OooO00o = oooO0O0.OooO00o(authority);
                ScopeModel scopeModel = OooO0O0.OooO0Oo.get(OooO00o);
                if (scopeModel != null) {
                    ScopeUtils scopeUtils = ScopeUtils.OooO00o;
                    ArrayList<ScopesV2Bean> OooO00o2 = scopeUtils.OooO00o(page);
                    long validityTime = scopeModel.getValidityTime();
                    boolean userAuthorization = scopeModel.getUserAuthorization();
                    if (OooO00o2 != null) {
                        ScopesV2Bean OooO00o3 = scopeUtils.OooO00o(OooO00o, OooO00o2);
                        if (OooO00o3 == null) {
                            oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, OooO00o);
                            ExecutorUtils.execute(ExecutorType.NORMAL, new OooO00o(oooO0O0, OooO00o, appId, appModel));
                            return true;
                        }
                        userAuthorization = OooO00o3.getUserAuthorization();
                        long validityTime2 = OooO00o3.getValidityTime();
                        scopeModel.setUserAuthorization(userAuthorization);
                        scopeModel.setValidityTime(validityTime2);
                        validityTime = validityTime2;
                    }
                    if (userAuthorization && !scopeUtils.OooO00o(oooO0O0.OooO00o, OooO00o, validityTime, appId)) {
                        Context context = oooO0O0.OooO00o;
                        Intrinsics.h(context, "context");
                        Intrinsics.h(OooO00o, "scopeName");
                        Intrinsics.h(appId, "appId");
                        if (!Intrinsics.c(OooO00o, "userLogin") && scopeUtils.OooO0O0(context, OooO00o, appId) >= 3) {
                            if (System.currentTimeMillis() - scopeUtils.OooO0o0(context, OooO00o, appId) <= 86400000) {
                                oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, OooO00o);
                                return true;
                            }
                        }
                        if ("notifyMessage".equals(OooO00o)) {
                            Pair<Boolean, Long> OooO00o4 = scopeUtils.OooO00o(oooO0O0.OooO00o, appId);
                            if (Boolean.TRUE.equals(OooO00o4.getFirst())) {
                                Long l = (Long) OooO00o4.getSecond();
                                if (System.currentTimeMillis() - l.longValue() < 604800000 && l.longValue() != 0) {
                                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "notifyMsg scope not show again" + l);
                                    oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, OooO00o);
                                    return true;
                                }
                            }
                        }
                        return oooO0O0.OooO00o(page, appId, authority, nativeCallContext, bridgeResponseHelper, permissions, false);
                    }
                }
            }
        }
        return false;
    }

    public void clearPermissionModel(String str) {
        if (this.OooO0O0.get(str) != null) {
            this.OooO0O0.get(str).clear();
            this.OooO0O0.remove(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00fe, code lost:
    
        if (android.text.TextUtils.equals(((com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) com.cloud.tmc.kernel.proxy.TmcProxy.get(com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class)).getString(r11.OooO00o, r12, r11.OooO00o(r13, r2)), "1") != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Boolean> getAllPermissions(String str, String str2, @Nullable AppModel appModel) {
        boolean z;
        if (this.OooO0o0 == null) {
            this.OooO0o0 = new OooO0O0(this.OooO00o);
        }
        OooO0O0 oooO0O0 = this.OooO0o0;
        oooO0O0.getClass();
        TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class);
        if (appModel == null) {
            appModel = tmcAppInfoManager.getAppModel(oooO0O0.OooO00o, AppInfoQuery.make(str2));
        }
        HashMap hashMap = new HashMap();
        if (appModel != null && appModel.getPermissions() != null && appModel.getPermissions().getNativeApiScopeConfig() != null) {
            JsonObject nativeApiScopeConfig = appModel.getPermissions().getNativeApiScopeConfig();
            String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
            for (String str3 : nativeApiScopeConfig.keySet()) {
                String OooO00o = oooO0O0.OooO00o(str2, str3);
                String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(oooO0O0.OooO00o, str2, OooO00o);
                TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "isThePermissionApplied,key: " + OooO00o + ",value: " + string);
                if (TextUtils.isEmpty(string) && !TextUtils.isEmpty(aggregationMainAppId)) {
                    string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(oooO0O0.OooO00o, str2, oooO0O0.OooO00o(aggregationMainAppId, str3));
                }
                if (!TextUtils.isEmpty(string)) {
                    String OooO00o2 = oooO0O0.OooO00o(str2, str3);
                    String string2 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(oooO0O0.OooO00o, str2, OooO00o2);
                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "getPermissionByKey,key: " + OooO00o2 + ",value: " + string2);
                    if (!TextUtils.equals(string2, "1")) {
                        if (!TextUtils.isEmpty(aggregationMainAppId)) {
                        }
                        z = false;
                        hashMap.put(str3, Boolean.valueOf(z));
                    }
                    z = true;
                    hashMap.put(str3, Boolean.valueOf(z));
                }
            }
        }
        return hashMap;
    }

    public PermissionModel getPermissionModel(String str) {
        return this.OooO0OO.get(str);
    }

    public List<Permission> getPermissions(String str) {
        List<String> jsapiList;
        PermissionModel permissionModel = this.OooO0OO.get(str);
        if (permissionModel == null || (jsapiList = permissionModel.getJsapiList()) == null || jsapiList.size() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsapiList.size());
        for (String str2 : jsapiList) {
            arrayList.add(new BridgePermission(str2, str2));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00db, code lost:
    
        return r8.startsWith("JSAPI_SP_Config");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasPermission(String str, String str2, String str3, Page page) {
        Map<String, ApiPermissionInfo> map;
        TmcLogger.d(OooO0o, "hasPermission " + str + " " + str2 + " " + str3);
        IgnorePermissionPoint create = ExtensionPoint.as(IgnorePermissionPoint.class).node(page.getApp()).create();
        if (create != null && create.ignoreAppPermission(str)) {
            TmcLogger.d(OooO0o, "ignore hasPermission appid\t " + str);
            return true;
        }
        try {
            ApiPermissionInfo apiPermissionInfo = null;
            if (!TextUtils.isEmpty(this.OooO0Oo)) {
                JsonObject parseObject = JSONUtils.parseObject(this.OooO0Oo);
                JsonObject jsonObject = JSONUtils.getJsonObject(parseObject, str, null);
                if (jsonObject == null || jsonObject.size() == 0) {
                    if ("yes".equalsIgnoreCase(JSONUtils.getString(parseObject, str3))) {
                        return true;
                    }
                } else if ("yes".equalsIgnoreCase(JSONUtils.getString(jsonObject, str3))) {
                    return true;
                }
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (map = this.OooO0O0) != null && map.get(str) != null && this.OooO0O0.get(str).getApiLevelList(str3) != null && !this.OooO0O0.get(str).getApiLevelList(str3).isEmpty()) {
                apiPermissionInfo = this.OooO0O0.get(str);
            }
            return OooO00o(apiPermissionInfo, str2, str3);
        } catch (Exception e) {
            TmcLogger.e(OooO0o, "hasPermission Exception!", e);
            return true;
        }
    }

    public boolean hasPermissionModel(String str, Page page) {
        if (TextUtils.isEmpty(str)) {
            str = page.getApp().getAppId();
        }
        return this.OooO0OO.containsKey(str);
    }

    public void setPermissionModel(String str, PermissionModel permissionModel) {
        this.OooO0OO.put(str, permissionModel);
        this.OooO0O0.put(str, AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
    }

    public void setPermissionState(String str, String str2, String str3, boolean z) {
        if (this.OooO0o0 == null) {
            this.OooO0o0 = new OooO0O0(this.OooO00o);
        }
        AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(this.OooO00o, AppInfoQuery.make(str2));
        OooO0O0 oooO0O0 = this.OooO0o0;
        String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
        oooO0O0.getClass();
        if ("userLogin".equals(str3)) {
            return;
        }
        String OooO00o = TextUtils.isEmpty(aggregationMainAppId) ? oooO0O0.OooO00o(str2, str3) : oooO0O0.OooO00o(aggregationMainAppId, str3);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(oooO0O0.OooO00o, str2, OooO00o, z ? "1" : "0");
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "changePermissionState,key: " + OooO00o + ",opened: " + z);
    }
}
