package com.cloud.tmc.miniapp.nativewebview;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.minicover.NativeComponentManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.minicover.base.BaseNativeComponent;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO {
    public static final OooO0OO OooO00o = new OooO0OO();
    public static final ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> OooO0O0 = new ConcurrentHashMap<>();

    public final BaseNativeComponent OooO00o(Context context, String str, String str2, IRender iRender) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "renderId");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(iRender, "render");
        String appId = iRender.getAppId();
        ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> concurrentHashMap = OooO0O0;
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = concurrentHashMap.get(appId);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        if (concurrentLinkedQueue.size() >= MiniAppConfigHelper.INSTANCE.getConfigTargetInt(LauncherMiniAppConfigHelper.KEY_MINIAPP_MAX_NATIVE_WEBVIEW_NUM, 5)) {
            String poll = concurrentLinkedQueue.poll();
            View view = iRender.getView();
            WebView webView = view instanceof WebView ? (WebView) view : null;
            TmcLogger.d("NativeWebviewManager", "webviewQueue size >= 5,remove " + poll);
            NativeComponentManager nativeComponentManager = NativeComponentManager.INSTANCE;
            Intrinsics.g(poll, "removeViewId");
            nativeComponentManager.removeNativeComponent(webView, poll, str);
        }
        OooO0O0 oooO0O0 = new OooO0O0(context, str, str2, iRender);
        concurrentLinkedQueue.add(str2);
        Intrinsics.g(appId, "appId");
        concurrentHashMap.put(appId, concurrentLinkedQueue);
        return oooO0O0;
    }
}
