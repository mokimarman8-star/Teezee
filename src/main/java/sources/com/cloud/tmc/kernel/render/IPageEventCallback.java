package com.cloud.tmc.kernel.render;

import android.graphics.Bitmap;
import android.webkit.WebView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IPageEventCallback {
    void onProgressChanged(WebView webView, int i);

    void onReceivedIcon(Bitmap bitmap);

    void onReceivedTitle(String str);

    void onRequestFocus();
}
