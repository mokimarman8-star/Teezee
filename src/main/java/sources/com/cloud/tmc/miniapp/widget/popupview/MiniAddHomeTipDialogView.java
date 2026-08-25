package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.CreateShortCutUtils;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniAddHomeTipDialogView extends FrameLayout {
    public static final /* synthetic */ int OooOOOo = 0;
    public final String OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final String OooO0oO;
    public final String OooO0oo;
    public MiniAppAutoPopover OooOO0;
    public boolean OooOO0O;
    public long OooOO0o;
    public String OooOOO;
    public int OooOOO0;
    public final OooO0OO OooOOOO;

    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R.id.tv_add_home_now_btn);
        }
    }

    public static final class OooO00o extends Lambda implements Function0<ImageView> {
        public OooO00o() {
            super(0);
        }

        public Object invoke() {
            return (ImageView) MiniAddHomeTipDialogView.this.findViewById(R.id.iv_add_home_tip_close);
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            return MiniAddHomeTipDialogView.this.findViewById(R.id.iv_dialog_mini_app_logo);
        }
    }

    public static final class OooO0OO implements PopWindowManager.IPopWindowManagerController {
        public final /* synthetic */ Context OooO00o;
        public final /* synthetic */ MiniAddHomeTipDialogView OooO0O0;

        public OooO0OO(Context context, MiniAddHomeTipDialogView miniAddHomeTipDialogView) {
            this.OooO00o = context;
            this.OooO0O0 = miniAddHomeTipDialogView;
        }

        public void onRefresh(PopWindowManager.PopWindowData popWindowData) {
            Intrinsics.h(popWindowData, "bean");
            Object obj = this.OooO00o;
            MiniAppActivity miniAppActivity = obj instanceof MiniAppActivity ? (MiniAppActivity) obj : null;
            if (miniAppActivity == null) {
                return;
            }
            TmcLogger.d(this.OooO0O0.OooO0oO, "onRefresh:" + (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
            miniAppActivity.showPopUpWindowRunnable(popWindowData.getDelayTime() - (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
        }

        public void show(String str) {
            Long delayDuration;
            Intrinsics.h(str, "appId");
            Object obj = this.OooO00o;
            MiniAppActivity miniAppActivity = obj instanceof MiniAppActivity ? (MiniAppActivity) obj : null;
            if (miniAppActivity == null) {
                return;
            }
            TmcLogger.d(this.OooO0O0.OooO0oO, "showAddHomeTipDialogController");
            CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
            if (createShortCutUtils.getAddHomeStatus(this.OooO00o, str)) {
                return;
            }
            try {
                MiniAppAutoPopover mMiniAppAutoPopover = this.OooO0O0.getMMiniAppAutoPopover();
                long longValue = (mMiniAppAutoPopover == null || (delayDuration = mMiniAppAutoPopover.getDelayDuration()) == null) ? 15000L : delayDuration.longValue();
                long currentTimeMillis = miniAppActivity.getMiniappResumeTimestamp() > miniAppActivity.getOnPauseStopTimeStamp() ? (System.currentTimeMillis() - miniAppActivity.getMiniappResumeTimestamp()) + miniAppActivity.getMiniappForegroundTime() : miniAppActivity.getMiniappForegroundTime();
                TmcLogger.d(this.OooO0O0.OooO0oO, "currentForegroundTime:->" + currentTimeMillis);
                if (!miniAppActivity.getResumed()) {
                    this.OooO0O0.setShowAddHomeDialogStatus(true);
                    this.OooO0O0.setShowAddHomeDialogDelayTime(((System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()) + longValue) - currentTimeMillis);
                    return;
                }
                if (currentTimeMillis <= longValue) {
                    MiniAddHomeTipDialogView miniAddHomeTipDialogView = this.OooO0O0;
                    miniAddHomeTipDialogView.OooO00o(str, miniAddHomeTipDialogView.getMMiniAppAutoPopover(), ((System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()) + longValue) - currentTimeMillis);
                    return;
                }
                AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.INSTANCE;
                ActivityHelper mActivityHelper = miniAppActivity.getMActivityHelper();
                if (addHomeToScreenUtils.checkAddhomeShowStatus(83, mActivityHelper != null ? mActivityHelper.getApp() : null)) {
                    TmcLogger.d(this.OooO0O0.OooO0oO, "not allow show ,return ");
                    return;
                }
                App app = miniAppActivity.getMActivityHelper().getApp();
                if (app != null) {
                    app.getBackPressedProcessor().addInterceptors(new com.cloud.tmc.miniapp.utils.intercept.OooO00o());
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO0O0.OooO0oO, th);
            }
        }
    }

    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R.id.tv_add_home_later_btn);
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R.id.tv_dialog_content_info);
        }
    }

    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        public Object invoke() {
            return (TextView) MiniAddHomeTipDialogView.this.findViewById(R.id.tv_dialog_mini_app_name);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniAddHomeTipDialogView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniAddHomeTipDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooOO0());
        this.OooO0O0 = LazyKt.b(new OooO0O0());
        this.OooO0OO = LazyKt.b(new OooOO0O());
        this.OooO0Oo = LazyKt.b(new OooO());
        this.OooO0o0 = LazyKt.b(new OooO0o());
        this.OooO0o = LazyKt.b(new OooO00o());
        this.OooO0oO = "MiniAddHomeTipDialog";
        this.OooO0oo = "key_latest_show_add_home_dialog_time";
        this.OooO = "key_show_add_home_dialog_num";
        LayoutInflater.from(context).inflate(R.layout.mini_dialog_addhome_tip_layout, this);
        TextView tvAddHomeNowBtn = getTvAddHomeNowBtn();
        if (tvAddHomeNowBtn != null) {
            tvAddHomeNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO00o(MiniAddHomeTipDialogView.this, view);
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAddHomeTipDialogView.OooO0O0(MiniAddHomeTipDialogView.this, view);
            }
        });
        TextView tvAddHomeLaterBtn = getTvAddHomeLaterBtn();
        if (tvAddHomeLaterBtn != null) {
            tvAddHomeLaterBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO0OO(MiniAddHomeTipDialogView.this, view);
                }
            });
        }
        ImageView ivAddHomeTipClose = getIvAddHomeTipClose();
        if (ivAddHomeTipClose != null) {
            ivAddHomeTipClose.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAddHomeTipDialogView.OooO0Oo(MiniAddHomeTipDialogView.this, view);
                }
            });
        }
        this.OooOOOO = new OooO0OO(context, this);
    }

    public /* synthetic */ MiniAddHomeTipDialogView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(MiniAddHomeTipDialogView miniAddHomeTipDialogView, View view) {
        ActivityHelper mActivityHelper;
        App app;
        Intrinsics.h(miniAddHomeTipDialogView, "this$0");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        Object context = miniAddHomeTipDialogView.getContext();
        MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
        if (miniAppActivity != null && (mActivityHelper = miniAppActivity.getMActivityHelper()) != null && (app = mActivityHelper.getApp()) != null) {
            Context context2 = miniAddHomeTipDialogView.getContext();
            Intrinsics.g(context2, "getContext()");
            Class launcherShortCutActivity = ((StartActivityProxy) TmcProxy.get(StartActivityProxy.class)).getLauncherShortCutActivity();
            Intrinsics.g(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
            CreateShortCutUtils.createShortcut$default(context2, launcherShortCutActivity, app, "12", miniAddHomeTipDialogView.OooOOO0, false, false, 96, (Object) null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId = app.getAppId();
            Bundle bundle = new Bundle();
            bundle.putString("location", "12");
            Unit unit = Unit.a;
            performanceAnalyseProxy.recordForCommon(appId, "quit_pop_click", bundle);
        }
        miniAddHomeTipDialogView.OooO00o(true);
    }

    public static final void OooO0O0(MiniAddHomeTipDialogView miniAddHomeTipDialogView, View view) {
        Intrinsics.h(miniAddHomeTipDialogView, "this$0");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        TmcLogger.d(miniAddHomeTipDialogView.OooO0oO, "");
    }

    public static final void OooO0OO(MiniAddHomeTipDialogView miniAddHomeTipDialogView, View view) {
        Intrinsics.h(miniAddHomeTipDialogView, "this$0");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        miniAddHomeTipDialogView.OooO00o(true);
    }

    public static final void OooO0Oo(MiniAddHomeTipDialogView miniAddHomeTipDialogView, View view) {
        Intrinsics.h(miniAddHomeTipDialogView, "this$0");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        miniAddHomeTipDialogView.OooO00o(false);
    }

    private final ImageView getIvAddHomeTipClose() {
        return (ImageView) this.OooO0o.getValue();
    }

    private final ImageView getIvDialogMiniAppLogo() {
        return (ImageView) this.OooO0O0.getValue();
    }

    private final TextView getTvAddHomeLaterBtn() {
        return (TextView) this.OooO0o0.getValue();
    }

    private final TextView getTvAddHomeNowBtn() {
        return (TextView) this.OooO0Oo.getValue();
    }

    private final TextView getTvDialogContentInfo() {
        return (TextView) this.OooO00o.getValue();
    }

    private final TextView getTvDialogMiniAppName() {
        return (TextView) this.OooO0OO.getValue();
    }

    private final void setLogoResource(String str) {
        ImageView ivDialogMiniAppLogo;
        if (str != null) {
            try {
                if (str.length() == 0 || (ivDialogMiniAppLogo = getIvDialogMiniAppLogo()) == null) {
                    return;
                }
                ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImg(getContext(), str, ivDialogMiniAppLogo);
            } catch (Throwable th) {
                TmcLogger.e(this.OooO0oO, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f0 A[Catch: all -> 0x0022, TRY_LEAVE, TryCatch #0 {all -> 0x0022, blocks: (B:2:0x0000, B:5:0x0016, B:7:0x001c, B:8:0x00c0, B:13:0x00f0, B:17:0x0025, B:20:0x0033, B:22:0x0039, B:23:0x003f, B:26:0x004d, B:28:0x0053, B:29:0x0058, B:32:0x006b, B:34:0x0071, B:35:0x0076, B:38:0x0089, B:40:0x008f, B:41:0x0094, B:44:0x00a7, B:46:0x00ad, B:48:0x00b4, B:50:0x00ba), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setTitleInfo(MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        MiniAppMultiLanguageModel en;
        String title;
        MiniAppMultiLanguageModel id;
        MiniAppMultiLanguageModel ru;
        MiniAppMultiLanguageModel ar;
        MiniAppMultiLanguageModel fr;
        MiniAppMultiLanguageModel en2;
        TextView tvDialogContentInfo;
        MiniAppMultiLanguageModel zh;
        try {
            String language = Locale.getDefault().getLanguage();
            if (Intrinsics.c(language, Locale.CHINESE.getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (zh = miniAppMultiLanguageConfig.getZh()) != null) {
                    title = zh.getTitle();
                    String string = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(title, string);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                        return;
                    }
                    tvDialogContentInfo.setText(orDefaultAndCheckEmpty);
                    return;
                }
                title = null;
                String string2 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string2, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty2 = StringExtKt.orDefaultAndCheckEmpty(title, string2);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else if (Intrinsics.c(language, Locale.ENGLISH.getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (en2 = miniAppMultiLanguageConfig.getEn()) != null) {
                    title = en2.getTitle();
                    String string22 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string22, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty22 = StringExtKt.orDefaultAndCheckEmpty(title, string22);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty222 = StringExtKt.orDefaultAndCheckEmpty(title, string222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else if (Intrinsics.c(language, Locale.FRANCE.getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (fr = miniAppMultiLanguageConfig.getFr()) != null) {
                    title = fr.getTitle();
                    String string2222 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string2222, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty2222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string22222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string22222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty22222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else if (Intrinsics.c(language, new Locale("ar").getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (ar = miniAppMultiLanguageConfig.getAr()) != null) {
                    title = ar.getTitle();
                    String string222222 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string222222, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string2222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string2222222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty2222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else if (Intrinsics.c(language, new Locale("ru").getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (ru = miniAppMultiLanguageConfig.getRu()) != null) {
                    title = ru.getTitle();
                    String string22222222 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string22222222, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty22222222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222222);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222222);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string222222222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else if (Intrinsics.c(language, new Locale("in").getLanguage())) {
                if (miniAppMultiLanguageConfig != null && (id = miniAppMultiLanguageConfig.getId()) != null) {
                    title = id.getTitle();
                    String string2222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string2222222222, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty2222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222222);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222222);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string22222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string22222222222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty22222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222222222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            } else {
                if (miniAppMultiLanguageConfig != null && (en = miniAppMultiLanguageConfig.getEn()) != null) {
                    title = en.getTitle();
                    String string222222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                    Intrinsics.g(string222222222222, "getContext().getString(R…ni_add_home_tips_default)");
                    String orDefaultAndCheckEmpty222222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222222222);
                    TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222222222);
                    tvDialogContentInfo = getTvDialogContentInfo();
                    if (tvDialogContentInfo != null) {
                    }
                }
                title = null;
                String string2222222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string2222222222222, "getContext().getString(R…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty2222222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222222222);
                tvDialogContentInfo = getTvDialogContentInfo();
                if (tvDialogContentInfo != null) {
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0oO, th);
        }
    }

    public final int OooO00o(Context context, String str) {
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO + "_" + str);
    }

    public final void OooO00o(Context context, String str, boolean z) {
        if (z) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO + "_" + str, 0);
            return;
        }
        int OooO00o2 = OooO00o(context, str);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO + "_" + str, OooO00o2 + 1);
    }

    public final void OooO00o(String str, MiniAppAutoPopover miniAppAutoPopover, long j) {
        Long delayDuration;
        Intrinsics.h(str, "it");
        Object context = getContext();
        MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
        if (miniAppActivity == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.g(context2, "context");
        if (OooO00o(context2, str, miniAppAutoPopover)) {
            TmcLogger.d(this.OooO0oO, "showAddHomeDialog");
            App app = miniAppActivity.getMActivityHelper().getApp();
            AppModel appModel = app != null ? app.getAppModel() : null;
            if (miniAppAutoPopover != null) {
                this.OooOO0 = miniAppAutoPopover;
                setTitleInfo(miniAppAutoPopover.getConfigs());
            }
            if (appModel != null) {
                this.OooOOO = appModel.getAppId();
                setLogoResource(appModel.getLogo());
                TextView tvDialogMiniAppName = getTvDialogMiniAppName();
                if (tvDialogMiniAppName != null) {
                    tvDialogMiniAppName.setText(appModel.getName());
                }
            }
            PopWindowManager popWindowManager = PopWindowManager.INSTANCE;
            String miniAppPopWindowToken = miniAppActivity.getMiniAppPopWindowToken();
            if (j == 0) {
                j = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? 45000L : delayDuration.longValue();
            }
            popWindowManager.addPopWindow(miniAppPopWindowToken, new PopWindowManager.PopWindowData(str, j, 1, this.OooOOOO, true));
        }
    }

    public final void OooO00o(boolean z) {
        MiniAppActivity miniAppActivity;
        try {
            if (!ViewExtKt.getVisible(this)) {
                TmcLogger.d(this.OooO0oO, "hideDialog: not visible");
                return;
            }
            if (z) {
                int i = this.OooOOO0;
                if (i == 2) {
                    Object context = getContext();
                    miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                    if (miniAppActivity != null) {
                        miniAppActivity.finishMiniActivity(TmcFragment.ExitType.CLOSE_APP, false);
                    }
                } else if (i == 1) {
                    Object context2 = getContext();
                    miniAppActivity = context2 instanceof MiniAppActivity ? (MiniAppActivity) context2 : null;
                    if (miniAppActivity != null) {
                        miniAppActivity.goBack();
                    }
                }
            }
            this.OooOOO0 = 0;
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mini_view_toast_exit));
            ViewExtKt.toGone(this);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0oO, th);
        }
    }

    public final boolean OooO00o(Context context, String str, MiniAppAutoPopover miniAppAutoPopover) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        if (miniAppAutoPopover != null) {
            try {
                if (!Intrinsics.c(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    if (!MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_ADD_HOME_CUSTOM_BACK_TIP, true)) {
                        TmcLogger.d(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow: backDialogEnable is false");
                        return false;
                    }
                    if (AppUtils.INSTANCE.queryShortcutExist(context, str)) {
                        TmcLogger.d(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow addhomeStatus is true");
                        return false;
                    }
                    long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0oo + "_" + str);
                    long intValue = (miniAppAutoPopover.getPerXDay() != null ? r4.intValue() : 1) * 86400 * 1000;
                    int OooO00o2 = OooO00o(context, str);
                    if (System.currentTimeMillis() - j > intValue) {
                        OooO00o(context, str, true);
                    } else {
                        Integer displayFrequency = miniAppAutoPopover.getDisplayFrequency();
                        if (OooO00o2 >= (displayFrequency != null ? displayFrequency.intValue() : 1)) {
                            String str2 = this.OooO0oO;
                            Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                            TmcLogger.d(str2, "checkAddHomeDialogTipIsNeedShow showNum is " + OooO00o2 + " >=" + (displayFrequency2 != null ? displayFrequency2.intValue() : 1));
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th) {
                TmcLogger.e(this.OooO0oO, "checkAddHomeTopTipIsNeedShow error", th);
                return true;
            }
        }
        TmcLogger.d(this.OooO0oO, "checkAddHomeDialogTipIsNeedShow: bean is null or status is false");
        return false;
    }

    public final void OooO0O0(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0oo + "_" + str, System.currentTimeMillis());
    }

    public final String getAppId() {
        return this.OooOOO;
    }

    public final int getBackFromType() {
        return this.OooOOO0;
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.OooOO0;
    }

    public final long getShowAddHomeDialogDelayTime() {
        return this.OooOO0o;
    }

    public final boolean getShowAddHomeDialogStatus() {
        return this.OooOO0O;
    }

    public final void setAppId(String str) {
        this.OooOOO = str;
    }

    public final void setBackFromType(int i) {
        this.OooOOO0 = i;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.OooOO0 = miniAppAutoPopover;
    }

    public final void setShowAddHomeDialogDelayTime(long j) {
        this.OooOO0o = j;
    }

    public final void setShowAddHomeDialogStatus(boolean z) {
        this.OooOO0O = z;
    }
}
