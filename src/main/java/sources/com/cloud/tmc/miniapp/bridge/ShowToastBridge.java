package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import com.cloud.tmc.integration.model.AlertBeforeUnloadCache;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.utils.toast.ToastUtils;
import com.cloud.tmc.miniapp.utils.toast.config.ToastType;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ShowToastBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO(BridgeCallback bridgeCallback) {
            super(0);
            this.OooO00o = bridgeCallback;
        }

        public Object invoke() {
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
            return Unit.a;
        }
    }

    public static final class OooO00o {
    }

    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(BridgeCallback bridgeCallback) {
            super(0);
            this.OooO00o = bridgeCallback;
        }

        public Object invoke() {
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
            return Unit.a;
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(BridgeCallback bridgeCallback) {
            super(0);
            this.OooO00o = bridgeCallback;
        }

        public Object invoke() {
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
            return Unit.a;
        }
    }

    public static final class OooO0o extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(BridgeCallback bridgeCallback) {
            super(0);
            this.OooO00o = bridgeCallback;
        }

        public Object invoke() {
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
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
    public final void disableAlertBeforeUnload(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app == null || page == null || Intrinsics.c(app.getFirstPage(), page) || page.isTabPage()) {
            bridgeCallback.sendFailResponse();
            return;
        }
        AlertBeforeUnloadCache alertBeforeUnloadCache = (AlertBeforeUnloadCache) page.getData(AlertBeforeUnloadCache.class);
        if (alertBeforeUnloadCache == null) {
            bridgeCallback.sendSuccessResponse();
        } else {
            alertBeforeUnloadCache.setEnabled(false);
            bridgeCallback.sendSuccessResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void enableAlertBeforeUnload(@BindingParam({"message"}) String str, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(str, "message");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        if (app == null || page == null || Intrinsics.c(app.getFirstPage(), page) || page.isTabPage() || str.length() == 0) {
            bridgeCallback.sendFailResponse();
        } else {
            page.setData(AlertBeforeUnloadCache.class, new AlertBeforeUnloadCache(true, str));
            bridgeCallback.sendSuccessResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideLoading(@BindingParam(name = {"noConflict"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        if (z) {
            ToastUtils.cancel();
        } else {
            ToastUtils.hideLoading();
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideToast(@BindingParam(name = {"noConflict"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        if (z) {
            ToastUtils.cancel();
        } else {
            ToastUtils.hideToast();
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d("showToast", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d("showToast", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showActionSheet(@BindingParam(name = {"itemList", "actions"}) JsonArray jsonArray, @BindingParam(name = {"itemColor"}, stringDefault = "#191F2B") String str, @BindingParam(name = {"type"}, stringDefault = "text") String str2, @BindingParam(name = {"title"}) String str3, @BindingParam(name = {"alertText", "content"}) String str4, @BindingParam(booleanDefault = true, name = {"showCancel"}) boolean z, @BindingParam(name = {"cancelText"}, stringDefault = "Cancel") String str5, @BindingParam(name = {"cancelColor"}, stringDefault = "#191F2B") String str6, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Intrinsics.h(str, "itemColor");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_TYPE);
        Intrinsics.h(str5, "cancelText");
        Intrinsics.h(str6, "cancelColor");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        String appId = app != null ? app.getAppId() : null;
        if (context == null || appId == null || appId.length() == 0 || jsonArray == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: AS10001", bridgeCallback);
            }
        } else {
            if (Intrinsics.c(str2, "text") || Intrinsics.c(str2, "icon")) {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).showActionSheet(jsonArray, str2, str3, str4, str, z, str5, str6, context, appId, bridgeCallback);
                return;
            }
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", str2 + " is not supported: AS10002");
                bridgeCallback.sendFailResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showAddHomeTipsToast(@BindingNode(App.class) App app, @BindingParam({"showType"}) int i, @BindingParam({"showDelayTime"}) long j, @BindingParam({"closeDelayTime"}) long j2, @BindingParam({"message"}) String str, @BindingParam({"iconUrl"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Intrinsics.h(str, "message");
        Intrinsics.h(str2, "iconUrl");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            if (!CollectionsKt.o(new Integer[]{1, 2}).contains(Integer.valueOf(i))) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", i + " is not supported: AS10002");
                bridgeCallback.sendFailResponse(jsonObject);
                return;
            }
            if (AddHomeToScreenUtils.INSTANCE.checkAddhomeShowStatus(81, app)) {
                return;
            }
            Context context = null;
            if (PermissionScopeBridge.Companion.OooO00o(app != null ? app.getAppId() : null)) {
                TmcLogger.d("showToast", "dev dialog is showing, return");
                return;
            }
            if (app != null && (appContext = app.getAppContext()) != null) {
                context = appContext.getContext();
            }
            if (!(context instanceof MiniAppActivity)) {
                bridgeCallback.sendFailResponse();
            } else {
                ((MiniAppActivity) context).checkAndShowAddHomeCustomToast(i, j, j2, str, str2);
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th) {
            TmcLogger.e("showToast", th);
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showLoading(@BindingParam(name = {"title"}) String str, @BindingParam(intDefault = 1, name = {"duration"}) int i, @BindingParam(booleanDefault = true, name = {"mask"}) boolean z, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Intrinsics.h(str, "msg");
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            if (str.length() == 0) {
                AppContext appContext = app.getAppContext();
                str = (appContext == null || (context = appContext.getContext()) == null) ? null : context.getString(R.string.dialog_loading_tv);
            }
            showToast(StringExtKt.orDefault(str, ""), ToastType.LOADING.INSTANCE.getName(), null, i, z, app, bridgeCallback);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showModal(@BindingParam(name = {"title"}) String str, @BindingParam(name = {"content"}) String str2, @BindingParam(name = {"showCancel"}) boolean z, @BindingParam(name = {"editable"}) boolean z2, @BindingParam(name = {"placeholderText"}) String str3, @BindingParam(name = {"cancelText"}) String str4, @BindingParam(name = {"cancelColor"}) String str5, @BindingParam(name = {"confirmText"}) String str6, @BindingParam(name = {"confirmColor"}) String str7, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context != null) {
            ((ToastProxy) TmcProxy.get(ToastProxy.class)).showModal(str, str2, z, z2, str3, str4, str5, str6, str7, context, bridgeCallback);
        } else if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showToast(@BindingParam(name = {"msg", "title"}) String str, @BindingParam(name = {"icon"}, stringDefault = "none") String str2, @BindingParam(name = {"image"}) String str3, @BindingParam(intDefault = 1500, name = {"duration"}) int i, @BindingParam(name = {"mask"}) boolean z, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        int i2 = i;
        Intrinsics.h(str, "msg");
        Intrinsics.h(str2, "icon");
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (i2 == 1) {
            i2 = 1;
        } else if (i2 == 0 || i2 > 60000 || i2 < 1000) {
            i2 = 0;
        }
        File file = (str3 == null || str3.length() == 0) ? null : FileUtil.getFile(app, str3);
        ToastType.SUCCESS success = ToastType.SUCCESS.INSTANCE;
        if (Intrinsics.c(str2, success.getName())) {
            ToastUtils.showLoading$default(str, success, i2, 0L, z, file, new OooO0O0(bridgeCallback), 8, null);
            return;
        }
        ToastType.ERROR error = ToastType.ERROR.INSTANCE;
        if (Intrinsics.c(str2, error.getName())) {
            ToastUtils.showLoading$default(str, error, i2, 0L, z, file, new OooO0OO(bridgeCallback), 8, null);
            return;
        }
        ToastType.LOADING loading = ToastType.LOADING.INSTANCE;
        if (Intrinsics.c(str2, loading.getName())) {
            ToastUtils.showLoading$default(str, loading, i2, 0L, z, file, new OooO0o(bridgeCallback), 8, null);
        } else if (Intrinsics.c(str2, ToastType.NONE.INSTANCE.getName())) {
            ToastUtils.showToast$default(str, i2, 0L, z, new OooO(bridgeCallback), 4, null);
        } else if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
        }
    }
}
