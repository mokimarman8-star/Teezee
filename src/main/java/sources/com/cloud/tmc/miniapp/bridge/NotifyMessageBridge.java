package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
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
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NotifyMessageBridge implements BridgeExtension {
    public final String OooO00o = "NotifyMessageBridge";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    public final String getTAG() {
        return this.OooO00o;
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
    public final void updateMessageScopeStatus(@BindingNode(App.class) App app, @BindingParam({"appId"}) String str, @BindingParam({"appName"}) String str2, @BindingParam({"appLogo"}) String str3, @BindingParam({"status"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "appName");
        Intrinsics.h(str3, "appLogo");
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "updateMessageScopeStatus:appId->" + str + ",status->" + z);
            ScopeUtils.OooO00o.OooO00o(context, "notifyMessage", str, z, str2, str3, false, true);
            bridgeCallback.sendSuccessResponse();
            unit = Unit.a;
        }
        if (unit == null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void updateNotifyMessageStatus(@BindingNode(App.class) App app, @BindingParam({"status"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(bridgeCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            AppContext appContext = app.getAppContext();
            if (appContext == null || (context = appContext.getContext()) == null) {
                unit = null;
            } else {
                TmcLogger.d(this.OooO00o, "updateNotifyMessageStatus:->" + z);
                Intrinsics.h(context, "context");
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_NEW_MESSAGE_STATUS, z);
                if (!z) {
                    Intrinsics.h(context, "context");
                    Intrinsics.h("", "msgStr");
                    try {
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", "");
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_NEW_MESSAGE_STATUS, !Intrinsics.c("", ""));
                    } catch (Throwable th) {
                        TmcLogger.e("MiniappMsgDataProvider", th);
                    }
                }
                bridgeCallback.sendSuccessResponse();
                unit = Unit.a;
            }
            if (unit == null) {
                bridgeCallback.sendFailResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, th2);
        }
    }
}
