package com.cloud.tmc.miniapp.ad;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.cloud.tmc.ad.TrackingManager;
import com.cloud.tmc.ad.bean.AdExtraBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.BundleUtil;
import com.cloud.tmc.integration.utils.ObjectTypeAdapter;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEvent;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.AdAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.render.IWebView;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.render.method.ShellGameJsInterface;
import com.cloud.tmc.render.system.SystemWebView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class WebviewAdLandingPageActivity extends WebViewActivity {
    public AdsDTO OooO;
    public String OooO0O0;
    public String OooO0OO;
    public String OooO0Oo;
    public String OooO0o;
    public String OooO0o0;
    public DownUpPointBean OooO0oo;
    public final String OooO00o = "WebviewAdLandingPageActivity";
    public Bundle OooO0oO = new Bundle();
    public long OooOO0 = System.currentTimeMillis();

    public final void OooO00o() {
        this.OooO0oO.putLong("web_duration", System.currentTimeMillis() - this.OooOO0);
        this.OooO0oO.putLong("event_ts", this.OooOO0);
        this.OooO0oO.putString("web_url", this.OooO0O0);
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o, AdAnalyseType.ad_web_callback, "", this.OooO0oO);
    }

    public final void OooO00o(String str) {
        AdsDTO adsDTO;
        Integer codeSeatType;
        List l;
        ArrayList clickTrackingUrls;
        Node findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(this.OooO0o);
        DefaultEvent defaultEvent = new DefaultEvent("landingPage");
        ArrayList arrayList = new ArrayList();
        AdsDTO adsDTO2 = this.OooO;
        if (TextUtils.isEmpty(adsDTO2 != null ? adsDTO2.getAdm() : null) || (adsDTO = this.OooO) == null || (codeSeatType = adsDTO.getCodeSeatType()) == null || codeSeatType.intValue() != 1) {
            arrayList.add(str);
        } else {
            AdsDTO adsDTO3 = this.OooO;
            if (adsDTO3 == null || (clickTrackingUrls = adsDTO3.getClickTrackingUrls()) == null || (l = CollectionsKt.R0(clickTrackingUrls)) == null) {
                l = CollectionsKt.l();
            }
            arrayList.addAll(l);
        }
        defaultEvent.setData(MapsKt.f(TuplesKt.a("ad_click", arrayList)));
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(findApp);
        if (eventCenterInstance != null) {
            eventCenterInstance.postEvent("adLandingPage", defaultEvent);
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.action.StatusAction
    public Integer getViewThemeMode() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        String stringExtra = getIntent().getStringExtra("ad_landingPage_url");
        this.OooO0O0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        try {
            this.OooO0OO = getIntent().getStringExtra("adInfo");
            this.OooO0Oo = getIntent().getStringExtra("adsDTO");
            this.OooO0o0 = getIntent().getStringExtra("pointData");
            this.OooO0o = getIntent().getStringExtra("appId");
            Map map = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdLandingPageActivity$initData$gson$1
            }.getType(), new ObjectTypeAdapter()).serializeNulls().create().fromJson(this.OooO0OO, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdLandingPageActivity$initData$_dataMap$1
            }.getType());
            this.OooO0oo = (DownUpPointBean) GsonUtils.fromJson(this.OooO0o0, DownUpPointBean.class);
            this.OooO = (AdsDTO) GsonUtils.fromJson(this.OooO0Oo, AdsDTO.class);
            BundleUtil bundleUtil = BundleUtil.INSTANCE;
            Intrinsics.g(map, "_dataMap");
            bundleUtil.parse(map, this.OooO0oO);
        } catch (Throwable th) {
            TraceLog.i(this.OooO00o, "parse LandingPage info fail: " + th);
        }
        IWebView wb = getWb();
        SystemWebView systemWebView = wb instanceof SystemWebView ? (SystemWebView) wb : null;
        if (systemWebView != null) {
            systemWebView.setBackgroundColor(0);
            systemWebView.getSettings().setMixedContentMode(0);
            systemWebView.getSettings().setSupportMultipleWindows(false);
            systemWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            systemWebView.getSettings().setNeedInitialFocus(true);
            systemWebView.getSettings().setDisplayZoomControls(false);
            systemWebView.getSettings().setUseWideViewPort(true);
            systemWebView.getSettings().setLoadWithOverviewMode(true);
            systemWebView.addJavascriptInterface(new ShellGameJsInterface(), "dltms");
        }
        if (this.OooO0oo == null || this.OooO == null) {
            finish();
        } else {
            String str = this.OooO0O0;
            if (str == null) {
                str = "";
            }
            if (TrackingManager.isEagllwinLink(str)) {
                TrackingManager trackingManager = TrackingManager.INSTANCE;
                DownUpPointBean downUpPointBean = this.OooO0oo;
                Intrinsics.e(downUpPointBean);
                AdsDTO adsDTO = this.OooO;
                Intrinsics.e(adsDTO);
                String str2 = this.OooO0o;
                String str3 = str2 != null ? str2 : "";
                String sDKVersion = ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getSDKVersion();
                Intrinsics.g(sDKVersion, "get(\n                   …             ).sdkVersion");
                this.OooO0O0 = trackingManager.reportServerJoinField(downUpPointBean, adsDTO, new AdExtraBean(str3, false, sDKVersion), true);
            }
            getIntent().putExtra(TmcConstants.EXTRA_PAGE_URI, this.OooO0O0);
        }
        super.initData();
        OooO00o();
        String str4 = this.OooO0O0;
        if (str4 != null) {
            OooO00o(str4);
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity
    public void onDestroy() {
        super.onDestroy();
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(((AppManager) TmcProxy.get(AppManager.class)).findApp(this.OooO0o));
        if (eventCenterInstance != null) {
            DefaultEvent defaultEvent = new DefaultEvent("landingPage");
            defaultEvent.setData(MapsKt.f(TuplesKt.a("finish", "true")));
            Unit unit = Unit.a;
            eventCenterInstance.postEvent("adLandingPage", defaultEvent);
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.kernel.render.WebviewPageCallback
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.kernel.render.WebviewPageEventCallback
    public void onReceivedTitle(String str) {
        super.onReceivedTitle(str);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.kernel.render.WebviewPageCallback
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        OooO00o();
        AdsDTO adsDTO = this.OooO;
        if (!TextUtils.isEmpty(adsDTO != null ? adsDTO.getAdm() : null) && webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            String uri = url.toString();
            Intrinsics.g(uri, "it.toString()");
            OooO00o(uri);
        }
        Boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
        Intrinsics.g(shouldOverrideUrlLoading, "super.shouldOverrideUrlLoading(view, request)");
        return shouldOverrideUrlLoading;
    }
}
