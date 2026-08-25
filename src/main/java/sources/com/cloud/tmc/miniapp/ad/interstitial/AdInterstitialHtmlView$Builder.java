package com.cloud.tmc.miniapp.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cloud.tmc.ad.R;
import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.interface.ActionJsListener;
import com.cloud.tmc.ad.interface.AdEventListener;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import com.cloud.tmc.kernel.render.IWebView;
import com.cloud.tmc.kernel.render.WebviewPageCallback;
import com.cloud.tmc.kernel.render.WebviewPageEventCallback;
import com.cloud.tmc.miniutils.util.ScreenUtils;
import com.cloud.tmc.render.system.SystemWebView;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AdInterstitialHtmlView$Builder extends AdBaseDialog implements WebviewPageEventCallback, WebviewPageCallback {
    public IWebView OooO;
    public final String OooO0oO;
    public AdEventListener OooO0oo;
    public FrameLayout OooOO0;
    public ImageView OooOO0O;
    public ImageView OooOO0o;
    public boolean OooOOO;
    public ImageView OooOOO0;
    public boolean OooOOOO;
    public boolean OooOOOo;
    public float OooOOo;
    public float OooOOo0;
    public float OooOOoo;
    public final ViewGroup.LayoutParams OooOo0;
    public float OooOo00;

    public final class CheckMaterial implements ActionJsListener {
        public CheckMaterial() {
        }

        @JavascriptInterface
        public void loadMaterialError(String str) {
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = AdInterstitialHtmlView$Builder.this;
            adInterstitialHtmlView$Builder.OooOOOo = true;
            AdEventListener adEventListener = adInterstitialHtmlView$Builder.OooO0oo;
            if (adEventListener != null) {
                adEventListener.fillingResult(adInterstitialHtmlView$Builder.OooO0oO, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInterstitialHtmlView$Builder(Context context, String str, String str2, String str3, AdEventListener adEventListener) {
        super(context);
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(str2, "htmlData");
        Intrinsics.h(str3, "scale");
        this.OooO0oO = str;
        this.OooO0oo = adEventListener;
        this.OooOo0 = new ViewGroup.LayoutParams(-1, -2);
        try {
            setContentView(R.layout.view_interstitial_html_style);
            setCanceledOnTouchOutside(false);
            setAnimStyle(-1);
            this.OooOO0O = (ImageView) findViewById(com.cloud.tmc.miniapp.R.id.iv_close);
            this.OooOO0 = (FrameLayout) findViewById(com.cloud.tmc.miniapp.R.id.fl_wb);
            this.OooOO0o = (ImageView) findViewById(R.id.iv_ad);
            this.OooOOO0 = (ImageView) findViewById(R.id.iv_homepage);
            FrameLayout frameLayout = this.OooOO0;
            if (frameLayout != null && (viewTreeObserver = frameLayout.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.cloud.tmc.miniapp.ad.interstitial.b
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        AdInterstitialHtmlView$Builder.OooO00o(AdInterstitialHtmlView$Builder.this);
                    }
                });
            }
            IWebView createWebView = ((IWebViewFactory) TmcProxy.get(IWebViewFactory.class)).createWebView(context);
            if (createWebView != null) {
                createWebView.registerPageEventCallback(this);
                createWebView.registerPageCallback(this);
            } else {
                createWebView = null;
            }
            this.OooO = createWebView;
            if (createWebView != null) {
                createWebView.setAppId("open AdInterstitialHtmlView");
            }
            IWebView iWebView = this.OooO;
            if (iWebView != null) {
                iWebView.setNode(new PageNode((App) null, "", "", (Bundle) null, (Bundle) null));
            }
            IWebView iWebView2 = this.OooO;
            if (iWebView2 != null) {
                iWebView2.create();
            }
            IWebView iWebView3 = this.OooO;
            SystemWebView systemWebView = iWebView3 instanceof SystemWebView ? (SystemWebView) iWebView3 : null;
            if (systemWebView != null) {
                systemWebView.getSettings().setDomStorageEnabled(true);
                ViewExtKt.removeSelf(systemWebView);
                systemWebView.addJavascriptInterface(new CheckMaterial(), "loadError");
                systemWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cloud.tmc.miniapp.ad.interstitial.c
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return AdInterstitialHtmlView$Builder.OooO00o(AdInterstitialHtmlView$Builder.this, view, motionEvent);
                    }
                });
                systemWebView.loadDataWithBaseURL(null, str2 + "<script>\n\twindow.addEventListener('error', function(e) {\n\t\tvar target = e.srcElement;\n\t\tvar tagName = target.tagName;\n\t\tif (tagName && tagName.toUpperCase() === 'IMG' && target) {\n\t\t\tconst {\n\t\t\t\twidth,\n\t\t\t\theight\n\t\t\t} = target.getBoundingClientRect();\n\t\t\tvar isShow = window.getComputedStyle(target).getPropertyValue('display').toUpperCase() !== \"NONE\" ||\n\t\t\t\tfalse;\n\t\t\tvar isShow1 = window.getComputedStyle(target).getPropertyValue('visibility').toUpperCase() !==\n\t\t\t\t\"HIDDEN\" || false;\n\t\t\tif (typeof width == \"number\" && width > 1 && isShow && isShow1) {\n\t\t\t\twindow.loadError && window.loadError.loadMaterialError && window.loadError.loadMaterialError(target\n\t\t\t\t\t.src)\n\t\t\t}\n\t\t}\n\t}, true)\n</script>", "text/html", "utf-8", null);
                FrameLayout frameLayout2 = this.OooOO0;
                if (frameLayout2 != null) {
                    frameLayout2.addView(systemWebView);
                }
            }
            setOnClickListener(this.OooOO0O, this.OooOO0o, this.OooOOO0);
        } catch (Throwable unused) {
        }
    }

    public static final void OooO00o(AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder) {
        Intrinsics.h(adInterstitialHtmlView$Builder, "this$0");
        FrameLayout frameLayout = adInterstitialHtmlView$Builder.OooOO0;
        int height = frameLayout != null ? frameLayout.getHeight() : 0;
        if (height <= 0 || adInterstitialHtmlView$Builder.OooOOO) {
            return;
        }
        adInterstitialHtmlView$Builder.OooOOO = true;
        int screenHeight = (int) (ScreenUtils.getScreenHeight() * 0.54d);
        if (height > screenHeight) {
            ViewGroup.LayoutParams layoutParams = adInterstitialHtmlView$Builder.OooOo0;
            layoutParams.height = screenHeight;
            FrameLayout frameLayout2 = adInterstitialHtmlView$Builder.OooOO0;
            if (frameLayout2 == null) {
                return;
            }
            frameLayout2.setLayoutParams(layoutParams);
        }
    }

    public static final boolean OooO00o(AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder, View view, MotionEvent motionEvent) {
        Intrinsics.h(adInterstitialHtmlView$Builder, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            adInterstitialHtmlView$Builder.OooOOo0 = motionEvent.getX();
            adInterstitialHtmlView$Builder.OooOOo = motionEvent.getY();
            return false;
        }
        if (action != 1) {
            return false;
        }
        adInterstitialHtmlView$Builder.OooOOoo = motionEvent.getX();
        adInterstitialHtmlView$Builder.OooOo00 = motionEvent.getY();
        return false;
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public int OooO00o() {
        FrameLayout frameLayout = this.OooOO0;
        if (frameLayout != null) {
            return frameLayout.getHeight();
        }
        return 0;
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public void OooO00o(AdShowBean adShowBean) {
        Intrinsics.h(adShowBean, "adShowBean");
        AdEventListener adEventListener = this.OooO0oo;
        if (adEventListener != null) {
            adEventListener.showResult(this.OooO0oO, true, adShowBean);
        }
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public int OooO0O0() {
        FrameLayout frameLayout = this.OooOO0;
        if (frameLayout != null) {
            return frameLayout.getWidth();
        }
        return 0;
    }

    public final void OooO0Oo() {
        IWebView iWebView = this.OooO;
        if (iWebView != null) {
            iWebView.destroy();
            this.OooO = null;
        }
        FrameLayout frameLayout = this.OooOO0;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.OooO0oo = null;
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooO00o, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        AdEventListener adEventListener;
        Intrinsics.h(view, "view");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        if (!Intrinsics.c(view, this.OooOO0O)) {
            if (Intrinsics.c(view, this.OooOO0o)) {
                AdEventListener adEventListener2 = this.OooO0oo;
                if (adEventListener2 != null) {
                    adEventListener2.clickPersonalization(this.OooO0oO);
                    return;
                }
                return;
            }
            if (!Intrinsics.c(view, this.OooOOO0) || (adEventListener = this.OooO0oo) == null) {
                return;
            }
            adEventListener.clickHomePage(this.OooO0oO);
            return;
        }
        AdEventListener adEventListener3 = this.OooO0oo;
        if (adEventListener3 != null) {
            String str = this.OooO0oO;
            AdClickBean adClickBean = new AdClickBean(0, 0L, (String) null, 7, (DefaultConstructorMarker) null);
            adClickBean.setShowTimes(this.OooO0O0);
            adClickBean.setShowDuration(System.currentTimeMillis() - adClickBean.getShowDuration());
            FrameLayout frameLayout = this.OooOO0;
            Integer valueOf = frameLayout != null ? Integer.valueOf(frameLayout.getWidth()) : null;
            FrameLayout frameLayout2 = this.OooOO0;
            adClickBean.setShowArea(valueOf + "*" + (frameLayout2 != null ? Integer.valueOf(frameLayout2.getHeight()) : null));
            Unit unit = Unit.a;
            adEventListener3.closeAd(str, adClickBean);
        }
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onConsoleMessage(String str) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onPageStarted(WebView webView, String str) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onProgressChanged(WebView webView, int i) {
        AdEventListener adEventListener;
        if (i != 100) {
            this.OooOOOO = false;
            return;
        }
        if (i != 100 || this.OooOOOO) {
            return;
        }
        this.OooOOOO = true;
        if (this.OooOOOo || (adEventListener = this.OooO0oo) == null) {
            return;
        }
        adEventListener.fillingResult(this.OooO0oO, true);
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onReceivedIcon(Bitmap bitmap) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onReceivedTitle(String str) {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public /* synthetic */ Boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return com.cloud.tmc.kernel.render.d.a(this, webView, renderProcessGoneDetail);
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onRequestFocus() {
    }

    @Override // com.cloud.tmc.kernel.render.WebviewPageCallback
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        float f = this.OooOOo0;
        float f2 = this.OooOOo;
        float f3 = this.OooOOoo;
        float f4 = this.OooOo00;
        FrameLayout frameLayout = this.OooOO0;
        int width = frameLayout != null ? frameLayout.getWidth() : 0;
        FrameLayout frameLayout2 = this.OooOO0;
        DownUpPointBean downUpPointBean = new DownUpPointBean(f, f2, f3, f4, frameLayout2 != null ? frameLayout2.getHeight() : 0, width);
        AdEventListener adEventListener = this.OooO0oo;
        if (adEventListener != null) {
            adEventListener.click(this.OooO0oO, downUpPointBean, webView != null ? webView.getUrl() : null);
        }
        return Boolean.TRUE;
    }
}
