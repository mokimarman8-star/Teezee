package com.vungle.ads.internal.ui.view;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.vungle.ads.internal.omsdk.d;
import kotlinx.serialization.json.JsonObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {

    public interface a {
        boolean processCommand(String str, JsonObject jsonObject);
    }

    /* renamed from: com.vungle.ads.internal.ui.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0049b {
        void onReceivedError(String str, boolean z);

        void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess);

        boolean onWebRenderingProcessGone(WebView webView, Boolean bool);
    }

    void notifyPropertiesChange(boolean z);

    void setAdVisibility(boolean z);

    void setConsentStatus(boolean z, String str, String str2, String str3, String str4);

    void setErrorHandler(InterfaceC0049b interfaceC0049b);

    void setMraidDelegate(a aVar);

    void setWebViewObserver(d dVar);
}
