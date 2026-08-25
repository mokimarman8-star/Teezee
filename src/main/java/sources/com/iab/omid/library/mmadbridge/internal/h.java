package com.iab.omid.library.mmadbridge.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class h {
    private static h a = new h();

    class a implements Runnable {
        final /* synthetic */ WebView a;
        final /* synthetic */ String b;

        a(WebView webView, String str) {
            this.a = webView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.p(this.a, this.b);
        }
    }

    private h() {
    }

    public static final h a() {
        return a;
    }

    public void b(WebView webView, String str) {
        h(webView, "finishSession", str);
    }

    public void c(WebView webView, String str, float f) {
        h(webView, "setDeviceVolume", Float.valueOf(f), str);
    }

    public void d(WebView webView, String str, String str2) {
        h(webView, "setDeviceLockState", str2);
    }

    public void e(WebView webView, String str, String str2, JSONObject jSONObject) {
        h(webView, "publishMediaEvent", str2, jSONObject, str);
    }

    public void f(WebView webView, String str, JSONObject jSONObject) {
        h(webView, "init", jSONObject, str);
    }

    public void g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    void h(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            re.d.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("if(window.omidBridge!==undefined){omidBridge.");
        sb2.append(str);
        sb2.append("(");
        k(sb2, objArr);
        sb2.append(")}");
        i(webView, sb2);
    }

    void i(WebView webView, StringBuilder sb2) {
        String sb3 = sb2.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            p(webView, sb3);
        } else {
            handler.post(new a(webView, sb3));
        }
    }

    public void j(WebView webView, JSONObject jSONObject) {
        h(webView, "setLastActivity", jSONObject);
    }

    void k(StringBuilder sb2, Object[] objArr) {
        String obj;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                obj = "null";
            } else {
                if (obj2 instanceof String) {
                    obj = obj2.toString();
                    if (!obj.startsWith("{")) {
                        sb2.append('\"');
                        sb2.append(obj);
                        sb2.append('\"');
                    }
                } else {
                    sb2.append(obj2);
                }
                sb2.append(",");
            }
            sb2.append(obj);
            sb2.append(",");
        }
        sb2.setLength(sb2.length() - 1);
    }

    public void l(WebView webView, String str) {
        h(webView, "publishImpressionEvent", str);
    }

    public void m(WebView webView, String str, String str2) {
        h(webView, "setNativeViewHierarchy", str2, str);
    }

    public void n(WebView webView, String str, JSONObject jSONObject) {
        h(webView, "publishLoadedEvent", jSONObject, str);
    }

    public void o(WebView webView, String str, String str2) {
        h(webView, "setState", str2, str);
    }

    public boolean p(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: " + str);
            return true;
        }
    }

    public void q(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        p(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }
}
