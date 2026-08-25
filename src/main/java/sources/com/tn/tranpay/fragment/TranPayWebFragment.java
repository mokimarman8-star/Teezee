package com.tn.tranpay.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.u;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.event.AppScopeVMlProvider;
import com.tn.tranpay.event.FlowEventBus;
import com.tn.tranpay.helper.PayUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001XB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0018\u0010>\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00101R\u0016\u0010A\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010D\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010@R4\u0010J\u001a\"\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010F0Ej\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010F`G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010@R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010#¨\u0006Y"}, d2 = {"Lcom/tn/tranpay/fragment/TranPayWebFragment;", "Lcom/tn/tranpay/fragment/BaseFragment;", "Lrg/c;", "Lcom/blankj/utilcode/util/NetworkUtils$a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "o0", "(Landroid/view/LayoutInflater;)Lrg/c;", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onDestroyView", "onDestroy", "Lcom/tn/tranpay/report/c;", "V", "()Lcom/tn/tranpay/report/c;", "onDisconnected", "Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;", "networkType", "k", "(Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;)V", "", "u0", "()Z", "", "getClassTag", "()Ljava/lang/String;", "initViewModel", "t0", "(Landroid/view/View;)V", "url", "from", "l0", "(Ljava/lang/String;Ljava/lang/String;)Z", "isBackPressed", "p0", "(Z)V", "v0", "(Ljava/lang/String;)V", "d", "Ljava/lang/String;", "strTitle", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "webLoading", "Landroid/webkit/WebView;", "f", "Landroid/webkit/WebView;", "mCustomWebView", "g", "mUrl", "h", "mCpFontPage", "i", "Z", "mShouldOpenCpFrontPage", "j", "isError", "isPayCancel", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "l", "Ljava/util/HashMap;", "timer", "m", "isTriggerFinishPage", "Landroid/webkit/WebChromeClient;", "n", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebViewClient;", "o", "Landroid/webkit/WebViewClient;", "mWebViewClient", "n0", "resultPageUrl", "p", "a", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPayWebFragment extends BaseFragment<rg.c> implements NetworkUtils.a {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String q;
    private static final String r;

    /* renamed from: e, reason: from kotlin metadata */
    private ViewGroup webLoading;

    /* renamed from: f, reason: from kotlin metadata */
    private WebView mCustomWebView;

    /* renamed from: g, reason: from kotlin metadata */
    private String mUrl;

    /* renamed from: h, reason: from kotlin metadata */
    private String mCpFontPage;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean isError;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isPayCancel;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isTriggerFinishPage;

    /* renamed from: d, reason: from kotlin metadata */
    private String strTitle = "";

    /* renamed from: i, reason: from kotlin metadata */
    private boolean mShouldOpenCpFrontPage = true;

    /* renamed from: l, reason: from kotlin metadata */
    private final HashMap timer = new HashMap();

    /* renamed from: n, reason: from kotlin metadata */
    private WebChromeClient mWebChromeClient = new b();

    /* renamed from: o, reason: from kotlin metadata */
    private WebViewClient mWebViewClient = new c();

    /* renamed from: com.tn.tranpay.fragment.TranPayWebFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranPayWebFragment a() {
            return new TranPayWebFragment();
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
            rg.c mViewBinding;
            AppCompatTextView appCompatTextView;
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "title");
            super.onReceivedTitle(webView, str);
            TranPayWebFragment.this.strTitle = str;
            String str2 = TranPayWebFragment.this.strTitle;
            if (str2 == null || (mViewBinding = TranPayWebFragment.this.getMViewBinding()) == null || (appCompatTextView = mViewBinding.i) == null) {
                return;
            }
            appCompatTextView.setText(str2);
        }
    }

    public static final class c extends WebViewClient {
        c() {
        }

        private final boolean a(Uri uri) {
            WebView webView;
            try {
                Intent parseUri = Intent.parseUri(uri.toString(), 1);
                if (parseUri != null) {
                    FragmentActivity activity = TranPayWebFragment.this.getActivity();
                    PackageManager packageManager = activity != null ? activity.getPackageManager() : null;
                    if ((packageManager != null ? packageManager.resolveActivity(parseUri, 0) : null) != null) {
                        FragmentActivity activity2 = TranPayWebFragment.this.getActivity();
                        if (activity2 != null) {
                            activity2.startActivity(parseUri);
                        }
                        return true;
                    }
                    String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (stringExtra != null && StringsKt.W(stringExtra, "market://", false, 2, (Object) null)) {
                            String str = parseUri.getPackage();
                            if (str != null) {
                                return PayUtils.r(PayUtils.a, str, false, 2, null);
                            }
                        } else if (stringExtra != null && (webView = TranPayWebFragment.this.mCustomWebView) != null) {
                            webView.loadUrl(stringExtra);
                        }
                        return true;
                    }
                }
            } catch (Exception e) {
                lh.a.e(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> handleIntentScheme() --> 处理失败: " + e, null, 2, null);
            }
            return false;
        }

        private final boolean b(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    if (Intrinsics.c("intent", parse.getScheme())) {
                        return a(parse);
                    }
                    if (!CollectionsKt.b0(CollectionsKt.o(new String[]{"http", "https"}), parse.getScheme())) {
                        PayUtils payUtils = PayUtils.a;
                        String uri = parse.toString();
                        Intrinsics.g(uri, "uri.toString()");
                        if (!payUtils.s(uri, true)) {
                            lh.a.k(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> shouldOverrideUrlLoadingInner() --> 无法处理自定义协议: " + parse.getScheme() + "，已阻止 WebView 加载", null, 2, null);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                lh.a.e(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> shouldOverrideUrlLoadingInner() --> 解析失败: " + e, null, 2, null);
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            HashMap g;
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "url");
            super.onPageFinished(webView, str);
            lh.a aVar = lh.a.a;
            lh.a.c(aVar, TranPayWebFragment.this.getClassTag() + " --> mWebViewClient --> onPageFinished() --> url = " + str, null, 2, null);
            if (!TranPayWebFragment.this.isError) {
                TranPayWebFragment.this.v0(str);
                return;
            }
            com.tn.tranpay.report.c logViewConfig = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.j(false);
            }
            if (TranPayWebFragment.this.timer.get(str) == null) {
                lh.a.e(aVar, TranPayWebFragment.this.getClassTag() + " --> mWebViewClient --> onPageFinished() --> 未记录请求加载的耗时 --> url = " + str, null, 2, null);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = TranPayWebFragment.this.timer.get(str);
            Intrinsics.e(obj);
            long longValue = currentTimeMillis - ((Number) obj).longValue();
            com.tn.tranpay.report.c logViewConfig2 = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig2 == null || (g = logViewConfig2.g()) == null) {
                return;
            }
            g.put("duration", String.valueOf(longValue));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            HashMap g;
            Intrinsics.h(webView, "view");
            Intrinsics.h(str, "url");
            super.onPageStarted(webView, str, bitmap);
            if (TranPayWebFragment.this.l0(str, "onPageStarted()")) {
                return;
            }
            ViewGroup viewGroup = TranPayWebFragment.this.webLoading;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            rg.c mViewBinding = TranPayWebFragment.this.getMViewBinding();
            ProgressBar progressBar = mViewBinding != null ? mViewBinding.f : null;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (TranPayWebFragment.this.timer.get(str) == null) {
                TranPayWebFragment.this.timer.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            com.tn.tranpay.report.c logViewConfig = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                g.put("url", str);
            }
            TranPayWebFragment.this.isError = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            Intrinsics.h(webResourceError, SendToNativeCallback.KEY_CODE);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            lh.a.e(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedError() --> url = " + webResourceRequest.getUrl() + " --> error = " + webResourceError, null, 2, null);
            TranPayWebFragment.this.isError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            Intrinsics.h(webResourceResponse, "errorResponse");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            lh.a.e(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedHttpError() --> url = " + webResourceRequest.getUrl() + " --> errorResponse = " + webResourceResponse, null, 2, null);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Intrinsics.h(webView, "view");
            Intrinsics.h(webResourceRequest, "request");
            TranPayWebFragment tranPayWebFragment = TranPayWebFragment.this;
            String uri = webResourceRequest.getUrl().toString();
            Intrinsics.g(uri, "request.url.toString()");
            tranPayWebFragment.l0(uri, "shouldInterceptRequest()");
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null) {
                return false;
            }
            lh.a.c(lh.a.a, TranPayWebFragment.this.getClassTag() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> url = " + uri, null, 2, null);
            if (b(webView, uri)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    static {
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
        q = tranPayConfiguration.u() ? "https://cashier-serverweb.paynicorn.com/result" : "https://cashier-serverweb-test.paynicorn.com/result";
        r = tranPayConfiguration.u() ? "https://cashier-serverweb.paynicorn.com/api/cancelPay" : "https://cashier-serverweb-test.paynicorn.com/api/cancelPay";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TranPayWebFragment.class.getSimpleName();
        Intrinsics.g(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final void initViewModel() {
        String str;
        rg.c mViewBinding;
        AppCompatTextView appCompatTextView;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("url")) == null) {
            str = "";
        }
        this.mUrl = str;
        Bundle arguments2 = getArguments();
        this.mCpFontPage = arguments2 != null ? arguments2.getString("cpFrontPage") : null;
        Bundle arguments3 = getArguments();
        this.mShouldOpenCpFrontPage = arguments3 != null ? arguments3.getBoolean("shouldOpenCpFrontPage") : true;
        String[] a = u.a(this.mUrl, "\\/");
        if (a != null) {
            if (a.length == 0) {
                return;
            }
            String str2 = a[a.length - 1];
            this.strTitle = str2;
            if (str2 == null || (mViewBinding = getMViewBinding()) == null || (appCompatTextView = mViewBinding.i) == null) {
                return;
            }
            appCompatTextView.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l0(String url, String from) {
        lh.a aVar = lh.a.a;
        lh.a.g(aVar, getClassTag() + " --> mWebViewClient --> checkUrl() --> from = " + from + " --> url = " + url + " --> resultPageUrl = " + n0(), null, 2, null);
        if (this.isTriggerFinishPage) {
            lh.a.c(aVar, getClassTag() + " --> mWebViewClient --> isTriggerFinishPage = " + from + " --> url = " + url + " --> resultPageUrl = " + n0(), null, 2, null);
            return true;
        }
        if (!StringsKt.c0(url, n0(), false, 2, (Object) null)) {
            if (!StringsKt.c0(url, r, false, 2, (Object) null)) {
                return false;
            }
            this.isTriggerFinishPage = true;
            lh.a.g(aVar, getClassTag() + " --> mWebViewClient --> checkUrl() --> cancel --> from = " + from + " --> url = " + url, null, 2, null);
            this.isPayCancel = true;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        }
        if (this.mShouldOpenCpFrontPage) {
            this.isTriggerFinishPage = true;
            lh.a.g(aVar, getClassTag() + " --> mWebViewClient --> checkUrl() -- shouldOpenCpFrontPage --> result --> from = " + from + " --> url = " + url, null, 2, null);
            com.tn.tranpay.event.b bVar = new com.tn.tranpay.event.b(0);
            if (com.tn.tranpay.event.a.a.c()) {
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = com.tn.tranpay.event.b.class.getName();
                Intrinsics.g(name, "T::class.java.name");
                flowEventBus.postEvent(name, bVar, 0L);
            } else {
                lh.a.e(aVar, "TranPay SDK not initialized, cannot post event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
            }
            return false;
        }
        this.isTriggerFinishPage = true;
        lh.a.g(aVar, getClassTag() + " --> mWebViewClient --> checkUrl() -- shouldNotOpenCpFrontPage --> result --> from = " + from + " --> url = " + url, null, 2, null);
        com.tn.tranpay.event.b bVar2 = new com.tn.tranpay.event.b(0);
        if (com.tn.tranpay.event.a.a.c()) {
            FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = com.tn.tranpay.event.b.class.getName();
            Intrinsics.g(name2, "T::class.java.name");
            flowEventBus2.postEvent(name2, bVar2, 0L);
        } else {
            lh.a.e(aVar, "TranPay SDK not initialized, cannot post event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
        }
        ThreadUtils.f().postDelayed(new Runnable() { // from class: com.tn.tranpay.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                TranPayWebFragment.m0(TranPayWebFragment.this);
            }
        }, 400L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(TranPayWebFragment tranPayWebFragment) {
        Intrinsics.h(tranPayWebFragment, "this$0");
        FragmentActivity activity = tranPayWebFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final String n0() {
        String str = this.mCpFontPage;
        if (str == null || StringsKt.q0(str)) {
            str = null;
        }
        return str == null ? q : str;
    }

    private final void p0(boolean isBackPressed) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            lh.a.c(lh.a.a, "用户关闭了 TranPayWebFragment", null, 2, null);
            if (isBackPressed) {
                activity.onBackPressed();
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(TranPayWebFragment tranPayWebFragment, View view) {
        Intrinsics.h(tranPayWebFragment, "this$0");
        WebView webView = tranPayWebFragment.mCustomWebView;
        if (webView != null) {
            webView.reload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(TranPayWebFragment tranPayWebFragment, View view) {
        Intrinsics.h(tranPayWebFragment, "this$0");
        tranPayWebFragment.p0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(TranPayWebFragment tranPayWebFragment, View view) {
        Intrinsics.h(tranPayWebFragment, "this$0");
        tranPayWebFragment.p0(false);
    }

    private final void t0(View view) {
        HashMap g;
        FrameLayout frameLayout;
        WebView webView = new WebView(view.getContext());
        rg.c mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.b) != null) {
            frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new TranPayWebFragment$initWeb$1$1$1(settings, null), 3, (Object) null);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(false);
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
            com.tn.tranpay.report.c logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                g.put("url", this.mUrl);
            }
            rg.c mViewBinding2 = getMViewBinding();
            ProgressBar progressBar = mViewBinding2 != null ? mViewBinding2.f : null;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            lh.a.g(lh.a.a, getClassTag() + " --> initWeb() --> WebView初始化完成 --> mCustomWebView?.loadUrl(it) 开始加载收银台 -- url = " + this.mUrl, null, 2, null);
            WebView webView2 = this.mCustomWebView;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(String url) {
        HashMap g;
        HashMap g2;
        if (this.timer.get(url) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = (Long) this.timer.get(url);
            long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
            lh.a.g(lh.a.a, getClassTag() + " --> pageFinish() --> mUrl = " + this.mUrl + " -- used time = " + longValue, null, 2, null);
            com.tn.tranpay.report.c logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g2 = logViewConfig.g()) != null) {
                g2.put("duration", String.valueOf(longValue));
            }
            if (this.timer.get("on_create") != null) {
                Object obj = this.timer.get("on_create");
                Intrinsics.e(obj);
                long longValue2 = currentTimeMillis - ((Number) obj).longValue();
                com.tn.tranpay.report.c logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
                    g.put("duration", String.valueOf(longValue2));
                }
                this.timer.put("on_create", null);
            }
        }
        com.tn.tranpay.report.c logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 == null) {
            return;
        }
        logViewConfig3.j(true);
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public com.tn.tranpay.report.c V() {
        return new com.tn.tranpay.report.c("web_page", false, 2, null);
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        ProgressBar progressBar;
        rg.d dVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.h(view, "view");
        rg.c mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.h.setVisibility(0);
        }
        this.timer.put("on_create", Long.valueOf(System.currentTimeMillis()));
        rg.c mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView3 = mViewBinding2.e) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.q0(TranPayWebFragment.this, view2);
                }
            });
        }
        rg.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView2 = mViewBinding3.c) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.r0(TranPayWebFragment.this, view2);
                }
            });
        }
        rg.c mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.s0(TranPayWebFragment.this, view2);
                }
            });
        }
        rg.c mViewBinding5 = getMViewBinding();
        this.webLoading = (mViewBinding5 == null || (dVar = mViewBinding5.j) == null) ? null : dVar.b;
        rg.c mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (progressBar = mViewBinding6.f) != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(com.tn.tranpay.e.c.b().d()));
        }
        initViewModel();
        t0(view);
        NetworkUtils.w(this);
    }

    public void k(NetworkUtils.NetworkType networkType) {
        WebView webView;
        com.tn.tranpay.report.c logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || !logViewConfig.i()) && this.isError && (webView = this.mCustomWebView) != null) {
            webView.reload();
        }
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public rg.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rg.c c2 = rg.c.c(inflater);
        Intrinsics.g(c2, "inflate(inflater)");
        return c2;
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lh.a.g(lh.a.a, getClassTag() + " --> onCreate()", null, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        NetworkUtils.A(this);
        if (this.isPayCancel) {
            com.tn.tranpay.event.b bVar = new com.tn.tranpay.event.b(-1);
            if (!com.tn.tranpay.event.a.a.c()) {
                lh.a.e(lh.a.a, "TranPay SDK not initialized, cannot post event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
                return;
            }
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.tn.tranpay.event.b.class.getName();
            Intrinsics.g(name, "T::class.java.name");
            flowEventBus.postEvent(name, bVar, 0L);
            return;
        }
        com.tn.tranpay.event.b bVar2 = new com.tn.tranpay.event.b(0);
        if (!com.tn.tranpay.event.a.a.c()) {
            lh.a.e(lh.a.a, "TranPay SDK not initialized, cannot post event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
            return;
        }
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = com.tn.tranpay.event.b.class.getName();
        Intrinsics.g(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, bVar2, 0L);
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void onDestroyView() {
        WebView webView = this.mCustomWebView;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }

    public void onDisconnected() {
    }

    public final boolean u0() {
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
