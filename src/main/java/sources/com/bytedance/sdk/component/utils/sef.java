package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef {
    private static final Sj Sj = new sP();

    private static class Sj {
        private Sj() {
        }

        public void Sj(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(TTAdConstant.CONVERSION_LINK_LANDING_DIRECT_AND_ENDCARD)
    private static class sP extends Sj {
        private sP() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.sef.Sj
        public void Sj(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th) {
                    boolean z = th instanceof IllegalStateException;
                }
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void Sj(WebView webView, String str) {
        Sj.Sj(webView, str);
    }
}
