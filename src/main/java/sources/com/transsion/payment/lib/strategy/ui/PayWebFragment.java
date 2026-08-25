package com.transsion.payment.lib.strategy.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.u;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.d;
import com.transsion.payment.lib.strategy.ui.PayWebActivity;
import com.transsion.payment.lib.strategy.ui.PayWebFragment;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import eh.g;
import hx.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0005J\u0017\u0010'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020 2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010>\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010=R4\u0010F\u001a\"\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010B0Aj\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010B`C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010=R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/transsion/payment/lib/strategy/ui/PayWebFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lxm/b;", "Lyg/m;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "n0", "(Landroid/view/LayoutInflater;)Lxm/b;", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onDestroyView", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", BuildConfig.FLAVOR, "s0", "()Z", BuildConfig.FLAVOR, "getClassTag", "()Ljava/lang/String;", "initViewModel", "r0", "(Landroid/view/View;)V", "url", "from", "m0", "(Ljava/lang/String;Ljava/lang/String;)Z", "t0", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "strTitle", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "webLoading", "Landroid/webkit/WebView;", "c", "Landroid/webkit/WebView;", "mCustomWebView", "d", "mUrl", "e", "Z", "isError", "f", "isPayCancel", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "timer", "h", "isTriggerFinishPage", "Landroid/webkit/WebChromeClient;", "i", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebViewClient;", "j", "Landroid/webkit/WebViewClient;", "mWebViewClient", "k", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PayWebFragment extends BaseFragment<xm.b> implements m {

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String l = "https://api.paynicorn.com/sp-gateway/redirect/mock";

    /* renamed from: b, reason: from kotlin metadata */
    private ViewGroup webLoading;

    /* renamed from: c, reason: from kotlin metadata */
    private WebView mCustomWebView;

    /* renamed from: d, reason: from kotlin metadata */
    private String mUrl;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isError;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean isPayCancel;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isTriggerFinishPage;

    /* renamed from: a, reason: from kotlin metadata */
    private String strTitle = BuildConfig.FLAVOR;

    /* renamed from: g, reason: from kotlin metadata */
    private final HashMap timer = new HashMap();

    /* renamed from: i, reason: from kotlin metadata */
    private WebChromeClient mWebChromeClient = new b();

    /* renamed from: j, reason: from kotlin metadata */
    private WebViewClient mWebViewClient = new c();

    /* renamed from: com.transsion.payment.lib.strategy.ui.PayWebFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayWebFragment a() {
            return new PayWebFragment();
        }
    }

    public static final class b extends WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Intrinsics.h(webView, "view");
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            xm.b bVar;
            AppCompatTextView appCompatTextView;
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "title");
            super.onReceivedTitle(webView, str);
            PayWebFragment.this.strTitle = str;
            String str2 = PayWebFragment.this.strTitle;
            if (str2 == null || (bVar = (xm.b) PayWebFragment.this.getMViewBinding()) == null || (appCompatTextView = bVar.i) == null) {
                return;
            }
            appCompatTextView.setText(str2);
        }
    }

    public static final class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "url");
            super.onPageFinished(webView, str);
            if (PayWebFragment.this.isError) {
                return;
            }
            PayWebFragment.this.t0(str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            HashMap g;
            ProgressBar progressBar;
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "url");
            super.onPageStarted(webView, str, bitmap);
            if (PayWebFragment.this.m0(str, "onPageStarted()")) {
                return;
            }
            ViewGroup viewGroup = PayWebFragment.this.webLoading;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            xm.b bVar = (xm.b) PayWebFragment.this.getMViewBinding();
            if (bVar != null && (progressBar = bVar.f) != null) {
                progressBar.setVisibility(8);
            }
            if (PayWebFragment.this.timer.get(str) == null) {
                PayWebFragment.this.timer.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            qi.b logViewConfig = PayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                g.put("url", str);
            }
            PayWebFragment.this.isError = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            Intrinsics.h(webResourceError, MediaItem.MUSIC_FLOAT_STATE_ERROR);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            d.a.b(PayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedError() --> url = " + webResourceRequest.getUrl() + " --> error = " + webResourceError);
            PayWebFragment.this.isError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            Intrinsics.h(webResourceResponse, "errorResponse");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            d.a.b(PayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedHttpError() --> url = " + webResourceRequest.getUrl() + " --> errorResponse = " + webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            PayWebFragment payWebFragment = PayWebFragment.this;
            String uri = webResourceRequest.getUrl().toString();
            Intrinsics.g(uri, "toString(...)");
            payWebFragment.m0(uri, "shouldInterceptRequest()");
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            Context context;
            if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (uri = url.toString()) != null) {
                PayWebFragment payWebFragment = PayWebFragment.this;
                if (StringsKt.W(uri, "tel:", false, 2, (Object) null)) {
                    d.a.b(payWebFragment.getClassTag() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> 使用Intent来处理拨号请求 --> url = " + uri);
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(uri));
                    if (webView != null && (context = webView.getContext()) != null) {
                        context.startActivity(intent);
                    }
                    return true;
                }
                if (payWebFragment.m0(uri, "shouldOverrideUrlLoading()")) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = PayWebFragment.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void initViewModel() {
        String str;
        xm.b bVar;
        AppCompatTextView appCompatTextView;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(PayWebActivity.INSTANCE.a())) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mUrl = str;
        String[] a = u.a(str, "\\/");
        if (a != null) {
            if (a.length == 0) {
                return;
            }
            String str2 = a[a.length - 1];
            this.strTitle = str2;
            if (str2 == null || (bVar = (xm.b) getMViewBinding()) == null || (appCompatTextView = bVar.i) == null) {
                return;
            }
            appCompatTextView.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m0(String url, String from) {
        if (this.isTriggerFinishPage) {
            return true;
        }
        if (!StringsKt.c0(url, l, false, 2, (Object) null)) {
            if (!StringsKt.c0(url, "https://cashier-serverweb.paynicorn.com/api/cancelPay", false, 2, (Object) null)) {
                return false;
            }
            this.isTriggerFinishPage = true;
            d.a.b(getClassTag() + " --> mWebViewClient --> checkUrl() --> from = " + from + " --> url = " + url);
            this.isPayCancel = true;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return true;
            }
            activity.finish();
            return true;
        }
        this.isTriggerFinishPage = true;
        d.a.b(getClassTag() + " --> mWebViewClient --> checkUrl() --> from = " + from + " --> url = " + url);
        e eVar = new e(0);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = e.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, eVar, 0L);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(PayWebFragment payWebFragment, View view) {
        WebView webView = payWebFragment.mCustomWebView;
        if (webView != null) {
            webView.reload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(PayWebFragment payWebFragment, View view) {
        FragmentActivity activity = payWebFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(PayWebFragment payWebFragment, View view) {
        FragmentActivity activity = payWebFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void r0(View view) {
        ProgressBar progressBar;
        HashMap g;
        HashMap g2;
        FrameLayout frameLayout;
        Context context = view.getContext();
        WebView webView = new WebView(context);
        xm.b bVar = (xm.b) getMViewBinding();
        if (bVar != null && (frameLayout = bVar.b) != null) {
            frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        l lVar = l.a;
        Intrinsics.e(context);
        settings.setCacheMode(lVar.j(context) ? -1 : 1);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setDomStorageEnabled(true);
        settings.setNeedInitialFocus(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDefaultFontSize(16);
        settings.setMinimumFontSize(12);
        settings.setGeolocationEnabled(true);
        webView.setWebChromeClient(this.mWebChromeClient);
        webView.setWebViewClient(this.mWebViewClient);
        webView.setOverScrollMode(2);
        this.mCustomWebView = webView;
        String str = this.mUrl;
        if (str != null) {
            this.timer.put(str, Long.valueOf(System.currentTimeMillis()));
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g2 = logViewConfig.g()) != null) {
                g2.put("url", this.mUrl);
            }
            qi.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
                g.put("loading", MsgStyle.CUSTOM_LEFT_PIC);
            }
            xm.b bVar2 = (xm.b) getMViewBinding();
            if (bVar2 != null && (progressBar = bVar2.f) != null) {
                progressBar.setVisibility(0);
            }
            d.a.a(getClassTag() + " --> initWeb() --> WebView初始化完成 --> mCustomWebView?.loadUrl(it) 开始加载收银台 -- url = " + this.mUrl);
            WebView webView2 = this.mCustomWebView;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String url) {
        HashMap g;
        HashMap g2;
        HashMap g3;
        HashMap g4;
        if (this.timer.get(url) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l2 = (Long) this.timer.get(url);
            long longValue = currentTimeMillis - (l2 != null ? l2.longValue() : currentTimeMillis);
            d.a.a(getClassTag() + " --> pageFinish() --> mUrl = " + this.mUrl + " -- used time = " + longValue);
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g4 = logViewConfig.g()) != null) {
                g4.put("load_h5_time", String.valueOf(longValue));
            }
            if (this.timer.get("on_create") != null) {
                Object obj = this.timer.get("on_create");
                Intrinsics.e(obj);
                long longValue2 = currentTimeMillis - ((Number) obj).longValue();
                qi.b logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (g3 = logViewConfig2.g()) != null) {
                    g3.put("load_time", String.valueOf(longValue2));
                }
                this.timer.put("on_create", null);
            }
            qi.b logViewConfig3 = getLogViewConfig();
            if (logViewConfig3 != null && (g2 = logViewConfig3.g()) != null) {
                g2.put("load_h5_time", String.valueOf(longValue));
            }
        }
        qi.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
            PayWebActivity.Companion companion = PayWebActivity.INSTANCE;
            String b2 = companion.b();
            Bundle arguments = getArguments();
            g.put(b2, arguments != null ? arguments.getString(companion.b()) : null);
        }
        qi.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null) {
            logViewConfig5.k(true);
        }
    }

    public void initView(View view, Bundle savedInstanceState) {
        g gVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.h(view, "view");
        xm.b bVar = (xm.b) getMViewBinding();
        if (bVar != null) {
            ConstraintLayout constraintLayout = bVar.h;
            Intrinsics.g(constraintLayout, "toolBar");
            uf.c.k(constraintLayout);
        }
        this.timer.put("on_create", Long.valueOf(System.currentTimeMillis()));
        xm.b bVar2 = (xm.b) getMViewBinding();
        if (bVar2 != null && (appCompatImageView3 = bVar2.e) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: ym.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.o0(PayWebFragment.this, view2);
                }
            });
        }
        xm.b bVar3 = (xm.b) getMViewBinding();
        if (bVar3 != null && (appCompatImageView2 = bVar3.c) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: ym.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.p0(PayWebFragment.this, view2);
                }
            });
        }
        xm.b bVar4 = (xm.b) getMViewBinding();
        if (bVar4 != null && (appCompatImageView = bVar4.d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ym.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.q0(PayWebFragment.this, view2);
                }
            });
        }
        xm.b bVar5 = (xm.b) getMViewBinding();
        this.webLoading = (bVar5 == null || (gVar = bVar5.j) == null) ? null : gVar.b;
        initViewModel();
        r0(view);
        l.a.l(this);
    }

    public void lazyLoadData() {
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public xm.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        xm.b c2 = xm.b.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("snifferh5page", false, 2, null);
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        WebView webView;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        qi.b logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || !logViewConfig.i()) && this.isError && (webView = this.mCustomWebView) != null) {
            webView.reload();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d.a.a(getClassTag() + " --> onCreate() --> 聚合支付收银台容器初始化");
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        l.a.m(this);
        if (this.isPayCancel) {
            e eVar = new e(-1);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = e.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, eVar, 0L);
            return;
        }
        e eVar2 = new e(0);
        FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.postEvent(name2, eVar2, 0L);
    }

    public void onDestroyView() {
        WebView webView = this.mCustomWebView;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }

    public void onDisconnected() {
    }

    public final boolean s0() {
        WebView webView = this.mCustomWebView;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        WebView webView2 = this.mCustomWebView;
        if (webView2 == null) {
            return true;
        }
        webView2.goBack();
        return true;
    }
}
