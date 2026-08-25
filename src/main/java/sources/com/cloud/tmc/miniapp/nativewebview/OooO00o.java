package com.cloud.tmc.miniapp.nativewebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.cloud.tmc.kernel.render.WebviewPageEventCallback;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o extends WebChromeClient {
    public WebviewPageEventCallback OooO00o;

    public OooO00o(Context context, WebviewPageEventCallback webviewPageEventCallback) {
        Intrinsics.h(context, "context");
        this.OooO00o = webviewPageEventCallback;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        WebviewPageEventCallback webviewPageEventCallback = this.OooO00o;
        if (webviewPageEventCallback != null) {
            webviewPageEventCallback.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        WebviewPageEventCallback webviewPageEventCallback = this.OooO00o;
        if (webviewPageEventCallback != null) {
            webviewPageEventCallback.onReceivedIcon(bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        WebviewPageEventCallback webviewPageEventCallback = this.OooO00o;
        if (webviewPageEventCallback != null) {
            webviewPageEventCallback.onReceivedTitle(str);
        }
    }
}
