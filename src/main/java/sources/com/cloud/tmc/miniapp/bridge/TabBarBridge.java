package com.cloud.tmc.miniapp.bridge;

import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarManualConfigStore;
import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.utils.MiniAppConfigUtils;
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
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TabBarBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO00o {
    }

    public static final class OooO0O0 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(BridgeCallback bridgeCallback) {
            super(1);
            this.OooO00o = bridgeCallback;
        }

        public Object invoke(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                BridgeCallback bridgeCallback = this.OooO00o;
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    bridgeCallback.sendSuccessResponse(jsonObject);
                }
            } else {
                BridgeCallback bridgeCallback2 = this.OooO00o;
                if (bridgeCallback2 != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback2);
                }
            }
            return Unit.a;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBar(@BindingNode(App.class) App app, @BindingParam({"animation"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.hideTabBar(z)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else {
            activePage.putStringValue(TmcConstants.KEY_IS_API_SHOW_TAB_BAR_ENABLED, "hideTabBar");
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBarRedDot(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.hideTabBarRedDot(i)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBarUnreadIcon(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
                return;
            }
            return;
        }
        try {
            if (activePage.hideTabBarUnreadIcon(i)) {
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    bridgeCallback.sendSuccessResponse(jsonObject);
                }
            } else if (bridgeCallback != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "set tab item failed,please check the config: T10003");
                bridgeCallback.sendFailResponse(jsonObject2);
            }
        } catch (Throwable th) {
            TmcLogger.e("TabBarBridge", th);
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, please check the config: T10005", bridgeCallback);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    @ActionFilter
    @ThreadType(ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void loadTabBar(@BindingNode(App.class) App app, @BindingParam({"tabBarConfig"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        MiniAppConfigModel.TabBarBean tabBarBean;
        boolean z;
        MiniAppConfigModel miniAppConfigModel;
        Intrinsics.h(str, "tabBarConfig");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || str.length() == 0) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
            return;
        }
        AppLoadResult appLoadResult = activePage.getAppLoadResult();
        int i = 0;
        if (!((appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) ? false : miniAppConfigModel.tabBarManual())) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, app.json is not config handleTabBarLoad as manual: T10004", bridgeCallback);
            return;
        }
        TmcLogger.d("TabBarBridge", "load tab config: " + str);
        try {
            Type type = new TypeToken<MiniAppConfigModel.TabBarBean>() { // from class: com.cloud.tmc.miniapp.bridge.TabBarBridge$loadTabBar$tabBar$1
            }.getType();
            Intrinsics.g(type, "object :\n               …del.TabBarBean>() {}.type");
            tabBarBean = (MiniAppConfigModel.TabBarBean) TmcGsonUtils.fromJson(str, type);
        } catch (Throwable th) {
            TmcLogger.e("TabBarBridge", "tabBarConfig json parse error", th);
            tabBarBean = null;
        }
        if (tabBarBean == null) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, please check the config: T10005", bridgeCallback);
            return;
        }
        List list = tabBarBean.list;
        if (list != null) {
            int size = list.size();
            if (2 <= size && size < 6) {
                z = true;
                if (z) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, The number of dynamic configurations is not between 2 and 5: T10006", bridgeCallback);
                    return;
                }
                AppNode appNode = app instanceof AppNode ? (AppNode) app : null;
                MiniAppConfigModel.TabBarBean tabBar = MiniAppConfigUtils.getTabBar(tabBarBean, appNode != null ? appNode.getmAppLoadResult() : null, true);
                app.setData(TabBarManualConfigStore.class, new TabBarManualConfigStore(tabBar));
                List list2 = tabBarBean.list;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.c(((MiniAppConfigModel.TabBarBean.ListBean) it.next()).pagePath, activePage.getPagePath())) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                i = -1;
                if (i == -1) {
                    TmcLogger.d("TabBarBridge", "lazy load tab bar");
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "lazy load tab bar: T10007");
                    bridgeCallback.sendSuccessResponse(jsonObject);
                    return;
                }
                activePage.setTabPage(true);
                boolean loadTabBar = activePage.loadTabBar(tabBar);
                TmcLogger.d("TabBarBridge", "load tab bar result: " + loadTabBar);
                if (!loadTabBar) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                    return;
                }
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "ok");
                bridgeCallback.sendSuccessResponse(jsonObject2);
                return;
            }
            TmcLogger.d("TabBarBridge", "The number of tabBarConfig list is not between 2 and 5");
        }
        z = false;
        if (z) {
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void offTabReselected(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
            }
        } else {
            if (!activePage.isTabPage()) {
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
                    return;
                }
                return;
            }
            TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
            BridgeCallback bridgeCallback2 = (BridgeCallback) (tabReSelectedStore == null ? new WeakHashMap() : tabReSelectedStore.getPageCache()).remove(activePage.getPageId());
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d("TabBarBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d("TabBarBridge", "onInitialized");
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void onTabReselected(@BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
                return;
            }
            return;
        }
        TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
        WeakHashMap weakHashMap = tabReSelectedStore == null ? new WeakHashMap() : tabReSelectedStore.getPageCache();
        BridgeCallback bridgeCallback2 = (BridgeCallback) weakHashMap.remove(activePage.getPageId());
        if (bridgeCallback2 != null) {
            bridgeCallback2.close();
        }
        weakHashMap.put(activePage.getPageId(), bridgeCallback);
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void removeTabBarBadge(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.removeTabBarBadge(i)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarBadge(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingParam({"text"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(str, "text");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0 || str.length() == 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarBadge(i, str)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarItem(@BindingNode(App.class) App app, @BindingParam({"index"}) int i, @BindingParam({"text"}) String str, @BindingParam({"iconPath"}) String str2, @BindingParam({"selectedIconPath"}) String str3, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarItem(i, str, str2, str3)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarItems(@BindingNode(App.class) App app, @BindingParam({"tabs"}) JsonArray jsonArray, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || jsonArray == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarItems(jsonArray)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarStyle(@BindingNode(App.class) App app, @BindingParam({"color"}) String str, @BindingParam({"selectedColor"}) String str2, @BindingParam({"backgroundColor"}) String str3, @BindingParam({"borderStyle"}) String str4, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(str, "color");
        Intrinsics.h(str2, "selectedColor");
        Intrinsics.h(str3, "backgroundColor");
        Intrinsics.h(str4, "borderStyle");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarStyle(StringExtKt.takeIfNotEmpty(str), StringExtKt.takeIfNotEmpty(str2), StringExtKt.takeIfNotEmpty(str3), StringExtKt.takeIfNotEmpty(str4))) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBar(@BindingNode(App.class) App app, @BindingParam({"animation"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.showTabBar(z)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else {
            activePage.putStringValue(TmcConstants.KEY_IS_API_SHOW_TAB_BAR_ENABLED, "showTabBar");
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBarRedDot(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.showTabBarRedDot(i)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBarUnreadIcon(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i, @BindingParam({"iconPath"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else {
            if (str == null || str.length() == 0) {
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: T10001", bridgeCallback);
                    return;
                }
                return;
            }
            try {
                activePage.showTabBarUnreadIcon(i, str, new OooO0O0(bridgeCallback));
            } catch (Throwable th) {
                TmcLogger.e("TabBarBridge", th);
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, please check the config: T10005", bridgeCallback);
                }
            }
        }
    }
}
