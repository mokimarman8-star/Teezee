package com.cloud.hisavana.sdk.common.util;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.b4;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e {
    public static final e a = new e();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();
    private static final Handler c = new Handler(Looper.getMainLooper());

    private e() {
    }

    private final void c(String str, long j) {
        try {
            ConcurrentHashMap concurrentHashMap = b;
            WebView webView = (WebView) concurrentHashMap.get(Long.valueOf(j));
            if (webView == null) {
                b4.b().d("AdxTrackWebviewManager", "create trackwebview now, key->" + j);
                webView = new WebView(com.cloud.sdk.commonutil.util.e.a());
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                concurrentHashMap.put(Long.valueOf(j), webView);
            }
            b4.b().d("AdxTrackWebviewManager", "adx track, load url: " + str);
            webView.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WebView webView, long j) {
        a.f(webView, j);
    }

    private final void f(WebView webView, long j) {
        try {
            b4.b().d("AdxTrackWebviewManager", "destroy trackwebview now, key->" + j);
            if (webView != null) {
                webView.clearHistory();
                webView.clearCache(true);
                webView.loadUrl("about:blank");
                webView.freeMemory();
                webView.destroy();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str, long j) {
        Intrinsics.h(str, "$url");
        a.c(str, j);
    }

    public final void d(final long j) {
        try {
            final WebView webView = (WebView) b.remove(Long.valueOf(j));
            if (webView != null) {
                b4.b().d("AdxTrackWebviewManager", "delay 10 seconds to destroy the trackWebview,key: ->" + j);
                c.postDelayed(new Runnable() { // from class: com.cloud.hisavana.sdk.common.util.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.e(webView, j);
                    }
                }, 10000L);
            }
        } catch (Throwable unused) {
        }
    }

    public final void g(final long j, final String str) {
        Intrinsics.h(str, TmcStartParams.KEY_URL);
        c.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.util.d
            @Override // java.lang.Runnable
            public final void run() {
                e.h(str, j);
            }
        });
    }
}
