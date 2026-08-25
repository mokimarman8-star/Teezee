package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.callback.LocalAuthPermissionWithNotShowAgainCallback;
import com.cloud.tmc.integration.callback.PrivacyCallback;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PermissionDialogModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.AppPermissionUtils;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.StringUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO0O0 implements PrivacyCallback {
    public static final ConcurrentHashMap<String, String> OooO0OO = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, ScopeModel> OooO0Oo = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, List<PermissionDialogModel>> OooO0o0 = new ConcurrentHashMap<>();
    public Context OooO00o;
    public ConcurrentHashMap<String, List<C0002OooO0O0>> OooO0O0 = new ConcurrentHashMap<>();

    public class OooO00o implements LocalAuthPermissionWithNotShowAgainCallback {
        public boolean OooO00o = false;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ String OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ Page OooO0oO;

        public OooO00o(String str, String str2, String str3, String str4, String str5, Page page) {
            this.OooO0O0 = str;
            this.OooO0OO = str2;
            this.OooO0Oo = str3;
            this.OooO0o0 = str4;
            this.OooO0o = str5;
            this.OooO0oO = page;
        }

        public void clickNotShowAgagin(boolean z) {
            this.OooO00o = z;
        }

        public void onDenied() {
            OooO0O0.this.OooO0O0(this.OooO0O0, this.OooO0OO);
            TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...cancel");
            ScopeUtils scopeUtils = ScopeUtils.OooO00o;
            Context context = OooO0O0.this.OooO00o;
            String str = this.OooO0OO;
            String str2 = this.OooO0Oo;
            String str3 = this.OooO0o0;
            String str4 = this.OooO0o;
            Intrinsics.h(context, "context");
            Intrinsics.h(str, "scopeName");
            Intrinsics.h(str2, "appId");
            scopeUtils.OooO00o(context, str, str2, false, str3, str4, true, false);
            OooO0O0.this.OooO0O0.remove(this.OooO0OO);
            Context context2 = OooO0O0.this.OooO00o;
            String str5 = this.OooO0Oo;
            boolean z = this.OooO00o;
            if (this.OooO0OO.equals("notifyMessage") && z) {
                scopeUtils.OooO00o(context2, str5, z);
            }
        }

        public void onGranted(@Nullable Object obj) {
            ScopeUtils scopeUtils = ScopeUtils.OooO00o;
            Context context = OooO0O0.this.OooO00o;
            String str = this.OooO0OO;
            String str2 = this.OooO0Oo;
            String str3 = this.OooO0o0;
            String str4 = this.OooO0o;
            Intrinsics.h(context, "context");
            Intrinsics.h(str, "scopeName");
            Intrinsics.h(str2, "appId");
            scopeUtils.OooO00o(context, str, str2, true, str3, str4, true, false);
            OooO0O0 oooO0O0 = OooO0O0.this;
            Page page = this.OooO0oO;
            String str5 = this.OooO0O0;
            String str6 = this.OooO0OO;
            oooO0O0.getClass();
            if (page != null && page.getApp() != null && page.getApp().getEngineProxy() != null) {
                List<C0002OooO0O0> list = oooO0O0.OooO0O0.get(str6);
                oooO0O0.OooO0O0.remove(str6);
                if (list != null) {
                    for (C0002OooO0O0 c0002OooO0O0 : list) {
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "sendResult...action=" + str5);
                        try {
                            page.getApp().getEngineProxy().getBridge().sendToNative(c0002OooO0O0.OooO00o, c0002OooO0O0.OooO0O0.getInnerBridgeResponse(), false);
                        } catch (Exception e) {
                            StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("use local permission send result error:\t");
                            OooO00o.append(e.getMessage());
                            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", OooO00o.toString());
                        }
                    }
                }
            }
            Context context2 = OooO0O0.this.OooO00o;
            String str7 = this.OooO0Oo;
            boolean z = this.OooO00o;
            if (this.OooO0OO.equals("notifyMessage") && z) {
                ScopeUtils.OooO00o.OooO00o(context2, str7, z);
            }
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.defaultimpl.OooO0O0$OooO0O0, reason: collision with other inner class name */
    public class C0002OooO0O0 {
        public NativeCallContext OooO00o;
        public BridgeResponseHelper OooO0O0;

        public C0002OooO0O0(OooO0O0 oooO0O0, String str, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
            this.OooO00o = nativeCallContext;
            this.OooO0O0 = bridgeResponseHelper;
        }
    }

    public OooO0O0(Context context) {
        this.OooO00o = context;
        ScopeUtils.OooO00o.OooO00o(OooO0Oo, OooO0OO);
        ExtensionPoint.as(PermissionDialogPoint.class).create().registerCallback(this);
    }

    public final String OooO00o(String str) {
        String str2 = OooO0OO.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public final String OooO00o(String str, String str2) {
        return "_" + str + "_" + str2.substring(str2.indexOf(TmcConstants.EXTENSION_SEPARATOR) + 1, str2.length());
    }

    public final void OooO00o(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0002OooO0O0(this, str, nativeCallContext, bridgeResponseHelper));
        this.OooO0O0.put(str2, arrayList);
        try {
            nativeCallContext.getRender().getAppId();
        } catch (Throwable th) {
            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", "cancelAuth", th);
        }
        OooO0O0(str, str2);
        this.OooO0O0.remove(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
    
        if (r3 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ed, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 添加入缓存, appId: " + r23 + ", scope: " + r1 + ", startToken: " + r0.getStartToken());
        r5.add(new com.cloud.tmc.integration.model.PermissionDialogModel(r22, r23, r24, r25, r26, r27, r0.getStartToken()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean OooO00o(Page page, String str, String str2, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, PermissionModel permissionModel, boolean z) {
        String str3;
        String str4;
        Boolean bool;
        JsonObject asJsonObject;
        String OooO00o2 = OooO00o(str2);
        ScopeUtils scopeUtils = ScopeUtils.OooO00o;
        ConcurrentHashMap<String, ScopeModel> concurrentHashMap = OooO0Oo;
        Intrinsics.h(OooO00o2, "scopeName");
        Intrinsics.h(concurrentHashMap, "SHOW_SCOPE_MAP");
        ScopeModel scopeModel = concurrentHashMap.get(OooO00o2);
        Pair pair = null;
        if (scopeModel != null) {
            String language = Locale.getDefault().getLanguage();
            Intrinsics.g(language, "getDefault().language");
            Locale locale = Locale.ROOT;
            Intrinsics.g(locale, "ROOT");
            String lowerCase = language.toLowerCase(locale);
            Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            JsonObject language2 = scopeModel.getLanguage();
            if (language2 == null || (asJsonObject = language2.getAsJsonObject(lowerCase)) == null) {
                JsonObject language3 = scopeModel.getLanguage();
                asJsonObject = language3 != null ? language3.getAsJsonObject("en") : null;
            }
            String string = StringUtils.getString(R.string.mini_permission_dialog_title);
            Intrinsics.g(string, "getString(R.string.mini_permission_dialog_title)");
            pair = new Pair(string, scopeUtils.OooO00o(OooO00o2, asJsonObject.get("content").getAsString()));
        }
        if (pair == null) {
            return false;
        }
        String str5 = (String) pair.getSecond();
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog -> action:" + str2 + ", appId: " + str + ", scope: " + OooO00o2);
        if (page == null || page.getApp() == null) {
            str3 = "";
            str4 = str3;
        } else {
            AppModel appModel = page.getApp().getAppModel();
            AppPermissionUtils.getAggregationMainAppId(appModel);
            String name = appModel.getName();
            str4 = appModel.getLogo();
            str3 = name;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog not show icon or title null");
            return false;
        }
        if (z) {
            bool = Boolean.TRUE;
        } else if (TextUtils.isEmpty(str)) {
            bool = Boolean.TRUE;
        } else if (page == null) {
            bool = Boolean.TRUE;
        } else {
            App app = page.getApp();
            if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
                bool = Boolean.TRUE;
            } else {
                Context context = app.getAppContext().getContext();
                if (context == null) {
                    bool = Boolean.TRUE;
                } else if (!(context instanceof MiniAppActivity)) {
                    bool = Boolean.TRUE;
                } else if (MiniForceAddHomeManager.INSTANCE.checkInterect(str)) {
                    String OooO00o3 = OooO00o(str2);
                    if (TextUtils.isEmpty(OooO00o3)) {
                        bool = Boolean.TRUE;
                    } else {
                        ConcurrentHashMap<String, List<PermissionDialogModel>> concurrentHashMap2 = OooO0o0;
                        List<PermissionDialogModel> list = concurrentHashMap2.get(str);
                        if (list == null) {
                            list = new ArrayList<>();
                            concurrentHashMap2.put(str, list);
                        }
                        List<PermissionDialogModel> list2 = list;
                        Iterator<PermissionDialogModel> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            PermissionDialogModel next = it.next();
                            if (next != null) {
                                String OooO00o4 = OooO00o(next.getAction());
                                TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + OooO00o3 + ", cacheScope: " + OooO00o4);
                                if (!TextUtils.isEmpty(OooO00o4) && OooO00o4.equals(OooO00o3)) {
                                    if (app.getStartToken() != next.getStartToken()) {
                                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + OooO00o3 + " startToken不一致，判定缓存是失效的，进行剔除");
                                        it.remove();
                                    } else {
                                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 遍历缓存, appId: " + str + ", scope: " + OooO00o3 + " startToken一致，则丢弃该请求");
                                    }
                                }
                            }
                        }
                        bool = Boolean.FALSE;
                    }
                } else {
                    bool = Boolean.TRUE;
                }
            }
        }
        boolean booleanValue = bool.booleanValue();
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog -> showPermissionDialogAble:" + booleanValue + ", scope: " + OooO00o2);
        if (!booleanValue) {
            return true;
        }
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "doShowPermissionDialog -> showPermissionDialog, appId: " + str + ", scope: " + OooO00o2);
        ((DialogProxy) TmcProxy.get(DialogProxy.class)).showPermissionDialog(this.OooO00o, OooO00o2, str5, str3, str4, new OooO00o(str2, OooO00o2, str, str3, str4, page));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0002OooO0O0(this, str2, nativeCallContext, bridgeResponseHelper));
        this.OooO0O0.put(OooO00o2, arrayList);
        return true;
    }

    public final void OooO0O0(String str, String str2) {
        List<C0002OooO0O0> list = this.OooO0O0.get(str2);
        if (list != null) {
            for (C0002OooO0O0 c0002OooO0O0 : list) {
                if (c0002OooO0O0.OooO0O0 != null) {
                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "cancelAuth...action=" + str);
                    c0002OooO0O0.OooO0O0.sendNotGrantPermission();
                }
            }
        }
    }

    public void privacyDismiss(String str, long j) {
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> appId:" + str + " , startToken:" + j);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap<String, List<PermissionDialogModel>> concurrentHashMap = OooO0o0;
            List<PermissionDialogModel> list = concurrentHashMap.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator<PermissionDialogModel> it = list.iterator();
                if (it.hasNext()) {
                    PermissionDialogModel next = it.next();
                    if (next == null) {
                        it.remove();
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> permissionDialogModel == null, continue");
                        privacyDismiss(str, j);
                        return;
                    }
                    if (next.getStartToken() != j) {
                        it.remove();
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> cacheStartToken: " + next.getStartToken() + " 不匹配, continue");
                        privacyDismiss(str, j);
                        return;
                    }
                    String callbackId = next.getResponseHelper().getCallbackId();
                    next.getPage().getApp().updateInterectCallbackId(callbackId);
                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "update currentCallbackId -> " + callbackId);
                    OooO00o(next.getPage(), next.getAppId(), next.getAction(), next.getBridgeContext(), next.getResponseHelper(), next.getModel(), true);
                    it.remove();
                }
                if (it.hasNext()) {
                    return;
                }
                concurrentHashMap.remove(str);
                MiniForceAddHomeManager.INSTANCE.removeInterectMFAH(str, true);
                return;
            }
            concurrentHashMap.remove(str);
            MiniForceAddHomeManager.INSTANCE.removeInterectMFAH(str, true);
        } catch (Throwable th) {
            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", OooO0O0.class.getSimpleName(), th);
        }
    }
}
