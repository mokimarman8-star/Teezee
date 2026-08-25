package com.cloud.tmc.miniapp.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.SoftHideKeyBoardUtil;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.callback.IAllowMFAHListener;
import com.cloud.tmc.integration.callback.IAppCallback;
import com.cloud.tmc.integration.callback.IAsyncStartLoadingCallback;
import com.cloud.tmc.integration.callback.ICheckMiniAppLifecycleCallback;
import com.cloud.tmc.integration.callback.IShowAddHomeCallback;
import com.cloud.tmc.integration.callback.ISubpackageLoadCheckCallback;
import com.cloud.tmc.integration.chain.app.AppChainContext;
import com.cloud.tmc.integration.chain.errorState.AppErrorState;
import com.cloud.tmc.integration.chain.insert.AppInsertState;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.minicover.NativeComponentManager;
import com.cloud.tmc.integration.model.AlertBeforeUnloadCache;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.CSMKBean;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ForegroundRangTime;
import com.cloud.tmc.integration.model.ForegroundTime;
import com.cloud.tmc.integration.model.MiniAppAutoOperationConfig;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.MiniAppUpdateMessageStore;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.model.StartTime;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.processor.intercept.IBackPressedIntercept;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.proxy.UpdateLoadingStepListener;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.app.BaseAppContext;
import com.cloud.tmc.integration.structure.app.TmcAppContext;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.ui.fragment.IFragmentManager;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.CreateShortCutUtils;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.DefaultExtensionManager;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.BundleUtils;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.TmcInitializer;
import com.cloud.tmc.miniapp.action.StatusAction;
import com.cloud.tmc.miniapp.action.VersionUpdateAction;
import com.cloud.tmc.miniapp.base.MiniAppBaseActivity;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.defaultimpl.OooO0OO;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.dialog.OooOOO0;
import com.cloud.tmc.miniapp.dialog.o0Oo0oo;
import com.cloud.tmc.miniapp.performanceanalyse.OooOO0O;
import com.cloud.tmc.miniapp.point.CreateBottomMenuPoint;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.OooOo;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.prestrategy.strategy.OooO00o;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.task.OooO0O0;
import com.cloud.tmc.miniapp.ui.extension.PinForLaterExtensionKt;
import com.cloud.tmc.miniapp.utils.AddHomeToastUtils;
import com.cloud.tmc.miniapp.utils.MessageBubbleUtils;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.OooO;
import com.cloud.tmc.miniapp.utils.OooOOO;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom1PopUpWindowView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom2PopUpWindowView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomBottomTipView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomTopTipView;
import com.cloud.tmc.miniapp.widget.popupview.MiniAddHomeTipDialogView;
import com.cloud.tmc.miniapp.widget.popupview.MsgBubblePopUpWindowView;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.cloud.tmc.miniutils.util.SystemUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class MiniAppActivity extends MiniAppBaseActivity implements StatusAction, VersionUpdateAction, OooOo, IOnRenderProcessGoneProxy.Listener, UpdateLoadingStepListener, ICheckMiniAppLifecycleCallback, StatusLayout.OooO00o, IAllowMFAHListener, OfflineAppProxy.CreateShortCutsListener, IShowAddHomeCallback {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MiniAppActivity";
    private final Lazy addHomeDialogView$delegate;
    private final AppChainContext appChainContext;
    private String appId;
    private final Lazy capsule$delegate;
    private PrepareController controller;
    private long currentDelayTime;
    private boolean delayShowError;
    private String devToken;
    private final Lazy dialog$delegate;
    private boolean enableQuickMode;
    private PrepareException errorException;
    private IEventCenter eventCenter;
    private boolean isFirstLaunch;
    private AtomicBoolean isResendH5PageStack;
    private boolean isValidOnResume;
    private final ActivityHelper mActivityHelper;
    private final ArrayList<Function0<Unit>> mMFAHInterceptList;
    private final Lazy mShowCompleteTaskQueue$delegate;
    private final Lazy mStatusLayout$delegate = LazyKt.b(new Function0<StatusLayout>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$mStatusLayout$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StatusLayout m65invoke() {
            return (StatusLayout) MiniAppActivity.this.findViewById(R.id.sl_status);
        }
    });
    private final Lazy miniAppPopWindowToken$delegate;
    private long miniappForegroundTime;
    private long miniappResumeTimestamp;
    private long miniappStartTime;
    private String mode;
    private String msgAppName;
    private long onPauseStopTimeStamp;
    private PrepareContext prepareContext;
    private final Lazy pvAddHomeBottomTip$delegate;
    private final Lazy pvAddHomeCustom1$delegate;
    private final Lazy pvAddHomeCustom2$delegate;
    private final Lazy pvAddHomeTopTip$delegate;
    private final Lazy pvMsgBubble$delegate;
    private PrepareController quickModeController;
    private boolean quickModeStartStatus;
    private String rootTaskId;
    private String sceneId;
    private final PopWindowManager.IPopWindowManagerController showMsgBubbleController;
    private boolean showOpenAppDialog;
    private Runnable showPopUpWindowRunnable;
    private String tempAppLogo;
    private String tempAppName;
    private Long uniqueChainId;
    private String version;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MiniAppActivity() {
        AppChainContext appChainContext = new AppChainContext();
        this.appChainContext = appChainContext;
        this.mActivityHelper = new ActivityHelper(this, appChainContext);
        this.capsule$delegate = LazyKt.b(new Function0<CapsuleView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$capsule$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CapsuleView m59invoke() {
                return (CapsuleView) MiniAppActivity.this.findViewById(R.id.capsule);
            }
        });
        this.pvAddHomeCustom1$delegate = LazyKt.b(new Function0<AddHomeCustom1PopUpWindowView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$pvAddHomeCustom1$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AddHomeCustom1PopUpWindowView m68invoke() {
                return (AddHomeCustom1PopUpWindowView) MiniAppActivity.this.findViewById(R.id.pv_add_home_custom1);
            }
        });
        this.pvAddHomeCustom2$delegate = LazyKt.b(new Function0<AddHomeCustom2PopUpWindowView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$pvAddHomeCustom2$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AddHomeCustom2PopUpWindowView m69invoke() {
                return (AddHomeCustom2PopUpWindowView) MiniAppActivity.this.findViewById(R.id.pv_add_home_custom2);
            }
        });
        this.pvAddHomeTopTip$delegate = LazyKt.b(new Function0<AddHomeCustomTopTipView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$pvAddHomeTopTip$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AddHomeCustomTopTipView m70invoke() {
                return (AddHomeCustomTopTipView) MiniAppActivity.this.findViewById(R.id.pv_add_home_top_tip);
            }
        });
        this.pvAddHomeBottomTip$delegate = LazyKt.b(new Function0<AddHomeCustomBottomTipView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$pvAddHomeBottomTip$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AddHomeCustomBottomTipView m67invoke() {
                return (AddHomeCustomBottomTipView) MiniAppActivity.this.findViewById(R.id.pv_add_home_bottom_tip);
            }
        });
        this.pvMsgBubble$delegate = LazyKt.b(new Function0<MsgBubblePopUpWindowView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$pvMsgBubble$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MsgBubblePopUpWindowView m71invoke() {
                return (MsgBubblePopUpWindowView) MiniAppActivity.this.findViewById(R.id.pv_msg_bubble);
            }
        });
        this.addHomeDialogView$delegate = LazyKt.b(new Function0<MiniAddHomeTipDialogView>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$addHomeDialogView$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MiniAddHomeTipDialogView m58invoke() {
                return (MiniAddHomeTipDialogView) MiniAppActivity.this.findViewById(R.id.add_home_dialog_view);
            }
        });
        this.isFirstLaunch = true;
        this.isValidOnResume = true;
        this.isResendH5PageStack = new AtomicBoolean(false);
        this.msgAppName = "";
        this.miniappStartTime = System.currentTimeMillis();
        this.miniAppPopWindowToken$delegate = LazyKt.b(new Function0<String>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$miniAppPopWindowToken$2
            {
                super(0);
            }

            public final String invoke() {
                return MiniAppActivity.this.getAppId() + "_" + MiniAppActivity.this.getMiniappStartTime();
            }
        });
        this.mShowCompleteTaskQueue$delegate = LazyKt.b(new Function0<OooO0O0>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$mShowCompleteTaskQueue$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final OooO0O0 m64invoke() {
                return new OooO0O0();
            }
        });
        this.mMFAHInterceptList = new ArrayList<>();
        this.tempAppLogo = "";
        this.tempAppName = "";
        this.dialog$delegate = LazyKt.b(new MiniAppActivity$dialog$2(this));
        this.rootTaskId = "";
        this.showMsgBubbleController = new PopWindowManager.IPopWindowManagerController() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showMsgBubbleController$1
            public void onRefresh(PopWindowManager.PopWindowData popWindowData) {
                Intrinsics.h(popWindowData, "bean");
                TmcLogger.d("MiniAppActivity", "onRefresh:" + (System.currentTimeMillis() - MiniAppActivity.this.getMiniappStartTime()));
                MiniAppActivity.this.showPopUpWindowRunnable(popWindowData.getDelayTime() - (System.currentTimeMillis() - MiniAppActivity.this.getMiniappStartTime()));
            }

            public void show(String str) {
                Intrinsics.h(str, "appId");
                TmcLogger.d("MiniAppActivity", "msgBubbleToast");
                try {
                    if (MiniAppActivity.this.getResumed()) {
                        MiniAppActivity.this.showMsgBubbleToast();
                    }
                } catch (Throwable th) {
                    TmcLogger.e("MiniAppActivity", th);
                }
            }
        };
    }

    public static /* synthetic */ void addScreen$default(MiniAppActivity miniAppActivity, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addScreen");
        }
        if ((i & 1) != 0) {
            str = "0";
        }
        miniAppActivity.addScreen(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backgroundDownloadZipAsync$lambda$35(MiniAppActivity miniAppActivity, boolean z) {
        Intrinsics.h(miniAppActivity, "this$0");
        miniAppActivity.dispatchOnUpdateApp(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void capsuleSetOnLeftClick() {
        AppModel appModel;
        if (isLoadStatusLoadingOrError()) {
            return;
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_MORE_ENTER, "");
        App app = this.mActivityHelper.getApp();
        if (app == null || (appModel = app.getAppModel()) == null) {
            return;
        }
        getDialog().show();
        OooOOO0 dialog = getDialog();
        dialog.getClass();
        Intrinsics.h(appModel, "appModel");
        if (TextUtils.isEmpty(appModel.getDeveloper())) {
            TextView OooO0OO = dialog.OooO0OO();
            if (OooO0OO != null) {
                OooO0OO.setVisibility(8);
            }
        } else {
            TextView OooO0OO2 = dialog.OooO0OO();
            if (OooO0OO2 != null) {
                OooO0OO2.setVisibility(0);
            }
            TextView OooO0OO3 = dialog.OooO0OO();
            if (OooO0OO3 != null) {
                OooO0OO3.setText(appModel.getDeveloper());
            }
        }
        TextView textView = (TextView) dialog.OooO0O0.getValue();
        if (textView != null) {
            textView.setText(appModel.getName());
        }
        dialog.OooO0oO = appModel.getAppId();
        ImageView imageView = (AppCompatImageView) dialog.OooO00o.getValue();
        if (imageView != null) {
            ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
            Context context = dialog.getContext();
            String logo = appModel.getLogo();
            String str = logo == null ? "" : logo;
            int dp2px = CommonExtKt.getDp2px(6);
            int i = R.drawable.drawable_app_icon_place_holder;
            imageLoaderProxy.loadImgRoundCorners(context, str, imageView, dp2px, i, i);
        }
        OooOOO0 dialog2 = getDialog();
        dialog2.getClass();
        Intrinsics.h(this, "activity");
        ((CreateBottomMenuPoint) ExtensionPoint.as(CreateBottomMenuPoint.class).create()).buildBottomDialog(this, dialog2);
    }

    public static /* synthetic */ void capsuleSetOnRightClick$default(MiniAppActivity miniAppActivity, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: capsuleSetOnRightClick");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        miniAppActivity.capsuleSetOnRightClick(z);
    }

    private final boolean checkAddHomeForbidShowPopWindow(String str) {
        try {
            Object fromJson = GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_ADD_HOME_FORBID_ID, "[\"1000886706715795456\",\"1000391591855976448\",\"1000497027976413184\"]"), (Class<Object>) List.class);
            List list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList();
            }
            return list.contains(str);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            return false;
        }
    }

    private final void checkAddHomeTipStatus() {
        String str;
        String str2;
        String str3;
        try {
            AddHomeCustomTopTipView pvAddHomeTopTip = getPvAddHomeTopTip();
            if (pvAddHomeTopTip != null && (str3 = this.appId) != null && pvAddHomeTopTip.OooO0oo) {
                pvAddHomeTopTip.OooO0oo = false;
                pvAddHomeTopTip.OooO00o(str3, pvAddHomeTopTip.OooO0oO, pvAddHomeTopTip.OooO);
            }
            AddHomeCustomBottomTipView pvAddHomeBottomTip = getPvAddHomeBottomTip();
            if (pvAddHomeBottomTip != null && (str2 = this.appId) != null) {
                TmcLogger.d(pvAddHomeBottomTip.OooO0oO, "checkAddHomeBottomTipStatus");
                if (pvAddHomeBottomTip.OooOO0) {
                    pvAddHomeBottomTip.OooOO0 = false;
                    pvAddHomeBottomTip.OooO00o(str2, pvAddHomeBottomTip.OooO, pvAddHomeBottomTip.OooOO0O);
                }
            }
            MiniAddHomeTipDialogView addHomeDialogView = getAddHomeDialogView();
            if (addHomeDialogView == null || (str = this.appId) == null || !addHomeDialogView.OooOO0O) {
                return;
            }
            addHomeDialogView.OooOO0O = false;
            addHomeDialogView.OooO00o(str, addHomeDialogView.OooOO0, addHomeDialogView.OooOO0o);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final void checkAndExecuteAddHomeAutoTips(MiniAppAutoOperationConfig miniAppAutoOperationConfig, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (miniAppAutoOperationConfig != null) {
            showAddHomeTips(str, miniAppAutoOperationConfig);
            return;
        }
        TmcLogger.d(TAG, "checkAndExecuteAddHomeAutoTips miniAppAutoExecuteConfig is null ->" + str);
    }

    public static /* synthetic */ void checkAndShowAddHomeCustomToast$default(MiniAppActivity miniAppActivity, int i, long j, long j2, String str, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkAndShowAddHomeCustomToast");
        }
        miniAppActivity.checkAndShowAddHomeCustomToast(i, j, j2, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void dispatchOnCheckForUpdateListener() {
        WeakHashMap onCheckForUpdate;
        BridgeCallback bridgeCallback;
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String str = this.appId;
        if (str == null) {
            str = "";
        }
        boolean isNeedUpdate = miniAppLaunch.isNeedUpdate(this, str);
        App app = this.mActivityHelper.getApp();
        MiniAppUpdateMessageStore miniAppUpdateMessageStore = app != null ? (MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class) : null;
        if (miniAppUpdateMessageStore == null || (onCheckForUpdate = miniAppUpdateMessageStore.getOnCheckForUpdate()) == null || (bridgeCallback = (BridgeCallback) onCheckForUpdate.get(this.appId)) == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hasUpdate", Boolean.valueOf(isNeedUpdate));
        bridgeCallback.sendSuccessResponse(jsonObject);
    }

    private final void dispatchOnUpdateApp(boolean z) {
        WeakHashMap onUpdateFailed;
        BridgeCallback bridgeCallback;
        WeakHashMap onUpdateReady;
        BridgeCallback bridgeCallback2;
        App app = this.mActivityHelper.getApp();
        MiniAppUpdateMessageStore miniAppUpdateMessageStore = app != null ? (MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class) : null;
        if (z) {
            if (miniAppUpdateMessageStore == null || (onUpdateReady = miniAppUpdateMessageStore.getOnUpdateReady()) == null || (bridgeCallback2 = (BridgeCallback) onUpdateReady.get(this.appId)) == null) {
                return;
            }
            bridgeCallback2.sendSuccessResponse();
            return;
        }
        if (miniAppUpdateMessageStore == null || (onUpdateFailed = miniAppUpdateMessageStore.getOnUpdateFailed()) == null || (bridgeCallback = (BridgeCallback) onUpdateFailed.get(this.appId)) == null) {
            return;
        }
        bridgeCallback.sendSuccessResponse();
    }

    public static /* synthetic */ void finishMiniActivity$default(MiniAppActivity miniAppActivity, TmcFragment.ExitType exitType, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishMiniActivity");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        miniAppActivity.finishMiniActivity(exitType, z);
    }

    private final MiniAddHomeTipDialogView getAddHomeDialogView() {
        return (MiniAddHomeTipDialogView) this.addHomeDialogView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle getAppBrandBundle(AppModel appModel) {
        Bundle bundle = new Bundle();
        try {
            String name = appModel.getName();
            String str = "";
            if (name == null) {
                name = "";
            }
            bundle.putString(TmcConstants.EXTRA_APP_NAME, name);
            String miniAppVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel);
            if (miniAppVersion != null) {
                str = miniAppVersion;
            }
            bundle.putString(TmcConstants.EXTRA_APP_INFO_VERSION, str);
            bundle.putString(TmcConstants.EXTRA_APP_INFO_DESC, appModel.getDesc());
            bundle.putString(TmcConstants.EXTRA_APP_INFO_LOGO_URL, appModel.getLogo());
            bundle.putString(TmcConstants.EXTRA_APP_INFO_REGISTER_TYPE, appModel.getRegisterType());
            bundle.putString(TmcConstants.EXTRA_APP_INFO_DEVELOPER, appModel.getDeveloper());
            bundle.putLong(TmcConstants.EXTRA_APP_INFO_RLEASE_TIME, appModel.getReleaseTime());
        } catch (Throwable unused) {
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OooOOO0 getDialog() {
        return (OooOOO0) this.dialog$delegate.getValue();
    }

    private final OooO0O0 getMShowCompleteTaskQueue() {
        return (OooO0O0) this.mShowCompleteTaskQueue$delegate.getValue();
    }

    private final StatusLayout getMStatusLayout() {
        return (StatusLayout) this.mStatusLayout$delegate.getValue();
    }

    private final AddHomeCustomBottomTipView getPvAddHomeBottomTip() {
        return (AddHomeCustomBottomTipView) this.pvAddHomeBottomTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddHomeCustom1PopUpWindowView getPvAddHomeCustom1() {
        return (AddHomeCustom1PopUpWindowView) this.pvAddHomeCustom1$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddHomeCustom2PopUpWindowView getPvAddHomeCustom2() {
        return (AddHomeCustom2PopUpWindowView) this.pvAddHomeCustom2$delegate.getValue();
    }

    private final AddHomeCustomTopTipView getPvAddHomeTopTip() {
        return (AddHomeCustomTopTipView) this.pvAddHomeTopTip$delegate.getValue();
    }

    private final MsgBubblePopUpWindowView getPvMsgBubble() {
        return (MsgBubblePopUpWindowView) this.pvMsgBubble$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideStatusLoading$lambda$10(final MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        if (miniAppActivity.showComplete()) {
            String str = miniAppActivity.appId;
            if (str != null) {
                miniAppActivity.miniappStartTime = System.currentTimeMillis();
                String str2 = null;
                MiniForceAddHomeManager.notifyHideLoading$default(MiniForceAddHomeManager.INSTANCE, str, (BridgeCallback) null, 2, (Object) null);
                App app = miniAppActivity.mActivityHelper.getApp();
                if (app != null) {
                    app.setAppStartTime(miniAppActivity.miniappStartTime);
                }
                App app2 = miniAppActivity.mActivityHelper.getApp();
                if (app2 != null) {
                    app2.setAddhomeShowCallback(miniAppActivity);
                }
                AppNode app3 = miniAppActivity.mActivityHelper.getApp();
                if (app3 != null && !miniAppActivity.enableQuickMode) {
                    AppNode appNode = app3 instanceof AppNode ? app3 : null;
                    if (appNode != null) {
                        appNode.setAsyncLaunchStatus(true);
                    }
                }
                miniAppActivity.getMShowCompleteTaskQueue().OooO00o();
                boolean z = false;
                try {
                    if (MessageBubbleUtils.OooO00o.OooO0O0()) {
                        z = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_BUBBLE_ENABLE, false);
                    }
                } catch (Throwable th) {
                    TmcLogger.e("MessageBubbleUtils", th);
                }
                if (z) {
                    MessageBubbleUtils messageBubbleUtils = MessageBubbleUtils.OooO00o;
                    App app4 = miniAppActivity.mActivityHelper.getApp();
                    com.cloud.tmc.miniapp.utils.OooO0O0 oooO0O0 = new com.cloud.tmc.miniapp.utils.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$hideStatusLoading$2$1$2
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.cloud.tmc.miniapp.ui.MiniAppActivity] */
                        @Override // com.cloud.tmc.miniapp.utils.OooO0O0
                        public void show(String str3, String str4) {
                            if (str3 != null) {
                                ?? r0 = MiniAppActivity.this;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                r0.setMsgAppName(str4);
                                MessageBubbleUtils.OooO00o.OooO00o(r0, str3, r0.getMiniAppPopWindowToken(), r0.getShowMsgBubbleController());
                            }
                        }
                    };
                    if (app4 != null) {
                        try {
                            str2 = app4.getAppId();
                        } catch (Throwable th2) {
                            TmcLogger.e("MessageBubbleUtils", th2);
                        }
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (!messageBubbleUtils.OooO00o(str2)) {
                        if (NetworkUtils.isConnected()) {
                            TmcLogger.d("MessageBubbleUtils", "refreshMsgBubble -> requestMsgInfo");
                            messageBubbleUtils.OooO0O0(app4, oooO0O0);
                        } else {
                            messageBubbleUtils.OooO00o(app4, oooO0O0);
                        }
                    }
                }
            }
            String str3 = miniAppActivity.appId;
            if (str3 != null) {
                OooO00o oooO00o = OooO00o.OooO00o;
                Intrinsics.h(str3, "appId");
                try {
                    OooO00o.OooO0O0.remove(str3);
                } catch (Throwable th3) {
                    TmcLogger.e(OooO00o.OooO0OO, "removePreAppinfo", th3);
                }
            }
            try {
                ExecutorUtils.execute(ExecutorType.IDLE, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppActivity.hideStatusLoading$lambda$10$lambda$7(MiniAppActivity.this);
                    }
                });
            } catch (Throwable th4) {
                TmcLogger.e(TAG, th4);
            }
            if (miniAppActivity.appId != null) {
                try {
                    ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniAppActivity.hideStatusLoading$lambda$10$lambda$9$lambda$8();
                        }
                    });
                } catch (Throwable th5) {
                    TmcLogger.e(TAG, th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void hideStatusLoading$lambda$10$lambda$7(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        try {
            com.cloud.tmc.miniapp.prestrategy.OooO00o oooO00o = com.cloud.tmc.miniapp.prestrategy.OooO00o.OooO00o;
            Application application = miniAppActivity.getApplication();
            Intrinsics.g(application, "this.application");
            oooO00o.OooO0OO(application);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideStatusLoading$lambda$10$lambda$9$lambda$8() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideStatusLoadingDelay$lambda$1(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        miniAppActivity.hideStatusLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initMiniActivityData() {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        String str;
        Bundle startParams;
        Bundle startParams2;
        Bundle startParams3;
        Bundle startParams4;
        Bundle bundle4;
        Bundle bundle5;
        String string;
        if (getSavedInstance() != null) {
            Bundle savedInstance = getSavedInstance();
            if (savedInstance == null || (string = savedInstance.getString(TmcConstants.EXTRA_APP_ID)) == null) {
                MiniAppLaunch.INSTANCE.reportMiniAppLauncherFailedTrack(this.appId, "3");
                TmcLogger.d(TAG, "savedInstance is not null,appId is null");
                finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
                return;
            } else {
                this.appId = string;
                Bundle savedInstance2 = getSavedInstance();
                this.mode = savedInstance2 != null ? savedInstance2.getString("mode") : null;
                Bundle savedInstance3 = getSavedInstance();
                this.version = savedInstance3 != null ? savedInstance3.getString(TmcConstants.EXTRA_APP_INFO_VERSION) : null;
                Bundle savedInstance4 = getSavedInstance();
                this.devToken = savedInstance4 != null ? savedInstance4.getString(TmcConstants.EXTRA_APP_DEV_TOKEN) : null;
            }
        } else {
            try {
                if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_ENABLE_NEW_INIT, true)) {
                    newDataInitialize();
                } else {
                    oldDataInitialize();
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                oldDataInitialize();
            }
            this.enableQuickMode = getBoolean(TmcConstants.EXTRA_APP_ENABLE_QUICK_MODE);
        }
        String str2 = this.appId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        NewTaskManager.Companion companion = NewTaskManager.Companion;
        companion.updateTaskIdByAppId(this.appId, getTaskId());
        MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
        miniForceAddHomeManager.addMFAHListener(this.appId, this);
        this.mActivityHelper.setAppId(this.appId);
        ((LogEProxy) TmcProxy.get(LogEProxy.class)).init(this.appId);
        IUpdateLoadingStepProxy iUpdateLoadingStepProxy = (IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class);
        String str3 = this.appId;
        if (str3 == null) {
            str3 = "";
        }
        iUpdateLoadingStepProxy.addUpdateLoadingListener(str3, this);
        OfflineManager.addOfflineLifecycleObserver(this.appId, getLifecycle());
        if (companion.getInstance().checkUseSingleTaskMode(this.appId)) {
            String taskRootAppId = companion.getInstance().getTaskRootAppId();
            if (taskRootAppId == null) {
                taskRootAppId = "";
            }
            this.rootTaskId = taskRootAppId;
            TmcLogger.d(TAG, "tootTaskId:" + taskRootAppId);
        }
        TmcLogger.d(TAG, "initMiniActivityData:checkTaskId:" + this.appId);
        companion.getInstance().checkTaskId(this.appId, getClass());
        StartClientBundle parcelable = BundleUtils.getParcelable(getBundle(), TmcConstants.EXTRA_START_BUNDLE);
        if (parcelable != null) {
            try {
                bundle = parcelable.startParams;
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "", th2);
            }
        } else {
            bundle = null;
        }
        miniForceAddHomeManager.checkForceAddHome(bundle);
        VirtualAppManager virtualAppManager = (VirtualAppManager) TmcProxy.get(VirtualAppManager.class);
        String str4 = this.appId;
        if (parcelable == null || (bundle2 = parcelable.startParams) == null) {
            bundle2 = new Bundle();
        }
        if (parcelable == null || (bundle3 = parcelable.sceneParams) == null) {
            bundle3 = new Bundle();
        }
        virtualAppManager.startApp(str4, bundle2, bundle3);
        OooOO0O.OooO00o oooO00o = OooOO0O.OooO0o0;
        this.uniqueChainId = Long.valueOf(OooOO0O.OooO0o.addAndGet(1L) + (Process.myPid() * 1000000));
        if (this.quickModeStartStatus) {
            this.enableQuickMode = false;
        }
        String str5 = this.appId;
        if (str5 == null) {
            str5 = "";
        }
        Bundle bundle6 = new Bundle();
        bundle6.putString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, String.valueOf(this.uniqueChainId));
        if (parcelable != null && (bundle5 = parcelable.startParams) != null) {
            bundle6.putAll(bundle5);
        }
        Unit unit = Unit.a;
        Bundle bundle7 = new Bundle();
        if (parcelable != null && (bundle4 = parcelable.sceneParams) != null) {
            bundle7.putAll(bundle4);
        }
        PrepareContext prepareContext = new PrepareContext(this, str5, bundle6, bundle7, false, this.appChainContext, this, (AtomicBoolean) null, 144, (DefaultConstructorMarker) null);
        this.prepareContext = prepareContext;
        prepareContext.setAppType(this.mode);
        PrepareContext prepareContext2 = this.prepareContext;
        if (prepareContext2 != null) {
            prepareContext2.setAppVersion(this.version);
        }
        PrepareContext prepareContext3 = this.prepareContext;
        if (prepareContext3 != null) {
            prepareContext3.setAppToken(this.devToken);
        }
        PrepareContext prepareContext4 = this.prepareContext;
        if (prepareContext4 != null) {
            prepareContext4.setQuickMode(this.enableQuickMode);
        }
        if (this.enableQuickMode) {
            ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(this.appId, "quickStart");
        }
        ((SessionUtilProxy) TmcProxy.get(SessionUtilProxy.class)).updateSession(this.appId, false, true);
        if (getInitDataChannel() == 0) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String str6 = this.appId;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LAUNCH_MINIAPP_START;
            Bundle bundle8 = new Bundle();
            bundle8.putString("miniapp_id", this.appId);
            bundle8.putString("queryShortcutExist", String.valueOf(AppUtils.INSTANCE.queryShortcutExist(this, this.appId)));
            PrepareContext prepareContext5 = this.prepareContext;
            bundle8.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, (prepareContext5 == null || (startParams4 = prepareContext5.getStartParams()) == null) ? null : startParams4.getString("scene_id", "100000"));
            PrepareContext prepareContext6 = this.prepareContext;
            this.sceneId = (prepareContext6 == null || (startParams3 = prepareContext6.getStartParams()) == null) ? null : startParams3.getString("scene_id", "100000");
            PrepareContext prepareContext7 = this.prepareContext;
            bundle8.putString("fis_type", (prepareContext7 == null || (startParams2 = prepareContext7.getStartParams()) == null) ? null : startParams2.getString("fis_type", "0"));
            str = "";
            performanceAnalyseProxy.record(str6, pointAnalyseType, str, bundle8);
        } else {
            str = "";
        }
        Bundle bundle9 = new Bundle();
        bundle9.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        String str7 = ChainPoint.CHAIN_ID;
        PrepareContext prepareContext8 = this.prepareContext;
        bundle9.putString(str7, (prepareContext8 == null || (startParams = prepareContext8.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_CHAIN_START, ChainPoint.app, bundle9);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String str8 = this.appId;
        performanceAnalyseProxy2.record(str8, PointAnalyseType.POINT_START, String.valueOf(str8));
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String str9 = this.appId;
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_PAGE_PV;
        Bundle bundle10 = new Bundle();
        bundle10.putString("miniapp_id", this.appId);
        performanceAnalyseProxy3.record(str9, pointAnalyseType2, str, bundle10);
        ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.initMiniActivityData$lambda$62(MiniAppActivity.this);
            }
        });
        recordStart1s();
        ((CreateBottomMenuPoint) ExtensionPoint.as(CreateBottomMenuPoint.class).create()).requestBottomAbilityConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMiniActivityData$lambda$62(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        boolean z = miniAppActivity.enableQuickMode;
        if (z) {
            PrepareController createQuickModePrepareController = ((IClientStarter) TmcProxy.get(IClientStarter.class)).createQuickModePrepareController(miniAppActivity.prepareContext, new OooO0OO(miniAppActivity.prepareContext, miniAppActivity));
            miniAppActivity.quickModeController = createQuickModePrepareController;
            if (createQuickModePrepareController != null) {
                createQuickModePrepareController.start();
                return;
            }
            return;
        }
        PrepareContext prepareContext = miniAppActivity.prepareContext;
        if (prepareContext != null) {
            prepareContext.setVirtualStart(z);
        }
        PrepareController createPrepareController = ((IClientStarter) TmcProxy.get(IClientStarter.class)).createPrepareController(miniAppActivity.prepareContext, new OooO0OO(miniAppActivity.prepareContext, miniAppActivity));
        miniAppActivity.controller = createPrepareController;
        if (createPrepareController != null) {
            createPrepareController.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$50(MiniAppActivity miniAppActivity, int i) {
        Intrinsics.h(miniAppActivity, "this$0");
        StatusLayout statusLayout = miniAppActivity.getStatusLayout();
        if (statusLayout != null) {
            statusLayout.setBackgroundColor(i);
            TmcLogger.d(TAG, "setHostActivityStatusBackground: 设置 activity 的状态布局背景色成功");
        }
        TmcLogger.d(TAG, "setHostActivityStatusBackground: 执行完毕");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadError$lambda$16(PrepareException prepareException, final MiniAppActivity miniAppActivity) {
        String code;
        String str;
        String code2;
        Intrinsics.h(miniAppActivity, "this$0");
        Integer valueOf = (prepareException == null || (code2 = prepareException.getCode()) == null) ? null : Integer.valueOf(Integer.parseInt(code2));
        int parseInt = Integer.parseInt("3");
        if (valueOf != null && valueOf.intValue() == parseInt) {
            code = prepareException != null ? prepareException.getCode() : null;
            str = code != null ? code : "0";
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(str));
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle);
            new AppInsertState(bundle).setChainContext(miniAppActivity.appChainContext);
            miniAppActivity.showNoNetwork(prepareException);
            return;
        }
        int parseInt2 = Integer.parseInt("4");
        if (valueOf != null && valueOf.intValue() == parseInt2) {
            code = prepareException != null ? prepareException.getCode() : null;
            str = code != null ? code : "0";
            Bundle bundle2 = new Bundle();
            bundle2.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(str));
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle2);
            new AppInsertState(bundle2).setChainContext(miniAppActivity.appChainContext);
            if (NetworkUtils.isConnected()) {
                StatusAction.DefaultImpls.showUnstableNetwork$default(miniAppActivity, new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$loadError$1$2
                    @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                    public void onRetry(StatusLayout statusLayout) {
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String appId = MiniAppActivity.this.getAppId();
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                        Unit unit = Unit.a;
                        performanceAnalyseProxy.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle3);
                        MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
                    }
                }, 0, null, miniAppActivity.appId, PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity), 6, null);
                return;
            } else {
                StatusAction.DefaultImpls.showNoNetwork$default(miniAppActivity, new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$loadError$1$1
                    @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                    public void onRetry(StatusLayout statusLayout) {
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String appId = MiniAppActivity.this.getAppId();
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                        Unit unit = Unit.a;
                        performanceAnalyseProxy.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle3);
                        MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
                    }
                }, 0, null, miniAppActivity.appId, PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity), 6, null);
                return;
            }
        }
        if (valueOf != null && valueOf.intValue() == 9) {
            code = prepareException != null ? prepareException.getCode() : null;
            str = code != null ? code : "0";
            Bundle bundle3 = new Bundle();
            bundle3.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(str));
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle3);
            new AppInsertState(bundle3).setChainContext(miniAppActivity.appChainContext);
            Integer viewThemeMode = miniAppActivity.getViewThemeMode();
            StatusAction.DefaultImpls.showErrorLayout$default(miniAppActivity, (viewThemeMode != null && viewThemeMode.intValue() == 2) ? R.drawable.mini_ic_closed_normal_mode : R.drawable.mini_ic_closed, R.string.loading_error_miniapp_closed, (StatusLayout.OooO0O0) null, (String) null, (StatusLayout.OooO00o) null, 24, (Object) null);
            return;
        }
        if (valueOf == null || valueOf.intValue() != 30004) {
            try {
                miniAppActivity.showErrorLayout(prepareException, PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity));
                return;
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                miniAppActivity.showErrorLayout(prepareException, PinForLaterExtensionKt.getPinForLaterListener(miniAppActivity));
                return;
            }
        }
        code = prepareException != null ? prepareException.getCode() : null;
        str = code != null ? code : "0";
        Bundle bundle4 = new Bundle();
        bundle4.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(str));
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle4);
        new AppInsertState(bundle4).setChainContext(miniAppActivity.appChainContext);
        Integer viewThemeMode2 = miniAppActivity.getViewThemeMode();
        StatusAction.DefaultImpls.showErrorLayout$default(miniAppActivity, (viewThemeMode2 != null && viewThemeMode2.intValue() == 2) ? R.drawable.mini_ic_no_available_normal_mode : R.drawable.mini_ic_no_available, R.string.loading_error_miniapp_no_longer_available, (StatusLayout.OooO0O0) null, (String) null, (StatusLayout.OooO00o) null, 24, (Object) null);
    }

    private final boolean nativeComponentIntercept() {
        Page activePage;
        IRender render;
        String renderId;
        try {
            App app = this.mActivityHelper.getApp();
            if (app == null || (activePage = app.getActivePage()) == null || (render = activePage.getRender()) == null || (renderId = render.getRenderId()) == null) {
                return false;
            }
            return NativeComponentManager.INSTANCE.shouldInterceptBackPressed(renderId);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            return false;
        }
    }

    private final void newDataInitialize() {
        String str = this.appId;
        if (str == null || str.length() == 0) {
            String string = getString(TmcConstants.EXTRA_APP_ID);
            if (string == null) {
                MiniAppLaunch.INSTANCE.reportMiniAppLauncherFailedTrack(this.appId, "5");
                TmcLogger.d(TAG, "newDataInitialize appId is null");
                finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
                return;
            }
            this.appId = string;
        }
        String str2 = this.mode;
        if (str2 == null || str2.length() == 0) {
            this.mode = getString("mode");
        }
        String str3 = this.version;
        if (str3 == null || str3.length() == 0) {
            this.version = getString(TmcConstants.EXTRA_APP_INFO_VERSION);
        }
        String str4 = this.devToken;
        if (str4 == null || str4.length() == 0) {
            this.devToken = getString(TmcConstants.EXTRA_APP_DEV_TOKEN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyShowAddHome$lambda$96(int i, MiniAppActivity miniAppActivity) {
        MsgBubblePopUpWindowView pvMsgBubble;
        MiniAddHomeTipDialogView addHomeDialogView;
        AddHomeCustomBottomTipView pvAddHomeBottomTip;
        Intrinsics.h(miniAppActivity, "this$0");
        if (i > 81) {
            try {
                if (miniAppActivity.getPvMsgBubble() != null && (pvMsgBubble = miniAppActivity.getPvMsgBubble()) != null) {
                    ViewExtKt.toGone(pvMsgBubble);
                }
                AddHomeCustomTopTipView pvAddHomeTopTip = miniAppActivity.getPvAddHomeTopTip();
                if (pvAddHomeTopTip != null) {
                    ViewExtKt.toGone(pvAddHomeTopTip);
                }
                AddHomeCustom1PopUpWindowView pvAddHomeCustom1 = miniAppActivity.getPvAddHomeCustom1();
                if (pvAddHomeCustom1 != null) {
                    ViewExtKt.toGone(pvAddHomeCustom1);
                }
                AddHomeCustom2PopUpWindowView pvAddHomeCustom2 = miniAppActivity.getPvAddHomeCustom2();
                if (pvAddHomeCustom2 != null) {
                    ViewExtKt.toGone(pvAddHomeCustom2);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (i > 82 && (pvAddHomeBottomTip = miniAppActivity.getPvAddHomeBottomTip()) != null) {
            ViewExtKt.toGone(pvAddHomeBottomTip);
        }
        if (i <= 83 || (addHomeDialogView = miniAppActivity.getAddHomeDialogView()) == null) {
            return;
        }
        addHomeDialogView.OooO00o(false);
    }

    private final void oldDataInitialize() {
        String string = getString(TmcConstants.EXTRA_APP_ID);
        if (string == null) {
            MiniAppLaunch.INSTANCE.reportMiniAppLauncherFailedTrack(this.appId, "2");
            TmcLogger.d(TAG, "oldDataInitialize appId is null");
            finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
        } else {
            this.appId = string;
            this.mode = getString("mode");
            this.version = getString(TmcConstants.EXTRA_APP_INFO_VERSION);
            this.devToken = getString(TmcConstants.EXTRA_APP_DEV_TOKEN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroy$lambda$78() {
        try {
            CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
            if (createShortCutUtils.getAddHomeAppIdList().isEmpty()) {
                return;
            }
            Iterator it = createShortCutUtils.getAddHomeAppIdList().iterator();
            while (it.hasNext()) {
                CreateShortCutUtils.INSTANCE.getAppMap().remove((String) it.next());
            }
            CreateShortCutUtils.INSTANCE.getAddHomeAppIdList().clear();
        } catch (Throwable th) {
            TmcLogger.e(TAG, "onDestroy", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onPinForLaterClick$lambda$94$lambda$93(MiniAppActivity miniAppActivity, String str) {
        Intrinsics.h(miniAppActivity, "this$0");
        Intrinsics.h(str, "$it");
        PreStrategyManager.OooO00o.OooO00o((Context) miniAppActivity, CollectionsKt.q(new String[]{str}), TmcConstants.KEY_PREFETCH_PIN);
    }

    private final void recordStart1s() {
        try {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.x
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.recordStart1s$lambda$64(MiniAppActivity.this);
                }
            }, 1000L);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "report error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recordStart1s$lambda$64(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        try {
            StatusLayout statusLayout = miniAppActivity.getStatusLayout();
            if (statusLayout == null || !statusLayout.OooOOOo) {
                if (miniAppActivity.getResumed()) {
                    ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    String str = miniAppActivity.appId;
                    Bundle bundle = new Bundle();
                    bundle.putString("miniappid", miniAppActivity.appId);
                    Unit unit = Unit.a;
                    reportProxy.report(str, "miniapp_start_suc", bundle);
                } else {
                    TmcLogger.d(TAG, "not report miniapp_start_suc ,resume is false");
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "report error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAppInfo$lambda$34(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        miniAppActivity.dispatchOnCheckForUpdateListener();
    }

    public static /* synthetic */ void reload$default(MiniAppActivity miniAppActivity, boolean z, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reload");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        miniAppActivity.reload(z, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$25(MiniAppActivity miniAppActivity, Bundle bundle, boolean z) {
        Intrinsics.h(miniAppActivity, "this$0");
        miniAppActivity.isFirstLaunch = true;
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra(TmcConstants.EXTRA_LAUNCH_MODE, TmcConstants.EXTRA_LAUNCH_MODE_COLD);
            super.onNewIntent(intent);
        }
        if (z) {
            App app = miniAppActivity.mActivityHelper.getApp();
            if (app != null) {
                app.putBooleanValue(TmcConstants.MINIAPP_RELOAD, true);
            }
            if (app != null) {
                app.exit();
            }
        }
        miniAppActivity.showStatusLoading();
        miniAppActivity.setInitDataChannel(1);
        miniAppActivity.initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showAddHomeTips(final String str, final MiniAppAutoOperationConfig miniAppAutoOperationConfig) {
        if (!MiniForceAddHomeManager.INSTANCE.checkInterectMFAH(str)) {
            if (AppUtils.INSTANCE.queryShortcutExist(this, this.appId)) {
                return;
            }
            ExecutorUtils.execute(ExecutorType.UI, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.v
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.showAddHomeTips$lambda$11(MiniAppActivity.this, str, miniAppAutoOperationConfig);
                }
            });
        } else {
            TmcLogger.d(TAG, "showAddHomeTips checkInterectMFAH is true ->" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAddHomeTips$lambda$11(MiniAppActivity miniAppActivity, String str, MiniAppAutoOperationConfig miniAppAutoOperationConfig) {
        Intrinsics.h(miniAppActivity, "this$0");
        Intrinsics.h(str, "$miniappId");
        Intrinsics.h(miniAppAutoOperationConfig, "$miniAppAutoExecuteConfig");
        try {
            TmcLogger.d(TAG, "addhomeStatus is false");
            AddHomeCustomTopTipView pvAddHomeTopTip = miniAppActivity.getPvAddHomeTopTip();
            if (pvAddHomeTopTip != null) {
                MiniAppAutoPopover topPopover = miniAppAutoOperationConfig.getTopPopover();
                int i = AddHomeCustomTopTipView.OooOO0o;
                pvAddHomeTopTip.OooO00o(str, topPopover, 0L);
            }
            AddHomeCustomBottomTipView pvAddHomeBottomTip = miniAppActivity.getPvAddHomeBottomTip();
            if (pvAddHomeBottomTip != null) {
                MiniAppAutoPopover bottomPopover = miniAppAutoOperationConfig.getBottomPopover();
                int i2 = AddHomeCustomBottomTipView.OooOOO0;
                pvAddHomeBottomTip.OooO00o(str, bottomPopover, 0L);
            }
            MiniAddHomeTipDialogView addHomeDialogView = miniAppActivity.getAddHomeDialogView();
            if (addHomeDialogView != null) {
                MiniAppAutoPopover exitReminder = miniAppAutoOperationConfig.getExitReminder();
                int i3 = MiniAddHomeTipDialogView.OooOOOo;
                addHomeDialogView.OooO00o(str, exitReminder, 0L);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final void showErrorLayout(PrepareException prepareException, StatusLayout.OooO00o oooO00o) {
        String code = prepareException != null ? prepareException.getCode() : null;
        if (code == null) {
            code = "0";
        }
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(code));
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle);
        new AppInsertState(bundle).setChainContext(this.appChainContext);
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String str = this.appId;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 4);
        Unit unit = Unit.a;
        performanceAnalyseProxy.recordForCommon(str, TmcConstants.REPORTER_NO_NET_WORK_PAGE, bundle2);
        showError(new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showErrorLayout$2
            @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
            public void onRetry(StatusLayout statusLayout) {
                PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                String appId = MiniAppActivity.this.getAppId();
                Bundle bundle3 = new Bundle();
                bundle3.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 4);
                Unit unit2 = Unit.a;
                performanceAnalyseProxy2.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle3);
                MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
            }
        }, R.string.loading_error_tv, prepareException != null ? prepareException.getMessage() : null, this.appId, oooO00o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingPage() {
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.w
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.showLoadingPage$lambda$83(MiniAppActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingPage$lambda$83(MiniAppActivity miniAppActivity) {
        AppModel appModel;
        Intrinsics.h(miniAppActivity, "this$0");
        if (miniAppActivity.errorException != null) {
            TmcLogger.d(TAG, "showAsyncStatusLoading loadError");
            miniAppActivity.loadError(null, miniAppActivity.errorException);
            miniAppActivity.errorException = null;
            return;
        }
        TmcLogger.d(TAG, "showAsyncStatusLoading showLoading");
        miniAppActivity.showLoading();
        App app = miniAppActivity.mActivityHelper.getApp();
        if (app == null || (appModel = app.getAppModel()) == null) {
            return;
        }
        String name = appModel.getName();
        if (name == null) {
            name = "";
        }
        String logo = appModel.getLogo();
        miniAppActivity.showLoadingLogo(name, logo != null ? logo : "");
        miniAppActivity.updateStepProgress(LoadStepAction.STEP_START_LOADING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showLoadingView$lambda$44(final EntryInfo entryInfo, MiniAppActivity miniAppActivity) {
        String str;
        Unit unit;
        Intrinsics.h(miniAppActivity, "this$0");
        if (entryInfo != null) {
            try {
                str = miniAppActivity.getString(R.string.dialog_loading_tv);
            } catch (Throwable unused) {
                str = "Loading...";
            }
            Intrinsics.g(str, "try {\n                  …ing...\"\n                }");
            String str2 = entryInfo.title;
            if (str2 != null) {
                str = str2;
            }
            miniAppActivity.showLoadingLogo(str, StringExtKt.orDefault(entryInfo.iconUrl, ""));
            miniAppActivity.addMFAHInterceptAction(entryInfo.appId, new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showLoadingView$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m72invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m72invoke() {
                    EntryInfo entryInfo2 = entryInfo;
                    LatestUseUtils.addAppUse(entryInfo2.appId, entryInfo2.title, entryInfo2.iconUrl, entryInfo2.desc, entryInfo2.getClassificationNames(), entryInfo.getExclusiveLogoUrl(), 0);
                }
            });
            unit = Unit.a;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                String string = miniAppActivity.getString(R.string.dialog_loading_tv);
                Intrinsics.g(string, "getString(R.string.dialog_loading_tv)");
                miniAppActivity.showLoadingLogo(string, "");
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showMsgBubbleToast$lambda$70(final MiniAppActivity miniAppActivity) {
        long j;
        Intrinsics.h(miniAppActivity, "this$0");
        try {
            if (miniAppActivity.getPvMsgBubble() == null) {
                TmcLogger.d(TAG, "pvMsgBubble is null");
                return;
            }
            MsgBubblePopUpWindowView pvMsgBubble = miniAppActivity.getPvMsgBubble();
            if (pvMsgBubble != null) {
                ViewExtKt.toVisible(pvMsgBubble);
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putString("jump_confi", pvMsgBubble.OooO0OO ? "0" : "1");
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(null, TmcConstants.REPORTER_SHOW_MSG_BUBBLE, bundle);
            }
            MsgBubblePopUpWindowView pvMsgBubble2 = miniAppActivity.getPvMsgBubble();
            if (pvMsgBubble2 != null) {
                pvMsgBubble2.OooO00o(miniAppActivity.msgAppName);
            }
            TmcLogger.d(TAG, "showMsgBubbleToast");
            String str = miniAppActivity.appId;
            if (str != null) {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(miniAppActivity, str, TmcConstants.KEY_SHOW_MSG_BUBBLE_TIME, System.currentTimeMillis());
            }
            try {
                j = MiniAppConfigHelper.INSTANCE.getConfigTargetInt(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_TIME, 5000);
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
                j = 5000;
            }
            miniAppActivity.postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.r
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.showMsgBubbleToast$lambda$70$lambda$69(MiniAppActivity.this);
                }
            }, j);
            Context context = miniAppActivity.getContext();
            Intrinsics.h(context, "context");
            Intrinsics.h("", "msgStr");
            try {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", "");
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_NEW_MESSAGE_STATUS, !Intrinsics.c("", ""));
            } catch (Throwable th2) {
                TmcLogger.e("MiniappMsgDataProvider", th2);
            }
        } catch (Throwable th3) {
            TmcLogger.e(TAG, "showMsgBubbleToast", th3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMsgBubbleToast$lambda$70$lambda$69(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        MsgBubblePopUpWindowView pvMsgBubble = miniAppActivity.getPvMsgBubble();
        if (pvMsgBubble != null) {
            ViewExtKt.toGone(pvMsgBubble);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showNoNetwork(PrepareException prepareException) {
        Bundle bundle;
        String string;
        Bundle extras = getIntent().getExtras();
        Object obj = extras != null ? extras.get(TmcConstants.EXTRA_START_BUNDLE) : null;
        StartClientBundle startClientBundle = obj instanceof StartClientBundle ? (StartClientBundle) obj : null;
        if (startClientBundle != null && (bundle = startClientBundle.startParams) != null && (string = bundle.getString(TmcConstants.EXTRA_DATA)) != null) {
            Map mapFromJson = TmcGsonUtils.mapFromJson(string);
            String str = mapFromJson != null ? (String) mapFromJson.get("logo") : null;
            String str2 = mapFromJson != null ? (String) mapFromJson.get("name") : null;
            String str3 = mapFromJson != null ? (String) mapFromJson.get("desc") : null;
            this.tempAppLogo = str == null ? "" : str;
            this.tempAppName = str2 != null ? str2 : "";
            if (str == null || str.length() <= 0 || NetworkUtils.isConnected()) {
                StatusAction.DefaultImpls.showNoNetwork$default(this, new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showNoNetwork$1$2
                    @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                    public void onRetry(StatusLayout statusLayout) {
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String appId = MiniAppActivity.this.getAppId();
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                        Unit unit = Unit.a;
                        performanceAnalyseProxy.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle2);
                        MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
                    }
                }, 0, null, this.appId, PinForLaterExtensionKt.getPinForLaterListener(this), 6, null);
            } else {
                r1 = prepareException != null ? prepareException.getCode() : null;
                if (r1 == null) {
                    r1 = "0";
                } else {
                    Intrinsics.g(r1, "exception?.code ?: \"0\"");
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, PrepareException.codeToDes(r1));
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle2);
                new AppInsertState(bundle2).setChainContext(this.appChainContext);
                showCustomErrorLayout(str2, str, str3, new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showNoNetwork$1$1
                    @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                    public void onRetry(StatusLayout statusLayout) {
                        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String appId = MiniAppActivity.this.getAppId();
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                        Unit unit = Unit.a;
                        performanceAnalyseProxy.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle3);
                        MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
                    }
                }, this.appId, PinForLaterExtensionKt.getPinForLaterListener(this));
            }
            r1 = Unit.a;
        }
        if (r1 == null) {
            StatusAction.DefaultImpls.showNoNetwork$default(this, new StatusLayout.OooO0O0() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showNoNetwork$2$1
                @Override // com.cloud.tmc.miniapp.widget.StatusLayout.OooO0O0
                public void onRetry(StatusLayout statusLayout) {
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    String appId = MiniAppActivity.this.getAppId();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                    Unit unit = Unit.a;
                    performanceAnalyseProxy.recordForCommon(appId, TmcConstants.REPORTER_NO_NET_WORK_RETRY, bundle3);
                    MiniAppActivity.reload$default(MiniAppActivity.this, false, null, 3, null);
                }
            }, 0, null, this.appId, PinForLaterExtensionKt.getPinForLaterListener(this), 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showOpenAppDialog(String str, String str2, String str3) {
        if (this.showOpenAppDialog) {
            return;
        }
        o0Oo0oo o0oo0oo = new o0Oo0oo(this, str3);
        try {
            ImageView imageView = (ImageView) o0oo0oo.OooO0OO.getValue();
            if (imageView != null) {
                ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
                Context context = o0oo0oo.OooO00o;
                if (str == null) {
                    str = "";
                }
                imageLoaderProxy.loadImgRoundCorners(context, new File(str), imageView, SizeUtils.dp2px(12.0f), R.drawable.mini_icon_placeholder);
            }
        } catch (Throwable unused) {
        }
        o0oo0oo.addOnShowListener(new OooO0O0.Oooo000() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showOpenAppDialog$1
            @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
            public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
                MiniAppActivity.this.showOpenAppDialog = true;
            }
        }).addOnDismissListener(new OooO0O0.OooOo00() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$showOpenAppDialog$2
            @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
            public void onDismiss(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
                MiniAppActivity.this.showOpenAppDialog = false;
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUpWindowRunnable$lambda$72(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        PopWindowManager.INSTANCE.showPopWindow(miniAppActivity.getMiniAppPopWindowToken(), System.currentTimeMillis() - miniAppActivity.miniappStartTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStatusLoading$lambda$0(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        miniAppActivity.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startApp$lambda$29(final MiniAppActivity miniAppActivity, Intent intent) {
        Intrinsics.h(miniAppActivity, "this$0");
        try {
            TmcLogger.d(TAG, "startApp success");
            if (intent != null) {
                intent.putExtra(TmcConstants.EXTRA_LAUNCH_MODE, TmcConstants.EXTRA_LAUNCH_MODE_REOPEN);
            } else {
                intent = null;
            }
            miniAppActivity.startMiniApp(intent);
            miniAppActivity.isValidOnResume = false;
            miniAppActivity.onResume();
            if (miniAppActivity.enableQuickMode) {
                miniAppActivity.quickModeStartStatus = true;
                TmcLogger.d(TAG, "quickModeStart complete");
                PrepareContext prepareContext = miniAppActivity.prepareContext;
                if (prepareContext != null) {
                    prepareContext.setVirtualStart(miniAppActivity.enableQuickMode);
                }
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppActivity.startApp$lambda$29$lambda$28(MiniAppActivity.this);
                    }
                });
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startApp$lambda$29$lambda$28(MiniAppActivity miniAppActivity) {
        Intrinsics.h(miniAppActivity, "this$0");
        PrepareController createPrepareController = ((IClientStarter) TmcProxy.get(IClientStarter.class)).createPrepareController(miniAppActivity.prepareContext, new OooO0OO(miniAppActivity.prepareContext, miniAppActivity));
        miniAppActivity.controller = createPrepareController;
        if (createPrepareController != null) {
            createPrepareController.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAsyncApp$lambda$33$lambda$32$lambda$31(AppNode appNode) {
        Intrinsics.h(appNode, "$appNode");
        TmcLogger.d(TAG, "startAsyncApp backToPagePath -> " + appNode.getBackToPagePath());
        String backToPagePath = appNode.getBackToPagePath();
        Bundle startParams = appNode.getStartParams();
        Bundle sceneParams = appNode.getSceneParams();
        sceneParams.putString("navigationType", TmcConstants.NAVIGATION_START_ASYNC_APP);
        Unit unit = Unit.a;
        appNode.relaunchToUrl(backToPagePath, startParams, sceneParams);
        appNode.setBackToPagePath("");
    }

    private final void startMiniApp(Intent intent) {
        App app;
        Bundle extras;
        if ((intent == null || (extras = intent.getExtras()) == null || !extras.containsKey(TmcConstants.EXTRA_LAUNCH_MODE)) && intent != null) {
            intent.putExtra(TmcConstants.EXTRA_LAUNCH_MODE, TmcConstants.EXTRA_LAUNCH_MODE_HOT);
        }
        TmcLogger.d(TAG, "onNewIntent: " + this.appId);
        TmcLogger.d(TAG, "startMiniApp:checkTaskId:" + this.appId);
        NewTaskManager.Companion.getInstance().checkTaskId(this.appId, getClass());
        this.mActivityHelper.onNewIntent(intent);
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(this.mActivityHelper.getApp());
        this.eventCenter = eventCenterInstance;
        if (eventCenterInstance != null) {
            App app2 = this.mActivityHelper.getApp();
            eventCenterInstance.register("resendH5PageStack_" + (app2 != null ? app2.getAppId() : null), new IEventSubscriber() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$startMiniApp$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent iEvent) {
                    IEventCenter iEventCenter;
                    MiniAppActivity.this.reSendDelayPageEnterToWorker();
                    iEventCenter = MiniAppActivity.this.eventCenter;
                    if (iEventCenter == null) {
                        return true;
                    }
                    App app3 = MiniAppActivity.this.getMActivityHelper().getApp();
                    iEventCenter.unregister("resendH5PageStack_" + (app3 != null ? app3.getAppId() : null), this);
                    return true;
                }
            });
        }
        if (this.enableQuickMode && (app = this.mActivityHelper.getApp()) != null) {
            app.setAsyncStartLoadingCallback(new IAsyncStartLoadingCallback() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$startMiniApp$2
                public void showAsyncStatusLoading() {
                    TmcLogger.d("MiniAppActivity", "showAsyncStatusLoading");
                    MiniAppActivity.this.showLoadingPage();
                }
            });
        }
        App app3 = this.mActivityHelper.getApp();
        if (app3 != null) {
            app3.setAppCallback(new IAppCallback() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$startMiniApp$3
                public boolean validPushPage(String str, AppModel appModel, Context context, Bundle bundle, Bundle bundle2, ISubpackageLoadCheckCallback iSubpackageLoadCheckCallback) {
                    Intrinsics.h(str, TmcConstants.EXTRA_PATH);
                    Intrinsics.h(appModel, "appModel");
                    Intrinsics.h(context, "context");
                    Intrinsics.h(bundle, TmcConstants.EXTRA_START_PARAMS);
                    Intrinsics.h(bundle2, TmcConstants.EXTRA_SCENE_PARAMS);
                    Intrinsics.h(iSubpackageLoadCheckCallback, "loadCheckCallback");
                    return OooOOO.OooO00o(str, appModel, context, bundle, bundle2, iSubpackageLoadCheckCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateStepProgress$lambda$26(MiniAppActivity miniAppActivity, LoadStepAction loadStepAction) {
        Intrinsics.h(miniAppActivity, "this$0");
        Intrinsics.h(loadStepAction, "$step");
        miniAppActivity.updateStepAnimation(loadStepAction);
    }

    public void addMFAHInterceptAction(String str, Function0<Unit> function0) {
        IAllowMFAHListener.DefaultImpls.addMFAHInterceptAction(this, str, function0);
    }

    public final void addScreen(String str) {
        AppContext appContext;
        Context context;
        AddHomeCustomTopTipView pvAddHomeTopTip;
        Intrinsics.h(str, "location");
        try {
            if (isLoadStatusLoadingOrError()) {
                return;
            }
            if (Intrinsics.c(str, "0") && (pvAddHomeTopTip = getPvAddHomeTopTip()) != null && ViewExtKt.getVisible(pvAddHomeTopTip)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(this.appId, "upper_pop_click", new Bundle());
                str = "10";
            }
            String str2 = str;
            AddHomeCustomTopTipView pvAddHomeTopTip2 = getPvAddHomeTopTip();
            if (pvAddHomeTopTip2 != null) {
                pvAddHomeTopTip2.OooO00o();
            }
            AddHomeCustomBottomTipView pvAddHomeBottomTip = getPvAddHomeBottomTip();
            if (pvAddHomeBottomTip != null) {
                try {
                    if (ViewExtKt.getVisible(pvAddHomeBottomTip)) {
                        pvAddHomeBottomTip.startAnimation(AnimationUtils.loadAnimation(pvAddHomeBottomTip.getContext(), R.anim.mini_view_toast_exit));
                        ViewExtKt.toInvisible(pvAddHomeBottomTip);
                    }
                } catch (Throwable th) {
                    TmcLogger.e(pvAddHomeBottomTip.OooO0oO, "toAddCustomBottomVisible error", th);
                }
            }
            MiniAddHomeTipDialogView addHomeDialogView = getAddHomeDialogView();
            if (addHomeDialogView != null) {
                addHomeDialogView.OooO00o(false);
            }
            App app = this.mActivityHelper.getApp();
            if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
                Intrinsics.g(context, "context");
                Class launcherShortCutActivity = ((StartActivityProxy) TmcProxy.get(StartActivityProxy.class)).getLauncherShortCutActivity();
                Intrinsics.g(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
                CreateShortCutUtils.createShortcut$default(context, launcherShortCutActivity, app, str2, 0, false, false, TaskResultKt.ERROR_LOAD_REQUEST_FAIL, (Object) null);
            }
            try {
                removeCallbacksAndMessages(getPvAddHomeCustom1());
                removeCallbacksAndMessages(getPvAddHomeCustom2());
                AddHomeCustom1PopUpWindowView pvAddHomeCustom1 = getPvAddHomeCustom1();
                if (pvAddHomeCustom1 != null) {
                    ViewExtKt.toGone(pvAddHomeCustom1);
                }
                AddHomeCustom2PopUpWindowView pvAddHomeCustom2 = getPvAddHomeCustom2();
                if (pvAddHomeCustom2 != null) {
                    ViewExtKt.toGone(pvAddHomeCustom2);
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
            }
        } catch (Throwable th3) {
            TmcLogger.e(TAG, th3);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void backgroundDownloadZipAsync(AppModel appModel, final boolean z) {
        Intrinsics.h(appModel, "appModelNew");
        TmcLogger.d(TAG, "backgroundDownloadZipAsync: miniappStartTime: " + this.miniappStartTime + " isSuccess: " + z + " appModelNew: " + appModel);
        if (this.miniappStartTime != 0) {
            dispatchOnUpdateApp(z);
        } else {
            getMShowCompleteTaskQueue().OooO00o(new com.cloud.tmc.miniapp.task.OooO00o("onUpdateApp", new Runnable() { // from class: com.cloud.tmc.miniapp.ui.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.backgroundDownloadZipAsync$lambda$35(MiniAppActivity.this, z);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void capsuleSetOnRightClick(boolean z) {
        Unit unit;
        try {
            try {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_EXIT_CLICK, "");
            } catch (Throwable th) {
                TmcLogger.e(TAG, th);
            }
            OfflineManager.INSTANCE.clearCache(this);
            if (z) {
                finishMiniActivity(TmcFragment.ExitType.CLOSE_APP, true);
                return;
            }
            AppNode app = this.mActivityHelper.getApp();
            if (app != null) {
                if (!app.getBackPressedProcessor().startBackPressedInterceptorChain(new IBackPressedIntercept.Params(this, this.appId, app instanceof AppNode ? app : null, true, 2)).isIntercept()) {
                    finishMiniActivity(TmcFragment.ExitType.CLOSE_APP, false);
                }
                unit = Unit.a;
            } else {
                unit = null;
            }
            if (unit == null) {
                finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkAndShowAddHomeCustomToast(int i, long j, long j2, String str, String str2) {
        AddHomeToastUtils.OooO00o.OooO00o(this, this.appId, getMiniAppPopWindowToken(), this.miniappStartTime, j, new MiniAppActivity$checkAndShowAddHomeCustomToast$1(i, this, str, str2, j2));
    }

    public boolean checkIsForeground() {
        return getResumed();
    }

    public void clearMFAHIntercept() {
        IAllowMFAHListener.DefaultImpls.clearMFAHIntercept(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createSuccess(String str) {
        Intrinsics.h(str, "appId");
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(this, "1000886706715795456_web", "csmk");
            if (string == null) {
                string = "";
            }
            if (((CSMKBean) GsonUtils.fromJson(string, CSMKBean.class)).getContinueShow()) {
                statusLayoutCreateShortCutsSuccess(str, new MiniAppActivity$createSuccess$2(this));
            } else {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_GET_TOAST_ADD_EX;
                Bundle bundle = new Bundle();
                bundle.putString("miniappid", str);
                Unit unit = Unit.a;
                performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
                statusLayoutCreateShortCutsSuccess(str, null);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void finish() {
        super.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finishMiniActivity(TmcFragment.ExitType exitType, boolean z) {
        List arrayList;
        AppContext appContext;
        IFragmentManager fragmentManager;
        Set fragments;
        Intrinsics.h(exitType, "exitType");
        try {
            App app = this.mActivityHelper.getApp();
            Unit unit = null;
            AppContext appContext2 = app != null ? app.getAppContext() : null;
            TmcAppContext tmcAppContext = appContext2 instanceof TmcAppContext ? (TmcAppContext) appContext2 : null;
            if (tmcAppContext != null && (fragmentManager = tmcAppContext.getFragmentManager()) != null && (fragments = fragmentManager.getFragments()) != null) {
                Iterator it = fragments.iterator();
                while (it.hasNext()) {
                    ((TmcFragment) it.next()).setExitType(exitType);
                }
            }
            App app2 = this.mActivityHelper.getApp();
            if (app2 == null) {
                if (!NewTaskManager.Companion.getInstance().checkOpenMutipleTask(this.appId)) {
                    finish();
                    return;
                }
                try {
                    String str = this.appId;
                    if (str != null && str.length() != 0) {
                        ((StartActivityProxy) TmcProxy.get(StartActivityProxy.class)).removeMiniAppTask(this.appId, this);
                        return;
                    }
                    finishAndRemoveTask();
                    return;
                } catch (Throwable unused) {
                    finishAndRemoveTask();
                    return;
                }
            }
            if (z) {
                app2.exit();
                return;
            }
            MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.INSTANCE;
            if (!miniAppConfigHelper.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_ENABLE_MOVE_TO_BACK, true)) {
                TmcLogger.d(TAG, "finishMiniActivity enableMoveToBack -> false");
                app2.exit();
                return;
            }
            NewTaskManager.Companion companion = NewTaskManager.Companion;
            NewTaskManager companion2 = companion.getInstance();
            App app3 = this.mActivityHelper.getApp();
            if (!companion2.checkOpenMutipleTask(app3 != null ? app3.getAppId() : null)) {
                TmcLogger.d(TAG, "finishMiniActivity checkOpenMutipleTask -> false");
                app2.exit();
                return;
            }
            NewTaskManager companion3 = companion.getInstance();
            App app4 = this.mActivityHelper.getApp();
            if (companion3.checkUseSingleTaskMode(app4 != null ? app4.getAppId() : null)) {
                TmcLogger.d(TAG, "finishMiniActivity feedback -> finish");
                app2.exit();
                return;
            }
            NewTaskManager companion4 = companion.getInstance();
            App app5 = this.mActivityHelper.getApp();
            if (companion4.checkMiniAppServerApp(app5 != null ? app5.getAppId() : null)) {
                TmcLogger.d(TAG, "finishMiniActivity setting -> finish");
                app2.exit();
                return;
            }
            App app6 = this.mActivityHelper.getApp();
            if (app6 != null && !app6.getMiniAppLoadStatus()) {
                TmcLogger.d(TAG, "finishMiniActivity miniAppLoadStatus -> false");
                app2.exit();
                return;
            }
            try {
                try {
                    Object fromJson = GsonUtils.fromJson(miniAppConfigHelper.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_FORCE_FINISH_MINIAPP, "[]"), (Class<Object>) List.class);
                    arrayList = fromJson instanceof List ? (List) fromJson : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                } catch (Throwable th) {
                    TmcLogger.e(TAG, th);
                    arrayList = new ArrayList();
                }
                App app7 = this.mActivityHelper.getApp();
                if (CollectionsKt.b0(arrayList, app7 != null ? app7.getAppId() : null)) {
                    TmcLogger.d(TAG, "finishMiniActivity forceFinishList -> finish");
                    app2.exit();
                    return;
                }
            } catch (Throwable unused2) {
            }
            App app8 = this.mActivityHelper.getApp();
            if (app8 != null && (appContext = app8.getAppContext()) != null) {
                boolean moveToBackground = appContext.moveToBackground();
                TmcLogger.e(TAG, "mActivityHelper not null, moveToBackground status ->" + moveToBackground);
                if (!moveToBackground) {
                    app2.exit();
                }
                unit = Unit.a;
            }
            if (unit == null) {
                TmcLogger.e(TAG, "app or appContext is null,exit app");
                app2.exit();
            }
        } catch (Throwable th2) {
            TmcLogger.e("miniappactivity", th2);
        }
    }

    public final String getAppId() {
        return this.appId;
    }

    public final CapsuleView getCapsule() {
        return (CapsuleView) this.capsule$delegate.getValue();
    }

    public final PrepareController getController() {
        return this.controller;
    }

    public App getCurrentApp() {
        return this.mActivityHelper.getApp();
    }

    public final long getCurrentDelayTime() {
        return this.currentDelayTime;
    }

    public final boolean getDelayShowError() {
        return this.delayShowError;
    }

    public final String getDevToken() {
        return this.devToken;
    }

    public final boolean getEnableQuickMode() {
        return this.enableQuickMode;
    }

    public final PrepareException getErrorException() {
        return this.errorException;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R.layout.activity_mini_main;
    }

    public final ActivityHelper getMActivityHelper() {
        return this.mActivityHelper;
    }

    public ArrayList<Function0<Unit>> getMFAHIntercept() {
        return IAllowMFAHListener.DefaultImpls.getMFAHIntercept(this);
    }

    public ArrayList<Function0<Unit>> getMFAHInterceptList() {
        return this.mMFAHInterceptList;
    }

    public final String getMiniAppPopWindowToken() {
        return (String) this.miniAppPopWindowToken$delegate.getValue();
    }

    public final long getMiniappForegroundTime() {
        return this.miniappForegroundTime;
    }

    public final long getMiniappResumeTimestamp() {
        return this.miniappResumeTimestamp;
    }

    public final long getMiniappStartTime() {
        return this.miniappStartTime;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getMsgAppName() {
        return this.msgAppName;
    }

    public final long getOnPauseStopTimeStamp() {
        return this.onPauseStopTimeStamp;
    }

    public final PrepareContext getPrepareContext() {
        return this.prepareContext;
    }

    public final PrepareController getQuickModeController() {
        return this.quickModeController;
    }

    public final boolean getQuickModeStartStatus() {
        return this.quickModeStartStatus;
    }

    public boolean getResumed() {
        return getMResumed();
    }

    public final String getRootTaskId() {
        return this.rootTaskId;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final PopWindowManager.IPopWindowManagerController getShowMsgBubbleController() {
        return this.showMsgBubbleController;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public StatusLayout getStatusLayout() {
        return getMStatusLayout();
    }

    public final String getTempAppLogo() {
        return this.tempAppLogo;
    }

    public final String getTempAppName() {
        return this.tempAppName;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public Integer getViewThemeMode() {
        App app = this.mActivityHelper.getApp();
        AppModel appModel = app != null ? app.getAppModel() : null;
        return (appModel != null && (MiniAppType.SHELL.getType() == appModel.getAppinfoCategoryType() || MiniAppType.SHELL_GAME.getType() == appModel.getAppinfoCategoryType())) ? 2 : 1;
    }

    public final void goBack() {
        if (isLoadStatusLoadingOrError()) {
            return;
        }
        onKeyUp(4, new KeyEvent(1, 4));
    }

    public final void goHome() {
        if (this.enableQuickMode) {
            AppNode app = this.mActivityHelper.getApp();
            AppNode appNode = app instanceof AppNode ? app : null;
            if (appNode != null && !appNode.isAsyncLaunchStatus()) {
                AppNode app2 = this.mActivityHelper.getApp();
                AppNode appNode2 = app2 instanceof AppNode ? app2 : null;
                if (appNode2 != null) {
                    App app3 = this.mActivityHelper.getApp();
                    appNode2.setBackToPagePath(app3 != null ? app3.getHomePagePath() : null);
                }
                showLoadingPage();
                return;
            }
        }
        if (isLoadStatusLoadingOrError()) {
            return;
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_NAV_HOME_PRESSED, "");
        try {
            App app4 = this.mActivityHelper.getApp();
            if (app4 != null) {
                app4.exitToHomePage();
            }
        } catch (Throwable th) {
            TmcLogger.e(th.getMessage());
        }
    }

    public final void hideAddHomeTips() {
        try {
            AddHomeCustomTopTipView pvAddHomeTopTip = getPvAddHomeTopTip();
            if (pvAddHomeTopTip != null) {
                pvAddHomeTopTip.OooO00o();
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
        App app = this.mActivityHelper.getApp();
        if (app != null) {
            ((IAdManagerProxy) TmcProxy.get(IAdManagerProxy.class)).onCreate(app);
            app.updateHideMiniappLoadingStatus(true);
        }
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.a0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.hideStatusLoading$lambda$10(MiniAppActivity.this);
            }
        });
    }

    public final void hideStatusLoadingDelay(long j) {
        postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.hideStatusLoadingDelay$lambda$1(MiniAppActivity.this);
            }
        }, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        if (!ByteAppManager.isInit()) {
            TmcLogger.d(TAG, "ByteAppManager is not init");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            Application application = getApplication();
            Intrinsics.g(application, "this.application");
            miniAppLaunch.byteAppInit$com_cloud_tmc_miniapp_sdk(application);
        }
        initMiniActivityData();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.cloud.tmc.miniapp.widget.CapsuleView] */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        ?? capsule = getCapsule();
        if (capsule != 0) {
            capsule.setTranslationY(capsule.getTranslationY() + MiniBarUtils.getStatusHeight());
            capsule.setTranslationX(ViewUtils.isLayoutRtl() ? getResources().getDimension(R.dimen.mini_dp_8) : getResources().getDimension(R.dimen.mini_dp_m_8));
            capsule.setOnLeftClickListener(new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$initView$1$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m62invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m62invoke() {
                    MiniAppActivity.this.capsuleSetOnLeftClick();
                }
            });
            capsule.setOnRightClickListener(new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$initView$1$2
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m63invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m63invoke() {
                    MiniAppActivity.capsuleSetOnRightClick$default(MiniAppActivity.this, false, 1, null);
                }
            });
        }
        this.mActivityHelper.setOnSetHostActivityStatusBackgroundCallback(new ActivityHelper.OnSetHostActivityStatusBackgroundCallback() { // from class: com.cloud.tmc.miniapp.ui.b0
            public final void setHostActivityStatusBackground(int i) {
                MiniAppActivity.initView$lambda$50(MiniAppActivity.this, i);
            }
        });
    }

    public final boolean isAsyncLaunchStatus() {
        try {
            AppNode app = this.mActivityHelper.getApp();
            AppNode appNode = app instanceof AppNode ? app : null;
            if (appNode != null) {
                return appNode.isAsyncLaunchStatus();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean isFirstLaunch() {
        return this.isFirstLaunch;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public boolean isLoadStatusLoadingOrError() {
        return StatusAction.DefaultImpls.isLoadStatusLoadingOrError(this);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void killActivity() {
        TmcLogger.d("NewTaskManager", "kill activity");
        TmcLogger.e("launch step error,finish activity");
        finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void loadError(PrepareData prepareData, final PrepareException prepareException) {
        if (this.enableQuickMode && this.quickModeStartStatus && this.errorException == null) {
            this.errorException = prepareException;
            return;
        }
        String code = prepareException != null ? prepareException.getCode() : null;
        String message = prepareException != null ? prepareException.getMessage() : null;
        TmcLogger.e(TAG, "loadError errorCode: " + code + " errorMessage: " + message + ", Just print: " + Log.getStackTraceString(prepareException));
        App app = this.mActivityHelper.getApp();
        if (app != null) {
            app.setMiniAppLoadStatus(false);
        }
        new AppErrorState(new Bundle()).setChainContext(this.appChainContext);
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.loadError$lambda$16(PrepareException.this, this);
            }
        });
    }

    public void mfahAllow(String str) {
        IAllowMFAHListener.DefaultImpls.mfahAllow(this, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyShowAddHome(final int i) {
        runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.notifyShowAddHome$lambda$96(i, this);
            }
        });
    }

    public void onBackPressed() {
        App app = this.mActivityHelper.getApp();
        AppContext appContext = app != null ? app.getAppContext() : null;
        if (!(appContext instanceof TmcAppContext) || ((TmcAppContext) appContext).getFragmentManager().onBackPressed()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i == 1) {
            LinearLayoutCompat capsule = getCapsule();
            if (capsule != null) {
                capsule.setVisibility(0);
            }
            getWindow().clearFlags(MemoryConstants.KB);
            getWindow().addFlags(2048);
            return;
        }
        if (i != 2) {
            return;
        }
        LinearLayoutCompat capsule2 = getCapsule();
        if (capsule2 != null) {
            capsule2.setVisibility(8);
        }
        getWindow().clearFlags(2048);
        getWindow().addFlags(MemoryConstants.KB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SoftHideKeyBoardUtil.assistActivity(this);
        ((IOnRenderProcessGoneProxy) TmcProxy.get(IOnRenderProcessGoneProxy.class)).register(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onDestroy() {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        ConcurrentHashMap concurrentHashMap4;
        String appId;
        Bundle startParams;
        Bundle startParams2;
        StartTime startTime;
        String str = "";
        super.onDestroy();
        TmcLogger.d("MiniAppBasePage", "onDestroy invoke..appId:" + this.appId + ",isDarkMode:" + SystemUtils.darkThemeIsEnabled(this));
        String str2 = this.appId;
        StringBuilder sb = new StringBuilder();
        sb.append("ondestory:");
        sb.append(str2);
        TmcLogger.d(TAG, sb.toString());
        try {
            OooO.OooO00o.OooO00o().OooO00o.clear();
        } catch (Throwable th) {
            TmcLogger.e("NormalTaskQueueUtils", "", th);
        }
        NewTaskManager.Companion.getInstance().removeActivityStack(this.appId);
        ((LogEProxy) TmcProxy.get(LogEProxy.class)).destroy(this.appId);
        IEventCenter iEventCenter = this.eventCenter;
        if (iEventCenter != null) {
            App app = this.mActivityHelper.getApp();
            iEventCenter.unregister("resendH5PageStack_" + (app != null ? app.getAppId() : null));
        }
        ((IOnRenderProcessGoneProxy) TmcProxy.get(IOnRenderProcessGoneProxy.class)).unRegister(this);
        IEventCenter eventCenterInstance = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(this.mActivityHelper.getApp());
        if (eventCenterInstance != null) {
            eventCenterInstance.unregister(WorkerManager.INSTANCE.getEVENT_RESEND_PAGE_ENTER());
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String str3 = this.appId;
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_CLEAR;
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        bundle.putString(ChainPoint.CHAIN_ID, String.valueOf(this.uniqueChainId));
        bundle.putString("miniapp_id", this.appId);
        bundle.putString("queryShortcutExist", String.valueOf(AppUtils.INSTANCE.queryShortcutExist(this, this.appId)));
        Unit unit = Unit.a;
        performanceAnalyseProxy.record(str3, pointAnalyseType, "clear", bundle);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String str4 = this.appId;
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_APP_CHAIN_CLEAR;
        Bundle bundle2 = new Bundle();
        bundle2.putString("openMiniAppFailedReason", "关闭");
        performanceAnalyseProxy2.record(str4, pointAnalyseType2, "clear", bundle2);
        ((IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class)).appDestroy(this.mActivityHelper.getApp());
        ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).clearDownloadCall();
        PrepareController prepareController = this.controller;
        if (prepareController != null) {
            prepareController.finish();
        }
        this.controller = null;
        PrepareController prepareController2 = this.quickModeController;
        if (prepareController2 != null) {
            prepareController2.finish();
        }
        this.quickModeController = null;
        App app2 = this.mActivityHelper.getApp();
        long startTime2 = (app2 == null || (startTime = (StartTime) app2.getData(StartTime.class)) == null) ? 0L : startTime.getStartTime();
        if (startTime2 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - startTime2;
            App app3 = this.mActivityHelper.getApp();
            TmcLogger.d("[MiniAppActivity]: app usageTime:" + elapsedRealtime + " ms, appId:" + (app3 != null ? app3.getAppId() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String str5 = this.appId;
            PointAnalyseType putData = PointAnalyseType.POINT_EXIT_MINIAPP.putData("usageTime", Long.valueOf(elapsedRealtime));
            App app4 = this.mActivityHelper.getApp();
            PointAnalyseType putData2 = putData.putData(TmcConstants.KEY_MINI_APPID, app4 != null ? app4.getAppId() : null).putData("miniapp_id", this.appId);
            App app5 = this.mActivityHelper.getApp();
            PointAnalyseType putData3 = putData2.putData(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, (app5 == null || (startParams2 = app5.getStartParams()) == null) ? null : startParams2.getString("scene_id", "100000"));
            App app6 = this.mActivityHelper.getApp();
            performanceAnalyseProxy3.record(str5, putData3.putData("fis_type", (app6 == null || (startParams = app6.getStartParams()) == null) ? null : startParams.getString("fis_type", "0")), "");
        }
        App app7 = this.mActivityHelper.getApp();
        if (app7 != null && (appId = app7.getAppId()) != null) {
            ((IAdManagerProxy) TmcProxy.get(IAdManagerProxy.class)).onDestroy(appId);
        }
        this.mActivityHelper.onDestroy();
        PopWindowManager.INSTANCE.clearPopWindow(getMiniAppPopWindowToken());
        try {
            TypeIntrinsics.d(CreateShortCutUtils.INSTANCE.getAppMap()).remove(this.appId);
            IUpdateLoadingStepProxy iUpdateLoadingStepProxy = (IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class);
            String str6 = this.appId;
            if (str6 != null) {
                str = str6;
            }
            iUpdateLoadingStepProxy.removeUpdateLoadingListener(str);
            ((TmcResourceManager) TmcProxy.get(TmcResourceManager.class)).clearDownloadAppMap();
            App app8 = this.mActivityHelper.getApp();
            if (app8 != null) {
                app8.setMiniappLifecycleCallback((ICheckMiniAppLifecycleCallback) null);
            }
            App app9 = this.mActivityHelper.getApp();
            if (app9 != null) {
                app9.setAddhomeShowCallback((IShowAddHomeCallback) null);
            }
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.p
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.onDestroy$lambda$78();
                }
            });
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).clearPerformanceImproves(this.appId);
        Bundle bundle3 = new Bundle();
        bundle3.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, "关闭");
        new AppInsertState(bundle3).setChainContext(this.appChainContext);
        this.appChainContext.destroy(new Bundle());
        ((SessionUtilProxy) TmcProxy.get(SessionUtilProxy.class)).removeSession(this.appId);
        ((VirtualAppManager) TmcProxy.get(VirtualAppManager.class)).exitApp(((VirtualAppManager) TmcProxy.get(VirtualAppManager.class)).findApp(this.appId));
        String str7 = this.appId;
        if (str7 != null) {
            NativeComponentManager.INSTANCE.removeForAppId(str7);
        }
        MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
        miniForceAddHomeManager.removeInterectMFAH(this.appId, false);
        miniForceAddHomeManager.removeAllMfahListener(this.appId);
        try {
            PrivacyBridge.Companion.getClass();
            concurrentHashMap = PrivacyBridge.OooO0O0;
            if (concurrentHashMap.containsKey(this.appId)) {
                TmcLogger.d(TAG, "removePrivacyDialog appId = " + this.appId);
                concurrentHashMap4 = PrivacyBridge.OooO0O0;
                TypeIntrinsics.d(concurrentHashMap4).remove(this.appId);
            }
            concurrentHashMap2 = PrivacyBridge.OooO0OO;
            if (concurrentHashMap2.containsKey(this.appId)) {
                TmcLogger.d(TAG, "removePrivacySimpleDialog appId = " + this.appId);
                concurrentHashMap3 = PrivacyBridge.OooO0OO;
                TypeIntrinsics.d(concurrentHashMap3).remove(this.appId);
            }
            ExtensionManager extensionManager = TmcInitializer.getExtensionManager();
            DefaultExtensionManager defaultExtensionManager = extensionManager instanceof DefaultExtensionManager ? (DefaultExtensionManager) extensionManager : null;
            Map<Node, Map<String, Extension>> nodeExtensionMap = defaultExtensionManager != null ? defaultExtensionManager.getNodeExtensionMap() : null;
            if (nodeExtensionMap != null) {
                Iterator<Node> it = nodeExtensionMap.keySet().iterator();
                while (it.hasNext()) {
                    AppNode appNode = (Node) it.next();
                    String str8 = this.appId;
                    if (str8 != null) {
                        AppNode appNode2 = appNode instanceof AppNode ? appNode : null;
                        if (Intrinsics.c(appNode2 != null ? appNode2.getAppId() : null, str8)) {
                            nodeExtensionMap.remove(appNode);
                            TmcLogger.d(TAG, "nodeExtensionMap remove " + appNode);
                        }
                    }
                }
                TmcLogger.d(TAG, "nodeExtensionMap size ->" + nodeExtensionMap.size());
            }
        } catch (Throwable th3) {
            TmcLogger.e(TAG, "privacyDialogMap", th3);
        }
    }

    public String onGetCurrentAppId() {
        String str = this.appId;
        return str == null ? "" : str;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        TmcFragment tmcFragment;
        IFragmentManager fragmentManager;
        TmcLogger.d("[MiniActivity]：onKeyUp()");
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if ((keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) ? nativeComponentIntercept() : false) {
            return true;
        }
        App app = this.mActivityHelper.getApp();
        AppContext appContext = app != null ? app.getAppContext() : null;
        BaseAppContext baseAppContext = appContext instanceof BaseAppContext ? (BaseAppContext) appContext : null;
        if (baseAppContext == null || (fragmentManager = baseAppContext.getFragmentManager()) == null) {
            tmcFragment = null;
        } else {
            App app2 = this.mActivityHelper.getApp();
            tmcFragment = fragmentManager.findFragmentForPage(app2 != null ? app2.getActivePage() : null);
        }
        MiniAppBaseFragment miniAppBaseFragment = tmcFragment instanceof MiniAppBaseFragment ? (MiniAppBaseFragment) tmcFragment : null;
        if (miniAppBaseFragment != null && miniAppBaseFragment.shouldInterceptOnKeyDown()) {
            return true;
        }
        try {
            return this.mActivityHelper.onKeyUp(i, keyEvent);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
            return false;
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        startMiniApp(intent);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void onPackageLoadFailed(PrepareData prepareData, PrepareException prepareException) {
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void onPackageLoadSuccess() {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onPause() {
        super.onPause();
        TmcLogger.d(TAG, "onPause: " + this.appId);
        this.mActivityHelper.onPause();
        long currentTimeMillis = System.currentTimeMillis();
        this.onPauseStopTimeStamp = currentTimeMillis;
        long j = this.miniappResumeTimestamp;
        if (j == 0) {
            this.miniappForegroundTime = (currentTimeMillis - this.miniappStartTime) + this.miniappForegroundTime;
        } else {
            this.miniappForegroundTime = (currentTimeMillis - j) + this.miniappForegroundTime;
        }
    }

    public void onPinForLaterClick(StatusLayout statusLayout) {
        PinForLaterExtensionKt.pinForLater(this);
        final String str = this.appId;
        if (str != null) {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.c0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.onPinForLaterClick$lambda$94$lambda$93(MiniAppActivity.this, str);
                }
            });
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy.Listener
    public void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        App app;
        ActivityHelper activityHelper = this.mActivityHelper;
        TmcLogger.e("onRenderProcessGone", "miniappId=" + ((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId()) + " is Destroy by onRenderProcessGone");
        MiniAppLaunch.INSTANCE.reportMiniAppLauncherFailedTrack(this.appId, "4");
        finishMiniActivity$default(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onResume() {
        super.onResume();
        TmcLogger.d(TAG, "onResume: " + this.appId);
        String str = this.appId;
        if (str != null) {
            ((SessionUtilProxy) TmcProxy.get(SessionUtilProxy.class)).updateSession(str, this.isValidOnResume, false);
            this.isValidOnResume = true;
            TmcLogger.d(TAG, "onResume:checkTaskId:" + str);
            NewTaskManager.Companion companion = NewTaskManager.Companion;
            companion.getInstance().checkTaskId(str, getClass());
            String str2 = this.appId;
            if (str2 == null) {
                str2 = "";
            }
            if (companion.getInstance().checkUseSingleTaskMode(this.appId)) {
                str2 = this.rootTaskId;
            } else {
                str = "";
            }
            companion.getInstance().moveToForeground(str2, str);
            companion.getInstance().addActivityStack(this.appId);
        }
        this.mActivityHelper.onResume();
        try {
            OooO.OooO00o.OooO00o().OooO00o();
        } catch (Throwable th) {
            TmcLogger.e("NormalTaskQueueUtils", "", th);
        }
        PinForLaterExtensionKt.checkPinForLaterStatus(this, this.appId);
        this.miniappResumeTimestamp = System.currentTimeMillis();
        checkAddHomeTipStatus();
        statusLayoutOnResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.h(bundle, "outState");
        TmcLogger.d(TAG, "onSaveInstanceState" + this.appId);
        bundle.putString(TmcConstants.EXTRA_APP_ID, this.appId);
        bundle.putString("mode", this.mode);
        bundle.putString(TmcConstants.EXTRA_APP_INFO_VERSION, this.version);
        bundle.putString(TmcConstants.EXTRA_APP_DEV_TOKEN, this.devToken);
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onStart() {
        ForegroundTime foregroundTime;
        super.onStart();
        TmcLogger.d(TAG, "onStart: " + this.appId);
        ((OfflineAppProxy) TmcProxy.get(OfflineAppProxy.class)).addShortCutListener(this);
        App app = this.mActivityHelper.getApp();
        if (app == null || (foregroundTime = (ForegroundTime) app.getData(ForegroundTime.class)) == null) {
            return;
        }
        foregroundTime.setStartTime();
        foregroundTime.addStartCount();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onStop() {
        Bundle sceneParams;
        Bundle startParams;
        ForegroundTime foregroundTime;
        super.onStop();
        this.mActivityHelper.onStop();
        App app = this.mActivityHelper.getApp();
        if (app != null && (foregroundTime = (ForegroundTime) app.getData(ForegroundTime.class)) != null) {
            try {
                ForegroundRangTime endTime = foregroundTime.setEndTime();
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                String str = this.appId;
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_MINIAPP_FOREGROUND_TIME;
                Bundle bundle = new Bundle();
                bundle.putString(PointConstants.POINT_FOREGROUND_RANDOM_ID, endTime.getForegroundRandomId());
                bundle.putLong(PointConstants.POINT_FOREGROUND_START_TIME, endTime.getStartTime());
                bundle.putLong(PointConstants.POINT_FOREGROUND_END_TIME, endTime.getEndTime());
                bundle.putLong(PointConstants.POINT_FOREGROUND_COST_TIME, endTime.getCostTime());
                bundle.putInt(PointConstants.POINT_FOREGROUND_START_COUNT, endTime.getForegroundStartCount());
                App app2 = this.mActivityHelper.getApp();
                String homePagePath = app2 != null ? app2.getHomePagePath() : null;
                if (homePagePath == null) {
                    homePagePath = "";
                }
                bundle.putString(PointConstants.POINT_PAGE_PATH, homePagePath);
                Unit unit = Unit.a;
                performanceAnalyseProxy.record(str, pointAnalyseType, "", bundle);
            } catch (Throwable th) {
                TmcLogger.e(TAG, "Failed to report foreground time", th);
            }
        }
        App app3 = this.mActivityHelper.getApp();
        if (app3 != null && (startParams = app3.getStartParams()) != null) {
            startParams.remove(TmcConstants.EXTRA_OPEN_MC_SCENE);
        }
        App app4 = this.mActivityHelper.getApp();
        if (app4 != null && (sceneParams = app4.getSceneParams()) != null) {
            sceneParams.remove(TmcConstants.EXTRA_OPEN_MC_SCENE);
        }
        ((OfflineAppProxy) TmcProxy.get(OfflineAppProxy.class)).removeShortCutListener(this);
    }

    public void onUpdateStep(LoadStepAction loadStepAction) {
        Intrinsics.h(loadStepAction, "step");
        updateStepProgress(loadStepAction);
    }

    public final void reSendDelayPageEnterToWorker() {
        IFragmentManager fragmentManager;
        Set fragments;
        if (this.isResendH5PageStack.getAndSet(true)) {
            return;
        }
        App app = this.mActivityHelper.getApp();
        AppContext appContext = app != null ? app.getAppContext() : null;
        TmcAppContext tmcAppContext = appContext instanceof TmcAppContext ? (TmcAppContext) appContext : null;
        if (tmcAppContext == null || (fragmentManager = tmcAppContext.getFragmentManager()) == null || (fragments = fragmentManager.getFragments()) == null) {
            return;
        }
        int i = 0;
        for (Object obj : fragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            TmcFragment tmcFragment = (TmcFragment) obj;
            if (i == fragments.size() - 1) {
                return;
            }
            if (tmcFragment != null) {
                Intrinsics.g(tmcFragment, "tmcFragment");
                if (tmcFragment instanceof MiniH5Fragment) {
                    MiniH5Fragment miniH5Fragment = (MiniH5Fragment) tmcFragment;
                    if (!miniH5Fragment.isSendPageEnter()) {
                        miniH5Fragment.setSendPageEnter(true);
                        MiniAppBaseFragment miniAppBaseFragment = tmcFragment instanceof MiniAppBaseFragment ? (MiniAppBaseFragment) tmcFragment : null;
                        if (miniAppBaseFragment != null) {
                            MiniAppBaseFragment.sendPageEnterToWorker$default(miniAppBaseFragment, null, 1, null);
                        }
                    }
                }
            }
            i = i2;
        }
    }

    public final void refresh() {
        try {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_REFRESH, "");
            getDialog().dismiss();
            refreshApp();
        } catch (Throwable th) {
            TmcLogger.e("refresh fail!!,msg:" + th);
        }
    }

    public final void refreshApp() {
        MiniAppConfigModel miniAppConfigModel;
        List list;
        TmcLogger.d(TAG, "Refresh app...");
        try {
            App app = this.mActivityHelper.getApp();
            AppLoadResult parcelable = BundleUtils.getParcelable(app != null ? app.getSceneParams() : null, TmcConstants.EXTRA_APP_LOAD_RESULT);
            String str = (parcelable == null || (miniAppConfigModel = parcelable.appConfigModel) == null || (list = miniAppConfigModel.pages) == null) ? null : (String) CollectionsKt.k0(list);
            Bundle startParams = app != null ? app.getStartParams() : null;
            Bundle sceneParams = app != null ? app.getSceneParams() : null;
            if (str != null && str.length() != 0 && startParams != null && sceneParams != null) {
                app.putRouteType(str, "reLaunch");
                sceneParams.putString("navigationType", "refreshApp");
                app.relaunchToUrl(str, startParams, sceneParams);
                return;
            }
            TmcLogger.d(TAG, "refreshApp null");
        } catch (Throwable th) {
            TmcLogger.e(TAG, "Refresh fail!", th);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void refreshAppInfo(AppModel appModel) {
        Intrinsics.h(appModel, "appModelNew");
        TmcLogger.d(TAG, "refreshAppInfo: miniappStartTime: " + this.miniappStartTime + " appModelNew: " + appModel);
        if (this.miniappStartTime != 0) {
            dispatchOnCheckForUpdateListener();
        } else {
            getMShowCompleteTaskQueue().OooO00o(new com.cloud.tmc.miniapp.task.OooO00o("onCheckForUpdate", new Runnable() { // from class: com.cloud.tmc.miniapp.ui.q
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity.refreshAppInfo$lambda$34(MiniAppActivity.this);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reload(final boolean z, final Bundle bundle) {
        IFragmentManager fragmentManager;
        Set fragments;
        try {
            this.mActivityHelper.reportFailureClickReloadButton();
            App app = this.mActivityHelper.getApp();
            if (app != null) {
                app.updateHideMiniappLoadingStatus(false);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        App app2 = this.mActivityHelper.getApp();
        AppContext appContext = app2 != null ? app2.getAppContext() : null;
        TmcAppContext tmcAppContext = appContext instanceof TmcAppContext ? (TmcAppContext) appContext : null;
        if (tmcAppContext != null && (fragmentManager = tmcAppContext.getFragmentManager()) != null && (fragments = fragmentManager.getFragments()) != null) {
            Iterator it = fragments.iterator();
            while (it.hasNext()) {
                ((TmcFragment) it.next()).setExitType(TmcFragment.ExitType.REFRESH);
            }
        }
        runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.u
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.reload$lambda$25(MiniAppActivity.this, bundle, z);
            }
        });
    }

    public final void removeBottomDialogMenu(String str) {
        Intrinsics.h(str, "id");
        getDialog().OooO00o(str);
    }

    public final void restoreBottomDialogMenu(String str) {
        Intrinsics.h(str, "id");
        OooOOO0 dialog = getDialog();
        dialog.getClass();
        Intrinsics.h(str, "id");
        for (Map.Entry<Integer, BottomDialog$MenuItem> entry : dialog.OooO.entrySet()) {
            if (Intrinsics.c(entry.getValue().getId(), str)) {
                com.cloud.tmc.miniapp.dialog.OooOOO oooOOO = dialog.OooO0o;
                Integer key = entry.getKey();
                Intrinsics.g(key, "it.key");
                int intValue = key.intValue();
                BottomDialog$MenuItem value = entry.getValue();
                Intrinsics.g(value, "it.value");
                oooOOO.addItem(intValue, value);
                dialog.OooO.remove(entry.getKey());
                return;
            }
        }
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setController(PrepareController prepareController) {
        this.controller = prepareController;
    }

    public final void setCurrentDelayTime(long j) {
        this.currentDelayTime = j;
    }

    public final void setDelayShowError(boolean z) {
        this.delayShowError = z;
    }

    public final void setDevToken(String str) {
        this.devToken = str;
    }

    public final void setEnableQuickMode(boolean z) {
        this.enableQuickMode = z;
    }

    public final void setErrorException(PrepareException prepareException) {
        this.errorException = prepareException;
    }

    public final void setFirstLaunch(boolean z) {
        this.isFirstLaunch = z;
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel loadingAnimationModel) {
        StatusAction.DefaultImpls.setLoadingProgressConfig(this, loadingAnimationModel);
    }

    public final void setMiniappForegroundTime(long j) {
        this.miniappForegroundTime = j;
    }

    public final void setMiniappResumeTimestamp(long j) {
        this.miniappResumeTimestamp = j;
    }

    public final void setMiniappStartTime(long j) {
        this.miniappStartTime = j;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setMsgAppName(String str) {
        Intrinsics.h(str, "<set-?>");
        this.msgAppName = str;
    }

    public final void setOnPauseStopTimeStamp(long j) {
        this.onPauseStopTimeStamp = j;
    }

    public final void setPrepareContext(PrepareContext prepareContext) {
        this.prepareContext = prepareContext;
    }

    public final void setQuickModeController(PrepareController prepareController) {
        this.quickModeController = prepareController;
    }

    public final void setQuickModeStartStatus(boolean z) {
        this.quickModeStartStatus = z;
    }

    public final void setRootTaskId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.rootTaskId = str;
    }

    public final void setSceneId(String str) {
        this.sceneId = str;
    }

    public final void setTempAppLogo(String str) {
        Intrinsics.h(str, "<set-?>");
        this.tempAppLogo = str;
    }

    public final void setTempAppName(String str) {
        Intrinsics.h(str, "<set-?>");
        this.tempAppName = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void showAddHomeTipsDialog(int i) {
        MiniAddHomeTipDialogView addHomeDialogView;
        String str = this.appId;
        if (str == null || (addHomeDialogView = getAddHomeDialogView()) == null) {
            return;
        }
        Intrinsics.h(str, "appId");
        addHomeDialogView.OooOOO0 = i;
        Context context = addHomeDialogView.getContext();
        Intrinsics.g(context, "context");
        addHomeDialogView.OooO00o(context, str, false);
        Context context2 = addHomeDialogView.getContext();
        Intrinsics.g(context2, "context");
        addHomeDialogView.OooO0O0(context2, str);
        addHomeDialogView.startAnimation(AnimationUtils.loadAnimation(addHomeDialogView.getContext(), R.anim.mini_view_toast_enter));
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(str, "quit_pop_ex", new Bundle());
        ViewExtKt.toVisible(addHomeDialogView);
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

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void showLoadingView(final EntryInfo entryInfo) {
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.showLoadingView$lambda$44(entryInfo, this);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showMainLayoutAlpha(float f) {
        StatusAction.DefaultImpls.showMainLayoutAlpha(this, f);
    }

    public final void showMsgBubbleToast() {
        post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.d0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.showMsgBubbleToast$lambda$70(MiniAppActivity.this);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showNoNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showNoNetwork(this, oooO0O0, i, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showPhotoEmpty(int i, int i2, StatusLayout.OooO0O0 oooO0O0) {
        StatusAction.DefaultImpls.showPhotoEmpty(this, i, i2, oooO0O0);
    }

    public final void showPopUpWindowRunnable(long j) {
        Runnable runnable = this.showPopUpWindowRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.cloud.tmc.miniapp.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.showPopUpWindowRunnable$lambda$72(MiniAppActivity.this);
            }
        };
        this.showPopUpWindowRunnable = runnable2;
        postDelayed(runnable2, j);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.z
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.showStatusLoading$lambda$0(MiniAppActivity.this);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void showTaskDescription(String str, String str2) {
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void showUnstableNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
        StatusAction.DefaultImpls.showUnstableNetwork(this, oooO0O0, i, str, str2, oooO00o);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void showUpgradeHintPrompt(String str) {
        showUpgradeHintView(str, getViewThemeMode());
    }

    @Override // com.cloud.tmc.miniapp.action.VersionUpdateAction
    public void showUpgradeHintView(String str, Integer num) {
        VersionUpdateAction.DefaultImpls.showUpgradeHintView(this, str, num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void startApp(final Intent intent) {
        TmcLogger.d(TAG, "startApp");
        runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.startApp$lambda$29(MiniAppActivity.this, intent);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void startAsyncApp(Intent intent) {
        TmcLogger.d(TAG, TmcConstants.NAVIGATION_START_ASYNC_APP);
        try {
            AppNode app = this.mActivityHelper.getApp();
            if (app != null) {
                StartClientBundle parcelable = BundleUtils.getParcelable(intent != null ? intent.getExtras() : null, TmcConstants.EXTRA_START_BUNDLE);
                AppModel parcelable2 = BundleUtils.getParcelable(intent != null ? intent.getExtras() : null, TmcConstants.EXTRA_START_APP_MODEL);
                if (parcelable2 != null) {
                    app.updateAppModel(parcelable2);
                }
                final AppNode appNode = app instanceof AppNode ? app : null;
                if (appNode != null) {
                    TmcLogger.d(TAG, "startAsyncApp success");
                    appNode.setAsyncLaunchStatus(true);
                    appNode.setmStartParams(parcelable.startParams);
                    appNode.setmSceneParams(parcelable.sceneParams);
                    AppLoadResult parcelable3 = BundleUtils.getParcelable(parcelable.sceneParams, TmcConstants.EXTRA_APP_LOAD_RESULT);
                    appNode.setmAppLoadResult(parcelable3);
                    app.setData(AppLoadResult.class, parcelable3);
                    String backToPagePath = appNode.getBackToPagePath();
                    Intrinsics.g(backToPagePath, "appNode.backToPagePath");
                    if (backToPagePath.length() > 0) {
                        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                MiniAppActivity.startAsyncApp$lambda$33$lambda$32$lambda$31(appNode);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, TmcConstants.NAVIGATION_START_ASYNC_APP, th);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        StatusAction.DefaultImpls.statusLayoutCreateShortCutsSuccess(this, str, function3);
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void statusLayoutOnResume() {
        StatusAction.DefaultImpls.statusLayoutOnResume(this);
    }

    public final void swipeBack(TmcFragment tmcFragment) {
        AlertBeforeUnloadCache alertBeforeUnloadCache;
        Intrinsics.h(tmcFragment, "mFragment");
        Page page = tmcFragment.getPage();
        if (page == null || (alertBeforeUnloadCache = (AlertBeforeUnloadCache) page.getData(AlertBeforeUnloadCache.class)) == null) {
            return;
        }
        alertBeforeUnloadCache.setEnabled(false);
        goBack();
    }

    public final void updateBottomDialogMenu(BottomDialog$MenuItem bottomDialog$MenuItem) {
        Intrinsics.h(bottomDialog$MenuItem, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        OooOOO0 dialog = getDialog();
        dialog.getClass();
        Intrinsics.h(bottomDialog$MenuItem, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        Iterator<T> it = dialog.OooO0o.getData().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(((BottomDialog$MenuItem) next).getId(), bottomDialog$MenuItem.getId())) {
                break;
            } else {
                i = i2;
            }
        }
        if (i != -1) {
            BottomDialog$MenuItem item = dialog.OooO0o.getItem(i);
            item.setIcon(bottomDialog$MenuItem.getIcon());
            item.setName(bottomDialog$MenuItem.getName());
            dialog.OooO0o.notifyItemChanged(i);
        }
    }

    @Override // com.cloud.tmc.miniapp.action.StatusAction
    public void updateStepAnimation(LoadStepAction loadStepAction) {
        StatusAction.DefaultImpls.updateStepAnimation(this, loadStepAction);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooOo
    public void updateStepProgress(final LoadStepAction loadStepAction) {
        Intrinsics.h(loadStepAction, "step");
        getHandler().post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.e0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity.updateStepProgress$lambda$26(MiniAppActivity.this, loadStepAction);
            }
        });
    }
}
