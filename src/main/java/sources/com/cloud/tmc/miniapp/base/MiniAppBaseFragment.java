package com.cloud.tmc.miniapp.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.listener.RootViewGlobalLayoutListener;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarBadgeMessage;
import com.cloud.tmc.integration.model.TabBarMessageStore;
import com.cloud.tmc.integration.model.TabBarRedDotMessage;
import com.cloud.tmc.integration.model.TabBarStyle;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.processor.intercept.IBackPressedIntercept;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.structure.ui.TabBar;
import com.cloud.tmc.integration.structure.ui.TitleBar;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniAppConfigUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.UrlUtil;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.integration.utils.ext.PageExtKt;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.listener.OnKeyboardListener;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.utils.BundleUtils;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.action.HandlerAction;
import com.cloud.tmc.miniapp.action.RefreshAction;
import com.cloud.tmc.miniapp.defaultimpl.OooO0o;
import com.cloud.tmc.miniapp.defaultimpl.OooOO0;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.utils.OooOO0O;
import com.cloud.tmc.miniapp.utils.manager.OooO00o;
import com.cloud.tmc.miniapp.utils.manager.OooO0O0;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.SwipeBackLayout;
import com.cloud.tmc.miniapp.widget.TabBarView;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class MiniAppBaseFragment extends TmcFragment implements RefreshAction, HandlerAction {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MiniAppBaseFragment";
    private boolean hasVirtualNavBar;
    private volatile boolean loadingAnimatorPlaying;
    private boolean navigationBarProgressUpdating;
    private boolean pullDownRefresh;
    private boolean pullUpRefresh;
    private Integer refreshFooterDelayed;
    private Integer refreshHeaderDelayed;
    private RootViewGlobalLayoutListener rootViewGlobalLayoutListener;
    private final Lazy swipeBackManager$delegate = LazyKt.b(new Function0<OooOO0>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$swipeBackManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OooOO0 m29invoke() {
            return new OooOO0();
        }
    });
    private final Lazy refreshManager$delegate = LazyKt.b(new Function0<OooO0o>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$refreshManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OooO0o m28invoke() {
            return new OooO0o();
        }
    });
    private final AnimatorSet loadingAnimatorSet = new AnimatorSet();
    private AtomicBoolean isFullScreen = new AtomicBoolean(false);
    private final OnKeyboardListener onKeyboardListener = new OnKeyboardListener() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$onKeyboardListener$1
        @Override // com.cloud.tmc.kernel.listener.OnKeyboardListener
        public void onKeyBoardChanged(int i, int i2) {
            try {
                TmcLogger.d("MiniAppBaseFragment", "onKeyboardListener: keyboardHeight: " + i + ", screenHeight: " + i2);
                MiniAppBaseFragment.this.tabBarAdjustPan(i, i2);
            } catch (Throwable th) {
                TmcLogger.e("MiniAppBaseFragment", "onKeyBoardChanged failed", th);
            }
        }
    };

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final synchronized void cancelAnimator() {
        try {
            TmcLogger.d(TAG, "cancelAnimator");
        } finally {
        }
        if (this.loadingAnimatorPlaying) {
            this.loadingAnimatorSet.cancel();
            this.loadingAnimatorPlaying = false;
        }
    }

    private final boolean checkAlertBeforeUnload() {
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            return PageExtKt.checkAlertBeforeUnload(page, new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$checkAlertBeforeUnload$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m27invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m27invoke() {
                    MiniAppActivity activity = MiniAppBaseFragment.this.getActivity();
                    MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
                    if (miniAppActivity != null) {
                        miniAppActivity.goBack();
                    }
                }
            });
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableHeaderTranslationContent$lambda$11(MiniAppBaseFragment miniAppBaseFragment) {
        View content;
        Intrinsics.h(miniAppBaseFragment, "this$0");
        try {
            MiniAppConfigModel.WindowBean window = miniAppBaseFragment.getWindow();
            String orDefault = StringExtKt.orDefault(window != null ? window.getRefreshHeaderStyle() : null, "default");
            float px2dp = CommonExtKt.getPx2dp(MiniBarUtils.getStatusHeight());
            TitleBar titleBar = miniAppBaseFragment.getTitleBar();
            float px2dp2 = (titleBar == null || (content = titleBar.getContent()) == null) ? -1.0f : CommonExtKt.getPx2dp(content.getHeight());
            float px2dp3 = CommonExtKt.getPx2dp((((TmcFragment) miniAppBaseFragment).page != null ? r5.getIntValue("capsuleTranslationY") : 0.0f) + (((TmcFragment) miniAppBaseFragment).page != null ? r7.getIntValue("capsuleHeight") : 0.0f));
            if (!Intrinsics.c(orDefault, "custom")) {
                px2dp3 = px2dp2 == -1.0f ? px2dp + CommonExtKt.getPx2dp(19.2f) : (px2dp2 / 5) * 3;
            }
            if (Intrinsics.c(orDefault, "custom")) {
                px2dp = 0.0f;
            }
            miniAppBaseFragment.getRefreshManager().OooO0O0(px2dp3);
            miniAppBaseFragment.getRefreshManager().OooO00o(px2dp);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "Error refreshing", th);
        }
    }

    private final OooO00o getRefreshManager() {
        return (OooO00o) this.refreshManager$delegate.getValue();
    }

    private final OooO0O0 getSwipeBackManager() {
        return (OooO0O0) this.swipeBackManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideLoadingDialog$lambda$39(MiniAppBaseFragment miniAppBaseFragment) {
        Intrinsics.h(miniAppBaseFragment, "this$0");
        try {
            ViewGroup contentView = miniAppBaseFragment.getContentView();
            FrameLayout frameLayout = contentView != null ? (FrameLayout) contentView.findViewById(R.id.fl_loading_mask) : null;
            if ((frameLayout == null || frameLayout.getVisibility() != 8) && frameLayout != null) {
                ViewExtKt.toGone(frameLayout);
            }
            miniAppBaseFragment.cancelAnimator();
            ViewGroup contentView2 = miniAppBaseFragment.getContentView();
            ImageView imageView = contentView2 != null ? (ImageView) contentView2.findViewById(R.id.iv_loading) : null;
            if (imageView != null) {
                miniAppBaseFragment.removeCallbacksAndMessages(imageView);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshApp$lambda$32(FragmentActivity fragmentActivity) {
        ((MiniAppActivity) fragmentActivity).refreshApp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendAppOrPageReadyToRender$default(MiniAppBaseFragment miniAppBaseFragment, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAppOrPageReadyToRender");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        miniAppBaseFragment.sendAppOrPageReadyToRender(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendEventOrLifecycleToWorker$default(MiniAppBaseFragment miniAppBaseFragment, String str, boolean z, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEventOrLifecycleToWorker");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        miniAppBaseFragment.sendEventOrLifecycleToWorker(str, z, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendPageEnterToWorker$default(MiniAppBaseFragment miniAppBaseFragment, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPageEnterToWorker");
        }
        if ((i & 1) != 0) {
            map = null;
        }
        miniAppBaseFragment.sendPageEnterToWorker(map);
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, com.cloud.tmc.miniapp.widget.CapsuleView] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.cloud.tmc.miniapp.widget.CapsuleView] */
    private final void setCapsuleParams() {
        MiniAppActivity activity = getActivity();
        MiniAppActivity miniAppActivity = activity instanceof MiniAppActivity ? activity : null;
        final ?? capsule = miniAppActivity != null ? miniAppActivity.getCapsule() : 0;
        if (capsule != 0) {
            capsule.post(new Runnable() { // from class: com.cloud.tmc.miniapp.base.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.setCapsuleParams$lambda$31$lambda$30(MiniAppBaseFragment.this, capsule);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setCapsuleParams$lambda$31$lambda$30(MiniAppBaseFragment miniAppBaseFragment, CapsuleView capsuleView) {
        Intrinsics.h(miniAppBaseFragment, "this$0");
        Intrinsics.h(capsuleView, "$v");
        Page page = ((TmcFragment) miniAppBaseFragment).page;
        if (page != null) {
            page.putIntValue("capsuleHeight", capsuleView.getHeight());
            page.putIntValue("capsuleWidth", capsuleView.getWidth());
            page.putIntValue("capsuleTop", (int) capsuleView.getY());
            page.putIntValue("capsuleRight", capsuleView.getWidth() + ((int) capsuleView.getX()));
            page.putIntValue("capsuleBottom", capsuleView.getHeight() + ((int) capsuleView.getY()));
            page.putIntValue("capsuleLeft", (int) capsuleView.getX());
            page.putIntValue("capsuleTranslationX", (int) capsuleView.getTranslationX());
            page.putIntValue("capsuleTranslationY", (int) capsuleView.getTranslationY());
        }
    }

    private final void setHostActivityStatusBackground(final Page page) {
        try {
            TmcLogger.d(TAG, "setHostActivityStatusBackground page: " + page.getPagePath());
            AppNode app = page.getApp();
            AppNode appNode = app instanceof AppNode ? app : null;
            AppLoadResult appLoadResult = appNode != null ? appNode.getmAppLoadResult() : null;
            if (appLoadResult == null) {
                TmcLogger.d(TAG, "setHostActivityStatusBackground: appLoadResult is null");
                return;
            }
            MiniAppConfigModel.WindowBean windowOptimalConfiguration = MiniAppConfigUtils.getWindowOptimalConfiguration(appLoadResult, page.getPagePath());
            final String contentBgColor = windowOptimalConfiguration != null ? windowOptimalConfiguration.getContentBgColor() : null;
            if (contentBgColor == null || contentBgColor.length() <= 0) {
                return;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.base.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.setHostActivityStatusBackground$lambda$35$lambda$34(contentBgColor, this, page);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "setHostActivityStatusBackground parse color failed!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHostActivityStatusBackground$lambda$35$lambda$34(String str, MiniAppBaseFragment miniAppBaseFragment, Page page) {
        StatusLayout statusLayout;
        AppContext appContext;
        Intrinsics.h(str, "$color");
        Intrinsics.h(miniAppBaseFragment, "this$0");
        Intrinsics.h(page, "$page");
        try {
            TmcLogger.d(TAG, "setHostActivityStatusBackground: contentBackground: : " + str);
            int parseColor = Color.parseColor(str);
            MiniAppActivity activity = miniAppBaseFragment.getActivity();
            MiniAppActivity miniAppActivity = null;
            MiniAppActivity miniAppActivity2 = activity instanceof MiniAppActivity ? activity : null;
            if (miniAppActivity2 == null) {
                App app = page.getApp();
                Object context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                if (context instanceof MiniAppActivity) {
                    miniAppActivity = (MiniAppActivity) context;
                }
            } else {
                miniAppActivity = miniAppActivity2;
            }
            if (miniAppActivity != null && (statusLayout = miniAppActivity.getStatusLayout()) != null) {
                statusLayout.setBackgroundColor(parseColor);
                TmcLogger.d(TAG, "setHostActivityStatusBackground: 设置 activity 的状态布局背景色成功");
            }
            TmcLogger.d(TAG, "setHostActivityStatusBackground: 执行完毕");
        } catch (Throwable th) {
            TmcLogger.e(TAG, "setHostActivityStatusBackground parse color failed!!!", th);
        }
    }

    private final void setParallaxOffset(float f) {
        getSwipeBackManager().OooO00o(f);
    }

    public static /* synthetic */ void setParallaxOffset$default(MiniAppBaseFragment miniAppBaseFragment, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setParallaxOffset");
        }
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        miniAppBaseFragment.setParallaxOffset(f);
    }

    private final void setShowLoading(Page page) {
        try {
            TmcLogger.d(TAG, "setShowLoading");
            if (getContentView() == null) {
                TmcLogger.d(TAG, "setShowLoading 当面页面未渲染，不再执行");
                return;
            }
            App app = page.getApp();
            String stringValue = app != null ? app.getStringValue(TmcConstants.KEY_FIRST_STARTED_PAGE_PATH) : null;
            if (stringValue == null) {
                return;
            }
            TmcLogger.d(TAG, "setShowLoading firstStartedPagePath: " + stringValue);
            String pagePath = page.getPagePath();
            if (pagePath == null) {
                return;
            }
            TmcLogger.d(TAG, "setShowLoading current pagePath: " + pagePath);
            if (Intrinsics.c(stringValue, pagePath)) {
                TmcLogger.d(TAG, "setShowLoading 首个启动页面不展示页面Loading");
                return;
            }
            if (UrlUtil.isHttpOrHttpsUrl(pagePath)) {
                TmcLogger.d(TAG, "setShowLoading 混合页面不支持显示页面Loading");
                return;
            }
            App app2 = page.getApp();
            boolean booleanValue = app2 != null ? app2.getBooleanValue(TmcConstants.KEY_FIRST_NORMAL_PAGE_OPENED) : false;
            TmcLogger.d(TAG, "setShowLoading 首个正常小程序页面是否打开过：" + booleanValue);
            MiniAppConfigModel.WindowBean window = getWindow();
            boolean c = window != null ? Intrinsics.c(window.getEnablePageLoading(), Boolean.TRUE) : false;
            TmcLogger.d(TAG, "setShowLoading 业务小程序配置Loading的开关：" + c);
            if (UrlUtil.isHttpOrHttpsUrl(stringValue) && !booleanValue) {
                TmcLogger.d(TAG, "setShowLoading 首个页面为H5混合页，首个正常小程序页面尚未打开过");
                c = true;
            }
            if (c) {
                showLoadingDialog();
            } else {
                TmcLogger.d(TAG, "setShowLoading 关闭页面调整Loading");
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "setShowLoading fail!!!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingDialog$lambda$37(final MiniAppBaseFragment miniAppBaseFragment) {
        Intrinsics.h(miniAppBaseFragment, "this$0");
        try {
            ViewGroup contentView = miniAppBaseFragment.getContentView();
            FrameLayout frameLayout = contentView != null ? (FrameLayout) contentView.findViewById(R.id.fl_loading_mask) : null;
            ViewGroup contentView2 = miniAppBaseFragment.getContentView();
            ImageView imageView = contentView2 != null ? (ImageView) contentView2.findViewById(R.id.iv_loading) : null;
            if (imageView == null) {
                return;
            }
            if ((frameLayout == null || frameLayout.getVisibility() != 0) && frameLayout != null) {
                ViewExtKt.toVisible(frameLayout);
            }
            miniAppBaseFragment.removeCallbacksAndMessages(imageView);
            miniAppBaseFragment.startAnimator(imageView);
            miniAppBaseFragment.postDelayed(imageView, ToastStrategy.SHORT_DURATION_TIMEOUT, new Runnable() { // from class: com.cloud.tmc.miniapp.base.g
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.showLoadingDialog$lambda$37$lambda$36(MiniAppBaseFragment.this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingDialog$lambda$37$lambda$36(MiniAppBaseFragment miniAppBaseFragment) {
        Intrinsics.h(miniAppBaseFragment, "this$0");
        miniAppBaseFragment.hideLoadingDialog();
    }

    private final synchronized void startAnimator(ImageView imageView) {
        try {
            TmcLogger.d(TAG, "startAnimator");
        } finally {
        }
        if (this.loadingAnimatorPlaying) {
            return;
        }
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
            Intrinsics.g(ofFloat, "ofFloat(it, \"rotation\", 0F, 360F)");
            ofFloat.setDuration(600L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            this.loadingAnimatorSet.play(ofFloat);
            this.loadingAnimatorSet.start();
            this.loadingAnimatorPlaying = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tabBarAdjustPan(int i, int i2) {
        try {
            MiniAppConfigModel.WindowBean window = getWindow();
            if (!(window != null ? Intrinsics.c(window.getEnableTabBarAdjustPan(), Boolean.TRUE) : false)) {
                TmcLogger.d(TAG, "onTabBarAdjustPan enableTabBarAdjustPan is not enabled");
                return;
            }
            Page page = ((TmcFragment) this).page;
            if (!(page != null ? page.isTabPage() : false)) {
                TmcLogger.d(TAG, "onTabBarAdjustPan: page is not tabPage " + ((TmcFragment) this).page);
                return;
            }
            Page page2 = ((TmcFragment) this).page;
            if (Intrinsics.c(page2 != null ? page2.getStringValue(TmcConstants.KEY_IS_API_SHOW_TAB_BAR_ENABLED) : null, "hideTabBar")) {
                Page page3 = ((TmcFragment) this).page;
                if (page3 != null) {
                    page3.hideTabBar(false);
                    return;
                }
                return;
            }
            if (i > i2 * 0.15d) {
                Page page4 = ((TmcFragment) this).page;
                if (page4 != null) {
                    page4.hideTabBar(false);
                    return;
                }
                return;
            }
            Page page5 = ((TmcFragment) this).page;
            if (page5 != null) {
                page5.showTabBar(false);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "tabBarAdjustPan failed", th);
        }
    }

    public void addOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        Intrinsics.h(onKeyboardListener, "listener");
        RootViewGlobalLayoutListener rootViewGlobalLayoutListener = this.rootViewGlobalLayoutListener;
        if (rootViewGlobalLayoutListener != null) {
            rootViewGlobalLayoutListener.addOnKeyboardListener(onKeyboardListener);
        }
    }

    public final View attachToRefresh(View view, MiniAppConfigModel.WindowBean windowBean) {
        Intrinsics.h(view, "view");
        Intrinsics.h(windowBean, "window");
        this.refreshHeaderDelayed = windowBean.getRefreshHeaderDelayed();
        this.refreshFooterDelayed = windowBean.getRefreshFooterDelayed();
        OooO00o refreshManager = getRefreshManager();
        ViewExtKt.removeSelf(view);
        Unit unit = Unit.a;
        View OooO00o = refreshManager.OooO00o(this, view);
        Boolean enablePullDownRefresh = windowBean.getEnablePullDownRefresh();
        Boolean bool = Boolean.TRUE;
        enableRefresh(Intrinsics.c(enablePullDownRefresh, bool));
        enableLoadMore(Intrinsics.c(windowBean.getEnablePullUpRefresh(), bool));
        String refreshHeaderStyle = windowBean.getRefreshHeaderStyle();
        if (refreshHeaderStyle != null && Intrinsics.c(refreshHeaderStyle, "custom")) {
            OooOO0O oooOO0O = OooOO0O.OooO00o;
            File OooO00o2 = oooOO0O.OooO00o(windowBean.getRefreshHeaderCustomLoadingGif(), ((TmcFragment) this).app, true);
            File OooO00o3 = oooOO0O.OooO00o(windowBean.getRefreshHeaderCustomSuccessGif(), ((TmcFragment) this).app, true);
            File OooO00o4 = oooOO0O.OooO00o(windowBean.getRefreshHeaderCustomLoading(), ((TmcFragment) this).app, false);
            File OooO00o5 = oooOO0O.OooO00o(windowBean.getRefreshHeaderCustomSuccess(), ((TmcFragment) this).app, false);
            if (OooO00o2 != null && OooO00o3 != null && OooO00o4 != null && OooO00o5 != null) {
                getRefreshManager().OooO00o("custom");
                getRefreshManager().OooO0O0(Intrinsics.c(windowBean.getRefreshHeaderCustomTextEnable(), bool));
                getRefreshManager().OooO00o(OooO00o2, OooO00o3, OooO00o4, OooO00o5);
            }
        }
        enableHeaderTranslationContent(Intrinsics.c(windowBean.getRefreshHeaderTranslationContent(), bool));
        try {
            String refreshHeaderAccentColor = windowBean.getRefreshHeaderAccentColor();
            if (refreshHeaderAccentColor != null && refreshHeaderAccentColor.length() > 0) {
                getRefreshManager().OooO0Oo(Color.parseColor(refreshHeaderAccentColor));
            }
        } catch (Exception e) {
            TmcLogger.e(TAG, "set header accent color error", e);
        }
        try {
            String refreshHeaderBackgroundColor = windowBean.getRefreshHeaderBackgroundColor();
            if (refreshHeaderBackgroundColor != null && refreshHeaderBackgroundColor.length() > 0) {
                getRefreshManager().OooO0O0(Color.parseColor(refreshHeaderBackgroundColor));
            }
        } catch (Exception e2) {
            TmcLogger.e(TAG, "set header background color error", e2);
        }
        try {
            String refreshFooterAccentColor = windowBean.getRefreshFooterAccentColor();
            if (refreshFooterAccentColor != null && refreshFooterAccentColor.length() > 0) {
                getRefreshManager().OooO00o(Color.parseColor(refreshFooterAccentColor));
            }
        } catch (Exception e3) {
            TmcLogger.e(TAG, "set footer accent color error", e3);
        }
        try {
            String refreshFooterBackgroundColor = windowBean.getRefreshFooterBackgroundColor();
            if (refreshFooterBackgroundColor != null && refreshFooterBackgroundColor.length() > 0) {
                getRefreshManager().OooO0OO(Color.parseColor(refreshFooterBackgroundColor));
            }
        } catch (Exception e4) {
            TmcLogger.e(TAG, "set footer background color error", e4);
        }
        return OooO00o;
    }

    public final View attachToSwipeBack(View view) {
        Intrinsics.h(view, "view");
        OooO0O0 swipeBackManager = getSwipeBackManager();
        ViewExtKt.removeSelf(view);
        setEdgeLevel(CommonExtKt.getDp2px(25));
        return swipeBackManager.OooO00o(view);
    }

    public final void checkBackToPageInterceptAndRemoveIt() {
        IBackPressedProcessor backPressedProcessor;
        List interceptors;
        Object obj;
        App app;
        IBackPressedProcessor backPressedProcessor2;
        try {
            App app2 = ((TmcFragment) this).app;
            if (app2 == null || (backPressedProcessor = app2.getBackPressedProcessor()) == null || (interceptors = backPressedProcessor.getInterceptors()) == null) {
                return;
            }
            Iterator it = interceptors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(((IBackPressedIntercept) obj).getInterceptName(), "BackToPageIntercept")) {
                        break;
                    }
                }
            }
            IBackPressedIntercept iBackPressedIntercept = (IBackPressedIntercept) obj;
            if (iBackPressedIntercept == null || (app = ((TmcFragment) this).app) == null || (backPressedProcessor2 = app.getBackPressedProcessor()) == null) {
                return;
            }
            backPressedProcessor2.removeInterceptors(iBackPressedIntercept);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th.getMessage(), th);
        }
    }

    public void destroy() {
        try {
            hideLoadingDialog();
        } catch (Throwable th) {
            TmcLogger.e(TAG, "remove callbacks and messages", th);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public void enableHeaderTranslationContent(boolean z) {
        View view;
        if (this.pullDownRefresh) {
            getRefreshManager().OooO00o(z);
            if (z) {
                return;
            }
            MiniAppConfigModel.WindowBean window = getWindow();
            if (!(window != null ? Intrinsics.c(window.getEnableTransparentStatusBar(), Boolean.TRUE) : false) || (view = getView()) == null) {
                return;
            }
            view.post(new Runnable() { // from class: com.cloud.tmc.miniapp.base.h
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.enableHeaderTranslationContent$lambda$11(MiniAppBaseFragment.this);
                }
            });
        }
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public void enableLoadMore(boolean z) {
        this.pullUpRefresh = z;
        getRefreshManager().OooO0Oo(z);
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public void enableRefresh(boolean z) {
        this.pullDownRefresh = z;
        getRefreshManager().OooO0OO(z);
    }

    public final AppLoadResult getAppLoadResult() {
        return BundleUtils.getParcelable(getSceneParams(), TmcConstants.EXTRA_APP_LOAD_RESULT);
    }

    public final EntryInfo getEntryInfo() {
        return BundleUtils.getParcelable(getSceneParams(), TmcConstants.EXTRA_ENTRY_INFO);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public Handler getHandler() {
        return HandlerAction.DefaultImpls.getHandler(this);
    }

    public final boolean getHasVirtualNavBar() {
        return this.hasVirtualNavBar;
    }

    public boolean getNavigationBarProgressUpdateStatus() {
        return this.navigationBarProgressUpdating;
    }

    public final boolean getNavigationBarProgressUpdating() {
        return this.navigationBarProgressUpdating;
    }

    public final Bundle getSceneParams() {
        App app;
        Page page = ((TmcFragment) this).page;
        if (page == null || (app = page.getApp()) == null) {
            return null;
        }
        return app.getSceneParams();
    }

    public final MiniAppConfigModel.WindowBean getWindow() {
        AppLoadResult appLoadResult = getAppLoadResult();
        Page page = ((TmcFragment) this).page;
        return MiniAppConfigUtils.getWindowOptimalConfiguration(appLoadResult, page != null ? page.getPagePath() : null);
    }

    public final boolean hasVirtualNavBar(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    public final void hideLoadingDialog() {
        try {
            TmcLogger.d(TAG, "hideLoadingDialog");
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.base.k
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.hideLoadingDialog$lambda$39(MiniAppBaseFragment.this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    public boolean hideTabBar(boolean z) {
        TabBar tabBar = getTabBar();
        if (tabBar != null) {
            return tabBar.hideTabBar(z);
        }
        return false;
    }

    public boolean hideTabBarRedDot(int i) {
        HashMap redDotMessageHashMap;
        App app;
        TabBar tabBar = getTabBar();
        boolean unreadVisible = tabBar != null ? tabBar.setUnreadVisible(i, false) : false;
        if (unreadVisible) {
            Page page = ((TmcFragment) this).page;
            TabBarRedDotMessage tabBarRedDotMessage = null;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                tabBarRedDotMessage = (TabBarRedDotMessage) redDotMessageHashMap.get(Integer.valueOf(i));
            }
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowRedDot(false);
            }
        }
        return unreadVisible;
    }

    public boolean hideTabBarUnreadIcon(int i) {
        HashMap redDotMessageHashMap;
        App app;
        TabBar tabBar = getTabBar();
        boolean unreadIconVisible = tabBar != null ? tabBar.setUnreadIconVisible(i, false) : false;
        if (unreadIconVisible) {
            Page page = ((TmcFragment) this).page;
            TabBarRedDotMessage tabBarRedDotMessage = null;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                tabBarRedDotMessage = (TabBarRedDotMessage) redDotMessageHashMap.get(Integer.valueOf(i));
            }
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowUnreadIcon(false);
            }
        }
        return unreadIconVisible;
    }

    public final void hideVirtualNavBar() {
        View decorView = requireActivity().getWindow().getDecorView();
        Intrinsics.g(decorView, "requireActivity().window.decorView");
        decorView.setSystemUiVisibility(2050);
    }

    public void initView() {
        setCapsuleParams();
    }

    public final AtomicBoolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isHomepage(AppLoadResult appLoadResult) {
        return AppUtils.isHomepage(((TmcFragment) this).page, appLoadResult);
    }

    public boolean loadTabBar(MiniAppConfigModel.TabBarBean tabBarBean, String str) {
        Intrinsics.h(tabBarBean, "tabBar");
        TabBar tabBar = getTabBar();
        boolean z = false;
        if (tabBar == null || !(tabBar instanceof TabBarView)) {
            return false;
        }
        TabBarView tabBarView = (TabBarView) tabBar;
        Page page = ((TmcFragment) this).page;
        if (page != null && page.isTabPage()) {
            z = true;
        }
        ViewExtKt.toVisibleOrGone(tabBarView, z);
        Page page2 = ((TmcFragment) this).page;
        if (page2 != null && page2.isTabPage()) {
            Page page3 = ((TmcFragment) this).page;
            if (str == null) {
                str = "";
            }
            tabBarView.setTabs(tabBarBean, page3, str);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.Fragment*/.onCreate(bundle);
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext()");
        this.hasVirtualNavBar = hasVirtualNavBar(requireContext);
        Page page = ((TmcFragment) this).page;
        if (page == null || !page.isTabPage()) {
            getSwipeBackManager().OooO00o(this, bundle);
        }
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        getSwipeBackManager().onDestroy();
        if (this.pullDownRefresh || this.pullUpRefresh) {
            getRefreshManager().onDestroy();
        }
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        try {
            getSwipeBackManager().OooO00o();
            ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).releaseKeyBoardChange(requireView());
            RootViewGlobalLayoutListener rootViewGlobalLayoutListener = this.rootViewGlobalLayoutListener;
            if (rootViewGlobalLayoutListener != null) {
                rootViewGlobalLayoutListener.release();
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "onDestroyView failed", th);
        }
    }

    public void onHiddenChanged(boolean z) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(z);
        getSwipeBackManager().OooO00o(z);
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public void onLoadMoreEvent() {
        Integer num;
        int intValue;
        if (!this.pullUpRefresh || (num = this.refreshFooterDelayed) == null || (intValue = num.intValue()) <= 0) {
            return;
        }
        getRefreshManager().OooO00o(intValue, false);
    }

    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        super/*androidx.fragment.app.Fragment*/.onPause();
        try {
            View view = getView();
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.rootViewGlobalLayoutListener);
            }
            ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).setKeyBoardListener((com.cloud.tmc.integration.proxy.OnKeyboardListener) null);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "onPause failed", th);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public void onRefreshEvent() {
        Integer num;
        int intValue;
        if (!this.pullDownRefresh || (num = this.refreshHeaderDelayed) == null || (intValue = num.intValue()) <= 0) {
            return;
        }
        getRefreshManager().OooO0O0(intValue, false);
    }

    public void onResume() {
        RootViewGlobalLayoutListener rootViewGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver;
        super/*androidx.fragment.app.Fragment*/.onResume();
        try {
            View view = getView();
            if (view != null && (rootViewGlobalLayoutListener = this.rootViewGlobalLayoutListener) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(rootViewGlobalLayoutListener);
            }
            ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).setKeyBoardListener(new com.cloud.tmc.integration.proxy.OnKeyboardListener() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$onResume$2
                private final IEvent createEvent;
                private final IEventCenterFactory eventCenterFactory;

                {
                    IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
                    this.eventCenterFactory = iEventCenterFactory;
                    this.createEvent = iEventCenterFactory.createEvent("onKeyboardHeightChange");
                }

                public final IEvent getCreateEvent() {
                    return this.createEvent;
                }

                public final IEventCenterFactory getEventCenterFactory() {
                    return this.eventCenterFactory;
                }

                public void onKeyBoardAnimEnd() {
                    TmcLogger.d("MiniAppBaseFragment", "Keyboard anim end");
                }

                public void onKeyBoardAnimStart() {
                    TmcLogger.d("MiniAppBaseFragment", "Keyboard anim start");
                }

                public void onKeyBoardHeightChange(int i) {
                    Page page;
                    App app;
                    TmcLogger.d("MiniAppBaseFragment", "Keyboard height:" + i);
                    IEvent iEvent = this.createEvent;
                    page = ((TmcFragment) MiniAppBaseFragment.this).page;
                    iEvent.setData(MapsKt.j(new Pair[]{TuplesKt.a("page", page), TuplesKt.a("height", String.valueOf(i))}));
                    IEventCenterFactory iEventCenterFactory = this.eventCenterFactory;
                    app = ((TmcFragment) MiniAppBaseFragment.this).app;
                    IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(app);
                    if (eventCenterInstance != null) {
                        eventCenterInstance.postEvent("onKeyboardHeightChange", this.createEvent);
                    }
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "onResume failed", th);
        }
    }

    public void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, bundle);
        ((IKeyboardProxy) TmcProxy.get(IKeyboardProxy.class)).initKeyBoardChange(requireView());
        RootViewGlobalLayoutListener rootViewGlobalLayoutListener = new RootViewGlobalLayoutListener(this);
        rootViewGlobalLayoutListener.addOnKeyboardListener(this.onKeyboardListener);
        this.rootViewGlobalLayoutListener = rootViewGlobalLayoutListener;
    }

    public void onViewStateRestored(Bundle bundle) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(bundle);
        setParallaxOffset$default(this, 0.0f, 1, null);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean post(Runnable runnable) {
        return HandlerAction.DefaultImpls.post(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postAtTime(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postAtTime(this, runnable, j);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Object obj, long j, Runnable runnable) {
        return HandlerAction.DefaultImpls.postDelayed(this, obj, j, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postDelayed(this, runnable, j);
    }

    public void refreshApp() {
        final MiniAppActivity activity = getActivity();
        if (activity instanceof MiniAppActivity) {
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                activity.refreshApp();
            } else {
                ExecutorUtils.execute(ExecutorType.UI, new Runnable() { // from class: com.cloud.tmc.miniapp.base.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppBaseFragment.refreshApp$lambda$32(activity);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks() {
        HandlerAction.DefaultImpls.removeCallbacks(this);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks(Runnable runnable) {
        HandlerAction.DefaultImpls.removeCallbacks(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacksAndMessages(Object obj) {
        HandlerAction.DefaultImpls.removeCallbacksAndMessages(this, obj);
    }

    public void removeOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        Intrinsics.h(onKeyboardListener, "listener");
        RootViewGlobalLayoutListener rootViewGlobalLayoutListener = this.rootViewGlobalLayoutListener;
        if (rootViewGlobalLayoutListener != null) {
            rootViewGlobalLayoutListener.removeOnKeyboardListener(onKeyboardListener);
        }
    }

    public boolean removeTabBarBadge(int i) {
        HashMap badgeMessageHashMap;
        TabBarBadgeMessage tabBarBadgeMessage;
        App app;
        TabBar tabBar = getTabBar();
        boolean removeTabBarBadge = tabBar != null ? tabBar.removeTabBarBadge(i) : false;
        if (removeTabBarBadge) {
            Page page = ((TmcFragment) this).page;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null && (badgeMessageHashMap = tabBarMessageStore.getBadgeMessageHashMap()) != null && (tabBarBadgeMessage = (TabBarBadgeMessage) badgeMessageHashMap.get(Integer.valueOf(i))) != null) {
                tabBarBadgeMessage.setShowBadge(false);
                tabBarBadgeMessage.setText((String) null);
            }
        }
        return removeTabBarBadge;
    }

    public final void sendAppOrPageReadyToRender(String str, Map<String, String> map) {
        Intrinsics.h(str, "eventName");
        AppUtils.sendAppOrPageReadyToRender(((TmcFragment) this).page, str, map);
    }

    public final void sendEventOrLifecycleToWorker(String str, boolean z, Map<String, ? extends Object> map) {
        Intrinsics.h(str, "eventName");
        AppUtils.sendEventOrLifecycleToWorker(((TmcFragment) this).page, str, z, map);
    }

    public final void sendPageEnterToWorker(Map<String, ? extends Object> map) {
        String str;
        Integer num;
        App app;
        Page prePage;
        App app2;
        Page page = ((TmcFragment) this).page;
        String str2 = null;
        if (page == null || (app2 = page.getApp()) == null) {
            str = null;
        } else {
            Page page2 = ((TmcFragment) this).page;
            String pagePath = page2 != null ? page2.getPagePath() : null;
            if (pagePath == null) {
                pagePath = "";
            }
            str = app2.getRouteType(pagePath);
        }
        String orDefault = StringExtKt.orDefault(StringExtKt.takeIfNotEmpty(str), "navigateTo");
        String str3 = Intrinsics.c(orDefault, TmcConstants.ROUTE_UNKNOWN) ? "navigateTo" : orDefault;
        App app3 = ((TmcFragment) this).app;
        if (app3 != null) {
            Page page3 = ((TmcFragment) this).page;
            String pagePath2 = page3 != null ? page3.getPagePath() : null;
            if (pagePath2 == null) {
                pagePath2 = "";
            }
            num = Integer.valueOf(app3.getPageType(pagePath2));
        } else {
            num = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(FrameworkConstants.GLOBAL_DATA_KEY_DELTA, 0);
        hashMap.put(FrameworkConstants.GLOBAL_DATA_KEY_ROUTE_TYPE, str3);
        boolean z = true;
        if (num != null && num.intValue() == 1) {
            z = false;
        }
        hashMap.put(FrameworkConstants.GLOBAL_DATA_KEY_IS_MIXED_PAGE, Boolean.valueOf(z));
        Page page4 = ((TmcFragment) this).page;
        if (page4 != null && (app = page4.getApp()) != null && (prePage = app.getPrePage()) != null) {
            str2 = prePage.getPageId();
        }
        hashMap.put(FrameworkConstants.GLOBAL_DATA_KEY_PRE_RENDER_ID, str2 != null ? str2 : "");
        if (map != null) {
            hashMap.putAll(map);
        }
        sendEventOrLifecycleToWorker("pageEnter", false, hashMap);
    }

    public final void setEdgeLevel(int i) {
        getSwipeBackManager().OooO00o(i);
    }

    public final void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
        Intrinsics.h(edgeLevel, "edgeLevel");
        getSwipeBackManager().OooO00o(edgeLevel);
    }

    public final void setFullScreen(AtomicBoolean atomicBoolean) {
        Intrinsics.h(atomicBoolean, "<set-?>");
        this.isFullScreen = atomicBoolean;
    }

    public final void setHasVirtualNavBar(boolean z) {
        this.hasVirtualNavBar = z;
    }

    public final void setNavigationBarProgressUpdating(boolean z) {
        this.navigationBarProgressUpdating = z;
    }

    public void setPage(Page page) {
        Intrinsics.h(page, "page");
        try {
            try {
                App app = ((TmcFragment) this).app;
                if ((app != null ? app.getAppLifecycleCallback() : null) == null) {
                    TmcLogger.d(TAG, "setMiniappLifecycleCallback");
                    App app2 = ((TmcFragment) this).app;
                    if (app2 != null) {
                        FragmentActivity activity = getActivity();
                        app2.setMiniappLifecycleCallback(activity instanceof MiniAppActivity ? (MiniAppActivity) activity : null);
                    }
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
            }
            setHostActivityStatusBackground(page);
            setShowLoading(page);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "setPage fail!", th2);
        }
    }

    public final void setSwipeBackEnable(boolean z) {
        getSwipeBackManager().OooO0O0(z);
    }

    public boolean setTabBarBadge(int i, String str) {
        HashMap redDotMessageHashMap;
        App app;
        TabBar tabBar = getTabBar();
        boolean tabBarBadge = tabBar != null ? tabBar.setTabBarBadge(i, str) : false;
        if (tabBarBadge) {
            Page page = ((TmcFragment) this).page;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            TabBarRedDotMessage tabBarRedDotMessage = (tabBarMessageStore == null || (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) == null) ? null : (TabBarRedDotMessage) redDotMessageHashMap.get(Integer.valueOf(i));
            if (tabBarRedDotMessage != null) {
                tabBarRedDotMessage.setShowRedDot(false);
            }
            HashMap badgeMessageHashMap = tabBarMessageStore != null ? tabBarMessageStore.getBadgeMessageHashMap() : null;
            if (badgeMessageHashMap != null) {
            }
        }
        return tabBarBadge;
    }

    public boolean setTabBarItem(int i, MiniAppConfigModel.TabBarBean.ListBean listBean) {
        Intrinsics.h(listBean, "tab");
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            TabBar tabBar = getTabBar();
            Boolean valueOf = tabBar != null ? Boolean.valueOf(tabBar.updateTabItem(i, listBean, page)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        TmcLogger.d(TAG, "set tab item for index " + i + " with tab " + listBean + " is failed");
        return false;
    }

    public boolean setTabBarItems(ArrayList<MiniAppConfigModel.TabBarBean.ListBean> arrayList) {
        Intrinsics.h(arrayList, "tabs");
        Page page = ((TmcFragment) this).page;
        if (page != null) {
            TabBar tabBar = getTabBar();
            Boolean valueOf = tabBar != null ? Boolean.valueOf(tabBar.updateAllTabs(arrayList, page)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        TmcLogger.d(TAG, "set tab items is failed");
        return false;
    }

    public boolean setTabBarStyle(String str, String str2, String str3, String str4) {
        App app;
        TabBar tabBar = getTabBar();
        boolean tabBarStyle = tabBar != null ? tabBar.setTabBarStyle(str, str2, str3, str4) : false;
        if (tabBarStyle) {
            Page page = ((TmcFragment) this).page;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            if (tabBarMessageStore != null) {
                tabBarMessageStore.setTabBarStyle(new TabBarStyle(str, str2, str3, str4));
            }
        }
        return tabBarStyle;
    }

    public boolean shouldInterceptOnKeyDown() {
        return checkAlertBeforeUnload();
    }

    public final void showLoadingDialog() {
        try {
            TmcLogger.d(TAG, "showLoadingDialog");
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.base.f
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBaseFragment.showLoadingDialog$lambda$37(MiniAppBaseFragment.this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(TAG, "", th);
        }
    }

    public boolean showTabBar(boolean z) {
        TabBar tabBar = getTabBar();
        if (tabBar != null) {
            return tabBar.showTabBar(z);
        }
        return false;
    }

    public boolean showTabBarRedDot(int i) {
        HashMap badgeMessageHashMap;
        TabBarBadgeMessage tabBarBadgeMessage;
        App app;
        TabBar tabBar = getTabBar();
        boolean unreadVisible = tabBar != null ? tabBar.setUnreadVisible(i, true) : false;
        if (unreadVisible) {
            Page page = ((TmcFragment) this).page;
            TabBarMessageStore tabBarMessageStore = (page == null || (app = page.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
            HashMap redDotMessageHashMap = tabBarMessageStore != null ? tabBarMessageStore.getRedDotMessageHashMap() : null;
            if (redDotMessageHashMap != null) {
            }
            if (tabBarMessageStore != null && (badgeMessageHashMap = tabBarMessageStore.getBadgeMessageHashMap()) != null && (tabBarBadgeMessage = (TabBarBadgeMessage) badgeMessageHashMap.get(Integer.valueOf(i))) != null) {
                tabBarBadgeMessage.setShowBadge(false);
                tabBarBadgeMessage.setText((String) null);
            }
        }
        return unreadVisible;
    }

    public void showTabBarUnreadIcon(final int i, final String str, final Function1<? super Boolean, Unit> function1) {
        TabBar tabBar;
        Intrinsics.h(str, "iconPath");
        Page page = ((TmcFragment) this).page;
        if (page == null || (tabBar = getTabBar()) == null) {
            return;
        }
        tabBar.showTabBarUnreadIcon(i, str, page, new Function1<Boolean, Unit>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseFragment$showTabBarUnreadIcon$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z) {
                Page page2;
                HashMap redDotMessageHashMap;
                HashMap redDotMessageHashMap2;
                App app;
                if (z) {
                    page2 = ((TmcFragment) MiniAppBaseFragment.this).page;
                    TabBarRedDotMessage tabBarRedDotMessage = null;
                    TabBarMessageStore tabBarMessageStore = (page2 == null || (app = page2.getApp()) == null) ? null : (TabBarMessageStore) app.getData(TabBarMessageStore.class, true);
                    TabBarRedDotMessage tabBarRedDotMessage2 = (tabBarMessageStore == null || (redDotMessageHashMap2 = tabBarMessageStore.getRedDotMessageHashMap()) == null) ? null : (TabBarRedDotMessage) redDotMessageHashMap2.get(Integer.valueOf(i));
                    if (tabBarRedDotMessage2 != null) {
                        tabBarRedDotMessage2.setUnreadIcon(str);
                    }
                    if (tabBarMessageStore != null && (redDotMessageHashMap = tabBarMessageStore.getRedDotMessageHashMap()) != null) {
                        tabBarRedDotMessage = (TabBarRedDotMessage) redDotMessageHashMap.get(Integer.valueOf(i));
                    }
                    if (tabBarRedDotMessage != null) {
                        tabBarRedDotMessage.setShowUnreadIcon(true);
                    }
                }
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(Boolean.valueOf(z));
                }
            }
        });
    }

    public final void showVirtualNavBar() {
        View decorView = requireActivity().getWindow().getDecorView();
        Intrinsics.g(decorView, "requireActivity().window.decorView");
        decorView.setSystemUiVisibility(MemoryConstants.KB);
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public boolean startRefresh() {
        if (this.pullDownRefresh) {
            return getRefreshManager().startRefresh();
        }
        return false;
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public boolean stopLoadMore() {
        if (this.pullUpRefresh) {
            getRefreshManager().stopLoadMore();
        }
        return this.pullUpRefresh;
    }

    @Override // com.cloud.tmc.miniapp.action.RefreshAction
    public boolean stopRefresh() {
        if (this.pullDownRefresh) {
            getRefreshManager().stopRefresh();
        }
        return this.pullDownRefresh;
    }
}
