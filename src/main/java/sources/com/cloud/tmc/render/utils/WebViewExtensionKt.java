package com.cloud.tmc.render.utils;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.render.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u001a,\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¨\u0006\r"}, d2 = {"addJavaScriptInterfaceAD", "", "Landroid/webkit/WebView;", "adjsi", "Lcom/cloud/tmc/render/utils/ADJSI;", "addJavaScriptInterfaceFullScreen", "fullScreenJSI", "Lcom/cloud/tmc/render/utils/FullScreenJSI;", "executeJavascript", "jsScript", "", "onComplete", "Lkotlin/Function1;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class WebViewExtensionKt {
    public static final void addJavaScriptInterfaceAD(WebView webView, ADJSI adjsi) {
        Intrinsics.h(webView, "<this>");
        Intrinsics.h(adjsi, "adjsi");
        webView.addJavascriptInterface(adjsi, "ad");
    }

    public static final void addJavaScriptInterfaceFullScreen(WebView webView, FullScreenJSI fullScreenJSI) {
        Intrinsics.h(webView, "<this>");
        Intrinsics.h(fullScreenJSI, "fullScreenJSI");
        webView.addJavascriptInterface(fullScreenJSI, "dltFullScreen");
    }

    public static final void executeJavascript(final WebView webView, final String str, final Function1<? super String, Unit> function1) {
        Intrinsics.h(webView, "<this>");
        Intrinsics.h(str, "jsScript");
        if (str.length() == 0) {
            return;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.render.utils.WebViewExtensionKt$executeJavascript$runnable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m117invoke();
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m117invoke() {
                String str2 = str;
                if (!StringsKt.W(str2, "javascript", false, 2, (Object) null)) {
                    str2 = "javascript:" + str;
                }
                TraceLog.d(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "nativeSendToRender DefaultRenderBridge= " + str2);
                try {
                    WebView webView2 = webView;
                    final Function1<String, Unit> function12 = function1;
                    webView2.evaluateJavascript(str2, new ValueCallback<String>() { // from class: com.cloud.tmc.render.utils.WebViewExtensionKt$executeJavascript$runnable$1.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String p0) {
                            Function1<String, Unit> function13 = function12;
                            if (function13 != null) {
                                function13.invoke(p0);
                            }
                        }
                    });
                } catch (Exception e) {
                    TraceLog.e(TmcConstants.RENDER_TAG, "evaluateJavascript error = " + e, true);
                    webView.loadUrl(str2);
                }
            }
        };
        if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.tmc.render.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewExtensionKt.executeJavascript$lambda$0(function0);
                }
            });
        }
    }

    public static /* synthetic */ void executeJavascript$default(WebView webView, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        executeJavascript(webView, str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeJavascript$lambda$0(Function0 function0) {
        Intrinsics.h(function0, "$runnable");
        function0.invoke();
    }
}
