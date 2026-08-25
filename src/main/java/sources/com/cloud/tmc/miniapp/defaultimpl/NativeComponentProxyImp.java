package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import com.cloud.tmc.integration.callback.ICheckMiniAppLifecycleCallback;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.ui.native.NativeImgComponent;
import com.cloud.tmc.integration.ui.native.NativeTabComponent;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentProxy;
import com.cloud.tmc.kernel.minicover.base.BaseNativeComponent;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.render.IRender;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NativeComponentProxyImp implements NativeComponentProxy {
    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public boolean checkResumedStatus(String str) {
        ICheckMiniAppLifecycleCallback appLifecycleCallback;
        try {
            App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
            if (findApp == null || (appLifecycleCallback = findApp.getAppLifecycleCallback()) == null) {
                return true;
            }
            return appLifecycleCallback.checkIsForeground();
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public BaseNativeComponent getComponentNativeImgInstance(Context context, String str, String str2, IRender iRender) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "renderId");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(iRender, "render");
        return new NativeImgComponent(context, str, str2, iRender);
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public BaseNativeComponent getComponentNativeTabInstance(Context context, String str, String str2, IRender iRender) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "renderId");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(iRender, "render");
        return new NativeTabComponent(context, str, str2, iRender);
    }

    @Override // com.cloud.tmc.kernel.minicover.NativeComponentProxy
    public BaseNativeComponent getComponentNativeWebViewInstance(Context context, String str, String str2, IRender iRender) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "renderId");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(iRender, "render");
        return com.cloud.tmc.miniapp.nativewebview.OooO0OO.OooO00o.OooO00o(context, str, str2, iRender);
    }
}
