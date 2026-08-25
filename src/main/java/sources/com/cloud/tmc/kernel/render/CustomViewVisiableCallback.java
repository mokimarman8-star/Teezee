package com.cloud.tmc.kernel.render;

import android.view.View;
import android.webkit.WebChromeClient;
import com.cloud.tmc.kernel.BuildConfig;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/cloud/tmc/kernel/render/CustomViewVisiableCallback;", "", "onHideCustomView", "", "onShowCustomView", "view", "Landroid/view/View;", RenderCallContext.TYPE_CALLBACK, "Landroid/webkit/WebChromeClient$CustomViewCallback;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface CustomViewVisiableCallback {
    void onHideCustomView();

    void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback);
}
