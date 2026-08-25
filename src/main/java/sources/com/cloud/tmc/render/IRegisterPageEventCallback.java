package com.cloud.tmc.render;

import android.webkit.WebView;
import com.cloud.tmc.kernel.render.IPageEventCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/cloud/tmc/render/IRegisterPageEventCallback;", "", "registerPageEventCallback", "", "webview", "Landroid/webkit/WebView;", "pageEventCallback", "Lcom/cloud/tmc/kernel/render/IPageEventCallback;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IRegisterPageEventCallback {
    void registerPageEventCallback(WebView webview, IPageEventCallback pageEventCallback);
}
