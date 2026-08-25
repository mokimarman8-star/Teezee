package com.github.lzyzsd.jsbridge;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface WebViewJavascriptBridge {
    void sendToWeb(String str);

    void sendToWeb(String str, OnBridgeCallback onBridgeCallback);

    void sendToWeb(String str, Object... objArr);
}
