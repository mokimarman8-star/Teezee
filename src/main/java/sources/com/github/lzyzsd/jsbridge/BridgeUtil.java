package com.github.lzyzsd.jsbridge;

import android.content.Context;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BridgeUtil {
    static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    static final String EMPTY_STR = "";
    public static final String JAVASCRIPT_STR = "javascript:%s";
    public static final String JAVA_SCRIPT = "WebViewJavascriptBridge.js";
    static final String JS_FETCH_QUEUE_FROM_JAVA = "javascript:WebViewJavascriptBridge._fetchQueue();";
    static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:WebViewJavascriptBridge._handleMessageFromNative(%s);";
    public static final String JS_NAVIGATOR_HOST = "javascript:window.navigator.hostInfo = { platform: 'Android',version: '%s' }";
    static final String SPLIT_MARK = "/";
    static final String UNDERLINE_STR = "_";
    static final String YY_FETCH_QUEUE = "yy://return/_fetchQueue/";
    static final String YY_OVERRIDE_SCHEMA = "yy://";
    static final String YY_RETURN_DATA = "yy://return/";

    /* JADX WARN: Removed duplicated region for block: B:41:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String assetFile2Str(Context context, String str) {
        InputStream inputStream;
        String readLine;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    do {
                        readLine = bufferedReader.readLine();
                        if (readLine != null && !readLine.matches("^\\s*\\/\\/.*")) {
                            sb.append(readLine);
                        }
                    } while (readLine != null);
                    bufferedReader.close();
                    inputStream.close();
                    String sb2 = sb.toString();
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return sb2;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public static String getDataFromReturnUrl(String str) {
        return EMPTY_STR;
    }

    public static String getFunctionFromReturnUrl(String str) {
        return EMPTY_STR;
    }

    public static String parseFunctionName(String str) {
        return EMPTY_STR;
    }

    public static void webViewLoadJs(WebView webView, String str) {
        webView.loadUrl("javascript:" + (("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void webViewLoadLocalJs(WebView webView, String str) {
        webView.loadUrl("javascript:" + assetFile2Str(webView.getContext(), str));
    }
}
