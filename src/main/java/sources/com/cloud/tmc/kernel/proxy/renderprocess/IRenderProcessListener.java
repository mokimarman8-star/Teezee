package com.cloud.tmc.kernel.proxy.renderprocess;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IRenderProcessListener {
    Boolean isRenderProcessGone();

    void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);
}
