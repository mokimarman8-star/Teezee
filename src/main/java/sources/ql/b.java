package ql;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.blankj.utilcode.util.o;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qi.h;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    public static final class a extends WebViewClient {
        final /* synthetic */ BridgeWebView a;

        a(BridgeWebView bridgeWebView) {
            this.a = bridgeWebView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b.a.e(this.a, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String str;
            Uri url;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str = url.toString()) == null) {
                str = BuildConfig.FLAVOR;
            }
            if (StringsKt.W(str, "http", false, 2, (Object) null) || StringsKt.W(str, "https", false, 2, (Object) null) || StringsKt.W(str, "file", false, 2, (Object) null)) {
                return false;
            }
            try {
                b.a.e(this.a, webView != null ? webView.getUrl() : null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "url");
            if (StringsKt.W(str, "http", false, 2, (Object) null) || StringsKt.W(str, "https", false, 2, (Object) null) || StringsKt.W(str, "file", false, 2, (Object) null)) {
                return false;
            }
            try {
                b.a.e(this.a, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    private b() {
    }

    private final void c(BridgeWebView bridgeWebView) {
        WebSettings settings = bridgeWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        l lVar = l.a;
        Context context = bridgeWebView.getContext();
        Intrinsics.g(context, "getContext(...)");
        settings.setCacheMode(lVar.j(context) ? -1 : 1);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setDomStorageEnabled(true);
        settings.setNeedInitialFocus(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDefaultFontSize(16);
        settings.setMinimumFontSize(12);
        settings.setGeolocationEnabled(true);
    }

    private final void d(BridgeWebView bridgeWebView) {
        bridgeWebView.setGson(o.f());
        bridgeWebView.setLayerType(2, null);
        bridgeWebView.setOverScrollMode(2);
        bridgeWebView.setWebViewClient(new a(bridgeWebView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(BridgeWebView bridgeWebView, String str) {
        Object tag = bridgeWebView.getTag(-1001);
        if (Intrinsics.c(tag instanceof Boolean ? (Boolean) tag : null, Boolean.TRUE)) {
            bridgeWebView.setTag(-1001, Boolean.FALSE);
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            g(str, "finish");
        }
    }

    public final BridgeWebView b(Context context) {
        Intrinsics.h(context, "context");
        BridgeWebView bridgeWebView = new BridgeWebView(context);
        d(bridgeWebView);
        c(bridgeWebView);
        return bridgeWebView;
    }

    public final void f(String str) {
        Intrinsics.h(str, "msg");
    }

    public final void g(String str, String str2) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "action");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", str);
        linkedHashMap.put("action", str2);
        h.a.v("preload", linkedHashMap, "web");
        f("上报 --> action = " + str2 + " --> url = " + str);
    }
}
