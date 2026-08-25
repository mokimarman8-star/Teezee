package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {

    /* renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a, reason: collision with other inner class name */
    private static class C0111a {
        private static final a a = new a();
    }

    public static a a() {
        return C0111a.a;
    }

    private void a(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(WebView webView) {
        a(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public void a(WebView webView, double d) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d)));
    }

    public void a(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void a(WebView webView, float f, float f2, float f3, float f4) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    public void a(WebView webView, String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, C.UTF8_NAME);
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        try {
            jSONObject2 = URLEncoder.encode(jSONObject2, C.UTF8_NAME);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject2));
    }

    public void b(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void b(WebView webView, float f, float f2, float f3, float f4) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    public void b(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }

    public void c(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void c(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }
}
