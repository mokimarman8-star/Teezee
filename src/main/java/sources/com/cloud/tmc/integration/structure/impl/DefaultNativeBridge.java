package com.cloud.tmc.integration.structure.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.defaultImpl.DefaultAccessControlManagement;
import com.cloud.tmc.integration.dispatch.BridgeDispatcher;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import com.cloud.tmc.kernel.bridge.SendToRenderCallback;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.extension.bridge.BridgeGuard;
import com.cloud.tmc.kernel.extension.bridge.BridgePermission;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.point.NativeCallNotFoundPoint;
import com.cloud.tmc.kernel.point.NativeCallResultPoint;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.security.AccessControlException;
import com.cloud.tmc.kernel.security.AccessController;
import com.cloud.tmc.kernel.security.internal.DefaultAccessController;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DefaultNativeBridge implements NativeBridge {
    public static final String TAG = "TmcEngine:NativeBridge";
    private EngineRouter mEngineRouter;
    private boolean mReleased = false;

    private boolean executeNative(NativeCallContext nativeCallContext, @Nullable final SendToNativeCallback sendToNativeCallback, boolean z) {
        List<IRender> registeredRender;
        SendToRenderCallback takeCallback;
        Page activePage;
        if (nativeCallContext == null) {
            TmcLogger.w(TAG, "executeNative but bridgeContext == null!");
            return false;
        }
        if (nativeCallContext.getNode() == null) {
            TmcLogger.w(TAG, "executeNative with node == null!!! may cause memory leak");
        }
        if (nativeCallContext.getRender() == null) {
            if (nativeCallContext.getNode() instanceof Page) {
                nativeCallContext.setRender(nativeCallContext.getNode().getRender());
            } else if ((nativeCallContext.getNode() instanceof App) && (activePage = nativeCallContext.getNode().getActivePage()) != null) {
                nativeCallContext.setRender(activePage.getRender());
            }
        }
        EngineRouter engineRouter = this.mEngineRouter;
        if (engineRouter != null && (registeredRender = engineRouter.getRegisteredRender()) != null) {
            for (IRender iRender : registeredRender) {
                if (iRender.getRenderBridge() != null && (takeCallback = iRender.getRenderBridge().takeCallback(nativeCallContext.getId())) != null) {
                    TmcLogger.d(TAG, "executeNative hit callback! " + nativeCallContext.getId());
                    takeCallback.onCallBack(nativeCallContext.getParams());
                    return true;
                }
            }
        }
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            TmcLogger.w(TAG, "cannot dispatch empty API!");
            return true;
        }
        BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(new SendToNativeCallback() { // from class: com.cloud.tmc.integration.structure.impl.DefaultNativeBridge.1
            public void onCallback(JsonObject jsonObject, boolean z2, boolean z3) {
                SendToNativeCallback sendToNativeCallback2 = sendToNativeCallback;
                if (sendToNativeCallback2 != null) {
                    sendToNativeCallback2.onCallback(jsonObject, z2, z3);
                }
            }

            public void onCallback(HashMap<String, Object> hashMap, boolean z2, boolean z3) {
                SendToNativeCallback sendToNativeCallback2 = sendToNativeCallback;
                if (sendToNativeCallback2 != null) {
                    sendToNativeCallback2.onCallback(hashMap, z2, z3);
                }
            }
        });
        bridgeResponseHelper.setCallbackId(nativeCallContext.getCallbackId());
        TmcLogger.d(TAG, "executeNative jsapi req name={" + nativeCallContext.getName() + "} " + nativeCallContext.getId() + " " + nativeCallContext.getParams());
        if (BridgeDispatcher.getInstance().dispatch(nativeCallContext, bridgeResponseHelper, z)) {
            return true;
        }
        TmcLogger.w(TAG, "executeNative but not found Extension!" + nativeCallContext.getName());
        if (z) {
            try {
                if (doCheckPermission(nativeCallContext, bridgeResponseHelper)) {
                    return true;
                }
            } catch (AccessControlException unused) {
                TmcLogger.d(TAG, "executeNative check failed for legacy call! " + nativeCallContext.getName());
                bridgeResponseHelper.sendNoRigHtToInvoke();
                return true;
            }
        }
        if (ExtensionPoint.as(NativeCallNotFoundPoint.class).node(nativeCallContext.getNode()).create().handleNotFound(nativeCallContext, bridgeResponseHelper)) {
            TmcLogger.d(TAG, "executeNative handleNotFound intercepted");
            return true;
        }
        bridgeResponseHelper.sendNotFound();
        return false;
    }

    public void bindEngineRouter(EngineRouter engineRouter) {
        this.mEngineRouter = engineRouter;
    }

    public boolean doCheckPermission(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) throws AccessControlException {
        DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement(nativeCallContext, bridgeResponseHelper, BridgeDispatcher.getInstance().getExtensionManager());
        DefaultAccessController defaultAccessController = new DefaultAccessController();
        defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BridgeGuard(new BridgePermission(nativeCallContext.getName(), nativeCallContext.getName())));
        if (defaultAccessController.check(nativeCallContext.getNode(), arrayList, (AccessController.ApplyCallback) null)) {
            TmcLogger.d(TAG, "executeNative check pending! " + nativeCallContext.getName());
            return true;
        }
        TmcLogger.d(TAG, "executeNative check success! " + nativeCallContext.getName());
        return false;
    }

    public NativeCallResultPoint getNativeCallResultPoint(NativeCallContext nativeCallContext) {
        return ExtensionPoint.as(NativeCallResultPoint.class).node(nativeCallContext.getNode()).create();
    }

    protected void onRelease() {
    }

    public final void release() {
        if (this.mReleased) {
            return;
        }
        this.mReleased = true;
        onRelease();
    }

    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable SendToNativeCallback sendToNativeCallback) {
        if (!this.mReleased && nativeCallContext != null) {
            return executeNative(nativeCallContext, sendToNativeCallback, true);
        }
        TmcLogger.w(TAG, "sendToNative but released!");
        return false;
    }

    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable SendToNativeCallback sendToNativeCallback, boolean z) {
        if (!this.mReleased && nativeCallContext != null) {
            return executeNative(nativeCallContext, sendToNativeCallback, z);
        }
        TmcLogger.w(TAG, "sendToNative but released!");
        return false;
    }
}
