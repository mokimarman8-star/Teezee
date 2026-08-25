package com.cloud.tmc.miniapp.nativewebview.interfaces;

import android.webkit.JavascriptInterface;
import com.cloud.tmc.integration.minicover.NativeComponentManager;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.minicover.base.BaseNativeComponent;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.miniapp.nativewebview.OooO0O0;
import com.cloud.tmc.miniapp.nativewebview.OooO0o;
import com.cloud.tmc.miniapp.nativewebview.listener.OooO00o;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NativeWebviewInterface {
    @JavascriptInterface
    public final void onScrollChanged(String str) {
        OooO0o oooO0o;
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        try {
            BaseNativeComponent componentView = NativeComponentManager.INSTANCE.getComponentView(str);
            OooO0O0 oooO0O0 = componentView instanceof OooO0O0 ? (OooO0O0) componentView : null;
            if (oooO0O0 == null || (oooO0o = oooO0O0.OooO0OO) == null) {
                return;
            }
            try {
                if (oooO0o.OooOOo) {
                    ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).hideKeyboard(oooO0o);
                }
            } catch (Throwable th) {
                TmcLogger.e(oooO0o.OooO0OO, th);
            }
        } catch (Throwable th2) {
            TmcLogger.e("receiveUrlIcon", th2);
        }
    }

    @JavascriptInterface
    public final void receiveUrlIcon(String str, String str2) {
        OooO0o oooO0o;
        Intrinsics.h(str, "icon");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        try {
            BaseNativeComponent componentView = NativeComponentManager.INSTANCE.getComponentView(str2);
            OooO0O0 oooO0O0 = componentView instanceof OooO0O0 ? (OooO0O0) componentView : null;
            if (oooO0O0 == null || (oooO0o = oooO0O0.OooO0OO) == null) {
                return;
            }
            Intrinsics.h(str, "iconUrl");
            JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onReceivedIcon").addProperty("favicon", str).build();
            Intrinsics.g(build, "create().addProperty(KEY…FAVICON, iconUrl).build()");
            OooO00o oooO00o = oooO0o.OooO0o;
            if (oooO00o != null) {
                oooO00o.OooO00o("onReceivedIcon", build);
            }
        } catch (Throwable th) {
            TmcLogger.e("receiveUrlIcon", th);
        }
    }
}
