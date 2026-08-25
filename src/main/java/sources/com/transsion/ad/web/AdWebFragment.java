package com.transsion.ad.web;

import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.blankj.utilcode.util.o;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.hisavana.mediation.bridge.MediationJsBridge;
import com.transsion.ad.web.AdWebFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.BaseLibWebFragment;
import com.transsion.lib_web.zip.loader.c;
import com.transsion.lib_web.zip.loader.d;
import com.transsion.player.mediasession.MediaItem;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qi.b;
import qi.h;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J)\u0010)\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J5\u0010-\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0016¢\u0006\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010?\u001a\u00020:8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/transsion/ad/web/AdWebFragment;", "Lcom/transsion/lib_web/BaseLibWebFragment;", "<init>", "()V", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "S0", "(Ljava/lang/String;)V", "Lcom/github/lzyzsd/jsbridge/BridgeWebView;", "bridgeWebView", "b0", "(Lcom/github/lzyzsd/jsbridge/BridgeWebView;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "onResume", "onPause", "Landroid/webkit/WebView;", "view", "E0", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "Landroid/graphics/Bitmap;", "favicon", "F0", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceError;", MediaItem.MUSIC_FLOAT_STATE_ERROR, "H0", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", BuildConfig.FLAVOR, "failingUrl", "G0", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "Lcom/transsion/lib_web/zip/loader/c;", "e0", "()Ljava/util/List;", "o", "Z", "isError", "Lcom/hisavana/mediation/bridge/MediationJsBridge;", "p", "Lcom/hisavana/mediation/bridge/MediationJsBridge;", "mediationJsBridge", "Lqi/b;", "q", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdWebFragment extends BaseLibWebFragment {

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isError;

    /* renamed from: p, reason: from kotlin metadata */
    private MediationJsBridge mediationJsBridge;

    /* renamed from: q, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: fi.a
        public final Object invoke() {
            b R0;
            R0 = AdWebFragment.R0();
            return R0;
        }
    });

    public static final class a implements c {
        final /* synthetic */ MediationJsBridge b;

        a(MediationJsBridge mediationJsBridge) {
            this.b = mediationJsBridge;
        }

        @Override // com.transsion.lib_web.zip.loader.c
        public WebResourceResponse a(WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            WebResourceResponse shouldInterceptRequest;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null || (shouldInterceptRequest = this.b.shouldInterceptRequest(uri)) == null) {
                return null;
            }
            return shouldInterceptRequest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b R0() {
        return new b("ad_web_page", false, 2, null);
    }

    private final void S0(String url) {
        getLogViewConfig().k(getLoadInfoStats().getIsLoadSuccess());
        getLogViewConfig().g().put("load_time", String.valueOf(getLoadInfoStats().getLoad_time()));
        getLogViewConfig().g().put("error_code", String.valueOf(getLoadInfoStats().getError_code()));
        getLogViewConfig().g().put("error_msg", getLoadInfoStats().getError_msg());
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void E0(WebView view, String url) {
        Intrinsics.h(view, "view");
        Intrinsics.h(url, "url");
        super.E0(view, url);
        S0(url);
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void F0(WebView view, String url, Bitmap favicon) {
        Intrinsics.h(view, "view");
        Intrinsics.h(url, "url");
        super.F0(view, url, favicon);
        getLogViewConfig().g().put("url", url);
        this.isError = false;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void G0(WebView view, int request, String error, String failingUrl) {
        super.G0(view, request, error, failingUrl);
        this.isError = true;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void H0(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.h(request, "request");
        Intrinsics.h(error, MediaItem.MUSIC_FLOAT_STATE_ERROR);
        super.H0(view, request, error);
        this.isError = true;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void b0(BridgeWebView bridgeWebView) {
        Intrinsics.h(bridgeWebView, "bridgeWebView");
        MediationJsBridge mediationJsBridge = new MediationJsBridge(bridgeWebView);
        this.mediationJsBridge = mediationJsBridge;
        bridgeWebView.addJavascriptInterface(mediationJsBridge, "HisavanaAdJsBridge");
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public List e0() {
        List e;
        MediationJsBridge mediationJsBridge = this.mediationJsBridge;
        return (mediationJsBridge == null || (e = CollectionsKt.e(new a(mediationJsBridge))) == null) ? CollectionsKt.l() : e;
    }

    public final b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        if (getLogViewConfig().i() || !this.isError) {
            return;
        }
        k0().reload();
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLogViewConfig().g().put("original_url", j0());
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        HashMap g = getLogViewConfig().g();
        d mWebViewLoaderManager = getMWebViewLoaderManager();
        g.put("is_from_cache", String.valueOf(mWebViewLoaderManager != null ? Boolean.valueOf(mWebViewLoaderManager.b()) : null));
        getLogViewConfig().g().put("dom", o.j(getLoadInfoStats().getDom_performance()));
        h.a.x(getLogViewConfig());
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void onResume() {
        super.onResume();
        getLogViewConfig().o(SystemClock.elapsedRealtime());
    }
}
