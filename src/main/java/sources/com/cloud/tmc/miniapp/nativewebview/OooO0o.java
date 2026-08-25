package com.cloud.tmc.miniapp.nativewebview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import androidx.collection.s;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.kernel.constants.JSApiResultCode;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.listener.OnKeyboardListener;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.render.WebviewPageCallback;
import com.cloud.tmc.kernel.render.WebviewPageEventCallback;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.util.BarUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.HttpUtils;
import com.cloud.tmc.render.system.DefaultDownloadListener;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0o extends FrameLayout implements WebviewPageEventCallback, WebviewPageCallback, OnKeyboardListener {
    public long OooO;
    public final String OooO00o;
    public final WeakReference<Activity> OooO0O0;
    public final String OooO0OO;
    public final Lazy OooO0Oo;
    public com.cloud.tmc.miniapp.nativewebview.listener.OooO00o OooO0o;
    public final com.cloud.tmc.miniapp.nativewebview.view.OooO00o OooO0o0;
    public String OooO0oO;
    public String OooO0oo;
    public final Stack<OooO00o> OooOO0;
    public boolean OooOO0O;
    public DefaultDownloadListener OooOO0o;
    public final String OooOOO;
    public boolean OooOOO0;
    public final Stack<String> OooOOOO;
    public final List<String> OooOOOo;
    public boolean OooOOo;
    public int OooOOo0;
    public long OooOOoo;

    public static final class OooO00o {
        public long OooO;
        public String OooO00o;
        public boolean OooO0O0;
        public boolean OooO0OO;
        public boolean OooO0Oo;
        public boolean OooO0o;
        public boolean OooO0o0;
        public String OooO0oO;
        public ConcurrentHashMap<Integer, Long> OooO0oo;
        public boolean OooOO0;

        public OooO00o() {
            this(null, false, false, false, false, false, null, null, 0L, false, 1023);
        }

        public OooO00o(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str2, ConcurrentHashMap<Integer, Long> concurrentHashMap, long j, boolean z6) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "virtual_h5PageId");
            Intrinsics.h(concurrentHashMap, "progressCollectList");
            this.OooO00o = str;
            this.OooO0O0 = z;
            this.OooO0OO = z2;
            this.OooO0Oo = z3;
            this.OooO0o0 = z4;
            this.OooO0o = z5;
            this.OooO0oO = str2;
            this.OooO0oo = concurrentHashMap;
            this.OooO = j;
            this.OooOO0 = z6;
        }

        public /* synthetic */ OooO00o(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str2, ConcurrentHashMap concurrentHashMap, long j, boolean z6, int i) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? "0" : null, (i & 128) != 0 ? new ConcurrentHashMap() : null, (i & 256) != 0 ? System.currentTimeMillis() : j, (i & 512) == 0 ? z6 : false);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OooO00o)) {
                return false;
            }
            OooO00o oooO00o = (OooO00o) obj;
            return Intrinsics.c(this.OooO00o, oooO00o.OooO00o) && this.OooO0O0 == oooO00o.OooO0O0 && this.OooO0OO == oooO00o.OooO0OO && this.OooO0Oo == oooO00o.OooO0Oo && this.OooO0o0 == oooO00o.OooO0o0 && this.OooO0o == oooO00o.OooO0o && Intrinsics.c(this.OooO0oO, oooO00o.OooO0oO) && Intrinsics.c(this.OooO0oo, oooO00o.OooO0oo) && this.OooO == oooO00o.OooO && this.OooOO0 == oooO00o.OooOO0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.OooO00o.hashCode() * 31;
            boolean z = this.OooO0O0;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.OooO0OO;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.OooO0Oo;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z4 = this.OooO0o0;
            int i7 = z4;
            if (z4 != 0) {
                i7 = 1;
            }
            int i10 = (i6 + i7) * 31;
            boolean z5 = this.OooO0o;
            int i11 = z5;
            if (z5 != 0) {
                i11 = 1;
            }
            int a = (s.a(this.OooO) + ((this.OooO0oo.hashCode() + ((this.OooO0oO.hashCode() + ((i10 + i11) * 31)) * 31)) * 31)) * 31;
            boolean z6 = this.OooOO0;
            return a + (z6 ? 1 : z6 ? 1 : 0);
        }

        public String toString() {
            return "PageStatus(url=" + this.OooO00o + ", isProgressChangedTo100=" + this.OooO0O0 + ", isPageFinished=" + this.OooO0OO + ", isHomePage=" + this.OooO0Oo + ", isLoadError=" + this.OooO0o0 + ", canGoBack=" + this.OooO0o + ", virtual_h5PageId=" + this.OooO0oO + ", progressCollectList=" + this.OooO0oo + ", progressStartTime=" + this.OooO + ", isDomContentLoaded=" + this.OooOO0 + ")";
        }
    }

    public /* synthetic */ class OooO0O0 {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[BaseComponentLifecycle.ViewAction.values().length];
            try {
                iArr[BaseComponentLifecycle.ViewAction.ON_ADD_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BaseComponentLifecycle.ViewAction.ON_UPDATE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            OooO00o = iArr;
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<FrameLayout> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return (FrameLayout) OooO0o.this.findViewById(R.id.baseLayout);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0o(String str, Context context, WeakReference<Activity> weakReference, AttributeSet attributeSet) {
        super(context, null);
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_VIEW_ID);
        Intrinsics.h(context, "context");
        this.OooO00o = str;
        this.OooO0O0 = weakReference;
        this.OooO0OO = "WebviewComponentView";
        this.OooO0Oo = LazyKt.b(new OooO0OO());
        this.OooO0oO = "";
        this.OooO0oo = "";
        this.OooOO0 = new Stack<>();
        LayoutInflater.from(getContext()).inflate(R.layout.layout_mini_webview_view, (ViewGroup) this, true);
        com.cloud.tmc.miniapp.nativewebview.view.OooO00o oooO00o = new com.cloud.tmc.miniapp.nativewebview.view.OooO00o(context, null, 2);
        oooO00o.OooO00o((WebviewPageCallback) this);
        oooO00o.OooO00o((WebviewPageEventCallback) this);
        oooO00o.setBackgroundColor(-1);
        this.OooO0o0 = oooO00o;
        FrameLayout frameLayout = getFrameLayout();
        if (frameLayout != null) {
            frameLayout.addView(oooO00o);
        }
        oooO00o.OooO00o();
        try {
            Activity activity = weakReference.get();
            if (activity != null) {
                boolean isNavBarVisible = BarUtils.isNavBarVisible(activity);
                this.OooOOO0 = isNavBarVisible;
                TmcLogger.d("WebviewComponentView", "isNavBarVisible ->" + isNavBarVisible);
            }
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0OO, th);
        }
        this.OooOOO = "h5Redirect";
        this.OooOOOO = new Stack<>();
        this.OooOOOo = new ArrayList();
    }

    public static final void OooO00o(long j, OooO0o oooO0o, Ref.ObjectRef objectRef, String str) {
        Intrinsics.h(oooO0o, "this$0");
        Intrinsics.h(objectRef, "$url");
        try {
            if (j <= oooO0o.OooO) {
                DefaultDownloadListener defaultDownloadListener = oooO0o.OooOO0o;
                if (defaultDownloadListener != null) {
                    defaultDownloadListener.onDownloadStart((String) objectRef.element, null, null, str, j);
                }
            } else {
                JsonObject build = JsonObjectUtils.create().addProperty("errorCode", JSApiResultCode.ERROR_CODE_DOWNLOAD_FILE_TOO_LARGE).addProperty(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, Boolean.FALSE).build();
                Intrinsics.g(build, "create().addProperty(\n  …\"success\", false).build()");
                DefaultDownloadListener defaultDownloadListener2 = oooO0o.OooOO0o;
                if (defaultDownloadListener2 != null) {
                    defaultDownloadListener2.onDownloadFail(build);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(oooO0o.OooO0OO, th);
        }
    }

    public static final void OooO00o(OooO0o oooO0o) {
        Intrinsics.h(oooO0o, "this$0");
        try {
            oooO0o.setLayoutParams(new AbsoluteLayout.LayoutParams(oooO0o.getWidth(), oooO0o.OooOOo0, oooO0o.getTop(), oooO0o.getLeft()));
        } catch (Throwable th) {
            TmcLogger.e(oooO0o.OooO0OO, th);
        }
    }

    public static final void OooO00o(OooO0o oooO0o, String str) {
        Intrinsics.h(oooO0o, "this$0");
        Intrinsics.h(str, "$url");
        oooO0o.OooO0o0.OooO00o(str);
    }

    public static final void OooO00o(OooO0o oooO0o, String str, String str2, String str3, String str4) {
        Intrinsics.h(oooO0o, "this$0");
        Intrinsics.h(str, "$baseUrl");
        Intrinsics.h(str2, "$data");
        Intrinsics.h(str3, "$mimeType");
        Intrinsics.h(str4, "$encoding");
        TmcLogger.d(oooO0o.OooO0OO, "loadDataWithBaseURL baseUrl:" + str);
        oooO0o.OooO0o0.loadDataWithBaseURL(str, str2, str3, str4, null);
    }

    public static final void OooO00o(OooO0o oooO0o, String str, String str2, String str3, String str4, long j) {
        Intrinsics.h(oooO0o, "this$0");
        DefaultDownloadListener defaultDownloadListener = oooO0o.OooOO0o;
        if (defaultDownloadListener != null) {
            defaultDownloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public static final void OooO00o(final Ref.ObjectRef objectRef, final OooO0o oooO0o, final String str) {
        Intrinsics.h(objectRef, "$url");
        Intrinsics.h(oooO0o, "this$0");
        final long contentLength = HttpUtils.getContentLength((String) objectRef.element);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.f
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(contentLength, oooO0o, objectRef, str);
            }
        });
    }

    public static final void OooO0O0(OooO0o oooO0o) {
        Intrinsics.h(oooO0o, "this$0");
        try {
            oooO0o.setLayoutParams(new AbsoluteLayout.LayoutParams(oooO0o.getWidth(), oooO0o.OooOOo0, oooO0o.getTop(), oooO0o.getLeft()));
        } catch (Throwable th) {
            TmcLogger.e(oooO0o.OooO0OO, th);
        }
    }

    public static final void OooO0OO(OooO0o oooO0o) {
        Intrinsics.h(oooO0o, "this$0");
        oooO0o.OooO0o0.reload();
    }

    private final FrameLayout getFrameLayout() {
        return (FrameLayout) this.OooO0Oo.getValue();
    }

    public final void OooO() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onResume").addProperty("pageUrl", this.OooO0o0.getUrl()).build();
        Intrinsics.g(build, "create().addProperty(KEY…URL, webView.url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onResume", build);
        }
    }

    public final void OooO00o(WebView webView, String str) {
        String url;
        TmcLogger.d(this.OooOOO, "redirectPageStarted ==================>");
        try {
            TmcLogger.d(this.OooOOO, "webView.original:" + (webView != null ? webView.getOriginalUrl() : null));
            TmcLogger.d(this.OooOOO, "webView.url:" + (webView != null ? webView.getUrl() : null));
            TmcLogger.d(this.OooOOO, "url:" + str);
            if (webView != null && (url = webView.getUrl()) != null) {
                this.OooOOOO.add(url);
            }
        } catch (Throwable unused) {
        }
        TmcLogger.d(this.OooOOO, "redirectPageStarted <==================");
    }

    public final void OooO00o(Node node) {
        Intrinsics.h(node, "node");
        try {
            this.OooOO0o = new DefaultDownloadListener(node);
            this.OooO0o0.setDownloadListener(new DownloadListener() { // from class: com.cloud.tmc.miniapp.nativewebview.i
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    OooO0o.OooO00o(OooO0o.this, str, str2, str3, str4, j);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0OO, "registerDownloadListener", th);
        }
    }

    public final void OooO00o(JsonObject jsonObject, BaseComponentLifecycle.ViewAction viewAction) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.h(viewAction, "viewAction");
        try {
            TmcLogger.e(this.OooO0OO, " parse json = " + (jsonObject != null ? jsonObject.toString() : null));
            if (jsonObject != null && (jsonElement2 = jsonObject.get("src")) != null) {
                String asString = jsonElement2.getAsString();
                int i = OooO0O0.OooO00o[viewAction.ordinal()];
                if (i == 1) {
                    Intrinsics.g(asString, "loadUrl");
                    this.OooO0oo = asString;
                    OooO0O0(asString);
                } else if (i == 2 && !TextUtils.isEmpty(asString) && !Intrinsics.c(asString, this.OooO0oo)) {
                    Intrinsics.g(asString, "loadUrl");
                    this.OooO0oo = asString;
                    OooO0O0(asString);
                }
            }
            if (jsonObject == null || (jsonElement = jsonObject.get("maxContentLength")) == null) {
                return;
            }
            try {
                String jsonElement3 = jsonElement.toString();
                Intrinsics.g(jsonElement3, "it.toString()");
                long parseLong = Long.parseLong(jsonElement3);
                this.OooO = parseLong;
                TmcLogger.d(this.OooO0OO, "maxContentLength:->" + parseLong);
            } catch (Throwable th) {
                TmcLogger.e(this.OooO0OO, th);
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0OO, "parseJson", th2);
        }
    }

    public final void OooO00o(String str, String str2) {
        Intrinsics.h(str, "webviewUrl");
        Intrinsics.h(str2, "webResourceRequestUrl");
        try {
            TmcLogger.d(this.OooO0OO, "redirect => webviewUrl: " + str + ", webResourceRequestUrl: " + str2);
            URL url = new URL(str);
            URL url2 = new URL(str2);
            String str3 = url.getHost() + url.getPath();
            String str4 = url2.getHost() + url2.getPath();
            TmcLogger.d(this.OooO0OO, "webviewURLCombine:" + str3);
            TmcLogger.d(this.OooO0OO, "webResourceRequestURLCombine:" + str4);
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (Intrinsics.c(str3, str4)) {
                    TmcLogger.d(this.OooO0OO, "redirect  进入backForward栈 => webviewUrl: " + str + ", webResourceRequestUrl: " + str2);
                    this.OooOO0.peek().OooO0o = true;
                } else {
                    TmcLogger.d(this.OooO0OO, "redirect  开始加载 => webviewUrl: " + str + ", webResourceRequestUrl: " + str2);
                    OooO00o(str2, false);
                    OooO0o0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(final String str, final String str2, final String str3, final String str4) {
        Intrinsics.h(str, "baseUrl");
        Intrinsics.h(str2, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        Intrinsics.h(str3, "mimeType");
        Intrinsics.h(str4, "encoding");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.c
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(OooO0o.this, str, str2, str3, str4);
            }
        });
    }

    public final void OooO00o(String str, boolean z) {
        Intrinsics.h(str, "loadingUrl");
        TmcLogger.d(this.OooO0OO, "setLoadingUrl => loadingUrl: " + str + " , isFirstLoadHomePage: " + z);
        this.OooO0oO = str;
        this.OooOO0O = z;
    }

    public final boolean OooO00o() {
        String str = this.OooOOO;
        com.cloud.tmc.miniapp.nativewebview.view.OooO00o oooO00o = this.OooO0o0;
        String originalUrl = oooO00o != null ? oooO00o.getOriginalUrl() : null;
        com.cloud.tmc.miniapp.nativewebview.view.OooO00o oooO00o2 = this.OooO0o0;
        TmcLogger.d(str, "canGoBack => originalUrl:" + originalUrl + " , url:" + (oooO00o2 != null ? oooO00o2.getUrl() : null));
        try {
            if (this.OooO0o0.canGoBack()) {
                if (!this.OooOOOo.isEmpty()) {
                    TmcLogger.d(this.OooOOO, "canGoBack => 重定向回退");
                    return OooO00o(this.OooO0o0);
                }
                TmcLogger.d(this.OooOOO, "canGoBack => 正常回退");
                this.OooO0o0.goBack();
                OooO0OO();
                return true;
            }
        } catch (Throwable unused) {
        }
        TmcLogger.d(this.OooOOO, "canGoBack => 直接退出");
        return false;
    }

    public final boolean OooO00o(WebView webView) {
        TmcLogger.d(this.OooOOO, "redirectCanGoBack => originalUrl:" + (webView != null ? webView.getOriginalUrl() : null) + " , url:" + (webView != null ? webView.getUrl() : null));
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    String pop = this.OooOOOO.pop();
                    if (pop == null) {
                        return false;
                    }
                    TmcLogger.d(this.OooOOO, "exitPage:" + pop);
                    WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                    Intrinsics.g(copyBackForwardList, "webView.copyBackForwardList()");
                    TmcLogger.d(this.OooOOO, "WebBackForwardList.size:" + copyBackForwardList.getSize());
                    int i = -1;
                    int i2 = -1;
                    for (int size = copyBackForwardList.getSize() - 1; -1 < size; size--) {
                        TmcLogger.d(this.OooOOO, "WebBackForwardList(" + size + ") => originalUrl:" + copyBackForwardList.getItemAtIndex(size).getOriginalUrl() + " , url:" + copyBackForwardList.getItemAtIndex(size).getUrl());
                        if (Intrinsics.c(copyBackForwardList.getItemAtIndex(size).getUrl(), pop)) {
                            if (i2 == -1) {
                                i2 = size;
                            }
                            i = size;
                        }
                    }
                    String OooO0O02 = OooO0O0();
                    if (OooO0O02 == null) {
                        return false;
                    }
                    TmcLogger.d(this.OooOOO, "prePage:" + OooO0O02);
                    int i3 = 1;
                    WebHistoryItem webHistoryItem = null;
                    for (int i4 = i + (-1); -1 < i4; i4--) {
                        WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i4);
                        if (Intrinsics.c(OooO0O02, itemAtIndex.getUrl())) {
                            i3 = i4;
                            webHistoryItem = itemAtIndex;
                        }
                    }
                    if (webHistoryItem != null) {
                        int i5 = i3 - i;
                        webView.goBackOrForward(i5);
                        OooO0OO();
                        TmcLogger.d(this.OooOOO, "goBackOrForward(" + i5 + ")");
                        return true;
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooOOO, "redirectCanGoBack fail:" + th);
            }
        }
        TmcLogger.d(this.OooOOO, "redirectCanGoBack -> 直接退出");
        return false;
    }

    public final boolean OooO00o(String str) {
        try {
            String path = new URL(str).getPath();
            Object fromJson = GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_MINIAPP_MAX_NATIVE_WEBVIEW_DOWNLOAD_CONFIG, "[\".pdf\",\".jpg\",\".png\",\".mp3\",\".mp4\",\".apk\",\".txt\",\".zip\"]"), (Class<Object>) List.class);
            List<String> list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList();
            }
            for (String str2 : list) {
                Intrinsics.g(path, TmcConstants.EXTRA_PATH);
                if (StringsKt.G(path, str2, false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String OooO0O0() {
        try {
            String peek = this.OooOOOO.peek();
            if (peek == null) {
                return null;
            }
            if (!CollectionsKt.b0(this.OooOOOo, peek)) {
                return peek;
            }
            this.OooOOOO.pop();
            return OooO0O0();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void OooO0O0(WebView webView) {
        TmcLogger.d(this.OooOOO, "redirectShouldOverrideUrlLoading ==================>");
        TmcLogger.d(this.OooOOO, "webview.url:" + (webView != null ? webView.getUrl() : null));
        TmcLogger.d(this.OooOOO, "redirectShouldOverrideUrlLoading <==================");
    }

    public final void OooO0O0(final String str) {
        Intrinsics.h(str, "url");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.b
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO00o(OooO0o.this, str);
            }
        });
    }

    public final void OooO0OO() {
        try {
            if (this.OooOO0.size() > 1) {
                OooO00o pop = this.OooOO0.pop();
                OooO00o peek = this.OooOO0.peek();
                TmcLogger.d(this.OooO0OO, "goBack => exitPage: " + pop + ", showPage: " + peek);
                OooO00o(peek.OooO00o, false);
                if (!pop.OooO0o) {
                    TmcLogger.d(this.OooO0OO, "goBack 页面未入栈，继续退出 => exitPage: " + pop + ", showPage: " + peek);
                    OooO0OO();
                }
            } else {
                TmcLogger.e(this.OooO0OO, "goBack fail: backForwardStack.size <= 1");
            }
        } catch (Throwable th) {
            TmcLogger.e("goback fail: " + th);
        }
    }

    public final boolean OooO0Oo() {
        return this.OooOOo || System.currentTimeMillis() - this.OooOOoo <= 200;
    }

    public final void OooO0o() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onDestory").addProperty("pageUrl", this.OooO0o0.getUrl()).build();
        Intrinsics.g(build, "create().addProperty(KEY…URL, webView.url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onDestory", build);
        }
        this.OooO0o = null;
        try {
            this.OooO0o0.setDownloadListener(null);
            this.OooOO0o = null;
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0OO, "unRegisterDownloadListener", th);
        }
    }

    public final void OooO0o0() {
        TmcLogger.d(this.OooO0OO, "loadingUrlStart => loadingUrl: " + this.OooO0oO);
        this.OooOO0.add(new OooO00o(this.OooO0oO, false, false, this.OooOO0O, false, false, null, null, 0L, false, 960));
    }

    public final void OooO0oO() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onPause").addProperty("pageUrl", this.OooO0o0.getUrl()).build();
        Intrinsics.g(build, "create().addProperty(KEY…URL, webView.url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onPause", build);
        }
    }

    public final void OooO0oo() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onRemove").addProperty("pageUrl", this.OooO0o0.getUrl()).build();
        Intrinsics.g(build, "create().addProperty(KEY…URL, webView.url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onRemove", build);
        }
        this.OooO0o = null;
    }

    public final void OooOO0() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onStop").addProperty("pageUrl", this.OooO0o0.getUrl()).build();
        Intrinsics.g(build, "create().addProperty(KEY…URL, webView.url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onStop", build);
        }
    }

    public final void OooOO0O() {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.e
            @Override // java.lang.Runnable
            public final void run() {
                OooO0o.OooO0OO(OooO0o.this);
            }
        });
    }

    public final void OooOO0o() {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "syncPageStack").addProperty("canGoBack", Boolean.valueOf(this.OooO0o0.canGoBack())).addProperty("canGoForward", Boolean.valueOf(this.OooO0o0.canGoForward())).build();
        Intrinsics.g(build, "create()\n            .ad…d())\n            .build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("syncPageStack", build);
        }
    }

    public final WeakReference<Activity> getActivity() {
        return this.OooO0O0;
    }

    public final String getPageUrl() {
        String url = this.OooO0o0.getUrl();
        return url == null ? "" : url;
    }

    public final String getViewId() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onConsoleMessage(String str) {
    }

    @Override // com.cloud.tmc.kernel.listener.OnKeyboardListener
    public void onKeyBoardChanged(int i, int i2) {
        int navBarHeight = this.OooOOO0 ? BarUtils.getNavBarHeight() : 0;
        TmcLogger.d(this.OooO0OO, "isNavBarVisible -> " + this.OooOOO0);
        try {
            TmcLogger.d(this.OooO0OO, "onKeyBoardChanged height -> " + getHeight());
            if (this.OooOOo0 == 0) {
                this.OooOOo0 = getHeight();
            }
            int i3 = i - navBarHeight;
            if (i3 < 100) {
                TmcLogger.d(this.OooO0OO, "hide keyboard ->" + i3);
                this.OooOOo = false;
                this.OooOOoo = System.currentTimeMillis();
                postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO00o(OooO0o.this);
                    }
                }, 150L);
            } else if (i3 != 0) {
                TmcLogger.d(this.OooO0OO, "show keyboard");
                this.OooOOo = true;
                setLayoutParams(new AbsoluteLayout.LayoutParams(getWidth(), this.OooOOo0 - i3, getTop(), getLeft()));
            } else {
                TmcLogger.d(this.OooO0OO, "hide keyboard else  ->" + i3);
                this.OooOOo = false;
                this.OooOOoo = System.currentTimeMillis();
                postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO0O0(OooO0o.this);
                    }
                }, 150L);
            }
            TmcLogger.d(this.OooO0OO, "newKeyboardHeight->" + i3 + ", keyboardHeight->" + i + ",screenHeight->" + i2);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0OO, th);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onPageFinished(WebView webView, String str) {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onPageFinished").addProperty("pageUrl", str).build();
        Intrinsics.g(build, "create().addProperty(KEY…EW_PAGE_URL, url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onPageFinished", build);
        }
        if (webView != null) {
            webView.loadUrl("javascript:function getFaviconUrl() {var favicon = '';var links = document.getElementsByTagName('link');for (var i = 0; i < links.length; i++) {if (links[i].rel.indexOf('icon') >= 0) {favicon = links[i].href;}}return favicon;}window.dltNativeWebview.receiveUrlIcon(getFaviconUrl(),'" + this.OooO00o + "');");
        }
        if (webView != null) {
            webView.loadUrl("javascript:var scrolled = false;window.addEventListener('scroll', function (e) {if (!scrolled) {window.dltNativeWebview.onScrollChanged('" + this.OooO00o + "');scrolled = true;}});var innerHeight = window.innerHeight;window.addEventListener('resize', () => {var newInnerHeight = window.innerHeight;if (innerHeight <= newInnerHeight) {scrolled = false;}});");
        }
        OooOO0o();
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onPageStarted(WebView webView, String str) {
        OooO00o(webView, str);
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onPageStarted").addProperty("pageUrl", str).build();
        Intrinsics.g(build, "create().addProperty(KEY…EW_PAGE_URL, url).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onPageStarted", build);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onProgressChanged(WebView webView, int i) {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onProgressChanged").addProperty("newProgress", Integer.valueOf(i)).build();
        Intrinsics.g(build, "create()\n               …ESS, newProgress).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onProgressChanged", build);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        boolean isRedirect;
        CharSequence description;
        Uri url;
        Boolean bool = null;
        JsonObjectUtils.Builder addProperty = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onReceivedError").addProperty("isForMainFrame", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null).addProperty("pageUrl", (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString()).addProperty("errorCode", webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null).addProperty("isForMainFrame", (webResourceError == null || (description = webResourceError.getDescription()) == null) ? null : description.toString());
        Intrinsics.g(addProperty, "create().addProperty(KEY….description?.toString())");
        if (Build.VERSION.SDK_INT >= 24) {
            if (webResourceRequest != null) {
                isRedirect = webResourceRequest.isRedirect();
                bool = Boolean.valueOf(isRedirect);
            }
            addProperty.addProperty("isRedirect", bool);
        }
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            JsonObject build = addProperty.build();
            Intrinsics.g(build, "builder.build()");
            oooO00o.OooO00o("onReceivedError", build);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str;
        boolean isRedirect;
        Uri url;
        Boolean bool = null;
        JsonObjectUtils.Builder addProperty = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onReceivedHttpError").addProperty("isForMainFrame", webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null).addProperty("pageUrl", (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString()).addProperty("errorCode", webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
        if (webResourceResponse == null || (str = webResourceResponse.getReasonPhrase()) == null) {
            str = null;
        }
        JsonObjectUtils.Builder addProperty2 = addProperty.addProperty("reasonPhrase", str);
        Intrinsics.g(addProperty2, "create()\n            .ad…reasonPhrase?.toString())");
        if (Build.VERSION.SDK_INT >= 24) {
            if (webResourceRequest != null) {
                isRedirect = webResourceRequest.isRedirect();
                bool = Boolean.valueOf(isRedirect);
            }
            addProperty2.addProperty("isRedirect", bool);
        }
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            JsonObject build = addProperty2.build();
            Intrinsics.g(build, "builder.build()");
            oooO00o.OooO00o("onReceivedHttpError", build);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onReceivedIcon(Bitmap bitmap) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onReceivedTitle(String str) {
        JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onReceivedTitle").addProperty("title", str).build();
        Intrinsics.g(build, "create().addProperty(KEY…IEW_TITLE, title).build()");
        com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
        if (oooO00o != null) {
            oooO00o.OooO00o("onReceivedTitle", build);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public /* synthetic */ Boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return com.cloud.tmc.kernel.render.d.a(this, webView, renderProcessGoneDetail);
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onRequestFocus() {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String url;
        Uri url2;
        String uri;
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String valueOf = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
            objectRef.element = valueOf;
            if (OooO00o(valueOf)) {
                final String contentTypeFromUrl = UrlUtils.getContentTypeFromUrl((String) objectRef.element);
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.nativewebview.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0o.OooO00o(objectRef, this, contentTypeFromUrl);
                    }
                });
                return Boolean.TRUE;
            }
            if (!StringsKt.W((String) objectRef.element, "http://", false, 2, (Object) null) && !StringsKt.W((String) objectRef.element, "https://", false, 2, (Object) null)) {
                TmcLogger.d(this.OooO0OO, "外跳事件，当前全部屏蔽状态,交由业务方处理");
                String str = (String) objectRef.element;
                Intrinsics.h(str, TmcConstants.KEY_PRE_DATA_SCHEME_URL);
                JsonObject build = JsonObjectUtils.create().addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, "onReceivedSchemeUrl").addProperty(TmcConstants.KEY_PRE_DATA_SCHEME_URL, str).build();
                Intrinsics.g(build, "create()\n            .ad…Url)\n            .build()");
                com.cloud.tmc.miniapp.nativewebview.listener.OooO00o oooO00o = this.OooO0o;
                if (oooO00o != null) {
                    oooO00o.OooO00o("onReceivedSchemeUrl", build);
                }
                return Boolean.TRUE;
            }
            OooO0O0(webView);
            if (webView != null && (url = webView.getUrl()) != null) {
                if (webResourceRequest != null && (url2 = webResourceRequest.getUrl()) != null && (uri = url2.toString()) != null) {
                    OooO00o(url, uri);
                    try {
                        ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).hideKeyboard(this);
                    } catch (Throwable th) {
                        TmcLogger.e(this.OooO0OO, th);
                    }
                    Boolean b = com.cloud.tmc.kernel.render.d.b(this, webView, webResourceRequest);
                    Intrinsics.g(b, "super.shouldOverrideUrlLoading(view, request)");
                    return b;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0OO, "shouldOverrideUrlLoading", th2);
            Boolean b2 = com.cloud.tmc.kernel.render.d.b(this, webView, webResourceRequest);
            Intrinsics.g(b2, "super.shouldOverrideUrlLoading(view, request)");
            return b2;
        }
    }
}
