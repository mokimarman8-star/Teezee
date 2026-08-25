package com.cloud.tmc.miniapp.nativewebview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.minicover.base.BaseNativeComponent;
import com.cloud.tmc.kernel.minicover.callback.OnEventCallback;
import com.cloud.tmc.kernel.minicover.callback.OnViewChangeCallback;
import com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.JsonObjectUtils;
import com.cloud.tmc.miniapp.nativewebview.OooO0O0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 extends BaseNativeComponent {
    public final IRender OooO00o;
    public final String OooO0O0;
    public final OooO0o OooO0OO;
    public final OooO00o OooO0Oo;

    public final class OooO00o implements com.cloud.tmc.miniapp.nativewebview.listener.OooO00o {
        public OooO00o() {
        }

        public static final void OooO00o(OooO0O0 oooO0O0, String str, JsonObject jsonObject) {
            Intrinsics.h(oooO0O0, "this$0");
            Intrinsics.h(str, "$eventName");
            Intrinsics.h(jsonObject, "$json");
            try {
                TmcLogger.e(oooO0O0.OooO0O0, "onWebviewEvent eventName=" + str + " $ json = " + jsonObject);
                oooO0O0.postEventMessage(str, jsonObject);
            } catch (Throwable th) {
                TmcLogger.e(oooO0O0.OooO0O0, "onWebviewEvent", th);
            }
        }

        @Override // com.cloud.tmc.miniapp.nativewebview.listener.OooO00o
        public void OooO00o(final String str, final JsonObject jsonObject) {
            Intrinsics.h(str, "eventName");
            Intrinsics.h(jsonObject, "json");
            try {
                ExecutorType executorType = ExecutorType.IO;
                final OooO0O0 oooO0O0 = OooO0O0.this;
                ExecutorUtils.execute(executorType, new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0O0.OooO00o.OooO00o(OooO0O0.this, str, jsonObject);
                    }
                });
            } catch (Throwable th) {
                TmcLogger.e(OooO0O0.this.OooO0O0, "onWebviewEvent", th);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0O0(Context context, String str, String str2, IRender iRender) {
        super(context, str, str2, iRender);
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "renderId");
        Intrinsics.h(str2, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(iRender, "render");
        this.OooO00o = iRender;
        this.OooO0O0 = "NativeWebViewComponent";
        this.OooO0OO = new OooO0o(str2, context, new WeakReference(iRender.getActivity()), null);
        this.OooO0Oo = new OooO00o();
    }

    @Override // com.cloud.tmc.kernel.minicover.base.BaseNativeComponent
    public String getComponentName() {
        return "native-webview";
    }

    @Override // com.cloud.tmc.kernel.minicover.base.BaseNativeComponent
    public View getComponentView() {
        return this.OooO0OO;
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onAddView(JsonObject jsonObject, OnViewChangeCallback onViewChangeCallback) {
        Intrinsics.h(onViewChangeCallback, "onViewChangeCallback");
        try {
            OooO0o oooO0o = this.OooO0OO;
            oooO0o.OooO0o = this.OooO0Oo;
            oooO0o.OooO00o(jsonObject, BaseComponentLifecycle.ViewAction.ON_ADD_VIEW);
            PageNode page = this.OooO00o.getPage();
            if (page != null) {
                this.OooO0OO.OooO00o((Node) page);
                OooO0o oooO0o2 = this.OooO0OO;
                oooO0o2.getClass();
                Intrinsics.h(page, "node");
                try {
                    PageNode pageNode = page instanceof PageNode ? page : null;
                    if (pageNode != null) {
                        pageNode.addOnKeyboardListener(oooO0o2);
                    }
                } catch (Throwable th) {
                    TmcLogger.e(oooO0o2.OooO0OO, "", th);
                }
            }
            onViewChangeCallback.onSuccess();
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0O0, "onAddView", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onDestory() {
        try {
            this.OooO0OO.OooO0o();
            OooO0o oooO0o = this.OooO0OO;
            PageNode page = this.OooO00o.getPage();
            Intrinsics.g(page, "render.page");
            oooO0o.getClass();
            Intrinsics.h(page, "node");
            try {
                PageNode pageNode = page instanceof PageNode ? page : null;
                if (pageNode != null) {
                    pageNode.removeOnKeyboardListener(oooO0o);
                }
            } catch (Throwable th) {
                TmcLogger.e(oooO0o.OooO0OO, "", th);
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0O0, "onDestory", th2);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.cloud.tmc.kernel.minicover.base.BaseNativeComponent
    public void onEventMessage(String str, JsonObject jsonObject, OnEventCallback onEventCallback) {
        Intrinsics.h(str, "methodName");
        Intrinsics.h(jsonObject, NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS);
        Intrinsics.h(onEventCallback, RenderCallContext.TYPE_CALLBACK);
        try {
            TmcLogger.e(this.OooO0O0, "onEventMessage method = " + str + ", args = " + jsonObject);
            switch (str.hashCode()) {
                case -1691085464:
                    if (!str.equals("loadDataWithBaseURL")) {
                        break;
                    } else {
                        JsonElement jsonElement = jsonObject.get("baseUrl");
                        String asString = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString != null) {
                            JsonElement jsonElement2 = jsonObject.get("pageHtmlData");
                            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                            if (asString2 != null) {
                                JsonElement jsonElement3 = jsonObject.get("mimeType");
                                String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                                if (asString3 == null) {
                                    asString3 = "text/html";
                                }
                                JsonElement jsonElement4 = jsonObject.get("encoding");
                                String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                                if (asString4 == null) {
                                    asString4 = TmcConstants.DEFAULT_ENCODING;
                                }
                                this.OooO0OO.OooO00o(asString, asString2, asString3, asString4);
                                OnEventCallback.DefaultImpls.onSuccess$default(onEventCallback, null, 1, null);
                                break;
                            }
                        }
                    }
                    break;
                case -1241591313:
                    if (!str.equals("goBack")) {
                        break;
                    } else {
                        if (this.OooO0OO.OooO00o()) {
                            OnEventCallback.DefaultImpls.onSuccess$default(onEventCallback, null, 1, null);
                        }
                        this.OooO0OO.OooOO0o();
                        break;
                    }
                case -934641255:
                    if (!str.equals("reload")) {
                        break;
                    } else {
                        this.OooO0OO.OooOO0O();
                        OnEventCallback.DefaultImpls.onSuccess$default(onEventCallback, null, 1, null);
                        break;
                    }
                case -318289731:
                    if (!str.equals("goForward")) {
                        break;
                    } else {
                        if (this.OooO0OO.OooO0o0.canGoForward()) {
                            this.OooO0OO.OooO0o0.goForward();
                            OnEventCallback.DefaultImpls.onSuccess$default(onEventCallback, null, 1, null);
                        }
                        this.OooO0OO.OooOO0o();
                        break;
                    }
                case 233302058:
                    if (!str.equals("getPageUrl")) {
                        break;
                    } else {
                        onEventCallback.onSuccess(JsonObjectUtils.create().addProperty("pageUrl", this.OooO0OO.getPageUrl()));
                        break;
                    }
                case 336631465:
                    if (!str.equals("loadUrl")) {
                        break;
                    } else {
                        JsonElement jsonElement5 = jsonObject.get("url");
                        String asString5 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                        if (asString5 != null) {
                            this.OooO0OO.OooO0O0(asString5);
                            OnEventCallback.DefaultImpls.onSuccess$default(onEventCallback, null, 1, null);
                            break;
                        }
                    }
                    break;
            }
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0O0, "onEventMessage", th);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.base.BaseNativeComponent
    public boolean onInterceptBackPressed() {
        PageContext pageContext;
        ViewGroup contentView;
        try {
            TmcLogger.d(this.OooO0O0, "hide keyboard->" + this.OooO0OO.OooO0Oo());
            if (!this.OooO0OO.OooO0Oo()) {
                if (!this.OooO0OO.OooO00o()) {
                    TmcLogger.d(this.OooO0O0, "onInterceptBackPressed -> false");
                    return false;
                }
                TmcLogger.d(this.OooO0O0, "onInterceptBackPressed -> true");
                this.OooO0OO.OooOO0o();
                return true;
            }
            try {
                PageNode page = this.OooO00o.getPage();
                PageNode pageNode = page instanceof PageNode ? page : null;
                if (pageNode != null && (pageContext = pageNode.getPageContext()) != null && (contentView = pageContext.getContentView()) != null) {
                    ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).hideKeyboard(contentView);
                }
                TmcLogger.d(this.OooO0O0, "hide keyboard");
                return true;
            } catch (Throwable th) {
                TmcLogger.e(this.OooO0O0, "hide keyboard error ", th);
                return false;
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0O0, "onInterceptBackPressed", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onPause() {
        try {
            this.OooO0OO.OooO0oO();
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0O0, "onPause", th);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onRemove() {
        try {
            this.OooO0OO.OooO0oo();
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0O0, "onRemove", th);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onResume() {
        try {
            this.OooO0OO.OooO();
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0O0, "onResume", th);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onStop() {
        try {
            this.OooO0OO.OooOO0();
        } catch (Throwable unused) {
            TmcLogger.e(this.OooO0O0, "onStop");
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onUpdateView(JsonObject jsonObject, OnViewChangeCallback onViewChangeCallback) {
        Intrinsics.h(onViewChangeCallback, "onViewChangeCallback");
        try {
            this.OooO0OO.OooO00o(jsonObject, BaseComponentLifecycle.ViewAction.ON_UPDATE_VIEW);
            onViewChangeCallback.onSuccess();
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0O0, "onUpdateView", th);
        }
    }
}
