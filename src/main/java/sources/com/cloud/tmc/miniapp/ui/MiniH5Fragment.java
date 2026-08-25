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
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
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
import com.cloud.tmc.integration.utils.AbilitiesUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniAppConfigUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEvent;
import com.cloud.tmc.kernel.debug.DebugCallback;
import com.cloud.tmc.kernel.debug.DebugConfig;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.render.ICustomViewVisiable;
import com.cloud.tmc.kernel.render.IPageCallback;
import com.cloud.tmc.kernel.render.IPageEventCallback;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.render.LoadParams;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
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
import com.cloud.tmc.render.method.HybridPageJsInterface;
import com.cloud.tmc.render.system.ShellWebView;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniH5Fragment extends MiniAppH5BaseFragment implements IPageEventCallback, IPageCallback, DebugCallback, IEventSubscriber, StatusAction, VersionUpdateAction {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MiniH5Fragment";
    private OooO00o binding;
    private View contextView;
    private boolean enablePreRequest;
    private IEventCenter eventCenter;
    private boolean isSendPageEnter;
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
    private final Lazy mHandler$delegate = LazyKt.b(new Function0<Handler>() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$mHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m75invoke() {
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
    public static final void changeNavigationBarProgress$lambda$18(MiniH5Fragment miniH5Fragment, int i, int i2, long j) {
        Intrinsics.h(miniH5Fragment, "this$0");
        miniH5Fragment.changeNavigationBarProgress(i + 1, i2, j);
    }

    private final void checkUpdateTitleBarStyle() {
        try {
            Page page = ((TmcFragment) this).page;
            if (page == null || !page.isShow()) {
                return;
            }
            updateTitleBarStyle();
            checkUpdateScreenButton();
        } catch (Throwable unused) {
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
    public static final void debugRefresh$lambda$28(final MiniH5Fragment miniH5Fragment) {
        JSI jsi;
        IRender render;
        App app;
        IRender render2;
        App app2;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app3;
        IEngine engineProxy2;
        Intrinsics.h(miniH5Fragment, "this$0");
        MiniAppActivity activity = miniH5Fragment.getActivity();
        String str = null;
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null) {
            miniAppActivity.setFirstLaunch(true);
        }
        Page page = ((TmcFragment) miniH5Fragment).page;
        if (page == null || (app2 = page.getApp()) == null || (engineProxy = app2.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            jsi = null;
        } else {
            Page page2 = ((TmcFragment) miniH5Fragment).page;
            jsi = engineRouter.getWorkerById((page2 == null || (app3 = page2.getApp()) == null || (engineProxy2 = app3.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (jsi != null) {
            jsi.debugRefresh();
        }
        Page page3 = ((TmcFragment) miniH5Fragment).page;
        View view = (page3 == null || (render2 = page3.getRender()) == null) ? null : render2.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        }
        if (miniH5Fragment.getAppLoadResult() != null) {
            final IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(((TmcFragment) miniH5Fragment).app);
            if (eventCenterInstance != null) {
                eventCenterInstance.register("renderOnMessageReady", new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$debugRefresh$1$1$1
                    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                    public boolean onEvent(IEvent iEvent) {
                        Page page4;
                        Page page5;
                        WebviewBridgeHelper webviewBridgeHelper;
                        IRender render3;
                        IRender render4;
                        page4 = ((TmcFragment) MiniH5Fragment.this).page;
                        if (!StringsKt.I((page4 == null || (render4 = page4.getRender()) == null) ? null : render4.getRenderId(), iEvent != null ? iEvent.getRenderId() : null, false, 2, (Object) null)) {
                            return false;
                        }
                        page5 = ((TmcFragment) MiniH5Fragment.this).page;
                        KeyEvent.Callback view2 = (page5 == null || (render3 = page5.getRender()) == null) ? null : render3.getView();
                        ShellWebView shellWebView = view2 instanceof ShellWebView ? (ShellWebView) view2 : null;
                        if (shellWebView != null && (webviewBridgeHelper = shellWebView.getWebviewBridgeHelper()) != null) {
                            webviewBridgeHelper.registerMessageChannel();
                        }
                        MiniH5Fragment.this.openPage();
                        eventCenterInstance.unregister("renderOnMessageReady", this);
                        return true;
                    }
                });
            }
            LoadParams loadParams = new LoadParams();
            Page page4 = ((TmcFragment) miniH5Fragment).page;
            loadParams.url = page4 != null ? page4.getPagePath() : null;
            Page page5 = ((TmcFragment) miniH5Fragment).page;
            loadParams.pagePath = page5 != null ? page5.getPagePath() : null;
            Page page6 = ((TmcFragment) miniH5Fragment).page;
            if (page6 != null && (app = page6.getApp()) != null) {
                str = app.getAppId();
            }
            loadParams.appId = str;
            Page page7 = ((TmcFragment) miniH5Fragment).page;
            if (page7 == null || (render = page7.getRender()) == null) {
                return;
            }
            render.load(loadParams);
        }
    }

    private final String generateShellUrl(String str) {
        Bundle startParams;
        String string;
        if (str == null) {
            return "";
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        String str2 = query == null ? "" : query;
        Intrinsics.g(str2, "uri.query ?: \"\"");
        List S0 = StringsKt.S0(str2, new String[]{UrlUtils.AND_MARK}, false, 0, 6, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = S0.size();
        for (int i = 0; i < size; i++) {
            List S02 = StringsKt.S0((CharSequence) S0.get(i), new String[]{UrlUtils.EQUAL_MARK}, false, 0, 6, (Object) null);
            if (S02.size() == 2) {
                linkedHashMap.put((String) S02.get(0), (String) S02.get(1));
            }
        }
        Page page = ((TmcFragment) this).page;
        String str3 = (page == null || (startParams = page.getStartParams()) == null || (string = startParams.getString("query")) == null) ? "" : string;
        Intrinsics.g(str3, "page?.startParams?.getSt…Activity.KEY_QUERY) ?: \"\"");
        List S03 = StringsKt.S0(str3, new String[]{UrlUtils.AND_MARK}, false, 0, 6, (Object) null);
        int size2 = S03.size();
        for (int i2 = 0; i2 < size2; i2++) {
            List S04 = StringsKt.S0((CharSequence) S03.get(i2), new String[]{UrlUtils.EQUAL_MARK}, false, 0, 6, (Object) null);
            if (S04.size() == 2) {
                linkedHashMap.put((String) S04.get(0), (String) S04.get(1));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String uri = buildUpon.build().toString();
        Intrinsics.g(uri, "newUri.build().toString()");
        return uri;
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
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.a()), (CoroutineContext) null, (CoroutineStart) null, new MiniH5Fragment$hideCustomView$1(this, null), 3, (Object) null);
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
            miniAppActivity.hideStatusLoading();
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
    public static final void initView$lambda$7$lambda$5$lambda$3(MiniH5Fragment miniH5Fragment, MiniAppActivity miniAppActivity, View view) {
        Intrinsics.h(miniH5Fragment, "this$0");
        miniH5Fragment.checkBackToPageInterceptAndRemoveIt();
        if (miniAppActivity != null) {
            miniAppActivity.goHome();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5$lambda$4(MiniH5Fragment miniH5Fragment, MiniAppActivity miniAppActivity, View view) {
        ActivityHelper mActivityHelper;
        App app;
        IRender render;
        Intrinsics.h(miniH5Fragment, "this$0");
        Page page = ((TmcFragment) miniH5Fragment).page;
        KeyEvent.Callback view2 = (page == null || (render = page.getRender()) == null) ? null : render.getView();
        if (miniH5Fragment.canGoBack(view2 instanceof WebView ? (WebView) view2 : null) || miniAppActivity == null || (mActivityHelper = miniAppActivity.getMActivityHelper()) == null || (app = mActivityHelper.getApp()) == null) {
            return;
        }
        app.backPressed();
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0292 A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:196:0x01ae, B:91:0x01b7, B:93:0x01bb, B:96:0x01c9, B:99:0x01d1, B:101:0x01dd, B:102:0x01e3, B:104:0x01e7, B:106:0x01ed, B:107:0x01f7, B:109:0x021b, B:111:0x0221, B:113:0x0227, B:115:0x023b, B:116:0x0241, B:118:0x0244, B:120:0x024c, B:121:0x0252, B:171:0x0259, B:173:0x026a, B:175:0x0276, B:179:0x028c, B:181:0x0292, B:183:0x02a0, B:184:0x02aa, B:186:0x02c8, B:187:0x02ce, B:190:0x02d4, B:193:0x02da), top: B:195:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void injectRenderFramework(IRender iRender, App app) {
        String str;
        View view;
        JSI jsi;
        App app2;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app3;
        IEngine engineProxy2;
        IRender render;
        String str2;
        String str3;
        IRender render2;
        View view2;
        LoadParams loadParams = new LoadParams();
        Page page = ((TmcFragment) this).page;
        loadParams.url = page != null ? page.getPagePath() : null;
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
        String valueOf = String.valueOf(page3 != null ? page3.getPagePath() : null);
        Page page4 = ((TmcFragment) this).page;
        pointTrackLoadRenderFrameworkStartNew(valueOf, String.valueOf(page4 != null ? page4.getPageId() : null));
        Page page5 = ((TmcFragment) this).page;
        String valueOf2 = String.valueOf(page5 != null ? page5.getPagePath() : null);
        Page page6 = ((TmcFragment) this).page;
        pointTrackLoadRenderFrameworkEndNew(valueOf2, String.valueOf(page6 != null ? page6.getPageId() : null));
        Page page7 = ((TmcFragment) this).page;
        String valueOf3 = String.valueOf(page7 != null ? page7.getPagePath() : null);
        Page page8 = ((TmcFragment) this).page;
        pointTrackCreateWorkerStartNew(valueOf3, String.valueOf(page8 != null ? page8.getPageId() : null));
        Page page9 = ((TmcFragment) this).page;
        String valueOf4 = String.valueOf(page9 != null ? page9.getPagePath() : null);
        Page page10 = ((TmcFragment) this).page;
        pointTrackCreateWorkerEndNew(valueOf4, String.valueOf(page10 != null ? page10.getPageId() : null));
        Page page11 = ((TmcFragment) this).page;
        String valueOf5 = String.valueOf(page11 != null ? page11.getPagePath() : null);
        Page page12 = ((TmcFragment) this).page;
        pointTrackLoadWorkerFrameworkStartNew(valueOf5, String.valueOf(page12 != null ? page12.getPageId() : null));
        Page page13 = ((TmcFragment) this).page;
        String valueOf6 = String.valueOf(page13 != null ? page13.getPagePath() : null);
        Page page14 = ((TmcFragment) this).page;
        pointTrackLoadWorkerFrameworkEndNew(valueOf6, String.valueOf(page14 != null ? page14.getPageId() : null));
        Page page15 = ((TmcFragment) this).page;
        String valueOf7 = String.valueOf(page15 != null ? page15.getPagePath() : null);
        Page page16 = ((TmcFragment) this).page;
        pointTrackMidStartNew(valueOf7, String.valueOf(page16 != null ? page16.getPageId() : null));
        Page page17 = ((TmcFragment) this).page;
        String valueOf8 = String.valueOf(page17 != null ? page17.getPagePath() : null);
        Page page18 = ((TmcFragment) this).page;
        pointTrackMidEndNew(valueOf8, String.valueOf(page18 != null ? page18.getPageId() : null));
        Page page19 = ((TmcFragment) this).page;
        String valueOf9 = String.valueOf(page19 != null ? page19.getPagePath() : null);
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
            TmcLogger.d("nevermore", "load url H5");
            boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_SHARP_NEWS_PRE_REQUEST, true);
            this.enablePreRequest = configTargetBool;
            if (configTargetBool) {
                String encryptMD5ToString = EncryptUtils.encryptMD5ToString(loadParams.url);
                Context context2 = getContext();
                if (context2 != null) {
                    str2 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context2, TmcConstants.KEY_LATEST_SYNC_SHARPNEWS, encryptMD5ToString);
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
                    } else if (iRender != null) {
                        iRender.load(loadParams);
                    }
                }
                str2 = "";
                str3 = str2;
                if (str3.length() <= 0) {
                }
            } else if (iRender != null) {
                iRender.load(loadParams);
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
        initDomLoadMonitor(1);
        Page page24 = ((TmcFragment) this).page;
        if (page24 == null || (app2 = page24.getApp()) == null || (engineProxy = app2.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            jsi = null;
        } else {
            Page page25 = ((TmcFragment) this).page;
            jsi = engineRouter.getWorkerById((page25 == null || (app3 = page25.getApp()) == null || (engineProxy2 = app3.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if ((jsi != null ? Intrinsics.c(jsi.firstGetPackageFileStatus(), Boolean.TRUE) : false) && !this.isSendPageEnter) {
            this.isSendPageEnter = true;
            MiniAppBaseFragment.sendPageEnterToWorker$default(this, null, 1, null);
        }
        Page page26 = ((TmcFragment) this).page;
        String valueOf11 = String.valueOf(page26 != null ? page26.getPagePath() : null);
        Page page27 = ((TmcFragment) this).page;
        pointTrackDrawViewEndForApp(valueOf11, String.valueOf(page27 != null ? page27.getPageId() : null), this.typeLoadData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MiniH5Fragment miniH5Fragment, View view) {
        Intrinsics.h(miniH5Fragment, "this$0");
        miniH5Fragment.hideCustomView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPage() {
        JSI jsi;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        App app2;
        IEngine engineProxy2;
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null && miniAppActivity.isFirstLaunch()) {
            sendAppReadyToRender();
            FragmentActivity activity2 = getActivity();
            App app3 = activity2 instanceof MiniAppActivity ? (MiniAppActivity) activity2 : null;
            if (app3 == null) {
                return;
            }
            app3.setFirstLaunch(false);
            return;
        }
        sendPageReadyToRender();
        Page page = ((TmcFragment) this).page;
        if (page == null || (app = page.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null) {
            jsi = null;
        } else {
            Page page2 = ((TmcFragment) this).page;
            jsi = engineRouter.getWorkerById((page2 == null || (app2 = page2.getApp()) == null || (engineProxy2 = app2.getEngineProxy()) == null) ? null : engineProxy2.getWorkerId());
        }
        if (jsi != null ? Intrinsics.c(jsi.firstGetPackageFileStatus(), Boolean.TRUE) : false) {
            MiniAppBaseFragment.sendPageEnterToWorker$default(this, null, 1, null);
            return;
        }
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
        Page page3 = ((TmcFragment) this).page;
        IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(page3 != null ? page3.getApp() : null);
        if (eventCenterInstance != null) {
            eventCenterInstance.register(WorkerManager.INSTANCE.getEVENT_RESEND_PAGE_ENTER(), new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$openPage$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent iEvent) {
                    MiniAppBaseFragment.sendPageEnterToWorker$default(MiniH5Fragment.this, null, 1, null);
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
            eventCenterInstance.register("renderOnMessageReady", new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$prePage$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent iEvent) {
                    Page page2;
                    IRender render2;
                    page2 = ((TmcFragment) MiniH5Fragment.this).page;
                    if (!StringsKt.I((page2 == null || (render2 = page2.getRender()) == null) ? null : render2.getRenderId(), iEvent != null ? iEvent.getRenderId() : null, false, 2, (Object) null)) {
                        return false;
                    }
                    MiniH5Fragment.this.openPage();
                    eventCenterInstance.unregister("renderOnMessageReady", this);
                    return true;
                }
            });
        }
    }

    private final void sendAppReadyToRender() {
        MiniAppBaseFragment.sendAppOrPageReadyToRender$default(this, "appReady", null, 2, null);
    }

    private final void sendPageReadyToRender() {
        MiniAppBaseFragment.sendAppOrPageReadyToRender$default(this, "pageReady", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPage$lambda$13(MiniH5Fragment miniH5Fragment, Page page) {
        Intrinsics.h(miniH5Fragment, "this$0");
        Intrinsics.h(page, "$page");
        OooO00o oooO00o = miniH5Fragment.binding;
        if ((oooO00o != null ? oooO00o.OooO00o : null) == null) {
            miniH5Fragment.mPendingSetPage = page;
            return;
        }
        miniH5Fragment.setLoadingUrl(String.valueOf(page.getPagePath()), true, String.valueOf(page.getPageId()));
        String valueOf = String.valueOf(page.getPagePath());
        String valueOf2 = String.valueOf(page.getPageId());
        PageChainContext pageChainContext = ((TmcFragment) miniH5Fragment).pageChainContext;
        Intrinsics.g(pageChainContext, "pageChainContext");
        miniH5Fragment.addPage("", "", valueOf, valueOf2, pageChainContext);
        miniH5Fragment.pointTrackCreateContainerStartNew(String.valueOf(page.getPagePath()), String.valueOf(page.getPageId()));
        miniH5Fragment.pointTrackCreateContainerEndNew(String.valueOf(page.getPagePath()), String.valueOf(page.getPageId()));
        miniH5Fragment.pointTrackPageStart();
        miniH5Fragment.setPageOnMain(page);
        try {
            App app = ((TmcFragment) miniH5Fragment).app;
            if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                TmcLogger.d(TAG, "setMiniappLifecycleCallback");
                App app2 = ((TmcFragment) miniH5Fragment).app;
                if (app2 != null) {
                    FragmentActivity activity = miniH5Fragment.getActivity();
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
            ((IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class)).start(((TmcFragment) this).app, String.valueOf(page != null ? page.getPagePath() : null));
            if (page != null) {
                FragmentActivity activity = getActivity();
                MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? (MiniAppActivity) activity : null;
                page.bindContext(this, Boolean.valueOf(miniAppActivity != null ? miniAppActivity.isFirstLaunch() : false), new Page.CreateRenderListener() { // from class: com.cloud.tmc.miniapp.ui.y0
                    public final void success() {
                        MiniH5Fragment.setPageOnMain$lambda$20(page, this);
                    }
                });
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "setPageOnMain error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPageOnMain$lambda$20(Page page, final MiniH5Fragment miniH5Fragment) {
        IRender render;
        IRender render2;
        IRender render3;
        IRender render4;
        Intrinsics.h(miniH5Fragment, "this$0");
        if (page != null && (render4 = page.getRender()) != null) {
            render4.registerPageCallback(miniH5Fragment);
        }
        View view = (page == null || (render3 = page.getRender()) == null) ? null : render3.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        View view2 = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
        WebView webView2 = view2 instanceof WebView ? (WebView) view2 : null;
        if (webView2 != null) {
            webView2.addJavascriptInterface(new HybridPageJsInterface(), "dlthp");
        }
        FragmentActivity activity = miniH5Fragment.getActivity();
        if (activity != null) {
            OooO00o oooO00o = miniH5Fragment.binding;
            FullScreenExtensionKt.addFullScreenJSIListener(miniH5Fragment, page, oooO00o != null ? oooO00o.OooO0OO : null, activity, ((TmcFragment) miniH5Fragment).app, miniH5Fragment);
        }
        if (page != null && (render = page.getRender()) != null) {
            render.registerICustomViewVisiable(new ICustomViewVisiable() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$setPageOnMain$1$2
                @Override // com.cloud.tmc.kernel.render.ICustomViewVisiable
                public void onHideCustomView() {
                    MiniH5Fragment.this.isFullScreen().set(false);
                    MiniH5Fragment.this.hideCustomView(false);
                }

                @Override // com.cloud.tmc.kernel.render.ICustomViewVisiable
                public void onShowCustomView(View view3, WebChromeClient.CustomViewCallback customViewCallback) {
                    MiniH5Fragment.this.isFullScreen().set(true);
                    MiniH5Fragment.this.showCustomView(view3, customViewCallback);
                }
            });
        }
        miniH5Fragment.initView();
        miniH5Fragment.init();
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
        try {
            Page page = ((TmcFragment) this).page;
            if (page != null) {
                page.setNavigationBarTitleVisible(false);
            }
            Page page2 = ((TmcFragment) this).page;
            if (page2 != null) {
                page2.showHomeButton();
            }
            Page page3 = ((TmcFragment) this).page;
            if (page3 != null) {
                page3.setHomeAction(MiniAppConfigUtils.navigationBarAction("all"), true);
            }
            checkUpdateScreenButton();
            Page page4 = ((TmcFragment) this).page;
            if (page4 != null) {
                page4.setNavigationBarIconStyle(false);
            }
            Page page5 = ((TmcFragment) this).page;
            if (page5 != null) {
                page5.setNavigationBarTitleColor(false);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
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
            progressBar.postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.e1
                @Override // java.lang.Runnable
                public final void run() {
                    MiniH5Fragment.changeNavigationBarProgress$lambda$18(MiniH5Fragment.this, i, i2, j);
                }
            }, j);
        }
        onProgressChanged(null, i);
    }

    public final void checkUpdateScreenButton() {
        boolean z;
        App app = ((TmcFragment) this).app;
        if (app != null) {
            AbilitiesUtils abilitiesUtils = AbilitiesUtils.INSTANCE;
            String appId = app.getAppId();
            Intrinsics.g(appId, "it.appId");
            z = abilitiesUtils.getAbilityEnableStatus(appId, TmcConstants.MENU_KEY_TITLE_BAR_ADD_HOME);
        } else {
            z = true;
        }
        Page page = ((TmcFragment) this).page;
        String stringValue = page != null ? page.getStringValue(TmcConstants.KEY_IS_API_ADD_SCREEN_ENABLED) : null;
        if (Intrinsics.c(stringValue, "showAddScreenButton")) {
            if (z) {
                Page page2 = ((TmcFragment) this).page;
                if (page2 != null) {
                    page2.showAddScreenButton();
                    return;
                }
                return;
            }
            Page page3 = ((TmcFragment) this).page;
            if (page3 != null) {
                page3.hideAddScreenButton();
                return;
            }
            return;
        }
        if (Intrinsics.c(stringValue, "hideAddScreenButton")) {
            Page page4 = ((TmcFragment) this).page;
            if (page4 != null) {
                page4.hideAddScreenButton();
                return;
            }
            return;
        }
        if (z) {
            Page page5 = ((TmcFragment) this).page;
            if (page5 != null) {
                page5.showAddScreenButton();
                return;
            }
            return;
        }
        Page page6 = ((TmcFragment) this).page;
        if (page6 != null) {
            page6.hideAddScreenButton();
        }
    }

    @Override // com.cloud.tmc.kernel.debug.DebugCallback
    public void debugRefresh() {
        DebugConfig.DEBUG_REFRESH = true;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.d1
                @Override // java.lang.Runnable
                public final void run() {
                    MiniH5Fragment.debugRefresh$lambda$28(MiniH5Fragment.this);
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
        iScreenInspectProxy.destroy(app, String.valueOf(page2 != null ? page2.getPagePath() : null));
        Page page3 = ((TmcFragment) this).page;
        if (page3 == null || (render2 = page3.getRender()) == null || !render2.fromWarmup()) {
            Page page4 = ((TmcFragment) this).page;
            if (page4 == null || (render = page4.getRender()) == null) {
                return;
            }
            render.destroy();
            return;
        }
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
            immersiveTitleBarView.setOnAddScreenClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniH5Fragment.initView$lambda$7$lambda$5$lambda$2(MiniAppActivity.this, view);
                }
            });
            immersiveTitleBarView.setOnHomeClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniH5Fragment.initView$lambda$7$lambda$5$lambda$3(MiniH5Fragment.this, miniAppActivity, view);
                }
            });
            immersiveTitleBarView.setOnBackClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniH5Fragment.initView$lambda$7$lambda$5$lambda$4(MiniH5Fragment.this, miniAppActivity, view);
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

    public final boolean isSendPageEnter() {
        return this.isSendPageEnter;
    }

    public Animation onCreateAnimation(int i, final boolean z, int i2) {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), i2);
            Intrinsics.g(loadAnimation, "loadAnimation(activity, nextAnim)");
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$onCreateAnimation$1
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
                        MiniH5Fragment miniH5Fragment = this;
                        appLoadResult = miniH5Fragment.getAppLoadResult();
                        isHomepage = miniH5Fragment.isHomepage(appLoadResult);
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
            IRender render = page.getRender();
            if (render != null) {
                render.destroy();
            }
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
        IRender render;
        IRender render2;
        try {
            Page page = ((TmcFragment) this).page;
            View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
            injectJSFromConfig(view instanceof WebView ? (WebView) view : null, "pageStart");
            if (this.typeLoadData || Intrinsics.c(this.baseUrl, str)) {
                Page page2 = ((TmcFragment) this).page;
                String str2 = "javascript:localStorage.setItem('pageUrl','" + (page2 != null ? page2.getPagePath() : null) + "');";
                Page page3 = ((TmcFragment) this).page;
                KeyEvent.Callback view2 = (page3 == null || (render = page3.getRender()) == null) ? null : render.getView();
                WebView webView2 = view2 instanceof WebView ? (WebView) view2 : null;
                if (webView2 != null) {
                    webView2.loadUrl(str2);
                }
                this.typeLoadData = false;
            }
            initDomLoadMonitor(1);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        redirectPageStarted(webView, str);
        pointTrackStartNew(webView, str);
    }

    @Override // com.cloud.tmc.kernel.render.IPageEventCallback
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        IRender render;
        IRender render2;
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
        if (i != 100) {
            pointTrackProgressChangedNew(webView, i);
            if (i >= 70) {
                MiniAppH5BaseFragment.ProgressStep progressStep = MiniAppH5BaseFragment.ProgressStep.STEP_70;
                updateProgressStep(progressStep);
                updateProgressStepNew(progressStep);
                return;
            } else if (i >= 50) {
                MiniAppH5BaseFragment.ProgressStep progressStep2 = MiniAppH5BaseFragment.ProgressStep.STEP_50;
                updateProgressStep(progressStep2);
                updateProgressStepNew(progressStep2);
                return;
            } else if (i >= 30) {
                MiniAppH5BaseFragment.ProgressStep progressStep3 = MiniAppH5BaseFragment.ProgressStep.STEP_30;
                updateProgressStep(progressStep3);
                updateProgressStepNew(progressStep3);
                return;
            } else {
                MiniAppH5BaseFragment.ProgressStep progressStep4 = MiniAppH5BaseFragment.ProgressStep.INIT;
                updateProgressStep(progressStep4);
                updateProgressStepNew(progressStep4);
                return;
            }
        }
        MiniAppH5BaseFragment.ProgressStep progressStep5 = MiniAppH5BaseFragment.ProgressStep.STEP_100;
        updateProgressStep(progressStep5);
        updateProgressStepNew(progressStep5);
        loadingUrlFinish();
        Page page = ((TmcFragment) this).page;
        View view = (page == null || (render2 = page.getRender()) == null) ? null : render2.getView();
        WebView webView2 = view instanceof WebView ? (WebView) view : null;
        TmcLogger.d(TAG, "pointTrackProgressChanged100New ->" + (webView2 != null ? webView2.getUrl() : null));
        Page page2 = ((TmcFragment) this).page;
        View view2 = (page2 == null || (render = page2.getRender()) == null) ? null : render.getView();
        WebView webView3 = view2 instanceof WebView ? (WebView) view2 : null;
        TmcLogger.d(TAG, "pointTrackProgressChanged100New ->" + Intrinsics.c(webView3 != null ? webView3.getUrl() : null, this.baseUrl));
        pointTrackProgressChanged100New(webView);
    }

    @Override // com.cloud.tmc.kernel.render.IPageCallback
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest != null) {
            boolean isForMainFrame = webResourceRequest.isForMainFrame();
            boolean z = true;
            if (isForMainFrame) {
                loadingUrlError();
                StatusLayout.OooO0O0 oooO0O0 = new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniH5Fragment$onReceivedError$1
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
                        app = ((TmcFragment) MiniH5Fragment.this).app;
                        if (app != null) {
                            page3 = ((TmcFragment) MiniH5Fragment.this).page;
                            String pagePath = page3 != null ? page3.getPagePath() : null;
                            if (pagePath == null) {
                                pagePath = "";
                            }
                            app.putPageType(pagePath, 2);
                        }
                        app2 = ((TmcFragment) MiniH5Fragment.this).app;
                        if (app2 != null) {
                            page2 = ((TmcFragment) MiniH5Fragment.this).page;
                            String pagePath2 = page2 != null ? page2.getPagePath() : null;
                            if (pagePath2 == null) {
                                pagePath2 = "";
                            }
                            app2.putRouteType(pagePath2, "redirectTo");
                        }
                        app3 = ((TmcFragment) MiniH5Fragment.this).app;
                        if (app3 != null) {
                            page = ((TmcFragment) MiniH5Fragment.this).page;
                            String pagePath3 = page != null ? page.getPagePath() : null;
                            String str = pagePath3 != null ? pagePath3 : "";
                            app4 = ((TmcFragment) MiniH5Fragment.this).app;
                            Bundle startParams = app4 != null ? app4.getStartParams() : null;
                            app5 = ((TmcFragment) MiniH5Fragment.this).app;
                            app3.redirectTo(str, startParams, app5 != null ? app5.getSceneParams() : null);
                        }
                    }
                };
                int i = R.string.loading_error_tv;
                App app = ((TmcFragment) this).app;
                String appId = app != null ? app.getAppId() : null;
                MiniAppActivity activity = getActivity();
                MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
                showError(oooO0O0, i, "", appId, miniAppActivity != null ? PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity) : null);
                try {
                    Integer viewThemeMode = getViewThemeMode();
                    if (viewThemeMode != null && viewThemeMode.intValue() == 1) {
                        setCapsuleStyle(z);
                    }
                    z = false;
                    setCapsuleStyle(z);
                } catch (Throwable th) {
                    TmcLogger.e(TAG, "", th);
                }
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
    public void onReceivedTitle(String str) {
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
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.a()), (CoroutineContext) null, (CoroutineStart) null, new MiniH5Fragment$onResume$1(this, null), 3, (Object) null);
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
        Intrinsics.h(view, "view");
        super.onViewCreated(view, bundle);
        ((IMonitorWebviewManagerProxy) TmcProxy.get(IMonitorWebviewManagerProxy.class)).registerMonitorListener(this);
        PageChainContext pageChainContext = ((TmcFragment) this).pageChainContext;
        App app = ((TmcFragment) this).app;
        pageChainContext.setAppChainContext(app != null ? app.getAppChainContext() : null);
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
        App app2 = ((TmcFragment) this).app;
        performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CREATE, "");
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        if (miniAppActivity != null && !miniAppActivity.isFirstLaunch()) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app3 = ((TmcFragment) this).app;
            performanceAnalyseProxy2.record(app3 != null ? app3.getAppId() : null, PointAnalyseType.POINT_PAGE_PV, "");
        }
        Page page2 = this.mPendingSetPage;
        if (page2 != null) {
            Intrinsics.e(page2);
            setPage(page2);
            this.mPendingSetPage = null;
        }
        showNavigationBarLoading();
        com.cloud.tmc.kernel.debug.a.a(this, this);
        OooO00o oooO00o = this.binding;
        if (oooO00o == null || (imageView = oooO00o.OooO0Oo) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniH5Fragment.onViewCreated$lambda$1(MiniH5Fragment.this, view2);
            }
        });
    }

    @Override // com.cloud.tmc.render.MonitorWebviewListener
    public void reportDomLoadTime(int i, String str) {
        Intrinsics.h(str, "uniqueId");
        if (i == 1) {
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
        String str = null;
        PageNode pageNode = page instanceof PageNode ? (PageNode) page : null;
        if (pageNode != null) {
            App app = page.getApp();
            if (app != null && (appModel = app.getAppModel()) != null && (extend = appModel.getExtend()) != null) {
                str = extend.getH5Url();
            }
            pageNode.setPageURI(generateShellUrl(str));
        }
        ((TmcFragment) this).page = page;
        ((TmcFragment) this).app = page.bubbleFindNode(App.class);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.x0
            @Override // java.lang.Runnable
            public final void run() {
                MiniH5Fragment.setPage$lambda$13(MiniH5Fragment.this, page);
            }
        });
    }

    public final void setSendPageEnter(boolean z) {
        this.isSendPageEnter = z;
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
        Intent intent;
        String uri;
        redirectShouldOverrideUrlLoading(webView, webResourceRequest);
        pointTrackShouldOverrideUrlLoadingNew(webView, webResourceRequest);
        if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            String uri2 = url.toString();
            Intrinsics.g(uri2, "it.toString()");
            if (!StringsKt.W(uri2, "http", false, 2, (Object) null)) {
                try {
                    Object fromJson = new Gson().fromJson(((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_SHELL_SCHEME_FILTER, "[\"whatsapp\",\"sms\",\"tel\"]"), List.class);
                    List list = fromJson instanceof List ? (List) fromJson : null;
                    if (list != null && CollectionsKt.b0(list, url.getScheme())) {
                        if ("intent".equals(url.getScheme())) {
                            intent = Intent.parseUri(url.toString(), 1);
                            Intrinsics.g(intent, "parseUri(it.toString(), Intent.URI_INTENT_SCHEME)");
                        } else {
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(url.toString()));
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
            String currentUrl = getCurrentUrl(webView);
            if (currentUrl == null) {
                return Boolean.FALSE;
            }
            Uri url2 = webResourceRequest.getUrl();
            if (url2 == null || (uri = url2.toString()) == null) {
                return Boolean.FALSE;
            }
            redirect(currentUrl, uri);
        }
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
