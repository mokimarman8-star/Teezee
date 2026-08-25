package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.ext.TextViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.FwDevDownloadUtils;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.NativeTitleBar;
import com.cloud.tmc.miniapp.widget.SettingBar;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.cloud.tmc.miniutils.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class AppBrandProfileActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "AppBrandProfileActivity";
    private AppModel appModel;
    private long appReleaseTime;
    private final Lazy mLayoutTitle$delegate = LazyKt.b(new Function0<NativeTitleBar>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$mLayoutTitle$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NativeTitleBar m32invoke() {
            return (NativeTitleBar) AppBrandProfileActivity.this.findViewById(R.id.layout_title);
        }
    });
    private final Lazy ivLogo$delegate = LazyKt.b(new Function0<AppCompatImageView>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$ivLogo$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AppCompatImageView m31invoke() {
            return AppBrandProfileActivity.this.findViewById(R.id.iv_logo);
        }
    });
    private final Lazy tvName$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$tvName$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m38invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R.id.tv_name);
        }
    });
    private final Lazy tvDesc$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$tvDesc$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m37invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R.id.tv_desc);
        }
    });
    private final Lazy sbDeveloperName$delegate = LazyKt.b(new Function0<SettingBar>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$sbDeveloperName$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SettingBar m34invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R.id.sb_developer_name);
        }
    });
    private final Lazy sbVersion$delegate = LazyKt.b(new Function0<SettingBar>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$sbVersion$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SettingBar m36invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R.id.sb_version);
        }
    });
    private final Lazy sbUpdate$delegate = LazyKt.b(new Function0<SettingBar>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$sbUpdate$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SettingBar m35invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R.id.sb_update);
        }
    });
    private final Lazy sbAccountType$delegate = LazyKt.b(new Function0<SettingBar>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$sbAccountType$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SettingBar m33invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R.id.sb_account_type);
        }
    });
    private final Lazy tvPrivacyPolicy$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$tvPrivacyPolicy$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m39invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R.id.tv_privacy_policy);
        }
    });
    private final Lazy tvUserAgreement$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$tvUserAgreement$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m40invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R.id.tv_user_agreement);
        }
    });
    private String appVersion = "";
    private String appName = "";
    private String appLogoUrl = "";
    private String appDesc = "";
    private String appRegisterType = "";
    private String appDeveloper = "";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, String str, Bundle bundle, int i, Object obj) {
            if ((i & 4) != 0) {
                bundle = null;
            }
            companion.launch(context, str, bundle);
        }

        @JvmStatic
        public final void launch(Context context, String str, Bundle bundle) {
            Intrinsics.h(context, "context");
            Intrinsics.h(str, "appId");
            Intent intent = new Intent(context, (Class<?>) AppBrandProfileActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("appId", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, context);
            context.startActivity(intent);
        }
    }

    private final AppCompatImageView getIvLogo() {
        return (AppCompatImageView) this.ivLogo$delegate.getValue();
    }

    private final NativeTitleBar getMLayoutTitle() {
        return (NativeTitleBar) this.mLayoutTitle$delegate.getValue();
    }

    private final SettingBar getSbAccountType() {
        return (SettingBar) this.sbAccountType$delegate.getValue();
    }

    private final SettingBar getSbDeveloperName() {
        return (SettingBar) this.sbDeveloperName$delegate.getValue();
    }

    private final SettingBar getSbUpdate() {
        return (SettingBar) this.sbUpdate$delegate.getValue();
    }

    private final SettingBar getSbVersion() {
        return (SettingBar) this.sbVersion$delegate.getValue();
    }

    private final TextView getTvDesc() {
        return (TextView) this.tvDesc$delegate.getValue();
    }

    private final TextView getTvName() {
        return (TextView) this.tvName$delegate.getValue();
    }

    private final TextView getTvPrivacyPolicy() {
        return (TextView) this.tvPrivacyPolicy$delegate.getValue();
    }

    private final TextView getTvUserAgreement() {
        return (TextView) this.tvUserAgreement$delegate.getValue();
    }

    @JvmStatic
    public static final void launch(Context context, String str, Bundle bundle) {
        Companion.launch(context, str, bundle);
    }

    private final String toDate(long j) {
        SimpleDateFormat simpleDateFormat;
        if (j == 0) {
            return "";
        }
        try {
            String language = Locale.getDefault().getLanguage();
            Locale locale = Locale.FRANCE;
            if (Intrinsics.c(language, locale.getLanguage())) {
                simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", locale);
            } else {
                Locale locale2 = Locale.CHINA;
                simpleDateFormat = Intrinsics.c(language, locale2.getLanguage()) ? new SimpleDateFormat("yyyy.MM.dd", locale2) : Intrinsics.c(language, new Locale("ar").getLanguage()) ? new SimpleDateFormat("dd MMM, yyyy", new Locale("ar")) : new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault());
            }
            String millis2String = TimeUtils.millis2String(j, simpleDateFormat);
            Intrinsics.g(millis2String, "millis2String(releaseTime, formatter)");
            return millis2String;
        } catch (Throwable th) {
            TmcLogger.e(TmcConstants.TAG, "appModel is null", th);
            return "";
        }
    }

    public final String getAppDesc() {
        return this.appDesc;
    }

    public final String getAppDeveloper() {
        return this.appDeveloper;
    }

    public final String getAppLogoUrl() {
        return this.appLogoUrl;
    }

    public final AppModel getAppModel() {
        return this.appModel;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppRegisterType() {
        return this.appRegisterType;
    }

    public final long getAppReleaseTime() {
        return this.appReleaseTime;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R.layout.activity_app_brand_profile;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        TextView tvDesc;
        try {
            TmcLogger.d(TAG, "initData");
            String string = getString(TmcConstants.EXTRA_APP_NAME);
            if (string == null || string.length() <= 0) {
                String string2 = getString("appId");
                AppModel appModelFromUsed = string2 != null ? ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModelFromUsed(getContext(), string2) : null;
                this.appModel = appModelFromUsed;
                if (appModelFromUsed == null) {
                    try {
                        TmcLogger.d(TAG, "appModel is null");
                        String string3 = getString("appId");
                        TmcLogger.d(TAG, "appId is " + string3);
                        if (string3 != null && string3.length() != 0) {
                            String string4 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(this, String.valueOf(string3), TmcConstants.INSTANCE.getKEY_MINIAPP_INFO_ADD_HOME());
                            TmcLogger.d(TAG, "addHomeInfo -> " + string4);
                            this.appModel = (AppModel) JsonUtil.INSTANCE.fromJson(string4, AppModel.class);
                        }
                        finish();
                        return;
                    } catch (Throwable th) {
                        TmcLogger.e(TAG, "appModel is null", th);
                    }
                }
                AppModel appModel = this.appModel;
                if (appModel != null) {
                    String name = appModel.getName();
                    if (name == null) {
                        name = "";
                    }
                    this.appName = name;
                    String miniAppVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(this.appModel);
                    if (miniAppVersion == null) {
                        miniAppVersion = "";
                    }
                    this.appVersion = miniAppVersion;
                    String desc = appModel.getDesc();
                    if (desc == null) {
                        desc = "";
                    }
                    this.appDesc = desc;
                    String logo = appModel.getLogo();
                    if (logo == null) {
                        logo = "";
                    }
                    this.appLogoUrl = logo;
                    String registerType = appModel.getRegisterType();
                    if (registerType == null) {
                        registerType = "";
                    }
                    this.appRegisterType = registerType;
                    String developer = appModel.getDeveloper();
                    if (developer == null) {
                        developer = "";
                    }
                    this.appDeveloper = developer;
                    this.appReleaseTime = appModel.getReleaseTime();
                }
            } else {
                this.appName = string;
                String string5 = getString(TmcConstants.EXTRA_APP_INFO_VERSION);
                if (string5 == null) {
                    string5 = "";
                }
                this.appVersion = string5;
                String string6 = getString(TmcConstants.EXTRA_APP_INFO_DESC);
                if (string6 == null) {
                    string6 = "";
                }
                this.appDesc = string6;
                String string7 = getString(TmcConstants.EXTRA_APP_INFO_LOGO_URL);
                if (string7 == null) {
                    string7 = "";
                }
                this.appLogoUrl = string7;
                String string8 = getString(TmcConstants.EXTRA_APP_INFO_REGISTER_TYPE);
                if (string8 == null) {
                    string8 = "";
                }
                this.appRegisterType = string8;
                String string9 = getString(TmcConstants.EXTRA_APP_INFO_DEVELOPER);
                if (string9 == null) {
                    string9 = "";
                }
                this.appDeveloper = string9;
                this.appReleaseTime = getLong(TmcConstants.EXTRA_APP_INFO_RLEASE_TIME);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        try {
            ImageView ivLogo = getIvLogo();
            if (ivLogo != null) {
                ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
                String str = this.appLogoUrl;
                int dp2px = SizeUtils.dp2px(12.0f);
                int i = R.drawable.drawable_app_icon_place_holder;
                imageLoaderProxy.loadImgRoundCorners(this, str, ivLogo, dp2px, i, i);
            }
            TextView tvName = getTvName();
            if (tvName != null) {
                tvName.setText(this.appName);
            }
            if (this.appDesc.length() > 0 && (tvDesc = getTvDesc()) != null) {
                TextViewExtKt.setMultilingualText(tvDesc, this.appDesc);
            }
            String str2 = this.appRegisterType;
            if (Intrinsics.c(str2, "1")) {
                SettingBar sbDeveloperName = getSbDeveloperName();
                if (sbDeveloperName != null) {
                    sbDeveloperName.setVisibility(8);
                }
                SettingBar sbAccountType = getSbAccountType();
                if (sbAccountType != null) {
                    sbAccountType.OooO0OO.setText(getString(R.string.mini_brand_individual));
                }
            } else if (Intrinsics.c(str2, "2")) {
                SettingBar sbDeveloperName2 = getSbDeveloperName();
                if (sbDeveloperName2 != null) {
                    sbDeveloperName2.setVisibility(0);
                }
                SettingBar sbDeveloperName3 = getSbDeveloperName();
                if (sbDeveloperName3 != null) {
                    sbDeveloperName3.OooO0OO.setText(this.appDeveloper);
                }
                SettingBar sbAccountType2 = getSbAccountType();
                if (sbAccountType2 != null) {
                    sbAccountType2.OooO0OO.setText(getString(R.string.mini_brand_business));
                }
            } else {
                SettingBar sbAccountType3 = getSbAccountType();
                if (sbAccountType3 != null) {
                    sbAccountType3.setVisibility(8);
                }
            }
            SettingBar sbVersion = getSbVersion();
            if (sbVersion != null) {
                sbVersion.OooO0OO.setText(this.appVersion);
            }
            if (this.appReleaseTime == 0) {
                SettingBar sbUpdate = getSbUpdate();
                if (sbUpdate == null) {
                    return;
                }
                sbUpdate.setVisibility(8);
                return;
            }
            SettingBar sbUpdate2 = getSbUpdate();
            if (sbUpdate2 != null) {
                sbUpdate2.setVisibility(0);
            }
            SettingBar sbUpdate3 = getSbUpdate();
            if (sbUpdate3 != null) {
                sbUpdate3.OooO0OO.setText(toDate(this.appReleaseTime));
            }
        } catch (Throwable unused) {
            TmcLogger.e(TAG, "");
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        NativeTitleBar mLayoutTitle = getMLayoutTitle();
        if (mLayoutTitle != null) {
            mLayoutTitle.setonBackClickListener(new Function0<Unit>() { // from class: com.cloud.tmc.miniapp.ui.AppBrandProfileActivity$initView$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m30invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m30invoke() {
                    AppBrandProfileActivity.this.finish();
                }
            });
        }
        NativeTitleBar mLayoutTitle2 = getMLayoutTitle();
        if (mLayoutTitle2 != null) {
            mLayoutTitle2.setTitleLineHeight(1);
        }
        setOnClickListener(getTvPrivacyPolicy(), getTvUserAgreement(), getIvLogo());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.h(view, "view");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        if (Intrinsics.c(view, getTvPrivacyPolicy())) {
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this, UrlKt.appendCommonParamUrl("https://h5.dlight-app.com/outside/privacy-policy?lang=", this), null, null, 12, null);
        } else if (Intrinsics.c(view, getTvUserAgreement())) {
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this, UrlKt.appendCommonParamUrl("https://h5.dlight-app.com/outside/user-agreement?lang=", this), null, null, 12, null);
        } else if (Intrinsics.c(view, getIvLogo())) {
            FwDevDownloadUtils.INSTANCE.init(this);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TmcLogger.d(TAG, "onCreate");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.d(TAG, "onDestroy");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        TmcLogger.d(TAG, "onNewIntent");
        initData();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onStart() {
        super.onStart();
        TmcLogger.d(TAG, TmcConstants.NAVIGATION_ON_START);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onStop() {
        super.onStop();
        TmcLogger.d(TAG, "onStop");
    }

    public final void setAppDesc(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appDesc = str;
    }

    public final void setAppDeveloper(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appDeveloper = str;
    }

    public final void setAppLogoUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appLogoUrl = str;
    }

    public final void setAppModel(AppModel appModel) {
        this.appModel = appModel;
    }

    public final void setAppName(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppRegisterType(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appRegisterType = str;
    }

    public final void setAppReleaseTime(long j) {
        this.appReleaseTime = j;
    }

    public final void setAppVersion(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appVersion = str;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }
}
