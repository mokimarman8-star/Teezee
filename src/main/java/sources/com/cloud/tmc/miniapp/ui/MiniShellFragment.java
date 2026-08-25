package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.callback.ILoadHtmlDataCallback;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.structure.ui.ErrorView;
import com.cloud.tmc.integration.structure.ui.LoadingView;
import com.cloud.tmc.integration.structure.ui.PageContainer;
import com.cloud.tmc.integration.structure.ui.TabBar;
import com.cloud.tmc.integration.structure.ui.TitleBar;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.EnvironmentUtil;
import com.cloud.tmc.integration.utils.MiniAppConfigUtils;
import com.cloud.tmc.integration.utils.MiniShellUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEvent;
import com.cloud.tmc.kernel.debug.DebugCallback;
import com.cloud.tmc.kernel.debug.DebugConfig;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.render.ICustomViewVisiable;
import com.cloud.tmc.kernel.render.IPageCallback;
import com.cloud.tmc.kernel.render.IPageEventCallback;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.render.IWebView;
import com.cloud.tmc.kernel.render.LoadParams;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.KUrlUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.kernel.worker.JSI;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.action.StatusAction;
import com.cloud.tmc.miniapp.action.VersionUpdateAction;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.base.MiniAppH5BaseFragment;
import com.cloud.tmc.miniapp.databinding.OooO00o;
import com.cloud.tmc.miniapp.ui.extension.FullScreenExtensionKt;
import com.cloud.tmc.miniapp.ui.extension.PinForLaterExtensionKt;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.ImmersiveTitleBarView;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.PageContainerView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import com.cloud.tmc.render.bridge.WebviewBridgeHelper;
import com.cloud.tmc.render.system.ShellWebView;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniShellFragment extends MiniAppH5BaseFragment implements IPageEventCallback, IPageCallback, DebugCallback, IEventSubscriber, StatusAction, ILoadHtmlDataCallback, VersionUpdateAction {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MiniShellFragment";
    private OooO00o binding;
    private View contextView;
    private boolean enablePreRequest;
    private IEventCenter eventCenter;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private Page mPendingSetPage;
    private int mScrollY;
    private StatusLayout mStatusLayout;
    private boolean needRefreshYCoordinate;
    private boolean perEnterFlag;
    private boolean perfSendFlag;
    private boolean typeLoadData;
    private String baseUrl = "";
    private final Lazy mHandler$delegate = LazyKt.b(new Function0<Handler>() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$mHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m77invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeNavigationBarProgress$lambda$18(MiniShellFragment miniShellFragment, int i, int i2, long j) {
        Intrinsics.h(miniShellFragment, "this$0");
        miniShellFragment.changeNavigationBarProgress(i + 1, i2, j);
    }

    private final void checkUpdateTitleBarStyle() {
        try {
            Page page = ((TmcFragment) this).page;
            if (page == null || !page.isShow()) {
                return;
            }
            updateTitleBarStyle();
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final void customNavigationStyle(MiniAppConfigModel.WindowBean windowBean) {
        Page page;
        if (windowBean != null) {
            Page page2 = ((TmcFragment) this).page;
            if (page2 != null) {
                page2.setNavigationBarTitleColor(windowBean.navigationBarTextStyleIsWhite());
            }
            Page page3 = ((TmcFragment) this).page;
            if (page3 != null) {
                page3.setNavigationBarBackgroundColor(windowBean.getNavigationBarBackgroundColor());
            }
            Page page4 = ((TmcFragment) this).page;
            if (page4 != null) {
                page4.setNavigationBarTransparent(Intrinsics.c(windowBean.getEnableTransparentStatusBar(), Boolean.TRUE));
            }
            String navigationBarHomeAction = windowBean.getNavigationBarHomeAction();
            if (navigationBarHomeAction != null && (page = ((TmcFragment) this).page) != null) {
                page.setHomeAction(MiniAppConfigUtils.navigationBarAction(navigationBarHomeAction), false);
            }
            Page page5 = ((TmcFragment) this).page;
            if (page5 != null) {
                page5.setNavigationBarIconStyle(windowBean.navigationBarIconStyleIsWhite());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debugRefresh$lambda$28(final MiniShellFragment miniShellFragment) {
        JSI jsi;
        IRender render;
        App app;
        IRender render2;
        App app2;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app3;
        IEngine engineProxy2;
        Intrinsics.h(miniShellFragment, "this$0");
        MiniAppActivity activity = miniShellFragment.getActivity();
        String str = null;
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null) {
            miniAppActivity.setFirstLaunch(true);
        }
        Page page = ((TmcFragment) miniShellFragment).page;
        if (page == null || (app2 = page.getApp()) == null || (engineProxy = app2.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            jsi = null;
        } else {
            Page page2 = ((TmcFragment) miniShellFragment).page;
            jsi = engineRouter.getWorkerById((page2 == null || (app3 = page2.getApp()) == null || (engineProxy2 = app3.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (jsi != null) {
            jsi.debugRefresh();
        }
        Page page3 = ((TmcFragment) miniShellFragment).page;
        View view = (page3 == null || (render2 = page3.getRender()) == null) ? null : render2.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        }
        if (miniShellFragment.getAppLoadResult() != null) {
            final IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(((TmcFragment) miniShellFragment).app);
            if (eventCenterInstance != null) {
                eventCenterInstance.register("renderOnMessageReady", new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$debugRefresh$1$1$1
                    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                    public boolean onEvent(IEvent iEvent) {
                        Page page4;
                        Page page5;
                        WebviewBridgeHelper webviewBridgeHelper;
                        IRender render3;
                        IRender render4;
                        page4 = ((TmcFragment) MiniShellFragment.this).page;
                        if (!StringsKt.I((page4 == null || (render4 = page4.getRender()) == null) ? null : render4.getRenderId(), iEvent != null ? iEvent.getRenderId() : null, false, 2, (Object) null)) {
                            return false;
                        }
                        page5 = ((TmcFragment) MiniShellFragment.this).page;
                        KeyEvent.Callback view2 = (page5 == null || (render3 = page5.getRender()) == null) ? null : render3.getView();
                        ShellWebView shellWebView = view2 instanceof ShellWebView ? (ShellWebView) view2 : null;
                        if (shellWebView != null && (webviewBridgeHelper = shellWebView.getWebviewBridgeHelper()) != null) {
                            webviewBridgeHelper.registerMessageChannel();
                        }
                        MiniShellFragment.this.openPage();
                        eventCenterInstance.unregister("renderOnMessageReady", this);
                        return true;
                    }
                });
            }
            LoadParams loadParams = new LoadParams();
            Page page4 = ((TmcFragment) miniShellFragment).page;
            loadParams.url = page4 != null ? page4.getPageURI() : null;
            Page page5 = ((TmcFragment) miniShellFragment).page;
            loadParams.pagePath = page5 != null ? page5.getPagePath() : null;
            Page page6 = ((TmcFragment) miniShellFragment).page;
            if (page6 != null && (app = page6.getApp()) != null) {
                str = app.getAppId();
            }
            loadParams.appId = str;
            Page page7 = ((TmcFragment) miniShellFragment).page;
            if (page7 == null || (render = page7.getRender()) == null) {
                return;
            }
            render.load(loadParams);
        }
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hideCustomView(boolean z) {
        FrameLayout frameLayout;
        if (this.mCustomView == null) {
            return false;
        }
        if (z) {
            this.needRefreshYCoordinate = true;
        }
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.a()), (CoroutineContext) null, (CoroutineStart) null, new MiniShellFragment$hideCustomView$1(this, null), 3, (Object) null);
        OooO00o oooO00o = this.binding;
        if (oooO00o != null && (frameLayout = oooO00o.OooO0OO) != null) {
            frameLayout.setVisibility(8);
            frameLayout.removeView(this.mCustomView);
        }
        View view = this.mCustomView;
        if (view != null) {
            view.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.mCustomViewCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.mCustomView = null;
        this.mCustomViewCallback = null;
        if (getHasVirtualNavBar()) {
            showVirtualNavBar();
        }
        FullScreenExtensionKt.landScapeToProtrait(this);
        return true;
    }

    private final void init() {
        IRender render;
        PageContainerView pageContainerView;
        IRender render2;
        App app;
        PageContainerView pageContainerView2;
        IRender render3;
        App app2;
        AppLoadResult appLoadResult = getAppLoadResult();
        Page page = ((TmcFragment) this).page;
        if (page != null && (app2 = page.getApp()) != null) {
            app2.setData(AppLoadResult.class, appLoadResult);
        }
        try {
            Boolean isDebug = ((BuildConfigProxy) TmcProxy.get(BuildConfigProxy.class)).isDebug();
            Intrinsics.g(isDebug, "get(BuildConfigProxy::class.java).isDebug");
            if (isDebug.booleanValue() || AppUtils.enableWebViewDebugger()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Throwable unused) {
        }
        Page page2 = ((TmcFragment) this).page;
        View view = (page2 == null || (render3 = page2.getRender()) == null) ? null : render3.getView();
        if (view == null) {
            return;
        }
        this.contextView = view;
        AppLoadResult appLoadResult2 = getAppLoadResult();
        Page page3 = ((TmcFragment) this).page;
        MiniAppConfigModel.WindowBean windowOptimalConfiguration = MiniAppConfigUtils.getWindowOptimalConfiguration(appLoadResult2, page3 != null ? page3.getPagePath() : null);
        if (windowOptimalConfiguration != null) {
            try {
                String contentBgColor = windowOptimalConfiguration.getContentBgColor();
                if (contentBgColor != null && contentBgColor.length() > 0) {
                    int parseColor = Color.parseColor(contentBgColor);
                    OooO00o oooO00o = this.binding;
                    if (oooO00o != null && (pageContainerView = oooO00o.OooO0O0) != null) {
                        pageContainerView.setBackgroundColor(parseColor);
                    }
                    Page page4 = ((TmcFragment) this).page;
                    if (page4 != null && (render = page4.getRender()) != null) {
                        render.setBgColor(contentBgColor);
                    }
                }
            } catch (Exception e) {
                TmcLogger.e(TAG, "set content background color error", e);
            }
            Boolean enablePullDownRefresh = windowOptimalConfiguration.getEnablePullDownRefresh();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.c(enablePullDownRefresh, bool) || Intrinsics.c(windowOptimalConfiguration.getEnablePullUpRefresh(), bool)) {
                View view2 = this.contextView;
                if (view2 == null) {
                    Intrinsics.y("contextView");
                    view2 = null;
                }
                this.contextView = attachToRefresh(view2, windowOptimalConfiguration);
            }
        }
        OooO00o oooO00o2 = this.binding;
        if (oooO00o2 != null && (pageContainerView2 = oooO00o2.OooO0O0) != null) {
            View view3 = this.contextView;
            if (view3 == null) {
                Intrinsics.y("contextView");
                view3 = null;
            }
            ViewExtKt.removeSelf(view3);
            pageContainerView2.addView(view3);
        }
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null) {
            miniAppActivity.hideStatusLoadingDelay(MiniAppLaunch.INSTANCE.getStartLoadingH5AnimDelayTime());
        }
        Page page5 = ((TmcFragment) this).page;
        if (page5 != null && (render2 = page5.getRender()) != null && render2.fromWarmup()) {
            PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class);
            Page page6 = ((TmcFragment) this).page;
            performanceImprovesProxy.addPeroformanceImprove((page6 == null || (app = page6.getApp()) == null) ? null : app.getAppId(), "webview");
        }
        Page page7 = ((TmcFragment) this).page;
        IRender render4 = page7 != null ? page7.getRender() : null;
        Page page8 = ((TmcFragment) this).page;
        injectRenderFramework(render4, page8 != null ? page8.getApp() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5$lambda$2(MiniAppActivity miniAppActivity, View view) {
        if (miniAppActivity != null) {
            MiniAppActivity.addScreen$default(miniAppActivity, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5$lambda$3(MiniAppActivity miniAppActivity, View view) {
        if (miniAppActivity != null) {
            miniAppActivity.goHome();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5$lambda$4(MiniShellFragment miniShellFragment, View view) {
        IRender render;
        Intrinsics.h(miniShellFragment, "this$0");
        Page page = ((TmcFragment) miniShellFragment).page;
        View view2 = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        WebView webView = view2 instanceof WebView ? (WebView) view2 : null;
        if (miniShellFragment.canGoBack(webView)) {
            WebBackForwardList copyBackForwardList = webView != null ? webView.copyBackForwardList() : null;
            if ((copyBackForwardList != null ? copyBackForwardList.getCurrentIndex() : 0) != 0) {
                Page page2 = ((TmcFragment) miniShellFragment).page;
                if (page2 != null) {
                    page2.setNavigationBarTitleVisible(false);
                    return;
                }
                return;
            }
            Page page3 = ((TmcFragment) miniShellFragment).page;
            if (page3 != null) {
                page3.hideHomeButton();
            }
            Page page4 = ((TmcFragment) miniShellFragment).page;
            if (page4 != null) {
                page4.setNavigationBarTitleVisible(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x02c5 A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:178:0x01ac, B:91:0x01b5, B:93:0x01b9, B:96:0x01c8, B:99:0x01d0, B:101:0x01dc, B:102:0x01e2, B:104:0x01e6, B:106:0x01ec, B:107:0x01f6, B:109:0x021a, B:111:0x0220, B:113:0x0226, B:115:0x023a, B:116:0x0240, B:118:0x0243, B:120:0x024b, B:121:0x0251, B:148:0x025a, B:149:0x0264, B:152:0x0286, B:154:0x02a6, B:158:0x02bf, B:160:0x02c5, B:162:0x02d3, B:163:0x02e0, B:165:0x02fe, B:166:0x0304, B:168:0x0308, B:170:0x031e, B:172:0x0322, B:174:0x0338), top: B:177:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0308 A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:178:0x01ac, B:91:0x01b5, B:93:0x01b9, B:96:0x01c8, B:99:0x01d0, B:101:0x01dc, B:102:0x01e2, B:104:0x01e6, B:106:0x01ec, B:107:0x01f6, B:109:0x021a, B:111:0x0220, B:113:0x0226, B:115:0x023a, B:116:0x0240, B:118:0x0243, B:120:0x024b, B:121:0x0251, B:148:0x025a, B:149:0x0264, B:152:0x0286, B:154:0x02a6, B:158:0x02bf, B:160:0x02c5, B:162:0x02d3, B:163:0x02e0, B:165:0x02fe, B:166:0x0304, B:168:0x0308, B:170:0x031e, B:172:0x0322, B:174:0x0338), top: B:177:0x01ac }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void injectRenderFramework(IRender iRender, App app) {
        String str;
        View view;
        IRender render;
        String str2;
        String str3;
        IRender render2;
        View view2;
        LoadParams loadParams = new LoadParams();
        Page page = ((TmcFragment) this).page;
        loadParams.url = page != null ? page.getPageURI() : null;
        Page page2 = ((TmcFragment) this).page;
        loadParams.pagePath = page2 != null ? page2.getPagePath() : null;
        loadParams.appId = app != null ? app.getAppId() : null;
        pointTrackLoadRenderFrameworkStart();
        pointTrackLoadRenderFrameworkEnd();
        pointTrackCreateWorkerStart();
        pointTrackCreateWorkerEnd();
        pointTrackLoadWorkerFrameworkStart();
        pointTrackLoadWorkerFrameworkEnd();
        pointTrackDrawViewStart();
        Page page3 = ((TmcFragment) this).page;
        String valueOf = String.valueOf(page3 != null ? page3.getPageURI() : null);
        Page page4 = ((TmcFragment) this).page;
        pointTrackLoadRenderFrameworkStartNew(valueOf, String.valueOf(page4 != null ? page4.getPageId() : null));
        Page page5 = ((TmcFragment) this).page;
        String valueOf2 = String.valueOf(page5 != null ? page5.getPageURI() : null);
        Page page6 = ((TmcFragment) this).page;
        pointTrackLoadRenderFrameworkEndNew(valueOf2, String.valueOf(page6 != null ? page6.getPageId() : null));
        Page page7 = ((TmcFragment) this).page;
        String valueOf3 = String.valueOf(page7 != null ? page7.getPageURI() : null);
        Page page8 = ((TmcFragment) this).page;
        pointTrackCreateWorkerStartNew(valueOf3, String.valueOf(page8 != null ? page8.getPageId() : null));
        Page page9 = ((TmcFragment) this).page;
        String valueOf4 = String.valueOf(page9 != null ? page9.getPageURI() : null);
        Page page10 = ((TmcFragment) this).page;
        pointTrackCreateWorkerEndNew(valueOf4, String.valueOf(page10 != null ? page10.getPageId() : null));
        Page page11 = ((TmcFragment) this).page;
        String valueOf5 = String.valueOf(page11 != null ? page11.getPageURI() : null);
        Page page12 = ((TmcFragment) this).page;
        pointTrackLoadWorkerFrameworkStartNew(valueOf5, String.valueOf(page12 != null ? page12.getPageId() : null));
        Page page13 = ((TmcFragment) this).page;
        String valueOf6 = String.valueOf(page13 != null ? page13.getPageURI() : null);
        Page page14 = ((TmcFragment) this).page;
        pointTrackLoadWorkerFrameworkEndNew(valueOf6, String.valueOf(page14 != null ? page14.getPageId() : null));
        Page page15 = ((TmcFragment) this).page;
        String valueOf7 = String.valueOf(page15 != null ? page15.getPageURI() : null);
        Page page16 = ((TmcFragment) this).page;
        pointTrackMidStartNew(valueOf7, String.valueOf(page16 != null ? page16.getPageId() : null));
        Page page17 = ((TmcFragment) this).page;
        String valueOf8 = String.valueOf(page17 != null ? page17.getPageURI() : null);
        Page page18 = ((TmcFragment) this).page;
        pointTrackMidEndNew(valueOf8, String.valueOf(page18 != null ? page18.getPageId() : null));
        Page page19 = ((TmcFragment) this).page;
        String valueOf9 = String.valueOf(page19 != null ? page19.getPageURI() : null);
        Page page20 = ((TmcFragment) this).page;
        pointTrackDrawViewStartNew(valueOf9, String.valueOf(page20 != null ? page20.getPageId() : null));
        Page page21 = ((TmcFragment) this).page;
        if (page21 == null || (str = page21.getPageRandomIdByGAId()) == null) {
            str = "null";
        }
        loadingUrlStart(str);
        Context context = getContext();
        if (context != null && iRender != null && (view2 = iRender.getView()) != null) {
            Integer viewThemeMode = getViewThemeMode();
            view2.setBackgroundColor(androidx.core.content.b.getColor(context, (viewThemeMode != null && viewThemeMode.intValue() == 2) ? R.color.mini_color_white : R.color.mini_color_bg_01));
        }
        Page page22 = ((TmcFragment) this).page;
        View view3 = (page22 == null || (render2 = page22.getRender()) == null) ? null : render2.getView();
        injectJSFromConfig(view3 instanceof WebView ? (WebView) view3 : null, "preLoadurl");
        if (iRender != null) {
            try {
                view = iRender.getView();
            } catch (Throwable th) {
                this.typeLoadData = false;
                if (iRender != null) {
                    iRender.load(loadParams);
                }
                TmcLogger.e(TAG, th);
            }
        } else {
            view = null;
        }
        ShellWebView shellWebView = view instanceof ShellWebView ? (ShellWebView) view : null;
        if (shellWebView == null || !shellWebView.getIsOffScreenRender()) {
            TmcLogger.d("nevermore", "load Shell url -> " + (iRender != null ? Boolean.valueOf(iRender.fromWarmup()) : null));
            boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_SHELL_PRE_REQUEST, true);
            this.enablePreRequest = configTargetBool;
            if (configTargetBool) {
                String encryptMD5ToString = EncryptUtils.encryptMD5ToString(loadParams.url);
                TmcLogger.d(TAG, "md5 -> " + encryptMD5ToString);
                Context context2 = getContext();
                if (context2 != null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class);
                    Intrinsics.g(encryptMD5ToString, "md5");
                    str2 = preHtmStrategyProxy.getPreHtmlCache(context2, encryptMD5ToString, 1, true);
                    if (str2 == null) {
                    }
                    str3 = str2;
                    if (str3.length() <= 0) {
                        this.typeLoadData = true;
                        setTrackPointLoadData(true);
                        String str4 = loadParams.url;
                        Intrinsics.g(str4, "loadParams.url");
                        this.baseUrl = str4;
                        if (iRender != null) {
                            iRender.loadDataWithBaseURL(loadParams, str3, "text/html", TmcConstants.DEFAULT_ENCODING, null);
                        }
                        TmcLogger.d(TAG, "use loadDataWithBaseURL -> url is " + loadParams.url);
                        ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(app != null ? app.getAppId() : null, "preHtml");
                    } else {
                        TmcLogger.d(TAG, "use http -> url is " + loadParams.url);
                        if (iRender != null) {
                            iRender.load(loadParams);
                        }
                    }
                }
                str2 = "";
                str3 = str2;
                if (str3.length() <= 0) {
                }
            } else {
                TmcLogger.d(TAG, "use http -> url is " + loadParams.url);
                if (iRender != null) {
                    iRender.load(loadParams);
                }
            }
        } else {
            Boolean valueOf10 = iRender != null ? Boolean.valueOf(iRender.fromWarmup()) : null;
            View view4 = iRender != null ? iRender.getView() : null;
            ShellWebView shellWebView2 = view4 instanceof ShellWebView ? (ShellWebView) view4 : null;
            TmcLogger.d("nevermore", "load Shell offscreen -> warmup: " + valueOf10 + ", loadDataWithBaseURL: " + (shellWebView2 != null ? Boolean.valueOf(shellWebView2.getIsLoadDataWithBaseURL()) : null));
            View view5 = iRender.getView();
            ShellWebView shellWebView3 = view5 instanceof ShellWebView ? (ShellWebView) view5 : null;
            if (shellWebView3 != null && shellWebView3.getIsLoadDataWithBaseURL()) {
                this.typeLoadData = true;
                setTrackPointLoadData(true);
                String str5 = loadParams.url;
                Intrinsics.g(str5, "loadParams.url");
                this.baseUrl = str5;
                ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(app != null ? app.getAppId() : null, "preHtml");
            }
            ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(app != null ? app.getAppId() : null, LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER);
        }
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(app);
        if (eventCenterInstance != null) {
            DefaultEvent defaultEvent = new DefaultEvent("pageEnter");
            Page page23 = ((TmcFragment) this).page;
            defaultEvent.setRenderId((page23 == null || (render = page23.getRender()) == null) ? null : render.getRenderId());
            Unit unit = Unit.a;
            eventCenterInstance.postEvent("renderOnMessageReady", defaultEvent);
        }
        initDomLoadMonitor(2);
        Page page24 = ((TmcFragment) this).page;
        String valueOf11 = String.valueOf(page24 != null ? page24.getPageURI() : null);
        Page page25 = ((TmcFragment) this).page;
        MiniAppH5BaseFragment.pointTrackDrawViewEndForApp$default(this, valueOf11, String.valueOf(page25 != null ? page25.getPageId() : null), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceivedError$lambda$33(final MiniShellFragment miniShellFragment) {
        boolean z;
        Intrinsics.h(miniShellFragment, "this$0");
        try {
            StatusLayout.OooO0O0 oooO0O0 = new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$onReceivedError$1$1
                @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                public void onRetry(StatusLayout statusLayout) {
                    App app;
                    App app2;
                    App app3;
                    Page page;
                    App app4;
                    App app5;
                    Page page2;
                    Page page3;
                    Object context = MiniShellFragment.this.getContext();
                    MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                    if (miniAppActivity != null) {
                        miniAppActivity.setDelayShowError(true);
                    }
                    app = ((TmcFragment) MiniShellFragment.this).app;
                    if (app != null) {
                        page3 = ((TmcFragment) MiniShellFragment.this).page;
                        String pageURI = page3 != null ? page3.getPageURI() : null;
                        if (pageURI == null) {
                            pageURI = "";
                        }
                        app.putPageType(pageURI, 2);
                    }
                    app2 = ((TmcFragment) MiniShellFragment.this).app;
                    if (app2 != null) {
                        page2 = ((TmcFragment) MiniShellFragment.this).page;
                        String pageURI2 = page2 != null ? page2.getPageURI() : null;
                        if (pageURI2 == null) {
                            pageURI2 = "";
                        }
                        app2.putRouteType(pageURI2, "redirectTo");
                    }
                    app3 = ((TmcFragment) MiniShellFragment.this).app;
                    if (app3 != null) {
                        page = ((TmcFragment) MiniShellFragment.this).page;
                        String pageURI3 = page != null ? page.getPageURI() : null;
                        String str = pageURI3 != null ? pageURI3 : "";
                        app4 = ((TmcFragment) MiniShellFragment.this).app;
                        Bundle startParams = app4 != null ? app4.getStartParams() : null;
                        app5 = ((TmcFragment) MiniShellFragment.this).app;
                        app3.redirectTo(str, startParams, app5 != null ? app5.getSceneParams() : null);
                    }
                }
            };
            int i = R.string.loading_error_tv;
            App app = ((TmcFragment) miniShellFragment).app;
            String appId = app != null ? app.getAppId() : null;
            MiniAppActivity activity = miniShellFragment.getActivity();
            MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
            miniShellFragment.showError(oooO0O0, i, "", appId, miniAppActivity != null ? PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity) : null);
            Integer viewThemeMode = miniShellFragment.getViewThemeMode();
            if (viewThemeMode != null) {
                z = true;
                if (viewThemeMode.intValue() == 1) {
                    miniShellFragment.setCapsuleStyle(z);
                }
            }
            z = false;
            miniShellFragment.setCapsuleStyle(z);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MiniShellFragment miniShellFragment, View view) {
        Intrinsics.h(miniShellFragment, "this$0");
        miniShellFragment.hideCustomView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPage() {
        JSI jsi;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        App app3;
        App app4;
        Bundle startParams;
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, "page");
        String str = ChainPoint.CHAIN_ID;
        Page page = ((TmcFragment) this).page;
        bundle.putString(str, String.valueOf((page == null || (app4 = page.getApp()) == null || (startParams = app4.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
        String str2 = ChainPoint.PAGE_PATH;
        Page page2 = ((TmcFragment) this).page;
        bundle.putString(str2, getReportOriginalUrl(String.valueOf(page2 != null ? page2.getPageURI() : null)));
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        Page page3 = ((TmcFragment) this).page;
        performanceAnalyseProxy.record((page3 == null || (app3 = page3.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_CHAIN_START, ChainPoint.DrawView, bundle);
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null && miniAppActivity.isFirstLaunch()) {
            sendAppReadyToRender();
            FragmentActivity activity2 = getActivity();
            App app5 = activity2 instanceof MiniAppActivity ? (MiniAppActivity) activity2 : null;
            if (app5 == null) {
                return;
            }
            app5.setFirstLaunch(false);
            return;
        }
        sendPageReadyToRender();
        Page page4 = ((TmcFragment) this).page;
        if (page4 == null || (app = page4.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            jsi = null;
        } else {
            Page page5 = ((TmcFragment) this).page;
            jsi = engineRouter.getWorkerById((page5 == null || (app2 = page5.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (jsi != null ? Intrinsics.c(jsi.firstGetPackageFileStatus(), Boolean.TRUE) : false) {
            MiniAppBaseFragment.sendPageEnterToWorker$default(this, null, 1, null);
            return;
        }
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
        Page page6 = ((TmcFragment) this).page;
        IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(page6 != null ? page6.getApp() : null);
        if (eventCenterInstance != null) {
            eventCenterInstance.register(WorkerManager.INSTANCE.getEVENT_RESEND_PAGE_ENTER(), new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$openPage$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent iEvent) {
                    MiniAppBaseFragment.sendPageEnterToWorker$default(MiniShellFragment.this, null, 1, null);
                    return false;
                }
            });
        }
    }

    private final void prePage() {
        IRender render;
        Page page = ((TmcFragment) this).page;
        if (page != null && (render = page.getRender()) != null && render.fromWarmup()) {
            openPage();
            return;
        }
        final IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(((TmcFragment) this).app);
        if (eventCenterInstance != null) {
            eventCenterInstance.register("renderOnMessageReady", new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$prePage$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent iEvent) {
                    Page page2;
                    IRender render2;
                    page2 = ((TmcFragment) MiniShellFragment.this).page;
                    if (!StringsKt.I((page2 == null || (render2 = page2.getRender()) == null) ? null : render2.getRenderId(), iEvent != null ? iEvent.getRenderId() : null, false, 2, (Object) null)) {
                        return false;
                    }
                    MiniShellFragment.this.openPage();
                    eventCenterInstance.unregister("renderOnMessageReady", this);
                    return true;
                }
            });
        }
    }

    private final void recordPointAfterLoadUrl(IRender iRender, LoadParams loadParams, String str) {
        try {
            String decode = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode == null) {
                decode = "";
            }
            MiniAppH5BaseFragment.pointTrackDrawViewEndForApp$default(this, decode, str, false, 4, null);
        } catch (Throwable unused) {
        }
    }

    private final void recordPointBeforeLoadUrl(IRender iRender, LoadParams loadParams, String str) {
        String str2;
        App app;
        try {
            String decode = UrlUtils.decode(String.valueOf(loadParams.url));
            String str3 = "";
            if (decode == null) {
                decode = "";
            }
            setLoadingUrl(decode, true, str);
            String decode2 = UrlUtils.decode(String.valueOf(loadParams.url));
            String str4 = decode2 == null ? "" : decode2;
            PageChainContext pageChainContext = new PageChainContext();
            App app2 = ((TmcFragment) this).app;
            String str5 = null;
            pageChainContext.setAppChainContext(app2 != null ? app2.getAppChainContext() : null);
            Unit unit = Unit.a;
            addPage("", "", str4, str, pageChainContext);
            pointTrackPageStart();
            MiniAppActivity activity = getActivity();
            MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
            if (miniAppActivity != null && !miniAppActivity.isFirstLaunch()) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                Node page = iRender != null ? iRender.getPage() : null;
                PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
                if (pageNode != null && (app = pageNode.getApp()) != null) {
                    str5 = app.getAppId();
                }
                performanceAnalyseProxy.record(str5, PointAnalyseType.POINT_PAGE_PV, "");
            }
            pointTrackCreateRenderStart();
            pointTrackCreateRenderEnd();
            pointTrackLoadRenderFrameworkStart();
            pointTrackLoadRenderFrameworkEnd();
            pointTrackCreateWorkerStart();
            pointTrackCreateWorkerEnd();
            pointTrackLoadWorkerFrameworkStart();
            pointTrackLoadWorkerFrameworkEnd();
            pointTrackDrawViewStart();
            String decode3 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode3 == null) {
                decode3 = "";
            }
            pointTrackCreateContainerStartNew(decode3, str);
            String decode4 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode4 == null) {
                decode4 = "";
            }
            pointTrackCreateContainerEndNew(decode4, str);
            String decode5 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode5 == null) {
                decode5 = "";
            }
            pointTrackCreateRenderStartNew(decode5, str);
            String decode6 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode6 == null) {
                decode6 = "";
            }
            pointTrackCreateRenderEndNew(decode6, str);
            String decode7 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode7 == null) {
                decode7 = "";
            }
            pointTrackLoadRenderFrameworkStartNew(decode7, str);
            String decode8 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode8 == null) {
                decode8 = "";
            }
            pointTrackLoadRenderFrameworkEndNew(decode8, str);
            String decode9 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode9 == null) {
                decode9 = "";
            }
            pointTrackCreateWorkerStartNew(decode9, str);
            String decode10 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode10 == null) {
                decode10 = "";
            }
            pointTrackCreateWorkerEndNew(decode10, str);
            String decode11 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode11 == null) {
                decode11 = "";
            }
            pointTrackLoadWorkerFrameworkStartNew(decode11, str);
            String decode12 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode12 == null) {
                decode12 = "";
            }
            pointTrackLoadWorkerFrameworkEndNew(decode12, str);
            String decode13 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode13 == null) {
                decode13 = "";
            }
            pointTrackMidStartNew(decode13, str);
            String decode14 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode14 == null) {
                decode14 = "";
            }
            pointTrackMidEndNew(decode14, str);
            String decode15 = UrlUtils.decode(String.valueOf(loadParams.url));
            if (decode15 != null) {
                str3 = decode15;
            }
            pointTrackDrawViewStartNew(str3, str);
            Page page2 = ((TmcFragment) this).page;
            if (page2 == null || (str2 = page2.getPageRandomIdByGAId()) == null) {
                str2 = "null";
            }
            loadingUrlStart(str2);
        } catch (Throwable unused) {
        }
    }

    private final void sendAppReadyToRender() {
        MiniAppBaseFragment.sendAppOrPageReadyToRender$default(this, "appReady", null, 2, null);
    }

    private final void sendPageReadyToRender() {
        MiniAppBaseFragment.sendAppOrPageReadyToRender$default(this, "pageReady", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPage$lambda$14(MiniShellFragment miniShellFragment, Page page) {
        Intrinsics.h(miniShellFragment, "this$0");
        Intrinsics.h(page, "$page");
        OooO00o oooO00o = miniShellFragment.binding;
        if ((oooO00o != null ? oooO00o.OooO00o : null) == null) {
            miniShellFragment.mPendingSetPage = page;
            return;
        }
        miniShellFragment.setLoadingUrl(String.valueOf(page.getPageURI()), true, String.valueOf(page.getPageId()));
        String valueOf = String.valueOf(page.getPageURI());
        String valueOf2 = String.valueOf(page.getPageId());
        PageChainContext pageChainContext = ((TmcFragment) miniShellFragment).pageChainContext;
        Intrinsics.g(pageChainContext, "pageChainContext");
        miniShellFragment.addPage("", "", valueOf, valueOf2, pageChainContext);
        miniShellFragment.pointTrackCreateContainerStartNew(String.valueOf(page.getPageURI()), String.valueOf(page.getPageId()));
        miniShellFragment.pointTrackCreateContainerEndNew(String.valueOf(page.getPageURI()), String.valueOf(page.getPageId()));
        miniShellFragment.pointTrackPageStart();
        miniShellFragment.setPageOnMain(page);
        try {
            App app = ((TmcFragment) miniShellFragment).app;
            if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                TmcLogger.d(TAG, "setMiniappLifecycleCallback");
                App app2 = ((TmcFragment) miniShellFragment).app;
                if (app2 != null) {
                    FragmentActivity activity = miniShellFragment.getActivity();
                    app2.setMiniappLifecycleCallback(activity instanceof MiniAppActivity ? (MiniAppActivity) activity : null);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final void setPageOnMain(final Page page) {
        try {
            ((TmcFragment) this).page = page;
            ((IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class)).start(((TmcFragment) this).app, String.valueOf(page != null ? page.getPageURI() : null));
            if (page != null) {
                FragmentActivity activity = getActivity();
                MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? (MiniAppActivity) activity : null;
                page.bindContext(this, Boolean.valueOf(miniAppActivity != null ? miniAppActivity.isFirstLaunch() : false), new Page.CreateRenderListener() { // from class: com.cloud.tmc.miniapp.ui.p1
                    public final void success() {
                        MiniShellFragment.setPageOnMain$lambda$20(page, this);
                    }
                });
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "setPageOnMain error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPageOnMain$lambda$20(Page page, final MiniShellFragment miniShellFragment) {
        AppModel appModel;
        Intrinsics.h(miniShellFragment, "this$0");
        boolean checkFullScreenAuthority = ((AuthorityProxy) TmcProxy.get(AuthorityProxy.class)).checkFullScreenAuthority(page);
        IRender render = page.getRender();
        if (render != null) {
            render.setSupportFullScreen(checkFullScreenAuthority);
        }
        IRender render2 = page.getRender();
        if (render2 != null) {
            render2.registerPageCallback(miniShellFragment);
        }
        IRender render3 = page.getRender();
        KeyEvent.Callback view = render3 != null ? render3.getView() : null;
        IWebView iWebView = view instanceof IWebView ? (IWebView) view : null;
        if (iWebView != null) {
            App app = ((TmcFragment) miniShellFragment).app;
            iWebView.setMiniAppType((app == null || (appModel = app.getAppModel()) == null) ? 0 : appModel.getAppinfoCategoryType());
        }
        IRender render4 = page.getRender();
        View view2 = render4 != null ? render4.getView() : null;
        WebView webView = view2 instanceof WebView ? (WebView) view2 : null;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        FragmentActivity activity = miniShellFragment.getActivity();
        if (activity != null) {
            OooO00o oooO00o = miniShellFragment.binding;
            FullScreenExtensionKt.addFullScreenJSIListener(miniShellFragment, page, oooO00o != null ? oooO00o.OooO0OO : null, activity, ((TmcFragment) miniShellFragment).app, miniShellFragment);
        }
        IRender render5 = page.getRender();
        if (render5 != null) {
            render5.registerICustomViewVisiable(new ICustomViewVisiable() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$setPageOnMain$1$2
                @Override // com.cloud.tmc.kernel.render.ICustomViewVisiable
                public void onHideCustomView() {
                    MiniShellFragment.this.isFullScreen().set(false);
                    MiniShellFragment.this.hideCustomView(false);
                }

                @Override // com.cloud.tmc.kernel.render.ICustomViewVisiable
                public void onShowCustomView(View view3, WebChromeClient.CustomViewCallback customViewCallback) {
                    MiniShellFragment.this.isFullScreen().set(true);
                    MiniShellFragment.this.showCustomView(view3, customViewCallback);
                }
            });
        }
        miniShellFragment.initView();
        miniShellFragment.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout;
        if (this.mCustomView != null) {
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            return;
        }
        this.mCustomView = view;
        OooO00o oooO00o = this.binding;
        if (oooO00o == null || (frameLayout = oooO00o.OooO0OO) == null) {
            return;
        }
        frameLayout.setVisibility(0);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.g(activity, "it");
            FullScreenExtensionKt.tryToProtrait(this, frameLayout, activity, ((TmcFragment) this).app);
        }
        frameLayout.addView(this.mCustomView, 0);
        View view2 = this.contextView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.y("contextView");
            view2 = null;
        }
        if (view2 != null) {
            View view4 = this.contextView;
            if (view4 == null) {
                Intrinsics.y("contextView");
            } else {
                view3 = view4;
            }
            this.mScrollY = view3.getScrollY();
        }
        this.mCustomViewCallback = customViewCallback;
    }

    private final void updateTitleBarStyle() {
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            page.hideHomeButton();
        }
        checkUpdateScreenButton();
        Page page2 = ((TmcFragment) this).page;
        if (page2 != null) {
            page2.setNavigationBarIconStyle(false);
        }
        OooO00o oooO00o = this.binding;
        ProgressBar progressBar = oooO00o != null ? oooO00o.OooO0o0 : null;
        if (progressBar == null) {
            return;
        }
        MiniAppConfigModel.WindowBean window = getWindow();
        progressBar.setTag(Boolean.valueOf(window != null ? Intrinsics.c(window.getEnableNavigationBarLoading(), Boolean.TRUE) : false));
    }

    public void changeNavigationBarProgress(final int i, final int i2, final long j) {
        ProgressBar progressBar;
        if (i > i2) {
            setNavigationBarProgressUpdating(false);
            return;
        }
        setNavigationBarProgressUpdating(true);
        OooO00o oooO00o = this.binding;
        if (oooO00o != null && (progressBar = oooO00o.OooO0o0) != null) {
            progressBar.postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.o1
                @Override // java.lang.Runnable
                public final void run() {
                    MiniShellFragment.changeNavigationBarProgress$lambda$18(MiniShellFragment.this, i, i2, j);
                }
            }, j);
        }
        onProgressChanged(null, i);
    }

    public final void checkUpdateScreenButton() {
    }

    @Override // com.cloud.tmc.kernel.debug.DebugCallback
    public void debugRefresh() {
        DebugConfig.DEBUG_REFRESH = true;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.i1
                @Override // java.lang.Runnable
                public final void run() {
                    MiniShellFragment.debugRefresh$lambda$28(MiniShellFragment.this);
                }
            });
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void destroy() {
        IRender render;
        IRender render2;
        IRender render3;
        IEventCenter iEventCenter = this.eventCenter;
        if (iEventCenter != null) {
            iEventCenter.unregister("consumeTime", this);
        }
        FullScreenExtensionKt.removeFullScreenJSIListener(this, ((TmcFragment) this).page);
        IScreenInspectProxy iScreenInspectProxy = (IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class);
        Page page = ((TmcFragment) this).page;
        App app = page != null ? page.getApp() : null;
        Page page2 = ((TmcFragment) this).page;
        iScreenInspectProxy.destroy(app, String.valueOf(page2 != null ? page2.getPageURI() : null));
        Page page3 = ((TmcFragment) this).page;
        if (page3 == null || (render2 = page3.getRender()) == null || !render2.fromWarmup()) {
            Page page4 = ((TmcFragment) this).page;
            if (page4 != null && (render = page4.getRender()) != null) {
                render.destroy();
            }
        } else {
            IInnerRenderPool iInnerRenderPool = (IInnerRenderPool) TmcProxy.get(IInnerRenderPool.class);
            Page page5 = ((TmcFragment) this).page;
            iInnerRenderPool.removeRender((page5 == null || (render3 = page5.getRender()) == null) ? null : render3.getRenderId());
            Object obj = TmcProxy.get(IInnerH5WebviewPool.class);
            Intrinsics.g(obj, "get(IInnerH5WebviewPool::class.java)");
            IInnerH5WebviewPool iInnerH5WebviewPool = (IInnerH5WebviewPool) obj;
            Page page6 = ((TmcFragment) this).page;
            IInnerH5WebviewPool.DefaultImpls.removeWebview$default(iInnerH5WebviewPool, page6 != null ? page6.getRender() : null, false, 2, (Object) null);
            OffScreenWebviewPool offScreenWebviewPool = OffScreenWebviewPool.INSTANCE;
            Page page7 = ((TmcFragment) this).page;
            offScreenWebviewPool.destroy(page7 != null ? page7.getRender() : null);
        }
        try {
            Page page8 = ((TmcFragment) this).page;
            App app2 = page8 != null ? page8.getApp() : null;
            if (app2 == null) {
                return;
            }
            app2.setLoadHtmlDataCallback((ILoadHtmlDataCallback) null);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    public Boolean exitFullScreen() {
        return Boolean.FALSE;
    }

    public ViewGroup getContentView() {
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            return oooO00o.OooO00o;
        }
        return null;
    }

    public String getCurrentPath() {
        IRender render;
        Page page = ((TmcFragment) this).page;
        KeyEvent.Callback view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        return getCurrentUrl(view instanceof WebView ? (WebView) view : null);
    }

    public final boolean getEnablePreRequest() {
        return this.enablePreRequest;
    }

    public ErrorView getErrorView() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final IEventCenter getEventCenter() {
        return this.eventCenter;
    }

    public final String getGlobalObjectScript(String str, JsonObject jsonObject) {
        Intrinsics.h(str, "key");
        Intrinsics.h(jsonObject, "jsonObject");
        return "(function() {window." + str + " = " + jsonObject + "; })();";
    }

    public LoadingView getLoadingView() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public PageContainer getPageContainer() {
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            return oooO00o.OooO0O0;
        }
        return null;
    }

    public ProgressBar getProgressBar() {
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            return oooO00o.OooO0o0;
        }
        return null;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public StatusLayout getStatusLayout() {
        return this.mStatusLayout;
    }

    public TabBar getTabBar() {
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            return oooO00o.OooO0o;
        }
        return null;
    }

    public TitleBar getTitleBar() {
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            return oooO00o.OooO0oO;
        }
        return null;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public Integer getViewThemeMode() {
        return 2;
    }

    public void hideNavigationBarLoading() {
        ProgressBar progressBar;
        OooO00o oooO00o = this.binding;
        ProgressBar progressBar2 = oooO00o != null ? oooO00o.OooO0o0 : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.FALSE);
        }
        OooO00o oooO00o2 = this.binding;
        if (oooO00o2 == null || (progressBar = oooO00o2.OooO0o0) == null) {
            return;
        }
        ViewExtKt.toGone(progressBar);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void initView() {
        String navigationBarTitleText;
        super.initView();
        MiniAppActivity activity = getActivity();
        String str = null;
        final MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        EntryInfo entryInfo = getEntryInfo();
        OooO00o oooO00o = this.binding;
        if (oooO00o != null) {
            ImmersiveTitleBarView immersiveTitleBarView = oooO00o.OooO0oO;
            immersiveTitleBarView.attachPage(((TmcFragment) this).page);
            MiniAppConfigModel.WindowBean window = getWindow();
            if (window != null && (navigationBarTitleText = window.getNavigationBarTitleText()) != null) {
                str = navigationBarTitleText;
            } else if (entryInfo != null) {
                str = entryInfo.title;
            }
            immersiveTitleBarView.setTitle(str);
            immersiveTitleBarView.setOnAddScreenClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.l1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.initView$lambda$7$lambda$5$lambda$2(MiniAppActivity.this, view);
                }
            });
            immersiveTitleBarView.setOnHomeClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.initView$lambda$7$lambda$5$lambda$3(MiniAppActivity.this, view);
                }
            });
            immersiveTitleBarView.setOnBackClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.n1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniShellFragment.initView$lambda$7$lambda$5$lambda$4(MiniShellFragment.this, view);
                }
            });
            TabBarView tabBarView = oooO00o.OooO0o;
            Intrinsics.g(tabBarView, "v");
            Page page = ((TmcFragment) this).page;
            ViewExtKt.toVisibleOrGone(tabBarView, page != null && page.isTabPage());
            Page page2 = ((TmcFragment) this).page;
            if (page2 != null && page2.isTabPage()) {
                TabBar.DefaultImpls.setTabs$default(tabBarView, MiniAppConfigUtils.getTabBar(getAppLoadResult()), ((TmcFragment) this).page, (String) null, 4, (Object) null);
            }
        }
        try {
            checkUpdateTitleBarStyle();
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public boolean isLoadStatusLoadingOrError() {
        return StatusAction.DefaultImpls.isLoadStatusLoadingOrError(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean loadHtmlData(IRender iRender, LoadParams loadParams) {
        String str;
        String str2;
        Intrinsics.h(loadParams, "loadParams");
        try {
            boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_SHELL_PRE_REQUEST, true);
            this.enablePreRequest = configTargetBool;
            if (configTargetBool) {
                String encryptMD5ToString = EncryptUtils.encryptMD5ToString(loadParams.url);
                TmcLogger.d(TAG, "md5 -> " + encryptMD5ToString);
                Context context = getContext();
                if (context != null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class);
                    Intrinsics.g(encryptMD5ToString, "md5");
                    str = preHtmStrategyProxy.getPreHtmlCache(context, encryptMD5ToString, 1, true);
                    if (str == null) {
                    }
                    str2 = str;
                    if (str2.length() > 0) {
                        return false;
                    }
                    Node page = iRender != null ? iRender.getPage() : null;
                    PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
                    String pageId = pageNode != null ? pageNode.getPageId() : null;
                    String str3 = pageId + "_" + getH5PageId().addAndGet(1);
                    recordPointBeforeLoadUrl(iRender, loadParams, str3);
                    this.typeLoadData = true;
                    setTrackPointLoadData(true);
                    String str4 = loadParams.url;
                    Intrinsics.g(str4, "loadParams.url");
                    this.baseUrl = str4;
                    if (iRender != null) {
                        iRender.loadDataWithBaseURL(loadParams, str2, "text/html", TmcConstants.DEFAULT_ENCODING, null);
                    }
                    TmcLogger.d(TAG, "use loadDataWithBaseURL -> url is " + loadParams.url);
                    PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class);
                    App app = ((TmcFragment) this).app;
                    performanceImprovesProxy.addPeroformanceImprove(app != null ? app.getAppId() : null, "preHtml");
                    recordPointAfterLoadUrl(iRender, loadParams, str3);
                    return true;
                }
                str = "";
                str2 = str;
                if (str2.length() > 0) {
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        return false;
    }

    public void loadUrl(IRender iRender, LoadParams loadParams) {
        Intrinsics.h(loadParams, "loadParams");
        Node page = iRender != null ? iRender.getPage() : null;
        PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
        String pageId = pageNode != null ? pageNode.getPageId() : null;
        String str = pageId + "_" + getH5PageId().addAndGet(1);
        recordPointBeforeLoadUrl(iRender, loadParams, str);
        if (iRender != null) {
            iRender.load(loadParams);
        }
        recordPointAfterLoadUrl(iRender, loadParams, str);
    }

    public Animation onCreateAnimation(int i, final boolean z, int i2) {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), i2);
            Intrinsics.g(loadAnimation, "loadAnimation(activity, nextAnim)");
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$onCreateAnimation$1
                /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
                
                    r2 = ((com.cloud.tmc.integration.ui.fragment.TmcFragment) r2).page;
                 */
                @Override // android.view.animation.Animation.AnimationListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onAnimationEnd(Animation animation) {
                    boolean z2;
                    AppLoadResult appLoadResult;
                    boolean isHomepage;
                    Page page;
                    Page page2;
                    Intrinsics.h(animation, "animation");
                    if (z) {
                        z2 = this.perEnterFlag;
                        if (z2) {
                            return;
                        }
                        MiniShellFragment miniShellFragment = this;
                        appLoadResult = miniShellFragment.getAppLoadResult();
                        isHomepage = miniShellFragment.isHomepage(appLoadResult);
                        if (isHomepage || page == null || page.isDestroyed()) {
                            return;
                        }
                        this.perEnterFlag = true;
                        page2 = ((TmcFragment) this).page;
                        if (page2 != null) {
                            page2.getApp();
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.h(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.h(animation, "animation");
                }
            });
            return loadAnimation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout attachToSwipeBack;
        Intrinsics.h(layoutInflater, "inflater");
        this.binding = OooO00o.OooO00o(layoutInflater);
        Page page = ((TmcFragment) this).page;
        if (page == null || !page.isTabPage()) {
            OooO00o oooO00o = this.binding;
            Intrinsics.e(oooO00o);
            ConstraintLayout constraintLayout = oooO00o.OooO00o;
            Intrinsics.g(constraintLayout, "binding!!.root");
            attachToSwipeBack = attachToSwipeBack(constraintLayout);
        } else {
            OooO00o oooO00o2 = this.binding;
            Intrinsics.e(oooO00o2);
            attachToSwipeBack = oooO00o2.OooO00o;
            Intrinsics.g(attachToSwipeBack, "binding!!.root");
        }
        this.mStatusLayout = (StatusLayout) attachToSwipeBack.findViewById(R.id.sl_status);
        ViewExtKt.removeSelf(attachToSwipeBack);
        return attachToSwipeBack;
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void onDestroy() {
        super.onDestroy();
        ((IMonitorWebviewManagerProxy) TmcProxy.get(IMonitorWebviewManagerProxy.class)).unRegisterMonitorListener(this);
        setExitType(TmcFragment.ExitType.BACK);
        pointTrackClear();
        pointTrackClearNew();
        destroySubscriber();
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void onDestroyView() {
        PageContainerView pageContainerView;
        super.onDestroyView();
        com.cloud.tmc.kernel.debug.a.c(this);
        OooO00o oooO00o = this.binding;
        if (oooO00o != null && (pageContainerView = oooO00o.OooO0O0) != null) {
            pageContainerView.removeAllViews();
        }
        this.binding = null;
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            ((EngineRouter) TmcProxy.get(EngineRouter.class)).unRegisterRender(page.getPageId());
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
    public boolean onEvent(IEvent iEvent) {
        Map<String, Object> data;
        if (iEvent == null) {
            return false;
        }
        try {
            String name = iEvent.getName();
            if (name == null) {
                return false;
            }
            Page page = ((TmcFragment) this).page;
            if (!name.equals(page != null ? page.getPageId() : null) || (data = iEvent.getData()) == null || !data.containsKey("eventData")) {
                return false;
            }
            Object obj = data.get("eventData");
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
            ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                Page page2 = ((TmcFragment) this).page;
                iCommunicationTimeProxy.plusTime(page2 != null ? page2.getPageId() : null, longValue);
                Page page3 = ((TmcFragment) this).page;
                iCommunicationTimeProxy.plusNum(page3 != null ? page3.getPageId() : null, 1);
            }
            return false;
        } catch (Exception unused) {
            TraceLog.i(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "parse consumeTime from EventCenter fail");
            return false;
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, com.cloud.tmc.miniapp.action.RefreshAction
    public void onLoadMoreEvent() {
        super.onLoadMoreEvent();
        TmcLogger.d("[MiniFragment]：onLoadMoreEvent");
        MiniAppBaseFragment.sendEventOrLifecycleToWorker$default(this, "onReachBottom", true, null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        App app;
        String appId;
        IRender render;
        IRender render2;
        checkUpdateTitleBarStyle();
        if (webView != null && webView.getProgress() == 100) {
            Page page = ((TmcFragment) this).page;
            View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
            injectJSFromConfig(view instanceof WebView ? (WebView) view : null, "pageFinished");
            Page page2 = ((TmcFragment) this).page;
            View view2 = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
            WebView webView2 = view2 instanceof WebView ? (WebView) view2 : null;
            if (webView2 != null) {
                Page page3 = ((TmcFragment) this).page;
                webView2.loadUrl("javascript:window.pageId=" + (page3 != null ? page3.getPageId() : null) + ";");
            }
            FullScreenExtensionKt.injectScreenFullJS(this);
            Page page4 = ((TmcFragment) this).page;
            if (page4 != null && (app = page4.getApp()) != null && (appId = app.getAppId()) != null) {
                ((IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
            }
            pointTrackPageFinishedNew(webView, str);
        }
        try {
            Integer viewThemeMode = getViewThemeMode();
            if (viewThemeMode != null) {
                z = true;
                if (viewThemeMode.intValue() == 1) {
                    setCapsuleStyle(z);
                }
            }
            z = false;
            setCapsuleStyle(z);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public void onPageStarted(WebView webView, String str) {
        App app;
        String appId;
        IRender render;
        try {
            Page page = ((TmcFragment) this).page;
            KeyEvent.Callback view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
            injectJSFromConfig(view instanceof WebView ? (WebView) view : null, "pageStart");
            if (this.typeLoadData || Intrinsics.c(this.baseUrl, str)) {
                Page page2 = ((TmcFragment) this).page;
                if (page2 != null && (app = page2.getApp()) != null && (appId = app.getAppId()) != null) {
                    TmcLogger.d(TAG, "load htmlData ,close loading page");
                    ((IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
                }
                this.typeLoadData = false;
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        redirectPageStarted(webView, str);
        pointTrackStartNew(webView, str);
        initDomLoadMonitor(2);
    }

    @Override // com.cloud.tmc.kernel.render.IPageEventCallback
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        App app;
        String appId;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        OooO00o oooO00o;
        ProgressBar progressBar4;
        ProgressBar progressBar5;
        ProgressBar progressBar6;
        OooO00o oooO00o2 = this.binding;
        boolean z = false;
        if ((oooO00o2 == null || (progressBar6 = oooO00o2.OooO0o0) == null) ? false : Intrinsics.c(progressBar6.getTag(), Boolean.FALSE)) {
            OooO00o oooO00o3 = this.binding;
            if (oooO00o3 != null && (progressBar5 = oooO00o3.OooO0o0) != null && ViewExtKt.getVisible(progressBar5)) {
                z = true;
            }
            if (!z || (oooO00o = this.binding) == null || (progressBar4 = oooO00o.OooO0o0) == null) {
                return;
            }
            ViewExtKt.toGone(progressBar4);
            return;
        }
        if (this.perfSendFlag) {
            this.perfSendFlag = false;
            OooO00o oooO00o4 = this.binding;
            if (oooO00o4 != null && (progressBar3 = oooO00o4.OooO0o0) != null) {
                ViewExtKt.toVisible(progressBar3);
            }
        }
        if (i == 0) {
            OooO00o oooO00o5 = this.binding;
            if (oooO00o5 != null && (progressBar = oooO00o5.OooO0o0) != null) {
                ViewExtKt.toVisible(progressBar);
            }
        } else if (i != 100) {
            OooO00o oooO00o6 = this.binding;
            ProgressBar progressBar7 = oooO00o6 != null ? oooO00o6.OooO0o0 : null;
            if (progressBar7 != null) {
                progressBar7.setProgress(i);
            }
        } else if (!this.perfSendFlag) {
            this.perfSendFlag = true;
            OooO00o oooO00o7 = this.binding;
            if (oooO00o7 != null && (progressBar2 = oooO00o7.OooO0o0) != null) {
                ViewExtKt.toGone(progressBar2);
            }
        }
        if (i == 100) {
            Page page = ((TmcFragment) this).page;
            if (page != null && (app = page.getApp()) != null && (appId = app.getAppId()) != null) {
                ((IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
            }
            MiniAppH5BaseFragment.ProgressStep progressStep = MiniAppH5BaseFragment.ProgressStep.STEP_100;
            updateProgressStep(progressStep);
            updateProgressStepNew(progressStep);
            loadingUrlFinish();
            pointTrackProgressChanged100New(webView);
            return;
        }
        pointTrackProgressChangedNew(webView, i);
        if (i >= 70) {
            MiniAppH5BaseFragment.ProgressStep progressStep2 = MiniAppH5BaseFragment.ProgressStep.STEP_70;
            updateProgressStep(progressStep2);
            updateProgressStepNew(progressStep2);
        } else if (i >= 50) {
            MiniAppH5BaseFragment.ProgressStep progressStep3 = MiniAppH5BaseFragment.ProgressStep.STEP_50;
            updateProgressStep(progressStep3);
            updateProgressStepNew(progressStep3);
        } else if (i >= 30) {
            MiniAppH5BaseFragment.ProgressStep progressStep4 = MiniAppH5BaseFragment.ProgressStep.STEP_30;
            updateProgressStep(progressStep4);
            updateProgressStepNew(progressStep4);
        } else {
            MiniAppH5BaseFragment.ProgressStep progressStep5 = MiniAppH5BaseFragment.ProgressStep.INIT;
            updateProgressStep(progressStep5);
            updateProgressStepNew(progressStep5);
        }
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest != null) {
            try {
                if (webResourceRequest.isForMainFrame()) {
                    loadingUrlError();
                    Object context = getContext();
                    MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                    long j = (miniAppActivity == null || !miniAppActivity.getDelayShowError()) ? 1L : 500L;
                    Object context2 = getContext();
                    MiniAppActivity miniAppActivity2 = context2 instanceof MiniAppActivity ? (MiniAppActivity) context2 : null;
                    if (miniAppActivity2 != null) {
                        miniAppActivity2.setDelayShowError(false);
                    }
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.j1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniShellFragment.onReceivedError$lambda$33(MiniShellFragment.this);
                        }
                    }, j);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // com.cloud.tmc.kernel.render.IPageEventCallback
    public /* synthetic */ void onReceivedIcon(Bitmap bitmap) {
        com.cloud.tmc.kernel.render.b.b(this, bitmap);
    }

    @Override // com.cloud.tmc.kernel.render.IPageEventCallback
    public /* synthetic */ void onReceivedTitle(String str) {
        com.cloud.tmc.kernel.render.b.c(this, str);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment, com.cloud.tmc.miniapp.action.RefreshAction
    public void onRefreshEvent() {
        super.onRefreshEvent();
        TmcLogger.d("[MiniFragment]：onRefreshEvent");
        MiniAppBaseFragment.sendEventOrLifecycleToWorker$default(this, "onPullDownRefresh", true, null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public Boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return Boolean.FALSE;
        }
        try {
            MiniAppActivity activity = getActivity();
            MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
            if (miniAppActivity != null) {
                miniAppActivity.refresh();
            }
        } catch (Throwable th) {
            TmcLogger.e("refresh fail!!,msg:" + th);
        }
        return Boolean.TRUE;
    }

    @Override // com.cloud.tmc.kernel.render.IPageEventCallback
    public /* synthetic */ void onRequestFocus() {
        com.cloud.tmc.kernel.render.b.d(this);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void onResume() {
        IRender render;
        super.onResume();
        if (this.needRefreshYCoordinate) {
            this.needRefreshYCoordinate = false;
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.a()), (CoroutineContext) null, (CoroutineStart) null, new MiniShellFragment$onResume$1(this, null), 3, (Object) null);
        }
        checkUpdateTitleBarStyle();
        Page page = ((TmcFragment) this).page;
        KeyEvent.Callback view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        ImageView imageView;
        App app;
        App app2;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, bundle);
        ((IMonitorWebviewManagerProxy) TmcProxy.get(IMonitorWebviewManagerProxy.class)).registerMonitorListener(this);
        PageChainContext pageChainContext = ((TmcFragment) this).pageChainContext;
        App app3 = ((TmcFragment) this).app;
        pageChainContext.setAppChainContext(app3 != null ? app3.getAppChainContext() : null);
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            page.setPageChainContext(((TmcFragment) this).pageChainContext);
        }
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(((TmcFragment) this).app);
        this.eventCenter = eventCenterInstance;
        if (eventCenterInstance != null) {
            eventCenterInstance.register("consumeTime", this);
        }
        createSubscriber();
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        Page page2 = ((TmcFragment) this).page;
        performanceAnalyseProxy.record((page2 == null || (app2 = page2.getApp()) == null) ? null : app2.getAppId(), PointAnalyseType.POINT_PAGE_CREATE, "");
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null && !miniAppActivity.isFirstLaunch()) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Page page3 = ((TmcFragment) this).page;
            performanceAnalyseProxy2.record((page3 == null || (app = page3.getApp()) == null) ? null : app.getAppId(), PointAnalyseType.POINT_PAGE_PV, "");
        }
        Page page4 = this.mPendingSetPage;
        if (page4 != null) {
            Intrinsics.e(page4);
            setPage(page4);
            this.mPendingSetPage = null;
        }
        showNavigationBarLoading();
        com.cloud.tmc.kernel.debug.a.a(this, this);
        OooO00o oooO00o = this.binding;
        if (oooO00o != null && (imageView = oooO00o.OooO0Oo) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.k1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MiniShellFragment.onViewCreated$lambda$1(MiniShellFragment.this, view2);
                }
            });
        }
        try {
            Page page5 = ((TmcFragment) this).page;
            App app4 = page5 != null ? page5.getApp() : null;
            if (app4 == null) {
                return;
            }
            app4.setLoadHtmlDataCallback(this);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    @Override // com.cloud.tmc.render.MonitorWebviewListener
    public void reportDomLoadTime(int i, String str) {
        Intrinsics.h(str, "uniqueId");
        if (i == 2) {
            updateDomContentLoaded();
        }
    }

    public void setCapsuleStyle(boolean z) {
        CapsuleView capsule;
        int i = !z ? 1 : 0;
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity == null || (capsule = miniAppActivity.getCapsule()) == null) {
            return;
        }
        CapsuleView.OooO00o(capsule, i, null, 2);
    }

    public final void setEnablePreRequest(boolean z) {
        this.enablePreRequest = z;
    }

    public final void setEventCenter(IEventCenter iEventCenter) {
        this.eventCenter = iEventCenter;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel loadingAnimationModel) {
        StatusAction.DefaultImpls.setLoadingProgressConfig(this, loadingAnimationModel);
    }

    public void setNavigationBarIconStyle(boolean z) {
        ImmersiveTitleBarView immersiveTitleBarView;
        int i = !z ? 1 : 0;
        OooO00o oooO00o = this.binding;
        if (oooO00o == null || (immersiveTitleBarView = oooO00o.OooO0oO) == null) {
            return;
        }
        immersiveTitleBarView.setThemeMode(i);
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public void setPage(final Page page) {
        AppModel appModel;
        ExtendModel extend;
        Intrinsics.h(page, "page");
        OooO00o oooO00o = this.binding;
        if ((oooO00o != null ? oooO00o.OooO00o : null) == null) {
            App app = page.getApp();
            String h5Url = (app == null || (appModel = app.getAppModel()) == null || (extend = appModel.getExtend()) == null) ? null : extend.getH5Url();
            App app2 = page.getApp();
            String generateShellUrl = KUrlUtils.generateShellUrl(h5Url, app2 != null ? app2.getStartParams() : null);
            if (h5Url != null) {
                getUrlMap().put(h5Url, generateShellUrl);
            }
            PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
            if (pageNode != null) {
                pageNode.setPageURI(generateShellUrl);
            }
        }
        ((TmcFragment) this).page = page;
        App bubbleFindNode = page.bubbleFindNode(App.class);
        ((TmcFragment) this).app = bubbleFindNode;
        if (bubbleFindNode != null) {
            Page page2 = ((TmcFragment) this).page;
            String pageURI = page2 != null ? page2.getPageURI() : null;
            if (pageURI == null) {
                pageURI = "";
            }
            bubbleFindNode.putPageType(pageURI, 2);
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.h1
            @Override // java.lang.Runnable
            public final void run() {
                MiniShellFragment.setPage$lambda$14(MiniShellFragment.this, page);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.base.MiniAppBaseFragment
    public boolean shouldInterceptOnKeyDown() {
        IRender render;
        Page page = ((TmcFragment) this).page;
        KeyEvent.Callback view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        return canGoBack(view instanceof WebView ? (WebView) view : null);
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        Uri url2;
        Intent intent;
        redirectShouldOverrideUrlLoading(webView, webResourceRequest);
        pointTrackShouldOverrideUrlLoadingNew(webView, webResourceRequest);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (webResourceRequest != null && (url2 = webResourceRequest.getUrl()) != null) {
            String uri2 = url2.toString();
            Intrinsics.g(uri2, "it.toString()");
            boolean z = false;
            if (!StringsKt.W(uri2, "http", false, 2, (Object) null)) {
                try {
                    Object fromJson = new Gson().fromJson(((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_SHELL_SCHEME_FILTER, "[\"whatsapp\",\"sms\",\"tel\"]"), List.class);
                    List list = fromJson instanceof List ? (List) fromJson : null;
                    if (list != null && CollectionsKt.b0(list, url2.getScheme())) {
                        if ("intent".equals(url2.getScheme())) {
                            intent = Intent.parseUri(url2.toString(), 1);
                            Intrinsics.g(intent, "parseUri(it.toString(), Intent.URI_INTENT_SCHEME)");
                        } else {
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(url2.toString()));
                            intent.setFlags(805306368);
                        }
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            activity.startActivity(intent);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Boolean.TRUE;
            }
            MiniShellUtils miniShellUtils = MiniShellUtils.INSTANCE;
            App app = ((TmcFragment) this).app;
            String uri3 = url2.toString();
            Intrinsics.g(uri3, "it.toString()");
            boolean checkJumpUrlWhitelist = miniShellUtils.checkJumpUrlWhitelist(app, uri3);
            TmcLogger.d(TAG, "是否支持内部打开：" + checkJumpUrlWhitelist);
            if (!checkJumpUrlWhitelist) {
                try {
                    String configString = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_SHELL_PATH_FILTER, "[]");
                    Intrinsics.g(configString, "shellPathFilterConfig");
                    Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.ui.MiniShellFragment$shouldOverrideUrlLoading$1$shellPathFilter$1
                    }.getType();
                    Intrinsics.g(type, "object :\n               …ayList<String>>() {}.type");
                    ArrayList arrayList = (ArrayList) TmcGsonUtils.fromJson(configString, type);
                    String host = url2.getHost();
                    String str = url2.getScheme() + "://" + url2.getHost() + url2.getPath();
                    String currentUrl = getCurrentUrl(webView);
                    String str2 = "";
                    if (currentUrl == null) {
                        currentUrl = "";
                    }
                    try {
                        str2 = Uri.parse(currentUrl).getHost();
                    } catch (Throwable th) {
                        TmcLogger.e(TAG, th);
                    }
                    if (!arrayList.contains(str)) {
                        if (!Intrinsics.c(str2, host)) {
                        }
                    }
                    Context context = getContext();
                    if (context != null) {
                        EnvironmentUtil.Companion companion = EnvironmentUtil.Companion;
                        Intrinsics.g(context, "context");
                        z = companion.openByBrowser(context, url2.toString());
                    }
                    booleanRef.element = z;
                } catch (Throwable th2) {
                    TmcLogger.e(TAG, th2);
                }
            }
        }
        if (booleanRef.element) {
            return Boolean.TRUE;
        }
        String currentUrl2 = getCurrentUrl(webView);
        if (currentUrl2 == null) {
            return Boolean.FALSE;
        }
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null) {
            return Boolean.FALSE;
        }
        redirect(currentUrl2, uri);
        return Boolean.FALSE;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public boolean showComplete() {
        return StatusAction.DefaultImpls.showComplete(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showCustomErrorLayout(String str, String str2, String str3, StatusLayout.OooO0O0 oooO0O0, String str4, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showCustomErrorLayout(this, str, str2, str3, oooO0O0, str4, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showError(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showError(this, oooO0O0, i, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(int i, int i2, int i3, StatusLayout.OooO0O0 oooO0O0, boolean z, boolean z2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, i, i2, i3, oooO0O0, z, z2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(int i, int i2, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, i, i2, oooO0O0, str, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, drawable, charSequence, oooO0O0, str, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.OooO0O0 oooO0O0, String str, boolean z, boolean z2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showErrorLayout(this, drawable, charSequence, charSequence2, oooO0O0, str, z, z2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showLoading() {
        StatusAction.DefaultImpls.showLoading(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showLoadingLogo(String str, String str2) {
        StatusAction.DefaultImpls.showLoadingLogo(this, str, str2);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showMainLayoutAlpha(float f) {
        StatusAction.DefaultImpls.showMainLayoutAlpha(this, f);
    }

    public void showNavigationBarLoading() {
        ProgressBar progressBar;
        OooO00o oooO00o = this.binding;
        ProgressBar progressBar2 = oooO00o != null ? oooO00o.OooO0o0 : null;
        if (progressBar2 != null) {
            progressBar2.setTag(Boolean.TRUE);
        }
        OooO00o oooO00o2 = this.binding;
        if (oooO00o2 == null || (progressBar = oooO00o2.OooO0o0) == null) {
            return;
        }
        ViewExtKt.toVisible(progressBar);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showNoNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showNoNetwork(this, oooO0O0, i, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showPhotoEmpty(int i, int i2, StatusLayout.OooO0O0 oooO0O0) {
        StatusAction.DefaultImpls.showPhotoEmpty(this, i, i2, oooO0O0);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showUnstableNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showUnstableNetwork(this, oooO0O0, i, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.VersionUpdateAction
    public void showUpgradeHintView(String str, Integer num) {
        VersionUpdateAction.DefaultImpls.showUpgradeHintView(this, str, num);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        StatusAction.DefaultImpls.statusLayoutCreateShortCutsSuccess(this, str, function3);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutOnResume() {
        StatusAction.DefaultImpls.statusLayoutOnResume(this);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void updateStepAnimation(LoadStepAction loadStepAction) {
        StatusAction.DefaultImpls.updateStepAnimation(this, loadStepAction);
    }
}
